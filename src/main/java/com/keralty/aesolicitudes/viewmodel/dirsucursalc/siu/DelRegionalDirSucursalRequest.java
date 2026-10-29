package com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DirSucursalCConstants;
import com.keralty.aesolicitudes.persistence.DirSucursalC;
import com.keralty.aesolicitudes.persistence.oid.DirSucursalCOid;
import com.keralty.aesolicitudes.persistence.oid.RegionalOid;
import com.keralty.aesolicitudes.persistence.Regional;

public class DelRegionalDirSucursalRequest {

    @JsonProperty("p_thisdirsucursalc_oid")
    private DirSucursalCOid dirSucursalCDelRegionalDirSucursalpthisDirSucursalC;
    
    @JsonIgnore
    private DirSucursalC dirSucursalCDelRegionalDirSucursalpthisDirSucursalCInstance;

    @JsonProperty("p_evcregional_oid")
    private RegionalOid dirSucursalCDelRegionalDirSucursalpevcRegional;
    
    @JsonIgnore
    private Regional dirSucursalCDelRegionalDirSucursalpevcRegionalInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkDirSucursalCDelRegionalDirSucursalpthisDirSucursalC();
        checkDirSucursalCDelRegionalDirSucursalpevcRegional();
    }

    @JsonIgnore
    public DirSucursalCOid getDirSucursalCDelRegionalDirSucursalpthisDirSucursalC() {
        return this.dirSucursalCDelRegionalDirSucursalpthisDirSucursalC;
    }
    
    public void setDirSucursalCDelRegionalDirSucursalpthisDirSucursalC(DirSucursalCOid dirSucursalCDelRegionalDirSucursalpthisDirSucursalC) {
        this.dirSucursalCDelRegionalDirSucursalpthisDirSucursalC = dirSucursalCDelRegionalDirSucursalpthisDirSucursalC;
    }

    @JsonIgnore
    public DirSucursalC getDirSucursalCDelRegionalDirSucursalpthisDirSucursalCInstance() {
        return this.dirSucursalCDelRegionalDirSucursalpthisDirSucursalCInstance;
    }
    
    public void setDirSucursalCDelRegionalDirSucursalpthisDirSucursalCInstance(DirSucursalC dirSucursalCDelRegionalDirSucursalpthisDirSucursalC) {
        this.dirSucursalCDelRegionalDirSucursalpthisDirSucursalCInstance = dirSucursalCDelRegionalDirSucursalpthisDirSucursalC;
        this.dirSucursalCDelRegionalDirSucursalpthisDirSucursalC = dirSucursalCDelRegionalDirSucursalpthisDirSucursalC != null ? dirSucursalCDelRegionalDirSucursalpthisDirSucursalC.getOid() : null;
    }

    private void checkDirSucursalCDelRegionalDirSucursalpthisDirSucursalC() throws NotNullArgumentException {
        if(this.getDirSucursalCDelRegionalDirSucursalpthisDirSucursalCInstance() == null || this.getDirSucursalCDelRegionalDirSucursalpthisDirSucursalCInstance().isNull()) {
            throw new NotNullArgumentException(DirSucursalCConstants.SERV_ID_DELREGIONALDIRSUCURSAL, DirSucursalCConstants.CLASS_ID, DirSucursalCConstants.ARG_ID_DELREGIONALDIRSUCURSAL_DIRSUCURSALCDELREGIONALDIRSUCURSALPTHISDIRSUCURSALC, DirSucursalCConstants.SERV_ALIAS_DELREGIONALDIRSUCURSAL, DirSucursalCConstants.CLASS_ALIAS, DirSucursalCConstants.ARG_ALIAS_DELREGIONALDIRSUCURSAL_DIRSUCURSALCDELREGIONALDIRSUCURSALPTHISDIRSUCURSALC);
        }
    }

    @JsonIgnore
    public RegionalOid getDirSucursalCDelRegionalDirSucursalpevcRegional() {
        return this.dirSucursalCDelRegionalDirSucursalpevcRegional;
    }
    
    public void setDirSucursalCDelRegionalDirSucursalpevcRegional(RegionalOid dirSucursalCDelRegionalDirSucursalpevcRegional) {
        this.dirSucursalCDelRegionalDirSucursalpevcRegional = dirSucursalCDelRegionalDirSucursalpevcRegional;
    }

    @JsonIgnore
    public Regional getDirSucursalCDelRegionalDirSucursalpevcRegionalInstance() {
        return this.dirSucursalCDelRegionalDirSucursalpevcRegionalInstance;
    }
    
    public void setDirSucursalCDelRegionalDirSucursalpevcRegionalInstance(Regional dirSucursalCDelRegionalDirSucursalpevcRegional) {
        this.dirSucursalCDelRegionalDirSucursalpevcRegionalInstance = dirSucursalCDelRegionalDirSucursalpevcRegional;
        this.dirSucursalCDelRegionalDirSucursalpevcRegional = dirSucursalCDelRegionalDirSucursalpevcRegional != null ? dirSucursalCDelRegionalDirSucursalpevcRegional.getOid() : null;
    }

    private void checkDirSucursalCDelRegionalDirSucursalpevcRegional() throws NotNullArgumentException {
        if(this.getDirSucursalCDelRegionalDirSucursalpevcRegionalInstance() == null || this.getDirSucursalCDelRegionalDirSucursalpevcRegionalInstance().isNull()) {
            throw new NotNullArgumentException(DirSucursalCConstants.SERV_ID_DELREGIONALDIRSUCURSAL, DirSucursalCConstants.CLASS_ID, DirSucursalCConstants.ARG_ID_DELREGIONALDIRSUCURSAL_DIRSUCURSALCDELREGIONALDIRSUCURSALPEVCREGIONAL, DirSucursalCConstants.SERV_ALIAS_DELREGIONALDIRSUCURSAL, DirSucursalCConstants.CLASS_ALIAS, DirSucursalCConstants.ARG_ALIAS_DELREGIONALDIRSUCURSAL_DIRSUCURSALCDELREGIONALDIRSUCURSALPEVCREGIONAL);
        }
    }
}
