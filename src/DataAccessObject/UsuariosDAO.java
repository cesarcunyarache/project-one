package DataAccessObject;

import DataSource.Conexion;
import TransferObject.ClienteDTO;
import TransferObject.Encriptacion;
import TransferObject.UsuariosDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UsuariosDAO implements DAO<UsuariosDTO> {

    Encriptacion encriptar;
    Conexion conexion;
    UsuariosDTO usuario;

    public UsuariosDAO() {
        conexion = new Conexion();
        encriptar = new Encriptacion();
    }

    public boolean Create(UsuariosDTO persona) {
        Connection con = conexion.getConection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("INSERT INTO Usuarios( usuario, contraseña, tipo, idEmpleado) VALUE(?,?,?,?)");

            ps.setString(1, persona.getUsuario());
            ps.setString(2, persona.getContraseña());
            ps.setString(3, persona.getTipo());
            ps.setInt(4, persona.getIdEmpleado());

            int res = ps.executeUpdate();
            if (res > 0) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar a la persona");
            }

        } catch (Exception e) {
            System.out.print(e);

        }
        return false;

    }

    @Override
    public boolean Delete(UsuariosDTO usuario) {
        PreparedStatement ps = null;
        Connection con = conexion.getConection();
        boolean isDelete = false;
        try {

            ps = con.prepareStatement("DELETE FROM Usuarios WHERE idUsuarios=?");
            ps.setInt(1, usuario.getIdUsuario());
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

    public boolean ValidarUsuario(String correo, String contraseña) {
        Connection con = conexion.getConection();
        PreparedStatement ps = null;
        ResultSet res;
        boolean isValidar = false;
        try {
            ps = con.prepareStatement("SELECT *  FROM Usuarios WHERE usuario=?");
            ps.setString(1, correo);

            res = ps.executeQuery();
            if (res.next()) {
                String contra = encriptar.deecnode(res.getString("contraseña"));

                if (contra.equals(contraseña)) {
                    isValidar = true;
                } else {
                    isValidar = false;
                }

            } else {
                isValidar = false;
            }
        } catch (Exception e) {
            System.out.println(e);
            isValidar = false;
        }
        return isValidar;

    }

    @Override
    public ArrayList<UsuariosDTO> Read() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = conexion.getConection();
        
        ArrayList<UsuariosDTO> users = new ArrayList<>();

        try {
            ps = con.prepareStatement("SELECT * FROM Usuarios");
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idUsuarios");
                String user = rs.getString("usuario");
                String contraseña = rs.getString("contraseña");
                String tipo = rs.getString("tipo");
                int idEmpleado = rs.getInt("idEmpleado");

                usuario = new UsuariosDTO(id, user, contraseña, tipo, idEmpleado);
                users.add(usuario);
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
        return users;
    }

    @Override
    public boolean Update(UsuariosDTO usuario) {
        Connection con = conexion.getConection();
        PreparedStatement ps = null;
        boolean isUpdate = false;

        try {

            ps = con.prepareStatement("UPDATE Usuarios SET usuario=?, contraseña=?, tipo=?, idEmpleado=? WHERE idUsuarios=?");

            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getContraseña());
            ps.setString(3, usuario.getTipo());
            ps.setInt(4, usuario.getIdEmpleado());
            ps.setInt(5, usuario.getIdUsuario());
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
    public UsuariosDTO Search(UsuariosDTO us) {
        Connection con = conexion.getConection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {

            ps = con.prepareStatement("SELECT * FROM Usuarios WHERE usuario=?");
            ps.setString(1, us.getUsuario());
            rs = ps.executeQuery();

            if (rs.next()) {

                int id = rs.getInt("idUsuarios");
                String user = rs.getString("usuario");
                String contraseña = rs.getString("contraseña");
                String tipo = rs.getString("tipo");
                int idEmpleado = rs.getInt("idEmpleado");
                usuario = new UsuariosDTO(id, user, contraseña, tipo, idEmpleado);

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

        return usuario;
    }

}
