package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.AnexoC;
import com.keralty.aesolicitudes.persistence.AnexoMat;
import com.keralty.aesolicitudes.persistence.AnexoNeo;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.Periodicidad;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.persistence.SolicitudNovedad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeriodicidadJpaRepository extends JpaRepository<Periodicidad, Long>, PeriodicidadJpaRepositoryCustom {

    List<Periodicidad> findBySolicitudes(Solicitud solicitudes);

    List<Periodicidad> findByAnexosMat(AnexoMat anexosMat);

    List<Periodicidad> findByAnexosNeo(AnexoNeo anexosNeo);

    List<Periodicidad> findByContratosC(ContratoC contratosC);

    List<Periodicidad> findByAnexosC(AnexoC anexosC);

    List<Periodicidad> findBySolicitudesNovedad(SolicitudNovedad solicitudesNovedad);

    List<Periodicidad> findBySolicitudesNovedadNueva(SolicitudNovedad solicitudesNovedadNueva);
}
