/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componente.clases;

/**
 *
 * @author Josue
 */
public class DiagnosticoPersona {

    String nombre;
    String fecha;
    String tipoDiag;
    String resultadoDiag;
    String medicoEnc;
    String obsDiag;

    public DiagnosticoPersona(String nombre, String fecha, String tipoDiag, String resultadoDiag, String medicoEnc, String obsDiag) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.tipoDiag = tipoDiag;
        this.resultadoDiag = resultadoDiag;
        this.medicoEnc = medicoEnc;
        this.obsDiag = obsDiag;
    }
    
        public Object[] toArray(){
        Object[] obj = new Object[6];
        
        obj[0] = nombre;
        obj[1] = fecha;
        obj[2] = tipoDiag;
        obj[3] = resultadoDiag;
        obj[4] = medicoEnc;
        obj[5] = obsDiag;
        
        return obj;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipoDiag() {
        return tipoDiag;
    }

    public void setTipoDiag(String tipoDiag) {
        this.tipoDiag = tipoDiag;
    }

    public String getResultadoDiag() {
        return resultadoDiag;
    }

    public void setResultadoDiag(String resultadoDiag) {
        this.resultadoDiag = resultadoDiag;
    }

    public String getMedicoEnc() {
        return medicoEnc;
    }

    public void setMedicoEnc(String medicoEnc) {
        this.medicoEnc = medicoEnc;
    }

    public String getObsDiag() {
        return obsDiag;
    }

    public void setObsDiag(String obsDiag) {
        this.obsDiag = obsDiag;
    }

}
