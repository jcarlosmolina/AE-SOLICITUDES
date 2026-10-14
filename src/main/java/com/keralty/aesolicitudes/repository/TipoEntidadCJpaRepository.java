package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.TipoEntidadC;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoEntidadCJpaRepository extends JpaRepository<TipoEntidadC, Long>, TipoEntidadCJpaRepositoryCustom {

    List<TipoEntidadC> findByPersonasC(PersonaC personasC);
}
