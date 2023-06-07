/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package TransferObject;

import java.util.ArrayList;

/**
 *
 * @author cesarcunyarache
 */
public class DetalleDTO {

    private int idVenta;
    private int idProducto;
    private int cantidad;
    private double importe;

    public DetalleDTO(int idVenta, int idProducto, int cantidad, double importe) {
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.importe = importe;
    }

    public DetalleDTO() {
    }

    public DetalleDTO(int idVenta) {
        this.idVenta = idVenta;
    }
    
    

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }


}
