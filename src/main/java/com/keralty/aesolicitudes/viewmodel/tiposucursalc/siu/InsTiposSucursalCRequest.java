package com.keralty.aesolicitudes.viewmodel.tiposucursalc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.TipoSucursalCConstants;
import com.keralty.aesolicitudes.persistence.DirSucursalC;
import com.keralty.aesolicitudes.persistence.oid.DirSucursalCOid;
import com.keralty.aesolicitudes.persistence.oid.TipoSucursalCOid;
import com.keralty.aesolicitudes.persistence.TipoSucursalC;

public class InsTiposSucursalCRequest {

    @JsonProperty("p_thistiposucursalc_oid")
    private TipoSucursalCOid tipoSucursalCInsTiposSucursalCpthisTipoSucursalC;
    
    @JsonIgnore
    private TipoSucursalC tipoSucursalCInsTiposSucursalCpthisTipoSucursalCInstance;

    @JsonProperty("p_evcdirsucursalc_oid")
    private DirSucursalCOid tipoSucursalCInsTiposSucursalCpevcDirSucursalC;
    
    @JsonIgnore
    private DirSucursalC tipoSucursalCInsTiposSucursalCpevcDirSucursalCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkTipoSucursalCInsTiposSucursalCpthisTipoSucursalC();
        checkTipoSucursalCInsTiposSucursalCpevcDirSucursalC();
    }

    @JsonIgnore
    public TipoSucursalCOid getTipoSucursalCInsTiposSucursalCpthisTipoSucursalC() {
        return this.tipoSucursalCInsTiposSucursalCpthisTipoSucursalC;
    }
    
    public void setTipoSucursalCInsTiposSucursalCpthisTipoSucursalC(TipoSucursalCOid tipoSucursalCInsTiposSucursalCpthisTipoSucursalC) {
        this.tipoSucursalCInsTiposSucursalCpthisTipoSucursalC = tipoSucursalCInsTiposSucursalCpthisTipoSucursalC;
    }

    @JsonIgnore
    public TipoSucursalC getTipoSucursalCInsTiposSucursalCpthisTipoSucursalCInstance() {
        return this.tipoSucursalCInsTiposSucursalCpthisTipoSucursalCInstance;
    }
    
    public void setTipoSucursalCInsTiposSucursalCpthisTipoSucursalCInstance(TipoSucursalC tipoSucursalCInsTiposSucursalCpthisTipoSucursalC) {
        this.tipoSucursalCInsTiposSucursalCpthisTipoSucursalCInstance = tipoSucursalCInsTiposSucursalCpthisTipoSucursalC;
        this.tipoSucursalCInsTiposSucursalCpthisTipoSucursalC = tipoSucursalCInsTiposSucursalCpthisTipoSucursalC != null ? tipoSucursalCInsTiposSucursalCpthisTipoSucursalC.getOid() : null;
    }

    private void checkTipoSucursalCInsTiposSucursalCpthisTipoSucursalC() throws NotNullArgumentException {
        if(this.getTipoSucursalCInsTiposSucursalCpthisTipoSucursalCInstance() == null || this.getTipoSucursalCInsTiposSucursalCpthisTipoSucursalCInstance().isNull()) {
            throw new NotNullArgumentException(TipoSucursalCConstants.SERV_ID_INSTIPOSSUCURSALC, TipoSucursalCConstants.CLASS_ID, TipoSucursalCConstants.ARG_ID_INSTIPOSSUCURSALC_TIPOSUCURSALCINSTIPOSSUCURSALCPTHISTIPOSUCURSALC, TipoSucursalCConstants.SERV_ALIAS_INSTIPOSSUCURSALC, TipoSucursalCConstants.CLASS_ALIAS, TipoSucursalCConstants.ARG_ALIAS_INSTIPOSSUCURSALC_TIPOSUCURSALCINSTIPOSSUCURSALCPTHISTIPOSUCURSALC);
        }
    }

    @JsonIgnore
    public DirSucursalCOid getTipoSucursalCInsTiposSucursalCpevcDirSucursalC() {
        return this.tipoSucursalCInsTiposSucursalCpevcDirSucursalC;
    }
    
    public void setTipoSucursalCInsTiposSucursalCpevcDirSucursalC(DirSucursalCOid tipoSucursalCInsTiposSucursalCpevcDirSucursalC) {
        this.tipoSucursalCInsTiposSucursalCpevcDirSucursalC = tipoSucursalCInsTiposSucursalCpevcDirSucursalC;
    }

    @JsonIgnore
    public DirSucursalC getTipoSucursalCInsTiposSucursalCpevcDirSucursalCInstance() {
        return this.tipoSucursalCInsTiposSucursalCpevcDirSucursalCInstance;
    }
    
    public void setTipoSucursalCInsTiposSucursalCpevcDirSucursalCInstance(DirSucursalC tipoSucursalCInsTiposSucursalCpevcDirSucursalC) {
        this.tipoSucursalCInsTiposSucursalCpevcDirSucursalCInstance = tipoSucursalCInsTiposSucursalCpevcDirSucursalC;
        this.tipoSucursalCInsTiposSucursalCpevcDirSucursalC = tipoSucursalCInsTiposSucursalCpevcDirSucursalC != null ? tipoSucursalCInsTiposSucursalCpevcDirSucursalC.getOid() : null;
    }

    private void checkTipoSucursalCInsTiposSucursalCpevcDirSucursalC() throws NotNullArgumentException {
        if(this.getTipoSucursalCInsTiposSucursalCpevcDirSucursalCInstance() == null || this.getTipoSucursalCInsTiposSucursalCpevcDirSucursalCInstance().isNull()) {
            throw new NotNullArgumentException(TipoSucursalCConstants.SERV_ID_INSTIPOSSUCURSALC, TipoSucursalCConstants.CLASS_ID, TipoSucursalCConstants.ARG_ID_INSTIPOSSUCURSALC_TIPOSUCURSALCINSTIPOSSUCURSALCPEVCDIRSUCURSALC, TipoSucursalCConstants.SERV_ALIAS_INSTIPOSSUCURSALC, TipoSucursalCConstants.CLASS_ALIAS, TipoSucursalCConstants.ARG_ALIAS_INSTIPOSSUCURSALC_TIPOSUCURSALCINSTIPOSSUCURSALCPEVCDIRSUCURSALC);
        }
    }
}
