package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.LogUsrSolNov;
import com.keralty.aesolicitudes.persistence.SolicitudNovedad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogUsrSolNovJpaRepository extends JpaRepository<LogUsrSolNov, Long>, LogUsrSolNovJpaRepositoryCustom {

    List<LogUsrSolNov> findBySolicitudNovedad(SolicitudNovedad solicitudNovedad);
}
