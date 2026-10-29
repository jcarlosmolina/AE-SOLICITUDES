package com.keralty.aesolicitudes.viewmodel.globalservices.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.GlobalServiceConstants;
import com.keralty.aesolicitudes.persistence.oid.PlanesOid;
import com.keralty.aesolicitudes.persistence.Planes;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class OGANULARSOLAUXRequest {

    @JsonProperty("ptplan_oid")
    private PlanesOid oGANULARSOLAUXptPlan;
    
    @JsonIgnore
    private Planes oGANULARSOLAUXptPlanInstance;

    @JsonProperty("ptfechacad")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date oGANULARSOLAUXptFechaCad;

    public void checkArguments() throws NotNullArgumentException {
        checkOGANULARSOLAUXptPlan();
        checkOGANULARSOLAUXptFechaCad();
    }

    @JsonIgnore
    public PlanesOid getOGANULARSOLAUXptPlan() {
        return this.oGANULARSOLAUXptPlan;
    }
    
    public void setOGANULARSOLAUXptPlan(PlanesOid oGANULARSOLAUXptPlan) {
        this.oGANULARSOLAUXptPlan = oGANULARSOLAUXptPlan;
    }

    @JsonIgnore
    public Planes getOGANULARSOLAUXptPlanInstance() {
        return this.oGANULARSOLAUXptPlanInstance;
    }
    
    public void setOGANULARSOLAUXptPlanInstance(Planes oGANULARSOLAUXptPlan) {
        this.oGANULARSOLAUXptPlanInstance = oGANULARSOLAUXptPlan;
        this.oGANULARSOLAUXptPlan = oGANULARSOLAUXptPlan != null ? oGANULARSOLAUXptPlan.getOid() : null;
    }

    private void checkOGANULARSOLAUXptPlan() throws NotNullArgumentException {
        if(this.getOGANULARSOLAUXptPlanInstance() == null || this.getOGANULARSOLAUXptPlanInstance().isNull()) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_OGANULARSOLAUX, GlobalServiceConstants.GS_ARG_ID_OGANULARSOLAUX_OGANULARSOLAUXPTPLAN, GlobalServiceConstants.G_SERV_ALIAS_OGANULARSOLAUX, GlobalServiceConstants.GS_ARG_ALIAS_OGANULARSOLAUX_OGANULARSOLAUXPTPLAN);
        }
    }

    @JsonIgnore
    public Date getOGANULARSOLAUXptFechaCad() {
        return this.oGANULARSOLAUXptFechaCad;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setOGANULARSOLAUXptFechaCad(Date oGANULARSOLAUXptFechaCad) {
        this.oGANULARSOLAUXptFechaCad = oGANULARSOLAUXptFechaCad;
    }

    private void checkOGANULARSOLAUXptFechaCad() throws NotNullArgumentException {
        if(this.getOGANULARSOLAUXptFechaCad() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_OGANULARSOLAUX, GlobalServiceConstants.GS_ARG_ID_OGANULARSOLAUX_OGANULARSOLAUXPTFECHACAD, GlobalServiceConstants.G_SERV_ALIAS_OGANULARSOLAUX, GlobalServiceConstants.GS_ARG_ALIAS_OGANULARSOLAUX_OGANULARSOLAUXPTFECHACAD);
        }
    }
}
