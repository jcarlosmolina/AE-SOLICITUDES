package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.Causal;
import com.keralty.aesolicitudes.persistence.SolicitudNovedad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CausalJpaRepository extends JpaRepository<Causal, Long>, CausalJpaRepositoryCustom {

    List<Causal> findBySolicitudes(SolicitudNovedad solicitudes);
}
