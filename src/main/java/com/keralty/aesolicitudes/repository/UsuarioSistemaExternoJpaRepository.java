package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.UsuarioSistemaExterno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioSistemaExternoJpaRepository extends JpaRepository<UsuarioSistemaExterno, String>, UsuarioSistemaExternoJpaRepositoryCustom {
}
