package com.portfolio.mrd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Skills {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreSkills;
    private String imgSkills;
    @NotNull
    private int porcentaje;
    @NotNull
    private String strokeColor;

    public Skills() {
    }

    public Skills(String nombreSkills, String imgSkills, int porcentaje, String strokeColor) {
        this.nombreSkills = nombreSkills;
        this.imgSkills = imgSkills;
        this.porcentaje = porcentaje;
        this.strokeColor = strokeColor;
    }  
    
}
