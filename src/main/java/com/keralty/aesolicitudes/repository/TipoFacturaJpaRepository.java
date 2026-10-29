package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.persistence.TipoFactura;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoFacturaJpaRepository extends JpaRepository<TipoFactura, String>, TipoFacturaJpaRepositoryCustom {

    List<TipoFactura> findBySolicitudes(Solicitud solicitudes);
}
