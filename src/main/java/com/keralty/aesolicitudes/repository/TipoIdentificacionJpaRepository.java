package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.AnexoC;
import com.keralty.aesolicitudes.persistence.Asesor;
import com.keralty.aesolicitudes.persistence.Contratante;
import com.keralty.aesolicitudes.persistence.Persona;
import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.SolicitudNovedad;
import com.keralty.aesolicitudes.persistence.TipoIdentificacion;
import com.keralty.aesolicitudes.persistence.Titular;
import com.keralty.aesolicitudes.persistence.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoIdentificacionJpaRepository extends JpaRepository<TipoIdentificacion, Long>, TipoIdentificacionJpaRepositoryCustom {

    List<TipoIdentificacion> findByAsesores(Asesor asesores);

    List<TipoIdentificacion> findByPersonas(Persona personas);

    List<TipoIdentificacion> findByPersonasC(PersonaC personasC);

    List<TipoIdentificacion> findByUsuarioS(Usuario usuarioS);

    List<TipoIdentificacion> findByContratantes(Contratante contratantes);

    List<TipoIdentificacion> findByAnexosC(AnexoC anexosC);

    List<TipoIdentificacion> findByTitulares(Titular titulares);

    List<TipoIdentificacion> findBySolicitudesNovedad(SolicitudNovedad solicitudesNovedad);
}
