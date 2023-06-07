/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TransferObject;

/**
 *
 * @author cesarcunyarache
 */
public class Proveedor {
    private int id;
    private String nombre;
    private String ruc;
    private String razonSocial;
    private String direccion;
    private String correo;
    private String telefono;

    public Proveedor(int id, String nombre, String ruc, String razonSocial, String direccion, String correo, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Proveedor(String nombre, String ruc, String razonSocial, String direccion, String correo, String telefono) {
        this.nombre = nombre;
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Proveedor(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}
