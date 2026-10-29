package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.Departamento;
import com.keralty.aesolicitudes.persistence.Direccion;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.Pais;
import com.keralty.aesolicitudes.persistence.Persona;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.persistence.TipoDireccion;
import com.keralty.aesolicitudes.persistence.Titular;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DireccionJpaRepository extends JpaRepository<Direccion, Long>, DireccionJpaRepositoryCustom {

    List<Direccion> findByPersona(Persona persona);

    List<Direccion> findByTipoDireccion(TipoDireccion tipoDireccion);

    List<Direccion> findByMunicipio(Municipio municipio);

    List<Direccion> findByDepartamento(Departamento departamento);

    List<Direccion> findByPais(Pais pais);

    List<Direccion> findByContrato(Solicitud contrato);

    List<Direccion> findByTitular(Titular titular);
}
