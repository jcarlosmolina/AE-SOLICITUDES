package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.DireccionC;
import com.keralty.aesolicitudes.persistence.DirSucursalC;
import com.keralty.aesolicitudes.persistence.TelefonoC;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefonoCJpaRepository extends JpaRepository<TelefonoC, Long>, TelefonoCJpaRepositoryCustom {

    List<TelefonoC> findByDirSucursalC(DirSucursalC dirSucursalC);

    List<TelefonoC> findByDireccionC(DireccionC direccionC);
}
