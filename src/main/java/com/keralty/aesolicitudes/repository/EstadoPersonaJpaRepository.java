package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.EstadoPersona;
import com.keralty.aesolicitudes.persistence.Persona;
import com.keralty.aesolicitudes.persistence.PersonaC;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoPersonaJpaRepository extends JpaRepository<EstadoPersona, Long>, EstadoPersonaJpaRepositoryCustom {

    List<EstadoPersona> findByPersonas(Persona personas);

    List<EstadoPersona> findByPersonasC(PersonaC personasC);
}
