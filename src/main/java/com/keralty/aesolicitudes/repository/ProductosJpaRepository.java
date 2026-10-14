package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.Aesolicitudes;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.GrupoAsociado;
import com.keralty.aesolicitudes.persistence.MarcaMedicaC;
import com.keralty.aesolicitudes.persistence.Planes;
import com.keralty.aesolicitudes.persistence.Productos;
import com.keralty.aesolicitudes.persistence.ProteccionDatos;
import com.keralty.aesolicitudes.persistence.ProteccionDatosC;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductosJpaRepository extends JpaRepository<Productos, Long>, ProductosJpaRepositoryCustom {

    List<Productos> findByPlanes(Planes planes);

    List<Productos> findByGruposAsociados(GrupoAsociado gruposAsociados);

    List<Productos> findByAESOLICITUDES(Aesolicitudes aESOLICITUDES);

    List<Productos> findByProteccionDatosC(ProteccionDatosC proteccionDatosC);

    List<Productos> findByProteccionesDatos(ProteccionDatos proteccionesDatos);

    List<Productos> findByContratosC(ContratoC contratosC);

    List<Productos> findByMarcaMedicaC(MarcaMedicaC marcaMedicaC);
}
