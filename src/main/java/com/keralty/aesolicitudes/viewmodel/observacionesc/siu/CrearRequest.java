package com.keralty.aesolicitudes.viewmodel.observacionesc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ObservacionesCConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;

public class CrearRequest {

    @JsonProperty("p_agrcontratoc_oid")
    private ContratoCOid observacionesCcrearpagrContratoC;
    
    @JsonIgnore
    private ContratoC observacionesCcrearpagrContratoCInstance;

    @JsonProperty("p_atrcodtipoobservacion")
    private String observacionesCcrearpatrCodTipoObservacion;

    @JsonProperty("p_atrtipoobservacion")
    private String observacionesCcrearpatrTipoObservacion;

    @JsonProperty("p_atrobservacions")
    private String observacionesCcrearpatrObservacions;

    public void checkArguments() throws NotNullArgumentException {
        checkObservacionesCcrearpagrContratoC();
        checkObservacionesCcrearpatrCodTipoObservacion();
        checkObservacionesCcrearpatrTipoObservacion();
        checkObservacionesCcrearpatrObservacions();
    }

    @JsonIgnore
    public ContratoCOid getObservacionesCcrearpagrContratoC() {
        return this.observacionesCcrearpagrContratoC;
    }
    
    public void setObservacionesCcrearpagrContratoC(ContratoCOid observacionesCcrearpagrContratoC) {
        this.observacionesCcrearpagrContratoC = observacionesCcrearpagrContratoC;
    }

    @JsonIgnore
    public ContratoC getObservacionesCcrearpagrContratoCInstance() {
        return this.observacionesCcrearpagrContratoCInstance;
    }
    
    public void setObservacionesCcrearpagrContratoCInstance(ContratoC observacionesCcrearpagrContratoC) {
        this.observacionesCcrearpagrContratoCInstance = observacionesCcrearpagrContratoC;
        this.observacionesCcrearpagrContratoC = observacionesCcrearpagrContratoC != null ? observacionesCcrearpagrContratoC.getOid() : null;
    }

    private void checkObservacionesCcrearpagrContratoC() throws NotNullArgumentException {
        if(this.getObservacionesCcrearpagrContratoCInstance() == null || this.getObservacionesCcrearpagrContratoCInstance().isNull()) {
            throw new NotNullArgumentException(ObservacionesCConstants.SERV_ID_CREAR, ObservacionesCConstants.CLASS_ID, ObservacionesCConstants.ARG_ID_CREAR_OBSERVACIONESCCREARPAGRCONTRATOC, ObservacionesCConstants.SERV_ALIAS_CREAR, ObservacionesCConstants.CLASS_ALIAS, ObservacionesCConstants.ARG_ALIAS_CREAR_OBSERVACIONESCCREARPAGRCONTRATOC);
        }
    }

    @JsonIgnore
    public String getObservacionesCcrearpatrCodTipoObservacion() {
        return this.observacionesCcrearpatrCodTipoObservacion;
    }
    
    public void setObservacionesCcrearpatrCodTipoObservacion(String observacionesCcrearpatrCodTipoObservacion) {
        this.observacionesCcrearpatrCodTipoObservacion = observacionesCcrearpatrCodTipoObservacion;
    }

    private void checkObservacionesCcrearpatrCodTipoObservacion() throws NotNullArgumentException {
        if(this.getObservacionesCcrearpatrCodTipoObservacion() == null) {
            throw new NotNullArgumentException(ObservacionesCConstants.SERV_ID_CREAR, ObservacionesCConstants.CLASS_ID, ObservacionesCConstants.ARG_ID_CREAR_OBSERVACIONESCCREARPATRCODTIPOOBSERVACION, ObservacionesCConstants.SERV_ALIAS_CREAR, ObservacionesCConstants.CLASS_ALIAS, ObservacionesCConstants.ARG_ALIAS_CREAR_OBSERVACIONESCCREARPATRCODTIPOOBSERVACION);
        }
    }

    @JsonIgnore
    public String getObservacionesCcrearpatrTipoObservacion() {
        return this.observacionesCcrearpatrTipoObservacion;
    }
    
    public void setObservacionesCcrearpatrTipoObservacion(String observacionesCcrearpatrTipoObservacion) {
        this.observacionesCcrearpatrTipoObservacion = observacionesCcrearpatrTipoObservacion;
    }

    private void checkObservacionesCcrearpatrTipoObservacion() throws NotNullArgumentException {
        if(this.getObservacionesCcrearpatrTipoObservacion() == null) {
            throw new NotNullArgumentException(ObservacionesCConstants.SERV_ID_CREAR, ObservacionesCConstants.CLASS_ID, ObservacionesCConstants.ARG_ID_CREAR_OBSERVACIONESCCREARPATRTIPOOBSERVACION, ObservacionesCConstants.SERV_ALIAS_CREAR, ObservacionesCConstants.CLASS_ALIAS, ObservacionesCConstants.ARG_ALIAS_CREAR_OBSERVACIONESCCREARPATRTIPOOBSERVACION);
        }
    }

    @JsonIgnore
    public String getObservacionesCcrearpatrObservacions() {
        return this.observacionesCcrearpatrObservacions;
    }
    
    public void setObservacionesCcrearpatrObservacions(String observacionesCcrearpatrObservacions) {
        this.observacionesCcrearpatrObservacions = observacionesCcrearpatrObservacions;
    }

    private void checkObservacionesCcrearpatrObservacions() throws NotNullArgumentException {
        if(this.getObservacionesCcrearpatrObservacions() == null) {
            throw new NotNullArgumentException(ObservacionesCConstants.SERV_ID_CREAR, ObservacionesCConstants.CLASS_ID, ObservacionesCConstants.ARG_ID_CREAR_OBSERVACIONESCCREARPATROBSERVACIONS, ObservacionesCConstants.SERV_ALIAS_CREAR, ObservacionesCConstants.CLASS_ALIAS, ObservacionesCConstants.ARG_ALIAS_CREAR_OBSERVACIONESCCREARPATROBSERVACIONS);
        }
    }
}
