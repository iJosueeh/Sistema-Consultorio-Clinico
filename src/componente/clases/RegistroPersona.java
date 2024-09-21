/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componente.clases;

/**
 *
 * @author Josue
 */
public class RegistroPersona {

    private String nombreCompleto;
    private String genero;
    private String edad;
    private String dni;
    private String nacionalidad;
    private String telefono;
    private String email;
    private String estadoCivil;
    
    public RegistroPersona(String nombreCompleto, String genero, String edad, String dni, String nacionalidad, String telefono, String email, String estadoCivil) {
        this.nombreCompleto = nombreCompleto;
        this.genero = genero;
        this.edad = edad;
        this.dni = dni;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.email = email;
        this.estadoCivil = estadoCivil;
    }
    
        public Object[] toArray() {
        Object[] obj = new Object[8];

        obj[0] = nombreCompleto;
        obj[1] = genero;
        obj[2] = edad;
        obj[3] = dni;
        obj[4] = nacionalidad;
        obj[5] = telefono;
        obj[6] = email;
        obj[7] = estadoCivil;

        return obj;
    }
    
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

}
