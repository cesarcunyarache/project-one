package TransferObject;

import java.sql.Date;

/**
 *
 * @author cesarcunyarache
 */
public class EmpleadoDTO extends PersonaDTO {

    private int id;
    private Date fechaNacimiento;
    private Date fechaContrato;

    public EmpleadoDTO(int id, Date feDateNacimiento, Date fechaContrato, String dni, String nombres, String apellidos, String genero, String telefono, String correo) {
        super(dni, nombres, apellidos, genero, telefono, correo);
        this.id = id;
        this.fechaNacimiento = feDateNacimiento;
        this.fechaContrato = fechaContrato;
    }

    public EmpleadoDTO(Date feDateNacimiento, Date fechaContrato, String dni, String nombres, String apellidos, String genero, String telefono, String correo) {
        super(dni, nombres, apellidos, genero, telefono, correo);
        this.fechaNacimiento = feDateNacimiento;
        this.fechaContrato = fechaContrato;
    }

    public EmpleadoDTO(String dni, String nombres, String apellidos) {
        super(dni, nombres, apellidos);
    }
    

    public EmpleadoDTO(int id) {
        this.id = id;
    }

    public EmpleadoDTO(String dni) {
        super(dni);
    }

    public EmpleadoDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date feDateNacimiento) {
        this.fechaNacimiento = feDateNacimiento;
    }

    public Date getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(Date fechaContrato) {
        this.fechaContrato = fechaContrato;
    }
    

}
