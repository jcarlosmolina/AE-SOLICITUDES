package com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DirSucursalCConstants;
import com.keralty.aesolicitudes.persistence.DirSucursalC;
import com.keralty.aesolicitudes.persistence.oid.DirSucursalCOid;

public class TELIMINARRequest {

    @JsonProperty("p_thisdirsucursalc_oid")
    private DirSucursalCOid dirSucursalCTELIMINARpthisDirSucursalC;
    
    @JsonIgnore
    private DirSucursalC dirSucursalCTELIMINARpthisDirSucursalCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkDirSucursalCTELIMINARpthisDirSucursalC();
    }

    @JsonIgnore
    public DirSucursalCOid getDirSucursalCTELIMINARpthisDirSucursalC() {
        return this.dirSucursalCTELIMINARpthisDirSucursalC;
    }
    
    public void setDirSucursalCTELIMINARpthisDirSucursalC(DirSucursalCOid dirSucursalCTELIMINARpthisDirSucursalC) {
        this.dirSucursalCTELIMINARpthisDirSucursalC = dirSucursalCTELIMINARpthisDirSucursalC;
    }

    @JsonIgnore
    public DirSucursalC getDirSucursalCTELIMINARpthisDirSucursalCInstance() {
        return this.dirSucursalCTELIMINARpthisDirSucursalCInstance;
    }
    
    public void setDirSucursalCTELIMINARpthisDirSucursalCInstance(DirSucursalC dirSucursalCTELIMINARpthisDirSucursalC) {
        this.dirSucursalCTELIMINARpthisDirSucursalCInstance = dirSucursalCTELIMINARpthisDirSucursalC;
        this.dirSucursalCTELIMINARpthisDirSucursalC = dirSucursalCTELIMINARpthisDirSucursalC != null ? dirSucursalCTELIMINARpthisDirSucursalC.getOid() : null;
    }

    private void checkDirSucursalCTELIMINARpthisDirSucursalC() throws NotNullArgumentException {
        if(this.getDirSucursalCTELIMINARpthisDirSucursalCInstance() == null || this.getDirSucursalCTELIMINARpthisDirSucursalCInstance().isNull()) {
            throw new NotNullArgumentException(DirSucursalCConstants.SERV_ID_TELIMINAR, DirSucursalCConstants.CLASS_ID, DirSucursalCConstants.ARG_ID_TELIMINAR_DIRSUCURSALCTELIMINARPTHISDIRSUCURSALC, DirSucursalCConstants.SERV_ALIAS_TELIMINAR, DirSucursalCConstants.CLASS_ALIAS, DirSucursalCConstants.ARG_ALIAS_TELIMINAR_DIRSUCURSALCTELIMINARPTHISDIRSUCURSALC);
        }
    }
}
