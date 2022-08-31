
package com.portfolio.mrd.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class DtoProyecto {
    
    @NotBlank
    private String nombreProy;
    @NotBlank
    @Size (min = 1, max = 1000, message = "No cumple con la longitud")
    private String descripcionProy;
    @NotBlank
    private String imgProy;
    private String fechaInicioProy;
    private String fechaFinProy;

    public DtoProyecto() {
    }

    public DtoProyecto(String nombreProy, String descripcionProy, String imgProy, String fechaInicioProy, String fechaFinProy) {
        this.nombreProy = nombreProy;
        this.descripcionProy = descripcionProy;
        this.imgProy = imgProy;
        this.fechaInicioProy = fechaInicioProy;
        this.fechaFinProy = fechaFinProy;
    }

    public String getNombreProy() {
        return nombreProy;
    }

    public void setNombreProy(String nombreProy) {
        this.nombreProy = nombreProy;
    }

    public String getDescripcionProy() {
        return descripcionProy;
    }

    public void setDescripcionProy(String descripcionProy) {
        this.descripcionProy = descripcionProy;
    }

    public String getImgProy() {
        return imgProy;
    }

    public void setImgProy(String imgProy) {
        this.imgProy = imgProy;
    }

    public String getFechaInicioProy() {
        return fechaInicioProy;
    }

    public void setFechaInicioProy(String fechaInicioProy) {
        this.fechaInicioProy = fechaInicioProy;
    }

    public String getFechaFinProy() {
        return fechaFinProy;
    }

    public void setFechaFinProy(String fechaFinProy) {
        this.fechaFinProy = fechaFinProy;
    }
    
    
    
}
