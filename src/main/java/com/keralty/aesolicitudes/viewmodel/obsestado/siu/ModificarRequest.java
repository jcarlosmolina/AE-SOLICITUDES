package com.keralty.aesolicitudes.viewmodel.obsestado.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ObsEstadoConstants;
import com.keralty.aesolicitudes.persistence.ObsEstado;
import com.keralty.aesolicitudes.persistence.oid.ObsEstadoOid;

public class ModificarRequest {

    @JsonProperty("p_thisobsestado_oid")
    private ObsEstadoOid obsEstadomodificarpthisObsEstado;
    
    @JsonIgnore
    private ObsEstado obsEstadomodificarpthisObsEstadoInstance;

    @JsonProperty("p_observacions")
    private String obsEstadomodificarpObservacions;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkObsEstadomodificarpthisObsEstado();
    }

    @JsonIgnore
    public ObsEstadoOid getObsEstadomodificarpthisObsEstado() {
        return this.obsEstadomodificarpthisObsEstado;
    }
    
    public void setObsEstadomodificarpthisObsEstado(ObsEstadoOid obsEstadomodificarpthisObsEstado) {
        this.obsEstadomodificarpthisObsEstado = obsEstadomodificarpthisObsEstado;
    }

    @JsonIgnore
    public ObsEstado getObsEstadomodificarpthisObsEstadoInstance() {
        return this.obsEstadomodificarpthisObsEstadoInstance;
    }
    
    public void setObsEstadomodificarpthisObsEstadoInstance(ObsEstado obsEstadomodificarpthisObsEstado) {
        this.obsEstadomodificarpthisObsEstadoInstance = obsEstadomodificarpthisObsEstado;
        this.obsEstadomodificarpthisObsEstado = obsEstadomodificarpthisObsEstado != null ? obsEstadomodificarpthisObsEstado.getOid() : null;
    }

    private void checkObsEstadomodificarpthisObsEstado() throws NotNullArgumentException {
        if(this.getObsEstadomodificarpthisObsEstadoInstance() == null || this.getObsEstadomodificarpthisObsEstadoInstance().isNull()) {
            throw new NotNullArgumentException(ObsEstadoConstants.SERV_ID_MODIFICAR, ObsEstadoConstants.CLASS_ID, ObsEstadoConstants.ARG_ID_MODIFICAR_OBSESTADOMODIFICARPTHISOBSESTADO, ObsEstadoConstants.SERV_ALIAS_MODIFICAR, ObsEstadoConstants.CLASS_ALIAS, ObsEstadoConstants.ARG_ALIAS_MODIFICAR_OBSESTADOMODIFICARPTHISOBSESTADO);
        }
    }

    @JsonIgnore
    public String getObsEstadomodificarpObservacions() {
        return this.obsEstadomodificarpObservacions;
    }
    
    public void setObsEstadomodificarpObservacions(String obsEstadomodificarpObservacions) {
        this.obsEstadomodificarpObservacions = obsEstadomodificarpObservacions;
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
