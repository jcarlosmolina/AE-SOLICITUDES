package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class TENVIARDOCRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudTENVIARDOCpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudTENVIARDOCpthisSolicitudInstance;

    @JsonProperty("p_previsualizar")
    private Boolean solicitudTENVIARDOCpPrevisualizar;

    @JsonProperty("p_enviar")
    private Boolean solicitudTENVIARDOCpEnviar;

    @JsonProperty("p_contrato")
    private Boolean solicitudTENVIARDOCpContrato;

    @JsonProperty("p_carnets")
    private Boolean solicitudTENVIARDOCpCarnets;

    @JsonProperty("p_cartapre")
    private Boolean solicitudTENVIARDOCpCartaPre;

    @JsonProperty("p_solicitud")
    private Boolean solicitudTENVIARDOCpSolicitud;

    @JsonProperty("p_condicionesbb")
    private Boolean solicitudTENVIARDOCpCondicionesBB;

    @JsonProperty("p_anexosincl")
    private Boolean solicitudTENVIARDOCpAnexosIncl;

    @JsonProperty("p_docmaternidad")
    private Boolean solicitudTENVIARDOCpDocMaternidad;

    @JsonProperty("p_cuesmedico")
    private Boolean solicitudTENVIARDOCpCuesMedico;

    @JsonProperty("p_cartaentrevista")
    private Boolean solicitudTENVIARDOCpCartaEntrevista;

    @JsonProperty("p_protecciondatos")
    private Boolean solicitudTENVIARDOCpProteccionDatos;

    @JsonProperty("p_diferenciasliq")
    private Boolean solicitudTENVIARDOCpDiferenciasLiq;

    @JsonProperty("p_marcartodos")
    private Boolean solicitudTENVIARDOCpMarcarTodos;

    @JsonProperty("p_docneonatal")
    private Boolean solicitudTENVIARDOCpDocNeonatal;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudTENVIARDOCpthisSolicitud();
        checkSolicitudTENVIARDOCpPrevisualizar();
        checkSolicitudTENVIARDOCpEnviar();
        checkSolicitudTENVIARDOCpContrato();
        checkSolicitudTENVIARDOCpCarnets();
        checkSolicitudTENVIARDOCpCartaPre();
        checkSolicitudTENVIARDOCpSolicitud();
        checkSolicitudTENVIARDOCpCondicionesBB();
        checkSolicitudTENVIARDOCpAnexosIncl();
        checkSolicitudTENVIARDOCpDocMaternidad();
        checkSolicitudTENVIARDOCpCuesMedico();
        checkSolicitudTENVIARDOCpCartaEntrevista();
        checkSolicitudTENVIARDOCpProteccionDatos();
        checkSolicitudTENVIARDOCpDiferenciasLiq();
        checkSolicitudTENVIARDOCpMarcarTodos();
        checkSolicitudTENVIARDOCpDocNeonatal();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudTENVIARDOCpthisSolicitud() {
        return this.solicitudTENVIARDOCpthisSolicitud;
    }
    
    public void setSolicitudTENVIARDOCpthisSolicitud(SolicitudOid solicitudTENVIARDOCpthisSolicitud) {
        this.solicitudTENVIARDOCpthisSolicitud = solicitudTENVIARDOCpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudTENVIARDOCpthisSolicitudInstance() {
        return this.solicitudTENVIARDOCpthisSolicitudInstance;
    }
    
    public void setSolicitudTENVIARDOCpthisSolicitudInstance(Solicitud solicitudTENVIARDOCpthisSolicitud) {
        this.solicitudTENVIARDOCpthisSolicitudInstance = solicitudTENVIARDOCpthisSolicitud;
        this.solicitudTENVIARDOCpthisSolicitud = solicitudTENVIARDOCpthisSolicitud != null ? solicitudTENVIARDOCpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudTENVIARDOCpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudTENVIARDOCpthisSolicitudInstance() == null || this.getSolicitudTENVIARDOCpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TENVIARDOC, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TENVIARDOC_SOLICITUDTENVIARDOCPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_TENVIARDOC, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TENVIARDOC_SOLICITUDTENVIARDOCPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public Boolean getSolicitudTENVIARDOCpPrevisualizar() {
        return this.solicitudTENVIARDOCpPrevisualizar;
    }
    
    public void setSolicitudTENVIARDOCpPrevisualizar(Boolean solicitudTENVIARDOCpPrevisualizar) {
        this.solicitudTENVIARDOCpPrevisualizar = solicitudTENVIARDOCpPrevisualizar;
    }

    private void checkSolicitudTENVIARDOCpPrevisualizar() throws NotNullArgumentException {
        if(this.getSolicitudTENVIARDOCpPrevisualizar() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TENVIARDOC, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TENVIARDOC_SOLICITUDTENVIARDOCPPREVISUALIZAR, SolicitudConstants.SERV_ALIAS_TENVIARDOC, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TENVIARDOC_SOLICITUDTENVIARDOCPPREVISUALIZAR);
        }
    }

    @JsonIgnore
    public Boolean getSolicitudTENVIARDOCpEnviar() {
        return this.solicitudTENVIARDOCpEnviar;
    }
    
    public void setSolicitudTENVIARDOCpEnviar(Boolean solicitudTENVIARDOCpEnviar) {
        this.solicitudTENVIARDOCpEnviar = solicitudTENVIARDOCpEnviar;
    }

    private void checkSolicitudTENVIARDOCpEnviar() throws NotNullArgumentException {
        if(this.getSolicitudTENVIARDOCpEnviar() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TENVIARDOC, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TENVIARDOC_SOLICITUDTENVIARDOCPENVIAR, SolicitudConstants.SERV_ALIAS_TENVIARDOC, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TENVIARDOC_SOLICITUDTENVIARDOCPENVIAR);
        }
    }

    @JsonIgnore
    public Boolean getSolicitudTENVIARDOCpContrato() {
        return this.solicitudTENVIARDOCpContrato;
    }
    
    public void setSolicitudTENVIARDOCpContrato(Boolean solicitudTENVIARDOCpContrato) {
        this.solicitudTENVIARDOCpContrato = solicitudTENVIARDOCpContrato;
    }

    private void checkSolicitudTENVIARDOCpContrato() throws NotNullArgumentException {
        if(this.getSolicitudTENVIARDOCpContrato() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TENVIARDOC, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TENVIARDOC_SOLICITUDTENVIARDOCPCONTRATO, SolicitudConstants.SERV_ALIAS_TENVIARDOC, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TENVIARDOC_SOLICITUDTENVIARDOCPCONTRATO);
        }
    }

    @JsonIgnore
    public Boolean getSolicitudTENVIARDOCpCarnets() {
        return this.solicitudTENVIARDOCpCarnets;
    }
    
    public void setSolicitudTENVIARDOCpCarnets(Boolean solicitudTENVIARDOCpCarnets) {
        this.solicitudTENVIARDOCpCarnets = solicitudTENVIARDOCpCarnets;
    }

    private void checkSolicitudTENVIARDOCpCarnets() throws NotNullArgumentException {
        if(this.getSolicitudTENVIARDOCpCarnets() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TENVIARDOC, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TENVIARDOC_SOLICITUDTENVIARDOCPCARNETS, SolicitudConstants.SERV_ALIAS_TENVIARDOC, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TENVIARDOC_SOLICITUDTENVIARDOCPCARNETS);
        }
    }

    @JsonIgnore
    public Boolean getSolicitudTENVIARDOCpCartaPre() {
        return this.solicitudTENVIARDOCpCartaPre;
    }
    
    public void setSolicitudTENVIARDOCpCartaPre(Boolean solicitudTENVIARDOCpCartaPre) {
        this.solicitudTENVIARDOCpCartaPre = solicitudTENVIARDOCpCartaPre;
    }

    private void checkSolicitudTENVIARDOCpCartaPre() throws NotNullArgumentException {
        if(this.getSolicitudTENVIARDOCpCartaPre() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TENVIARDOC, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TENVIARDOC_SOLICITUDTENVIARDOCPCARTAPRE, SolicitudConstants.SERV_ALIAS_TENVIARDOC, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TENVIARDOC_SOLICITUDTENVIARDOCPCARTAPRE);
        }
    }

    @JsonIgnore
    public Boolean getSolicitudTENVIARDOCpSolicitud() {
        return this.solicitudTENVIARDOCpSolicitud;
    }
    
    public void setSolicitudTENVIARDOCpSolicitud(Boolean solicitudTENVIARDOCpSolicitud) {
        this.solicitudTENVIARDOCpSolicitud = solicitudTENVIARDOCpSolicitud;
    }

    private void checkSolicitudTENVIARDOCpSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudTENVIARDOCpSolicitud() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TENVIARDOC, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TENVIARDOC_SOLICITUDTENVIARDOCPSOLICITUD, SolicitudConstants.SERV_ALIAS_TENVIARDOC, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TENVIARDOC_SOLICITUDTENVIARDOCPSOLICITUD);
        }
    }

    @JsonIgnore
    public Boolean getSolicitudTENVIARDOCpCondicionesBB() {
        return this.solicitudTENVIARDOCpCondicionesBB;
    }
    
    public void setSolicitudTENVIARDOCpCondicionesBB(Boolean solicitudTENVIARDOCpCondicionesBB) {
        this.solicitudTENVIARDOCpCondicionesBB = solicitudTENVIARDOCpCondicionesBB;
    }

    private void checkSolicitudTENVIARDOCpCondicionesBB() throws NotNullArgumentException {
        if(this.getSolicitudTENVIARDOCpCondicionesBB() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TENVIARDOC, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TENVIARDOC_SOLICITUDTENVIARDOCPCONDICIONESBB, SolicitudConstants.SERV_ALIAS_TENVIARDOC, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TENVIARDOC_SOLICITUDTENVIARDOCPCONDICIONESBB);
        }
    }

    @JsonIgnore
    public Boolean getSolicitudTENVIARDOCpAnexosIncl() {
        return this.solicitudTENVIARDOCpAnexosIncl;
    }
    
    public void setSolicitudTENVIARDOCpAnexosIncl(Boolean solicitudTENVIARDOCpAnexosIncl) {
        this.solicitudTENVIARDOCpAnexosIncl = solicitudTENVIARDOCpAnexosIncl;
    }

    private void checkSolicitudTENVIARDOCpAnexosIncl() throws NotNullArgumentException {
        if(this.getSolicitudTENVIARDOCpAnexosIncl() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TENVIARDOC, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TENVIARDOC_SOLICITUDTENVIARDOCPANEXOSINCL, SolicitudConstants.SERV_ALIAS_TENVIARDOC, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TENVIARDOC_SOLICITUDTENVIARDOCPANEXOSINCL);
        }
    }

    @JsonIgnore
    public Boolean getSolicitudTENVIARDOCpDocMaternidad() {
        return this.solicitudTENVIARDOCpDocMaternidad;
    }
    
    public void setSolicitudTENVIARDOCpDocMaternidad(Boolean solicitudTENVIARDOCpDocMaternidad) {
        this.solicitudTENVIARDOCpDocMaternidad = solicitudTENVIARDOCpDocMaternidad;
    }

    private void checkSolicitudTENVIARDOCpDocMaternidad() throws NotNullArgumentException {
        if(this.getSolicitudTENVIARDOCpDocMaternidad() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TENVIARDOC, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TENVIARDOC_SOLICITUDTENVIARDOCPDOCMATERNIDAD, SolicitudConstants.SERV_ALIAS_TENVIARDOC, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TENVIARDOC_SOLICITUDTENVIARDOCPDOCMATERNIDAD);
        }
    }

    @JsonIgnore
    public Boolean getSolicitudTENVIARDOCpCuesMedico() {
        return this.solicitudTENVIARDOCpCuesMedico;
    }
    
    public void setSolicitudTENVIARDOCpCuesMedico(Boolean solicitudTENVIARDOCpCuesMedico) {
        this.solicitudTENVIARDOCpCuesMedico = solicitudTENVIARDOCpCuesMedico;
    }

    private void checkSolicitudTENVIARDOCpCuesMedico() throws NotNullArgumentException {
        if(this.getSolicitudTENVIARDOCpCuesMedico() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TENVIARDOC, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TENVIARDOC_SOLICITUDTENVIARDOCPCUESMEDICO, SolicitudConstants.SERV_ALIAS_TENVIARDOC, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TENVIARDOC_SOLICITUDTENVIARDOCPCUESMEDICO);
        }
    }

    @JsonIgnore
    public Boolean getSolicitudTENVIARDOCpCartaEntrevista() {
        return this.solicitudTENVIARDOCpCartaEntrevista;
    }
    
    public void setSolicitudTENVIARDOCpCartaEntrevista(Boolean solicitudTENVIARDOCpCartaEntrevista) {
        this.solicitudTENVIARDOCpCartaEntrevista = solicitudTENVIARDOCpCartaEntrevista;
    }

    private void checkSolicitudTENVIARDOCpCartaEntrevista() throws NotNullArgumentException {
        if(this.getSolicitudTENVIARDOCpCartaEntrevista() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TENVIARDOC, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TENVIARDOC_SOLICITUDTENVIARDOCPCARTAENTREVISTA, SolicitudConstants.SERV_ALIAS_TENVIARDOC, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TENVIARDOC_SOLICITUDTENVIARDOCPCARTAENTREVISTA);
        }
    }

    @JsonIgnore
    public Boolean getSolicitudTENVIARDOCpProteccionDatos() {
        return this.solicitudTENVIARDOCpProteccionDatos;
    }
    
    public void setSolicitudTENVIARDOCpProteccionDatos(Boolean solicitudTENVIARDOCpProteccionDatos) {
        this.solicitudTENVIARDOCpProteccionDatos = solicitudTENVIARDOCpProteccionDatos;
    }

    private void checkSolicitudTENVIARDOCpProteccionDatos() throws NotNullArgumentException {
        if(this.getSolicitudTENVIARDOCpProteccionDatos() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TENVIARDOC, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TENVIARDOC_SOLICITUDTENVIARDOCPPROTECCIONDATOS, SolicitudConstants.SERV_ALIAS_TENVIARDOC, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TENVIARDOC_SOLICITUDTENVIARDOCPPROTECCIONDATOS);
        }
    }

    @JsonIgnore
    public Boolean getSolicitudTENVIARDOCpDiferenciasLiq() {
        return this.solicitudTENVIARDOCpDiferenciasLiq;
    }
    
    public void setSolicitudTENVIARDOCpDiferenciasLiq(Boolean solicitudTENVIARDOCpDiferenciasLiq) {
        this.solicitudTENVIARDOCpDiferenciasLiq = solicitudTENVIARDOCpDiferenciasLiq;
    }

    private void checkSolicitudTENVIARDOCpDiferenciasLiq() throws NotNullArgumentException {
        if(this.getSolicitudTENVIARDOCpDiferenciasLiq() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TENVIARDOC, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TENVIARDOC_SOLICITUDTENVIARDOCPDIFERENCIASLIQ, SolicitudConstants.SERV_ALIAS_TENVIARDOC, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TENVIARDOC_SOLICITUDTENVIARDOCPDIFERENCIASLIQ);
        }
    }

    @JsonIgnore
    public Boolean getSolicitudTENVIARDOCpMarcarTodos() {
        return this.solicitudTENVIARDOCpMarcarTodos;
    }
    
    public void setSolicitudTENVIARDOCpMarcarTodos(Boolean solicitudTENVIARDOCpMarcarTodos) {
        this.solicitudTENVIARDOCpMarcarTodos = solicitudTENVIARDOCpMarcarTodos;
    }

    private void checkSolicitudTENVIARDOCpMarcarTodos() throws NotNullArgumentException {
        if(this.getSolicitudTENVIARDOCpMarcarTodos() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TENVIARDOC, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TENVIARDOC_SOLICITUDTENVIARDOCPMARCARTODOS, SolicitudConstants.SERV_ALIAS_TENVIARDOC, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TENVIARDOC_SOLICITUDTENVIARDOCPMARCARTODOS);
        }
    }

    @JsonIgnore
    public Boolean getSolicitudTENVIARDOCpDocNeonatal() {
        return this.solicitudTENVIARDOCpDocNeonatal;
    }
    
    public void setSolicitudTENVIARDOCpDocNeonatal(Boolean solicitudTENVIARDOCpDocNeonatal) {
        this.solicitudTENVIARDOCpDocNeonatal = solicitudTENVIARDOCpDocNeonatal;
    }

    private void checkSolicitudTENVIARDOCpDocNeonatal() throws NotNullArgumentException {
        if(this.getSolicitudTENVIARDOCpDocNeonatal() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TENVIARDOC, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TENVIARDOC_SOLICITUDTENVIARDOCPDOCNEONATAL, SolicitudConstants.SERV_ALIAS_TENVIARDOC, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TENVIARDOC_SOLICITUDTENVIARDOCPDOCNEONATAL);
        }
    }
}
