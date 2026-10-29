package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.oid.PreexistenciaCOid;
import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.PreexistenciaC;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreexistenciaCJpaRepository extends JpaRepository<PreexistenciaC, PreexistenciaCOid>, PreexistenciaCJpaRepositoryCustom {

    List<PreexistenciaC> findByPersonaC(PersonaC personaC);
}
