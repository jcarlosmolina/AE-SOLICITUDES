package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.Contratante;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.Departamento;
import com.keralty.aesolicitudes.persistence.Direccion;
import com.keralty.aesolicitudes.persistence.DireccionC;
import com.keralty.aesolicitudes.persistence.DirSucursalC;
import com.keralty.aesolicitudes.persistence.FamiliaC;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.Persona;
import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.Titular;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MunicipioJpaRepository extends JpaRepository<Municipio, Long>, MunicipioJpaRepositoryCustom {

    List<Municipio> findByPersonas(Persona personas);

    List<Municipio> findByPersonasC(PersonaC personasC);

    List<Municipio> findByDireccionesC(DireccionC direccionesC);

    List<Municipio> findByDirecciones(Direccion direcciones);

    List<Municipio> findByContratantes(Contratante contratantes);

    List<Municipio> findByContratanteRes(Contratante contratanteRes);

    List<Municipio> findByContratosC(ContratoC contratosC);

    List<Municipio> findByDirSucursalC(DirSucursalC dirSucursalC);

    List<Municipio> findByFamiliaC(FamiliaC familiaC);

    List<Municipio> findByTitulares(Titular titulares);

    List<Municipio> findByDepartamento(Departamento departamento);
}
