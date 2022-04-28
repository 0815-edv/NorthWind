package de.edv.model.db;

import de.edv.model.exception.NorthwindException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Regelt die Kommunikation mit dem Datenbank-Server.
 *
 * @author Oliver S.
 * @author Markus
 * @version 1.5
 */
public abstract class DBConnector {

    protected Connection connection;
    private Statement stat;
    private ResultSet rs;
    private Savepoint save;
    protected final String db;
    protected final String user;
    protected final String pw;
    protected final int port;
    protected final String host;

    /**
     * Nimmt die Daten für einen Verbindungsaufbau zur Datenbank entgegen und
     * speichert diese in den entsprechenden Attributen.
     *
     * @param db Datenbankname
     * @param user Benutzername
     * @param pw Passwort
     * @param port Portnummer
     * @param host IP-Adresse oder Hostname
     */
    public DBConnector(String db, String user, String pw, int port, String host) {
        this.db = db;
        this.user = user;
        this.pw = pw;
        this.port = port;
        this.host = host;
    }

    /**
     * Versucht eine Verbindung zum Datenbank-Server aufzubauen.
     *
     */
    public abstract void connect() throws NorthwindException;

    /**
     * Baut die Verbindung zum Datenbank-Server ab und schließt dabei auch das
     * Statement.
     *
     */
    public void disconnect() throws NorthwindException {
        try {
            closeStatement();
            connection.close();                      // Verbindung schließen
        } catch (SQLException ex) {
            throw new NorthwindException("Datenbank", "Verbindung konnte nicht geschlossen werden.");
        }
    }

    /**
     * Create Savepoint
     * @throws SQLException 
     */
    public void createSavepoint() throws SQLException{
        save = connection.setSavepoint();
    }
    
    /**
     * Restore to Savepoint
     * @throws SQLException 
     */
    public void restoreSavepoint() throws SQLException{
        if(save != null)
            connection.rollback(save);
    }
    
    /**
     * Commit Changes to Database
     * @throws SQLException 
     */
    public void commitChanges() throws SQLException{
        connection.commit();
    }
    
    /**
     * Schickt eine SQL-Abfrage zum datenbank-Server und liefert das
     * entsprechende Resultset zurück.
     *
     * @param sqlString String mit der SQL-Abfrage
     * @return Resultset der Abfrage
     */
    public ResultSet query(String sqlString) throws NorthwindException {
        Savepoint s = null;
        try {
            s = connection.setSavepoint();          // Create Savepoint
            stat = connection.createStatement();    // Statement erzeugen
            connection.setAutoCommit(false);        // Disable Autocommit
            stat.executeQuery(sqlString);           // Statement ausführen
            rs = stat.getResultSet();               // Resultset holen
        } catch (SQLException ex) {
            try {
                connection.rollback(s);              // Rollback Changes
            } catch (SQLException ex1) {
                Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex1);
            }
            throw new NorthwindException("Datenbank", ex.getMessage());
        }
        return rs;
    }

    /**
     * Schickt eine DML-SQL-Abfrage (insert, update, delete) zum
     * Datenbank-Server.
     *
     * @param sqlString String mit der DML-SQL-Abfrage (insert, update, delete)
     */
    public void queryDML(String sqlString) throws NorthwindException {
        Savepoint s = null;
        try {
            s = connection.setSavepoint();          // Create Savepoint
            stat = connection.createStatement();     // Statement erzeugen
            connection.setAutoCommit(false);         // Disable Autocommit
            stat.executeUpdate(sqlString);           // Statement ausführen
        } catch (SQLException ex) {
            try {
                connection.rollback(s);               // Rollback Changes
            } catch (SQLException ex1) {
                Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex1);
            }
            throw new NorthwindException("Datenbank", ex.getMessage());
        }
    }

    /**
     * Schließt das Resultset und das Statement.
     *
     */
    public void closeStatement() throws NorthwindException {
        try {
            connection.commit();
            rs.close();                       // Resultset schließen
            stat.close();                     // Statement schließen
        } catch (SQLException ex) {
            throw new NorthwindException("Datenbank", "Staement konnte nicht geschlossen werden.");
        }
    }
}
