/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author ashik
 */
public class HomeFrame extends javax.swing.JFrame {

    /**
     * Creates new form HomeFrame
     */
    
    /**
     * TODO: Ashif, design this frame completely and attractively how I shown you.
     */
    
    public HomeFrame() {
        
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
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pHomePanel = new javax.swing.JPanel();
        lvlTitle = new javax.swing.JLabel();
        bAddBook = new javax.swing.JButton();
        bDelete = new javax.swing.JButton();
        bUpdate = new javax.swing.JButton();
        bPursue = new javax.swing.JButton();
        tfSearch = new javax.swing.JTextField();
        bSearch = new javax.swing.JButton();
        bReturn = new javax.swing.JButton();
        pBookListPanel = new javax.swing.JScrollPane();
        tblMainBookList = new javax.swing.JTable();
        pBookStatusPanel = new javax.swing.JPanel();
        lvlBookStatusTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBookInfoTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBookBorrowerTable = new javax.swing.JTable();
        lvlBorrowTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home - Inventory Management System");
        setResizable(false);

        lvlTitle.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        lvlTitle.setForeground(new java.awt.Color(0, 0, 204));
        lvlTitle.setText("Inventory Management System");
        lvlTitle.setToolTipText("");

        bAddBook.setText("Add Book");
        bAddBook.setToolTipText("Add Book");
        bAddBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddBookActionPerformed(evt);
            }
        });

        bDelete.setText("Delete");
        bDelete.setToolTipText("Delete Selected Book");

        bUpdate.setText("Update");
        bUpdate.setToolTipText("Update Selected Book Info");

        bPursue.setText("Pursue");
        bPursue.setToolTipText("Pursue Selected Book");
        bPursue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPursueActionPerformed(evt);
            }
        });

        bSearch.setText("Search");
        bSearch.setToolTipText("Search Book in the Inventory");
        bSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSearchActionPerformed(evt);
            }
        });

        bReturn.setText("Return");
        bReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bReturnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pHomePanelLayout = new javax.swing.GroupLayout(pHomePanel);
        pHomePanel.setLayout(pHomePanelLayout);
        pHomePanelLayout.setHorizontalGroup(
            pHomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pHomePanelLayout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addGroup(pHomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pHomePanelLayout.createSequentialGroup()
                        .addComponent(bAddBook, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pHomePanelLayout.createSequentialGroup()
                        .addComponent(tfSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(212, 212, 212)))
                .addGroup(pHomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(bReturn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bPursue, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                .addGap(71, 71, 71))
            .addGroup(pHomePanelLayout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(lvlTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pHomePanelLayout.setVerticalGroup(
            pHomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pHomePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lvlTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pHomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAddBook, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pHomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bPursue, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        tblMainBookList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title", "Author", "Total Copy", "Available"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pBookListPanel.setViewportView(tblMainBookList);
        if (tblMainBookList.getColumnModel().getColumnCount() > 0) {
            tblMainBookList.getColumnModel().getColumn(2).setResizable(false);
            tblMainBookList.getColumnModel().getColumn(3).setResizable(false);
        }

        pBookStatusPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lvlBookStatusTitle.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        lvlBookStatusTitle.setText("Book Title will be here");

        tblBookInfoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "ISBN", "Edition"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblBookInfoTable);
        if (tblBookInfoTable.getColumnModel().getColumnCount() > 0) {
            tblBookInfoTable.getColumnModel().getColumn(0).setResizable(false);
            tblBookInfoTable.getColumnModel().getColumn(1).setResizable(false);
        }

        tblBookBorrowerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Phone", "Pursue", "Return"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblBookBorrowerTable);
        if (tblBookBorrowerTable.getColumnModel().getColumnCount() > 0) {
            tblBookBorrowerTable.getColumnModel().getColumn(0).setResizable(false);
            tblBookBorrowerTable.getColumnModel().getColumn(3).setResizable(false);
        }

        lvlBorrowTitle.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lvlBorrowTitle.setText("Borrower List");

        javax.swing.GroupLayout pBookStatusPanelLayout = new javax.swing.GroupLayout(pBookStatusPanel);
        pBookStatusPanel.setLayout(pBookStatusPanelLayout);
        pBookStatusPanelLayout.setHorizontalGroup(
            pBookStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBookStatusPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pBookStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pBookStatusPanelLayout.createSequentialGroup()
                        .addComponent(lvlBookStatusTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pBookStatusPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pBookStatusPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(pBookStatusPanelLayout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(lvlBorrowTitle)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pBookStatusPanelLayout.setVerticalGroup(
            pBookStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBookStatusPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lvlBookStatusTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lvlBorrowTitle)
                .addGap(19, 19, 19)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pHomePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pBookListPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pBookStatusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pHomePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pBookStatusPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pBookListPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAddBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddBookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bAddBookActionPerformed

    private void bPursueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPursueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bPursueActionPerformed

    private void bSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bSearchActionPerformed

    private void bReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bReturnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bReturnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAddBook;
    private javax.swing.JButton bDelete;
    private javax.swing.JButton bPursue;
    private javax.swing.JButton bReturn;
    private javax.swing.JButton bSearch;
    private javax.swing.JButton bUpdate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lvlBookStatusTitle;
    private javax.swing.JLabel lvlBorrowTitle;
    private javax.swing.JLabel lvlTitle;
    private javax.swing.JScrollPane pBookListPanel;
    private javax.swing.JPanel pBookStatusPanel;
    private javax.swing.JPanel pHomePanel;
    private javax.swing.JTable tblBookBorrowerTable;
    private javax.swing.JTable tblBookInfoTable;
    private javax.swing.JTable tblMainBookList;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
