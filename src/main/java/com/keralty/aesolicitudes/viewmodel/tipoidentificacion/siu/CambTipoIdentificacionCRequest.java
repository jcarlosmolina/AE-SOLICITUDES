package com.keralty.aesolicitudes.viewmodel.tipoidentificacion.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.TipoIdentificacionConstants;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.oid.TipoIdentificacionOid;
import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.TipoIdentificacion;

public class CambTipoIdentificacionCRequest {

    @JsonProperty("p_thistipoidentificacion_oid")
    private TipoIdentificacionOid tipoIdentificacionCambTipoIdentificacionCpthisTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion tipoIdentificacionCambTipoIdentificacionCpthisTipoIdentificacionInstance;

    @JsonProperty("p_evcpersonac_oid")
    private PersonaCOid tipoIdentificacionCambTipoIdentificacionCpevcPersonaC;
    
    @JsonIgnore
    private PersonaC tipoIdentificacionCambTipoIdentificacionCpevcPersonaCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkTipoIdentificacionCambTipoIdentificacionCpthisTipoIdentificacion();
        checkTipoIdentificacionCambTipoIdentificacionCpevcPersonaC();
    }

    @JsonIgnore
    public TipoIdentificacionOid getTipoIdentificacionCambTipoIdentificacionCpthisTipoIdentificacion() {
        return this.tipoIdentificacionCambTipoIdentificacionCpthisTipoIdentificacion;
    }
    
    public void setTipoIdentificacionCambTipoIdentificacionCpthisTipoIdentificacion(TipoIdentificacionOid tipoIdentificacionCambTipoIdentificacionCpthisTipoIdentificacion) {
        this.tipoIdentificacionCambTipoIdentificacionCpthisTipoIdentificacion = tipoIdentificacionCambTipoIdentificacionCpthisTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getTipoIdentificacionCambTipoIdentificacionCpthisTipoIdentificacionInstance() {
        return this.tipoIdentificacionCambTipoIdentificacionCpthisTipoIdentificacionInstance;
    }
    
    public void setTipoIdentificacionCambTipoIdentificacionCpthisTipoIdentificacionInstance(TipoIdentificacion tipoIdentificacionCambTipoIdentificacionCpthisTipoIdentificacion) {
        this.tipoIdentificacionCambTipoIdentificacionCpthisTipoIdentificacionInstance = tipoIdentificacionCambTipoIdentificacionCpthisTipoIdentificacion;
        this.tipoIdentificacionCambTipoIdentificacionCpthisTipoIdentificacion = tipoIdentificacionCambTipoIdentificacionCpthisTipoIdentificacion != null ? tipoIdentificacionCambTipoIdentificacionCpthisTipoIdentificacion.getOid() : null;
    }

    private void checkTipoIdentificacionCambTipoIdentificacionCpthisTipoIdentificacion() throws NotNullArgumentException {
        if(this.getTipoIdentificacionCambTipoIdentificacionCpthisTipoIdentificacionInstance() == null || this.getTipoIdentificacionCambTipoIdentificacionCpthisTipoIdentificacionInstance().isNull()) {
            throw new NotNullArgumentException(TipoIdentificacionConstants.SERV_ID_CAMBTIPOIDENTIFICACIONC, TipoIdentificacionConstants.CLASS_ID, TipoIdentificacionConstants.ARG_ID_CAMBTIPOIDENTIFICACIONC_TIPOIDENTIFICACIONCAMBTIPOIDENTIFICACIONCPTHISTIPOIDENTIFICACION, TipoIdentificacionConstants.SERV_ALIAS_CAMBTIPOIDENTIFICACIONC, TipoIdentificacionConstants.CLASS_ALIAS, TipoIdentificacionConstants.ARG_ALIAS_CAMBTIPOIDENTIFICACIONC_TIPOIDENTIFICACIONCAMBTIPOIDENTIFICACIONCPTHISTIPOIDENTIFICACION);
        }
    }

    @JsonIgnore
    public PersonaCOid getTipoIdentificacionCambTipoIdentificacionCpevcPersonaC() {
        return this.tipoIdentificacionCambTipoIdentificacionCpevcPersonaC;
    }
    
    public void setTipoIdentificacionCambTipoIdentificacionCpevcPersonaC(PersonaCOid tipoIdentificacionCambTipoIdentificacionCpevcPersonaC) {
        this.tipoIdentificacionCambTipoIdentificacionCpevcPersonaC = tipoIdentificacionCambTipoIdentificacionCpevcPersonaC;
    }

    @JsonIgnore
    public PersonaC getTipoIdentificacionCambTipoIdentificacionCpevcPersonaCInstance() {
        return this.tipoIdentificacionCambTipoIdentificacionCpevcPersonaCInstance;
    }
    
    public void setTipoIdentificacionCambTipoIdentificacionCpevcPersonaCInstance(PersonaC tipoIdentificacionCambTipoIdentificacionCpevcPersonaC) {
        this.tipoIdentificacionCambTipoIdentificacionCpevcPersonaCInstance = tipoIdentificacionCambTipoIdentificacionCpevcPersonaC;
        this.tipoIdentificacionCambTipoIdentificacionCpevcPersonaC = tipoIdentificacionCambTipoIdentificacionCpevcPersonaC != null ? tipoIdentificacionCambTipoIdentificacionCpevcPersonaC.getOid() : null;
    }

    private void checkTipoIdentificacionCambTipoIdentificacionCpevcPersonaC() throws NotNullArgumentException {
        if(this.getTipoIdentificacionCambTipoIdentificacionCpevcPersonaCInstance() == null || this.getTipoIdentificacionCambTipoIdentificacionCpevcPersonaCInstance().isNull()) {
            throw new NotNullArgumentException(TipoIdentificacionConstants.SERV_ID_CAMBTIPOIDENTIFICACIONC, TipoIdentificacionConstants.CLASS_ID, TipoIdentificacionConstants.ARG_ID_CAMBTIPOIDENTIFICACIONC_TIPOIDENTIFICACIONCAMBTIPOIDENTIFICACIONCPEVCPERSONAC, TipoIdentificacionConstants.SERV_ALIAS_CAMBTIPOIDENTIFICACIONC, TipoIdentificacionConstants.CLASS_ALIAS, TipoIdentificacionConstants.ARG_ALIAS_CAMBTIPOIDENTIFICACIONC_TIPOIDENTIFICACIONCAMBTIPOIDENTIFICACIONCPEVCPERSONAC);
        }
    }
}
