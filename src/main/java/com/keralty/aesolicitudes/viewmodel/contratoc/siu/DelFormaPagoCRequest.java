package com.keralty.aesolicitudes.viewmodel.contratoc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ContratoCConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.FormaPago;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.FormaPagoOid;

public class DelFormaPagoCRequest {

    @JsonProperty("p_thiscontratoc_oid")
    private ContratoCOid contratoCDelFormaPagoCpthisContratoC;
    
    @JsonIgnore
    private ContratoC contratoCDelFormaPagoCpthisContratoCInstance;

    @JsonProperty("p_evcformapago_oid")
    private FormaPagoOid contratoCDelFormaPagoCpevcFormaPago;
    
    @JsonIgnore
    private FormaPago contratoCDelFormaPagoCpevcFormaPagoInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkContratoCDelFormaPagoCpthisContratoC();
        checkContratoCDelFormaPagoCpevcFormaPago();
    }

    @JsonIgnore
    public ContratoCOid getContratoCDelFormaPagoCpthisContratoC() {
        return this.contratoCDelFormaPagoCpthisContratoC;
    }
    
    public void setContratoCDelFormaPagoCpthisContratoC(ContratoCOid contratoCDelFormaPagoCpthisContratoC) {
        this.contratoCDelFormaPagoCpthisContratoC = contratoCDelFormaPagoCpthisContratoC;
    }

    @JsonIgnore
    public ContratoC getContratoCDelFormaPagoCpthisContratoCInstance() {
        return this.contratoCDelFormaPagoCpthisContratoCInstance;
    }
    
    public void setContratoCDelFormaPagoCpthisContratoCInstance(ContratoC contratoCDelFormaPagoCpthisContratoC) {
        this.contratoCDelFormaPagoCpthisContratoCInstance = contratoCDelFormaPagoCpthisContratoC;
        this.contratoCDelFormaPagoCpthisContratoC = contratoCDelFormaPagoCpthisContratoC != null ? contratoCDelFormaPagoCpthisContratoC.getOid() : null;
    }

    private void checkContratoCDelFormaPagoCpthisContratoC() throws NotNullArgumentException {
        if(this.getContratoCDelFormaPagoCpthisContratoCInstance() == null || this.getContratoCDelFormaPagoCpthisContratoCInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_DELFORMAPAGOC, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_DELFORMAPAGOC_CONTRATOCDELFORMAPAGOCPTHISCONTRATOC, ContratoCConstants.SERV_ALIAS_DELFORMAPAGOC, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_DELFORMAPAGOC_CONTRATOCDELFORMAPAGOCPTHISCONTRATOC);
        }
    }

    @JsonIgnore
    public FormaPagoOid getContratoCDelFormaPagoCpevcFormaPago() {
        return this.contratoCDelFormaPagoCpevcFormaPago;
    }
    
    public void setContratoCDelFormaPagoCpevcFormaPago(FormaPagoOid contratoCDelFormaPagoCpevcFormaPago) {
        this.contratoCDelFormaPagoCpevcFormaPago = contratoCDelFormaPagoCpevcFormaPago;
    }

    @JsonIgnore
    public FormaPago getContratoCDelFormaPagoCpevcFormaPagoInstance() {
        return this.contratoCDelFormaPagoCpevcFormaPagoInstance;
    }
    
    public void setContratoCDelFormaPagoCpevcFormaPagoInstance(FormaPago contratoCDelFormaPagoCpevcFormaPago) {
        this.contratoCDelFormaPagoCpevcFormaPagoInstance = contratoCDelFormaPagoCpevcFormaPago;
        this.contratoCDelFormaPagoCpevcFormaPago = contratoCDelFormaPagoCpevcFormaPago != null ? contratoCDelFormaPagoCpevcFormaPago.getOid() : null;
    }

    private void checkContratoCDelFormaPagoCpevcFormaPago() throws NotNullArgumentException {
        if(this.getContratoCDelFormaPagoCpevcFormaPagoInstance() == null || this.getContratoCDelFormaPagoCpevcFormaPagoInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_DELFORMAPAGOC, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_DELFORMAPAGOC_CONTRATOCDELFORMAPAGOCPEVCFORMAPAGO, ContratoCConstants.SERV_ALIAS_DELFORMAPAGOC, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_DELFORMAPAGOC_CONTRATOCDELFORMAPAGOCPEVCFORMAPAGO);
        }
    }
}
