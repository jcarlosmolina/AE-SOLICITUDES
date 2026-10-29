package com.keralty.aesolicitudes.viewmodel.tipodireccion.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.TipoDireccionConstants;
import com.keralty.aesolicitudes.persistence.DireccionC;
import com.keralty.aesolicitudes.persistence.oid.DireccionCOid;
import com.keralty.aesolicitudes.persistence.oid.TipoDireccionOid;
import com.keralty.aesolicitudes.persistence.TipoDireccion;

public class DelTipoDireccionCRequest {

    @JsonProperty("p_thistipodireccion_oid")
    private TipoDireccionOid tipoDireccionDelTipoDireccionCpthisTipoDireccion;
    
    @JsonIgnore
    private TipoDireccion tipoDireccionDelTipoDireccionCpthisTipoDireccionInstance;

    @JsonProperty("p_evcdireccionc_oid")
    private DireccionCOid tipoDireccionDelTipoDireccionCpevcDireccionC;
    
    @JsonIgnore
    private DireccionC tipoDireccionDelTipoDireccionCpevcDireccionCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkTipoDireccionDelTipoDireccionCpthisTipoDireccion();
        checkTipoDireccionDelTipoDireccionCpevcDireccionC();
    }

    @JsonIgnore
    public TipoDireccionOid getTipoDireccionDelTipoDireccionCpthisTipoDireccion() {
        return this.tipoDireccionDelTipoDireccionCpthisTipoDireccion;
    }
    
    public void setTipoDireccionDelTipoDireccionCpthisTipoDireccion(TipoDireccionOid tipoDireccionDelTipoDireccionCpthisTipoDireccion) {
        this.tipoDireccionDelTipoDireccionCpthisTipoDireccion = tipoDireccionDelTipoDireccionCpthisTipoDireccion;
    }

    @JsonIgnore
    public TipoDireccion getTipoDireccionDelTipoDireccionCpthisTipoDireccionInstance() {
        return this.tipoDireccionDelTipoDireccionCpthisTipoDireccionInstance;
    }
    
    public void setTipoDireccionDelTipoDireccionCpthisTipoDireccionInstance(TipoDireccion tipoDireccionDelTipoDireccionCpthisTipoDireccion) {
        this.tipoDireccionDelTipoDireccionCpthisTipoDireccionInstance = tipoDireccionDelTipoDireccionCpthisTipoDireccion;
        this.tipoDireccionDelTipoDireccionCpthisTipoDireccion = tipoDireccionDelTipoDireccionCpthisTipoDireccion != null ? tipoDireccionDelTipoDireccionCpthisTipoDireccion.getOid() : null;
    }

    private void checkTipoDireccionDelTipoDireccionCpthisTipoDireccion() throws NotNullArgumentException {
        if(this.getTipoDireccionDelTipoDireccionCpthisTipoDireccionInstance() == null || this.getTipoDireccionDelTipoDireccionCpthisTipoDireccionInstance().isNull()) {
            throw new NotNullArgumentException(TipoDireccionConstants.SERV_ID_DELTIPODIRECCIONC, TipoDireccionConstants.CLASS_ID, TipoDireccionConstants.ARG_ID_DELTIPODIRECCIONC_TIPODIRECCIONDELTIPODIRECCIONCPTHISTIPODIRECCION, TipoDireccionConstants.SERV_ALIAS_DELTIPODIRECCIONC, TipoDireccionConstants.CLASS_ALIAS, TipoDireccionConstants.ARG_ALIAS_DELTIPODIRECCIONC_TIPODIRECCIONDELTIPODIRECCIONCPTHISTIPODIRECCION);
        }
    }

    @JsonIgnore
    public DireccionCOid getTipoDireccionDelTipoDireccionCpevcDireccionC() {
        return this.tipoDireccionDelTipoDireccionCpevcDireccionC;
    }
    
    public void setTipoDireccionDelTipoDireccionCpevcDireccionC(DireccionCOid tipoDireccionDelTipoDireccionCpevcDireccionC) {
        this.tipoDireccionDelTipoDireccionCpevcDireccionC = tipoDireccionDelTipoDireccionCpevcDireccionC;
    }

    @JsonIgnore
    public DireccionC getTipoDireccionDelTipoDireccionCpevcDireccionCInstance() {
        return this.tipoDireccionDelTipoDireccionCpevcDireccionCInstance;
    }
    
    public void setTipoDireccionDelTipoDireccionCpevcDireccionCInstance(DireccionC tipoDireccionDelTipoDireccionCpevcDireccionC) {
        this.tipoDireccionDelTipoDireccionCpevcDireccionCInstance = tipoDireccionDelTipoDireccionCpevcDireccionC;
        this.tipoDireccionDelTipoDireccionCpevcDireccionC = tipoDireccionDelTipoDireccionCpevcDireccionC != null ? tipoDireccionDelTipoDireccionCpevcDireccionC.getOid() : null;
    }

    private void checkTipoDireccionDelTipoDireccionCpevcDireccionC() throws NotNullArgumentException {
        if(this.getTipoDireccionDelTipoDireccionCpevcDireccionCInstance() == null || this.getTipoDireccionDelTipoDireccionCpevcDireccionCInstance().isNull()) {
            throw new NotNullArgumentException(TipoDireccionConstants.SERV_ID_DELTIPODIRECCIONC, TipoDireccionConstants.CLASS_ID, TipoDireccionConstants.ARG_ID_DELTIPODIRECCIONC_TIPODIRECCIONDELTIPODIRECCIONCPEVCDIRECCIONC, TipoDireccionConstants.SERV_ALIAS_DELTIPODIRECCIONC, TipoDireccionConstants.CLASS_ALIAS, TipoDireccionConstants.ARG_ALIAS_DELTIPODIRECCIONC_TIPODIRECCIONDELTIPODIRECCIONCPEVCDIRECCIONC);
        }
    }
}
