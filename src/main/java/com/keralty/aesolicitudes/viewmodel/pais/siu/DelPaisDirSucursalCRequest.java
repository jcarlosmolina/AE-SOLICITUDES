package com.keralty.aesolicitudes.viewmodel.pais.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.PaisConstants;
import com.keralty.aesolicitudes.persistence.DirSucursalC;
import com.keralty.aesolicitudes.persistence.oid.DirSucursalCOid;
import com.keralty.aesolicitudes.persistence.oid.PaisOid;
import com.keralty.aesolicitudes.persistence.Pais;

public class DelPaisDirSucursalCRequest {

    @JsonProperty("p_thispais_oid")
    private PaisOid paisDelPaisDirSucursalCpthisPais;
    
    @JsonIgnore
    private Pais paisDelPaisDirSucursalCpthisPaisInstance;

    @JsonProperty("p_evcdirsucursalc_oid")
    private DirSucursalCOid paisDelPaisDirSucursalCpevcDirSucursalC;
    
    @JsonIgnore
    private DirSucursalC paisDelPaisDirSucursalCpevcDirSucursalCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkPaisDelPaisDirSucursalCpthisPais();
        checkPaisDelPaisDirSucursalCpevcDirSucursalC();
    }

    @JsonIgnore
    public PaisOid getPaisDelPaisDirSucursalCpthisPais() {
        return this.paisDelPaisDirSucursalCpthisPais;
    }
    
    public void setPaisDelPaisDirSucursalCpthisPais(PaisOid paisDelPaisDirSucursalCpthisPais) {
        this.paisDelPaisDirSucursalCpthisPais = paisDelPaisDirSucursalCpthisPais;
    }

    @JsonIgnore
    public Pais getPaisDelPaisDirSucursalCpthisPaisInstance() {
        return this.paisDelPaisDirSucursalCpthisPaisInstance;
    }
    
    public void setPaisDelPaisDirSucursalCpthisPaisInstance(Pais paisDelPaisDirSucursalCpthisPais) {
        this.paisDelPaisDirSucursalCpthisPaisInstance = paisDelPaisDirSucursalCpthisPais;
        this.paisDelPaisDirSucursalCpthisPais = paisDelPaisDirSucursalCpthisPais != null ? paisDelPaisDirSucursalCpthisPais.getOid() : null;
    }

    private void checkPaisDelPaisDirSucursalCpthisPais() throws NotNullArgumentException {
        if(this.getPaisDelPaisDirSucursalCpthisPaisInstance() == null || this.getPaisDelPaisDirSucursalCpthisPaisInstance().isNull()) {
            throw new NotNullArgumentException(PaisConstants.SERV_ID_DELPAISDIRSUCURSALC, PaisConstants.CLASS_ID, PaisConstants.ARG_ID_DELPAISDIRSUCURSALC_PAISDELPAISDIRSUCURSALCPTHISPAIS, PaisConstants.SERV_ALIAS_DELPAISDIRSUCURSALC, PaisConstants.CLASS_ALIAS, PaisConstants.ARG_ALIAS_DELPAISDIRSUCURSALC_PAISDELPAISDIRSUCURSALCPTHISPAIS);
        }
    }

    @JsonIgnore
    public DirSucursalCOid getPaisDelPaisDirSucursalCpevcDirSucursalC() {
        return this.paisDelPaisDirSucursalCpevcDirSucursalC;
    }
    
    public void setPaisDelPaisDirSucursalCpevcDirSucursalC(DirSucursalCOid paisDelPaisDirSucursalCpevcDirSucursalC) {
        this.paisDelPaisDirSucursalCpevcDirSucursalC = paisDelPaisDirSucursalCpevcDirSucursalC;
    }

    @JsonIgnore
    public DirSucursalC getPaisDelPaisDirSucursalCpevcDirSucursalCInstance() {
        return this.paisDelPaisDirSucursalCpevcDirSucursalCInstance;
    }
    
    public void setPaisDelPaisDirSucursalCpevcDirSucursalCInstance(DirSucursalC paisDelPaisDirSucursalCpevcDirSucursalC) {
        this.paisDelPaisDirSucursalCpevcDirSucursalCInstance = paisDelPaisDirSucursalCpevcDirSucursalC;
        this.paisDelPaisDirSucursalCpevcDirSucursalC = paisDelPaisDirSucursalCpevcDirSucursalC != null ? paisDelPaisDirSucursalCpevcDirSucursalC.getOid() : null;
    }

    private void checkPaisDelPaisDirSucursalCpevcDirSucursalC() throws NotNullArgumentException {
        if(this.getPaisDelPaisDirSucursalCpevcDirSucursalCInstance() == null || this.getPaisDelPaisDirSucursalCpevcDirSucursalCInstance().isNull()) {
            throw new NotNullArgumentException(PaisConstants.SERV_ID_DELPAISDIRSUCURSALC, PaisConstants.CLASS_ID, PaisConstants.ARG_ID_DELPAISDIRSUCURSALC_PAISDELPAISDIRSUCURSALCPEVCDIRSUCURSALC, PaisConstants.SERV_ALIAS_DELPAISDIRSUCURSALC, PaisConstants.CLASS_ALIAS, PaisConstants.ARG_ALIAS_DELPAISDIRSUCURSALC_PAISDELPAISDIRSUCURSALCPEVCDIRSUCURSALC);
        }
    }
}
