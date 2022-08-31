
package com.portfolio.mrd.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class DtoPersona {
     @NotBlank
         private String nombre;
         @NotBlank
         private String apellido;
         @NotBlank
         @Size (min = 1, max = 500, message = "No cumple con la longitud")
         private String img;
         @NotBlank
         @Size (min = 1, max = 500, message = "No cumple con la longitud")
         private String imgBanner;
         @NotBlank
         @Size (min = 1, max = 2000, message = "No cumple con la longitud")
         private String acercaDeMi;

    public DtoPersona() {
    }

    public DtoPersona(String nombre, String apellido, String img, String imgBanner, String acercaDeMi) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.imgBanner = imgBanner;
        this.acercaDeMi = acercaDeMi;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImgBanner() {
        return imgBanner;
    }

    public void setImgBanner(String imgBanner) {
        this.imgBanner = imgBanner;
    }

    public String getAcercaDeMi() {
        return acercaDeMi;
    }

    public void setAcercaDeMi(String acercaDeMi) {
        this.acercaDeMi = acercaDeMi;
    }
  
    
}
