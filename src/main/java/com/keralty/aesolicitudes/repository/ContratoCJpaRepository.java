package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.Asesor;
import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.DireccionC;
import com.keralty.aesolicitudes.persistence.EstadoContrato;
import com.keralty.aesolicitudes.persistence.FamiliaC;
import com.keralty.aesolicitudes.persistence.FormaPago;
import com.keralty.aesolicitudes.persistence.GrupoAsociado;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.ObservacionesC;
import com.keralty.aesolicitudes.persistence.Periodicidad;
import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.Planes;
import com.keralty.aesolicitudes.persistence.Productos;
import com.keralty.aesolicitudes.persistence.Solicitud;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratoCJpaRepository extends JpaRepository<ContratoC, Long>, ContratoCJpaRepositoryCustom {

    List<ContratoC> findBySolicitud(Solicitud solicitud);

    List<ContratoC> findByPersonaCContratante(PersonaC personaCContratante);

    List<ContratoC> findByDireccionesC(DireccionC direccionesC);

    List<ContratoC> findByObservacionesC(ObservacionesC observacionesC);

    List<ContratoC> findByBeneficiariosC(BeneficiarioC beneficiariosC);

    List<ContratoC> findByFamiliasC(FamiliaC familiasC);

    List<ContratoC> findByPeriodicidadC(Periodicidad periodicidadC);

    List<ContratoC> findByFormaPagoC(FormaPago formaPagoC);

    List<ContratoC> findByEstadoContratoC(EstadoContrato estadoContratoC);

    List<ContratoC> findByProductoC(Productos productoC);

    List<ContratoC> findByPlanC(Planes planC);

    List<ContratoC> findByGrupoAsociadoC(GrupoAsociado grupoAsociadoC);

    List<ContratoC> findByMunicipioC(Municipio municipioC);

    List<ContratoC> findByAsesorC(Asesor asesorC);
}
