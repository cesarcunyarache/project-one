/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import TransferObject.ClienteDTO;
import DataSource.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author cesarcunyarache
 */
public class ClientesDAO implements DAO<ClienteDTO> {

    Conexion conexion;
    ClienteDTO cliente;
    public ClientesDAO() {
        conexion = new Conexion();
    }

    
    @Override
    public boolean Create(ClienteDTO cliente) {
        Connection con = conexion.getConection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("INSERT INTO Clientes(dni, nombres, apellidos, genero, telefono, correo, direccion, ruc) VALUE(?,?,?,?,?,?,?,?)");
            ps.setString(1, cliente.getDni());
            ps.setString(2, cliente.getNombres());
            ps.setString(3, cliente.getApellidos());
            ps.setString(4, cliente.getGenero());
            ps.setString(5, cliente.getTelefono());
            ps.setString(6, cliente.getCorreo());
            ps.setString(7, cliente.getDireccion());
            ps.setString(8, cliente.getRuc());
            int res = ps.executeUpdate();
            if (res > 0) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar a la persona");
            }

        } catch (Exception e) {
            System.out.print(e);

        } finally {
            try {
                con.close();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;

    }

    @Override
    public ArrayList<ClienteDTO> Read() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = conexion.getConection();
      
        ArrayList<ClienteDTO> clientes = new ArrayList<>();

        try {
            ps = con.prepareStatement("SELECT * FROM Clientes");
            rs = ps.executeQuery();

         
            while (rs.next()) {
                int id = rs.getInt("idClientes");
                String dni = rs.getString("dni");
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                String genero = rs.getString("genero");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                String direccion = rs.getString("direccion");
                String ruc = rs.getString("ruc");
                cliente = new ClienteDTO(id, direccion, ruc, dni, nombres, apellidos, genero, telefono, correo);
                clientes.add(cliente);
            }
          
          

        } catch (Exception e) {
            System.out.println(e);

        } finally {
            try {
                con.close();
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return clientes;
    }

    @Override
    public boolean Update(ClienteDTO cliente) {
        Connection con = conexion.getConection();
        PreparedStatement ps = null;
        boolean isUpdate = false;

        try {

            ps = con.prepareStatement("UPDATE Clientes SET nombres=?, apellidos=?, genero=?, telefono=?, correo=?, direccion=?, ruc=? WHERE dni="+ cliente.getDni());

           
            ps.setString(1, cliente.getNombres());
            ps.setString(2, cliente.getApellidos());
            ps.setString(3, cliente.getGenero());
            ps.setString(4, cliente.getTelefono());
            ps.setString(5, cliente.getCorreo());
            ps.setString(6, cliente.getDireccion());
            ps.setString(7, cliente.getRuc());
            
            int res = ps.executeUpdate();
            if (res>0){
            isUpdate = true;
            }

        } catch (SQLException e) {
            System.err.println(e);
            isUpdate = false;

        } finally {
            try {
                con.close();
                ps.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return isUpdate;
    }

    @Override
    public boolean Delete(ClienteDTO cliente) {

        PreparedStatement ps = null;
        Connection con = conexion.getConection();
        boolean isDelete = false;
        try {

            ps = con.prepareStatement("DELETE FROM Clientes WHERE dni=?");
            ps.setString(1, cliente.getDni());
            int res = ps.executeUpdate();

            if (res > 0) {
                isDelete = true;
            }

        } catch (SQLException e) {
            System.err.println(e);
            isDelete = false;

        } finally {
            try {
                con.close();
                ps.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return isDelete;

    }

    @Override
    public ClienteDTO Search(ClienteDTO clie) {
        Connection con = conexion.getConection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {

            ps = con.prepareStatement("SELECT * FROM Clientes WHERE dni=? or ruc=?");
            ps.setString(1, clie.getDni());
            ps.setString(2, clie.getRuc());
            rs = ps.executeQuery();

            if (rs.next()) {

                int id = rs.getInt("idClientes");
                String dni = rs.getString("dni");
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                String genero = rs.getString("genero");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                String direccion = rs.getString("direccion");
                String ruc = rs.getString("ruc");
                cliente = new ClienteDTO(id, direccion,ruc, dni, nombres, apellidos, genero, telefono, correo);
                
            } 

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            try {
                con.close();
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return cliente;
    }
    
    public ArrayList<ClienteDTO> BusquedaInteligente(String busqueda) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = conexion.getConection();
      
        ArrayList<ClienteDTO> clientes = new ArrayList<>();

        try {
            ps = con.prepareStatement("SELECT * FROM Clientes WHERE dni LIKE '%" +busqueda +"%' OR nombres LIKE '%" + busqueda + "%' OR apellidos LIKE '%"+ busqueda+ "%' OR genero LIKE '%" + busqueda + "%' OR telefono LIKE '%" + busqueda +"%' OR correo LIKE '%" + busqueda + "%' OR direccion LIKE '%"+ busqueda +"%'" );
            rs = ps.executeQuery();

         
            while (rs.next()) {
                int id = rs.getInt("idClientes");
                String dni = rs.getString("dni");
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                String genero = rs.getString("genero");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                String direccion = rs.getString("direccion");
                String ruc = rs.getString("ruc");
                cliente = new ClienteDTO(id, direccion, ruc, dni, nombres, apellidos, genero, telefono, correo);
                clientes.add(cliente);
            }
          
          

        } catch (Exception e) {
            System.out.println(e);

        } finally {
            try {
                con.close();
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return clientes;
    }
    
    public Vector<ClienteDTO> MostarCorreos() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = conexion.getConection();
        cliente  = null;
        Vector<ClienteDTO> clientes = new Vector<>();

        try {
            ps = con.prepareStatement("SELECT * FROM Clientes");
            rs = ps.executeQuery();

         
            while (rs.next()) {
                int id = rs.getInt("idClientes");
                String dni = rs.getString("dni");
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                String genero = rs.getString("genero");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                String direccion = rs.getString("direccion");
                String ruc = rs.getString("ruc");
                cliente = new ClienteDTO(id, direccion, ruc, dni, nombres, apellidos, genero, telefono, correo);
                clientes.add(cliente);
            }
          
          

        } catch (Exception e) {
            System.out.println(e);

        } finally {
            try {
                con.close();
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return clientes;
    }

}
