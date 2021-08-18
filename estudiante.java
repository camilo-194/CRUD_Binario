

import java.io.Serializable;


public class estudiante implements Serializable {
    
   
    private String nombres;
    private String apellidos;
    private String fechaNacimiento; 
    private String correoinstitucional;
    private String correopersonal;
    private long telefonocelular;
    private long telefonofijo;
    private String programa;
    

  
    
    
    
    public String getCorreoinstitucional() {
        return correoinstitucional;
    }

    public void setCorreoinstitucional(String correoinstitucional) {
        this.correoinstitucional = correoinstitucional;
    }

    public String getCorreopersonal() {
        return correopersonal;
    }

    public void setCorreopersonal(String correopersonal) {
        this.correopersonal = correopersonal;
    }

    public long getTelefonocelular() {
        return telefonocelular;
    }

    public void setTelefonocelular(long telefonocelular) {
        this.telefonocelular = telefonocelular;
    }

    public long getTelefonofijo() {
        return telefonofijo;
    }

    public void setTelefonofijo(long telefonofijo) {
        this.telefonofijo = telefonofijo;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }
   
     
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }






}
 
