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

public class Category extends javax.swing.JFrame {

     public Category() {
        initComponents();
        connection();
        displayTableCategoryData();
        
        this.setLocationRelativeTo(null);
    }
    
    Connection connection;
    PreparedStatement pst;
    ResultSet rs;
    String username = "root";
    String password = "";
    
    
    
    public void connection() {
    
        try {
            Class.forName ("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/MsLibrary", username, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
}
