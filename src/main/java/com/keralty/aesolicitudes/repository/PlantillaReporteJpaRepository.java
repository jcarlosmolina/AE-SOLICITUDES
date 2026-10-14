package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.PlantillaReporte;
import com.keralty.aesolicitudes.persistence.ReportesDominio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantillaReporteJpaRepository extends JpaRepository<PlantillaReporte, Long>, PlantillaReporteJpaRepositoryCustom {

    List<PlantillaReporte> findByReportesDominio(ReportesDominio reportesDominio);
}
