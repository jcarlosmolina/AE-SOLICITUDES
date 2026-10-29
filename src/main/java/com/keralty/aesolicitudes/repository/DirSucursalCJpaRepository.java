package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.Departamento;
import com.keralty.aesolicitudes.persistence.DirSucursalC;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.Pais;
import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.Regional;
import com.keralty.aesolicitudes.persistence.TelefonoC;
import com.keralty.aesolicitudes.persistence.TipoSucursalC;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirSucursalCJpaRepository extends JpaRepository<DirSucursalC, Long>, DirSucursalCJpaRepositoryCustom {

    List<DirSucursalC> findByTelefonosC(TelefonoC telefonosC);

    List<DirSucursalC> findByPersonaC(PersonaC personaC);

    List<DirSucursalC> findByTiposSucursalC(TipoSucursalC tiposSucursalC);

    List<DirSucursalC> findByMunicipioC(Municipio municipioC);

    List<DirSucursalC> findByDepartamentoC(Departamento departamentoC);

    List<DirSucursalC> findByPaisC(Pais paisC);

    List<DirSucursalC> findByRegionalC(Regional regionalC);
}
