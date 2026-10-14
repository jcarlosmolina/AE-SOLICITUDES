package com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DirSucursalCConstants;
import com.keralty.aesolicitudes.persistence.DirSucursalC;
import com.keralty.aesolicitudes.persistence.oid.DirSucursalCOid;
import com.keralty.aesolicitudes.persistence.oid.PaisOid;
import com.keralty.aesolicitudes.persistence.Pais;

public class InsPaisDirSucursalCRequest {

    @JsonProperty("p_thisdirsucursalc_oid")
    private DirSucursalCOid dirSucursalCInsPaisDirSucursalCpthisDirSucursalC;
    
    @JsonIgnore
    private DirSucursalC dirSucursalCInsPaisDirSucursalCpthisDirSucursalCInstance;

    @JsonProperty("p_evcpais_oid")
    private PaisOid dirSucursalCInsPaisDirSucursalCpevcPais;
    
    @JsonIgnore
    private Pais dirSucursalCInsPaisDirSucursalCpevcPaisInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkDirSucursalCInsPaisDirSucursalCpthisDirSucursalC();
        checkDirSucursalCInsPaisDirSucursalCpevcPais();
    }

    @JsonIgnore
    public DirSucursalCOid getDirSucursalCInsPaisDirSucursalCpthisDirSucursalC() {
        return this.dirSucursalCInsPaisDirSucursalCpthisDirSucursalC;
    }
    
    public void setDirSucursalCInsPaisDirSucursalCpthisDirSucursalC(DirSucursalCOid dirSucursalCInsPaisDirSucursalCpthisDirSucursalC) {
        this.dirSucursalCInsPaisDirSucursalCpthisDirSucursalC = dirSucursalCInsPaisDirSucursalCpthisDirSucursalC;
    }

    @JsonIgnore
    public DirSucursalC getDirSucursalCInsPaisDirSucursalCpthisDirSucursalCInstance() {
        return this.dirSucursalCInsPaisDirSucursalCpthisDirSucursalCInstance;
    }
    
    public void setDirSucursalCInsPaisDirSucursalCpthisDirSucursalCInstance(DirSucursalC dirSucursalCInsPaisDirSucursalCpthisDirSucursalC) {
        this.dirSucursalCInsPaisDirSucursalCpthisDirSucursalCInstance = dirSucursalCInsPaisDirSucursalCpthisDirSucursalC;
        this.dirSucursalCInsPaisDirSucursalCpthisDirSucursalC = dirSucursalCInsPaisDirSucursalCpthisDirSucursalC != null ? dirSucursalCInsPaisDirSucursalCpthisDirSucursalC.getOid() : null;
    }

    private void checkDirSucursalCInsPaisDirSucursalCpthisDirSucursalC() throws NotNullArgumentException {
        if(this.getDirSucursalCInsPaisDirSucursalCpthisDirSucursalCInstance() == null || this.getDirSucursalCInsPaisDirSucursalCpthisDirSucursalCInstance().isNull()) {
            throw new NotNullArgumentException(DirSucursalCConstants.SERV_ID_INSPAISDIRSUCURSALC, DirSucursalCConstants.CLASS_ID, DirSucursalCConstants.ARG_ID_INSPAISDIRSUCURSALC_DIRSUCURSALCINSPAISDIRSUCURSALCPTHISDIRSUCURSALC, DirSucursalCConstants.SERV_ALIAS_INSPAISDIRSUCURSALC, DirSucursalCConstants.CLASS_ALIAS, DirSucursalCConstants.ARG_ALIAS_INSPAISDIRSUCURSALC_DIRSUCURSALCINSPAISDIRSUCURSALCPTHISDIRSUCURSALC);
        }
    }

    @JsonIgnore
    public PaisOid getDirSucursalCInsPaisDirSucursalCpevcPais() {
        return this.dirSucursalCInsPaisDirSucursalCpevcPais;
    }
    
    public void setDirSucursalCInsPaisDirSucursalCpevcPais(PaisOid dirSucursalCInsPaisDirSucursalCpevcPais) {
        this.dirSucursalCInsPaisDirSucursalCpevcPais = dirSucursalCInsPaisDirSucursalCpevcPais;
    }

    @JsonIgnore
    public Pais getDirSucursalCInsPaisDirSucursalCpevcPaisInstance() {
        return this.dirSucursalCInsPaisDirSucursalCpevcPaisInstance;
    }
    
    public void setDirSucursalCInsPaisDirSucursalCpevcPaisInstance(Pais dirSucursalCInsPaisDirSucursalCpevcPais) {
        this.dirSucursalCInsPaisDirSucursalCpevcPaisInstance = dirSucursalCInsPaisDirSucursalCpevcPais;
        this.dirSucursalCInsPaisDirSucursalCpevcPais = dirSucursalCInsPaisDirSucursalCpevcPais != null ? dirSucursalCInsPaisDirSucursalCpevcPais.getOid() : null;
    }

    private void checkDirSucursalCInsPaisDirSucursalCpevcPais() throws NotNullArgumentException {
        if(this.getDirSucursalCInsPaisDirSucursalCpevcPaisInstance() == null || this.getDirSucursalCInsPaisDirSucursalCpevcPaisInstance().isNull()) {
            throw new NotNullArgumentException(DirSucursalCConstants.SERV_ID_INSPAISDIRSUCURSALC, DirSucursalCConstants.CLASS_ID, DirSucursalCConstants.ARG_ID_INSPAISDIRSUCURSALC_DIRSUCURSALCINSPAISDIRSUCURSALCPEVCPAIS, DirSucursalCConstants.SERV_ALIAS_INSPAISDIRSUCURSALC, DirSucursalCConstants.CLASS_ALIAS, DirSucursalCConstants.ARG_ALIAS_INSPAISDIRSUCURSALC_DIRSUCURSALCINSPAISDIRSUCURSALCPEVCPAIS);
        }
    }
}
