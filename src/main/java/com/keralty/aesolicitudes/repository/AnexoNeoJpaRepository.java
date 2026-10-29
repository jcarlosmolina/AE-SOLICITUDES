package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.AnexoNeo;
import com.keralty.aesolicitudes.persistence.Periodicidad;
import com.keralty.aesolicitudes.persistence.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnexoNeoJpaRepository extends JpaRepository<AnexoNeo, Long>, AnexoNeoJpaRepositoryCustom {

    List<AnexoNeo> findByUsuario(Usuario usuario);

    List<AnexoNeo> findByPeriodicidad(Periodicidad periodicidad);
}
