package com.keralty.aesolicitudes.viewmodel.pais.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.PaisConstants;
import com.keralty.aesolicitudes.persistence.DirSucursalC;
import com.keralty.aesolicitudes.persistence.oid.DirSucursalCOid;
import com.keralty.aesolicitudes.persistence.oid.PaisOid;
import com.keralty.aesolicitudes.persistence.Pais;

public class InsPaisDirSucursalCRequest {

    @JsonProperty("p_thispais_oid")
    private PaisOid paisInsPaisDirSucursalCpthisPais;
    
    @JsonIgnore
    private Pais paisInsPaisDirSucursalCpthisPaisInstance;

    @JsonProperty("p_evcdirsucursalc_oid")
    private DirSucursalCOid paisInsPaisDirSucursalCpevcDirSucursalC;
    
    @JsonIgnore
    private DirSucursalC paisInsPaisDirSucursalCpevcDirSucursalCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkPaisInsPaisDirSucursalCpthisPais();
        checkPaisInsPaisDirSucursalCpevcDirSucursalC();
    }

    @JsonIgnore
    public PaisOid getPaisInsPaisDirSucursalCpthisPais() {
        return this.paisInsPaisDirSucursalCpthisPais;
    }
    
    public void setPaisInsPaisDirSucursalCpthisPais(PaisOid paisInsPaisDirSucursalCpthisPais) {
        this.paisInsPaisDirSucursalCpthisPais = paisInsPaisDirSucursalCpthisPais;
    }

    @JsonIgnore
    public Pais getPaisInsPaisDirSucursalCpthisPaisInstance() {
        return this.paisInsPaisDirSucursalCpthisPaisInstance;
    }
    
    public void setPaisInsPaisDirSucursalCpthisPaisInstance(Pais paisInsPaisDirSucursalCpthisPais) {
        this.paisInsPaisDirSucursalCpthisPaisInstance = paisInsPaisDirSucursalCpthisPais;
        this.paisInsPaisDirSucursalCpthisPais = paisInsPaisDirSucursalCpthisPais != null ? paisInsPaisDirSucursalCpthisPais.getOid() : null;
    }

    private void checkPaisInsPaisDirSucursalCpthisPais() throws NotNullArgumentException {
        if(this.getPaisInsPaisDirSucursalCpthisPaisInstance() == null || this.getPaisInsPaisDirSucursalCpthisPaisInstance().isNull()) {
            throw new NotNullArgumentException(PaisConstants.SERV_ID_INSPAISDIRSUCURSALC, PaisConstants.CLASS_ID, PaisConstants.ARG_ID_INSPAISDIRSUCURSALC_PAISINSPAISDIRSUCURSALCPTHISPAIS, PaisConstants.SERV_ALIAS_INSPAISDIRSUCURSALC, PaisConstants.CLASS_ALIAS, PaisConstants.ARG_ALIAS_INSPAISDIRSUCURSALC_PAISINSPAISDIRSUCURSALCPTHISPAIS);
        }
    }

    @JsonIgnore
    public DirSucursalCOid getPaisInsPaisDirSucursalCpevcDirSucursalC() {
        return this.paisInsPaisDirSucursalCpevcDirSucursalC;
    }
    
    public void setPaisInsPaisDirSucursalCpevcDirSucursalC(DirSucursalCOid paisInsPaisDirSucursalCpevcDirSucursalC) {
        this.paisInsPaisDirSucursalCpevcDirSucursalC = paisInsPaisDirSucursalCpevcDirSucursalC;
    }

    @JsonIgnore
    public DirSucursalC getPaisInsPaisDirSucursalCpevcDirSucursalCInstance() {
        return this.paisInsPaisDirSucursalCpevcDirSucursalCInstance;
    }
    
    public void setPaisInsPaisDirSucursalCpevcDirSucursalCInstance(DirSucursalC paisInsPaisDirSucursalCpevcDirSucursalC) {
        this.paisInsPaisDirSucursalCpevcDirSucursalCInstance = paisInsPaisDirSucursalCpevcDirSucursalC;
        this.paisInsPaisDirSucursalCpevcDirSucursalC = paisInsPaisDirSucursalCpevcDirSucursalC != null ? paisInsPaisDirSucursalCpevcDirSucursalC.getOid() : null;
    }

    private void checkPaisInsPaisDirSucursalCpevcDirSucursalC() throws NotNullArgumentException {
        if(this.getPaisInsPaisDirSucursalCpevcDirSucursalCInstance() == null || this.getPaisInsPaisDirSucursalCpevcDirSucursalCInstance().isNull()) {
            throw new NotNullArgumentException(PaisConstants.SERV_ID_INSPAISDIRSUCURSALC, PaisConstants.CLASS_ID, PaisConstants.ARG_ID_INSPAISDIRSUCURSALC_PAISINSPAISDIRSUCURSALCPEVCDIRSUCURSALC, PaisConstants.SERV_ALIAS_INSPAISDIRSUCURSALC, PaisConstants.CLASS_ALIAS, PaisConstants.ARG_ALIAS_INSPAISDIRSUCURSALC_PAISINSPAISDIRSUCURSALCPEVCDIRSUCURSALC);
        }
    }
}
