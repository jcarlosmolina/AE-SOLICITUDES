package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.MesaDeApoyo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MesaDeApoyoJpaRepository extends JpaRepository<MesaDeApoyo, Long>, MesaDeApoyoJpaRepositoryCustom {
}
