package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.ConfiguracionANS;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfiguracionANSJpaRepository extends JpaRepository<ConfiguracionANS, Long>, ConfiguracionANSJpaRepositoryCustom {
}
