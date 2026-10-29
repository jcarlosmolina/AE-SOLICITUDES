package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.Contratante;
import com.keralty.aesolicitudes.persistence.Departamento;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.persistence.TipoIdentificacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratanteJpaRepository extends JpaRepository<Contratante, Long>, ContratanteJpaRepositoryCustom {

    List<Contratante> findBySolicitud(Solicitud solicitud);

    List<Contratante> findByTipoIdentificacion(TipoIdentificacion tipoIdentificacion);

    List<Contratante> findByDepartamentoNac(Departamento departamentoNac);

    List<Contratante> findByMunicipioNac(Municipio municipioNac);

    List<Contratante> findByDepartamentoRes(Departamento departamentoRes);

    List<Contratante> findByMunicipioRes(Municipio municipioRes);
}
