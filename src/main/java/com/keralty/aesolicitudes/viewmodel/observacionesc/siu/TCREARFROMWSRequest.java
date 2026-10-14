package com.keralty.aesolicitudes.viewmodel.observacionesc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ObservacionesCConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.ObservacionesC;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.ObservacionesCOid;

public class TCREARFROMWSRequest {

    @JsonProperty("pobservacionesc_oid")
    private ObservacionesCOid observacionesCTCREARFROMWSpObservacionesC;
    
    @JsonIgnore
    private ObservacionesC observacionesCTCREARFROMWSpObservacionesCInstance;

    @JsonProperty("pcontratoc_oid")
    private ContratoCOid observacionesCTCREARFROMWSpContratoC;
    
    @JsonIgnore
    private ContratoC observacionesCTCREARFROMWSpContratoCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkObservacionesCTCREARFROMWSpObservacionesC();
        checkObservacionesCTCREARFROMWSpContratoC();
    }

    @JsonIgnore
    public ObservacionesCOid getObservacionesCTCREARFROMWSpObservacionesC() {
        return this.observacionesCTCREARFROMWSpObservacionesC;
    }
    
    public void setObservacionesCTCREARFROMWSpObservacionesC(ObservacionesCOid observacionesCTCREARFROMWSpObservacionesC) {
        this.observacionesCTCREARFROMWSpObservacionesC = observacionesCTCREARFROMWSpObservacionesC;
    }

    @JsonIgnore
    public ObservacionesC getObservacionesCTCREARFROMWSpObservacionesCInstance() {
        return this.observacionesCTCREARFROMWSpObservacionesCInstance;
    }
    
    public void setObservacionesCTCREARFROMWSpObservacionesCInstance(ObservacionesC observacionesCTCREARFROMWSpObservacionesC) {
        this.observacionesCTCREARFROMWSpObservacionesCInstance = observacionesCTCREARFROMWSpObservacionesC;
        this.observacionesCTCREARFROMWSpObservacionesC = observacionesCTCREARFROMWSpObservacionesC != null ? observacionesCTCREARFROMWSpObservacionesC.getOid() : null;
    }

    private void checkObservacionesCTCREARFROMWSpObservacionesC() throws NotNullArgumentException {
        if(this.getObservacionesCTCREARFROMWSpObservacionesCInstance() == null || this.getObservacionesCTCREARFROMWSpObservacionesCInstance().isNull()) {
            throw new NotNullArgumentException(ObservacionesCConstants.SERV_ID_TCREARFROMWS, ObservacionesCConstants.CLASS_ID, ObservacionesCConstants.ARG_ID_TCREARFROMWS_OBSERVACIONESCTCREARFROMWSPOBSERVACIONESC, ObservacionesCConstants.SERV_ALIAS_TCREARFROMWS, ObservacionesCConstants.CLASS_ALIAS, ObservacionesCConstants.ARG_ALIAS_TCREARFROMWS_OBSERVACIONESCTCREARFROMWSPOBSERVACIONESC);
        }
    }

    @JsonIgnore
    public ContratoCOid getObservacionesCTCREARFROMWSpContratoC() {
        return this.observacionesCTCREARFROMWSpContratoC;
    }
    
    public void setObservacionesCTCREARFROMWSpContratoC(ContratoCOid observacionesCTCREARFROMWSpContratoC) {
        this.observacionesCTCREARFROMWSpContratoC = observacionesCTCREARFROMWSpContratoC;
    }

    @JsonIgnore
    public ContratoC getObservacionesCTCREARFROMWSpContratoCInstance() {
        return this.observacionesCTCREARFROMWSpContratoCInstance;
    }
    
    public void setObservacionesCTCREARFROMWSpContratoCInstance(ContratoC observacionesCTCREARFROMWSpContratoC) {
        this.observacionesCTCREARFROMWSpContratoCInstance = observacionesCTCREARFROMWSpContratoC;
        this.observacionesCTCREARFROMWSpContratoC = observacionesCTCREARFROMWSpContratoC != null ? observacionesCTCREARFROMWSpContratoC.getOid() : null;
    }

    private void checkObservacionesCTCREARFROMWSpContratoC() throws NotNullArgumentException {
        if(this.getObservacionesCTCREARFROMWSpContratoCInstance() == null || this.getObservacionesCTCREARFROMWSpContratoCInstance().isNull()) {
            throw new NotNullArgumentException(ObservacionesCConstants.SERV_ID_TCREARFROMWS, ObservacionesCConstants.CLASS_ID, ObservacionesCConstants.ARG_ID_TCREARFROMWS_OBSERVACIONESCTCREARFROMWSPCONTRATOC, ObservacionesCConstants.SERV_ALIAS_TCREARFROMWS, ObservacionesCConstants.CLASS_ALIAS, ObservacionesCConstants.ARG_ALIAS_TCREARFROMWS_OBSERVACIONESCTCREARFROMWSPCONTRATOC);
        }
    }
}
