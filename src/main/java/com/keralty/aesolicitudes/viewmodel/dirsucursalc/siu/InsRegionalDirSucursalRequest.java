package com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DirSucursalCConstants;
import com.keralty.aesolicitudes.persistence.DirSucursalC;
import com.keralty.aesolicitudes.persistence.oid.DirSucursalCOid;
import com.keralty.aesolicitudes.persistence.oid.RegionalOid;
import com.keralty.aesolicitudes.persistence.Regional;

public class InsRegionalDirSucursalRequest {

    @JsonProperty("p_thisdirsucursalc_oid")
    private DirSucursalCOid dirSucursalCInsRegionalDirSucursalpthisDirSucursalC;
    
    @JsonIgnore
    private DirSucursalC dirSucursalCInsRegionalDirSucursalpthisDirSucursalCInstance;

    @JsonProperty("p_evcregional_oid")
    private RegionalOid dirSucursalCInsRegionalDirSucursalpevcRegional;
    
    @JsonIgnore
    private Regional dirSucursalCInsRegionalDirSucursalpevcRegionalInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkDirSucursalCInsRegionalDirSucursalpthisDirSucursalC();
        checkDirSucursalCInsRegionalDirSucursalpevcRegional();
    }

    @JsonIgnore
    public DirSucursalCOid getDirSucursalCInsRegionalDirSucursalpthisDirSucursalC() {
        return this.dirSucursalCInsRegionalDirSucursalpthisDirSucursalC;
    }
    
    public void setDirSucursalCInsRegionalDirSucursalpthisDirSucursalC(DirSucursalCOid dirSucursalCInsRegionalDirSucursalpthisDirSucursalC) {
        this.dirSucursalCInsRegionalDirSucursalpthisDirSucursalC = dirSucursalCInsRegionalDirSucursalpthisDirSucursalC;
    }

    @JsonIgnore
    public DirSucursalC getDirSucursalCInsRegionalDirSucursalpthisDirSucursalCInstance() {
        return this.dirSucursalCInsRegionalDirSucursalpthisDirSucursalCInstance;
    }
    
    public void setDirSucursalCInsRegionalDirSucursalpthisDirSucursalCInstance(DirSucursalC dirSucursalCInsRegionalDirSucursalpthisDirSucursalC) {
        this.dirSucursalCInsRegionalDirSucursalpthisDirSucursalCInstance = dirSucursalCInsRegionalDirSucursalpthisDirSucursalC;
        this.dirSucursalCInsRegionalDirSucursalpthisDirSucursalC = dirSucursalCInsRegionalDirSucursalpthisDirSucursalC != null ? dirSucursalCInsRegionalDirSucursalpthisDirSucursalC.getOid() : null;
    }

    private void checkDirSucursalCInsRegionalDirSucursalpthisDirSucursalC() throws NotNullArgumentException {
        if(this.getDirSucursalCInsRegionalDirSucursalpthisDirSucursalCInstance() == null || this.getDirSucursalCInsRegionalDirSucursalpthisDirSucursalCInstance().isNull()) {
            throw new NotNullArgumentException(DirSucursalCConstants.SERV_ID_INSREGIONALDIRSUCURSAL, DirSucursalCConstants.CLASS_ID, DirSucursalCConstants.ARG_ID_INSREGIONALDIRSUCURSAL_DIRSUCURSALCINSREGIONALDIRSUCURSALPTHISDIRSUCURSALC, DirSucursalCConstants.SERV_ALIAS_INSREGIONALDIRSUCURSAL, DirSucursalCConstants.CLASS_ALIAS, DirSucursalCConstants.ARG_ALIAS_INSREGIONALDIRSUCURSAL_DIRSUCURSALCINSREGIONALDIRSUCURSALPTHISDIRSUCURSALC);
        }
    }

    @JsonIgnore
    public RegionalOid getDirSucursalCInsRegionalDirSucursalpevcRegional() {
        return this.dirSucursalCInsRegionalDirSucursalpevcRegional;
    }
    
    public void setDirSucursalCInsRegionalDirSucursalpevcRegional(RegionalOid dirSucursalCInsRegionalDirSucursalpevcRegional) {
        this.dirSucursalCInsRegionalDirSucursalpevcRegional = dirSucursalCInsRegionalDirSucursalpevcRegional;
    }

    @JsonIgnore
    public Regional getDirSucursalCInsRegionalDirSucursalpevcRegionalInstance() {
        return this.dirSucursalCInsRegionalDirSucursalpevcRegionalInstance;
    }
    
    public void setDirSucursalCInsRegionalDirSucursalpevcRegionalInstance(Regional dirSucursalCInsRegionalDirSucursalpevcRegional) {
        this.dirSucursalCInsRegionalDirSucursalpevcRegionalInstance = dirSucursalCInsRegionalDirSucursalpevcRegional;
        this.dirSucursalCInsRegionalDirSucursalpevcRegional = dirSucursalCInsRegionalDirSucursalpevcRegional != null ? dirSucursalCInsRegionalDirSucursalpevcRegional.getOid() : null;
    }

    private void checkDirSucursalCInsRegionalDirSucursalpevcRegional() throws NotNullArgumentException {
        if(this.getDirSucursalCInsRegionalDirSucursalpevcRegionalInstance() == null || this.getDirSucursalCInsRegionalDirSucursalpevcRegionalInstance().isNull()) {
            throw new NotNullArgumentException(DirSucursalCConstants.SERV_ID_INSREGIONALDIRSUCURSAL, DirSucursalCConstants.CLASS_ID, DirSucursalCConstants.ARG_ID_INSREGIONALDIRSUCURSAL_DIRSUCURSALCINSREGIONALDIRSUCURSALPEVCREGIONAL, DirSucursalCConstants.SERV_ALIAS_INSREGIONALDIRSUCURSAL, DirSucursalCConstants.CLASS_ALIAS, DirSucursalCConstants.ARG_ALIAS_INSREGIONALDIRSUCURSAL_DIRSUCURSALCINSREGIONALDIRSUCURSALPEVCREGIONAL);
        }
    }
}
