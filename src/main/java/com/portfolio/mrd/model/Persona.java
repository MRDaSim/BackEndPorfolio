
package com.portfolio.mrd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
      @Id
      @GeneratedValue (strategy = GenerationType.IDENTITY)
      private int id;
      
      @NotNull
      @Size (min = 1, max = 50, message = "No cumple con la longitud")
      private String nombre;
      
      @NotNull
      @Size (min = 1, max = 50, message = "No cumple con la longitud")
      private String apellido;
      
      @NotNull
      @Size (min = 1, max = 500, message = "No cumple con la longitud")
      private String img;
      
      
      @NotNull
      @Size (min = 1, max = 500, message = "No cumple con la longitud")
      private String imgBanner;
      
      @NotNull
      @Size (min = 1, max = 2000, message = "No cumple con la longitud")
      private String acercaDeMi;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String img, String imgBanner, String acercaDeMi) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.imgBanner = imgBanner;
        this.acercaDeMi = acercaDeMi;
    }
      
      
      
      
}


