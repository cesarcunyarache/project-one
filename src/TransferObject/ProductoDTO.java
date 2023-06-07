/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TransferObject;

/**
 *
 * @author cesarcunyarache
 */
public class ProductoDTO {

    private int codigo;
    private String descripcion;
    private double precio;
    private int stock;
    private String estado;
    private int idcategoria;

    public ProductoDTO(int codigo, String descripcion, double precio, int stock, String estado, int idcategoria) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
        this.idcategoria = idcategoria;
    }

    public ProductoDTO(String descripcion, double precio, int stock, String estado, int idcategoria) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
        this.idcategoria = idcategoria;
    }


    public ProductoDTO(int codigo) {
        this.codigo = codigo;
    }

    public ProductoDTO(String descripcion) {
        this.descripcion = descripcion;
    }
    
    

    public ProductoDTO() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    

    @Override
    public String toString() {
        return this.descripcion;
    }

}
