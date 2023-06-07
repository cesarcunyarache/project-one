/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TransferObject;

import JTable.EventAction;
import JTable.ModelAction;
import java.text.DecimalFormat;

/**
 *
 * @author cesarcunyarache
 */
public class CategoriaDTO {
    int id;
    String categoria;
    

    public CategoriaDTO(String categoria) {
        this.categoria = categoria;
    }

    public CategoriaDTO(int id, String categoria) {
        this.id = id;
        this.categoria = categoria;
       
    }

    public CategoriaDTO(int id) {
        this.id = id;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return categoria;
    }

    
//   public Object[] toRowTable(EventAction event) {
//        DecimalFormat df = new DecimalFormat("$#,##0.00");
//        return new Object[]{ id, categoria, new ModelAction<Categoria>(this, event)};
//    }
    
    
}
