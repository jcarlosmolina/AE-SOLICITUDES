package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.Novedad;
import com.keralty.aesolicitudes.persistence.SolicitudNovedad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NovedadJpaRepository extends JpaRepository<Novedad, Long>, NovedadJpaRepositoryCustom {

    List<Novedad> findBySolicitudes(SolicitudNovedad solicitudes);
}
