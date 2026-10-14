package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.CuestionarioP;
import com.keralty.aesolicitudes.persistence.SeccionP;
import com.keralty.aesolicitudes.persistence.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuestionarioPJpaRepository extends JpaRepository<CuestionarioP, Long>, CuestionarioPJpaRepositoryCustom {

    List<CuestionarioP> findBySecciones(SeccionP secciones);

    List<CuestionarioP> findByUsuario(Usuario usuario);
}
