/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessObject;

import DataAccessObject.ClientesDAO;
import DataAccessObject.EmpleadoDAO;
import JTable.EventAction;
import Notification.Notification;
import TransferObject.ClienteDTO;
import TransferObject.EmpleadoDTO;
import TransferObject.ProductoDTO;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author cesarcunyarache
 */
public class Empleados {
    private EmpleadoDTO empleado;
    private EmpleadoDAO crud;
    private Notification mensaje;
    private Notification mensajeError;
    private EventAction eventAction;
    private JFrame frame;

    public Empleados(JFrame frame) {
        this.frame = frame;
        crud = new EmpleadoDAO();

    }

    public void insertar(Date fechaNacimiento, Date fechaContrato, String dni, String nombres, String apellidos, String genero, String telefono, String correo) {

        empleado = new EmpleadoDTO(fechaNacimiento, fechaContrato, dni, nombres, apellidos, genero, telefono, correo);

        if (crud.Create(empleado)) {
            mensaje = new Notification("Creado correctamente", frame, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT);

        } else {
            mensajeError = new Notification("Algo salio mal",
                    frame, Notification.Type.WARNING, Notification.Location.TOP_RIGHT);

        }

    }

    public void Eliminar(String id) {

        EmpleadoDTO emp = new EmpleadoDTO(id);
        
        if (crud.Delete(emp)) {
            mensaje = new Notification("Eliminado correctamente",
                    frame, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT);

        } else {
            mensajeError = new Notification("Algo salio mal", frame,
                    Notification.Type.WARNING, Notification.Location.TOP_RIGHT);

        }
    }

    public void Modificar(Date fechaNacimiento, Date fechaContrato, String dni, String nombres, String apellidos, String genero, String telefono, String correo) {

        empleado = new EmpleadoDTO(fechaNacimiento, fechaContrato, dni, nombres, apellidos, genero, telefono, correo);

        if (crud.Update(empleado)) {
            mensaje = new Notification("Modificado correctamente", frame, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT);

        } else {
            mensajeError = new Notification("Algo salio mal",
                    frame, Notification.Type.WARNING, Notification.Location.TOP_RIGHT);

        }

    }

    public EmpleadoDTO Buscar(String id) {
        empleado = new EmpleadoDTO(id);
        EmpleadoDTO e = crud.Search(empleado);

        if (e != null) {
            return e;
        } else {
            return null;
        }

    }
    
    
    public EmpleadoDTO Buscar (int id ){
        empleado = new EmpleadoDTO(id);
        EmpleadoDTO e = crud.Buscar(empleado);

        if (e != null) {
            return e;
        } else {
            return null;
        }
        
    }
    
    public ArrayList<EmpleadoDTO> lista() {
        ArrayList<EmpleadoDTO> lista = crud.Read();
        if (lista != null) {
           return lista;
        } else {
            mensajeError = new Notification("No hay datos!",
                    frame, Notification.Type.WARNING, Notification.Location.TOP_RIGHT);
            return null;
        }
    }
    
    public ArrayList<EmpleadoDTO> BusquedaInteligente(String busqueda) {
        ArrayList<EmpleadoDTO> lista = crud.BusquedadInteligente(busqueda);
        if (lista != null) {
           return lista;
        } else {
            mensajeError = new Notification("No hay datos!",
                    frame, Notification.Type.WARNING, Notification.Location.TOP_RIGHT);
            return null;
        }
    }
    
    
}
