/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import DataSource.Conexion;
import Graphic.ModelChart;
import TransferObject.ClienteDTO;
import TransferObject.DetalleDTO;
import TransferObject.ItemDTO;
import TransferObject.ModelData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author cesarcunyarache
 */
public class DetalleVentasDAO implements DAO<DetalleDTO> {

    Conexion conexion;

    public DetalleVentasDAO() {
        conexion = new Conexion();
    }

    @Override
    public boolean Create(DetalleDTO detalle) {
        Connection con = conexion.getConection();
        PreparedStatement ps = null;
        boolean isCreate = false;
        try {
            ps = con.prepareStatement("INSERT INTO DetalleVentas(idVenta, idProducto, cantidad, importe) VALUE(?,?,?,?)");

            ps.setInt(1, detalle.getIdVenta());
            ps.setInt(2, detalle.getIdProducto());
            ps.setInt(3, detalle.getCantidad());
            ps.setDouble(4, detalle.getImporte());

            int res = ps.executeUpdate();
            if (res > 0) {
                isCreate = true;
            } else {

                System.out.println("Error al Guardar a la persona");
                isCreate = false;
            }

        } catch (Exception e) {

            System.out.print(e);
            isCreate = false;

        } finally {
            try {
                con.close();
                ps.close();
            } catch (SQLException ex) {
                isCreate = false;
                Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return isCreate;
    }

    @Override
    public ArrayList<DetalleDTO> Read() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = conexion.getConection();
        DetalleDTO detalle;
        ArrayList<DetalleDTO> detalles = new ArrayList<>();

        try {
            ps = con.prepareStatement("SELECT * FROM DetalleVentas");
            rs = ps.executeQuery();

            while (rs.next()) {
                int idVenta = rs.getInt("idVenta");
                int idProducto = rs.getInt("idProdcuto");
                int cantidad = rs.getInt("cantidad");
                double importe = rs.getDouble("importe");

                detalle = new DetalleDTO(idVenta, idProducto, cantidad, importe);
                detalles.add(detalle);
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
        return detalles;
    }

    @Override
    public boolean Update(DetalleDTO detalle) {
        Connection con = conexion.getConection();
        PreparedStatement ps = null;
        boolean isUpdate = false;

        try {

            ps = con.prepareStatement("UPDATE DetalleVentas SET idVenta=?, idProducto=?, cantidad=?, importe=? WHERE idVenta=" + detalle.getIdVenta());

            ps.setInt(1, detalle.getIdVenta());
            ps.setInt(2, detalle.getIdProducto());
            ps.setInt(3, detalle.getCantidad());
            ps.setDouble(4, detalle.getImporte());

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
    public boolean Delete(DetalleDTO detalle) {
        PreparedStatement ps = null;
        Connection con = conexion.getConection();
        boolean isDelete = false;
        try {

            ps = con.prepareStatement("DELETE FROM DetalleVentas WHERE idVenta=?");
            ps.setInt(1, detalle.getIdVenta());
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
    public DetalleDTO Search(DetalleDTO detalle) {
        Connection con = conexion.getConection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        DetalleDTO det = null;
        try {

            ps = con.prepareStatement("SELECT * FROM DetalleVentas WHERE idVenta=?");
            ps.setInt(1, detalle.getIdVenta());
            rs = ps.executeQuery();

            if (rs.next()) {

                int idVenta = rs.getInt("idVenta");
                int idProducto = rs.getInt("idProdcuto");
                int cantidad = rs.getInt("cantidad");
                double importe = rs.getDouble("importe");
                det = new DetalleDTO(idVenta, idProducto, cantidad, importe);

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

        return det;
    }

    public ArrayList<ModelData> Grafico() {
        ResultSet r = null;
        PreparedStatement p = null;
        Connection con = conexion.getConection();
        ArrayList<ModelData> lists = new ArrayList<>();
        try {

            String sql = "SELECT date_format(fecha, \"%d\") AS Dia, SUM(v.total) as Total, SUM(d.cantidad) as Cantidad, SUM(d.importe) as Importe FROM Ventas v, DetalleVentas d Group by v.fecha ORDER BY fecha DESC LIMIT 7;";
            p = con.prepareStatement(sql);
            r = p.executeQuery();
            while (r.next()) {
                String month = r.getString("Dia");
                double amount = r.getDouble("Total");
                int cost = r.getInt("Cantidad");
                double profit = r.getDouble("Importe");
                lists.add(new ModelData(month, amount, cost, profit));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                r.close();
                p.close();
            } catch (SQLException ex) {
                Logger.getLogger(DetalleVentasDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lists;

    }

}
