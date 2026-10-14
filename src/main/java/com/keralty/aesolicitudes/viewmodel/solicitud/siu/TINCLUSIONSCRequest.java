package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.Aesolicitudes;
import com.keralty.aesolicitudes.persistence.oid.AesolicitudesOid;
import com.keralty.aesolicitudes.persistence.oid.ProteccionDatosOid;
import com.keralty.aesolicitudes.persistence.ProteccionDatos;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class TINCLUSIONSCRequest {

    @JsonProperty("pt_p_agrae_solicitudes_oid")
    private AesolicitudesOid solicitudTINCLUSIONSCptpagrAESOLICITUDES;
    
    @JsonIgnore
    private Aesolicitudes solicitudTINCLUSIONSCptpagrAESOLICITUDESInstance;

    @JsonProperty("pt_p_agrprotecciondatos_oid")
    private ProteccionDatosOid solicitudTINCLUSIONSCptpagrProteccionDatos;
    
    @JsonIgnore
    private ProteccionDatos solicitudTINCLUSIONSCptpagrProteccionDatosInstance;

    @JsonProperty("pt_p_atrfiniciocontrato")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date solicitudTINCLUSIONSCptpatrFInicioContrato;

    @JsonProperty("pt_p_atrnumcontratoinclusion")
    private String solicitudTINCLUSIONSCptpatrNumContratoInclusion;

    @JsonProperty("pt_p_atrnumfamilia")
    private String solicitudTINCLUSIONSCptpatrNumFamilia;

    @JsonProperty("pcoddirector")
    private String solicitudTINCLUSIONSCpCodDirector;

    @JsonProperty("ptporcenprorrateo")
    private Double solicitudTINCLUSIONSCptPorcenProrrateo;

    @JsonProperty("ptmarcacarnet")
    private Boolean solicitudTINCLUSIONSCptMarcaCarnet;

    @JsonProperty("ptnumradicado")
    private Long solicitudTINCLUSIONSCptNumRadicado;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudTINCLUSIONSCptpagrAESOLICITUDES();
        checkSolicitudTINCLUSIONSCpCodDirector();
        checkSolicitudTINCLUSIONSCptMarcaCarnet();
        checkSolicitudTINCLUSIONSCptNumRadicado();
    }

    @JsonIgnore
    public AesolicitudesOid getSolicitudTINCLUSIONSCptpagrAESOLICITUDES() {
        return this.solicitudTINCLUSIONSCptpagrAESOLICITUDES;
    }
    
    public void setSolicitudTINCLUSIONSCptpagrAESOLICITUDES(AesolicitudesOid solicitudTINCLUSIONSCptpagrAESOLICITUDES) {
        this.solicitudTINCLUSIONSCptpagrAESOLICITUDES = solicitudTINCLUSIONSCptpagrAESOLICITUDES;
    }

    @JsonIgnore
    public Aesolicitudes getSolicitudTINCLUSIONSCptpagrAESOLICITUDESInstance() {
        return this.solicitudTINCLUSIONSCptpagrAESOLICITUDESInstance;
    }
    
    public void setSolicitudTINCLUSIONSCptpagrAESOLICITUDESInstance(Aesolicitudes solicitudTINCLUSIONSCptpagrAESOLICITUDES) {
        this.solicitudTINCLUSIONSCptpagrAESOLICITUDESInstance = solicitudTINCLUSIONSCptpagrAESOLICITUDES;
        this.solicitudTINCLUSIONSCptpagrAESOLICITUDES = solicitudTINCLUSIONSCptpagrAESOLICITUDES != null ? solicitudTINCLUSIONSCptpagrAESOLICITUDES.getOid() : null;
    }

    private void checkSolicitudTINCLUSIONSCptpagrAESOLICITUDES() throws NotNullArgumentException {
        if(this.getSolicitudTINCLUSIONSCptpagrAESOLICITUDESInstance() == null || this.getSolicitudTINCLUSIONSCptpagrAESOLICITUDESInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINCLUSIONSC, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINCLUSIONSC_SOLICITUDTINCLUSIONSCPTPAGRAESOLICITUDES, SolicitudConstants.SERV_ALIAS_TINCLUSIONSC, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINCLUSIONSC_SOLICITUDTINCLUSIONSCPTPAGRAESOLICITUDES);
        }
    }

    @JsonIgnore
    public ProteccionDatosOid getSolicitudTINCLUSIONSCptpagrProteccionDatos() {
        return this.solicitudTINCLUSIONSCptpagrProteccionDatos;
    }
    
    public void setSolicitudTINCLUSIONSCptpagrProteccionDatos(ProteccionDatosOid solicitudTINCLUSIONSCptpagrProteccionDatos) {
        this.solicitudTINCLUSIONSCptpagrProteccionDatos = solicitudTINCLUSIONSCptpagrProteccionDatos;
    }

    @JsonIgnore
    public ProteccionDatos getSolicitudTINCLUSIONSCptpagrProteccionDatosInstance() {
        return this.solicitudTINCLUSIONSCptpagrProteccionDatosInstance;
    }
    
    public void setSolicitudTINCLUSIONSCptpagrProteccionDatosInstance(ProteccionDatos solicitudTINCLUSIONSCptpagrProteccionDatos) {
        this.solicitudTINCLUSIONSCptpagrProteccionDatosInstance = solicitudTINCLUSIONSCptpagrProteccionDatos;
        this.solicitudTINCLUSIONSCptpagrProteccionDatos = solicitudTINCLUSIONSCptpagrProteccionDatos != null ? solicitudTINCLUSIONSCptpagrProteccionDatos.getOid() : null;
    }

    @JsonIgnore
    public Date getSolicitudTINCLUSIONSCptpatrFInicioContrato() {
        return this.solicitudTINCLUSIONSCptpatrFInicioContrato;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setSolicitudTINCLUSIONSCptpatrFInicioContrato(Date solicitudTINCLUSIONSCptpatrFInicioContrato) {
        this.solicitudTINCLUSIONSCptpatrFInicioContrato = solicitudTINCLUSIONSCptpatrFInicioContrato;
    }

    @JsonIgnore
    public String getSolicitudTINCLUSIONSCptpatrNumContratoInclusion() {
        return this.solicitudTINCLUSIONSCptpatrNumContratoInclusion;
    }
    
    public void setSolicitudTINCLUSIONSCptpatrNumContratoInclusion(String solicitudTINCLUSIONSCptpatrNumContratoInclusion) {
        this.solicitudTINCLUSIONSCptpatrNumContratoInclusion = solicitudTINCLUSIONSCptpatrNumContratoInclusion;
    }

    @JsonIgnore
    public String getSolicitudTINCLUSIONSCptpatrNumFamilia() {
        return this.solicitudTINCLUSIONSCptpatrNumFamilia;
    }
    
    public void setSolicitudTINCLUSIONSCptpatrNumFamilia(String solicitudTINCLUSIONSCptpatrNumFamilia) {
        this.solicitudTINCLUSIONSCptpatrNumFamilia = solicitudTINCLUSIONSCptpatrNumFamilia;
    }

    @JsonIgnore
    public String getSolicitudTINCLUSIONSCpCodDirector() {
        return this.solicitudTINCLUSIONSCpCodDirector;
    }
    
    public void setSolicitudTINCLUSIONSCpCodDirector(String solicitudTINCLUSIONSCpCodDirector) {
        this.solicitudTINCLUSIONSCpCodDirector = solicitudTINCLUSIONSCpCodDirector;
    }

    private void checkSolicitudTINCLUSIONSCpCodDirector() throws NotNullArgumentException {
        if(this.getSolicitudTINCLUSIONSCpCodDirector() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINCLUSIONSC, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINCLUSIONSC_SOLICITUDTINCLUSIONSCPCODDIRECTOR, SolicitudConstants.SERV_ALIAS_TINCLUSIONSC, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINCLUSIONSC_SOLICITUDTINCLUSIONSCPCODDIRECTOR);
        }
    }

    @JsonIgnore
    public Double getSolicitudTINCLUSIONSCptPorcenProrrateo() {
        return this.solicitudTINCLUSIONSCptPorcenProrrateo;
    }
    
    public void setSolicitudTINCLUSIONSCptPorcenProrrateo(Double solicitudTINCLUSIONSCptPorcenProrrateo) {
        this.solicitudTINCLUSIONSCptPorcenProrrateo = solicitudTINCLUSIONSCptPorcenProrrateo;
    }

    @JsonIgnore
    public Boolean getSolicitudTINCLUSIONSCptMarcaCarnet() {
        return this.solicitudTINCLUSIONSCptMarcaCarnet;
    }
    
    public void setSolicitudTINCLUSIONSCptMarcaCarnet(Boolean solicitudTINCLUSIONSCptMarcaCarnet) {
        this.solicitudTINCLUSIONSCptMarcaCarnet = solicitudTINCLUSIONSCptMarcaCarnet;
    }

    private void checkSolicitudTINCLUSIONSCptMarcaCarnet() throws NotNullArgumentException {
        if(this.getSolicitudTINCLUSIONSCptMarcaCarnet() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINCLUSIONSC, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINCLUSIONSC_SOLICITUDTINCLUSIONSCPTMARCACARNET, SolicitudConstants.SERV_ALIAS_TINCLUSIONSC, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINCLUSIONSC_SOLICITUDTINCLUSIONSCPTMARCACARNET);
        }
    }

    @JsonIgnore
    public Long getSolicitudTINCLUSIONSCptNumRadicado() {
        return this.solicitudTINCLUSIONSCptNumRadicado;
    }
    
    public void setSolicitudTINCLUSIONSCptNumRadicado(Long solicitudTINCLUSIONSCptNumRadicado) {
        this.solicitudTINCLUSIONSCptNumRadicado = solicitudTINCLUSIONSCptNumRadicado;
    }

    private void checkSolicitudTINCLUSIONSCptNumRadicado() throws NotNullArgumentException {
        if(this.getSolicitudTINCLUSIONSCptNumRadicado() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINCLUSIONSC, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINCLUSIONSC_SOLICITUDTINCLUSIONSCPTNUMRADICADO, SolicitudConstants.SERV_ALIAS_TINCLUSIONSC, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINCLUSIONSC_SOLICITUDTINCLUSIONSCPTNUMRADICADO);
        }
    }
}
