package de.edv.gui;

import de.edv.SuppliersAdapter;
import de.edv.model.data.Supplier;
import de.edv.model.db.DBConnector;
import de.edv.model.db.DBConnectorMySQL;
import de.edv.model.db.SuppliersAdapterDB;
import de.edv.model.exception.NorthwindException;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Oliver S.
 * @version 1.0
 */
public class SupplierGUI extends javax.swing.JFrame implements PropertyChangeListener {

    public SupplierGUI() {
        initComponents();
        loadData();
    }

    private void loadData() {
        try {
            SuppliersAdapterDB fa = new SuppliersAdapterDB();
            DBConnector db = new DBConnectorMySQL("northwind", "kino", "kino", 3306, "localhost");
            db.connect();
            fa.supplierListeDB(db);
            SuppliersAdapter f = fa;
            lstOverview.setListData(fa.get().toArray());
        } catch (NorthwindException ex) {
            Logger.getLogger(SupplierGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void emptyTextBox(){
        txfCompanyName.setText("");
        txfAddress.setText("");
        txfCity.setText("");
        txfContactTitle.setText("");
        txfCountry.setText("");
        txfFax.setText("");
        txfHomePage.setText("");
        txfPhone.setText("");
        txfPostalCode.setText("");
        txfRegion.setText("");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlOverview = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstOverview = new javax.swing.JList();
        pnlDetails = new javax.swing.JPanel();
        pnlFilminfo = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txfCompanyName = new javax.swing.JTextField();
        txfContactName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txfContactTitle = new javax.swing.JTextField();
        txfCity = new javax.swing.JTextField();
        txfAddress = new javax.swing.JTextField();
        txfHomePage = new javax.swing.JTextField();
        txfCountry = new javax.swing.JTextField();
        txfRegion = new javax.swing.JTextField();
        txfPostalCode = new javax.swing.JTextField();
        txfPhone = new javax.swing.JTextField();
        txfFax = new javax.swing.JTextField();
        pnlControl = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setTitle("Supplierdetails");
        getContentPane().setLayout(new java.awt.GridLayout(1, 2));

        pnlOverview.setBorder(javax.swing.BorderFactory.createTitledBorder("??bersicht"));

        lstOverview.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Supplier" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstOverview.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstOverview.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstOverviewValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstOverview);

        javax.swing.GroupLayout pnlOverviewLayout = new javax.swing.GroupLayout(pnlOverview);
        pnlOverview.setLayout(pnlOverviewLayout);
        pnlOverviewLayout.setHorizontalGroup(
            pnlOverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOverviewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlOverviewLayout.setVerticalGroup(
            pnlOverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOverviewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(pnlOverview);

        pnlDetails.setLayout(new java.awt.BorderLayout());

        pnlFilminfo.setBorder(javax.swing.BorderFactory.createTitledBorder("Details"));

        jLabel5.setText("CompanyName");

        jLabel7.setText("ContactName");

        jLabel8.setText("ContactTitle");

        jLabel9.setText("Address");

        jLabel10.setText("City");

        jLabel11.setText("Region");

        jLabel12.setText("PostalCode");

        jLabel13.setText("Country");

        jLabel14.setText("Phone");

        jLabel15.setText("Fax");

        jLabel16.setText("HomePage");

        javax.swing.GroupLayout pnlFilminfoLayout = new javax.swing.GroupLayout(pnlFilminfo);
        pnlFilminfo.setLayout(pnlFilminfoLayout);
        pnlFilminfoLayout.setHorizontalGroup(
            pnlFilminfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFilminfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFilminfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFilminfoLayout.createSequentialGroup()
                        .addGroup(pnlFilminfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))
                        .addGap(32, 32, 32)
                        .addGroup(pnlFilminfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfCompanyName)
                            .addComponent(txfContactName, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlFilminfoLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txfContactTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFilminfoLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txfAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFilminfoLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txfCity, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFilminfoLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txfRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFilminfoLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txfCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFilminfoLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txfPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFilminfoLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txfPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFilminfoLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txfFax, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFilminfoLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txfHomePage, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlFilminfoLayout.setVerticalGroup(
            pnlFilminfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFilminfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFilminfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlFilminfoLayout.createSequentialGroup()
                        .addGroup(pnlFilminfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlFilminfoLayout.createSequentialGroup()
                                .addGroup(pnlFilminfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txfCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlFilminfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txfContactName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlFilminfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txfContactTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(pnlFilminfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(txfAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10))
                            .addComponent(txfCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlFilminfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(8, 8, 8)
                        .addGroup(pnlFilminfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(txfPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFilminfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(34, 34, 34))
                    .addGroup(pnlFilminfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(txfPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addGroup(pnlFilminfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txfFax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFilminfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(txfHomePage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pnlDetails.add(pnlFilminfo, java.awt.BorderLayout.CENTER);

        pnlControl.setBorder(javax.swing.BorderFactory.createTitledBorder("??nderungen"));
        pnlControl.setLayout(new java.awt.GridLayout(1, 3, 5, 0));

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Update.gif"))); // NOI18N
        btnUpdate.setText("speichern");
        pnlControl.add(btnUpdate);

        btnInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Insert.gif"))); // NOI18N
        btnInsert.setText("anlegen");
        pnlControl.add(btnInsert);

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Delete.gif"))); // NOI18N
        btnDelete.setText("l??schen");
        pnlControl.add(btnDelete);

        pnlDetails.add(pnlControl, java.awt.BorderLayout.SOUTH);

        getContentPane().add(pnlDetails);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lstOverviewValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstOverviewValueChanged
        // TODO add your handling code here:
        emptyTextBox();
        if(lstOverview.getSelectedValue() != null){
            Supplier s = (Supplier) lstOverview.getSelectedValue();
            txfCompanyName.setText(s.getCompanyName());
            txfContactName.setText(s.getContactName());
            txfContactTitle.setText(s.getContactTitle());
            txfAddress.setText(s.getAddress());
            txfCity.setText(s.getCity());
            txfCountry.setText(s.getCountry());
            txfFax.setText(s.getFax());
            txfHomePage.setText(s.getHomePage());
            txfPhone.setText(s.getPhone());
            txfPostalCode.setText(s.getPostalCode());
            txfRegion.setText(s.getRegion()); 
        }
            
    }//GEN-LAST:event_lstOverviewValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lstOverview;
    private javax.swing.JPanel pnlControl;
    private javax.swing.JPanel pnlDetails;
    private javax.swing.JPanel pnlFilminfo;
    private javax.swing.JPanel pnlOverview;
    private javax.swing.JTextField txfAddress;
    private javax.swing.JTextField txfCity;
    private javax.swing.JTextField txfCompanyName;
    private javax.swing.JTextField txfContactName;
    private javax.swing.JTextField txfContactTitle;
    private javax.swing.JTextField txfCountry;
    private javax.swing.JTextField txfFax;
    private javax.swing.JTextField txfHomePage;
    private javax.swing.JTextField txfPhone;
    private javax.swing.JTextField txfPostalCode;
    private javax.swing.JTextField txfRegion;
    // End of variables declaration//GEN-END:variables

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
