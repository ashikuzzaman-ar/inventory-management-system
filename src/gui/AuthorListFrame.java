/**
 * This class shows all authors
 */
package gui;

import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Author;
import service.Database;

/*
 * Main GUI Form to launch the application
 */
public class AuthorListFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    private final Database database;

    private final Map<String, Author> authors;
    private final DefaultTableModel defaultTableModel;

    public AuthorListFrame(Database database, Map<String, Author> authors) {

        initComponents();
        this.database = database;
        this.authors = authors;
        this.defaultTableModel = (DefaultTableModel) this.tblAuthorList.getModel();
        this.initializeAuthorTable();
    }

    /**
     * Clearing existing data from table
     */
    private void clearTable() {

        try {

            for (int i = this.defaultTableModel.getRowCount() - 1; i >= 0; i--) {

                this.defaultTableModel.removeRow(i);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * Initializing Author table in frame
     */
    private void initializeAuthorTable() {

        try {

            this.clearTable();

            if (this.authors != null && this.authors.size() > 0) {

                this.authors.entrySet().stream().forEach(author -> {

                    this.defaultTableModel.addRow(new Object[]{
                        author.getValue().getAuthorId(),
                        author.getValue().getFirstName(),
                        author.getValue().getLastName()
                    });
                });
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, "Database Initialization Error!");
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pAuthor = new javax.swing.JPanel();
        lAuthorList = new javax.swing.JLabel();
        bAddNewAuthor = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAuthorList = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Author List");

        lAuthorList.setFont(new java.awt.Font("DejaVu Sans", 3, 24)); // NOI18N
        lAuthorList.setText("Author List");

        bAddNewAuthor.setText("Add New Author");
        bAddNewAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddNewAuthorActionPerformed(evt);
            }
        });

        tblAuthorList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Author ID", "First Name", "Last Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAuthorList);

        javax.swing.GroupLayout pAuthorLayout = new javax.swing.GroupLayout(pAuthor);
        pAuthor.setLayout(pAuthorLayout);
        pAuthorLayout.setHorizontalGroup(
            pAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAuthorLayout.createSequentialGroup()
                .addGroup(pAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
                    .addGroup(pAuthorLayout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addComponent(bAddNewAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(pAuthorLayout.createSequentialGroup()
                .addGap(299, 299, 299)
                .addComponent(lAuthorList)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pAuthorLayout.setVerticalGroup(
            pAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAuthorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lAuthorList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bAddNewAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void bAddNewAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddNewAuthorActionPerformed

        try {

            this.dispose();
            java.awt.EventQueue.invokeLater(()->{
                new AddNewAuthorFrame(this.database, this.authors, this).setVisible(true);
            });
        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, "Something went wrong. Please try again.");
            throw new ExceptionInInitializerError(e);
        }
    }//GEN-LAST:event_bAddNewAuthorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAddNewAuthor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lAuthorList;
    private javax.swing.JPanel pAuthor;
    private javax.swing.JTable tblAuthorList;
    // End of variables declaration//GEN-END:variables
}
