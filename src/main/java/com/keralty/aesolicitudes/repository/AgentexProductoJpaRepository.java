package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.AgentexProducto;
import com.keralty.aesolicitudes.persistence.Asesor;
import com.keralty.aesolicitudes.persistence.oid.AgentexProductoOid;
import com.keralty.aesolicitudes.persistence.Productos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentexProductoJpaRepository extends JpaRepository<AgentexProducto, AgentexProductoOid>, AgentexProductoJpaRepositoryCustom {

    List<AgentexProducto> findByProductoT(Productos productoT);

    List<AgentexProducto> findByAsesor(Asesor asesor);
}
