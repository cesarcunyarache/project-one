/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TransferObject;

/**
 *
 * @author cesarcunyarache
 */
public class ClienteDTO extends PersonaDTO {

    private int codigo;
    private String direccion;
    private String ruc;

    public ClienteDTO(int codigo, String direccion, String ruc, String dni, String nombres, String apellidos, String genero, String telefono, String correo) {
        super(dni, nombres, apellidos, genero, telefono, correo);
        this.codigo = codigo;
        this.direccion = direccion;
        this.ruc = ruc;
    }

    public ClienteDTO(String direccion, String ruc, String dni, String nombres, String apellidos, String genero, String telefono, String correo) {
        super(dni, nombres, apellidos, genero, telefono, correo);
        this.direccion = direccion;
        this.ruc = ruc;
    }

    

    public ClienteDTO(int codigo) {
        this.codigo = codigo;
    }

    public ClienteDTO(String dni) {
        super(dni);
    }


    public ClienteDTO() {
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
    
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    

}
