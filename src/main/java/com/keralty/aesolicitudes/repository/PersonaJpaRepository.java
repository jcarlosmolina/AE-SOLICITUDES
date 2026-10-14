package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.Departamento;
import com.keralty.aesolicitudes.persistence.Direccion;
import com.keralty.aesolicitudes.persistence.DocumentoG;
import com.keralty.aesolicitudes.persistence.EstadoCivil;
import com.keralty.aesolicitudes.persistence.EstadoPersona;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.Persona;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.persistence.TipoIdentificacion;
import com.keralty.aesolicitudes.persistence.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaJpaRepository extends JpaRepository<Persona, Long>, PersonaJpaRepositoryCustom {

    List<Persona> findBySolicitudesContratante(Solicitud solicitudesContratante);

    List<Persona> findBySolicitudesTitular(Solicitud solicitudesTitular);

    List<Persona> findByDirecciones(Direccion direcciones);

    List<Persona> findByUsuarios(Usuario usuarios);

    List<Persona> findByDocumentosG(DocumentoG documentosG);

    List<Persona> findByTipoIdentificacion(TipoIdentificacion tipoIdentificacion);

    List<Persona> findByDepartamentoNacimiento(Departamento departamentoNacimiento);

    List<Persona> findByMunicipioNacimiento(Municipio municipioNacimiento);

    List<Persona> findByEstadoCivil(EstadoCivil estadoCivil);

    List<Persona> findByEstadoPersona(EstadoPersona estadoPersona);
}
