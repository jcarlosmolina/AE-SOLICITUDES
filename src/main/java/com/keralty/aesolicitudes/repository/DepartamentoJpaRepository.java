package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.Contratante;
import com.keralty.aesolicitudes.persistence.Departamento;
import com.keralty.aesolicitudes.persistence.Direccion;
import com.keralty.aesolicitudes.persistence.DireccionC;
import com.keralty.aesolicitudes.persistence.DirSucursalC;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.Persona;
import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.Titular;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoJpaRepository extends JpaRepository<Departamento, Long>, DepartamentoJpaRepositoryCustom {

    List<Departamento> findByPersonas(Persona personas);

    List<Departamento> findByMunicipios(Municipio municipios);

    List<Departamento> findByPersonasC(PersonaC personasC);

    List<Departamento> findByDireccionesC(DireccionC direccionesC);

    List<Departamento> findByDirecciones(Direccion direcciones);

    List<Departamento> findByContratantes(Contratante contratantes);

    List<Departamento> findByContratantesRes(Contratante contratantesRes);

    List<Departamento> findByDirSucursalC(DirSucursalC dirSucursalC);

    List<Departamento> findByTitulares(Titular titulares);
}
