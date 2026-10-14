package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.Aesolicitudes;
import com.keralty.aesolicitudes.persistence.GrupoAsociado;
import com.keralty.aesolicitudes.persistence.oid.AesolicitudesOid;
import com.keralty.aesolicitudes.persistence.oid.GrupoAsociadoOid;
import com.keralty.aesolicitudes.persistence.oid.ProteccionDatosOid;
import com.keralty.aesolicitudes.persistence.oid.TipoFacturaOid;
import com.keralty.aesolicitudes.persistence.ProteccionDatos;
import com.keralty.aesolicitudes.persistence.TipoFactura;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class TNUEVAAFILIACIONRequest {

    @JsonProperty("pt_p_agrae_solicitudes_oid")
    private AesolicitudesOid solicitudTNUEVAAFILIACIONptpagrAESOLICITUDES;
    
    @JsonIgnore
    private Aesolicitudes solicitudTNUEVAAFILIACIONptpagrAESOLICITUDESInstance;

    @JsonProperty("pt_p_agrprotecciondatos_oid")
    private ProteccionDatosOid solicitudTNUEVAAFILIACIONptpagrProteccionDatos;
    
    @JsonIgnore
    private ProteccionDatos solicitudTNUEVAAFILIACIONptpagrProteccionDatosInstance;

    @JsonProperty("pt_p_agrgrupoasociado_oid")
    private GrupoAsociadoOid solicitudTNUEVAAFILIACIONptpagrGrupoAsociado;
    
    @JsonIgnore
    private GrupoAsociado solicitudTNUEVAAFILIACIONptpagrGrupoAsociadoInstance;

    @JsonProperty("pt_p_atrfiniciocontrato")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date solicitudTNUEVAAFILIACIONptpatrFInicioContrato;

    @JsonProperty("pt_p_atrestraslado")
    private Boolean solicitudTNUEVAAFILIACIONptpatrEsTraslado;

    @JsonProperty("pcoddirector")
    private String solicitudTNUEVAAFILIACIONpCodDirector;

    @JsonProperty("ptporcenprorrateo")
    private Double solicitudTNUEVAAFILIACIONptPorcenProrrateo;

    @JsonProperty("pttipofactura_oid")
    private TipoFacturaOid solicitudTNUEVAAFILIACIONptTipoFactura;
    
    @JsonIgnore
    private TipoFactura solicitudTNUEVAAFILIACIONptTipoFacturaInstance;

    @JsonProperty("ptmarcacarnet")
    private Boolean solicitudTNUEVAAFILIACIONptMarcaCarnet;

    @JsonProperty("ptnumradicado")
    private Long solicitudTNUEVAAFILIACIONptNumRadicado;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudTNUEVAAFILIACIONptpagrAESOLICITUDES();
        checkSolicitudTNUEVAAFILIACIONptpatrEsTraslado();
        checkSolicitudTNUEVAAFILIACIONpCodDirector();
        checkSolicitudTNUEVAAFILIACIONptMarcaCarnet();
        checkSolicitudTNUEVAAFILIACIONptNumRadicado();
    }

    @JsonIgnore
    public AesolicitudesOid getSolicitudTNUEVAAFILIACIONptpagrAESOLICITUDES() {
        return this.solicitudTNUEVAAFILIACIONptpagrAESOLICITUDES;
    }
    
    public void setSolicitudTNUEVAAFILIACIONptpagrAESOLICITUDES(AesolicitudesOid solicitudTNUEVAAFILIACIONptpagrAESOLICITUDES) {
        this.solicitudTNUEVAAFILIACIONptpagrAESOLICITUDES = solicitudTNUEVAAFILIACIONptpagrAESOLICITUDES;
    }

    @JsonIgnore
    public Aesolicitudes getSolicitudTNUEVAAFILIACIONptpagrAESOLICITUDESInstance() {
        return this.solicitudTNUEVAAFILIACIONptpagrAESOLICITUDESInstance;
    }
    
    public void setSolicitudTNUEVAAFILIACIONptpagrAESOLICITUDESInstance(Aesolicitudes solicitudTNUEVAAFILIACIONptpagrAESOLICITUDES) {
        this.solicitudTNUEVAAFILIACIONptpagrAESOLICITUDESInstance = solicitudTNUEVAAFILIACIONptpagrAESOLICITUDES;
        this.solicitudTNUEVAAFILIACIONptpagrAESOLICITUDES = solicitudTNUEVAAFILIACIONptpagrAESOLICITUDES != null ? solicitudTNUEVAAFILIACIONptpagrAESOLICITUDES.getOid() : null;
    }

    private void checkSolicitudTNUEVAAFILIACIONptpagrAESOLICITUDES() throws NotNullArgumentException {
        if(this.getSolicitudTNUEVAAFILIACIONptpagrAESOLICITUDESInstance() == null || this.getSolicitudTNUEVAAFILIACIONptpagrAESOLICITUDESInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TNUEVAAFILIACION, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TNUEVAAFILIACION_SOLICITUDTNUEVAAFILIACIONPTPAGRAESOLICITUDES, SolicitudConstants.SERV_ALIAS_TNUEVAAFILIACION, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TNUEVAAFILIACION_SOLICITUDTNUEVAAFILIACIONPTPAGRAESOLICITUDES);
        }
    }

    @JsonIgnore
    public ProteccionDatosOid getSolicitudTNUEVAAFILIACIONptpagrProteccionDatos() {
        return this.solicitudTNUEVAAFILIACIONptpagrProteccionDatos;
    }
    
    public void setSolicitudTNUEVAAFILIACIONptpagrProteccionDatos(ProteccionDatosOid solicitudTNUEVAAFILIACIONptpagrProteccionDatos) {
        this.solicitudTNUEVAAFILIACIONptpagrProteccionDatos = solicitudTNUEVAAFILIACIONptpagrProteccionDatos;
    }

    @JsonIgnore
    public ProteccionDatos getSolicitudTNUEVAAFILIACIONptpagrProteccionDatosInstance() {
        return this.solicitudTNUEVAAFILIACIONptpagrProteccionDatosInstance;
    }
    
    public void setSolicitudTNUEVAAFILIACIONptpagrProteccionDatosInstance(ProteccionDatos solicitudTNUEVAAFILIACIONptpagrProteccionDatos) {
        this.solicitudTNUEVAAFILIACIONptpagrProteccionDatosInstance = solicitudTNUEVAAFILIACIONptpagrProteccionDatos;
        this.solicitudTNUEVAAFILIACIONptpagrProteccionDatos = solicitudTNUEVAAFILIACIONptpagrProteccionDatos != null ? solicitudTNUEVAAFILIACIONptpagrProteccionDatos.getOid() : null;
    }

    @JsonIgnore
    public GrupoAsociadoOid getSolicitudTNUEVAAFILIACIONptpagrGrupoAsociado() {
        return this.solicitudTNUEVAAFILIACIONptpagrGrupoAsociado;
    }
    
    public void setSolicitudTNUEVAAFILIACIONptpagrGrupoAsociado(GrupoAsociadoOid solicitudTNUEVAAFILIACIONptpagrGrupoAsociado) {
        this.solicitudTNUEVAAFILIACIONptpagrGrupoAsociado = solicitudTNUEVAAFILIACIONptpagrGrupoAsociado;
    }

    @JsonIgnore
    public GrupoAsociado getSolicitudTNUEVAAFILIACIONptpagrGrupoAsociadoInstance() {
        return this.solicitudTNUEVAAFILIACIONptpagrGrupoAsociadoInstance;
    }
    
    public void setSolicitudTNUEVAAFILIACIONptpagrGrupoAsociadoInstance(GrupoAsociado solicitudTNUEVAAFILIACIONptpagrGrupoAsociado) {
        this.solicitudTNUEVAAFILIACIONptpagrGrupoAsociadoInstance = solicitudTNUEVAAFILIACIONptpagrGrupoAsociado;
        this.solicitudTNUEVAAFILIACIONptpagrGrupoAsociado = solicitudTNUEVAAFILIACIONptpagrGrupoAsociado != null ? solicitudTNUEVAAFILIACIONptpagrGrupoAsociado.getOid() : null;
    }

    @JsonIgnore
    public Date getSolicitudTNUEVAAFILIACIONptpatrFInicioContrato() {
        return this.solicitudTNUEVAAFILIACIONptpatrFInicioContrato;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setSolicitudTNUEVAAFILIACIONptpatrFInicioContrato(Date solicitudTNUEVAAFILIACIONptpatrFInicioContrato) {
        this.solicitudTNUEVAAFILIACIONptpatrFInicioContrato = solicitudTNUEVAAFILIACIONptpatrFInicioContrato;
    }

    @JsonIgnore
    public Boolean getSolicitudTNUEVAAFILIACIONptpatrEsTraslado() {
        return this.solicitudTNUEVAAFILIACIONptpatrEsTraslado;
    }
    
    public void setSolicitudTNUEVAAFILIACIONptpatrEsTraslado(Boolean solicitudTNUEVAAFILIACIONptpatrEsTraslado) {
        this.solicitudTNUEVAAFILIACIONptpatrEsTraslado = solicitudTNUEVAAFILIACIONptpatrEsTraslado;
    }

    private void checkSolicitudTNUEVAAFILIACIONptpatrEsTraslado() throws NotNullArgumentException {
        if(this.getSolicitudTNUEVAAFILIACIONptpatrEsTraslado() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TNUEVAAFILIACION, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TNUEVAAFILIACION_SOLICITUDTNUEVAAFILIACIONPTPATRESTRASLADO, SolicitudConstants.SERV_ALIAS_TNUEVAAFILIACION, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TNUEVAAFILIACION_SOLICITUDTNUEVAAFILIACIONPTPATRESTRASLADO);
        }
    }

    @JsonIgnore
    public String getSolicitudTNUEVAAFILIACIONpCodDirector() {
        return this.solicitudTNUEVAAFILIACIONpCodDirector;
    }
    
    public void setSolicitudTNUEVAAFILIACIONpCodDirector(String solicitudTNUEVAAFILIACIONpCodDirector) {
        this.solicitudTNUEVAAFILIACIONpCodDirector = solicitudTNUEVAAFILIACIONpCodDirector;
    }

    private void checkSolicitudTNUEVAAFILIACIONpCodDirector() throws NotNullArgumentException {
        if(this.getSolicitudTNUEVAAFILIACIONpCodDirector() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TNUEVAAFILIACION, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TNUEVAAFILIACION_SOLICITUDTNUEVAAFILIACIONPCODDIRECTOR, SolicitudConstants.SERV_ALIAS_TNUEVAAFILIACION, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TNUEVAAFILIACION_SOLICITUDTNUEVAAFILIACIONPCODDIRECTOR);
        }
    }

    @JsonIgnore
    public Double getSolicitudTNUEVAAFILIACIONptPorcenProrrateo() {
        return this.solicitudTNUEVAAFILIACIONptPorcenProrrateo;
    }
    
    public void setSolicitudTNUEVAAFILIACIONptPorcenProrrateo(Double solicitudTNUEVAAFILIACIONptPorcenProrrateo) {
        this.solicitudTNUEVAAFILIACIONptPorcenProrrateo = solicitudTNUEVAAFILIACIONptPorcenProrrateo;
    }

    @JsonIgnore
    public TipoFacturaOid getSolicitudTNUEVAAFILIACIONptTipoFactura() {
        return this.solicitudTNUEVAAFILIACIONptTipoFactura;
    }
    
    public void setSolicitudTNUEVAAFILIACIONptTipoFactura(TipoFacturaOid solicitudTNUEVAAFILIACIONptTipoFactura) {
        this.solicitudTNUEVAAFILIACIONptTipoFactura = solicitudTNUEVAAFILIACIONptTipoFactura;
    }

    @JsonIgnore
    public TipoFactura getSolicitudTNUEVAAFILIACIONptTipoFacturaInstance() {
        return this.solicitudTNUEVAAFILIACIONptTipoFacturaInstance;
    }
    
    public void setSolicitudTNUEVAAFILIACIONptTipoFacturaInstance(TipoFactura solicitudTNUEVAAFILIACIONptTipoFactura) {
        this.solicitudTNUEVAAFILIACIONptTipoFacturaInstance = solicitudTNUEVAAFILIACIONptTipoFactura;
        this.solicitudTNUEVAAFILIACIONptTipoFactura = solicitudTNUEVAAFILIACIONptTipoFactura != null ? solicitudTNUEVAAFILIACIONptTipoFactura.getOid() : null;
    }

    @JsonIgnore
    public Boolean getSolicitudTNUEVAAFILIACIONptMarcaCarnet() {
        return this.solicitudTNUEVAAFILIACIONptMarcaCarnet;
    }
    
    public void setSolicitudTNUEVAAFILIACIONptMarcaCarnet(Boolean solicitudTNUEVAAFILIACIONptMarcaCarnet) {
        this.solicitudTNUEVAAFILIACIONptMarcaCarnet = solicitudTNUEVAAFILIACIONptMarcaCarnet;
    }

    private void checkSolicitudTNUEVAAFILIACIONptMarcaCarnet() throws NotNullArgumentException {
        if(this.getSolicitudTNUEVAAFILIACIONptMarcaCarnet() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TNUEVAAFILIACION, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TNUEVAAFILIACION_SOLICITUDTNUEVAAFILIACIONPTMARCACARNET, SolicitudConstants.SERV_ALIAS_TNUEVAAFILIACION, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TNUEVAAFILIACION_SOLICITUDTNUEVAAFILIACIONPTMARCACARNET);
        }
    }

    @JsonIgnore
    public Long getSolicitudTNUEVAAFILIACIONptNumRadicado() {
        return this.solicitudTNUEVAAFILIACIONptNumRadicado;
    }
    
    public void setSolicitudTNUEVAAFILIACIONptNumRadicado(Long solicitudTNUEVAAFILIACIONptNumRadicado) {
        this.solicitudTNUEVAAFILIACIONptNumRadicado = solicitudTNUEVAAFILIACIONptNumRadicado;
    }

    private void checkSolicitudTNUEVAAFILIACIONptNumRadicado() throws NotNullArgumentException {
        if(this.getSolicitudTNUEVAAFILIACIONptNumRadicado() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TNUEVAAFILIACION, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TNUEVAAFILIACION_SOLICITUDTNUEVAAFILIACIONPTNUMRADICADO, SolicitudConstants.SERV_ALIAS_TNUEVAAFILIACION, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TNUEVAAFILIACION_SOLICITUDTNUEVAAFILIACIONPTNUMRADICADO);
        }
    }
}
