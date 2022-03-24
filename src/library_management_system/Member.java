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

public class Member extends javax.swing.JFrame {

    /**
     * Creates new form Member
     */
    public Member() {
        initComponents();
        connection();
        displayTableMemberData();

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
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void displayTableMemberData() {
        int c;

        try {
            pst = connection.prepareStatement("Select * from member");

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
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MEMBER");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel2.setText("Name:");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel3.setText("Address:");

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
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String[]{
                    "ID", "Member Name", "Address", "Phone Number"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
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

        txtAddress.setColumns(20);
        txtAddress.setRows(5);
        jScrollPane2.setViewportView(txtAddress);

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 18));
        jLabel4.setText("Phone Number:");

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
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel3)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 107, Short.MAX_VALUE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel4)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(txtPhoneNumber)))
                                                .addGap(18, 18, 18))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jButton1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel1)
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(33, 33, 33)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel4)
                                                        .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButton1)
                                                        .addComponent(jButton2)
                                                        .addComponent(jButton3)
                                                        .addComponent(jButton4)))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(61, Short.MAX_VALUE))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        String name = txtName.getText();
        String address = txtAddress.getText();
        String phoneNumber = txtPhoneNumber.getText();

        try {
            pst = connection.prepareStatement("insert into member(name, address, phonenumber) values(?, ?, ?)");
            pst.setString(1, name);
            pst.setString(2, address);
            pst.setString(3, phoneNumber);

            int eu = pst.executeUpdate();

            if (eu == 1) {
                JOptionPane.showMessageDialog(this, "Member has been sucessfully created");

                txtName.setText("");
                txtAddress.setText("");
                txtPhoneNumber.setText("");
                txtName.requestFocus();
                displayTableMemberData();

            } else {
                JOptionPane.showMessageDialog(this, "Member cannot be created");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        DefaultTableModel dtm1 = (DefaultTableModel) jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();

        int id = Integer.parseInt((String) dtm1.getValueAt(selectIndex, 0).toString());
        txtName.setText(dtm1.getValueAt(selectIndex, 1).toString());
        txtAddress.setText(dtm1.getValueAt(selectIndex, 2).toString());
        txtPhoneNumber.setText(dtm1.getValueAt(selectIndex, 3).toString());

        jButton1.setEnabled(false);

    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        DefaultTableModel dtm1 = (DefaultTableModel) jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();

        int id = Integer.parseInt((String) dtm1.getValueAt(selectIndex, 0).toString());

        String name = txtName.getText();
        String address = txtAddress.getText();
        String phoneNumber = txtPhoneNumber.getText();

        try {
            pst = connection.prepareStatement("update member set name = ?, address = ?, phonenumber = ? where id = ?");
            pst.setString(1, name);
            pst.setString(2, address);
            pst.setString(3, phoneNumber);
            pst.setInt(4, id);

            int eu = pst.executeUpdate();

            if (eu == 1) {
                JOptionPane.showMessageDialog(this, "Member has been sucessfully updated");

                txtName.setText("");
                txtAddress.setText("");
                txtPhoneNumber.setText("");
                txtName.requestFocus();
                displayTableMemberData();
                jButton1.setEnabled(true);

            } else {
                JOptionPane.showMessageDialog(this, "Member cannot be updated");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        DefaultTableModel dtm1 = (DefaultTableModel) jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();

        int id = Integer.parseInt((String) dtm1.getValueAt(selectIndex, 0).toString());

        try {
            pst = connection.prepareStatement("Delete from member where id = ?");

            pst.setInt(1, id);

            int eu = pst.executeUpdate();

            if (eu == 1) {
                JOptionPane.showMessageDialog(this, "Member has been sucessfully deleted");

                txtName.setText("");
                txtAddress.setText("");
                txtPhoneNumber.setText("");
                txtName.requestFocus();
                displayTableMemberData();
                jButton1.setEnabled(true);

            } else {
                JOptionPane.showMessageDialog(this, "Member cannot be deleted");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        HomeDashboard hd = new HomeDashboard();
        hd.setVisible(true);
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
            java.util.logging.Logger.getLogger(Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Member().setVisible(true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhoneNumber;

}
