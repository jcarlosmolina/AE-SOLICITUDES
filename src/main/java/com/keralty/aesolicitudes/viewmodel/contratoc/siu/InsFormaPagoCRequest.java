package com.keralty.aesolicitudes.viewmodel.contratoc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ContratoCConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.FormaPago;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.FormaPagoOid;

public class InsFormaPagoCRequest {

    @JsonProperty("p_thiscontratoc_oid")
    private ContratoCOid contratoCInsFormaPagoCpthisContratoC;
    
    @JsonIgnore
    private ContratoC contratoCInsFormaPagoCpthisContratoCInstance;

    @JsonProperty("p_evcformapago_oid")
    private FormaPagoOid contratoCInsFormaPagoCpevcFormaPago;
    
    @JsonIgnore
    private FormaPago contratoCInsFormaPagoCpevcFormaPagoInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkContratoCInsFormaPagoCpthisContratoC();
        checkContratoCInsFormaPagoCpevcFormaPago();
    }

    @JsonIgnore
    public ContratoCOid getContratoCInsFormaPagoCpthisContratoC() {
        return this.contratoCInsFormaPagoCpthisContratoC;
    }
    
    public void setContratoCInsFormaPagoCpthisContratoC(ContratoCOid contratoCInsFormaPagoCpthisContratoC) {
        this.contratoCInsFormaPagoCpthisContratoC = contratoCInsFormaPagoCpthisContratoC;
    }

    @JsonIgnore
    public ContratoC getContratoCInsFormaPagoCpthisContratoCInstance() {
        return this.contratoCInsFormaPagoCpthisContratoCInstance;
    }
    
    public void setContratoCInsFormaPagoCpthisContratoCInstance(ContratoC contratoCInsFormaPagoCpthisContratoC) {
        this.contratoCInsFormaPagoCpthisContratoCInstance = contratoCInsFormaPagoCpthisContratoC;
        this.contratoCInsFormaPagoCpthisContratoC = contratoCInsFormaPagoCpthisContratoC != null ? contratoCInsFormaPagoCpthisContratoC.getOid() : null;
    }

    private void checkContratoCInsFormaPagoCpthisContratoC() throws NotNullArgumentException {
        if(this.getContratoCInsFormaPagoCpthisContratoCInstance() == null || this.getContratoCInsFormaPagoCpthisContratoCInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_INSFORMAPAGOC, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_INSFORMAPAGOC_CONTRATOCINSFORMAPAGOCPTHISCONTRATOC, ContratoCConstants.SERV_ALIAS_INSFORMAPAGOC, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_INSFORMAPAGOC_CONTRATOCINSFORMAPAGOCPTHISCONTRATOC);
        }
    }

    @JsonIgnore
    public FormaPagoOid getContratoCInsFormaPagoCpevcFormaPago() {
        return this.contratoCInsFormaPagoCpevcFormaPago;
    }
    
    public void setContratoCInsFormaPagoCpevcFormaPago(FormaPagoOid contratoCInsFormaPagoCpevcFormaPago) {
        this.contratoCInsFormaPagoCpevcFormaPago = contratoCInsFormaPagoCpevcFormaPago;
    }

    @JsonIgnore
    public FormaPago getContratoCInsFormaPagoCpevcFormaPagoInstance() {
        return this.contratoCInsFormaPagoCpevcFormaPagoInstance;
    }
    
    public void setContratoCInsFormaPagoCpevcFormaPagoInstance(FormaPago contratoCInsFormaPagoCpevcFormaPago) {
        this.contratoCInsFormaPagoCpevcFormaPagoInstance = contratoCInsFormaPagoCpevcFormaPago;
        this.contratoCInsFormaPagoCpevcFormaPago = contratoCInsFormaPagoCpevcFormaPago != null ? contratoCInsFormaPagoCpevcFormaPago.getOid() : null;
    }

    private void checkContratoCInsFormaPagoCpevcFormaPago() throws NotNullArgumentException {
        if(this.getContratoCInsFormaPagoCpevcFormaPagoInstance() == null || this.getContratoCInsFormaPagoCpevcFormaPagoInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_INSFORMAPAGOC, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_INSFORMAPAGOC_CONTRATOCINSFORMAPAGOCPEVCFORMAPAGO, ContratoCConstants.SERV_ALIAS_INSFORMAPAGOC, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_INSFORMAPAGOC_CONTRATOCINSFORMAPAGOCPEVCFORMAPAGO);
        }
    }
}
