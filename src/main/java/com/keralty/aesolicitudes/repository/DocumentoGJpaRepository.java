package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.DocumentoG;
import com.keralty.aesolicitudes.persistence.ObsEstado;
import com.keralty.aesolicitudes.persistence.Persona;
import com.keralty.aesolicitudes.persistence.Solicitud;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentoGJpaRepository extends JpaRepository<DocumentoG, Long>, DocumentoGJpaRepositoryCustom {

    List<DocumentoG> findByObsEstado(ObsEstado obsEstado);

    List<DocumentoG> findBySolicitud(Solicitud solicitud);

    List<DocumentoG> findByPersona(Persona persona);
}
