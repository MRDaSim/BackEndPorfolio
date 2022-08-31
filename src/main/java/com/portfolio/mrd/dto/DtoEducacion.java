
package com.portfolio.mrd.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class DtoEducacion {
         
        @NotBlank
         private String nombreEdu;
         @NotBlank
         @Size (min = 1, max = 1000, message = "No cumple con la longitud")
         private String descripcionEdu;
         @NotBlank
         private String imgEdu;
         private String fechaInicioEdu;
         private String fechaFinEdu;
         
         //Constructores

    public DtoEducacion() {
    }

    public DtoEducacion(String nombreEdu, String descripcionEdu, String imgEdu, String fechaInicioEdu, String fechaFinEdu) {
        this.nombreEdu = nombreEdu;
        this.descripcionEdu = descripcionEdu;
        this.imgEdu = imgEdu;
        this.fechaInicioEdu = fechaInicioEdu;
        this.fechaFinEdu = fechaFinEdu;
    }

    public String getNombreEdu() {
        return nombreEdu;
    }

    public void setNombreEdu(String nombreEdu) {
        this.nombreEdu = nombreEdu;
    }

    public String getDescripcionEdu() {
        return descripcionEdu;
    }

    public void setDescripcionEdu(String descripcionEdu) {
        this.descripcionEdu = descripcionEdu;
    }

    public String getImgEdu() {
        return imgEdu;
    }

    public void setImgEdu(String imgEdu) {
        this.imgEdu = imgEdu;
    }

    public String getFechaInicioEdu() {
        return fechaInicioEdu;
    }

    public void setFechaInicioEdu(String fechaInicioEdu) {
        this.fechaInicioEdu = fechaInicioEdu;
    }

    public String getFechaFinEdu() {
        return fechaFinEdu;
    }

    public void setFechaFinEdu(String fechaFinEdu) {
        this.fechaFinEdu = fechaFinEdu;
    }
    
    
     
    
    
}
