package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.Departamento;
import com.keralty.aesolicitudes.persistence.Firma;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.NovedadCT;
import com.keralty.aesolicitudes.persistence.Pais;
import com.keralty.aesolicitudes.persistence.TipoIdentificacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NovedadCTJpaRepository extends JpaRepository<NovedadCT, Long>, NovedadCTJpaRepositoryCustom {

    List<NovedadCT> findByTipoIdentificacion(TipoIdentificacion tipoIdentificacion);

    List<NovedadCT> findByFirma(Firma firma);

    List<NovedadCT> findByMunicipioNac(Municipio municipioNac);

    List<NovedadCT> findByMunicipioRes(Municipio municipioRes);

    List<NovedadCT> findByDepartamentoNac(Departamento departamentoNac);

    List<NovedadCT> findByDepartamentoRes(Departamento departamentoRes);

    List<NovedadCT> findByPais(Pais pais);
}
