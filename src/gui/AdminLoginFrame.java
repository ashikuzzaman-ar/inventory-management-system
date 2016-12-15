/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import model.Admin;
import service.Database;

/**
 *
 * @author ashik
 */
public class AdminLoginFrame extends javax.swing.JFrame {

    private AdminSignupFrame asf;
    private final Database database;

    /**
     * Creates new form AdminLoginFrame
     *
     * @param database
     */
    public AdminLoginFrame(Database database) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminLoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        this.initComponents();
        this.database = database;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pMain = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lMessage = new javax.swing.JLabel();
        tfPassword = new javax.swing.JPasswordField();
        bAdminSignup = new javax.swing.JButton();
        bReset = new javax.swing.JButton();
        bADminLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Login");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Inventory Management System");

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 3, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("Admin Login");

        tfUsername.setToolTipText("Username");

        jLabel3.setText("Username : ");

        jLabel4.setText("Password : ");

        lMessage.setText("Please login with your correct username and password to access");

        tfPassword.setToolTipText("Password");

        bAdminSignup.setText("Admin SIgnup");
        bAdminSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAdminSignupActionPerformed(evt);
            }
        });

        bReset.setText("Reset");
        bReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bResetActionPerformed(evt);
            }
        });

        bADminLogin.setText("Admin Login");
        bADminLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bADminLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pMainLayout = new javax.swing.GroupLayout(pMain);
        pMain.setLayout(pMainLayout);
        pMainLayout.setHorizontalGroup(
            pMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pMainLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pMainLayout.createSequentialGroup()
                        .addGroup(pMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pMainLayout.createSequentialGroup()
                                .addGroup(pMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1)
                                    .addGroup(pMainLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(22, 22, 22)
                                        .addComponent(tfPassword)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(lMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pMainLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(tfUsername))
                            .addGroup(pMainLayout.createSequentialGroup()
                                .addComponent(bAdminSignup)
                                .addGap(37, 37, 37)
                                .addComponent(bReset)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bADminLogin)))
                        .addContainerGap())))
        );

        pMainLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bADminLogin, bAdminSignup, bReset});

        pMainLayout.setVerticalGroup(
            pMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(lMessage)
                .addGap(18, 18, 18)
                .addGroup(pMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(pMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(pMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAdminSignup)
                    .addComponent(bReset)
                    .addComponent(bADminLogin))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bResetActionPerformed

        try {

            this.tfUsername.setText(null);
            this.tfPassword.setText(null);
        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_bResetActionPerformed

    private void bAdminSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAdminSignupActionPerformed

        this.asf = new AdminSignupFrame(this.database);

        java.awt.EventQueue.invokeLater(() -> {

            this.asf.setVisible(true);
        });
    }//GEN-LAST:event_bAdminSignupActionPerformed

    private void bADminLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bADminLoginActionPerformed

        try {

            Admin admin = this.database.selectAdminFromUsername(this.tfUsername.getText().trim());
            if (admin != null && admin.getPassword().equals(this.tfPassword.getText())) {

                JOptionPane.showMessageDialog(this, "OK");
                return;
            }

            JOptionPane.showMessageDialog(this, "NOT OK");
        } catch (HeadlessException e) {

            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_bADminLoginActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bADminLogin;
    private javax.swing.JButton bAdminSignup;
    private javax.swing.JButton bReset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lMessage;
    private javax.swing.JPanel pMain;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables
}
