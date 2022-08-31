
package com.portfolio.mrd.controller;

import com.portfolio.mrd.dto.DtoPersona;
import com.portfolio.mrd.model.Persona;
import com.portfolio.mrd.security.controller.Mensaje;
import com.portfolio.mrd.service.ImpPersonaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin (origins = "https://hosting-angular-proyecto-ap.web.app")   ///"http://localhost:4200")
public class PersonaController {
        @Autowired ImpPersonaService personaService;
      
        @PreAuthorize ("hasRole('ADMIN')")
        @PostMapping("persona/create")
        public ResponseEntity<?> create(@RequestBody DtoPersona dtoPer) {
        if (StringUtils.isBlank(dtoPer.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (personaService.existsByNombre(dtoPer.getNombre())) {
            return new ResponseEntity(new Mensaje("La persona ya fue cargado"), HttpStatus.BAD_REQUEST);
        }

        Persona persona = new Persona(dtoPer.getNombre(), dtoPer.getApellido(), dtoPer.getImg(), dtoPer.getImgBanner(), dtoPer.getAcercaDeMi());
        personaService.save(persona);

        return new ResponseEntity(new Mensaje("Persona agregado"), HttpStatus.OK);

    }
        
        @PreAuthorize ("hasRole('ADMIN')")
        @DeleteMapping("/delete/{id}")
         public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //validamos si existe el id
        if (!personaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.OK);
        }

        personaService.delete(id);

        return new ResponseEntity(new Mensaje("persona eliminada"), HttpStatus.OK);
    }
        
        @PreAuthorize ("hasRole('ADMIN')")
        @PutMapping("persona/update/{id}")
         public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoPersona dtoPer) {
        //validamos si existe el id
        if (!personaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        
        //Compara nombre de proyecto 
        if (personaService.existsByNombre(dtoPer.getNombre()) && personaService.getByNombre(dtoPer.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("la persona ya existe"), HttpStatus.BAD_REQUEST);
        }

        //no puede estar vasio
        if (StringUtils.isBlank(dtoPer.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Persona persona = personaService.getOne(id).get();
        persona.setNombre(dtoPer.getNombre());
        persona.setApellido(dtoPer.getApellido());
        persona.setImg(dtoPer.getImg());
        persona.setImgBanner(dtoPer.getImgBanner());
        persona.setAcercaDeMi(dtoPer.getAcercaDeMi());
       

        personaService.save(persona);
        return new ResponseEntity(new Mensaje("Persona actualisado"), HttpStatus.OK);

    }
        
     @GetMapping("persona/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id) {
        if (!personaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Persona persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
           
   
        
        
}


