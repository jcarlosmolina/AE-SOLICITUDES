package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.Asesor;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.TipoIdentificacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsesorJpaRepository extends JpaRepository<Asesor, Long>, AsesorJpaRepositoryCustom {

    List<Asesor> findByContratosC(ContratoC contratosC);

    List<Asesor> findByTipoIdentificacion(TipoIdentificacion tipoIdentificacion);
}
