package de.edv.gui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author Oliver S.
 * @version 1.0
 */
public class ActorGUI extends javax.swing.JFrame implements PropertyChangeListener {

    public ActorGUI() {
        initComponents();
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
        txfName = new javax.swing.JTextField();
        txfVorname = new javax.swing.JTextField();
        pnlControl = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setTitle("Filmdetails");
        getContentPane().setLayout(new java.awt.GridLayout(1, 2));

        pnlOverview.setBorder(javax.swing.BorderFactory.createTitledBorder("Übersicht"));

        lstOverview.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(lstOverview);

        javax.swing.GroupLayout pnlOverviewLayout = new javax.swing.GroupLayout(pnlOverview);
        pnlOverview.setLayout(pnlOverviewLayout);
        pnlOverviewLayout.setHorizontalGroup(
            pnlOverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOverviewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlOverviewLayout.setVerticalGroup(
            pnlOverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOverviewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(pnlOverview);

        pnlDetails.setLayout(new java.awt.BorderLayout());

        pnlFilminfo.setBorder(javax.swing.BorderFactory.createTitledBorder("Details"));

        jLabel5.setText("Name");

        jLabel7.setText("Vorname");

        javax.swing.GroupLayout pnlFilminfoLayout = new javax.swing.GroupLayout(pnlFilminfo);
        pnlFilminfo.setLayout(pnlFilminfoLayout);
        pnlFilminfoLayout.setHorizontalGroup(
            pnlFilminfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFilminfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFilminfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5))
                .addGap(32, 32, 32)
                .addGroup(pnlFilminfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txfName)
                    .addComponent(txfVorname, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnlFilminfoLayout.setVerticalGroup(
            pnlFilminfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFilminfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFilminfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFilminfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txfVorname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(170, Short.MAX_VALUE))
        );

        pnlDetails.add(pnlFilminfo, java.awt.BorderLayout.CENTER);

        pnlControl.setBorder(javax.swing.BorderFactory.createTitledBorder("Änderungen"));
        pnlControl.setLayout(new java.awt.GridLayout(1, 3, 5, 0));

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Update.gif"))); // NOI18N
        btnUpdate.setText("speichern");
        pnlControl.add(btnUpdate);

        btnInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Insert.gif"))); // NOI18N
        btnInsert.setText("anlegen");
        pnlControl.add(btnInsert);

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Delete.gif"))); // NOI18N
        btnDelete.setText("löschen");
        pnlControl.add(btnDelete);

        pnlDetails.add(pnlControl, java.awt.BorderLayout.SOUTH);

        getContentPane().add(pnlDetails);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lstOverview;
    private javax.swing.JPanel pnlControl;
    private javax.swing.JPanel pnlDetails;
    private javax.swing.JPanel pnlFilminfo;
    private javax.swing.JPanel pnlOverview;
    private javax.swing.JTextField txfName;
    private javax.swing.JTextField txfVorname;
    // End of variables declaration//GEN-END:variables

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}