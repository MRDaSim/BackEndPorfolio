
package com.portfolio.mrd.service;

import com.portfolio.mrd.model.Skills;
import com.portfolio.mrd.repository.RSkills;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SSkills {
    @Autowired
    RSkills rSkills;
    
    public List <Skills> list() {
                return rSkills.findAll();
        } 
        
        public Optional<Skills> getOne (int id) {
                return rSkills.findById(id);
        }       
        
        public Optional <Skills> getByNombreSkills (String nombreSkills) {
                return rSkills.findByNombreSkills(nombreSkills);
        }
        
        public void save (Skills ski) {
                rSkills.save(ski);
        }
        
        public void delete (int id) {
                rSkills.deleteById(id);
        }
        
        public boolean existsById (int id) {
                return rSkills.existsById(id);
        }
        
        public boolean existsByNombreSkills (String nombreSkills) {
                return rSkills.existsByNombreSkills(nombreSkills);
        }
}
