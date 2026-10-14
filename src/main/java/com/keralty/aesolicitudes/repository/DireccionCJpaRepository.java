package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.Departamento;
import com.keralty.aesolicitudes.persistence.DireccionC;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.Pais;
import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.TelefonoC;
import com.keralty.aesolicitudes.persistence.TipoDireccion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DireccionCJpaRepository extends JpaRepository<DireccionC, Long>, DireccionCJpaRepositoryCustom {

    List<DireccionC> findByTelefonosC(TelefonoC telefonosC);

    List<DireccionC> findByPersonaC(PersonaC personaC);

    List<DireccionC> findByContratoC(ContratoC contratoC);

    List<DireccionC> findByTipoDireccionC(TipoDireccion tipoDireccionC);

    List<DireccionC> findByDepartamentoC(Departamento departamentoC);

    List<DireccionC> findByMunicipioC(Municipio municipioC);

    List<DireccionC> findByPaisC(Pais paisC);
}
