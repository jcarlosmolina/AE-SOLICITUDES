package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.TipoInstitucionC;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoInstitucionCJpaRepository extends JpaRepository<TipoInstitucionC, Long>, TipoInstitucionCJpaRepositoryCustom {

    List<TipoInstitucionC> findByPersonasC(PersonaC personasC);
}
