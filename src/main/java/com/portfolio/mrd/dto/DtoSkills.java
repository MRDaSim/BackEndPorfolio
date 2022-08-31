
package com.portfolio.mrd.dto;

import javax.validation.constraints.NotBlank;


public class DtoSkills {
    @NotBlank
    private String nombreSkills;
    @NotBlank
    private String imgSkills;
    private int porcentaje;
    private String strokeColor;

    public DtoSkills() {
    }

    public DtoSkills(String nombreSkills, String imgSkills, int porcentaje, String strokeColor) {
        this.nombreSkills = nombreSkills;
        this.imgSkills = imgSkills;
        this.porcentaje = porcentaje;
        this.strokeColor = strokeColor;
    }

    public String getNombreSkills() {
        return nombreSkills;
    }

    public void setNombreSkills(String nombreSkills) {
        this.nombreSkills = nombreSkills;
    }

    public String getImgSkills() {
        return imgSkills;
    }

    public void setImgSkills(String imgSkills) {
        this.imgSkills = imgSkills;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(String strokeColor) {
        this.strokeColor = strokeColor;
    }
    
    
    
}
