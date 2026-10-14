package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.Planes;
import com.keralty.aesolicitudes.persistence.Productos;
import com.keralty.aesolicitudes.persistence.TipoIVA;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoIVAJpaRepository extends JpaRepository<TipoIVA, Long>, TipoIVAJpaRepositoryCustom {

    List<TipoIVA> findByProductoT(Productos productoT);

    List<TipoIVA> findByPlanT(Planes planT);
}
