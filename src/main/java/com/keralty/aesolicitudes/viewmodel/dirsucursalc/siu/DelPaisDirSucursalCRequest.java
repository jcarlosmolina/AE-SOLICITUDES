package com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DirSucursalCConstants;
import com.keralty.aesolicitudes.persistence.DirSucursalC;
import com.keralty.aesolicitudes.persistence.oid.DirSucursalCOid;
import com.keralty.aesolicitudes.persistence.oid.PaisOid;
import com.keralty.aesolicitudes.persistence.Pais;

public class DelPaisDirSucursalCRequest {

    @JsonProperty("p_thisdirsucursalc_oid")
    private DirSucursalCOid dirSucursalCDelPaisDirSucursalCpthisDirSucursalC;
    
    @JsonIgnore
    private DirSucursalC dirSucursalCDelPaisDirSucursalCpthisDirSucursalCInstance;

    @JsonProperty("p_evcpais_oid")
    private PaisOid dirSucursalCDelPaisDirSucursalCpevcPais;
    
    @JsonIgnore
    private Pais dirSucursalCDelPaisDirSucursalCpevcPaisInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkDirSucursalCDelPaisDirSucursalCpthisDirSucursalC();
        checkDirSucursalCDelPaisDirSucursalCpevcPais();
    }

    @JsonIgnore
    public DirSucursalCOid getDirSucursalCDelPaisDirSucursalCpthisDirSucursalC() {
        return this.dirSucursalCDelPaisDirSucursalCpthisDirSucursalC;
    }
    
    public void setDirSucursalCDelPaisDirSucursalCpthisDirSucursalC(DirSucursalCOid dirSucursalCDelPaisDirSucursalCpthisDirSucursalC) {
        this.dirSucursalCDelPaisDirSucursalCpthisDirSucursalC = dirSucursalCDelPaisDirSucursalCpthisDirSucursalC;
    }

    @JsonIgnore
    public DirSucursalC getDirSucursalCDelPaisDirSucursalCpthisDirSucursalCInstance() {
        return this.dirSucursalCDelPaisDirSucursalCpthisDirSucursalCInstance;
    }
    
    public void setDirSucursalCDelPaisDirSucursalCpthisDirSucursalCInstance(DirSucursalC dirSucursalCDelPaisDirSucursalCpthisDirSucursalC) {
        this.dirSucursalCDelPaisDirSucursalCpthisDirSucursalCInstance = dirSucursalCDelPaisDirSucursalCpthisDirSucursalC;
        this.dirSucursalCDelPaisDirSucursalCpthisDirSucursalC = dirSucursalCDelPaisDirSucursalCpthisDirSucursalC != null ? dirSucursalCDelPaisDirSucursalCpthisDirSucursalC.getOid() : null;
    }

    private void checkDirSucursalCDelPaisDirSucursalCpthisDirSucursalC() throws NotNullArgumentException {
        if(this.getDirSucursalCDelPaisDirSucursalCpthisDirSucursalCInstance() == null || this.getDirSucursalCDelPaisDirSucursalCpthisDirSucursalCInstance().isNull()) {
            throw new NotNullArgumentException(DirSucursalCConstants.SERV_ID_DELPAISDIRSUCURSALC, DirSucursalCConstants.CLASS_ID, DirSucursalCConstants.ARG_ID_DELPAISDIRSUCURSALC_DIRSUCURSALCDELPAISDIRSUCURSALCPTHISDIRSUCURSALC, DirSucursalCConstants.SERV_ALIAS_DELPAISDIRSUCURSALC, DirSucursalCConstants.CLASS_ALIAS, DirSucursalCConstants.ARG_ALIAS_DELPAISDIRSUCURSALC_DIRSUCURSALCDELPAISDIRSUCURSALCPTHISDIRSUCURSALC);
        }
    }

    @JsonIgnore
    public PaisOid getDirSucursalCDelPaisDirSucursalCpevcPais() {
        return this.dirSucursalCDelPaisDirSucursalCpevcPais;
    }
    
    public void setDirSucursalCDelPaisDirSucursalCpevcPais(PaisOid dirSucursalCDelPaisDirSucursalCpevcPais) {
        this.dirSucursalCDelPaisDirSucursalCpevcPais = dirSucursalCDelPaisDirSucursalCpevcPais;
    }

    @JsonIgnore
    public Pais getDirSucursalCDelPaisDirSucursalCpevcPaisInstance() {
        return this.dirSucursalCDelPaisDirSucursalCpevcPaisInstance;
    }
    
    public void setDirSucursalCDelPaisDirSucursalCpevcPaisInstance(Pais dirSucursalCDelPaisDirSucursalCpevcPais) {
        this.dirSucursalCDelPaisDirSucursalCpevcPaisInstance = dirSucursalCDelPaisDirSucursalCpevcPais;
        this.dirSucursalCDelPaisDirSucursalCpevcPais = dirSucursalCDelPaisDirSucursalCpevcPais != null ? dirSucursalCDelPaisDirSucursalCpevcPais.getOid() : null;
    }

    private void checkDirSucursalCDelPaisDirSucursalCpevcPais() throws NotNullArgumentException {
        if(this.getDirSucursalCDelPaisDirSucursalCpevcPaisInstance() == null || this.getDirSucursalCDelPaisDirSucursalCpevcPaisInstance().isNull()) {
            throw new NotNullArgumentException(DirSucursalCConstants.SERV_ID_DELPAISDIRSUCURSALC, DirSucursalCConstants.CLASS_ID, DirSucursalCConstants.ARG_ID_DELPAISDIRSUCURSALC_DIRSUCURSALCDELPAISDIRSUCURSALCPEVCPAIS, DirSucursalCConstants.SERV_ALIAS_DELPAISDIRSUCURSALC, DirSucursalCConstants.CLASS_ALIAS, DirSucursalCConstants.ARG_ALIAS_DELPAISDIRSUCURSALC_DIRSUCURSALCDELPAISDIRSUCURSALCPEVCPAIS);
        }
    }
}
