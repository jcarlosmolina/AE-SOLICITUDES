package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.MotDevAreaMedica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotDevAreaMedicaJpaRepository extends JpaRepository<MotDevAreaMedica, Long>, MotDevAreaMedicaJpaRepositoryCustom {
}
