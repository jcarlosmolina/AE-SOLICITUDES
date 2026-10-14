package com.keralty.aesolicitudes.viewmodel.periodicidad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.PeriodicidadConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.PeriodicidadOid;
import com.keralty.aesolicitudes.persistence.Periodicidad;

public class InsPeriodicidadRequest {

    @JsonProperty("p_thisperiodicidad_oid")
    private PeriodicidadOid periodicidadInsPeriodicidadpthisPeriodicidad;
    
    @JsonIgnore
    private Periodicidad periodicidadInsPeriodicidadpthisPeriodicidadInstance;

    @JsonProperty("p_evccontratoc_oid")
    private ContratoCOid periodicidadInsPeriodicidadpevcContratoC;
    
    @JsonIgnore
    private ContratoC periodicidadInsPeriodicidadpevcContratoCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkPeriodicidadInsPeriodicidadpthisPeriodicidad();
        checkPeriodicidadInsPeriodicidadpevcContratoC();
    }

    @JsonIgnore
    public PeriodicidadOid getPeriodicidadInsPeriodicidadpthisPeriodicidad() {
        return this.periodicidadInsPeriodicidadpthisPeriodicidad;
    }
    
    public void setPeriodicidadInsPeriodicidadpthisPeriodicidad(PeriodicidadOid periodicidadInsPeriodicidadpthisPeriodicidad) {
        this.periodicidadInsPeriodicidadpthisPeriodicidad = periodicidadInsPeriodicidadpthisPeriodicidad;
    }

    @JsonIgnore
    public Periodicidad getPeriodicidadInsPeriodicidadpthisPeriodicidadInstance() {
        return this.periodicidadInsPeriodicidadpthisPeriodicidadInstance;
    }
    
    public void setPeriodicidadInsPeriodicidadpthisPeriodicidadInstance(Periodicidad periodicidadInsPeriodicidadpthisPeriodicidad) {
        this.periodicidadInsPeriodicidadpthisPeriodicidadInstance = periodicidadInsPeriodicidadpthisPeriodicidad;
        this.periodicidadInsPeriodicidadpthisPeriodicidad = periodicidadInsPeriodicidadpthisPeriodicidad != null ? periodicidadInsPeriodicidadpthisPeriodicidad.getOid() : null;
    }

    private void checkPeriodicidadInsPeriodicidadpthisPeriodicidad() throws NotNullArgumentException {
        if(this.getPeriodicidadInsPeriodicidadpthisPeriodicidadInstance() == null || this.getPeriodicidadInsPeriodicidadpthisPeriodicidadInstance().isNull()) {
            throw new NotNullArgumentException(PeriodicidadConstants.SERV_ID_INSPERIODICIDAD, PeriodicidadConstants.CLASS_ID, PeriodicidadConstants.ARG_ID_INSPERIODICIDAD_PERIODICIDADINSPERIODICIDADPTHISPERIODICIDAD, PeriodicidadConstants.SERV_ALIAS_INSPERIODICIDAD, PeriodicidadConstants.CLASS_ALIAS, PeriodicidadConstants.ARG_ALIAS_INSPERIODICIDAD_PERIODICIDADINSPERIODICIDADPTHISPERIODICIDAD);
        }
    }

    @JsonIgnore
    public ContratoCOid getPeriodicidadInsPeriodicidadpevcContratoC() {
        return this.periodicidadInsPeriodicidadpevcContratoC;
    }
    
    public void setPeriodicidadInsPeriodicidadpevcContratoC(ContratoCOid periodicidadInsPeriodicidadpevcContratoC) {
        this.periodicidadInsPeriodicidadpevcContratoC = periodicidadInsPeriodicidadpevcContratoC;
    }

    @JsonIgnore
    public ContratoC getPeriodicidadInsPeriodicidadpevcContratoCInstance() {
        return this.periodicidadInsPeriodicidadpevcContratoCInstance;
    }
    
    public void setPeriodicidadInsPeriodicidadpevcContratoCInstance(ContratoC periodicidadInsPeriodicidadpevcContratoC) {
        this.periodicidadInsPeriodicidadpevcContratoCInstance = periodicidadInsPeriodicidadpevcContratoC;
        this.periodicidadInsPeriodicidadpevcContratoC = periodicidadInsPeriodicidadpevcContratoC != null ? periodicidadInsPeriodicidadpevcContratoC.getOid() : null;
    }

    private void checkPeriodicidadInsPeriodicidadpevcContratoC() throws NotNullArgumentException {
        if(this.getPeriodicidadInsPeriodicidadpevcContratoCInstance() == null || this.getPeriodicidadInsPeriodicidadpevcContratoCInstance().isNull()) {
            throw new NotNullArgumentException(PeriodicidadConstants.SERV_ID_INSPERIODICIDAD, PeriodicidadConstants.CLASS_ID, PeriodicidadConstants.ARG_ID_INSPERIODICIDAD_PERIODICIDADINSPERIODICIDADPEVCCONTRATOC, PeriodicidadConstants.SERV_ALIAS_INSPERIODICIDAD, PeriodicidadConstants.CLASS_ALIAS, PeriodicidadConstants.ARG_ALIAS_INSPERIODICIDAD_PERIODICIDADINSPERIODICIDADPEVCCONTRATOC);
        }
    }
}
