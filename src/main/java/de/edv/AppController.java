package de.edv;

import de.edv.gui.FilmGUI;
import de.edv.model.db.DBConnector;
import de.edv.model.db.DBConnectorMySQL;

/**
 *
 * @author Oliver S.
 * @version 1.0
 */
public class AppController {

    // DB Connector
    private DBConnector dBConnector;

    // Adapter
    // GUIs
    private FilmGUI filmGUI;

    public AppController() {
        init();
    }

    private void init() {
        // DBConnector
        dBConnector = new DBConnectorMySQL("kinowelt", "root", "", 3306, "localhost");

        // Adapter
        // GUIs
        filmGUI = new FilmGUI();
        filmGUI.setVisible(true);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AppController();
            }
        });
    }
}
