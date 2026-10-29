package com.keralty.aesolicitudes.viewmodel.pais.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.PaisConstants;
import com.keralty.aesolicitudes.persistence.DireccionC;
import com.keralty.aesolicitudes.persistence.oid.DireccionCOid;
import com.keralty.aesolicitudes.persistence.oid.PaisOid;
import com.keralty.aesolicitudes.persistence.Pais;

public class InsPaisCRequest {

    @JsonProperty("p_thispais_oid")
    private PaisOid paisInsPaisCpthisPais;
    
    @JsonIgnore
    private Pais paisInsPaisCpthisPaisInstance;

    @JsonProperty("p_evcdireccionc_oid")
    private DireccionCOid paisInsPaisCpevcDireccionC;
    
    @JsonIgnore
    private DireccionC paisInsPaisCpevcDireccionCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkPaisInsPaisCpthisPais();
        checkPaisInsPaisCpevcDireccionC();
    }

    @JsonIgnore
    public PaisOid getPaisInsPaisCpthisPais() {
        return this.paisInsPaisCpthisPais;
    }
    
    public void setPaisInsPaisCpthisPais(PaisOid paisInsPaisCpthisPais) {
        this.paisInsPaisCpthisPais = paisInsPaisCpthisPais;
    }

    @JsonIgnore
    public Pais getPaisInsPaisCpthisPaisInstance() {
        return this.paisInsPaisCpthisPaisInstance;
    }
    
    public void setPaisInsPaisCpthisPaisInstance(Pais paisInsPaisCpthisPais) {
        this.paisInsPaisCpthisPaisInstance = paisInsPaisCpthisPais;
        this.paisInsPaisCpthisPais = paisInsPaisCpthisPais != null ? paisInsPaisCpthisPais.getOid() : null;
    }

    private void checkPaisInsPaisCpthisPais() throws NotNullArgumentException {
        if(this.getPaisInsPaisCpthisPaisInstance() == null || this.getPaisInsPaisCpthisPaisInstance().isNull()) {
            throw new NotNullArgumentException(PaisConstants.SERV_ID_INSPAISC, PaisConstants.CLASS_ID, PaisConstants.ARG_ID_INSPAISC_PAISINSPAISCPTHISPAIS, PaisConstants.SERV_ALIAS_INSPAISC, PaisConstants.CLASS_ALIAS, PaisConstants.ARG_ALIAS_INSPAISC_PAISINSPAISCPTHISPAIS);
        }
    }

    @JsonIgnore
    public DireccionCOid getPaisInsPaisCpevcDireccionC() {
        return this.paisInsPaisCpevcDireccionC;
    }
    
    public void setPaisInsPaisCpevcDireccionC(DireccionCOid paisInsPaisCpevcDireccionC) {
        this.paisInsPaisCpevcDireccionC = paisInsPaisCpevcDireccionC;
    }

    @JsonIgnore
    public DireccionC getPaisInsPaisCpevcDireccionCInstance() {
        return this.paisInsPaisCpevcDireccionCInstance;
    }
    
    public void setPaisInsPaisCpevcDireccionCInstance(DireccionC paisInsPaisCpevcDireccionC) {
        this.paisInsPaisCpevcDireccionCInstance = paisInsPaisCpevcDireccionC;
        this.paisInsPaisCpevcDireccionC = paisInsPaisCpevcDireccionC != null ? paisInsPaisCpevcDireccionC.getOid() : null;
    }

    private void checkPaisInsPaisCpevcDireccionC() throws NotNullArgumentException {
        if(this.getPaisInsPaisCpevcDireccionCInstance() == null || this.getPaisInsPaisCpevcDireccionCInstance().isNull()) {
            throw new NotNullArgumentException(PaisConstants.SERV_ID_INSPAISC, PaisConstants.CLASS_ID, PaisConstants.ARG_ID_INSPAISC_PAISINSPAISCPEVCDIRECCIONC, PaisConstants.SERV_ALIAS_INSPAISC, PaisConstants.CLASS_ALIAS, PaisConstants.ARG_ALIAS_INSPAISC_PAISINSPAISCPEVCDIRECCIONC);
        }
    }
}
