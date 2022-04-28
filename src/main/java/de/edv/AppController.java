package de.edv;

import de.edv.gui.SupplierGUI;
import de.edv.gui.ProductGUI;
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
    private ProductGUI filmGUI;
    private SupplierGUI actorGUI;

    public AppController() {
        init();
    }

    private void init() {
        // DBConnector
        dBConnector = new DBConnectorMySQL("kinowelt", "root", "", 3306, "localhost");

        // Adapter
        // GUIs
        filmGUI = new ProductGUI();
        filmGUI.setVisible(true);
        
        actorGUI = new SupplierGUI();
        actorGUI.setVisible(true);
        
        
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
