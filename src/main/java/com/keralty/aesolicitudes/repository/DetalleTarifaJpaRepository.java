package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.DetalleTarifa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleTarifaJpaRepository extends JpaRepository<DetalleTarifa, Long>, DetalleTarifaJpaRepositoryCustom {
}
