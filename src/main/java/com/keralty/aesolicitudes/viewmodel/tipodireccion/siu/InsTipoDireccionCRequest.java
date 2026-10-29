package com.keralty.aesolicitudes.viewmodel.tipodireccion.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.TipoDireccionConstants;
import com.keralty.aesolicitudes.persistence.DireccionC;
import com.keralty.aesolicitudes.persistence.oid.DireccionCOid;
import com.keralty.aesolicitudes.persistence.oid.TipoDireccionOid;
import com.keralty.aesolicitudes.persistence.TipoDireccion;

public class InsTipoDireccionCRequest {

    @JsonProperty("p_thistipodireccion_oid")
    private TipoDireccionOid tipoDireccionInsTipoDireccionCpthisTipoDireccion;
    
    @JsonIgnore
    private TipoDireccion tipoDireccionInsTipoDireccionCpthisTipoDireccionInstance;

    @JsonProperty("p_evcdireccionc_oid")
    private DireccionCOid tipoDireccionInsTipoDireccionCpevcDireccionC;
    
    @JsonIgnore
    private DireccionC tipoDireccionInsTipoDireccionCpevcDireccionCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkTipoDireccionInsTipoDireccionCpthisTipoDireccion();
        checkTipoDireccionInsTipoDireccionCpevcDireccionC();
    }

    @JsonIgnore
    public TipoDireccionOid getTipoDireccionInsTipoDireccionCpthisTipoDireccion() {
        return this.tipoDireccionInsTipoDireccionCpthisTipoDireccion;
    }
    
    public void setTipoDireccionInsTipoDireccionCpthisTipoDireccion(TipoDireccionOid tipoDireccionInsTipoDireccionCpthisTipoDireccion) {
        this.tipoDireccionInsTipoDireccionCpthisTipoDireccion = tipoDireccionInsTipoDireccionCpthisTipoDireccion;
    }

    @JsonIgnore
    public TipoDireccion getTipoDireccionInsTipoDireccionCpthisTipoDireccionInstance() {
        return this.tipoDireccionInsTipoDireccionCpthisTipoDireccionInstance;
    }
    
    public void setTipoDireccionInsTipoDireccionCpthisTipoDireccionInstance(TipoDireccion tipoDireccionInsTipoDireccionCpthisTipoDireccion) {
        this.tipoDireccionInsTipoDireccionCpthisTipoDireccionInstance = tipoDireccionInsTipoDireccionCpthisTipoDireccion;
        this.tipoDireccionInsTipoDireccionCpthisTipoDireccion = tipoDireccionInsTipoDireccionCpthisTipoDireccion != null ? tipoDireccionInsTipoDireccionCpthisTipoDireccion.getOid() : null;
    }

    private void checkTipoDireccionInsTipoDireccionCpthisTipoDireccion() throws NotNullArgumentException {
        if(this.getTipoDireccionInsTipoDireccionCpthisTipoDireccionInstance() == null || this.getTipoDireccionInsTipoDireccionCpthisTipoDireccionInstance().isNull()) {
            throw new NotNullArgumentException(TipoDireccionConstants.SERV_ID_INSTIPODIRECCIONC, TipoDireccionConstants.CLASS_ID, TipoDireccionConstants.ARG_ID_INSTIPODIRECCIONC_TIPODIRECCIONINSTIPODIRECCIONCPTHISTIPODIRECCION, TipoDireccionConstants.SERV_ALIAS_INSTIPODIRECCIONC, TipoDireccionConstants.CLASS_ALIAS, TipoDireccionConstants.ARG_ALIAS_INSTIPODIRECCIONC_TIPODIRECCIONINSTIPODIRECCIONCPTHISTIPODIRECCION);
        }
    }

    @JsonIgnore
    public DireccionCOid getTipoDireccionInsTipoDireccionCpevcDireccionC() {
        return this.tipoDireccionInsTipoDireccionCpevcDireccionC;
    }
    
    public void setTipoDireccionInsTipoDireccionCpevcDireccionC(DireccionCOid tipoDireccionInsTipoDireccionCpevcDireccionC) {
        this.tipoDireccionInsTipoDireccionCpevcDireccionC = tipoDireccionInsTipoDireccionCpevcDireccionC;
    }

    @JsonIgnore
    public DireccionC getTipoDireccionInsTipoDireccionCpevcDireccionCInstance() {
        return this.tipoDireccionInsTipoDireccionCpevcDireccionCInstance;
    }
    
    public void setTipoDireccionInsTipoDireccionCpevcDireccionCInstance(DireccionC tipoDireccionInsTipoDireccionCpevcDireccionC) {
        this.tipoDireccionInsTipoDireccionCpevcDireccionCInstance = tipoDireccionInsTipoDireccionCpevcDireccionC;
        this.tipoDireccionInsTipoDireccionCpevcDireccionC = tipoDireccionInsTipoDireccionCpevcDireccionC != null ? tipoDireccionInsTipoDireccionCpevcDireccionC.getOid() : null;
    }

    private void checkTipoDireccionInsTipoDireccionCpevcDireccionC() throws NotNullArgumentException {
        if(this.getTipoDireccionInsTipoDireccionCpevcDireccionCInstance() == null || this.getTipoDireccionInsTipoDireccionCpevcDireccionCInstance().isNull()) {
            throw new NotNullArgumentException(TipoDireccionConstants.SERV_ID_INSTIPODIRECCIONC, TipoDireccionConstants.CLASS_ID, TipoDireccionConstants.ARG_ID_INSTIPODIRECCIONC_TIPODIRECCIONINSTIPODIRECCIONCPEVCDIRECCIONC, TipoDireccionConstants.SERV_ALIAS_INSTIPODIRECCIONC, TipoDireccionConstants.CLASS_ALIAS, TipoDireccionConstants.ARG_ALIAS_INSTIPODIRECCIONC_TIPODIRECCIONINSTIPODIRECCIONCPEVCDIRECCIONC);
        }
    }
}
