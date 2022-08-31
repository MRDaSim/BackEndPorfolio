
package com.portfolio.mrd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreProy;
    @Size (min = 1, max = 1000, message = "No cumple con la longitud")
    private String descripcionProy;
    private String imgProy;
    private String fechaInicioProy;
    private String fechaFinProy;

    public Proyecto() {
    }

    public Proyecto(String nombreProy, String descripcionProy, String imgProy, String fechaInicioProy, String fechaFinProy) {
        this.nombreProy = nombreProy;
        this.descripcionProy = descripcionProy;
        this.imgProy = imgProy;
        this.fechaInicioProy = fechaInicioProy;
        this.fechaFinProy = fechaFinProy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
