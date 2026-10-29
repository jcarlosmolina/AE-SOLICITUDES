package com.keralty.aesolicitudes.repository;

import com.keralty.aesolicitudes.persistence.Aesolicitudes;
import com.keralty.aesolicitudes.persistence.AreaMedica;
import com.keralty.aesolicitudes.persistence.Contratante;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.Direccion;
import com.keralty.aesolicitudes.persistence.DocumentoG;
import com.keralty.aesolicitudes.persistence.ErrorWS;
import com.keralty.aesolicitudes.persistence.Firma;
import com.keralty.aesolicitudes.persistence.FormaPago;
import com.keralty.aesolicitudes.persistence.Funcionario;
import com.keralty.aesolicitudes.persistence.GrupoAsociado;
import com.keralty.aesolicitudes.persistence.LogAsignaciones;
import com.keralty.aesolicitudes.persistence.LogEstado;
import com.keralty.aesolicitudes.persistence.Periodicidad;
import com.keralty.aesolicitudes.persistence.Persona;
import com.keralty.aesolicitudes.persistence.ProteccionDatos;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.persistence.TipoFactura;
import com.keralty.aesolicitudes.persistence.Titular;
import com.keralty.aesolicitudes.persistence.Usuario;
import com.keralty.aesolicitudes.persistence.UsuarioReg;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudJpaRepository extends JpaRepository<Solicitud, Long>, SolicitudJpaRepositoryCustom {

    List<Solicitud> findByDireccion(Direccion direccion);

    List<Solicitud> findByProteccionDatos(ProteccionDatos proteccionDatos);

    List<Solicitud> findByUsuarios(Usuario usuarios);

    List<Solicitud> findByContratante(Contratante contratante);

    List<Solicitud> findByFirma(Firma firma);

    List<Solicitud> findBySegundaFirma(Firma segundaFirma);

    List<Solicitud> findByFirmaContratanteIncl(Firma firmaContratanteIncl);

    List<Solicitud> findByUsuariosRegistrados(UsuarioReg usuariosRegistrados);

    List<Solicitud> findByTitular(Titular titular);

    List<Solicitud> findByDocumentosGestor(DocumentoG documentosGestor);

    List<Solicitud> findByErroresWS(ErrorWS erroresWS);

    List<Solicitud> findByLogEstado(LogEstado logEstado);

    List<Solicitud> findByLogAsignaciones(LogAsignaciones logAsignaciones);

    List<Solicitud> findByAesolicitudes(Aesolicitudes aesolicitudes);

    List<Solicitud> findByContratantePersona(Persona contratantePersona);

    List<Solicitud> findByTitularPersona(Persona titularPersona);

    List<Solicitud> findByGrupoAsociado(GrupoAsociado grupoAsociado);

    List<Solicitud> findByAgente(Funcionario agente);

    List<Solicitud> findByFormaPago(FormaPago formaPago);

    List<Solicitud> findByPeriodicidad(Periodicidad periodicidad);

    List<Solicitud> findByContratoC(ContratoC contratoC);

    List<Solicitud> findByUsrAreaMedica(AreaMedica usrAreaMedica);

    List<Solicitud> findByTipoFactura(TipoFactura tipoFactura);

    List<Solicitud> findByUsrAfiliacion(Funcionario usrAfiliacion);
}
