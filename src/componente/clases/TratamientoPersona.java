/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componente.clases;

/**
 *
 * @author Josue
 */
public class TratamientoPersona {

    private String nombreCompleto;
    private String nombreTratamiento;
    private String fechaInicial;
    private String fechaFinal;
    private String duracion;
    private String dosis;
    private String frecuencia;
    private String estadoTratamiento;
    private String medicoEncargado;
    private String observacion;

    public TratamientoPersona(String nombreCompleto, String nombreTratamiento, String fechaInicial, String fechaFinal, String duracion, String dosis, String frecuencia, String estadoTratamiento, String medicoEncargado, String observacion) {
        this.nombreCompleto = nombreCompleto;
        this.nombreTratamiento = nombreTratamiento;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.duracion = duracion;
        this.dosis = dosis;
        this.frecuencia = frecuencia;
        this.estadoTratamiento = estadoTratamiento;
        this.medicoEncargado = medicoEncargado;
        this.observacion = observacion;
    }

    public Object[] toArray() {
        Object[] obj = new Object[10];

        obj[0] = nombreCompleto;
        obj[1] = nombreTratamiento;
        obj[2] = fechaInicial;
        obj[3] = fechaFinal;
        obj[4] = duracion;
        obj[5] = dosis;
        obj[6] = frecuencia;
        obj[7] = estadoTratamiento;
        obj[8] = medicoEncargado;
        obj[9] = observacion;

        return obj;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreTratamiento() {
        return nombreTratamiento;
    }

    public void setNombreTratamiento(String nombreTratamiento) {
        this.nombreTratamiento = nombreTratamiento;
    }

    public String getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(String fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getEstadoTratamiento() {
        return estadoTratamiento;
    }

    public void setEstadoTratamiento(String estadoTratamiento) {
        this.estadoTratamiento = estadoTratamiento;
    }

    public String getMedicoEncargado() {
        return medicoEncargado;
    }

    public void setMedicoEncargado(String medicoEncargado) {
        this.medicoEncargado = medicoEncargado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
