
package com.portfolio.mrd.controller;

import com.portfolio.mrd.Interface.IPersonaService;
import com.portfolio.mrd.model.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin (origins = "https://hosting-angular-proyecto-ap.web.app")
public class PersonaController {
        @Autowired IPersonaService ipersonaService;
        
        @GetMapping ("/personas/traer")
        public List <Persona> getPersona() {
           return ipersonaService.getPersona();
        }
        
        @PreAuthorize ("hasRole('ADMIN')")
        @PostMapping ("/persona/crear")
        public String crearPersona (@RequestBody Persona pers) {
            ipersonaService.savePersona(pers);
            return "La persona fue creada correctamente";
        }
        
        @PreAuthorize ("hasRole('ADMIN')")
        @DeleteMapping ("/persona/borrar/{id}")
        public String deletePersona (@PathVariable Long id) {
            ipersonaService.deletePersona(id);
            return "persona borrada";
        }
        
        @PreAuthorize ("hasRole('ADMIN')")
        @PutMapping ("/persona/editar/{id}")
        public Persona editarPersona (@PathVariable Long id,
                                                           @RequestParam ("nombre") String nuevoNombre,
                                                           @RequestParam ("apellido") String nuevoApellido,
                                                           @RequestParam ("img") String nuevoImg) {
                  Persona pers = ipersonaService.findPersona(id);
                  pers.setNombre(nuevoNombre);
                  pers.setApellido(nuevoApellido);
                  pers.setImg(nuevoImg);
                  
                  ipersonaService.savePersona(pers);
                  return pers;
        }
        
        @GetMapping ("/personas/traer/perfil")
        public Persona findPersona () {
            return ipersonaService.findPersona((long) 1);
        }
           
        
        
        
}
