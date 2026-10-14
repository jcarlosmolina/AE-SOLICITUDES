package com.keralty.aesolicitudes.viewmodel.grupoasociado.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.GrupoAsociadoConstants;
import com.keralty.aesolicitudes.persistence.GrupoAsociado;
import com.keralty.aesolicitudes.persistence.oid.GrupoAsociadoOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class InsGrupoAsociadoSolicitudRequest {

    @JsonProperty("p_thisgrupoasociado_oid")
    private GrupoAsociadoOid grupoAsociadoInsGrupoAsociadoSolicitudpthisGrupoAsociado;
    
    @JsonIgnore
    private GrupoAsociado grupoAsociadoInsGrupoAsociadoSolicitudpthisGrupoAsociadoInstance;

    @JsonProperty("p_evcsolicitud_oid")
    private SolicitudOid grupoAsociadoInsGrupoAsociadoSolicitudpevcSolicitud;
    
    @JsonIgnore
    private Solicitud grupoAsociadoInsGrupoAsociadoSolicitudpevcSolicitudInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkGrupoAsociadoInsGrupoAsociadoSolicitudpthisGrupoAsociado();
        checkGrupoAsociadoInsGrupoAsociadoSolicitudpevcSolicitud();
    }

    @JsonIgnore
    public GrupoAsociadoOid getGrupoAsociadoInsGrupoAsociadoSolicitudpthisGrupoAsociado() {
        return this.grupoAsociadoInsGrupoAsociadoSolicitudpthisGrupoAsociado;
    }
    
    public void setGrupoAsociadoInsGrupoAsociadoSolicitudpthisGrupoAsociado(GrupoAsociadoOid grupoAsociadoInsGrupoAsociadoSolicitudpthisGrupoAsociado) {
        this.grupoAsociadoInsGrupoAsociadoSolicitudpthisGrupoAsociado = grupoAsociadoInsGrupoAsociadoSolicitudpthisGrupoAsociado;
    }

    @JsonIgnore
    public GrupoAsociado getGrupoAsociadoInsGrupoAsociadoSolicitudpthisGrupoAsociadoInstance() {
        return this.grupoAsociadoInsGrupoAsociadoSolicitudpthisGrupoAsociadoInstance;
    }
    
    public void setGrupoAsociadoInsGrupoAsociadoSolicitudpthisGrupoAsociadoInstance(GrupoAsociado grupoAsociadoInsGrupoAsociadoSolicitudpthisGrupoAsociado) {
        this.grupoAsociadoInsGrupoAsociadoSolicitudpthisGrupoAsociadoInstance = grupoAsociadoInsGrupoAsociadoSolicitudpthisGrupoAsociado;
        this.grupoAsociadoInsGrupoAsociadoSolicitudpthisGrupoAsociado = grupoAsociadoInsGrupoAsociadoSolicitudpthisGrupoAsociado != null ? grupoAsociadoInsGrupoAsociadoSolicitudpthisGrupoAsociado.getOid() : null;
    }

    private void checkGrupoAsociadoInsGrupoAsociadoSolicitudpthisGrupoAsociado() throws NotNullArgumentException {
        if(this.getGrupoAsociadoInsGrupoAsociadoSolicitudpthisGrupoAsociadoInstance() == null || this.getGrupoAsociadoInsGrupoAsociadoSolicitudpthisGrupoAsociadoInstance().isNull()) {
            throw new NotNullArgumentException(GrupoAsociadoConstants.SERV_ID_INSGRUPOASOCIADOSOLICITUD, GrupoAsociadoConstants.CLASS_ID, GrupoAsociadoConstants.ARG_ID_INSGRUPOASOCIADOSOLICITUD_GRUPOASOCIADOINSGRUPOASOCIADOSOLICITUDPTHISGRUPOASOCIADO, GrupoAsociadoConstants.SERV_ALIAS_INSGRUPOASOCIADOSOLICITUD, GrupoAsociadoConstants.CLASS_ALIAS, GrupoAsociadoConstants.ARG_ALIAS_INSGRUPOASOCIADOSOLICITUD_GRUPOASOCIADOINSGRUPOASOCIADOSOLICITUDPTHISGRUPOASOCIADO);
        }
    }

    @JsonIgnore
    public SolicitudOid getGrupoAsociadoInsGrupoAsociadoSolicitudpevcSolicitud() {
        return this.grupoAsociadoInsGrupoAsociadoSolicitudpevcSolicitud;
    }
    
    public void setGrupoAsociadoInsGrupoAsociadoSolicitudpevcSolicitud(SolicitudOid grupoAsociadoInsGrupoAsociadoSolicitudpevcSolicitud) {
        this.grupoAsociadoInsGrupoAsociadoSolicitudpevcSolicitud = grupoAsociadoInsGrupoAsociadoSolicitudpevcSolicitud;
    }

    @JsonIgnore
    public Solicitud getGrupoAsociadoInsGrupoAsociadoSolicitudpevcSolicitudInstance() {
        return this.grupoAsociadoInsGrupoAsociadoSolicitudpevcSolicitudInstance;
    }
    
    public void setGrupoAsociadoInsGrupoAsociadoSolicitudpevcSolicitudInstance(Solicitud grupoAsociadoInsGrupoAsociadoSolicitudpevcSolicitud) {
        this.grupoAsociadoInsGrupoAsociadoSolicitudpevcSolicitudInstance = grupoAsociadoInsGrupoAsociadoSolicitudpevcSolicitud;
        this.grupoAsociadoInsGrupoAsociadoSolicitudpevcSolicitud = grupoAsociadoInsGrupoAsociadoSolicitudpevcSolicitud != null ? grupoAsociadoInsGrupoAsociadoSolicitudpevcSolicitud.getOid() : null;
    }

    private void checkGrupoAsociadoInsGrupoAsociadoSolicitudpevcSolicitud() throws NotNullArgumentException {
        if(this.getGrupoAsociadoInsGrupoAsociadoSolicitudpevcSolicitudInstance() == null || this.getGrupoAsociadoInsGrupoAsociadoSolicitudpevcSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(GrupoAsociadoConstants.SERV_ID_INSGRUPOASOCIADOSOLICITUD, GrupoAsociadoConstants.CLASS_ID, GrupoAsociadoConstants.ARG_ID_INSGRUPOASOCIADOSOLICITUD_GRUPOASOCIADOINSGRUPOASOCIADOSOLICITUDPEVCSOLICITUD, GrupoAsociadoConstants.SERV_ALIAS_INSGRUPOASOCIADOSOLICITUD, GrupoAsociadoConstants.CLASS_ALIAS, GrupoAsociadoConstants.ARG_ALIAS_INSGRUPOASOCIADOSOLICITUD_GRUPOASOCIADOINSGRUPOASOCIADOSOLICITUDPEVCSOLICITUD);
        }
    }
}
