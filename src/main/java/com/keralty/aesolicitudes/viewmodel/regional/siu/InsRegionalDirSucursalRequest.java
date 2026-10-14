package com.keralty.aesolicitudes.viewmodel.regional.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.RegionalConstants;
import com.keralty.aesolicitudes.persistence.DirSucursalC;
import com.keralty.aesolicitudes.persistence.oid.DirSucursalCOid;
import com.keralty.aesolicitudes.persistence.oid.RegionalOid;
import com.keralty.aesolicitudes.persistence.Regional;

public class InsRegionalDirSucursalRequest {

    @JsonProperty("p_thisregional_oid")
    private RegionalOid regionalInsRegionalDirSucursalpthisRegional;
    
    @JsonIgnore
    private Regional regionalInsRegionalDirSucursalpthisRegionalInstance;

    @JsonProperty("p_evcdirsucursalc_oid")
    private DirSucursalCOid regionalInsRegionalDirSucursalpevcDirSucursalC;
    
    @JsonIgnore
    private DirSucursalC regionalInsRegionalDirSucursalpevcDirSucursalCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkRegionalInsRegionalDirSucursalpthisRegional();
        checkRegionalInsRegionalDirSucursalpevcDirSucursalC();
    }

    @JsonIgnore
    public RegionalOid getRegionalInsRegionalDirSucursalpthisRegional() {
        return this.regionalInsRegionalDirSucursalpthisRegional;
    }
    
    public void setRegionalInsRegionalDirSucursalpthisRegional(RegionalOid regionalInsRegionalDirSucursalpthisRegional) {
        this.regionalInsRegionalDirSucursalpthisRegional = regionalInsRegionalDirSucursalpthisRegional;
    }

    @JsonIgnore
    public Regional getRegionalInsRegionalDirSucursalpthisRegionalInstance() {
        return this.regionalInsRegionalDirSucursalpthisRegionalInstance;
    }
    
    public void setRegionalInsRegionalDirSucursalpthisRegionalInstance(Regional regionalInsRegionalDirSucursalpthisRegional) {
        this.regionalInsRegionalDirSucursalpthisRegionalInstance = regionalInsRegionalDirSucursalpthisRegional;
        this.regionalInsRegionalDirSucursalpthisRegional = regionalInsRegionalDirSucursalpthisRegional != null ? regionalInsRegionalDirSucursalpthisRegional.getOid() : null;
    }

    private void checkRegionalInsRegionalDirSucursalpthisRegional() throws NotNullArgumentException {
        if(this.getRegionalInsRegionalDirSucursalpthisRegionalInstance() == null || this.getRegionalInsRegionalDirSucursalpthisRegionalInstance().isNull()) {
            throw new NotNullArgumentException(RegionalConstants.SERV_ID_INSREGIONALDIRSUCURSAL, RegionalConstants.CLASS_ID, RegionalConstants.ARG_ID_INSREGIONALDIRSUCURSAL_REGIONALINSREGIONALDIRSUCURSALPTHISREGIONAL, RegionalConstants.SERV_ALIAS_INSREGIONALDIRSUCURSAL, RegionalConstants.CLASS_ALIAS, RegionalConstants.ARG_ALIAS_INSREGIONALDIRSUCURSAL_REGIONALINSREGIONALDIRSUCURSALPTHISREGIONAL);
        }
    }

    @JsonIgnore
    public DirSucursalCOid getRegionalInsRegionalDirSucursalpevcDirSucursalC() {
        return this.regionalInsRegionalDirSucursalpevcDirSucursalC;
    }
    
    public void setRegionalInsRegionalDirSucursalpevcDirSucursalC(DirSucursalCOid regionalInsRegionalDirSucursalpevcDirSucursalC) {
        this.regionalInsRegionalDirSucursalpevcDirSucursalC = regionalInsRegionalDirSucursalpevcDirSucursalC;
    }

    @JsonIgnore
    public DirSucursalC getRegionalInsRegionalDirSucursalpevcDirSucursalCInstance() {
        return this.regionalInsRegionalDirSucursalpevcDirSucursalCInstance;
    }
    
    public void setRegionalInsRegionalDirSucursalpevcDirSucursalCInstance(DirSucursalC regionalInsRegionalDirSucursalpevcDirSucursalC) {
        this.regionalInsRegionalDirSucursalpevcDirSucursalCInstance = regionalInsRegionalDirSucursalpevcDirSucursalC;
        this.regionalInsRegionalDirSucursalpevcDirSucursalC = regionalInsRegionalDirSucursalpevcDirSucursalC != null ? regionalInsRegionalDirSucursalpevcDirSucursalC.getOid() : null;
    }

    private void checkRegionalInsRegionalDirSucursalpevcDirSucursalC() throws NotNullArgumentException {
        if(this.getRegionalInsRegionalDirSucursalpevcDirSucursalCInstance() == null || this.getRegionalInsRegionalDirSucursalpevcDirSucursalCInstance().isNull()) {
            throw new NotNullArgumentException(RegionalConstants.SERV_ID_INSREGIONALDIRSUCURSAL, RegionalConstants.CLASS_ID, RegionalConstants.ARG_ID_INSREGIONALDIRSUCURSAL_REGIONALINSREGIONALDIRSUCURSALPEVCDIRSUCURSALC, RegionalConstants.SERV_ALIAS_INSREGIONALDIRSUCURSAL, RegionalConstants.CLASS_ALIAS, RegionalConstants.ARG_ALIAS_INSREGIONALDIRSUCURSAL_REGIONALINSREGIONALDIRSUCURSALPEVCDIRSUCURSALC);
        }
    }
}
