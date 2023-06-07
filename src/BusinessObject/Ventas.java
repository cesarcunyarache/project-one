/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessObject;

import DataAccessObject.ProductosDAO;
import DataAccessObject.VentasDAO;
import JTable.EventAction;
import Notification.Notification;
import TransferObject.ProductoDTO;
import TransferObject.VentaDTO;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author cesarcunyarache
 */
public class Ventas {
    
    private VentaDTO venta;
    private VentasDAO crud;
    private Notification mensaje;
    private Notification mensajeError;
    private EventAction eventAction;
    private JFrame frame;

    public Ventas(JFrame frame) {
        this.frame = frame;
        crud = new VentasDAO();
    }

    
    public void insertar(int id, Date fecha, String tipo, double total) {

        venta = new VentaDTO(id, fecha, tipo, total);
        if (crud.Create(venta)) {
            mensaje = new Notification("Creado correctamente", frame, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT);

        } else {
            mensajeError = new Notification("Algo salio mal",
                    frame, Notification.Type.WARNING, Notification.Location.TOP_RIGHT);

        }

    }

    public void Eliminar(int id) {

        venta = new VentaDTO();
        venta.setId(id);
        if (crud.Delete(venta)) {
            mensaje = new Notification("Eliminado correctamente",
                    frame, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT);

        } else {
            mensajeError = new Notification("Algo salio mal", frame,
                    Notification.Type.WARNING, Notification.Location.TOP_RIGHT);

        }
    }

    public void Modificar(int id,Date fecha, String tipo, double total) {

        venta = new VentaDTO(id, fecha, tipo, total);
        if (crud.Update(venta)) {
            mensaje = new Notification("Modificado correctamente", frame, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT);

        } else {
            mensajeError = new Notification("Algo salio mal",
                    frame, Notification.Type.WARNING, Notification.Location.TOP_RIGHT);

        }

    }

    public VentaDTO Buscar(int id) {
        VentaDTO p= null;
        p.setId(id);
        p = crud.Search(p);

        if (p != null) {
            return p;
        } else {
            return null;
        }

    }

    public ArrayList<VentaDTO> lista() {
        
        ArrayList<VentaDTO> lista = crud.Read();
        
        if (lista!= null){
            return lista;
            
        } else {
            mensajeError = new Notification("No hay datos!",
                    frame, Notification.Type.WARNING, Notification.Location.TOP_RIGHT);
            return null;
        }
            
    }
    public int IdVenta(){
        return crud.getIdVenta();
    }

    
}
