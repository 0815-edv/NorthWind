package de.edv.model.db;

import de.edv.model.exception.NorthwindException;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Oliver S.
 * @version 1.0
 */
public class DBConnectorMySQL extends DBConnector {

    public DBConnectorMySQL(String db, String user, String pw, int port, String host) {
        super(db, user, pw, port, host);
    }

    @Override
    /**
     * Versucht eine Verbindung zum Datenbank-Server aufzubauen.
     *
     * @return true, wenn die Verbindung aufgebaut werden konnte, sonst false
     */
    public void connect() throws NorthwindException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + db, user, pw);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new NorthwindException("Datenbank", "Verbindung konnte nicht geöffnet werden.");
        }
    }
}
