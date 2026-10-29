package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.CuestionarioMed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuestionarioMedJpaRepository extends JpaRepository<CuestionarioMed, Long>, CuestionarioMedJpaRepositoryCustom {
}
