package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.GrupoAsociado;
import com.keralty.aesolicitudes.persistence.oid.GrupoAsociadoOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Prorrateo;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.persistence.TipoFactura;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class TMODENCABEZADORequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudTMODENCABEZADOpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudTMODENCABEZADOpthisSolicitudInstance;

    @JsonProperty("pt_ptfecha")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date solicitudTMODENCABEZADOptptFecha;

    @JsonProperty("ptgrupoasociado_oid")
    private GrupoAsociadoOid solicitudTMODENCABEZADOptGrupoAsociado;
    
    @JsonIgnore
    private GrupoAsociado solicitudTMODENCABEZADOptGrupoAsociadoInstance;

    @JsonProperty("ptprorrateo_json")
    private String solicitudTMODENCABEZADOptProrrateo;
    
    @JsonIgnore
    private Prorrateo solicitudTMODENCABEZADOptProrrateoInstance;

    @JsonProperty("pttipofactura_json")
    private String solicitudTMODENCABEZADOptTipoFactura;
    
    @JsonIgnore
    private TipoFactura solicitudTMODENCABEZADOptTipoFacturaInstance;

    @JsonProperty("ptsolodiauno")
    private Boolean solicitudTMODENCABEZADOptSoloDiaUno;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudTMODENCABEZADOpthisSolicitud();
        checkSolicitudTMODENCABEZADOptTipoFactura();
        checkSolicitudTMODENCABEZADOptSoloDiaUno();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudTMODENCABEZADOpthisSolicitud() {
        return this.solicitudTMODENCABEZADOpthisSolicitud;
    }
    
    public void setSolicitudTMODENCABEZADOpthisSolicitud(SolicitudOid solicitudTMODENCABEZADOpthisSolicitud) {
        this.solicitudTMODENCABEZADOpthisSolicitud = solicitudTMODENCABEZADOpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudTMODENCABEZADOpthisSolicitudInstance() {
        return this.solicitudTMODENCABEZADOpthisSolicitudInstance;
    }
    
    public void setSolicitudTMODENCABEZADOpthisSolicitudInstance(Solicitud solicitudTMODENCABEZADOpthisSolicitud) {
        this.solicitudTMODENCABEZADOpthisSolicitudInstance = solicitudTMODENCABEZADOpthisSolicitud;
        this.solicitudTMODENCABEZADOpthisSolicitud = solicitudTMODENCABEZADOpthisSolicitud != null ? solicitudTMODENCABEZADOpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudTMODENCABEZADOpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudTMODENCABEZADOpthisSolicitudInstance() == null || this.getSolicitudTMODENCABEZADOpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TMODENCABEZADO, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TMODENCABEZADO_SOLICITUDTMODENCABEZADOPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_TMODENCABEZADO, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TMODENCABEZADO_SOLICITUDTMODENCABEZADOPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public Date getSolicitudTMODENCABEZADOptptFecha() {
        return this.solicitudTMODENCABEZADOptptFecha;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setSolicitudTMODENCABEZADOptptFecha(Date solicitudTMODENCABEZADOptptFecha) {
        this.solicitudTMODENCABEZADOptptFecha = solicitudTMODENCABEZADOptptFecha;
    }

    @JsonIgnore
    public GrupoAsociadoOid getSolicitudTMODENCABEZADOptGrupoAsociado() {
        return this.solicitudTMODENCABEZADOptGrupoAsociado;
    }
    
    public void setSolicitudTMODENCABEZADOptGrupoAsociado(GrupoAsociadoOid solicitudTMODENCABEZADOptGrupoAsociado) {
        this.solicitudTMODENCABEZADOptGrupoAsociado = solicitudTMODENCABEZADOptGrupoAsociado;
    }

    @JsonIgnore
    public GrupoAsociado getSolicitudTMODENCABEZADOptGrupoAsociadoInstance() {
        return this.solicitudTMODENCABEZADOptGrupoAsociadoInstance;
    }
    
    public void setSolicitudTMODENCABEZADOptGrupoAsociadoInstance(GrupoAsociado solicitudTMODENCABEZADOptGrupoAsociado) {
        this.solicitudTMODENCABEZADOptGrupoAsociadoInstance = solicitudTMODENCABEZADOptGrupoAsociado;
        this.solicitudTMODENCABEZADOptGrupoAsociado = solicitudTMODENCABEZADOptGrupoAsociado != null ? solicitudTMODENCABEZADOptGrupoAsociado.getOid() : null;
    }

    @JsonIgnore
    public String getSolicitudTMODENCABEZADOptProrrateo() {
        return this.solicitudTMODENCABEZADOptProrrateo;
    }
    
    public void setSolicitudTMODENCABEZADOptProrrateo(String solicitudTMODENCABEZADOptProrrateo) {
        this.solicitudTMODENCABEZADOptProrrateo = solicitudTMODENCABEZADOptProrrateo;
    }

    @JsonIgnore
    public Prorrateo getSolicitudTMODENCABEZADOptProrrateoInstance() {
        return this.solicitudTMODENCABEZADOptProrrateoInstance;
    }
    
    public void setSolicitudTMODENCABEZADOptProrrateoInstance(Prorrateo solicitudTMODENCABEZADOptProrrateo) {
        this.solicitudTMODENCABEZADOptProrrateoInstance = solicitudTMODENCABEZADOptProrrateo;
        this.solicitudTMODENCABEZADOptProrrateo = solicitudTMODENCABEZADOptProrrateo != null ? solicitudTMODENCABEZADOptProrrateo.getOid().toJson() : "";
    }

    @JsonIgnore
    public String getSolicitudTMODENCABEZADOptTipoFactura() {
        return this.solicitudTMODENCABEZADOptTipoFactura;
    }
    
    public void setSolicitudTMODENCABEZADOptTipoFactura(String solicitudTMODENCABEZADOptTipoFactura) {
        this.solicitudTMODENCABEZADOptTipoFactura = solicitudTMODENCABEZADOptTipoFactura;
    }

    @JsonIgnore
    public TipoFactura getSolicitudTMODENCABEZADOptTipoFacturaInstance() {
        return this.solicitudTMODENCABEZADOptTipoFacturaInstance;
    }
    
    public void setSolicitudTMODENCABEZADOptTipoFacturaInstance(TipoFactura solicitudTMODENCABEZADOptTipoFactura) {
        this.solicitudTMODENCABEZADOptTipoFacturaInstance = solicitudTMODENCABEZADOptTipoFactura;
        this.solicitudTMODENCABEZADOptTipoFactura = solicitudTMODENCABEZADOptTipoFactura != null ? solicitudTMODENCABEZADOptTipoFactura.getOid().toJson() : "";
    }

    private void checkSolicitudTMODENCABEZADOptTipoFactura() throws NotNullArgumentException {
        if(this.getSolicitudTMODENCABEZADOptTipoFacturaInstance() == null || this.getSolicitudTMODENCABEZADOptTipoFacturaInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TMODENCABEZADO, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TMODENCABEZADO_SOLICITUDTMODENCABEZADOPTTIPOFACTURA, SolicitudConstants.SERV_ALIAS_TMODENCABEZADO, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TMODENCABEZADO_SOLICITUDTMODENCABEZADOPTTIPOFACTURA);
        }
    }

    @JsonIgnore
    public Boolean getSolicitudTMODENCABEZADOptSoloDiaUno() {
        return this.solicitudTMODENCABEZADOptSoloDiaUno;
    }
    
    public void setSolicitudTMODENCABEZADOptSoloDiaUno(Boolean solicitudTMODENCABEZADOptSoloDiaUno) {
        this.solicitudTMODENCABEZADOptSoloDiaUno = solicitudTMODENCABEZADOptSoloDiaUno;
    }

    private void checkSolicitudTMODENCABEZADOptSoloDiaUno() throws NotNullArgumentException {
        if(this.getSolicitudTMODENCABEZADOptSoloDiaUno() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TMODENCABEZADO, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TMODENCABEZADO_SOLICITUDTMODENCABEZADOPTSOLODIAUNO, SolicitudConstants.SERV_ALIAS_TMODENCABEZADO, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TMODENCABEZADO_SOLICITUDTMODENCABEZADOPTSOLODIAUNO);
        }
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
