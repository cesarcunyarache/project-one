/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import DataSource.Conexion;
import TransferObject.ProductoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import TransferObject.ClienteDTO;

/**
 *
 * @author cesarcunyarache
 */
public class ProductosDAO implements DAO<ProductoDTO> {

    Conexion conexion;
    ProductoDTO producto;
    public ProductosDAO() {
        conexion = new Conexion();
    }

    @Override
    public boolean Create(ProductoDTO p) {
        PreparedStatement ps = null;
        Connection con = conexion.getConection();
        try {

            ps = con.prepareStatement("INSERT INTO Productos (descripcion, precio, stock, estado, idCategoria) VALUES (?,?,?,?,?)");

            ps.setString(1, p.getDescripcion());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getStock());
            ps.setString(4, p.getEstado());
            ps.setInt(5, p.getIdcategoria());

            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;

        } finally {
            try {
                con.close();
                con.close();
                ps.close();

            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }

    @Override
    public ArrayList<ProductoDTO> Read() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = conexion.getConection();
        ProductoDTO producto;
        ArrayList<ProductoDTO> productos = new ArrayList<>();

        try {
            ps = con.prepareStatement("SELECT * FROM Productos");
            rs = ps.executeQuery();

            while (rs.next()) {
                int codigo = rs.getInt("idProducto");
                String descripcion = rs.getString("descripcion");
                double precio = rs.getDouble("precio");
                int stock = rs.getInt("stock");
                String estado = rs.getString("estado");
                int idCategoria = rs.getInt("idCategoria");

                producto = new ProductoDTO(codigo, descripcion, precio, stock, estado, idCategoria);
                productos.add(producto);
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
        return productos;
    }

    @Override
    public boolean Update(ProductoDTO producto) {
        Connection con = conexion.getConection();
        PreparedStatement ps = null;
        boolean isUpdate = false;

        try {

            ps = con.prepareStatement("UPDATE Productos SET  descripcion=?, precio=?, stock=? , estado=? ,idCategoria=? WHERE idProducto=?");

            
            ps.setString(1, producto.getDescripcion());
            ps.setDouble(2, producto.getPrecio());
            ps.setInt(3, producto.getStock());
       
            ps.setString(4, producto.getEstado());
            ps.setInt(5, producto.getIdcategoria());
            ps.setInt(6, producto.getCodigo());
            int res = ps.executeUpdate();
            if (res > 0) {
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
    public boolean Delete(ProductoDTO producto) {
        PreparedStatement ps = null;
        Connection con = conexion.getConection();
        boolean isDelete = false;
        try {

            ps = con.prepareStatement("DELETE FROM Productos WHERE idProducto=?");
            ps.setInt(1, producto.getCodigo());
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
    public ProductoDTO Search(ProductoDTO p) {
        Connection con = conexion.getConection();
        PreparedStatement ps = null;
        ResultSet rs = null;
       
        try {

            ps = con.prepareStatement("SELECT * FROM Productos WHERE idProducto=?");
            ps.setInt(1, p.getCodigo());
            rs = ps.executeQuery();

            if (rs.next()) {

//                String id = rs.getString("Id");
                int codigo = rs.getInt("idProducto");
                String descripcion = rs.getString("descripcion");
                double precio = rs.getDouble("precio");
                int stock = rs.getInt("stock");
                String estado = rs.getString("estado");
                int idCategoria = rs.getInt("idCategoria");

                producto = new ProductoDTO(codigo, descripcion, precio, stock, estado, idCategoria);

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

        return producto;
    }

    public boolean RestarStock(int id, int cantidad) {
        Connection con = conexion.getConection();
        PreparedStatement ps = null;
        boolean isUpdate = false;

        try {

            ps = con.prepareStatement("CALL RESTARSTOCK (?, ?)");

            ps.setInt(1, id);
            ps.setInt(2, cantidad);

            int res = ps.executeUpdate();
            if (res > 0) {
                isUpdate = true;
            } else {
                isUpdate = false;
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

    public Vector<String> mostrarProduct() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = conexion.getConection();

        Vector<String> datos = new Vector<>();
        String dat = null;
        try {

            ps = con.prepareStatement("SELECT * FROM Productos");
            rs = ps.executeQuery();

            dat = new String();
            dat = ("-Selecciona Productos-");
            datos.add(dat);

            while (rs.next()) {
                dat = new String();
                dat = (rs.getString("descripcion"));
                datos.add(dat);
            }

        } catch (SQLException ex) {
            System.err.println("Error consulta :" + ex.getMessage());
        } finally {
            try {
                con.close();
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductosDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return datos;
    }

    public Vector<ProductoDTO> mostrarProductos() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conexion.getConection();

        Vector<ProductoDTO> datos = new Vector<ProductoDTO>();
        
        try {

            String sql = "SELECT * FROM Productos";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            String desc = "-Seleccione Producto-";
            producto = new ProductoDTO(desc);
            datos.add(producto);

            while (rs.next()) {

                int codigo = rs.getInt("idProducto");
                String descripcion = rs.getString("descripcion");
                double precio = rs.getDouble("precio");
                int stock = rs.getInt("stock");
                String estado = rs.getString("estado");
                int idCategoria = rs.getInt("idCategoria");

                producto = new ProductoDTO(codigo, descripcion, precio, stock, estado, idCategoria);
                datos.add(producto);
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("Error consulta :" + ex.getMessage());
        }
        return datos;
    }

    public Vector<ProductoDTO> mostrarProd(int idCategoria) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = conexion.getConection();

        Vector<ProductoDTO> datos = new Vector<>();
        

        try {

            String sql = "SELECT * FROM Productos WHERE idCategoria=" + idCategoria;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            producto = new ProductoDTO();

            producto.setDescripcion("-Seleccionar Producto-");
            datos.add(producto);

            while (rs.next()) {
                producto = new ProductoDTO();
                producto.setCodigo(rs.getInt("idProducto"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));
                producto.setIdcategoria(rs.getInt("idCategoria"));
                datos.add(producto);
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("Error consulta :" + ex.getMessage());
        }
        return datos;
    }

}
