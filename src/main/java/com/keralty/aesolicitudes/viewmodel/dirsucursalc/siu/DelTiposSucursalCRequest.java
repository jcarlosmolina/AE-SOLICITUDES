package com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DirSucursalCConstants;
import com.keralty.aesolicitudes.persistence.DirSucursalC;
import com.keralty.aesolicitudes.persistence.oid.DirSucursalCOid;
import com.keralty.aesolicitudes.persistence.oid.TipoSucursalCOid;
import com.keralty.aesolicitudes.persistence.TipoSucursalC;

public class DelTiposSucursalCRequest {

    @JsonProperty("p_thisdirsucursalc_oid")
    private DirSucursalCOid dirSucursalCDelTiposSucursalCpthisDirSucursalC;
    
    @JsonIgnore
    private DirSucursalC dirSucursalCDelTiposSucursalCpthisDirSucursalCInstance;

    @JsonProperty("p_evctiposucursalc_oid")
    private TipoSucursalCOid dirSucursalCDelTiposSucursalCpevcTipoSucursalC;
    
    @JsonIgnore
    private TipoSucursalC dirSucursalCDelTiposSucursalCpevcTipoSucursalCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkDirSucursalCDelTiposSucursalCpthisDirSucursalC();
        checkDirSucursalCDelTiposSucursalCpevcTipoSucursalC();
    }

    @JsonIgnore
    public DirSucursalCOid getDirSucursalCDelTiposSucursalCpthisDirSucursalC() {
        return this.dirSucursalCDelTiposSucursalCpthisDirSucursalC;
    }
    
    public void setDirSucursalCDelTiposSucursalCpthisDirSucursalC(DirSucursalCOid dirSucursalCDelTiposSucursalCpthisDirSucursalC) {
        this.dirSucursalCDelTiposSucursalCpthisDirSucursalC = dirSucursalCDelTiposSucursalCpthisDirSucursalC;
    }

    @JsonIgnore
    public DirSucursalC getDirSucursalCDelTiposSucursalCpthisDirSucursalCInstance() {
        return this.dirSucursalCDelTiposSucursalCpthisDirSucursalCInstance;
    }
    
    public void setDirSucursalCDelTiposSucursalCpthisDirSucursalCInstance(DirSucursalC dirSucursalCDelTiposSucursalCpthisDirSucursalC) {
        this.dirSucursalCDelTiposSucursalCpthisDirSucursalCInstance = dirSucursalCDelTiposSucursalCpthisDirSucursalC;
        this.dirSucursalCDelTiposSucursalCpthisDirSucursalC = dirSucursalCDelTiposSucursalCpthisDirSucursalC != null ? dirSucursalCDelTiposSucursalCpthisDirSucursalC.getOid() : null;
    }

    private void checkDirSucursalCDelTiposSucursalCpthisDirSucursalC() throws NotNullArgumentException {
        if(this.getDirSucursalCDelTiposSucursalCpthisDirSucursalCInstance() == null || this.getDirSucursalCDelTiposSucursalCpthisDirSucursalCInstance().isNull()) {
            throw new NotNullArgumentException(DirSucursalCConstants.SERV_ID_DELTIPOSSUCURSALC, DirSucursalCConstants.CLASS_ID, DirSucursalCConstants.ARG_ID_DELTIPOSSUCURSALC_DIRSUCURSALCDELTIPOSSUCURSALCPTHISDIRSUCURSALC, DirSucursalCConstants.SERV_ALIAS_DELTIPOSSUCURSALC, DirSucursalCConstants.CLASS_ALIAS, DirSucursalCConstants.ARG_ALIAS_DELTIPOSSUCURSALC_DIRSUCURSALCDELTIPOSSUCURSALCPTHISDIRSUCURSALC);
        }
    }

    @JsonIgnore
    public TipoSucursalCOid getDirSucursalCDelTiposSucursalCpevcTipoSucursalC() {
        return this.dirSucursalCDelTiposSucursalCpevcTipoSucursalC;
    }
    
    public void setDirSucursalCDelTiposSucursalCpevcTipoSucursalC(TipoSucursalCOid dirSucursalCDelTiposSucursalCpevcTipoSucursalC) {
        this.dirSucursalCDelTiposSucursalCpevcTipoSucursalC = dirSucursalCDelTiposSucursalCpevcTipoSucursalC;
    }

    @JsonIgnore
    public TipoSucursalC getDirSucursalCDelTiposSucursalCpevcTipoSucursalCInstance() {
        return this.dirSucursalCDelTiposSucursalCpevcTipoSucursalCInstance;
    }
    
    public void setDirSucursalCDelTiposSucursalCpevcTipoSucursalCInstance(TipoSucursalC dirSucursalCDelTiposSucursalCpevcTipoSucursalC) {
        this.dirSucursalCDelTiposSucursalCpevcTipoSucursalCInstance = dirSucursalCDelTiposSucursalCpevcTipoSucursalC;
        this.dirSucursalCDelTiposSucursalCpevcTipoSucursalC = dirSucursalCDelTiposSucursalCpevcTipoSucursalC != null ? dirSucursalCDelTiposSucursalCpevcTipoSucursalC.getOid() : null;
    }

    private void checkDirSucursalCDelTiposSucursalCpevcTipoSucursalC() throws NotNullArgumentException {
        if(this.getDirSucursalCDelTiposSucursalCpevcTipoSucursalCInstance() == null || this.getDirSucursalCDelTiposSucursalCpevcTipoSucursalCInstance().isNull()) {
            throw new NotNullArgumentException(DirSucursalCConstants.SERV_ID_DELTIPOSSUCURSALC, DirSucursalCConstants.CLASS_ID, DirSucursalCConstants.ARG_ID_DELTIPOSSUCURSALC_DIRSUCURSALCDELTIPOSSUCURSALCPEVCTIPOSUCURSALC, DirSucursalCConstants.SERV_ALIAS_DELTIPOSSUCURSALC, DirSucursalCConstants.CLASS_ALIAS, DirSucursalCConstants.ARG_ALIAS_DELTIPOSSUCURSALC_DIRSUCURSALCDELTIPOSSUCURSALCPEVCTIPOSUCURSALC);
        }
    }
}
