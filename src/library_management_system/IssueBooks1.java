package library_management_system;

import java.awt.event.KeyEvent;
import java.sql.ResultSetMetaData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class IssueBooks1 extends javax.swing.JFrame {

    /**
     * Creates new form Category
     */
    public IssueBooks1() {
        initComponents();
        connection();
        Book();
        displayTableIssueBookData();
                
        

        this.setLocationRelativeTo(null);
    }
    
    
    
    

    

    Connection connection;
    PreparedStatement pst;
    ResultSet rs;
    String username = "root";
    String password = "";

    public void connection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/MsLibrary", username, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IssueBooks1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(IssueBooks1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public class BookItem {
        
        int id;
        String name;
        
    
        
        public BookItem (int id, String name){
            
            this.id = id;
            this.name = name;
            
    }
        public String toString() {
            
            return name;
        }
                
        
    }
    
    
    public void Book() {
        
        try {
            pst = connection.prepareStatement("select * from book");
            rs = pst.executeQuery();

            txtBook.removeAllItems();

            while (rs.next()) {
                txtBook.addItem(new BookItem(rs.getInt(1), rs.getString(2)));

            }

        } catch (SQLException ex) {
            Logger.getLogger(Book1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
        public void displayTableIssueBookData()
    {
        int c; 
        
        try {
            pst = connection.prepareStatement("SELECT l.id,m.name,b.bookname,l.issueddate,l.returndate FROM issuebook l JOIN member m ON l.memberid = m.id JOIN book b ON l.bookid = b.id;  ");
            
            rs = pst.executeQuery(); //retrieves data from the database
            
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount(); // retrieves the number of the columns of the current ResultSet object - returns integer value representing number of columns
            
            
            DefaultTableModel dtm = (DefaultTableModel)jTable1.getModel();
            dtm.setRowCount(0);
            
            while (rs.next())
            {
                Vector v2 = new Vector();
                
                for (int i = 1; i <= c; i++)
                {
                    v2.add(rs.getString("l.id"));
                    v2.add(rs.getString("m.name"));
                    v2.add(rs.getString("b.bookname"));
                    v2.add(rs.getString("l.issueddate"));
                    v2.add(rs.getString("l.returndate"));
                    
                            
                }
                
                dtm.addRow(v2);
                
            }
 
            
        } catch (SQLException ex) {
            Logger.getLogger(ReturnBook1.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMemberID = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtBook = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        txtMemberName = new javax.swing.JTextField();
        txtIssuedDate = new com.toedter.calendar.JDateChooser();
        txtReturnDate = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ISSUE BOOK");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel2.setText("Member ID:");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel3.setText("Member Name:");

        txtMemberID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMemberIDKeyPressed(evt);
            }
        });

        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("UPDATE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 0, 0));
        jButton3.setText("DELETE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("BACK TO HOME");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(204, 204, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Member Name", "Book", "Issued Date", "Return Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel4.setText("Book:");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel5.setText("Issued Date:");

        txtBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel6.setText("Return Date:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(361, 361, 361)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMemberName, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtIssuedDate, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(19, 19, 19))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtMemberID, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jButton1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtBook, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(84, 84, 84))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMemberID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtMemberName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtIssuedDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txtReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4, jLabel5, jLabel6});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton4, txtBook, txtIssuedDate, txtMemberID, txtMemberName, txtReturnDate});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel dtm1 = (DefaultTableModel) jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();

        int id = Integer.parseInt((String) dtm1.getValueAt(selectIndex, 0).toString());
        txtMemberID.setText(dtm1.getValueAt(selectIndex, 1).toString());
        txtMemberName.setText(dtm1.getValueAt(selectIndex, 2).toString());
        txtBook.setSelectedItem(dtm1.getValueAt(selectIndex, 3).toString());
        txtIssuedDate.setDateFormatString(dtm1.getValueAt(selectIndex, 4).toString());
        txtReturnDate.setDateFormatString (dtm1.getValueAt(selectIndex, 5).toString());
        

        jButton1.setEnabled(false);


    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        HomeForm1 backToHome = new HomeForm1();
        backToHome.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dtm1 = (DefaultTableModel) jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();

        int id = Integer.parseInt((String) dtm1.getValueAt(selectIndex, 0).toString());

        try {
            pst = connection.prepareStatement("Delete from issuebook where id = ?");

            pst.setInt(1, id);

            int eu = pst.executeUpdate();

            if (eu == 1) {
                JOptionPane.showMessageDialog(this, "Issued Book has been sucessfully deleted");

                txtMemberID.setText("");
                txtMemberName.setText("");
                txtBook.setSelectedItem(-1);
                txtIssuedDate.setDateFormatString("");
                txtReturnDate.setDateFormatString("");
                txtMemberID.requestFocus();
                
                displayTableIssueBookData();
                
            } else {
                JOptionPane.showMessageDialog(this, "Issued Book cannot be deleted");
            }

        } catch (SQLException ex) {
            Logger.getLogger(IssueBooks1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
         DefaultTableModel dtm1 = (DefaultTableModel)jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();
        
        int id = Integer.parseInt((String) dtm1.getValueAt(selectIndex, 0).toString());
        
        String memberID = txtMemberID.getText();
        String memberName = txtMemberName.getText();
        String bookName = txtBook.getSelectedItem().toString();
        String issuedDate = txtIssuedDate.getDateFormatString();
        String returnDate = txtReturnDate.getDateFormatString();
        
        
        
        
        try {
            pst = connection.prepareStatement("update issuebook set memberid = ?, bookid = ?, issueddate = ?, returndate = ? where id = ?");
            pst.setString(1, memberID);
            pst.setString(2, memberName);
            pst.setString(3, bookName);
            pst.setString(4, issuedDate);
            pst.setString(5, returnDate);
            pst.setInt(6, id);
            
            
            int eu = pst.executeUpdate();
            
            if (eu == 1)
            {
                JOptionPane.showMessageDialog(this, "Issued Book has been updated ");
                
                
                txtMemberID.setText("");
                txtMemberName.setText("");
                txtBook.setSelectedItem(-1);
                txtIssuedDate.setDateFormatString("");
                txtReturnDate.setDateFormatString("");
                
                txtMemberID.requestFocus();
                
                displayTableIssueBookData();
                
                
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Issued book could not be updated");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(IssueBooks1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       

       

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        String memberID = txtMemberID.getText();
        BookItem bItem = (BookItem) txtBook.getSelectedItem();
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String issueDate = dateFormat.format(txtIssuedDate.getDate());
        
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        String returnDate = dateFormat.format(txtReturnDate.getDate());
        


        try {
            pst = connection.prepareStatement("insert into issuebook(memberid, bookid, issueddate, returndate) values(?, ?, ?, ?)");
            pst.setString(1, memberID);
            pst.setInt(2, bItem.id);
            pst.setString(3, issueDate);
            pst.setString(4, returnDate);
            

            int eu = pst.executeUpdate();

            if (eu == 1) {
                JOptionPane.showMessageDialog(this, "Book has been sucessfully issued");

                txtMemberID.setText("");
                txtBook.setSelectedItem(-1);
                txtMemberName.setText("");
                displayTableIssueBookData();

            } else {
                JOptionPane.showMessageDialog(this, "Book cannot be issued");
            }

        } catch (SQLException ex) {
            Logger.getLogger(IssueBooks1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookActionPerformed

    private void txtMemberIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMemberIDKeyPressed
        // TODO add your handling code here:
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String memberID = txtMemberID.getText();
            
            try {
                pst = connection.prepareStatement("select * from member where id = ?");
                pst.setString(1, memberID);
                rs = pst.executeQuery();
                
                
                if (rs.next() == false) {
                    JOptionPane.showMessageDialog(this, "Member ID cannot be found");
                    
                } else {
                    String memberName = rs.getString("m.name");
                    txtMemberName.setText(memberName.trim());
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(IssueBooks1.class.getName()).log(Level.SEVERE, null, ex);
            }
   
            
        }

    }//GEN-LAST:event_txtMemberIDKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IssueBooks1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBooks1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBooks1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBooks1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBooks1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox txtBook;
    private com.toedter.calendar.JDateChooser txtIssuedDate;
    private javax.swing.JTextField txtMemberID;
    private javax.swing.JTextField txtMemberName;
    private com.toedter.calendar.JDateChooser txtReturnDate;
    // End of variables declaration//GEN-END:variables
}
