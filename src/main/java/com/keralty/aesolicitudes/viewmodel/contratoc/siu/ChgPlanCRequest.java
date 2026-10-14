package com.keralty.aesolicitudes.viewmodel.contratoc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ContratoCConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.PlanesOid;
import com.keralty.aesolicitudes.persistence.Planes;

public class ChgPlanCRequest {

    @JsonProperty("p_thiscontratoc_oid")
    private ContratoCOid contratoCchgPlanCpthisContratoC;
    
    @JsonIgnore
    private ContratoC contratoCchgPlanCpthisContratoCInstance;

    @JsonProperty("p_evcplanes_oid")
    private PlanesOid contratoCchgPlanCpevcPlanes;
    
    @JsonIgnore
    private Planes contratoCchgPlanCpevcPlanesInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkContratoCchgPlanCpthisContratoC();
        checkContratoCchgPlanCpevcPlanes();
    }

    @JsonIgnore
    public ContratoCOid getContratoCchgPlanCpthisContratoC() {
        return this.contratoCchgPlanCpthisContratoC;
    }
    
    public void setContratoCchgPlanCpthisContratoC(ContratoCOid contratoCchgPlanCpthisContratoC) {
        this.contratoCchgPlanCpthisContratoC = contratoCchgPlanCpthisContratoC;
    }

    @JsonIgnore
    public ContratoC getContratoCchgPlanCpthisContratoCInstance() {
        return this.contratoCchgPlanCpthisContratoCInstance;
    }
    
    public void setContratoCchgPlanCpthisContratoCInstance(ContratoC contratoCchgPlanCpthisContratoC) {
        this.contratoCchgPlanCpthisContratoCInstance = contratoCchgPlanCpthisContratoC;
        this.contratoCchgPlanCpthisContratoC = contratoCchgPlanCpthisContratoC != null ? contratoCchgPlanCpthisContratoC.getOid() : null;
    }

    private void checkContratoCchgPlanCpthisContratoC() throws NotNullArgumentException {
        if(this.getContratoCchgPlanCpthisContratoCInstance() == null || this.getContratoCchgPlanCpthisContratoCInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_CHGPLANC, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_CHGPLANC_CONTRATOCCHGPLANCPTHISCONTRATOC, ContratoCConstants.SERV_ALIAS_CHGPLANC, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_CHGPLANC_CONTRATOCCHGPLANCPTHISCONTRATOC);
        }
    }

    @JsonIgnore
    public PlanesOid getContratoCchgPlanCpevcPlanes() {
        return this.contratoCchgPlanCpevcPlanes;
    }
    
    public void setContratoCchgPlanCpevcPlanes(PlanesOid contratoCchgPlanCpevcPlanes) {
        this.contratoCchgPlanCpevcPlanes = contratoCchgPlanCpevcPlanes;
    }

    @JsonIgnore
    public Planes getContratoCchgPlanCpevcPlanesInstance() {
        return this.contratoCchgPlanCpevcPlanesInstance;
    }
    
    public void setContratoCchgPlanCpevcPlanesInstance(Planes contratoCchgPlanCpevcPlanes) {
        this.contratoCchgPlanCpevcPlanesInstance = contratoCchgPlanCpevcPlanes;
        this.contratoCchgPlanCpevcPlanes = contratoCchgPlanCpevcPlanes != null ? contratoCchgPlanCpevcPlanes.getOid() : null;
    }

    private void checkContratoCchgPlanCpevcPlanes() throws NotNullArgumentException {
        if(this.getContratoCchgPlanCpevcPlanesInstance() == null || this.getContratoCchgPlanCpevcPlanesInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_CHGPLANC, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_CHGPLANC_CONTRATOCCHGPLANCPEVCPLANES, ContratoCConstants.SERV_ALIAS_CHGPLANC, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_CHGPLANC_CONTRATOCCHGPLANCPEVCPLANES);
        }
    }
}
