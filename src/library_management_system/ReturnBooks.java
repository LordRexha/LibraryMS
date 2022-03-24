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

public class ReturnBooks extends javax.swing.JFrame {

    /**
     * Creates new form Category
     */
    public ReturnBooks() {
        initComponents();
        connection();
        table_update();

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
            Logger.getLogger(ReturnBooks.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReturnBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void table_update() {

        int c;
        try {

            pst = connection.prepareStatement("select * from  returnbook");
            ResultSet rs = pst.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();

            DefaultTableModel d = (DefaultTableModel) jTable1.getModel();
            d.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();

                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("memberid"));
                    v2.add(rs.getString("name"));
                    v2.add(rs.getString("bookname"));
                    v2.add(rs.getString("returndate"));
                    v2.add(rs.getString("elapsed"));
                    v2.add(rs.getString("fine"));

                }
                d.addRow(v2);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public class BookItem {

        int id;
        String name;

        public BookItem(int id, String name) {

            this.id = id;
            this.name = name;

        }

        public String toString() {

            return name;
        }

    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMemberID = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtMemberName = new javax.swing.JLabel();
        txtBook = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtdElp = new javax.swing.JTextField();
        txtFine = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        txtReturnDate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 36));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("RETURN BOOK");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 18));
        jLabel2.setText("Member ID:");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 18));
        jLabel3.setText("Member Name:");

        txtMemberID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMemberIDKeyPressed(evt);
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
                new Object[][]{
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null}
                },
                new String[]{
                    "ID", "Member ID", "Member Name", "Book", "Return Date", "Days Elapsed", "Fine"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 18));
        jLabel4.setText("Book:");

        txtMemberName.setFont(new java.awt.Font("Lucida Grande", 0, 18));
        txtMemberName.setText("John Smith");

        txtBook.setFont(new java.awt.Font("Lucida Grande", 0, 18));
        txtBook.setText("Harry Potter");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 18));
        jLabel5.setText("Return Date:");

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 18));
        jLabel6.setText("Days Elapsed:");

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 18));
        jLabel9.setText("Fine: ");

        jButton5.setText("RETURN");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        txtReturnDate.setFont(new java.awt.Font("Lucida Grande", 0, 18));
        txtReturnDate.setText("24/03/2022");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtFine))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtdElp, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel2)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(txtMemberID, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel3)
                                                                .addGap(29, 29, 29)
                                                                .addComponent(txtMemberName))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel4)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(txtBook))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel5)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(txtReturnDate)))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jButton5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton4)))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(361, 361, 361)
                                .addComponent(jLabel1)
                                .addGap(111, 111, 111))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(119, 119, 119)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtMemberID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(txtMemberName))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel4)
                                                        .addComponent(txtBook))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel5)
                                                        .addComponent(txtReturnDate))
                                                .addGap(16, 16, 16)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel6)
                                                        .addComponent(txtdElp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel9)
                                                        .addComponent(txtFine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(32, 32, 32)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButton4)
                                                        .addComponent(jButton5)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addComponent(jLabel1)
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(194, Short.MAX_VALUE))
        );

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
    }

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        DefaultTableModel dtm1 = (DefaultTableModel) jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();

        int id = Integer.parseInt((String) dtm1.getValueAt(selectIndex, 0).toString());
        txtMemberID.setText(dtm1.getValueAt(selectIndex, 1).toString());
        txtMemberName.setText(dtm1.getValueAt(selectIndex, 2).toString());
        txtBook.setText(dtm1.getValueAt(selectIndex, 3).toString());
        txtReturnDate.setText(dtm1.getValueAt(selectIndex, 4).toString());
        txtdElp.setText(dtm1.getValueAt(selectIndex, 5).toString());
        txtFine.setText(dtm1.getValueAt(selectIndex, 6).toString());

    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        HomeDashboard hd = new HomeDashboard();
        hd.setVisible(true);
    }

    private void txtMemberIDKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String id = txtMemberID.getText();
            try {
                pst = connection.prepareStatement("SELECT m.name,b.bookname,i.returndate,DATEDIFF(NOW(),i.returndate) as elap FROM issuebook i "
                        + "JOIN book b ON i.bookid = b.id JOIN member m ON i.memberid = m.id and  i.memberid = ?");
                pst.setString(1, id);
                ResultSet rs = pst.executeQuery();
                if (rs.next() == false) {
                    JOptionPane.showMessageDialog(this, "Member ID not Found");
                } else {
                    String memberName = rs.getString("m.name");
                    String bookName = rs.getString("b.bookname");
                    jLabel1.setText(memberName.trim());
                    jLabel2.setText(bookName.trim());
                    String date = rs.getString("l.returndate");
                    String elp = rs.getString("elap");

                    int elaped = Integer.parseInt(elp);
                    if (elaped > 0) {
                        txtdElp.setText(elp);
                        int fine = elaped * 50;
                        txtFine.setText(String.valueOf(fine));
                    } else {
                        txtdElp.setText("0");
                        txtFine.setText("0");
                    }
                    txtReturnDate.setText(date.trim());
                }
            } catch (SQLException ex) {
                Logger.getLogger(ReturnBooks.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        String memberID = txtMemberID.getText();
        String memberName = txtMemberName.getText();
        String bookName = txtBook.getText();
        String returnDate = txtReturnDate.getText();
        String elapsedTime = txtdElp.getText();
        String fine = txtFine.getText();

        try {
            pst = connection.prepareStatement("insert into returnbook(memberid,name,bookname,returndate,elapsed,fine)values(?,?,?,?,?,?) ");
            pst.setString(1, memberID);
            pst.setString(2, memberName);
            pst.setString(3, bookName);
            pst.setString(4, returnDate);
            pst.setString(5, elapsedTime);
            pst.setString(6, fine);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Returned Book Successfully");
            table_update();

            pst = connection.prepareStatement("delete from issuebook where memberid = ? ");
            pst.setString(1, memberID);
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReturnBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnBooks().setVisible(true);
            }
        });
    }
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel txtBook;
    private javax.swing.JTextField txtFine;
    private javax.swing.JTextField txtMemberID;
    private javax.swing.JLabel txtMemberName;
    private javax.swing.JLabel txtReturnDate;
    private javax.swing.JTextField txtdElp;

}
