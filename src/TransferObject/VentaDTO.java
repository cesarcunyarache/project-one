/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TransferObject;
import java.sql.Date;
import java.util.logging.Logger;


/**
 *
 * @author cesarcunyarache
 */
public class VentaDTO {
    private int id;
    private int idCliente;
    private Date fecha;
    private String tipo;
    private double total;

    public VentaDTO(int id, int idCliente, Date fecha, String tipo, double total) {
        this.id = id;
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.tipo = tipo;
        this.total = total;
    }

    public VentaDTO(int idCliente, Date fecha, String tipo, double total) {
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.tipo = tipo;
        this.total = total;
    }
    
    

    

    public VentaDTO() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
    
    
    
}
