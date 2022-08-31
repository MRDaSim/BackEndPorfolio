
package com.portfolio.mrd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Experiencia  {
        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
        private int id;
        @NotNull
        private String nombreE;
        @NotNull
        @Size (min = 1, max = 1000, message = "No cumple con la longitud")
        private String descripcionE;
        private String imgExp;
        private String fechaInicioExp;
        private String fechaFinExp;
        
       

        
     //Constructores
    public Experiencia() {
    }

    public Experiencia(String nombreE, String descripcionE, String imgExp, String fechaInicioExp, String fechaFinExp) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.imgExp = imgExp;
        this.fechaInicioExp = fechaInicioExp;
        this.fechaFinExp = fechaFinExp;
    }
    
    //Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
