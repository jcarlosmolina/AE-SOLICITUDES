package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.Funcionario;
import com.keralty.aesolicitudes.persistence.Rol;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolJpaRepository extends JpaRepository<Rol, Long>, RolJpaRepositoryCustom {

    List<Rol> findByAgentes(Funcionario agentes);
}
