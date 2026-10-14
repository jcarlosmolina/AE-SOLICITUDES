package com.keralty.aesolicitudes.viewmodel.planes.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.PlanesConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.PlanesOid;
import com.keralty.aesolicitudes.persistence.Planes;

public class ChgPlanCRequest {

    @JsonProperty("p_thisplanes_oid")
    private PlanesOid planeschgPlanCpthisPlanes;
    
    @JsonIgnore
    private Planes planeschgPlanCpthisPlanesInstance;

    @JsonProperty("p_evccontratoc_oid")
    private ContratoCOid planeschgPlanCpevcContratoC;
    
    @JsonIgnore
    private ContratoC planeschgPlanCpevcContratoCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkPlaneschgPlanCpthisPlanes();
        checkPlaneschgPlanCpevcContratoC();
    }

    @JsonIgnore
    public PlanesOid getPlaneschgPlanCpthisPlanes() {
        return this.planeschgPlanCpthisPlanes;
    }
    
    public void setPlaneschgPlanCpthisPlanes(PlanesOid planeschgPlanCpthisPlanes) {
        this.planeschgPlanCpthisPlanes = planeschgPlanCpthisPlanes;
    }

    @JsonIgnore
    public Planes getPlaneschgPlanCpthisPlanesInstance() {
        return this.planeschgPlanCpthisPlanesInstance;
    }
    
    public void setPlaneschgPlanCpthisPlanesInstance(Planes planeschgPlanCpthisPlanes) {
        this.planeschgPlanCpthisPlanesInstance = planeschgPlanCpthisPlanes;
        this.planeschgPlanCpthisPlanes = planeschgPlanCpthisPlanes != null ? planeschgPlanCpthisPlanes.getOid() : null;
    }

    private void checkPlaneschgPlanCpthisPlanes() throws NotNullArgumentException {
        if(this.getPlaneschgPlanCpthisPlanesInstance() == null || this.getPlaneschgPlanCpthisPlanesInstance().isNull()) {
            throw new NotNullArgumentException(PlanesConstants.SERV_ID_CHGPLANC, PlanesConstants.CLASS_ID, PlanesConstants.ARG_ID_CHGPLANC_PLANESCHGPLANCPTHISPLANES, PlanesConstants.SERV_ALIAS_CHGPLANC, PlanesConstants.CLASS_ALIAS, PlanesConstants.ARG_ALIAS_CHGPLANC_PLANESCHGPLANCPTHISPLANES);
        }
    }

    @JsonIgnore
    public ContratoCOid getPlaneschgPlanCpevcContratoC() {
        return this.planeschgPlanCpevcContratoC;
    }
    
    public void setPlaneschgPlanCpevcContratoC(ContratoCOid planeschgPlanCpevcContratoC) {
        this.planeschgPlanCpevcContratoC = planeschgPlanCpevcContratoC;
    }

    @JsonIgnore
    public ContratoC getPlaneschgPlanCpevcContratoCInstance() {
        return this.planeschgPlanCpevcContratoCInstance;
    }
    
    public void setPlaneschgPlanCpevcContratoCInstance(ContratoC planeschgPlanCpevcContratoC) {
        this.planeschgPlanCpevcContratoCInstance = planeschgPlanCpevcContratoC;
        this.planeschgPlanCpevcContratoC = planeschgPlanCpevcContratoC != null ? planeschgPlanCpevcContratoC.getOid() : null;
    }

    private void checkPlaneschgPlanCpevcContratoC() throws NotNullArgumentException {
        if(this.getPlaneschgPlanCpevcContratoCInstance() == null || this.getPlaneschgPlanCpevcContratoCInstance().isNull()) {
            throw new NotNullArgumentException(PlanesConstants.SERV_ID_CHGPLANC, PlanesConstants.CLASS_ID, PlanesConstants.ARG_ID_CHGPLANC_PLANESCHGPLANCPEVCCONTRATOC, PlanesConstants.SERV_ALIAS_CHGPLANC, PlanesConstants.CLASS_ALIAS, PlanesConstants.ARG_ALIAS_CHGPLANC_PLANESCHGPLANCPEVCCONTRATOC);
        }
    }
}
