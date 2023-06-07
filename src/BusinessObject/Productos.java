/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessObject;

import DataAccessObject.ClientesDAO;
import DataAccessObject.ProductosDAO;
import JTable.EventAction;
import Notification.Notification;
import TransferObject.ClienteDTO;
import TransferObject.ProductoDTO;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author cesarcunyarache
 */
public class Productos {

    private ProductoDTO producto;
    private ProductosDAO crud;
    private Notification mensaje;
    private Notification mensajeError;
    private EventAction eventAction;
    private JFrame frame;

    public Productos(JFrame frame) {
        this.frame = frame;
        crud = new ProductosDAO();
    }

    public void insertar(String descripcion, double precio, int stock, String estado, int idCategoria) {
        producto = new ProductoDTO(descripcion, precio, stock, estado, idCategoria);
        if (crud.Create(producto)) {
            mensaje = new Notification("Creado correctamente", frame, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT);
        } else {
            mensajeError = new Notification("Algo salio mal",
                    frame, Notification.Type.WARNING, Notification.Location.TOP_RIGHT);
        }
    }

    public void Eliminar(int id) {
        producto = new ProductoDTO(id);
        if (crud.Delete(producto)) {
            mensaje = new Notification("Eliminado correctamente",
                    frame, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT);
        } else {
            mensajeError = new Notification("Algo salio mal", frame,
                    Notification.Type.WARNING, Notification.Location.TOP_RIGHT);
        }
    }

    public void Modificar(int id, String descripcion, double precio, int stock, String estado, int idCategoria) {
        producto = new ProductoDTO(id, descripcion, precio, stock, estado, idCategoria);
        if (crud.Update(producto)) {
            mensaje = new Notification("Modificado correctamente", frame, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT);
        } else {
            mensajeError = new Notification("Algo salio mal",
                    frame, Notification.Type.WARNING, Notification.Location.TOP_RIGHT);
        }
    }

    public ProductoDTO Buscar(int id) {
        producto = new ProductoDTO(id);
        ProductoDTO p = crud.Search(producto);
        if (p != null) {
            return p;
        } else {
            return null;
        }

    }

    public ArrayList<ProductoDTO> lista() {
        ArrayList<ProductoDTO> lista = crud.Read();
        if (lista != null) {
            return lista;
        } else {
            mensajeError = new Notification("No hay datos!",
                    frame, Notification.Type.WARNING, Notification.Location.TOP_RIGHT);
            return null;
        }
    }

}
