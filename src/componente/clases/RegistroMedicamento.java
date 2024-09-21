/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componente.clases;

/**
 *
 * @author Josue
 */
public class RegistroMedicamento {

    private String nombreCientifico;
    private String marcaComercial;
    private String formaFarmaceutica;
    private String dosis;
    private String fechaCaducada;
    private String loteFabricada;
    private String numeroRegistros;
    private String cantidadDisponible;

    public RegistroMedicamento(String nombreCientifico, String marcaComercial, String formaFarmaceutica, String dosis, String fechaCaducada, String loteFabricada, String numeroRegistros, String cantidadDisponible) {
        this.nombreCientifico = nombreCientifico;
        this.marcaComercial = marcaComercial;
        this.formaFarmaceutica = formaFarmaceutica;
        this.dosis = dosis;
        this.fechaCaducada = fechaCaducada;
        this.loteFabricada = loteFabricada;
        this.numeroRegistros = numeroRegistros;
        this.cantidadDisponible = cantidadDisponible;
    }

    public Object[] toArray() {
        Object[] obj = new Object[8];

        obj[0] = nombreCientifico;
        obj[1] = marcaComercial;
        obj[2] = formaFarmaceutica;
        obj[3] = dosis;
        obj[4] = fechaCaducada;
        obj[5] = loteFabricada;
        obj[6] = numeroRegistros;
        obj[7] = cantidadDisponible;

        return obj;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getMarcaComercial() {
        return marcaComercial;
    }

    public void setMarcaComercial(String marcaComercial) {
        this.marcaComercial = marcaComercial;
    }

    public String getFormaFarmaceutica() {
        return formaFarmaceutica;
    }

    public void setFormaFarmaceutica(String formaFarmaceutica) {
        this.formaFarmaceutica = formaFarmaceutica;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getFechaCaducada() {
        return fechaCaducada;
    }

    public void setFechaCaducada(String fechaCaducada) {
        this.fechaCaducada = fechaCaducada;
    }

    public String getLoteFabricada() {
        return loteFabricada;
    }

    public void setLoteFabricada(String loteFabricada) {
        this.loteFabricada = loteFabricada;
    }

    public String getNumeroRegistros() {
        return numeroRegistros;
    }

    public void setNumeroRegistros(String numeroRegistros) {
        this.numeroRegistros = numeroRegistros;
    }

    public String getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(String cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

}
