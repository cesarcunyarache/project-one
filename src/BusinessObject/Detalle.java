/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessObject;

import DataAccessObject.DetalleVentasDAO;
import DataAccessObject.VentasDAO;
import JTable.EventAction;
import Notification.Notification;
import TransferObject.DetalleDTO;
import TransferObject.ModelData;
import TransferObject.VentaDTO;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author cesarcunyarache
 */
public class Detalle {
    private DetalleDTO detalle;
    private DetalleVentasDAO crud;
    private Notification mensaje;
    private Notification mensajeError;
    private EventAction eventAction;
    private JFrame frame;

    public Detalle(JFrame frame) {
        this.frame = frame;
        crud = new DetalleVentasDAO();
    }

    
    public void insertar(int idVenta, int idProducto, int cantidad, double importe) {
        detalle = new DetalleDTO(idVenta, idProducto, cantidad, importe);
        if (crud.Create(detalle)) {
            mensaje = new Notification("Creado correctamente", frame, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT);
        } else {
            mensajeError = new Notification("Algo salio mal",
                    frame, Notification.Type.WARNING, Notification.Location.TOP_RIGHT);
        }

    }

    public void Eliminar(int id) {

        detalle = new DetalleDTO(id);
        if (crud.Delete(detalle)) {
            mensaje = new Notification("Eliminado correctamente",
                    frame, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT);

        } else {
            mensajeError = new Notification("Algo salio mal", frame,
                    Notification.Type.WARNING, Notification.Location.TOP_RIGHT);

        }
    }

    public void Modificar(int idVenta, int idProducto, int cantidad, double importe) {

        detalle = new DetalleDTO(idVenta, idProducto, cantidad, importe);
        if (crud.Update(detalle)) {
            mensaje = new Notification("Modificado correctamente", frame, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT);

        } else {
            mensajeError = new Notification("Algo salio mal",
                    frame, Notification.Type.WARNING, Notification.Location.TOP_RIGHT);

        }

    }

    public DetalleDTO Buscar(int id) {
        DetalleDTO p= new DetalleDTO(id);
        p = crud.Search(p);
        if (p != null) {
            return p;
        } else {
            return null;
        }
    }
//
    public ArrayList<DetalleDTO> lista() {
        
        ArrayList<DetalleDTO> lista = crud.Read();
        if (lista!= null){
            return lista;    
        } else {
            mensajeError = new Notification("No hay datos!",
                    frame, Notification.Type.WARNING, Notification.Location.TOP_RIGHT);
            return null;
        }
            
    }
    
    
    public ArrayList<ModelData> Grafico() {
        ArrayList<ModelData> lista = crud.Grafico();
        if (lista!= null){
            return lista;    
        } else {
            mensajeError = new Notification("No hay datos!",
                    frame, Notification.Type.WARNING, Notification.Location.TOP_RIGHT);
            return null;
        }
        
    }
}
