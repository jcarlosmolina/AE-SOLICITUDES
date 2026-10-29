package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.Direccion;
import com.keralty.aesolicitudes.persistence.DireccionC;
import com.keralty.aesolicitudes.persistence.TipoDireccion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoDireccionJpaRepository extends JpaRepository<TipoDireccion, Long>, TipoDireccionJpaRepositoryCustom {

    List<TipoDireccion> findByDireccionesC(DireccionC direccionesC);

    List<TipoDireccion> findByDirecciones(Direccion direcciones);
}
