package com.keralty.aesolicitudes.viewmodel.regional.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.RegionalConstants;
import com.keralty.aesolicitudes.persistence.DirSucursalC;
import com.keralty.aesolicitudes.persistence.oid.DirSucursalCOid;
import com.keralty.aesolicitudes.persistence.oid.RegionalOid;
import com.keralty.aesolicitudes.persistence.Regional;

public class DelRegionalDirSucursalRequest {

    @JsonProperty("p_thisregional_oid")
    private RegionalOid regionalDelRegionalDirSucursalpthisRegional;
    
    @JsonIgnore
    private Regional regionalDelRegionalDirSucursalpthisRegionalInstance;

    @JsonProperty("p_evcdirsucursalc_oid")
    private DirSucursalCOid regionalDelRegionalDirSucursalpevcDirSucursalC;
    
    @JsonIgnore
    private DirSucursalC regionalDelRegionalDirSucursalpevcDirSucursalCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkRegionalDelRegionalDirSucursalpthisRegional();
        checkRegionalDelRegionalDirSucursalpevcDirSucursalC();
    }

    @JsonIgnore
    public RegionalOid getRegionalDelRegionalDirSucursalpthisRegional() {
        return this.regionalDelRegionalDirSucursalpthisRegional;
    }
    
    public void setRegionalDelRegionalDirSucursalpthisRegional(RegionalOid regionalDelRegionalDirSucursalpthisRegional) {
        this.regionalDelRegionalDirSucursalpthisRegional = regionalDelRegionalDirSucursalpthisRegional;
    }

    @JsonIgnore
    public Regional getRegionalDelRegionalDirSucursalpthisRegionalInstance() {
        return this.regionalDelRegionalDirSucursalpthisRegionalInstance;
    }
    
    public void setRegionalDelRegionalDirSucursalpthisRegionalInstance(Regional regionalDelRegionalDirSucursalpthisRegional) {
        this.regionalDelRegionalDirSucursalpthisRegionalInstance = regionalDelRegionalDirSucursalpthisRegional;
        this.regionalDelRegionalDirSucursalpthisRegional = regionalDelRegionalDirSucursalpthisRegional != null ? regionalDelRegionalDirSucursalpthisRegional.getOid() : null;
    }

    private void checkRegionalDelRegionalDirSucursalpthisRegional() throws NotNullArgumentException {
        if(this.getRegionalDelRegionalDirSucursalpthisRegionalInstance() == null || this.getRegionalDelRegionalDirSucursalpthisRegionalInstance().isNull()) {
            throw new NotNullArgumentException(RegionalConstants.SERV_ID_DELREGIONALDIRSUCURSAL, RegionalConstants.CLASS_ID, RegionalConstants.ARG_ID_DELREGIONALDIRSUCURSAL_REGIONALDELREGIONALDIRSUCURSALPTHISREGIONAL, RegionalConstants.SERV_ALIAS_DELREGIONALDIRSUCURSAL, RegionalConstants.CLASS_ALIAS, RegionalConstants.ARG_ALIAS_DELREGIONALDIRSUCURSAL_REGIONALDELREGIONALDIRSUCURSALPTHISREGIONAL);
        }
    }

    @JsonIgnore
    public DirSucursalCOid getRegionalDelRegionalDirSucursalpevcDirSucursalC() {
        return this.regionalDelRegionalDirSucursalpevcDirSucursalC;
    }
    
    public void setRegionalDelRegionalDirSucursalpevcDirSucursalC(DirSucursalCOid regionalDelRegionalDirSucursalpevcDirSucursalC) {
        this.regionalDelRegionalDirSucursalpevcDirSucursalC = regionalDelRegionalDirSucursalpevcDirSucursalC;
    }

    @JsonIgnore
    public DirSucursalC getRegionalDelRegionalDirSucursalpevcDirSucursalCInstance() {
        return this.regionalDelRegionalDirSucursalpevcDirSucursalCInstance;
    }
    
    public void setRegionalDelRegionalDirSucursalpevcDirSucursalCInstance(DirSucursalC regionalDelRegionalDirSucursalpevcDirSucursalC) {
        this.regionalDelRegionalDirSucursalpevcDirSucursalCInstance = regionalDelRegionalDirSucursalpevcDirSucursalC;
        this.regionalDelRegionalDirSucursalpevcDirSucursalC = regionalDelRegionalDirSucursalpevcDirSucursalC != null ? regionalDelRegionalDirSucursalpevcDirSucursalC.getOid() : null;
    }

    private void checkRegionalDelRegionalDirSucursalpevcDirSucursalC() throws NotNullArgumentException {
        if(this.getRegionalDelRegionalDirSucursalpevcDirSucursalCInstance() == null || this.getRegionalDelRegionalDirSucursalpevcDirSucursalCInstance().isNull()) {
            throw new NotNullArgumentException(RegionalConstants.SERV_ID_DELREGIONALDIRSUCURSAL, RegionalConstants.CLASS_ID, RegionalConstants.ARG_ID_DELREGIONALDIRSUCURSAL_REGIONALDELREGIONALDIRSUCURSALPEVCDIRSUCURSALC, RegionalConstants.SERV_ALIAS_DELREGIONALDIRSUCURSAL, RegionalConstants.CLASS_ALIAS, RegionalConstants.ARG_ALIAS_DELREGIONALDIRSUCURSAL_REGIONALDELREGIONALDIRSUCURSALPEVCDIRSUCURSALC);
        }
    }
}
