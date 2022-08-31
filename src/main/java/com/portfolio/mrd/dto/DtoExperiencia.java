
package com.portfolio.mrd.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class DtoExperiencia {

    @NotBlank
    private String nombreE;
    @NotBlank
    @Size (min = 1, max = 1000, message = "No cumple con la longitud")
    private String descripcionE;
    @NotBlank
    private String imgExp;
    @NotBlank
    private String fechaInicioExp;
    @NotBlank
    private String fechaFinExp;

    //Constructores 
    public DtoExperiencia() {
    }

    public DtoExperiencia(String nombreE, String descripcionE, String imgExp, String fechaInicioExp, String fechaFinExp) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.imgExp = imgExp;
        this.fechaInicioExp = fechaInicioExp;
        this.fechaFinExp = fechaFinExp;
    }

    //Getters y Setters
    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public String getImgExp() {
        return imgExp;
    }

    public void setImgExp(String imgExp) {
        this.imgExp = imgExp;
    }

    public String getFechaInicioExp() {
        return fechaInicioExp;
    }

    public void setFechaInicioExp(String fechaInicioExp) {
        this.fechaInicioExp = fechaInicioExp;
    }

    public String getFechaFinExp() {
        return fechaFinExp;
    }

    public void setFechaFinExp(String fechaFinExp) {
        this.fechaFinExp = fechaFinExp;
    }
    
    
}
