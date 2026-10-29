package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.DocumentoG;
import com.keralty.aesolicitudes.persistence.Funcionario;
import com.keralty.aesolicitudes.persistence.ObsEstado;
import com.keralty.aesolicitudes.persistence.oid.ObsEstadoOid;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObsEstadoJpaRepository extends JpaRepository<ObsEstado, ObsEstadoOid>, ObsEstadoJpaRepositoryCustom {

    List<ObsEstado> findByDocumentoG(DocumentoG documentoG);

    List<ObsEstado> findByAgente(Funcionario agente);
}
