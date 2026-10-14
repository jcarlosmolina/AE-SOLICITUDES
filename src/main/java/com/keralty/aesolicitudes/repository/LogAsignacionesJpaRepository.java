package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.LogAsignaciones;
import com.keralty.aesolicitudes.persistence.Solicitud;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogAsignacionesJpaRepository extends JpaRepository<LogAsignaciones, Long>, LogAsignacionesJpaRepositoryCustom {

    List<LogAsignaciones> findBySolicitud(Solicitud solicitud);
}
