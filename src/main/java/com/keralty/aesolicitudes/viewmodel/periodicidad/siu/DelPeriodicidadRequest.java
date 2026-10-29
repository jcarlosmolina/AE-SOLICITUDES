package com.keralty.aesolicitudes.viewmodel.periodicidad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.PeriodicidadConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.PeriodicidadOid;
import com.keralty.aesolicitudes.persistence.Periodicidad;

public class DelPeriodicidadRequest {

    @JsonProperty("p_thisperiodicidad_oid")
    private PeriodicidadOid periodicidadDelPeriodicidadpthisPeriodicidad;
    
    @JsonIgnore
    private Periodicidad periodicidadDelPeriodicidadpthisPeriodicidadInstance;

    @JsonProperty("p_evccontratoc_oid")
    private ContratoCOid periodicidadDelPeriodicidadpevcContratoC;
    
    @JsonIgnore
    private ContratoC periodicidadDelPeriodicidadpevcContratoCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkPeriodicidadDelPeriodicidadpthisPeriodicidad();
        checkPeriodicidadDelPeriodicidadpevcContratoC();
    }

    @JsonIgnore
    public PeriodicidadOid getPeriodicidadDelPeriodicidadpthisPeriodicidad() {
        return this.periodicidadDelPeriodicidadpthisPeriodicidad;
    }
    
    public void setPeriodicidadDelPeriodicidadpthisPeriodicidad(PeriodicidadOid periodicidadDelPeriodicidadpthisPeriodicidad) {
        this.periodicidadDelPeriodicidadpthisPeriodicidad = periodicidadDelPeriodicidadpthisPeriodicidad;
    }

    @JsonIgnore
    public Periodicidad getPeriodicidadDelPeriodicidadpthisPeriodicidadInstance() {
        return this.periodicidadDelPeriodicidadpthisPeriodicidadInstance;
    }
    
    public void setPeriodicidadDelPeriodicidadpthisPeriodicidadInstance(Periodicidad periodicidadDelPeriodicidadpthisPeriodicidad) {
        this.periodicidadDelPeriodicidadpthisPeriodicidadInstance = periodicidadDelPeriodicidadpthisPeriodicidad;
        this.periodicidadDelPeriodicidadpthisPeriodicidad = periodicidadDelPeriodicidadpthisPeriodicidad != null ? periodicidadDelPeriodicidadpthisPeriodicidad.getOid() : null;
    }

    private void checkPeriodicidadDelPeriodicidadpthisPeriodicidad() throws NotNullArgumentException {
        if(this.getPeriodicidadDelPeriodicidadpthisPeriodicidadInstance() == null || this.getPeriodicidadDelPeriodicidadpthisPeriodicidadInstance().isNull()) {
            throw new NotNullArgumentException(PeriodicidadConstants.SERV_ID_DELPERIODICIDAD, PeriodicidadConstants.CLASS_ID, PeriodicidadConstants.ARG_ID_DELPERIODICIDAD_PERIODICIDADDELPERIODICIDADPTHISPERIODICIDAD, PeriodicidadConstants.SERV_ALIAS_DELPERIODICIDAD, PeriodicidadConstants.CLASS_ALIAS, PeriodicidadConstants.ARG_ALIAS_DELPERIODICIDAD_PERIODICIDADDELPERIODICIDADPTHISPERIODICIDAD);
        }
    }

    @JsonIgnore
    public ContratoCOid getPeriodicidadDelPeriodicidadpevcContratoC() {
        return this.periodicidadDelPeriodicidadpevcContratoC;
    }
    
    public void setPeriodicidadDelPeriodicidadpevcContratoC(ContratoCOid periodicidadDelPeriodicidadpevcContratoC) {
        this.periodicidadDelPeriodicidadpevcContratoC = periodicidadDelPeriodicidadpevcContratoC;
    }

    @JsonIgnore
    public ContratoC getPeriodicidadDelPeriodicidadpevcContratoCInstance() {
        return this.periodicidadDelPeriodicidadpevcContratoCInstance;
    }
    
    public void setPeriodicidadDelPeriodicidadpevcContratoCInstance(ContratoC periodicidadDelPeriodicidadpevcContratoC) {
        this.periodicidadDelPeriodicidadpevcContratoCInstance = periodicidadDelPeriodicidadpevcContratoC;
        this.periodicidadDelPeriodicidadpevcContratoC = periodicidadDelPeriodicidadpevcContratoC != null ? periodicidadDelPeriodicidadpevcContratoC.getOid() : null;
    }

    private void checkPeriodicidadDelPeriodicidadpevcContratoC() throws NotNullArgumentException {
        if(this.getPeriodicidadDelPeriodicidadpevcContratoCInstance() == null || this.getPeriodicidadDelPeriodicidadpevcContratoCInstance().isNull()) {
            throw new NotNullArgumentException(PeriodicidadConstants.SERV_ID_DELPERIODICIDAD, PeriodicidadConstants.CLASS_ID, PeriodicidadConstants.ARG_ID_DELPERIODICIDAD_PERIODICIDADDELPERIODICIDADPEVCCONTRATOC, PeriodicidadConstants.SERV_ALIAS_DELPERIODICIDAD, PeriodicidadConstants.CLASS_ALIAS, PeriodicidadConstants.ARG_ALIAS_DELPERIODICIDAD_PERIODICIDADDELPERIODICIDADPEVCCONTRATOC);
        }
    }
}
