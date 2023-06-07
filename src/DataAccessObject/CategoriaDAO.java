/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DataAccessObject;

import TransferObject.ClienteDTO;
import DataSource.Conexion;
import TransferObject.CategoriaDTO;
import JTable.EventAction;
import JTable.ModelAction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import TransferObject.ProductoDTO;
import java.lang.invoke.MethodHandles;
import java.util.Vector;

public class CategoriaDAO implements DAO <CategoriaDTO>{

    Conexion conexion;
    CategoriaDTO categoria;
    public CategoriaDAO() {
        conexion = new Conexion();
        
    }

    
    
    @Override
    public boolean Create(CategoriaDTO c) {
        Connection con = conexion.getConection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("INSERT INTO Categoria(categoria) VALUE(?)");
            ps.setString(1, c.getCategoria());
           

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
    public ArrayList<CategoriaDTO> Read() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = conexion.getConection();
        
        ArrayList<CategoriaDTO> ct = new ArrayList<>();

        try {
            ps = con.prepareStatement("SELECT * FROM Categoria");
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idCategoria");
                String cat = rs.getString("categoria");
               

                categoria = new CategoriaDTO(id, cat);
                ct.add(categoria);
            }

        } catch (Exception e) {
            System.out.println(e);

        } 
        return ct;
    }

    @Override
    public boolean Update(CategoriaDTO c) {
        Connection con = conexion.getConection();
        PreparedStatement ps = null;
        boolean isUpdate = false;
        try {
            ps = con.prepareStatement("UPDATE Categoria SET categoria=?  WHERE idCategoria=?");

            ps.setString(1, c.getCategoria());
            ps.setInt(2, c.getId());
           
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
    public boolean Delete(CategoriaDTO categoria) {
        PreparedStatement ps = null;
        Connection con = conexion.getConection();
        boolean isDelete = false;
        try {

            ps = con.prepareStatement("DELETE FROM Categoria WHERE idCategoria=?");
            ps.setInt(1, categoria.getId());
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
    public CategoriaDTO Search(CategoriaDTO ca) {
        Connection con = conexion.getConection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        categoria = null;
        try {

            ps = con.prepareStatement("SELECT * FROM Categoria WHERE idCategoria=?");
            ps.setInt(1, ca.getId());
            rs = ps.executeQuery();

            if (rs.next()) {
                
                int id = rs.getInt("id");  
                String descripcion = rs.getString("categoria");
                

                categoria = new CategoriaDTO(id, descripcion);

            } else {
                JOptionPane.showMessageDialog(null, " No existe ");
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

        return categoria;
    
       
       
    }
    
    
    public ArrayList<ModelAction> leer(EventAction event){
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = conexion.getConection();
        categoria = null;
        ModelAction model;
        ArrayList<ModelAction> ct = new ArrayList<>();

        try {
            ps = con.prepareStatement("SELECT * FROM Categoria ");
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idCategoria");
                String cat = rs.getString("categoria");

                categoria = new CategoriaDTO(id, cat);
                model = new ModelAction(categoria, event);
                ct.add(model);
            }

        } catch (Exception e) {
            System.out.println(e);

        } 
        return ct;
        
    } 
    
     public Vector<CategoriaDTO> mostrarCategoria() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conexion.getConection();

        Vector<CategoriaDTO> datos = new Vector<>();
        CategoriaDTO dat = null;
        try {

            String sql = "SELECT * FROM Categoria";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            
            
            String desc = "-Seleccione Categoria-";
            dat = new CategoriaDTO(desc);
            datos.add(dat);
           

            while (rs.next()) {
                int id = rs.getInt("idCategoria");
                String categoria = rs.getString("categoria");
                dat = new CategoriaDTO(id, categoria);
                datos.add(dat);
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("Error consulta :" + ex.getMessage());
        }
        return datos;
    }
    
    
    
  

}