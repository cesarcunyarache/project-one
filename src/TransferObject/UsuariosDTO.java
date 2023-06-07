/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TransferObject;

/**
 *
 * @author cesarcunyarache
 */
public class UsuariosDTO  {

    private int idUsuario;
    private String usuario;
    private String contraseña;
    private String tipo;
    private int idEmpleado;

    public UsuariosDTO(int idUsuario, String usuario, String contraseña, String tipo, int idEmpleado) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.tipo = tipo;
        this.idEmpleado = idEmpleado;
    }

    public UsuariosDTO(String usuario, String contraseña, String tipo, int idEmpleado) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.tipo = tipo;
        this.idEmpleado = idEmpleado;
    }
    
    

    public UsuariosDTO(String usuario, String contraseña, String tipo) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.tipo = tipo;
    }

    public UsuariosDTO(String usuario) {
        this.usuario = usuario;
    }


    public UsuariosDTO(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public UsuariosDTO() {
    }

  


    
    public void Asignar (String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    
    

   

   

}
