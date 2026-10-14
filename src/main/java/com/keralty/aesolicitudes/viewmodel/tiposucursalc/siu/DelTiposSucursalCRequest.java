package com.keralty.aesolicitudes.viewmodel.tiposucursalc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.TipoSucursalCConstants;
import com.keralty.aesolicitudes.persistence.DirSucursalC;
import com.keralty.aesolicitudes.persistence.oid.DirSucursalCOid;
import com.keralty.aesolicitudes.persistence.oid.TipoSucursalCOid;
import com.keralty.aesolicitudes.persistence.TipoSucursalC;

public class DelTiposSucursalCRequest {

    @JsonProperty("p_thistiposucursalc_oid")
    private TipoSucursalCOid tipoSucursalCDelTiposSucursalCpthisTipoSucursalC;
    
    @JsonIgnore
    private TipoSucursalC tipoSucursalCDelTiposSucursalCpthisTipoSucursalCInstance;

    @JsonProperty("p_evcdirsucursalc_oid")
    private DirSucursalCOid tipoSucursalCDelTiposSucursalCpevcDirSucursalC;
    
    @JsonIgnore
    private DirSucursalC tipoSucursalCDelTiposSucursalCpevcDirSucursalCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkTipoSucursalCDelTiposSucursalCpthisTipoSucursalC();
        checkTipoSucursalCDelTiposSucursalCpevcDirSucursalC();
    }

    @JsonIgnore
    public TipoSucursalCOid getTipoSucursalCDelTiposSucursalCpthisTipoSucursalC() {
        return this.tipoSucursalCDelTiposSucursalCpthisTipoSucursalC;
    }
    
    public void setTipoSucursalCDelTiposSucursalCpthisTipoSucursalC(TipoSucursalCOid tipoSucursalCDelTiposSucursalCpthisTipoSucursalC) {
        this.tipoSucursalCDelTiposSucursalCpthisTipoSucursalC = tipoSucursalCDelTiposSucursalCpthisTipoSucursalC;
    }

    @JsonIgnore
    public TipoSucursalC getTipoSucursalCDelTiposSucursalCpthisTipoSucursalCInstance() {
        return this.tipoSucursalCDelTiposSucursalCpthisTipoSucursalCInstance;
    }
    
    public void setTipoSucursalCDelTiposSucursalCpthisTipoSucursalCInstance(TipoSucursalC tipoSucursalCDelTiposSucursalCpthisTipoSucursalC) {
        this.tipoSucursalCDelTiposSucursalCpthisTipoSucursalCInstance = tipoSucursalCDelTiposSucursalCpthisTipoSucursalC;
        this.tipoSucursalCDelTiposSucursalCpthisTipoSucursalC = tipoSucursalCDelTiposSucursalCpthisTipoSucursalC != null ? tipoSucursalCDelTiposSucursalCpthisTipoSucursalC.getOid() : null;
    }

    private void checkTipoSucursalCDelTiposSucursalCpthisTipoSucursalC() throws NotNullArgumentException {
        if(this.getTipoSucursalCDelTiposSucursalCpthisTipoSucursalCInstance() == null || this.getTipoSucursalCDelTiposSucursalCpthisTipoSucursalCInstance().isNull()) {
            throw new NotNullArgumentException(TipoSucursalCConstants.SERV_ID_DELTIPOSSUCURSALC, TipoSucursalCConstants.CLASS_ID, TipoSucursalCConstants.ARG_ID_DELTIPOSSUCURSALC_TIPOSUCURSALCDELTIPOSSUCURSALCPTHISTIPOSUCURSALC, TipoSucursalCConstants.SERV_ALIAS_DELTIPOSSUCURSALC, TipoSucursalCConstants.CLASS_ALIAS, TipoSucursalCConstants.ARG_ALIAS_DELTIPOSSUCURSALC_TIPOSUCURSALCDELTIPOSSUCURSALCPTHISTIPOSUCURSALC);
        }
    }

    @JsonIgnore
    public DirSucursalCOid getTipoSucursalCDelTiposSucursalCpevcDirSucursalC() {
        return this.tipoSucursalCDelTiposSucursalCpevcDirSucursalC;
    }
    
    public void setTipoSucursalCDelTiposSucursalCpevcDirSucursalC(DirSucursalCOid tipoSucursalCDelTiposSucursalCpevcDirSucursalC) {
        this.tipoSucursalCDelTiposSucursalCpevcDirSucursalC = tipoSucursalCDelTiposSucursalCpevcDirSucursalC;
    }

    @JsonIgnore
    public DirSucursalC getTipoSucursalCDelTiposSucursalCpevcDirSucursalCInstance() {
        return this.tipoSucursalCDelTiposSucursalCpevcDirSucursalCInstance;
    }
    
    public void setTipoSucursalCDelTiposSucursalCpevcDirSucursalCInstance(DirSucursalC tipoSucursalCDelTiposSucursalCpevcDirSucursalC) {
        this.tipoSucursalCDelTiposSucursalCpevcDirSucursalCInstance = tipoSucursalCDelTiposSucursalCpevcDirSucursalC;
        this.tipoSucursalCDelTiposSucursalCpevcDirSucursalC = tipoSucursalCDelTiposSucursalCpevcDirSucursalC != null ? tipoSucursalCDelTiposSucursalCpevcDirSucursalC.getOid() : null;
    }

    private void checkTipoSucursalCDelTiposSucursalCpevcDirSucursalC() throws NotNullArgumentException {
        if(this.getTipoSucursalCDelTiposSucursalCpevcDirSucursalCInstance() == null || this.getTipoSucursalCDelTiposSucursalCpevcDirSucursalCInstance().isNull()) {
            throw new NotNullArgumentException(TipoSucursalCConstants.SERV_ID_DELTIPOSSUCURSALC, TipoSucursalCConstants.CLASS_ID, TipoSucursalCConstants.ARG_ID_DELTIPOSSUCURSALC_TIPOSUCURSALCDELTIPOSSUCURSALCPEVCDIRSUCURSALC, TipoSucursalCConstants.SERV_ALIAS_DELTIPOSSUCURSALC, TipoSucursalCConstants.CLASS_ALIAS, TipoSucursalCConstants.ARG_ALIAS_DELTIPOSSUCURSALC_TIPOSUCURSALCDELTIPOSSUCURSALCPEVCDIRSUCURSALC);
        }
    }
}
