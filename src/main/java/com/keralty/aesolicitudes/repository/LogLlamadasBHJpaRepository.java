package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.LogLlamadasBH;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogLlamadasBHJpaRepository extends JpaRepository<LogLlamadasBH, Long>, LogLlamadasBHJpaRepositoryCustom {
}
