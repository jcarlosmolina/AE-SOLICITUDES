package com.keralty.aesolicitudes.viewmodel.estadocontrato.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.EstadoContratoConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.EstadoContrato;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.EstadoContratoOid;

public class DelEstadoContratoCRequest {

    @JsonProperty("p_thisestadocontrato_oid")
    private EstadoContratoOid estadoContratoDelEstadoContratoCpthisEstadoContrato;
    
    @JsonIgnore
    private EstadoContrato estadoContratoDelEstadoContratoCpthisEstadoContratoInstance;

    @JsonProperty("p_evccontratoc_oid")
    private ContratoCOid estadoContratoDelEstadoContratoCpevcContratoC;
    
    @JsonIgnore
    private ContratoC estadoContratoDelEstadoContratoCpevcContratoCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkEstadoContratoDelEstadoContratoCpthisEstadoContrato();
        checkEstadoContratoDelEstadoContratoCpevcContratoC();
    }

    @JsonIgnore
    public EstadoContratoOid getEstadoContratoDelEstadoContratoCpthisEstadoContrato() {
        return this.estadoContratoDelEstadoContratoCpthisEstadoContrato;
    }
    
    public void setEstadoContratoDelEstadoContratoCpthisEstadoContrato(EstadoContratoOid estadoContratoDelEstadoContratoCpthisEstadoContrato) {
        this.estadoContratoDelEstadoContratoCpthisEstadoContrato = estadoContratoDelEstadoContratoCpthisEstadoContrato;
    }

    @JsonIgnore
    public EstadoContrato getEstadoContratoDelEstadoContratoCpthisEstadoContratoInstance() {
        return this.estadoContratoDelEstadoContratoCpthisEstadoContratoInstance;
    }
    
    public void setEstadoContratoDelEstadoContratoCpthisEstadoContratoInstance(EstadoContrato estadoContratoDelEstadoContratoCpthisEstadoContrato) {
        this.estadoContratoDelEstadoContratoCpthisEstadoContratoInstance = estadoContratoDelEstadoContratoCpthisEstadoContrato;
        this.estadoContratoDelEstadoContratoCpthisEstadoContrato = estadoContratoDelEstadoContratoCpthisEstadoContrato != null ? estadoContratoDelEstadoContratoCpthisEstadoContrato.getOid() : null;
    }

    private void checkEstadoContratoDelEstadoContratoCpthisEstadoContrato() throws NotNullArgumentException {
        if(this.getEstadoContratoDelEstadoContratoCpthisEstadoContratoInstance() == null || this.getEstadoContratoDelEstadoContratoCpthisEstadoContratoInstance().isNull()) {
            throw new NotNullArgumentException(EstadoContratoConstants.SERV_ID_DELESTADOCONTRATOC, EstadoContratoConstants.CLASS_ID, EstadoContratoConstants.ARG_ID_DELESTADOCONTRATOC_ESTADOCONTRATODELESTADOCONTRATOCPTHISESTADOCONTRATO, EstadoContratoConstants.SERV_ALIAS_DELESTADOCONTRATOC, EstadoContratoConstants.CLASS_ALIAS, EstadoContratoConstants.ARG_ALIAS_DELESTADOCONTRATOC_ESTADOCONTRATODELESTADOCONTRATOCPTHISESTADOCONTRATO);
        }
    }

    @JsonIgnore
    public ContratoCOid getEstadoContratoDelEstadoContratoCpevcContratoC() {
        return this.estadoContratoDelEstadoContratoCpevcContratoC;
    }
    
    public void setEstadoContratoDelEstadoContratoCpevcContratoC(ContratoCOid estadoContratoDelEstadoContratoCpevcContratoC) {
        this.estadoContratoDelEstadoContratoCpevcContratoC = estadoContratoDelEstadoContratoCpevcContratoC;
    }

    @JsonIgnore
    public ContratoC getEstadoContratoDelEstadoContratoCpevcContratoCInstance() {
        return this.estadoContratoDelEstadoContratoCpevcContratoCInstance;
    }
    
    public void setEstadoContratoDelEstadoContratoCpevcContratoCInstance(ContratoC estadoContratoDelEstadoContratoCpevcContratoC) {
        this.estadoContratoDelEstadoContratoCpevcContratoCInstance = estadoContratoDelEstadoContratoCpevcContratoC;
        this.estadoContratoDelEstadoContratoCpevcContratoC = estadoContratoDelEstadoContratoCpevcContratoC != null ? estadoContratoDelEstadoContratoCpevcContratoC.getOid() : null;
    }

    private void checkEstadoContratoDelEstadoContratoCpevcContratoC() throws NotNullArgumentException {
        if(this.getEstadoContratoDelEstadoContratoCpevcContratoCInstance() == null || this.getEstadoContratoDelEstadoContratoCpevcContratoCInstance().isNull()) {
            throw new NotNullArgumentException(EstadoContratoConstants.SERV_ID_DELESTADOCONTRATOC, EstadoContratoConstants.CLASS_ID, EstadoContratoConstants.ARG_ID_DELESTADOCONTRATOC_ESTADOCONTRATODELESTADOCONTRATOCPEVCCONTRATOC, EstadoContratoConstants.SERV_ALIAS_DELESTADOCONTRATOC, EstadoContratoConstants.CLASS_ALIAS, EstadoContratoConstants.ARG_ALIAS_DELESTADOCONTRATOC_ESTADOCONTRATODELESTADOCONTRATOCPEVCCONTRATOC);
        }
    }
}
