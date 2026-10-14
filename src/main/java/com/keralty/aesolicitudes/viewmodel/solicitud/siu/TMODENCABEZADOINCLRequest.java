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
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class TMODENCABEZADOINCLRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudTMODENCABEZADOINCLpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudTMODENCABEZADOINCLpthisSolicitudInstance;

    @JsonProperty("pt_ptfecha")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date solicitudTMODENCABEZADOINCLptptFecha;

    @JsonProperty("ptgrupoasociado_oid")
    private GrupoAsociadoOid solicitudTMODENCABEZADOINCLptGrupoAsociado;
    
    @JsonIgnore
    private GrupoAsociado solicitudTMODENCABEZADOINCLptGrupoAsociadoInstance;

    @JsonProperty("ptsolodiauno")
    private Boolean solicitudTMODENCABEZADOINCLptSoloDiaUno;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudTMODENCABEZADOINCLpthisSolicitud();
        checkSolicitudTMODENCABEZADOINCLptSoloDiaUno();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudTMODENCABEZADOINCLpthisSolicitud() {
        return this.solicitudTMODENCABEZADOINCLpthisSolicitud;
    }
    
    public void setSolicitudTMODENCABEZADOINCLpthisSolicitud(SolicitudOid solicitudTMODENCABEZADOINCLpthisSolicitud) {
        this.solicitudTMODENCABEZADOINCLpthisSolicitud = solicitudTMODENCABEZADOINCLpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudTMODENCABEZADOINCLpthisSolicitudInstance() {
        return this.solicitudTMODENCABEZADOINCLpthisSolicitudInstance;
    }
    
    public void setSolicitudTMODENCABEZADOINCLpthisSolicitudInstance(Solicitud solicitudTMODENCABEZADOINCLpthisSolicitud) {
        this.solicitudTMODENCABEZADOINCLpthisSolicitudInstance = solicitudTMODENCABEZADOINCLpthisSolicitud;
        this.solicitudTMODENCABEZADOINCLpthisSolicitud = solicitudTMODENCABEZADOINCLpthisSolicitud != null ? solicitudTMODENCABEZADOINCLpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudTMODENCABEZADOINCLpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudTMODENCABEZADOINCLpthisSolicitudInstance() == null || this.getSolicitudTMODENCABEZADOINCLpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TMODENCABEZADOINCL, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TMODENCABEZADOINCL_SOLICITUDTMODENCABEZADOINCLPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_TMODENCABEZADOINCL, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TMODENCABEZADOINCL_SOLICITUDTMODENCABEZADOINCLPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public Date getSolicitudTMODENCABEZADOINCLptptFecha() {
        return this.solicitudTMODENCABEZADOINCLptptFecha;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setSolicitudTMODENCABEZADOINCLptptFecha(Date solicitudTMODENCABEZADOINCLptptFecha) {
        this.solicitudTMODENCABEZADOINCLptptFecha = solicitudTMODENCABEZADOINCLptptFecha;
    }

    @JsonIgnore
    public GrupoAsociadoOid getSolicitudTMODENCABEZADOINCLptGrupoAsociado() {
        return this.solicitudTMODENCABEZADOINCLptGrupoAsociado;
    }
    
    public void setSolicitudTMODENCABEZADOINCLptGrupoAsociado(GrupoAsociadoOid solicitudTMODENCABEZADOINCLptGrupoAsociado) {
        this.solicitudTMODENCABEZADOINCLptGrupoAsociado = solicitudTMODENCABEZADOINCLptGrupoAsociado;
    }

    @JsonIgnore
    public GrupoAsociado getSolicitudTMODENCABEZADOINCLptGrupoAsociadoInstance() {
        return this.solicitudTMODENCABEZADOINCLptGrupoAsociadoInstance;
    }
    
    public void setSolicitudTMODENCABEZADOINCLptGrupoAsociadoInstance(GrupoAsociado solicitudTMODENCABEZADOINCLptGrupoAsociado) {
        this.solicitudTMODENCABEZADOINCLptGrupoAsociadoInstance = solicitudTMODENCABEZADOINCLptGrupoAsociado;
        this.solicitudTMODENCABEZADOINCLptGrupoAsociado = solicitudTMODENCABEZADOINCLptGrupoAsociado != null ? solicitudTMODENCABEZADOINCLptGrupoAsociado.getOid() : null;
    }

    @JsonIgnore
    public Boolean getSolicitudTMODENCABEZADOINCLptSoloDiaUno() {
        return this.solicitudTMODENCABEZADOINCLptSoloDiaUno;
    }
    
    public void setSolicitudTMODENCABEZADOINCLptSoloDiaUno(Boolean solicitudTMODENCABEZADOINCLptSoloDiaUno) {
        this.solicitudTMODENCABEZADOINCLptSoloDiaUno = solicitudTMODENCABEZADOINCLptSoloDiaUno;
    }

    private void checkSolicitudTMODENCABEZADOINCLptSoloDiaUno() throws NotNullArgumentException {
        if(this.getSolicitudTMODENCABEZADOINCLptSoloDiaUno() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TMODENCABEZADOINCL, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TMODENCABEZADOINCL_SOLICITUDTMODENCABEZADOINCLPTSOLODIAUNO, SolicitudConstants.SERV_ALIAS_TMODENCABEZADOINCL, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TMODENCABEZADOINCL_SOLICITUDTMODENCABEZADOINCLPTSOLODIAUNO);
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
