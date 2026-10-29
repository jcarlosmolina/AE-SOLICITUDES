package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.oid.ProteccionDatosCOid;
import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.Productos;
import com.keralty.aesolicitudes.persistence.ProteccionDatosC;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProteccionDatosCJpaRepository extends JpaRepository<ProteccionDatosC, ProteccionDatosCOid>, ProteccionDatosCJpaRepositoryCustom {

    List<ProteccionDatosC> findByPersonaC(PersonaC personaC);

    List<ProteccionDatosC> findByProductoC(Productos productoC);
}
