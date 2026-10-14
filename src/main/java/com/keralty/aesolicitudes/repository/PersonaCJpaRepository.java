package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.Departamento;
import com.keralty.aesolicitudes.persistence.DireccionC;
import com.keralty.aesolicitudes.persistence.DirSucursalC;
import com.keralty.aesolicitudes.persistence.EstadoCivil;
import com.keralty.aesolicitudes.persistence.EstadoPersona;
import com.keralty.aesolicitudes.persistence.FamiliaC;
import com.keralty.aesolicitudes.persistence.MarcaMedicaC;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.PreexistenciaC;
import com.keralty.aesolicitudes.persistence.PregCuesMedC;
import com.keralty.aesolicitudes.persistence.ProteccionDatosC;
import com.keralty.aesolicitudes.persistence.TipoEntidadC;
import com.keralty.aesolicitudes.persistence.TipoIdentificacion;
import com.keralty.aesolicitudes.persistence.TipoInstitucionC;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaCJpaRepository extends JpaRepository<PersonaC, Long>, PersonaCJpaRepositoryCustom {

    List<PersonaC> findByDireccionesC(DireccionC direccionesC);

    List<PersonaC> findByProteccionesDatosC(ProteccionDatosC proteccionesDatosC);

    List<PersonaC> findByPregsCuesMedC(PregCuesMedC pregsCuesMedC);

    List<PersonaC> findByDirSucursalesC(DirSucursalC dirSucursalesC);

    List<PersonaC> findByPreexistenciasC(PreexistenciaC preexistenciasC);

    List<PersonaC> findByMarcasMedicasC(MarcaMedicaC marcasMedicasC);

    List<PersonaC> findByTipoInstitucionC(TipoInstitucionC tipoInstitucionC);

    List<PersonaC> findByTipoEntidadC(TipoEntidadC tipoEntidadC);

    List<PersonaC> findByEstadoCivilC(EstadoCivil estadoCivilC);

    List<PersonaC> findByEstadoPersonaC(EstadoPersona estadoPersonaC);

    List<PersonaC> findByTipoIdentificacionC(TipoIdentificacion tipoIdentificacionC);

    List<PersonaC> findByMunicipioCNac(Municipio municipioCNac);

    List<PersonaC> findByDepartamentoCNac(Departamento departamentoCNac);

    List<PersonaC> findByContratosC(ContratoC contratosC);

    List<PersonaC> findByFamiliasC(FamiliaC familiasC);

    List<PersonaC> findByBeneficiariosC(BeneficiarioC beneficiariosC);
}
