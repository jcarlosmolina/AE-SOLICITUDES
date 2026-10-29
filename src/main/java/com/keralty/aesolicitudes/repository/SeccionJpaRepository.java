package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.Seccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeccionJpaRepository extends JpaRepository<Seccion, Long>, SeccionJpaRepositoryCustom {
}
