package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.MarcaMedicaC;
import com.keralty.aesolicitudes.persistence.oid.MarcaMedicaCOid;
import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.Productos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaMedicaCJpaRepository extends JpaRepository<MarcaMedicaC, MarcaMedicaCOid>, MarcaMedicaCJpaRepositoryCustom {

    List<MarcaMedicaC> findByPersonaC(PersonaC personaC);

    List<MarcaMedicaC> findByProductoC(Productos productoC);
}
