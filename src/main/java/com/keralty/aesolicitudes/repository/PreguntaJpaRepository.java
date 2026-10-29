package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.Pregunta;
import com.keralty.aesolicitudes.persistence.PreguntaP;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreguntaJpaRepository extends JpaRepository<Pregunta, Long>, PreguntaJpaRepositoryCustom {

    List<Pregunta> findByPreguntasPersona(PreguntaP preguntasPersona);
}
