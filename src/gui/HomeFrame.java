/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Author;
import model.AuthorISBN;
import model.BorrowerISBN;
import model.Borrowers;
import model.Title;
import service.Database;

/**
 *
 * @author ashik
 */
public class HomeFrame extends javax.swing.JFrame {
    
    private final Database database;
    private Map<String, Title> titles;
    private Map<String, Author> authors;
    private Map<String, Borrowers> borrowers;
    private List<BorrowerISBN> borrowerISBNs;
    private Map<String, List<String>> authorTitleMap;
    private Map<String, List<String>> titleAuthorMap;
    private Map<String, List<String>> titleBorrowersMap;
    
    private final DefaultTableModel defaultTableModelMainBookList;
    private final DefaultTableModel defaultTableModelBookInfoTable;
    private final DefaultTableModel defaultTableModelBookBorrowerTable;
    private PursueFrame pursueFrame;
    private ReturnFrame returnFrame;

    /**
     * Creates new form HomeFrame
     */
    /**
     * TODO: Ashif, design this frame completely and attractively how I shown
     * you.
     *
     * @param database
     */
    public HomeFrame(Database database) {
        
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
        this.defaultTableModelMainBookList = (DefaultTableModel) this.tblMainBookList.getModel();
        this.defaultTableModelBookInfoTable = (DefaultTableModel) this.tblBookInfoTable.getModel();
        this.defaultTableModelBookBorrowerTable = (DefaultTableModel) this.tblBookBorrowerTable.getModel();
        this.database = database;
        this.initializeDatabase();
        this.initializeMainBookListTable();
    }
    
