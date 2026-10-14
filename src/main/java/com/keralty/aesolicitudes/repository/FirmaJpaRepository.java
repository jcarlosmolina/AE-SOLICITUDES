package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.Firma;
import com.keralty.aesolicitudes.persistence.RespRegional;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.persistence.SolicitudNovedad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FirmaJpaRepository extends JpaRepository<Firma, Long>, FirmaJpaRepositoryCustom {

    List<Firma> findBySolicitudNovedad(SolicitudNovedad solicitudNovedad);

    List<Firma> findBySolicitud(Solicitud solicitud);

    List<Firma> findBySolicitudSegunda(Solicitud solicitudSegunda);

    List<Firma> findByRespRegional(RespRegional respRegional);

    List<Firma> findBySolicitudContratante(Solicitud solicitudContratante);
}
