package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.DirSucursalC;
import com.keralty.aesolicitudes.persistence.TipoSucursalC;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoSucursalCJpaRepository extends JpaRepository<TipoSucursalC, Long>, TipoSucursalCJpaRepositoryCustom {

    List<TipoSucursalC> findByDirSucursalesC(DirSucursalC dirSucursalesC);
}