    private void clearMemory() {
        
        try {
            
            if (this.titles != null) {
                this.titles.clear();
            }
            if (this.authors != null) {
                this.authors.clear();
            }
            if (this.borrowers != null) {
                this.borrowers.clear();
            }
            if (this.borrowerISBNs != null) {
                this.borrowerISBNs.clear();
            }
            if (this.authorTitleMap != null) {
                this.authorTitleMap.clear();
            }
            if (this.titleAuthorMap != null) {
                this.titleAuthorMap.clear();
            }
            if (this.titleBorrowersMap != null) {
                this.titleBorrowersMap.clear();
            }
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    private void initializeDatabase() {
        
        try {
            
            this.clearMemory();
            
            this.titles = this.database.selectTitles();
            this.authors = this.database.selectAuthors();
            this.borrowers = this.database.selectBorrowers();
            this.initializeAuthorTitleMap(this.database.selectAuthorISBN());
            this.borrowerISBNs = this.database.selectBorrowerISBN();
            this.initializeBorrowersTitleMap();
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    private void initializeBorrowersTitleMap() {
        
        try {
            
            if (this.titleBorrowersMap == null) {
                
                this.titleBorrowersMap = new HashMap<>();
            }
            
            this.borrowerISBNs.stream().forEach(borrowersISBN -> {
                
                if (this.titleBorrowersMap.containsKey(borrowersISBN.getISBN())) {
                    
                    this.titleBorrowersMap.get(borrowersISBN.getISBN()).add(String.valueOf(borrowersISBN.getBorrowerId()));
                } else {
                    
                    List<String> borrowerses = new ArrayList<>();
                    borrowerses.add(String.valueOf(borrowersISBN.getBorrowerId()));
                    this.titleBorrowersMap.put(borrowersISBN.getISBN(), borrowerses);
                }
            });
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    private void initializeAuthorTitleMap(List<AuthorISBN> authorISBNs) {
        
        try {
            
            if (this.authorTitleMap == null) {
                
                this.authorTitleMap = new HashMap<>();
            }
            if (this.titleAuthorMap == null) {
                
                this.titleAuthorMap = new HashMap<>();
            }
            
            authorISBNs.stream().forEach(authorISBN -> {
                
                if (this.authorTitleMap.containsKey(authorISBN.getAuthorId())) {
                    
                    this.authorTitleMap.get(authorISBN.getAuthorId()).add(authorISBN.getISBN());
                } else {
                    
                    List<String> isbnList = new ArrayList<>();
                    isbnList.add(authorISBN.getISBN());
                    this.authorTitleMap.put(String.valueOf(authorISBN.getAuthorId()), isbnList);
                }
                
                if (this.titleAuthorMap.containsKey(authorISBN.getISBN())) {
                    
                    this.titleAuthorMap.get(authorISBN.getISBN()).add(String.valueOf(authorISBN.getAuthorId()));
                } else {
                    
                    List<String> idList = new ArrayList<>();
                    idList.add(String.valueOf(authorISBN.getAuthorId()));
                    this.titleAuthorMap.put(authorISBN.getISBN(), idList);
                }
            });
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    private void clearBookBorrowerTable() {
        
        try {
            
            for (int i = this.defaultTableModelBookBorrowerTable.getRowCount() - 1; i >= 0; i--) {
                
                this.defaultTableModelBookBorrowerTable.removeRow(i);
            }
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    private void clearBookInfoTable() {
        
        try {
            
            for (int i = this.defaultTableModelBookInfoTable.getRowCount() - 1; i >= 0; i--) {
                
                this.defaultTableModelBookInfoTable.removeRow(i);
            }
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    private void clearMainBookListTable() {
        
        try {
            
            for (int i = this.defaultTableModelMainBookList.getRowCount() - 1; i >= 0; i--) {
                
                this.defaultTableModelMainBookList.removeRow(i);
            }
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    private void initializeMainBookListTable() {
        
        try {
            
            this.clearMainBookListTable();
            if (this.titles != null && this.titles.size() > 0) {
                
                this.titles.entrySet().stream().forEach(t -> {
                    
                    Title title = t.getValue();
                    StringBuilder authorList = new StringBuilder();
                    List<String> tempAuthorList = this.titleAuthorMap.get(title.getISBN());
                    
                    tempAuthorList.stream().forEach(al -> {
                        
                        authorList.append(this.authors.get(al).getFirstName());
                        authorList.append(" ");
                        authorList.append(this.authors.get(al).getLastName());
                        authorList.append(",");
                    });
                    
                    int borrowedNumber = 0;
                    
                    if (this.titleBorrowersMap.containsKey(title.getISBN())) {
                        
                        borrowedNumber = this.titleBorrowersMap.get(title.getISBN()).size();
                    }
                    
                    this.defaultTableModelMainBookList.addRow(new Object[]{
                        title.getTitle(),
                        authorList.toString(),
                        title.getISBN(),
                        title.getTotalNumber(),
                        title.getTotalNumber() - borrowedNumber
                    });
                });
            }
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    private void initializeMainBookListTable(String bookTitle) {
        
        try {
            
            this.clearMainBookListTable();
            if (this.titles != null && this.titles.size() > 0) {
                
                this.titles.entrySet().stream().forEach(t -> {
                    
                    Title title = t.getValue();
                    
                    if (title.getTitle().toLowerCase().contains(bookTitle.toLowerCase())) {
                        
                        StringBuilder authorList = new StringBuilder();
                        List<String> tempAuthorList = this.titleAuthorMap.get(title.getISBN());
                        
                        tempAuthorList.stream().forEach(al -> {
                            
                            authorList.append(this.authors.get(al).getFirstName());
                            authorList.append(" ");
                            authorList.append(this.authors.get(al).getLastName());
                            authorList.append(",");
                        });
                        
                        int borrowedNumber = 0;
                        
                        if (this.titleBorrowersMap.containsKey(title.getISBN())) {
                            
                            borrowedNumber = this.titleBorrowersMap.get(title.getISBN()).size();
                        }
                        
                        this.defaultTableModelMainBookList.addRow(new Object[]{
                            title.getTitle(),
                            authorList.toString(),
                            title.getISBN(),
                            title.getTotalNumber(),
                            title.getTotalNumber() - borrowedNumber
                        });
                    }
                });
            }
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(this, e);
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

        pHomePanel = new javax.swing.JPanel();
        lvlTitle = new javax.swing.JLabel();
        bAddBook = new javax.swing.JButton();
        bAuthorList = new javax.swing.JButton();
        bUpdate = new javax.swing.JButton();
        bPursue = new javax.swing.JButton();
        tfSearch = new javax.swing.JTextField();
        bSearch = new javax.swing.JButton();
        bReturn = new javax.swing.JButton();
        bDelete = new javax.swing.JButton();
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

        bAuthorList.setText("Author List");
        bAuthorList.setToolTipText("Delete Selected Book");
        bAuthorList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAuthorListActionPerformed(evt);
            }
        });

        bUpdate.setText("Update");
        bUpdate.setToolTipText("Update Selected Book Info");
        bUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUpdateActionPerformed(evt);
            }
        });

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

        bDelete.setText("Delete");
        bDelete.setToolTipText("Delete Selected Book");
        bDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pHomePanelLayout = new javax.swing.GroupLayout(pHomePanel);
        pHomePanel.setLayout(pHomePanelLayout);
        pHomePanelLayout.setHorizontalGroup(
            pHomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pHomePanelLayout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addComponent(tfSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(212, 212, 212)
                .addGroup(pHomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(bReturn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bPursue, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                .addGap(71, 71, 71))
            .addGroup(pHomePanelLayout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(lvlTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pHomePanelLayout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(bAddBook, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(bAuthorList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(31, 31, 31)
                .addComponent(bDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(247, 247, 247))
        );
        pHomePanelLayout.setVerticalGroup(
            pHomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pHomePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lvlTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pHomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAddBook, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bAuthorList, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pHomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bPursue, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        tblMainBookList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title", "Author", "ISBN", "Total Copy", "Available"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMainBookList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMainBookListMouseClicked(evt);
            }
        });
        pBookListPanel.setViewportView(tblMainBookList);

        pBookStatusPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lvlBookStatusTitle.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N

        tblBookInfoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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

        tblBookBorrowerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
                .addGap(142, 142, 142)
                .addComponent(lvlBorrowTitle)
                .addGap(0, 118, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pBookStatusPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pBookStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pBookStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pBookStatusPanelLayout.createSequentialGroup()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pBookStatusPanelLayout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addContainerGap()))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pBookStatusPanelLayout.createSequentialGroup()
                        .addComponent(lvlBookStatusTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))))
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
        
        try {
            
            java.awt.EventQueue.invokeLater(() -> {
                new AddBookFrame(this.database, this.authors, this.titles, this.authorTitleMap, this.titleAuthorMap).setVisible(true);
            });
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_bAddBookActionPerformed

    private void bPursueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPursueActionPerformed
        
        try {
            
            int index = this.tblMainBookList.getSelectedRow();
            
            if (index >= 0) {
                
                java.awt.EventQueue.invokeLater(() -> {
                    
                    String ISBN = (String) this.defaultTableModelMainBookList.getValueAt(index, 2);
                    pursueFrame = new PursueFrame(database, ISBN, this.titles,
                            borrowers, borrowerISBNs, titleBorrowersMap);
                    pursueFrame.setVisible(true);
                });
            } else {
                
                JOptionPane.showMessageDialog(this, "Please select a book first then try again.");
            }
        } catch (HeadlessException e) {
            
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_bPursueActionPerformed

    private void bSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSearchActionPerformed
        
        try {
            
            this.initializeMainBookListTable(this.tfSearch.getText());
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_bSearchActionPerformed

    private void bReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bReturnActionPerformed
        
        try {
            
            java.awt.EventQueue.invokeLater(() -> {
                
                returnFrame = new ReturnFrame(database, this.titles,
                        borrowers, borrowerISBNs, titleBorrowersMap);
                returnFrame.setVisible(true);
            });
        } catch (HeadlessException e) {
            
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_bReturnActionPerformed

    private void tblMainBookListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMainBookListMouseClicked
        
        try {
            
            this.clearBookInfoTable();
            this.clearBookBorrowerTable();
            
            int index = this.tblMainBookList.getSelectedRow();
            
            if (index >= 0) {
                
                String ISBN = (String) this.defaultTableModelMainBookList.getValueAt(index, 2);
                
                this.lvlBookStatusTitle.setText(this.titles.get(ISBN).getTitle());
                
                this.defaultTableModelBookInfoTable.addRow(new Object[]{
                    ISBN,
                    this.titles.get(ISBN).getEditionNumber()
                });
                
                if (this.titleBorrowersMap.get(ISBN) != null) {
                    
                    this.titleBorrowersMap.get(ISBN).stream().forEach(b -> {
                        
                        Borrowers borrower = this.borrowers.get(b);
                        BorrowerISBN borrowerISBN = this.borrowerISBNs.get(this.borrowerISBNs.indexOf(new BorrowerISBN(borrower.getId(), ISBN)));
                        this.defaultTableModelBookBorrowerTable.addRow(new Object[]{
                            borrower.getFirstName() + " " + borrower.getLastName(),
                            borrower.getPhoneNumber(),
                            borrowerISBN.getPursueDate(),
                            borrowerISBN.getReturnDate()
                        });
                    });
                }
            }
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_tblMainBookListMouseClicked

    private void bAuthorListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAuthorListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bAuthorListActionPerformed

    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
        
        try {
            
            int index = this.tblMainBookList.getSelectedRow();
            
            if (index >= 0) {
                
                int decession = JOptionPane.showConfirmDialog(this, "Are you sure to delete this entry?");
                
                if (decession == 0) {
                    
                    if (this.database.deleteTitle((String) this.defaultTableModelMainBookList.getValueAt(index, 2))) {
                        
                        this.initializeDatabase();
                        this.initializeMainBookListTable();
                        this.bSearchActionPerformed(evt);
                    }
                }
            } else {
                
                JOptionPane.showMessageDialog(this, "Please choose a book first then try again.");
            }
        } catch (HeadlessException e) {
            
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_bDeleteActionPerformed

    private void bUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUpdateActionPerformed
        
        try {
            
            int index = this.tblMainBookList.getSelectedRow();
            
            if (index >= 0) {
                
                java.awt.EventQueue.invokeLater(() -> {
                    
                    new UpdateFrame(this.database, (String) this.defaultTableModelMainBookList.getValueAt(index, 2), this.authors, this.titles, this.authorTitleMap, this.titleAuthorMap).setVisible(true);
                });
            } else {
                
                JOptionPane.showMessageDialog(this, "Please choose a book first then try again.");
            }
        } catch (HeadlessException e) {
            
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_bUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAddBook;
    private javax.swing.JButton bAuthorList;
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
