package library_management_system;

import java.sql.ResultSetMetaData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class Book extends javax.swing.JFrame {

    /**
     * Creates new form Category
     */
    public Book() {
        initComponents();
        connection();
        Category();
        Author();
        displayTableBookData();

        this.setLocationRelativeTo(null);
    }

    public class CategoryItem {

        int id;
        String name;

        public CategoryItem(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String toString() {
            return name;

        }
    }

    public class AuthorItem {

        int id;
        String name;

        public AuthorItem(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String toString() {
            return name;
        }

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
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Category() {
        try {
            pst = connection.prepareStatement("select * from category");
            rs = pst.executeQuery();

            txtCategory.removeAllItems();

            while (rs.next()) {
                txtCategory.addItem(new CategoryItem(rs.getInt(1), rs.getString(2)));

            }

        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Author() {
        try {
            pst = connection.prepareStatement("select * from author");
            rs = pst.executeQuery();

            txtAuthor.removeAllItems();

            while (rs.next()) {
                txtAuthor.addItem(new AuthorItem(rs.getInt(1), rs.getString(2)));

            }

        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void displayTableAuthorData() {
        int c;

        try {
            pst = connection.prepareStatement("Select * from author");

            rs = pst.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();

            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();

                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("name"));
                    v2.add(rs.getString("address"));
                    v2.add(rs.getString("phonenumber"));

                }

                dtm.addRow(v2);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void displayTableBookData() {
        int c;

        try {
            pst = connection.prepareStatement("Select b.id, b.bookname, c.categoryname, a.name, b.author, b.category, b.contents, b.pages, b.edition from book b JOIN category c On b.category = c.id JOIN author a ON b.author = a.id; ");

            rs = pst.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();

            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();

                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("b.id"));
                    v2.add(rs.getString("b.bookname"));
                    v2.add(rs.getString("c.categoryname"));
                    v2.add(rs.getString("a.name"));
                    v2.add(rs.getString("b.contents"));
                    v2.add(rs.getString("b.pages"));
                    v2.add(rs.getString("b.edition"));

                }

                dtm.addRow(v2);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtContents = new javax.swing.JTextField();
        txtCategory = new javax.swing.JComboBox();
        txtAuthor = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        txtPages = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtEdition = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 36));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BOOK INFORMATION");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 18));
        jLabel2.setText("Book Name:");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 18));
        jLabel3.setText("Category:");

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
                new Object[][]{
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null}
                },
                new String[]{
                    "ID", "Book Name", "Category", "Author", "Contents", "No. of Pages", "Edition"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class,
                java.lang.Object.class
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
        jLabel4.setText("Author:");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 18));
        jLabel5.setText("Contents");

        txtAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAuthorActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 18));
        jLabel6.setText("No. of Pages:");

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 18));
        jLabel7.setText("Edition:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel2)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel3)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(txtCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel4)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel5)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(txtContents, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel6)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(txtPages, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel7)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(txtEdition, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jButton1)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButton2)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButton3)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButton4)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(100, 100, 100)
                                                .addComponent(jLabel1)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(31, 31, 31)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(txtCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel4)
                                                        .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel5)
                                                        .addComponent(txtContents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel6)
                                                        .addComponent(txtPages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel7)
                                                        .addComponent(txtEdition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButton1)
                                                        .addComponent(jButton2)
                                                        .addComponent(jButton3)
                                                        .addComponent(jButton4))))
                                .addContainerGap(184, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[]{txtAuthor, txtCategory, txtContents, txtEdition, txtName, txtPages});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[]{jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7});

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
        txtName.setText(dtm1.getValueAt(selectIndex, 1).toString());
        txtCategory.setSelectedItem(dtm1.getValueAt(selectIndex, 2).toString());
        txtAuthor.setSelectedItem(dtm1.getValueAt(selectIndex, 3).toString());
        txtContents.setText(dtm1.getValueAt(selectIndex, 4).toString());
        txtPages.setText(dtm1.getValueAt(selectIndex, 5).toString());
        txtEdition.setText(dtm1.getValueAt(selectIndex, 6).toString());

        jButton1.setEnabled(false);

    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        HomeDashboard hd = new HomeDashboard();
        hd.setVisible(true);
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        DefaultTableModel dtm1 = (DefaultTableModel) jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();

        int id = Integer.parseInt((String) dtm1.getValueAt(selectIndex, 0).toString());

        try {
            pst = connection.prepareStatement("Delete from author where id = ?");

            pst.setInt(1, id);

            int eu = pst.executeUpdate();

            if (eu == 1) {
                JOptionPane.showMessageDialog(this, "Author has been sucessfully deleted");

                txtName.setText("");
                txtCategory.setSelectedItem(null);
                txtName.requestFocus();
                displayTableAuthorData();
                jButton1.setEnabled(true);

            } else {
                JOptionPane.showMessageDialog(this, "Author cannot be deleted");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        DefaultTableModel dtm1 = (DefaultTableModel) jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();

        int id = Integer.parseInt((String) dtm1.getValueAt(selectIndex, 0).toString());

        String bookName = txtName.getText();
        String category = txtCategory.getSelectedItem().toString();
        String author = txtAuthor.getSelectedItem().toString();
        String contents = txtContents.getText();
        String numberOfPages = txtPages.getText();
        String edition = txtEdition.getText();

        try {
            pst = connection.prepareStatement("update book set bookname = ?, category = ?, author = ?, contents = ?, pages = ?, edition = ? where id = ?");
            pst.setString(1, bookName);
            pst.setString(2, category);
            pst.setString(3, author);
            pst.setString(4, contents);
            pst.setString(5, numberOfPages);
            pst.setString(6, edition);

            pst.setInt(7, id);
            int eu = pst.executeUpdate();

            if (eu == 1) {
                JOptionPane.showMessageDialog(this, "Book has been successfully updated ");

                txtName.setText("");
                txtCategory.setSelectedItem(0);
                txtCategory.requestFocus();
                jButton1.setEnabled(true);

            } else {
                JOptionPane.showMessageDialog(this, "Category not created");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        String name = txtName.getText();
        CategoryItem cItem = (CategoryItem) txtCategory.getSelectedItem();
        AuthorItem aItem = (AuthorItem) txtAuthor.getSelectedItem();

        String contents = txtContents.getText();
        String noOfPages = txtPages.getText();
        String edition = txtEdition.getText();

        try {
            pst = connection.prepareStatement("insert into book(bookname, category, author, contents, pages, edition) values(?, ?, ?, ?, ?, ?)");
            pst.setString(1, name);
            pst.setInt(2, cItem.id);
            pst.setInt(3, aItem.id);
            pst.setString(4, contents);
            pst.setString(5, noOfPages);
            pst.setString(6, edition);

            int eu = pst.executeUpdate();

            if (eu == 1) {
                JOptionPane.showMessageDialog(this, "Book has been sucessfully created");

                txtName.setText("");
                txtCategory.setSelectedItem(-1);
                txtAuthor.setSelectedItem(-1);
                txtContents.setText("");
                txtPages.setText("");
                txtEdition.setText("");

                displayTableAuthorData();

            } else {
                JOptionPane.showMessageDialog(this, "Book cannot be created");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void txtAuthorActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Book().setVisible(true);
            }
        });
    }

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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox txtAuthor;
    private javax.swing.JComboBox txtCategory;
    private javax.swing.JTextField txtContents;
    private javax.swing.JTextField txtEdition;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPages;

}
