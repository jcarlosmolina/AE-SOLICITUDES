package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.Aesolicitudes;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.EstadoContrato;
import com.keralty.aesolicitudes.persistence.SolicitudNovedad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoContratoJpaRepository extends JpaRepository<EstadoContrato, Long>, EstadoContratoJpaRepositoryCustom {

    List<EstadoContrato> findByAESOLICITUDES(Aesolicitudes aESOLICITUDES);

    List<EstadoContrato> findByContratosC(ContratoC contratosC);

    List<EstadoContrato> findBySolicitudesNovedad(SolicitudNovedad solicitudesNovedad);
}
