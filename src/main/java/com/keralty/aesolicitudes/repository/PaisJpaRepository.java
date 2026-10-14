package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.Direccion;
import com.keralty.aesolicitudes.persistence.DireccionC;
import com.keralty.aesolicitudes.persistence.DirSucursalC;
import com.keralty.aesolicitudes.persistence.Pais;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisJpaRepository extends JpaRepository<Pais, String>, PaisJpaRepositoryCustom {

    List<Pais> findByDireccionesC(DireccionC direccionesC);

    List<Pais> findByDirecciones(Direccion direcciones);

    List<Pais> findByDirSucursalC(DirSucursalC dirSucursalC);
}
