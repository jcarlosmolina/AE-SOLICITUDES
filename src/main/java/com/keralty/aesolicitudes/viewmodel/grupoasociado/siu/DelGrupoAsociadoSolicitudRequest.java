package com.keralty.aesolicitudes.viewmodel.grupoasociado.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.GrupoAsociadoConstants;
import com.keralty.aesolicitudes.persistence.GrupoAsociado;
import com.keralty.aesolicitudes.persistence.oid.GrupoAsociadoOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class DelGrupoAsociadoSolicitudRequest {

    @JsonProperty("p_thisgrupoasociado_oid")
    private GrupoAsociadoOid grupoAsociadoDelGrupoAsociadoSolicitudpthisGrupoAsociado;
    
    @JsonIgnore
    private GrupoAsociado grupoAsociadoDelGrupoAsociadoSolicitudpthisGrupoAsociadoInstance;

    @JsonProperty("p_evcsolicitud_oid")
    private SolicitudOid grupoAsociadoDelGrupoAsociadoSolicitudpevcSolicitud;
    
    @JsonIgnore
    private Solicitud grupoAsociadoDelGrupoAsociadoSolicitudpevcSolicitudInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkGrupoAsociadoDelGrupoAsociadoSolicitudpthisGrupoAsociado();
        checkGrupoAsociadoDelGrupoAsociadoSolicitudpevcSolicitud();
    }

    @JsonIgnore
    public GrupoAsociadoOid getGrupoAsociadoDelGrupoAsociadoSolicitudpthisGrupoAsociado() {
        return this.grupoAsociadoDelGrupoAsociadoSolicitudpthisGrupoAsociado;
    }
    
    public void setGrupoAsociadoDelGrupoAsociadoSolicitudpthisGrupoAsociado(GrupoAsociadoOid grupoAsociadoDelGrupoAsociadoSolicitudpthisGrupoAsociado) {
        this.grupoAsociadoDelGrupoAsociadoSolicitudpthisGrupoAsociado = grupoAsociadoDelGrupoAsociadoSolicitudpthisGrupoAsociado;
    }

    @JsonIgnore
    public GrupoAsociado getGrupoAsociadoDelGrupoAsociadoSolicitudpthisGrupoAsociadoInstance() {
        return this.grupoAsociadoDelGrupoAsociadoSolicitudpthisGrupoAsociadoInstance;
    }
    
    public void setGrupoAsociadoDelGrupoAsociadoSolicitudpthisGrupoAsociadoInstance(GrupoAsociado grupoAsociadoDelGrupoAsociadoSolicitudpthisGrupoAsociado) {
        this.grupoAsociadoDelGrupoAsociadoSolicitudpthisGrupoAsociadoInstance = grupoAsociadoDelGrupoAsociadoSolicitudpthisGrupoAsociado;
        this.grupoAsociadoDelGrupoAsociadoSolicitudpthisGrupoAsociado = grupoAsociadoDelGrupoAsociadoSolicitudpthisGrupoAsociado != null ? grupoAsociadoDelGrupoAsociadoSolicitudpthisGrupoAsociado.getOid() : null;
    }

    private void checkGrupoAsociadoDelGrupoAsociadoSolicitudpthisGrupoAsociado() throws NotNullArgumentException {
        if(this.getGrupoAsociadoDelGrupoAsociadoSolicitudpthisGrupoAsociadoInstance() == null || this.getGrupoAsociadoDelGrupoAsociadoSolicitudpthisGrupoAsociadoInstance().isNull()) {
            throw new NotNullArgumentException(GrupoAsociadoConstants.SERV_ID_DELGRUPOASOCIADOSOLICITUD, GrupoAsociadoConstants.CLASS_ID, GrupoAsociadoConstants.ARG_ID_DELGRUPOASOCIADOSOLICITUD_GRUPOASOCIADODELGRUPOASOCIADOSOLICITUDPTHISGRUPOASOCIADO, GrupoAsociadoConstants.SERV_ALIAS_DELGRUPOASOCIADOSOLICITUD, GrupoAsociadoConstants.CLASS_ALIAS, GrupoAsociadoConstants.ARG_ALIAS_DELGRUPOASOCIADOSOLICITUD_GRUPOASOCIADODELGRUPOASOCIADOSOLICITUDPTHISGRUPOASOCIADO);
        }
    }

    @JsonIgnore
    public SolicitudOid getGrupoAsociadoDelGrupoAsociadoSolicitudpevcSolicitud() {
        return this.grupoAsociadoDelGrupoAsociadoSolicitudpevcSolicitud;
    }
    
    public void setGrupoAsociadoDelGrupoAsociadoSolicitudpevcSolicitud(SolicitudOid grupoAsociadoDelGrupoAsociadoSolicitudpevcSolicitud) {
        this.grupoAsociadoDelGrupoAsociadoSolicitudpevcSolicitud = grupoAsociadoDelGrupoAsociadoSolicitudpevcSolicitud;
    }

    @JsonIgnore
    public Solicitud getGrupoAsociadoDelGrupoAsociadoSolicitudpevcSolicitudInstance() {
        return this.grupoAsociadoDelGrupoAsociadoSolicitudpevcSolicitudInstance;
    }
    
    public void setGrupoAsociadoDelGrupoAsociadoSolicitudpevcSolicitudInstance(Solicitud grupoAsociadoDelGrupoAsociadoSolicitudpevcSolicitud) {
        this.grupoAsociadoDelGrupoAsociadoSolicitudpevcSolicitudInstance = grupoAsociadoDelGrupoAsociadoSolicitudpevcSolicitud;
        this.grupoAsociadoDelGrupoAsociadoSolicitudpevcSolicitud = grupoAsociadoDelGrupoAsociadoSolicitudpevcSolicitud != null ? grupoAsociadoDelGrupoAsociadoSolicitudpevcSolicitud.getOid() : null;
    }

    private void checkGrupoAsociadoDelGrupoAsociadoSolicitudpevcSolicitud() throws NotNullArgumentException {
        if(this.getGrupoAsociadoDelGrupoAsociadoSolicitudpevcSolicitudInstance() == null || this.getGrupoAsociadoDelGrupoAsociadoSolicitudpevcSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(GrupoAsociadoConstants.SERV_ID_DELGRUPOASOCIADOSOLICITUD, GrupoAsociadoConstants.CLASS_ID, GrupoAsociadoConstants.ARG_ID_DELGRUPOASOCIADOSOLICITUD_GRUPOASOCIADODELGRUPOASOCIADOSOLICITUDPEVCSOLICITUD, GrupoAsociadoConstants.SERV_ALIAS_DELGRUPOASOCIADOSOLICITUD, GrupoAsociadoConstants.CLASS_ALIAS, GrupoAsociadoConstants.ARG_ALIAS_DELGRUPOASOCIADOSOLICITUD_GRUPOASOCIADODELGRUPOASOCIADOSOLICITUDPEVCSOLICITUD);
        }
    }
}
