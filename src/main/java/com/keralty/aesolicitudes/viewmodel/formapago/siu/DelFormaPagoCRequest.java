package com.keralty.aesolicitudes.viewmodel.formapago.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.FormaPagoConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.FormaPago;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.FormaPagoOid;

public class DelFormaPagoCRequest {

    @JsonProperty("p_thisformapago_oid")
    private FormaPagoOid formaPagoDelFormaPagoCpthisFormaPago;
    
    @JsonIgnore
    private FormaPago formaPagoDelFormaPagoCpthisFormaPagoInstance;

    @JsonProperty("p_evccontratoc_oid")
    private ContratoCOid formaPagoDelFormaPagoCpevcContratoC;
    
    @JsonIgnore
    private ContratoC formaPagoDelFormaPagoCpevcContratoCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkFormaPagoDelFormaPagoCpthisFormaPago();
        checkFormaPagoDelFormaPagoCpevcContratoC();
    }

    @JsonIgnore
    public FormaPagoOid getFormaPagoDelFormaPagoCpthisFormaPago() {
        return this.formaPagoDelFormaPagoCpthisFormaPago;
    }
    
    public void setFormaPagoDelFormaPagoCpthisFormaPago(FormaPagoOid formaPagoDelFormaPagoCpthisFormaPago) {
        this.formaPagoDelFormaPagoCpthisFormaPago = formaPagoDelFormaPagoCpthisFormaPago;
    }

    @JsonIgnore
    public FormaPago getFormaPagoDelFormaPagoCpthisFormaPagoInstance() {
        return this.formaPagoDelFormaPagoCpthisFormaPagoInstance;
    }
    
    public void setFormaPagoDelFormaPagoCpthisFormaPagoInstance(FormaPago formaPagoDelFormaPagoCpthisFormaPago) {
        this.formaPagoDelFormaPagoCpthisFormaPagoInstance = formaPagoDelFormaPagoCpthisFormaPago;
        this.formaPagoDelFormaPagoCpthisFormaPago = formaPagoDelFormaPagoCpthisFormaPago != null ? formaPagoDelFormaPagoCpthisFormaPago.getOid() : null;
    }

    private void checkFormaPagoDelFormaPagoCpthisFormaPago() throws NotNullArgumentException {
        if(this.getFormaPagoDelFormaPagoCpthisFormaPagoInstance() == null || this.getFormaPagoDelFormaPagoCpthisFormaPagoInstance().isNull()) {
            throw new NotNullArgumentException(FormaPagoConstants.SERV_ID_DELFORMAPAGOC, FormaPagoConstants.CLASS_ID, FormaPagoConstants.ARG_ID_DELFORMAPAGOC_FORMAPAGODELFORMAPAGOCPTHISFORMAPAGO, FormaPagoConstants.SERV_ALIAS_DELFORMAPAGOC, FormaPagoConstants.CLASS_ALIAS, FormaPagoConstants.ARG_ALIAS_DELFORMAPAGOC_FORMAPAGODELFORMAPAGOCPTHISFORMAPAGO);
        }
    }

    @JsonIgnore
    public ContratoCOid getFormaPagoDelFormaPagoCpevcContratoC() {
        return this.formaPagoDelFormaPagoCpevcContratoC;
    }
    
    public void setFormaPagoDelFormaPagoCpevcContratoC(ContratoCOid formaPagoDelFormaPagoCpevcContratoC) {
        this.formaPagoDelFormaPagoCpevcContratoC = formaPagoDelFormaPagoCpevcContratoC;
    }

    @JsonIgnore
    public ContratoC getFormaPagoDelFormaPagoCpevcContratoCInstance() {
        return this.formaPagoDelFormaPagoCpevcContratoCInstance;
    }
    
    public void setFormaPagoDelFormaPagoCpevcContratoCInstance(ContratoC formaPagoDelFormaPagoCpevcContratoC) {
        this.formaPagoDelFormaPagoCpevcContratoCInstance = formaPagoDelFormaPagoCpevcContratoC;
        this.formaPagoDelFormaPagoCpevcContratoC = formaPagoDelFormaPagoCpevcContratoC != null ? formaPagoDelFormaPagoCpevcContratoC.getOid() : null;
    }

    private void checkFormaPagoDelFormaPagoCpevcContratoC() throws NotNullArgumentException {
        if(this.getFormaPagoDelFormaPagoCpevcContratoCInstance() == null || this.getFormaPagoDelFormaPagoCpevcContratoCInstance().isNull()) {
            throw new NotNullArgumentException(FormaPagoConstants.SERV_ID_DELFORMAPAGOC, FormaPagoConstants.CLASS_ID, FormaPagoConstants.ARG_ID_DELFORMAPAGOC_FORMAPAGODELFORMAPAGOCPEVCCONTRATOC, FormaPagoConstants.SERV_ALIAS_DELFORMAPAGOC, FormaPagoConstants.CLASS_ALIAS, FormaPagoConstants.ARG_ALIAS_DELFORMAPAGOC_FORMAPAGODELFORMAPAGOCPEVCCONTRATOC);
        }
    }
}
