package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.Funcionario;
import com.keralty.aesolicitudes.persistence.ObsEstado;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.persistence.SolicitudNovedad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioJpaRepository extends JpaRepository<Funcionario, Long>, FuncionarioJpaRepositoryCustom {

    List<Funcionario> findBySolicitudes(Solicitud solicitudes);

    List<Funcionario> findBySolicitudesAfiliacion(Solicitud solicitudesAfiliacion);

    List<Funcionario> findByObsEstado(ObsEstado obsEstado);

    List<Funcionario> findBySolicitudesNovedad(SolicitudNovedad solicitudesNovedad);

    List<Funcionario> findBySolNovAifliaciones(SolicitudNovedad solNovAifliaciones);
}
