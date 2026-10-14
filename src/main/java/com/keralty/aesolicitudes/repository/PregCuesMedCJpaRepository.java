package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.oid.PregCuesMedCOid;
import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.PregCuesMedC;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PregCuesMedCJpaRepository extends JpaRepository<PregCuesMedC, PregCuesMedCOid>, PregCuesMedCJpaRepositoryCustom {

    List<PregCuesMedC> findByPersonaC(PersonaC personaC);
}
