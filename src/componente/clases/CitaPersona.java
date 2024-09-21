/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componente.clases;

/**
 *
 * @author Josue
 */
public class CitaPersona {

    String nombre;
    String apellidoPaterno;
    String apellidoMaterno;
    String edadPaciente;
    String telefonoPaciente;
    String fecha;
    String hora;

    public CitaPersona(String nombre, String apellidoPaterno, String apellidoMaterno, String edadPaciente, String telefonoPaciente, String fecha, String hora) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.edadPaciente = edadPaciente;
        this.telefonoPaciente = telefonoPaciente;
        this.fecha = fecha;
        this.hora = hora;
    }
    
    public CitaPersona(){
        
    }

    public Object[] toArray(){
        Object[] obj = new Object[7];
        
        obj[0] = nombre;
        obj[1] = apellidoPaterno;
        obj[2] = apellidoMaterno;
        obj[3] = edadPaciente;
        obj[4] = telefonoPaciente;
        obj[5] = fecha;
        obj[6] = hora;
        
        return obj;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getEdadPaciente() {
        return edadPaciente;
    }

    public void setEdadPaciente(String edadPaciente) {
        this.edadPaciente = edadPaciente;
    }

    public String getTelefonoPaciente() {
        return telefonoPaciente;
    }

    public void setTelefonoPaciente(String telefonoPaciente) {
        this.telefonoPaciente = telefonoPaciente;
    }
    
    public void setFecha(String fecha){
        this.fecha = fecha;
    }
    
    public String getFecha(){
        return fecha;
    }
    
    public void setHora(String hora){
        this.hora = hora;
    }
    
    public String getHora(){
        return hora;
    }    
}
