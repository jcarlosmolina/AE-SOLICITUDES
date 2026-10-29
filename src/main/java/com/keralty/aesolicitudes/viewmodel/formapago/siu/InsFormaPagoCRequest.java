package com.keralty.aesolicitudes.viewmodel.formapago.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.FormaPagoConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.FormaPago;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.FormaPagoOid;

public class InsFormaPagoCRequest {

    @JsonProperty("p_thisformapago_oid")
    private FormaPagoOid formaPagoInsFormaPagoCpthisFormaPago;
    
    @JsonIgnore
    private FormaPago formaPagoInsFormaPagoCpthisFormaPagoInstance;

    @JsonProperty("p_evccontratoc_oid")
    private ContratoCOid formaPagoInsFormaPagoCpevcContratoC;
    
    @JsonIgnore
    private ContratoC formaPagoInsFormaPagoCpevcContratoCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkFormaPagoInsFormaPagoCpthisFormaPago();
        checkFormaPagoInsFormaPagoCpevcContratoC();
    }

    @JsonIgnore
    public FormaPagoOid getFormaPagoInsFormaPagoCpthisFormaPago() {
        return this.formaPagoInsFormaPagoCpthisFormaPago;
    }
    
    public void setFormaPagoInsFormaPagoCpthisFormaPago(FormaPagoOid formaPagoInsFormaPagoCpthisFormaPago) {
        this.formaPagoInsFormaPagoCpthisFormaPago = formaPagoInsFormaPagoCpthisFormaPago;
    }

    @JsonIgnore
    public FormaPago getFormaPagoInsFormaPagoCpthisFormaPagoInstance() {
        return this.formaPagoInsFormaPagoCpthisFormaPagoInstance;
    }
    
    public void setFormaPagoInsFormaPagoCpthisFormaPagoInstance(FormaPago formaPagoInsFormaPagoCpthisFormaPago) {
        this.formaPagoInsFormaPagoCpthisFormaPagoInstance = formaPagoInsFormaPagoCpthisFormaPago;
        this.formaPagoInsFormaPagoCpthisFormaPago = formaPagoInsFormaPagoCpthisFormaPago != null ? formaPagoInsFormaPagoCpthisFormaPago.getOid() : null;
    }

    private void checkFormaPagoInsFormaPagoCpthisFormaPago() throws NotNullArgumentException {
        if(this.getFormaPagoInsFormaPagoCpthisFormaPagoInstance() == null || this.getFormaPagoInsFormaPagoCpthisFormaPagoInstance().isNull()) {
            throw new NotNullArgumentException(FormaPagoConstants.SERV_ID_INSFORMAPAGOC, FormaPagoConstants.CLASS_ID, FormaPagoConstants.ARG_ID_INSFORMAPAGOC_FORMAPAGOINSFORMAPAGOCPTHISFORMAPAGO, FormaPagoConstants.SERV_ALIAS_INSFORMAPAGOC, FormaPagoConstants.CLASS_ALIAS, FormaPagoConstants.ARG_ALIAS_INSFORMAPAGOC_FORMAPAGOINSFORMAPAGOCPTHISFORMAPAGO);
        }
    }

    @JsonIgnore
    public ContratoCOid getFormaPagoInsFormaPagoCpevcContratoC() {
        return this.formaPagoInsFormaPagoCpevcContratoC;
    }
    
    public void setFormaPagoInsFormaPagoCpevcContratoC(ContratoCOid formaPagoInsFormaPagoCpevcContratoC) {
        this.formaPagoInsFormaPagoCpevcContratoC = formaPagoInsFormaPagoCpevcContratoC;
    }

    @JsonIgnore
    public ContratoC getFormaPagoInsFormaPagoCpevcContratoCInstance() {
        return this.formaPagoInsFormaPagoCpevcContratoCInstance;
    }
    
    public void setFormaPagoInsFormaPagoCpevcContratoCInstance(ContratoC formaPagoInsFormaPagoCpevcContratoC) {
        this.formaPagoInsFormaPagoCpevcContratoCInstance = formaPagoInsFormaPagoCpevcContratoC;
        this.formaPagoInsFormaPagoCpevcContratoC = formaPagoInsFormaPagoCpevcContratoC != null ? formaPagoInsFormaPagoCpevcContratoC.getOid() : null;
    }

    private void checkFormaPagoInsFormaPagoCpevcContratoC() throws NotNullArgumentException {
        if(this.getFormaPagoInsFormaPagoCpevcContratoCInstance() == null || this.getFormaPagoInsFormaPagoCpevcContratoCInstance().isNull()) {
            throw new NotNullArgumentException(FormaPagoConstants.SERV_ID_INSFORMAPAGOC, FormaPagoConstants.CLASS_ID, FormaPagoConstants.ARG_ID_INSFORMAPAGOC_FORMAPAGOINSFORMAPAGOCPEVCCONTRATOC, FormaPagoConstants.SERV_ALIAS_INSFORMAPAGOC, FormaPagoConstants.CLASS_ALIAS, FormaPagoConstants.ARG_ALIAS_INSFORMAPAGOC_FORMAPAGOINSFORMAPAGOCPEVCCONTRATOC);
        }
    }
}
