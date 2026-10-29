package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.oid.PreexistenciaOid;
import com.keralty.aesolicitudes.persistence.Preexistencia;
import com.keralty.aesolicitudes.persistence.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreexistenciaJpaRepository extends JpaRepository<Preexistencia, PreexistenciaOid>, PreexistenciaJpaRepositoryCustom {

    List<Preexistencia> findByUsuario(Usuario usuario);
}
