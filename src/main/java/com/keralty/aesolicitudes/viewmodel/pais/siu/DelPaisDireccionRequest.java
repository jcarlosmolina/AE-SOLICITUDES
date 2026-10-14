package com.keralty.aesolicitudes.viewmodel.pais.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.PaisConstants;
import com.keralty.aesolicitudes.persistence.Direccion;
import com.keralty.aesolicitudes.persistence.oid.DireccionOid;
import com.keralty.aesolicitudes.persistence.oid.PaisOid;
import com.keralty.aesolicitudes.persistence.Pais;

public class DelPaisDireccionRequest {

    @JsonProperty("p_thispais_oid")
    private PaisOid paisDelPaisDireccionpthisPais;
    
    @JsonIgnore
    private Pais paisDelPaisDireccionpthisPaisInstance;

    @JsonProperty("p_evcdireccion_oid")
    private DireccionOid paisDelPaisDireccionpevcDireccion;
    
    @JsonIgnore
    private Direccion paisDelPaisDireccionpevcDireccionInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkPaisDelPaisDireccionpthisPais();
        checkPaisDelPaisDireccionpevcDireccion();
    }

    @JsonIgnore
    public PaisOid getPaisDelPaisDireccionpthisPais() {
        return this.paisDelPaisDireccionpthisPais;
    }
    
    public void setPaisDelPaisDireccionpthisPais(PaisOid paisDelPaisDireccionpthisPais) {
        this.paisDelPaisDireccionpthisPais = paisDelPaisDireccionpthisPais;
    }

    @JsonIgnore
    public Pais getPaisDelPaisDireccionpthisPaisInstance() {
        return this.paisDelPaisDireccionpthisPaisInstance;
    }
    
    public void setPaisDelPaisDireccionpthisPaisInstance(Pais paisDelPaisDireccionpthisPais) {
        this.paisDelPaisDireccionpthisPaisInstance = paisDelPaisDireccionpthisPais;
        this.paisDelPaisDireccionpthisPais = paisDelPaisDireccionpthisPais != null ? paisDelPaisDireccionpthisPais.getOid() : null;
    }

    private void checkPaisDelPaisDireccionpthisPais() throws NotNullArgumentException {
        if(this.getPaisDelPaisDireccionpthisPaisInstance() == null || this.getPaisDelPaisDireccionpthisPaisInstance().isNull()) {
            throw new NotNullArgumentException(PaisConstants.SERV_ID_DELPAISDIRECCION, PaisConstants.CLASS_ID, PaisConstants.ARG_ID_DELPAISDIRECCION_PAISDELPAISDIRECCIONPTHISPAIS, PaisConstants.SERV_ALIAS_DELPAISDIRECCION, PaisConstants.CLASS_ALIAS, PaisConstants.ARG_ALIAS_DELPAISDIRECCION_PAISDELPAISDIRECCIONPTHISPAIS);
        }
    }

    @JsonIgnore
    public DireccionOid getPaisDelPaisDireccionpevcDireccion() {
        return this.paisDelPaisDireccionpevcDireccion;
    }
    
    public void setPaisDelPaisDireccionpevcDireccion(DireccionOid paisDelPaisDireccionpevcDireccion) {
        this.paisDelPaisDireccionpevcDireccion = paisDelPaisDireccionpevcDireccion;
    }

    @JsonIgnore
    public Direccion getPaisDelPaisDireccionpevcDireccionInstance() {
        return this.paisDelPaisDireccionpevcDireccionInstance;
    }
    
    public void setPaisDelPaisDireccionpevcDireccionInstance(Direccion paisDelPaisDireccionpevcDireccion) {
        this.paisDelPaisDireccionpevcDireccionInstance = paisDelPaisDireccionpevcDireccion;
        this.paisDelPaisDireccionpevcDireccion = paisDelPaisDireccionpevcDireccion != null ? paisDelPaisDireccionpevcDireccion.getOid() : null;
    }

    private void checkPaisDelPaisDireccionpevcDireccion() throws NotNullArgumentException {
        if(this.getPaisDelPaisDireccionpevcDireccionInstance() == null || this.getPaisDelPaisDireccionpevcDireccionInstance().isNull()) {
            throw new NotNullArgumentException(PaisConstants.SERV_ID_DELPAISDIRECCION, PaisConstants.CLASS_ID, PaisConstants.ARG_ID_DELPAISDIRECCION_PAISDELPAISDIRECCIONPEVCDIRECCION, PaisConstants.SERV_ALIAS_DELPAISDIRECCION, PaisConstants.CLASS_ALIAS, PaisConstants.ARG_ALIAS_DELPAISDIRECCION_PAISDELPAISDIRECCIONPEVCDIRECCION);
        }
    }
}
