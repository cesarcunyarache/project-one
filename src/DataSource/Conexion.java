/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataSource;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author cesarcunyarache
 */
public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/fagexPeru";
    private static final String USER = "root";
    private static final String PASSWORD = "123456789";
    protected Connection conexion = null;

    public Connection getConection(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = (Connection)DriverManager.getConnection(this.URL, this.USER, this.PASSWORD);
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }

        return conexion;

    }

}
