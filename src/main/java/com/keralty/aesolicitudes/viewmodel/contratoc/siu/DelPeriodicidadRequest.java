package com.keralty.aesolicitudes.viewmodel.contratoc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ContratoCConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.PeriodicidadOid;
import com.keralty.aesolicitudes.persistence.Periodicidad;

public class DelPeriodicidadRequest {

    @JsonProperty("p_thiscontratoc_oid")
    private ContratoCOid contratoCDelPeriodicidadpthisContratoC;
    
    @JsonIgnore
    private ContratoC contratoCDelPeriodicidadpthisContratoCInstance;

    @JsonProperty("p_evcperiodicidad_oid")
    private PeriodicidadOid contratoCDelPeriodicidadpevcPeriodicidad;
    
    @JsonIgnore
    private Periodicidad contratoCDelPeriodicidadpevcPeriodicidadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkContratoCDelPeriodicidadpthisContratoC();
        checkContratoCDelPeriodicidadpevcPeriodicidad();
    }

    @JsonIgnore
    public ContratoCOid getContratoCDelPeriodicidadpthisContratoC() {
        return this.contratoCDelPeriodicidadpthisContratoC;
    }
    
    public void setContratoCDelPeriodicidadpthisContratoC(ContratoCOid contratoCDelPeriodicidadpthisContratoC) {
        this.contratoCDelPeriodicidadpthisContratoC = contratoCDelPeriodicidadpthisContratoC;
    }

    @JsonIgnore
    public ContratoC getContratoCDelPeriodicidadpthisContratoCInstance() {
        return this.contratoCDelPeriodicidadpthisContratoCInstance;
    }
    
    public void setContratoCDelPeriodicidadpthisContratoCInstance(ContratoC contratoCDelPeriodicidadpthisContratoC) {
        this.contratoCDelPeriodicidadpthisContratoCInstance = contratoCDelPeriodicidadpthisContratoC;
        this.contratoCDelPeriodicidadpthisContratoC = contratoCDelPeriodicidadpthisContratoC != null ? contratoCDelPeriodicidadpthisContratoC.getOid() : null;
    }

    private void checkContratoCDelPeriodicidadpthisContratoC() throws NotNullArgumentException {
        if(this.getContratoCDelPeriodicidadpthisContratoCInstance() == null || this.getContratoCDelPeriodicidadpthisContratoCInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_DELPERIODICIDAD, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_DELPERIODICIDAD_CONTRATOCDELPERIODICIDADPTHISCONTRATOC, ContratoCConstants.SERV_ALIAS_DELPERIODICIDAD, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_DELPERIODICIDAD_CONTRATOCDELPERIODICIDADPTHISCONTRATOC);
        }
    }

    @JsonIgnore
    public PeriodicidadOid getContratoCDelPeriodicidadpevcPeriodicidad() {
        return this.contratoCDelPeriodicidadpevcPeriodicidad;
    }
    
    public void setContratoCDelPeriodicidadpevcPeriodicidad(PeriodicidadOid contratoCDelPeriodicidadpevcPeriodicidad) {
        this.contratoCDelPeriodicidadpevcPeriodicidad = contratoCDelPeriodicidadpevcPeriodicidad;
    }

    @JsonIgnore
    public Periodicidad getContratoCDelPeriodicidadpevcPeriodicidadInstance() {
        return this.contratoCDelPeriodicidadpevcPeriodicidadInstance;
    }
    
    public void setContratoCDelPeriodicidadpevcPeriodicidadInstance(Periodicidad contratoCDelPeriodicidadpevcPeriodicidad) {
        this.contratoCDelPeriodicidadpevcPeriodicidadInstance = contratoCDelPeriodicidadpevcPeriodicidad;
        this.contratoCDelPeriodicidadpevcPeriodicidad = contratoCDelPeriodicidadpevcPeriodicidad != null ? contratoCDelPeriodicidadpevcPeriodicidad.getOid() : null;
    }

    private void checkContratoCDelPeriodicidadpevcPeriodicidad() throws NotNullArgumentException {
        if(this.getContratoCDelPeriodicidadpevcPeriodicidadInstance() == null || this.getContratoCDelPeriodicidadpevcPeriodicidadInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_DELPERIODICIDAD, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_DELPERIODICIDAD_CONTRATOCDELPERIODICIDADPEVCPERIODICIDAD, ContratoCConstants.SERV_ALIAS_DELPERIODICIDAD, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_DELPERIODICIDAD_CONTRATOCDELPERIODICIDADPEVCPERIODICIDAD);
        }
    }
}
