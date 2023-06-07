/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import DataSource.Conexion;
import TransferObject.ClienteDTO;
import TransferObject.ProductoDTO;
import TransferObject.VentaDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author cesarcunyarache
 */
public class VentasDAO implements DAO<VentaDTO> {

    Conexion conexion;
    VentaDTO venta;
    public VentasDAO() {
        conexion = new Conexion();
    }

    @Override
    public boolean Create(VentaDTO venta) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = conexion.getConection();
        try {

            ps = con.prepareStatement("INSERT INTO Ventas (idCliente, fecha, tipo, total) VALUES (?,?,?,?)");

            //ps.setInt(1, venta.getId());
            ps.setInt(1, venta.getIdCliente());
            ps.setDate(2, (Date) venta.getFecha());
            ps.setString(3, venta.getTipo());
            ps.setDouble(4, venta.getTotal());

            ps.execute();

            ps = con.prepareStatement("SELECT LAST_INSERT_ID()");
            rs = ps.executeQuery();

            if (rs.next()) {
                idVenta = rs.getInt("LAST_INSERT_ID()");
                System.out.println(idVenta);
            }
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
    public ArrayList<VentaDTO> Read() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = conexion.getConection();
        
        ArrayList<VentaDTO> ventas = new ArrayList<>();

        try {
            ps = con.prepareStatement("SELECT * FROM Ventas");
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idVenta");
                int idCliente = rs.getInt("idCliente");
                Date fecha = rs.getDate("fecha");
                String tipo = rs.getString("tipo");
                double total = rs.getDouble("total");

                venta = new VentaDTO(id, idCliente, fecha, tipo, total);
                ventas.add(venta);

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
        return ventas;
    }

    @Override
    public boolean Update(VentaDTO venta) {
        Connection con = conexion.getConection();
        PreparedStatement ps = null;
        boolean isUpdate = false;

        try {

            ps = con.prepareStatement("UPDATE Ventas SET idVenta=?, idCliente=?, fecha=?, tipo=? , total=? WHERE idVenta=" + venta.getId());

            ps.setInt(1, venta.getId());
            ps.setInt(2, venta.getIdCliente());
            ps.setDate(3, venta.getFecha());
            ps.setString(4, venta.getTipo());
            ps.setDouble(5, venta.getTotal());
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
    public boolean Delete(VentaDTO venta) {
        PreparedStatement ps = null;
        Connection con = conexion.getConection();
        boolean isDelete = false;
        try {

            ps = con.prepareStatement("DELETE FROM Ventas WHERE idVenta=?");
            ps.setInt(1, venta.getId());
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
    public VentaDTO Search(VentaDTO v) {
        Connection con = conexion.getConection();
        PreparedStatement ps = null;
        ResultSet rs = null;
      
        try {

            ps = con.prepareStatement("SELECT * FROM Ventas WHERE idVenta=?");
            ps.setInt(1, v.getId());
            rs = ps.executeQuery();

            if (rs.next()) {

//                String id = rs.getString("Id");
                int id = rs.getInt("idVenta");
                int idCliente = rs.getInt("idCliente");
                Date fecha = rs.getDate("fecha");
                String tipo = rs.getString("tipo");
                double total = rs.getDouble("total");

                venta = new VentaDTO(id, idCliente, fecha, tipo, total);
                

            } else {
                System.out.println(" No existe ");
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

        return venta;
    }

    private int idVenta;

    public int getIdVenta() {
        return idVenta;
    }

}
