package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.Dominio;
import com.keralty.aesolicitudes.persistence.FormaPago;
import com.keralty.aesolicitudes.persistence.Periodicidad;
import com.keralty.aesolicitudes.persistence.Planes;
import com.keralty.aesolicitudes.persistence.PlantillaEmail;
import com.keralty.aesolicitudes.persistence.Productos;
import com.keralty.aesolicitudes.persistence.ReportesDominio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DominioJpaRepository extends JpaRepository<Dominio, Long>, DominioJpaRepositoryCustom {

    List<Dominio> findByReportesDominio(ReportesDominio reportesDominio);

    List<Dominio> findByPlanT(Planes planT);

    List<Dominio> findByProductoT(Productos productoT);

    List<Dominio> findByPeriodicidades(Periodicidad periodicidades);

    List<Dominio> findByFormasPago(FormaPago formasPago);

    List<Dominio> findByPlantillas(PlantillaEmail plantillas);
}
