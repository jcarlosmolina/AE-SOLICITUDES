package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.EstadoCivil;
import com.keralty.aesolicitudes.persistence.Persona;
import com.keralty.aesolicitudes.persistence.PersonaC;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoCivilJpaRepository extends JpaRepository<EstadoCivil, Long>, EstadoCivilJpaRepositoryCustom {

    List<EstadoCivil> findByPersonas(Persona personas);

    List<EstadoCivil> findByPersonasC(PersonaC personasC);
}
