package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.Planes;
import com.keralty.aesolicitudes.persistence.Productos;
import com.keralty.aesolicitudes.persistence.Tarifa;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarifaJpaRepository extends JpaRepository<Tarifa, Long>, TarifaJpaRepositoryCustom {

    List<Tarifa> findByContratosC(ContratoC contratosC);

    List<Tarifa> findByProductoT(Productos productoT);

    List<Tarifa> findByPlanT(Planes planT);
}
