
package com.portfolio.mrd.controller;

import com.portfolio.mrd.dto.DtoProyecto;
import com.portfolio.mrd.model.Proyecto;
import com.portfolio.mrd.security.controller.Mensaje;
import com.portfolio.mrd.service.SProyecto;
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
@RequestMapping("proy")
@CrossOrigin(origins = "https://hosting-angular-proyecto-ap.web.app")   ///"http://localhost:4200")
public class CProyecto {

    @Autowired
    SProyecto sProyecto;

    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list() {
        List<Proyecto> list = sProyecto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProyecto dtoProy) {
        if (StringUtils.isBlank(dtoProy.getNombreProy())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (sProyecto.existsByNombreProy(dtoProy.getNombreProy())) {
            return new ResponseEntity(new Mensaje("Este Proyecto ya fue cargado"), HttpStatus.BAD_REQUEST);
        }

        Proyecto proyecto = new Proyecto(dtoProy.getNombreProy(), dtoProy.getDescripcionProy(), dtoProy.getImgProy(), dtoProy.getFechaInicioProy(), dtoProy.getFechaFinProy());
        sProyecto.save(proyecto);

        return new ResponseEntity(new Mensaje("Proyecto agregado"), HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProyecto dtoProy) {
        //validamos si existe el id
        if (!sProyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        
        //Compara nombre de proyecto 
        if (sProyecto.existsByNombreProy(dtoProy.getNombreProy()) && sProyecto.getByNombreProy(dtoProy.getNombreProy()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }

        //no puede estar vasio
        if (StringUtils.isBlank(dtoProy.getNombreProy())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Proyecto proyecto = sProyecto.getOne(id).get();
        proyecto.setNombreProy(dtoProy.getNombreProy());
        proyecto.setDescripcionProy(dtoProy.getDescripcionProy());
        proyecto.setImgProy(dtoProy.getImgProy());
        proyecto.setFechaInicioProy(dtoProy.getFechaInicioProy());
        proyecto.setFechaFinProy(dtoProy.getFechaFinProy());

        sProyecto.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto actualisado"), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //validamos si existe el id
        if (!sProyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.OK);
        }

        sProyecto.delete(id);

        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id) {
        if (!sProyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Proyecto proyecto = sProyecto.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
}
