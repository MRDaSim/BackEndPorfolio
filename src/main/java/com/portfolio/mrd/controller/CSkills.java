
package com.portfolio.mrd.controller;


import com.portfolio.mrd.dto.DtoSkills;
import com.portfolio.mrd.model.Skills;
import com.portfolio.mrd.security.controller.Mensaje;
import com.portfolio.mrd.service.SSkills;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("skills")
@CrossOrigin (origins = "https://hosting-angular-proyecto-ap.web.app")    ///"http://localhost:4200")
public class CSkills {
    @Autowired
    SSkills sSkills;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list() {
            List<Skills> list = sSkills.list();
            return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping ("/create")
    public ResponseEntity<?> create (@RequestBody DtoSkills dtoSkills) {
            if (StringUtils.isBlank(dtoSkills.getNombreSkills())) {
                    return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
            }
            
            if (sSkills.existsByNombreSkills(dtoSkills.getNombreSkills())) {
                    return new ResponseEntity(new Mensaje("Esta Skills ya fue cargada"), HttpStatus.BAD_REQUEST);
            }
            
            Skills skills = new Skills(dtoSkills.getNombreSkills(), dtoSkills.getImgSkills(), dtoSkills.getPorcentaje(), dtoSkills.getStrokeColor());
            sSkills.save(skills);
            
            return new ResponseEntity(new Mensaje("Educacion agregada"), HttpStatus.OK);
            
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoSkills dtoSkills) {
        //Validamos si existe el id
        if (!sSkills.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }

        //Conpara nombre de experiencias
        if (sSkills.existsByNombreSkills(dtoSkills.getNombreSkills()) && sSkills.getByNombreSkills(dtoSkills.getNombreSkills()).get().getId()!= id) {
            return new ResponseEntity(new Mensaje("Esa Skills ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vasio
        if (StringUtils.isBlank(dtoSkills.getNombreSkills())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Skills skills = sSkills.getOne(id).get();
        skills.setNombreSkills(dtoSkills.getNombreSkills());
        skills.setImgSkills(dtoSkills.getImgSkills());
        skills.setPorcentaje(dtoSkills.getPorcentaje());
        skills.setStrokeColor(dtoSkills.getStrokeColor());


        sSkills.save(skills);
        return new ResponseEntity(new Mensaje("Skills actualisada"), HttpStatus.OK);

    }
    
     @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //validamos si existe el id
        if (!sSkills.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.OK);
        }

        sSkills.delete(id);

        return new ResponseEntity(new Mensaje("Hard & Soft Skills eliminada"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") int id) {
        if (!sSkills.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Skills skills = sSkills.getOne(id).get();
        return new ResponseEntity(skills, HttpStatus.OK);
    }     
}
