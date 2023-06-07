/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessObject;

import DataAccessObject.ClientesDAO;
import TransferObject.CategoriaDTO;
import TransferObject.ClienteDTO;
import JTable.EventAction;
import JTable.ModelAction;
import Message.Message;
import Notification.Notification;

import java.awt.Frame;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cesarcunyarache
 */
public class Cliente {

    private ClienteDTO cliente;
    private ClientesDAO crud;
    private Notification mensaje;
    private Notification mensajeError;
    private EventAction eventAction;
    private JFrame frame;

    public Cliente(JFrame frame) {
        this.frame = frame;
        crud = new ClientesDAO();

    }

    public void insertar(String dni, String nombres, String apellidos,
            String genero, String telefono, String correo, String direccion, String ruc) {

        cliente = new ClienteDTO(direccion, ruc, dni, nombres, apellidos, genero, telefono, correo);

        if (crud.Create(cliente)) {
            mensaje = new Notification("Creado correctamente", frame, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT);

        } else {
            mensajeError = new Notification("Algo salio mal",
                    frame, Notification.Type.WARNING, Notification.Location.TOP_RIGHT);

        }

    }

    public void Eliminar(String id) {

        cliente = new ClienteDTO();
        cliente.setDni(id);
        
        if (crud.Delete(cliente)) {
            mensaje = new Notification("Eliminado correctamente",
                    frame, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT);

        } else {
            mensajeError = new Notification("Algo salio mal", frame,
                    Notification.Type.WARNING, Notification.Location.TOP_RIGHT);

        }
    }

    public void Modificar(String dni, String nombres, String apellidos,
            String genero, String telefono, String correo, String direccion, String ruc) {

        cliente = new ClienteDTO(direccion, ruc, dni, nombres, apellidos, genero, telefono, correo);

        if (crud.Update(cliente)) {
            mensaje = new Notification("Modificado correctamente", frame, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT);

        } else {
            mensajeError = new Notification("Algo salio mal",
                    frame, Notification.Type.WARNING, Notification.Location.TOP_RIGHT);

        }

    }

    public ClienteDTO Buscar(String id) {
        cliente = new ClienteDTO();
        cliente.setDni(id);
        cliente.setRuc(id);
        ClienteDTO c = crud.Search(cliente);

        if (c != null) {
            return c;
        } else {
            return null;
        }

    }
    
    public ArrayList<ClienteDTO> listar (){
        ArrayList<ClienteDTO> lista = crud.Read();
        
        if(lista!=null){
            return lista;
        } else {
            return null;
        }
    }
    
    public ArrayList<ClienteDTO> BusquedaInteligente (String busqueda){
        ArrayList<ClienteDTO> lista = crud.BusquedaInteligente(busqueda);
        if(lista!=null){
            return lista;
        } else {
            return null;
        }
    }
    public Vector<ClienteDTO> MostrarCorreos(){
        Vector<ClienteDTO> vector = crud.MostarCorreos();
        
        if (vector!= null){
            return vector;
        } else {
            return null;
        }
    }

}
