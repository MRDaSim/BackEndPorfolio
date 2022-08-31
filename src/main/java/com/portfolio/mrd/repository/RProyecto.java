
package com.portfolio.mrd.repository;

import com.portfolio.mrd.model.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RProyecto extends JpaRepository <Proyecto, Integer> {
    public Optional <Proyecto> findByNombreProy (String nombreProy);
    public boolean existsByNombreProy (String nombreProy);
}
