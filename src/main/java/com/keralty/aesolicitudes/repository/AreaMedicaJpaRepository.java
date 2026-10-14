package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.AreaMedica;
import com.keralty.aesolicitudes.persistence.Solicitud;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaMedicaJpaRepository extends JpaRepository<AreaMedica, Long>, AreaMedicaJpaRepositoryCustom {

    List<AreaMedica> findBySolicitudesArMe(Solicitud solicitudesArMe);
}
