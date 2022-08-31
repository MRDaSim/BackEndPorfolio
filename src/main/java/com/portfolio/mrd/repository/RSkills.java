
package com.portfolio.mrd.repository;

import com.portfolio.mrd.model.Skills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RSkills extends JpaRepository <Skills, Integer> {
     public Optional <Skills> findByNombreSkills (String nombreSkills);
        public boolean existsByNombreSkills (String nombreSkills);
}
