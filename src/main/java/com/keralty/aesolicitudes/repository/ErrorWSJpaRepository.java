package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.ErrorWS;
import com.keralty.aesolicitudes.persistence.Solicitud;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ErrorWSJpaRepository extends JpaRepository<ErrorWS, Long>, ErrorWSJpaRepositoryCustom {

    List<ErrorWS> findBySolicitud(Solicitud solicitud);
}
