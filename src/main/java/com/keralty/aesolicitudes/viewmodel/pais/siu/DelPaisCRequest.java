package com.keralty.aesolicitudes.viewmodel.pais.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.PaisConstants;
import com.keralty.aesolicitudes.persistence.DireccionC;
import com.keralty.aesolicitudes.persistence.oid.DireccionCOid;
import com.keralty.aesolicitudes.persistence.oid.PaisOid;
import com.keralty.aesolicitudes.persistence.Pais;

public class DelPaisCRequest {

    @JsonProperty("p_thispais_oid")
    private PaisOid paisDelPaisCpthisPais;
    
    @JsonIgnore
    private Pais paisDelPaisCpthisPaisInstance;

    @JsonProperty("p_evcdireccionc_oid")
    private DireccionCOid paisDelPaisCpevcDireccionC;
    
    @JsonIgnore
    private DireccionC paisDelPaisCpevcDireccionCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkPaisDelPaisCpthisPais();
        checkPaisDelPaisCpevcDireccionC();
    }

    @JsonIgnore
    public PaisOid getPaisDelPaisCpthisPais() {
        return this.paisDelPaisCpthisPais;
    }
    
    public void setPaisDelPaisCpthisPais(PaisOid paisDelPaisCpthisPais) {
        this.paisDelPaisCpthisPais = paisDelPaisCpthisPais;
    }

    @JsonIgnore
    public Pais getPaisDelPaisCpthisPaisInstance() {
        return this.paisDelPaisCpthisPaisInstance;
    }
    
    public void setPaisDelPaisCpthisPaisInstance(Pais paisDelPaisCpthisPais) {
        this.paisDelPaisCpthisPaisInstance = paisDelPaisCpthisPais;
        this.paisDelPaisCpthisPais = paisDelPaisCpthisPais != null ? paisDelPaisCpthisPais.getOid() : null;
    }

    private void checkPaisDelPaisCpthisPais() throws NotNullArgumentException {
        if(this.getPaisDelPaisCpthisPaisInstance() == null || this.getPaisDelPaisCpthisPaisInstance().isNull()) {
            throw new NotNullArgumentException(PaisConstants.SERV_ID_DELPAISC, PaisConstants.CLASS_ID, PaisConstants.ARG_ID_DELPAISC_PAISDELPAISCPTHISPAIS, PaisConstants.SERV_ALIAS_DELPAISC, PaisConstants.CLASS_ALIAS, PaisConstants.ARG_ALIAS_DELPAISC_PAISDELPAISCPTHISPAIS);
        }
    }

    @JsonIgnore
    public DireccionCOid getPaisDelPaisCpevcDireccionC() {
        return this.paisDelPaisCpevcDireccionC;
    }
    
    public void setPaisDelPaisCpevcDireccionC(DireccionCOid paisDelPaisCpevcDireccionC) {
        this.paisDelPaisCpevcDireccionC = paisDelPaisCpevcDireccionC;
    }

    @JsonIgnore
    public DireccionC getPaisDelPaisCpevcDireccionCInstance() {
        return this.paisDelPaisCpevcDireccionCInstance;
    }
    
    public void setPaisDelPaisCpevcDireccionCInstance(DireccionC paisDelPaisCpevcDireccionC) {
        this.paisDelPaisCpevcDireccionCInstance = paisDelPaisCpevcDireccionC;
        this.paisDelPaisCpevcDireccionC = paisDelPaisCpevcDireccionC != null ? paisDelPaisCpevcDireccionC.getOid() : null;
    }

    private void checkPaisDelPaisCpevcDireccionC() throws NotNullArgumentException {
        if(this.getPaisDelPaisCpevcDireccionCInstance() == null || this.getPaisDelPaisCpevcDireccionCInstance().isNull()) {
            throw new NotNullArgumentException(PaisConstants.SERV_ID_DELPAISC, PaisConstants.CLASS_ID, PaisConstants.ARG_ID_DELPAISC_PAISDELPAISCPEVCDIRECCIONC, PaisConstants.SERV_ALIAS_DELPAISC, PaisConstants.CLASS_ALIAS, PaisConstants.ARG_ALIAS_DELPAISC_PAISDELPAISCPEVCDIRECCIONC);
        }
    }
}
