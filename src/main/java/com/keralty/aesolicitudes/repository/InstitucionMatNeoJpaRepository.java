package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.AnexoMat;
import com.keralty.aesolicitudes.persistence.AnexoNeo;
import com.keralty.aesolicitudes.persistence.InstitucionMatNeo;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.TipoIdentificacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstitucionMatNeoJpaRepository extends JpaRepository<InstitucionMatNeo, String>, InstitucionMatNeoJpaRepositoryCustom {

    List<InstitucionMatNeo> findByAnexoMat(AnexoMat anexoMat);

    List<InstitucionMatNeo> findByAnexoNeo(AnexoNeo anexoNeo);

    List<InstitucionMatNeo> findByTipoIdentificacion(TipoIdentificacion tipoIdentificacion);

    List<InstitucionMatNeo> findByMunicipio(Municipio municipio);
}
