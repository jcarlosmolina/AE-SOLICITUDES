package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.TipoNovedad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoNovedadJpaRepository extends JpaRepository<TipoNovedad, Long>, TipoNovedadJpaRepositoryCustom {
}
