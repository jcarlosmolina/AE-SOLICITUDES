package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.Productos;
import com.keralty.aesolicitudes.persistence.ProteccionDatos;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.persistence.SolicitudNovedad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProteccionDatosJpaRepository extends JpaRepository<ProteccionDatos, Long>, ProteccionDatosJpaRepositoryCustom {

    List<ProteccionDatos> findBySolicitudNovedad(SolicitudNovedad solicitudNovedad);

    List<ProteccionDatos> findByProductoT(Productos productoT);

    List<ProteccionDatos> findBySolicitud(Solicitud solicitud);
}
