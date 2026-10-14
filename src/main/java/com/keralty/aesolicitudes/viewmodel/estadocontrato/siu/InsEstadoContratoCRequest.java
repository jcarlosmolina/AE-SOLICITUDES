package com.keralty.aesolicitudes.viewmodel.estadocontrato.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.EstadoContratoConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.EstadoContrato;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.EstadoContratoOid;

public class InsEstadoContratoCRequest {

    @JsonProperty("p_thisestadocontrato_oid")
    private EstadoContratoOid estadoContratoInsEstadoContratoCpthisEstadoContrato;
    
    @JsonIgnore
    private EstadoContrato estadoContratoInsEstadoContratoCpthisEstadoContratoInstance;

    @JsonProperty("p_evccontratoc_oid")
    private ContratoCOid estadoContratoInsEstadoContratoCpevcContratoC;
    
    @JsonIgnore
    private ContratoC estadoContratoInsEstadoContratoCpevcContratoCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkEstadoContratoInsEstadoContratoCpthisEstadoContrato();
        checkEstadoContratoInsEstadoContratoCpevcContratoC();
    }

    @JsonIgnore
    public EstadoContratoOid getEstadoContratoInsEstadoContratoCpthisEstadoContrato() {
        return this.estadoContratoInsEstadoContratoCpthisEstadoContrato;
    }
    
    public void setEstadoContratoInsEstadoContratoCpthisEstadoContrato(EstadoContratoOid estadoContratoInsEstadoContratoCpthisEstadoContrato) {
        this.estadoContratoInsEstadoContratoCpthisEstadoContrato = estadoContratoInsEstadoContratoCpthisEstadoContrato;
    }

    @JsonIgnore
    public EstadoContrato getEstadoContratoInsEstadoContratoCpthisEstadoContratoInstance() {
        return this.estadoContratoInsEstadoContratoCpthisEstadoContratoInstance;
    }
    
    public void setEstadoContratoInsEstadoContratoCpthisEstadoContratoInstance(EstadoContrato estadoContratoInsEstadoContratoCpthisEstadoContrato) {
        this.estadoContratoInsEstadoContratoCpthisEstadoContratoInstance = estadoContratoInsEstadoContratoCpthisEstadoContrato;
        this.estadoContratoInsEstadoContratoCpthisEstadoContrato = estadoContratoInsEstadoContratoCpthisEstadoContrato != null ? estadoContratoInsEstadoContratoCpthisEstadoContrato.getOid() : null;
    }

    private void checkEstadoContratoInsEstadoContratoCpthisEstadoContrato() throws NotNullArgumentException {
        if(this.getEstadoContratoInsEstadoContratoCpthisEstadoContratoInstance() == null || this.getEstadoContratoInsEstadoContratoCpthisEstadoContratoInstance().isNull()) {
            throw new NotNullArgumentException(EstadoContratoConstants.SERV_ID_INSESTADOCONTRATOC, EstadoContratoConstants.CLASS_ID, EstadoContratoConstants.ARG_ID_INSESTADOCONTRATOC_ESTADOCONTRATOINSESTADOCONTRATOCPTHISESTADOCONTRATO, EstadoContratoConstants.SERV_ALIAS_INSESTADOCONTRATOC, EstadoContratoConstants.CLASS_ALIAS, EstadoContratoConstants.ARG_ALIAS_INSESTADOCONTRATOC_ESTADOCONTRATOINSESTADOCONTRATOCPTHISESTADOCONTRATO);
        }
    }

    @JsonIgnore
    public ContratoCOid getEstadoContratoInsEstadoContratoCpevcContratoC() {
        return this.estadoContratoInsEstadoContratoCpevcContratoC;
    }
    
    public void setEstadoContratoInsEstadoContratoCpevcContratoC(ContratoCOid estadoContratoInsEstadoContratoCpevcContratoC) {
        this.estadoContratoInsEstadoContratoCpevcContratoC = estadoContratoInsEstadoContratoCpevcContratoC;
    }

    @JsonIgnore
    public ContratoC getEstadoContratoInsEstadoContratoCpevcContratoCInstance() {
        return this.estadoContratoInsEstadoContratoCpevcContratoCInstance;
    }
    
    public void setEstadoContratoInsEstadoContratoCpevcContratoCInstance(ContratoC estadoContratoInsEstadoContratoCpevcContratoC) {
        this.estadoContratoInsEstadoContratoCpevcContratoCInstance = estadoContratoInsEstadoContratoCpevcContratoC;
        this.estadoContratoInsEstadoContratoCpevcContratoC = estadoContratoInsEstadoContratoCpevcContratoC != null ? estadoContratoInsEstadoContratoCpevcContratoC.getOid() : null;
    }

    private void checkEstadoContratoInsEstadoContratoCpevcContratoC() throws NotNullArgumentException {
        if(this.getEstadoContratoInsEstadoContratoCpevcContratoCInstance() == null || this.getEstadoContratoInsEstadoContratoCpevcContratoCInstance().isNull()) {
            throw new NotNullArgumentException(EstadoContratoConstants.SERV_ID_INSESTADOCONTRATOC, EstadoContratoConstants.CLASS_ID, EstadoContratoConstants.ARG_ID_INSESTADOCONTRATOC_ESTADOCONTRATOINSESTADOCONTRATOCPEVCCONTRATOC, EstadoContratoConstants.SERV_ALIAS_INSESTADOCONTRATOC, EstadoContratoConstants.CLASS_ALIAS, EstadoContratoConstants.ARG_ALIAS_INSESTADOCONTRATOC_ESTADOCONTRATOINSESTADOCONTRATOCPEVCCONTRATOC);
        }
    }
}
