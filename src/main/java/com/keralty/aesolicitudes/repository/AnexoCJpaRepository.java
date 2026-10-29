package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.AnexoC;
import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.Periodicidad;
import com.keralty.aesolicitudes.persistence.TipoIdentificacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnexoCJpaRepository extends JpaRepository<AnexoC, Long>, AnexoCJpaRepositoryCustom {

    List<AnexoC> findByBeneficiarioC(BeneficiarioC beneficiarioC);

    List<AnexoC> findByPeriodicidadC(Periodicidad periodicidadC);

    List<AnexoC> findByTipoIdentificacionC(TipoIdentificacion tipoIdentificacionC);
}
