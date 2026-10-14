package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.ObservacionesC;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObservacionesCJpaRepository extends JpaRepository<ObservacionesC, Long>, ObservacionesCJpaRepositoryCustom {

    List<ObservacionesC> findByContratoC(ContratoC contratoC);
}
