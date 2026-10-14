package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.oid.ReportesDominioOid;
import com.keralty.aesolicitudes.persistence.ReportesDominio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportesDominioJpaRepository extends JpaRepository<ReportesDominio, ReportesDominioOid>, ReportesDominioJpaRepositoryCustom {
}
