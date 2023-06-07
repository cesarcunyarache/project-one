/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TransferObject;

/**
 *
 * @author cesarcunyarache
 */
public class ItemDTO {
   private ProductoDTO producto;
   private double importe;
   private int cantidad;

    public ItemDTO(ProductoDTO producto, int cantidad) {
        this.producto = producto;
        this.cantidad =  cantidad;
        importe = 0;
        
    }

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    

    public void CalcularImporte(){
        importe += cantidad * producto.getPrecio(); 
    }

   
   
}
