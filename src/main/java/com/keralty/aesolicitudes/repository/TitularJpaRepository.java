package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.Departamento;
import com.keralty.aesolicitudes.persistence.Direccion;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.persistence.TipoIdentificacion;
import com.keralty.aesolicitudes.persistence.Titular;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TitularJpaRepository extends JpaRepository<Titular, Long>, TitularJpaRepositoryCustom {

    List<Titular> findByDireccion(Direccion direccion);

    List<Titular> findBySolicitud(Solicitud solicitud);

    List<Titular> findByTipoIdentificacion(TipoIdentificacion tipoIdentificacion);

    List<Titular> findByDepartamentoNac(Departamento departamentoNac);

    List<Titular> findByMunicipioNac(Municipio municipioNac);
}
