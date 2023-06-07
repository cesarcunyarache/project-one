/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessObject;

import DataAccessObject.EmpleadoDAO;
import DataAccessObject.UsuariosDAO;
import JTable.EventAction;
import Notification.Notification;
import TransferObject.EmpleadoDTO;
import TransferObject.UsuariosDTO;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author cesarcunyarache
 */
public class Usuario {

    private UsuariosDTO usuario;
    private UsuariosDAO crud;
    private Notification mensaje;
    private Notification mensajeError;
    private EventAction eventAction;
    private JFrame frame;

    public Usuario(JFrame frame) {
        this.frame = frame;
        crud = new UsuariosDAO();

    }

    public void insertar(String user, String contraseña, String tipo, int idEmpleado) {
        usuario = new UsuariosDTO(user, contraseña, tipo, idEmpleado);
        if (crud.Create(usuario)) {
            mensaje = new Notification("Creado correctamente", frame, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT);
        } else {
            mensajeError = new Notification("Algo salio mal",
                    frame, Notification.Type.WARNING, Notification.Location.TOP_RIGHT);

        }

    }

    public void Eliminar(int id) {
        UsuariosDTO user = new UsuariosDTO(id);
        if (crud.Delete(user)) {
            mensaje = new Notification("Eliminado correctamente",
                    frame, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT);
        } else {
            mensajeError = new Notification("Algo salio mal", frame,
                    Notification.Type.WARNING, Notification.Location.TOP_RIGHT);

        }
    }

    public void Modificar(int id, String user, String contraseña, String tipo, int idEmpleado) {

        usuario = new UsuariosDTO(id, user, contraseña, tipo, idEmpleado);
        if (crud.Update(usuario)) {
            mensaje = new Notification("Modificado correctamente", frame, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT);

        } else {
            mensajeError = new Notification("Algo salio mal",
                    frame, Notification.Type.WARNING, Notification.Location.TOP_RIGHT);

        }

    }

    public UsuariosDTO Buscar(String user) {
        usuario = new UsuariosDTO(user);
        UsuariosDTO u = crud.Search(usuario);

        if (u != null) {
            return u;
        } else {
            return null;
        }

    }

    public ArrayList<UsuariosDTO> lista() {
        ArrayList<UsuariosDTO> lista = crud.Read();
        if (lista != null) {
            return lista;
        } else {
            mensajeError = new Notification("No hay datos!",
                    frame, Notification.Type.WARNING, Notification.Location.TOP_RIGHT);
            return null;
        }
    }

    public boolean ValidarUsuario(String correo, String contraseña) {

        if (crud.ValidarUsuario(correo, contraseña)) {
            return true;
        } else {
            return false;
        }

    }
}
