package com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DirSucursalCConstants;
import com.keralty.aesolicitudes.persistence.DirSucursalC;
import com.keralty.aesolicitudes.persistence.oid.DirSucursalCOid;
import com.keralty.aesolicitudes.persistence.oid.TipoSucursalCOid;
import com.keralty.aesolicitudes.persistence.TipoSucursalC;

public class InsTiposSucursalCRequest {

    @JsonProperty("p_thisdirsucursalc_oid")
    private DirSucursalCOid dirSucursalCInsTiposSucursalCpthisDirSucursalC;
    
    @JsonIgnore
    private DirSucursalC dirSucursalCInsTiposSucursalCpthisDirSucursalCInstance;

    @JsonProperty("p_evctiposucursalc_oid")
    private TipoSucursalCOid dirSucursalCInsTiposSucursalCpevcTipoSucursalC;
    
    @JsonIgnore
    private TipoSucursalC dirSucursalCInsTiposSucursalCpevcTipoSucursalCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkDirSucursalCInsTiposSucursalCpthisDirSucursalC();
        checkDirSucursalCInsTiposSucursalCpevcTipoSucursalC();
    }

    @JsonIgnore
    public DirSucursalCOid getDirSucursalCInsTiposSucursalCpthisDirSucursalC() {
        return this.dirSucursalCInsTiposSucursalCpthisDirSucursalC;
    }
    
    public void setDirSucursalCInsTiposSucursalCpthisDirSucursalC(DirSucursalCOid dirSucursalCInsTiposSucursalCpthisDirSucursalC) {
        this.dirSucursalCInsTiposSucursalCpthisDirSucursalC = dirSucursalCInsTiposSucursalCpthisDirSucursalC;
    }

    @JsonIgnore
    public DirSucursalC getDirSucursalCInsTiposSucursalCpthisDirSucursalCInstance() {
        return this.dirSucursalCInsTiposSucursalCpthisDirSucursalCInstance;
    }
    
    public void setDirSucursalCInsTiposSucursalCpthisDirSucursalCInstance(DirSucursalC dirSucursalCInsTiposSucursalCpthisDirSucursalC) {
        this.dirSucursalCInsTiposSucursalCpthisDirSucursalCInstance = dirSucursalCInsTiposSucursalCpthisDirSucursalC;
        this.dirSucursalCInsTiposSucursalCpthisDirSucursalC = dirSucursalCInsTiposSucursalCpthisDirSucursalC != null ? dirSucursalCInsTiposSucursalCpthisDirSucursalC.getOid() : null;
    }

    private void checkDirSucursalCInsTiposSucursalCpthisDirSucursalC() throws NotNullArgumentException {
        if(this.getDirSucursalCInsTiposSucursalCpthisDirSucursalCInstance() == null || this.getDirSucursalCInsTiposSucursalCpthisDirSucursalCInstance().isNull()) {
            throw new NotNullArgumentException(DirSucursalCConstants.SERV_ID_INSTIPOSSUCURSALC, DirSucursalCConstants.CLASS_ID, DirSucursalCConstants.ARG_ID_INSTIPOSSUCURSALC_DIRSUCURSALCINSTIPOSSUCURSALCPTHISDIRSUCURSALC, DirSucursalCConstants.SERV_ALIAS_INSTIPOSSUCURSALC, DirSucursalCConstants.CLASS_ALIAS, DirSucursalCConstants.ARG_ALIAS_INSTIPOSSUCURSALC_DIRSUCURSALCINSTIPOSSUCURSALCPTHISDIRSUCURSALC);
        }
    }

    @JsonIgnore
    public TipoSucursalCOid getDirSucursalCInsTiposSucursalCpevcTipoSucursalC() {
        return this.dirSucursalCInsTiposSucursalCpevcTipoSucursalC;
    }
    
    public void setDirSucursalCInsTiposSucursalCpevcTipoSucursalC(TipoSucursalCOid dirSucursalCInsTiposSucursalCpevcTipoSucursalC) {
        this.dirSucursalCInsTiposSucursalCpevcTipoSucursalC = dirSucursalCInsTiposSucursalCpevcTipoSucursalC;
    }

    @JsonIgnore
    public TipoSucursalC getDirSucursalCInsTiposSucursalCpevcTipoSucursalCInstance() {
        return this.dirSucursalCInsTiposSucursalCpevcTipoSucursalCInstance;
    }
    
    public void setDirSucursalCInsTiposSucursalCpevcTipoSucursalCInstance(TipoSucursalC dirSucursalCInsTiposSucursalCpevcTipoSucursalC) {
        this.dirSucursalCInsTiposSucursalCpevcTipoSucursalCInstance = dirSucursalCInsTiposSucursalCpevcTipoSucursalC;
        this.dirSucursalCInsTiposSucursalCpevcTipoSucursalC = dirSucursalCInsTiposSucursalCpevcTipoSucursalC != null ? dirSucursalCInsTiposSucursalCpevcTipoSucursalC.getOid() : null;
    }

    private void checkDirSucursalCInsTiposSucursalCpevcTipoSucursalC() throws NotNullArgumentException {
        if(this.getDirSucursalCInsTiposSucursalCpevcTipoSucursalCInstance() == null || this.getDirSucursalCInsTiposSucursalCpevcTipoSucursalCInstance().isNull()) {
            throw new NotNullArgumentException(DirSucursalCConstants.SERV_ID_INSTIPOSSUCURSALC, DirSucursalCConstants.CLASS_ID, DirSucursalCConstants.ARG_ID_INSTIPOSSUCURSALC_DIRSUCURSALCINSTIPOSSUCURSALCPEVCTIPOSUCURSALC, DirSucursalCConstants.SERV_ALIAS_INSTIPOSSUCURSALC, DirSucursalCConstants.CLASS_ALIAS, DirSucursalCConstants.ARG_ALIAS_INSTIPOSSUCURSALC_DIRSUCURSALCINSTIPOSSUCURSALCPEVCTIPOSUCURSALC);
        }
    }
}
