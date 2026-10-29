package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.PreguntaP;
import com.keralty.aesolicitudes.persistence.SeccionP;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreguntaPJpaRepository extends JpaRepository<PreguntaP, Long>, PreguntaPJpaRepositoryCustom {

    List<PreguntaP> findBySeccion(SeccionP seccion);
}
