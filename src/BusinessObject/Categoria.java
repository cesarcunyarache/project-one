/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessObject;

import DataAccessObject.CategoriaDAO;
import TransferObject.CategoriaDTO;
import Notification.Notification;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFrame;

/**
 *
 * @author cesarcunyarache
 */
public class Categoria {

    private CategoriaDTO categoria;
    private CategoriaDAO categ;
    private JFrame frame;
    private Notification mensaje;
    private Notification mensajeError;

    public Categoria(JFrame frame) {
        this.frame = frame;
        categ = new CategoriaDAO();

    }

    public void crear(String dato) {

        categoria = new CategoriaDTO(dato);

        if (categ.Create(categoria)) {
            mensaje = new Notification("Creado correctamente", frame, Notification.Type.SUCCESS,
                    Notification.Location.TOP_RIGHT);

        } else {
            mensajeError = new Notification("Algo salio mal",
                    frame, Notification.Type.WARNING, Notification.Location.TOP_RIGHT);
        }

    }

    public void eliminar(int id) {
        
        categoria = new CategoriaDTO(id);
        if (categ.Delete(categoria)) {
            mensaje = new Notification("Eliminado correctamente", frame, Notification.Type.SUCCESS,
                    Notification.Location.TOP_RIGHT);
        } else {
            mensajeError = new Notification("Algo salio mal",
                    frame, Notification.Type.WARNING, Notification.Location.TOP_RIGHT);
        }

    }

    public void actualizar(int id, String dato) {

        categoria = new CategoriaDTO(id, dato);
        if (categ.Update(categoria)) {
             mensaje = new Notification("Actualizado correctamente", frame, Notification.Type.SUCCESS,
                    Notification.Location.TOP_RIGHT);

        } else {
            mensajeError = new Notification("Algo salio mal",
                    frame, Notification.Type.WARNING, Notification.Location.TOP_RIGHT);
        }
    }
    
    
    public CategoriaDTO Buscar(int id){
        categoria = new CategoriaDTO(id);
        CategoriaDTO cat = categ.Search(categoria);
        
        if(cat!=null){
            return cat;
        } else {
            return null;
        }
        
    }
    
    public ArrayList<CategoriaDTO> listar(){
        ArrayList<CategoriaDTO> lista = categ.Read();
        
        if(lista!=null){
            return lista;
        } else {
            return null;
        }
    }
            

    public Vector<CategoriaDTO> mostrarCategoria() {
        
        Vector <CategoriaDTO> vector= categ.mostrarCategoria();
        
        if(vector!= null){
            return vector;
        } else {
            mensajeError = new Notification("No exiten datos",
                    frame, Notification.Type.WARNING, Notification.Location.TOP_RIGHT);
            return null;
        }
    }

}
