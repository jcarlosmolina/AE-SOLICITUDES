package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.PlantillaEmail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantillaEmailJpaRepository extends JpaRepository<PlantillaEmail, Long>, PlantillaEmailJpaRepositoryCustom {
}
