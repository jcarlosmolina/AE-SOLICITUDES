package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.FamiliaNovedad;
import com.keralty.aesolicitudes.persistence.Firma;
import com.keralty.aesolicitudes.persistence.SolicitudNovedad;
import com.keralty.aesolicitudes.persistence.TipoIdentificacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamiliaNovedadJpaRepository extends JpaRepository<FamiliaNovedad, Long>, FamiliaNovedadJpaRepositoryCustom {

    List<FamiliaNovedad> findBySolicitud(SolicitudNovedad solicitud);

    List<FamiliaNovedad> findByTipoIdentificacion(TipoIdentificacion tipoIdentificacion);

    List<FamiliaNovedad> findByFirma(Firma firma);
}
