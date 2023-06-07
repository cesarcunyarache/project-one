/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import DataSource.Conexion;
import TransferObject.EmpleadoDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cesarcunyarache
 */
public class EmpleadoDAO implements DAO<EmpleadoDTO> {

    Conexion conexion;
    EmpleadoDTO empleado;
    public EmpleadoDAO() {
        conexion = new Conexion();
    }

    @Override
    public boolean Create(EmpleadoDTO empleado) {

        Connection con = conexion.getConection();
        PreparedStatement ps = null;
        boolean isCreate = false;
        try {
            ps = con.prepareStatement("INSERT INTO Empleados (dni, nombres, apellidos, genero, telefono, correo, fechaNacimiento, fechaContrato) VALUES (?,?,?,?,?,?,?,?)");
            ps.setString(1, empleado.getDni());
            ps.setString(2, empleado.getNombres());
            ps.setString(3, empleado.getApellidos());
            ps.setString(4, empleado.getGenero());
            ps.setString(5, empleado.getTelefono());
            ps.setString(6, empleado.getCorreo());
            ps.setDate(7, empleado.getFechaNacimiento());
            ps.setDate(8, empleado.getFechaContrato());
            int rs = ps.executeUpdate();

            if (rs > 0) {
                isCreate = true;
            } else {
                isCreate = false;
            }
        } catch (Exception e) {
            System.out.println(e);
            isCreate = false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return isCreate;
    }

    @Override
    public ArrayList<EmpleadoDTO> Read() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = conexion.getConection();
        ArrayList<EmpleadoDTO> emp = new ArrayList<>();

        try {
            ps = con.prepareStatement("SELECT * FROM Empleados");
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idEmpleados");
                String dni = rs.getString("dni");
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                String genero = rs.getString("genero");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                Date fechaN = rs.getDate("fechaNacimiento");
                Date fecha = rs.getDate("fechaContrato");
                empleado = new EmpleadoDTO(id, fechaN, fecha, dni, nombres, apellidos, genero, telefono, correo);
                emp.add(empleado);
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
        return emp;
    }

    @Override
    public boolean Update(EmpleadoDTO empleado) {
        Connection con = conexion.getConection();
        PreparedStatement ps = null;
        boolean isUpdate = false;

        try {

            ps = con.prepareStatement("UPDATE Empleados SET nombres=?, apellidos=?, genero=?, telefono=?, correo=?, fechaNacimiento=?, fechaContrato=? WHERE dni=?");

            ps.setString(1, empleado.getNombres());
            ps.setString(2, empleado.getApellidos());
            ps.setString(3, empleado.getGenero());
            ps.setString(4, empleado.getTelefono());
            ps.setString(5, empleado.getCorreo());
            ps.setDate(6, empleado.getFechaNacimiento());
            ps.setDate(7, empleado.getFechaContrato());
            ps.setString(8, empleado.getDni());

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
    public boolean Delete(EmpleadoDTO empleado) {
        PreparedStatement ps = null;
        Connection con = conexion.getConection();
        boolean isDelete = false;
        try {

            ps = con.prepareStatement("DELETE FROM Empleados WHERE dni=?");
            ps.setString(1, empleado.getDni());
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
    public EmpleadoDTO Search(EmpleadoDTO emp) {
        Connection con = conexion.getConection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {

            ps = con.prepareStatement("SELECT * FROM Empleados WHERE dni=?");
            ps.setString(1, emp.getDni());
            rs = ps.executeQuery();

            if (rs.next()) {

                int id = rs.getInt("idEmpleados");
                String dni = rs.getString("dni");
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                String genero = rs.getString("genero");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                Date fechaN = rs.getDate("fechaNacimiento");
                Date fecha = rs.getDate("fechaContrato");

                empleado = new EmpleadoDTO(id, fechaN, fecha, dni, nombres, apellidos, genero, telefono, correo);

            }

        } catch (SQLException ex) {
            System.err.println(ex);
        } finally {
            try {
                con.close();
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return empleado;
    }
    
    
    public EmpleadoDTO Buscar(EmpleadoDTO emp) {
        Connection con = conexion.getConection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {

            ps = con.prepareStatement("SELECT * FROM Empleados WHERE idEmpleados=?");
            ps.setInt(1, emp.getId());
            rs = ps.executeQuery();

            if (rs.next()) {

                int id = rs.getInt("idEmpleados");
                String dni = rs.getString("dni");
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                String genero = rs.getString("genero");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                Date fechaN = rs.getDate("fechaNacimiento");
                Date fecha = rs.getDate("fechaContrato");

                empleado = new EmpleadoDTO(id, fechaN, fecha, dni, nombres, apellidos, genero, telefono, correo);

            }

        } catch (SQLException ex) {
            System.err.println(ex);
        } finally {
            try {
                con.close();
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return empleado;
    }
    
    public ArrayList<EmpleadoDTO> BusquedadInteligente(String busqueda){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = conexion.getConection();
        ArrayList<EmpleadoDTO> emp = new ArrayList<>();

        try {
            ps = con.prepareStatement("SELECT * FROM Empleados WHERE dni LIKE '%" +busqueda +"%' OR nombres LIKE '%" + busqueda + "%' OR apellidos LIKE '%"+ busqueda+ "%' OR genero LIKE '%" + busqueda + "%' OR telefono LIKE '%" + busqueda +"%' OR correo LIKE '%" + busqueda + "%'" );
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idEmpleados");
                String dni = rs.getString("dni");
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                String genero = rs.getString("genero");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                Date fechaN = rs.getDate("fechaNacimiento");
                Date fecha = rs.getDate("fechaContrato");
                empleado = new EmpleadoDTO(id, fechaN, fecha, dni, nombres, apellidos, genero, telefono, correo);
                emp.add(empleado);
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
        return emp;
        
    }

}
