package com.keralty.aesolicitudes.viewmodel.contratoc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ContratoCConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.ProductosOid;
import com.keralty.aesolicitudes.persistence.Productos;

public class ChgProductoCRequest {

    @JsonProperty("p_thiscontratoc_oid")
    private ContratoCOid contratoCchgProductoCpthisContratoC;
    
    @JsonIgnore
    private ContratoC contratoCchgProductoCpthisContratoCInstance;

    @JsonProperty("p_evcproductos_oid")
    private ProductosOid contratoCchgProductoCpevcProductos;
    
    @JsonIgnore
    private Productos contratoCchgProductoCpevcProductosInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkContratoCchgProductoCpthisContratoC();
        checkContratoCchgProductoCpevcProductos();
    }

    @JsonIgnore
    public ContratoCOid getContratoCchgProductoCpthisContratoC() {
        return this.contratoCchgProductoCpthisContratoC;
    }
    
    public void setContratoCchgProductoCpthisContratoC(ContratoCOid contratoCchgProductoCpthisContratoC) {
        this.contratoCchgProductoCpthisContratoC = contratoCchgProductoCpthisContratoC;
    }

    @JsonIgnore
    public ContratoC getContratoCchgProductoCpthisContratoCInstance() {
        return this.contratoCchgProductoCpthisContratoCInstance;
    }
    
    public void setContratoCchgProductoCpthisContratoCInstance(ContratoC contratoCchgProductoCpthisContratoC) {
        this.contratoCchgProductoCpthisContratoCInstance = contratoCchgProductoCpthisContratoC;
        this.contratoCchgProductoCpthisContratoC = contratoCchgProductoCpthisContratoC != null ? contratoCchgProductoCpthisContratoC.getOid() : null;
    }

    private void checkContratoCchgProductoCpthisContratoC() throws NotNullArgumentException {
        if(this.getContratoCchgProductoCpthisContratoCInstance() == null || this.getContratoCchgProductoCpthisContratoCInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_CHGPRODUCTOC, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_CHGPRODUCTOC_CONTRATOCCHGPRODUCTOCPTHISCONTRATOC, ContratoCConstants.SERV_ALIAS_CHGPRODUCTOC, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_CHGPRODUCTOC_CONTRATOCCHGPRODUCTOCPTHISCONTRATOC);
        }
    }

    @JsonIgnore
    public ProductosOid getContratoCchgProductoCpevcProductos() {
        return this.contratoCchgProductoCpevcProductos;
    }
    
    public void setContratoCchgProductoCpevcProductos(ProductosOid contratoCchgProductoCpevcProductos) {
        this.contratoCchgProductoCpevcProductos = contratoCchgProductoCpevcProductos;
    }

    @JsonIgnore
    public Productos getContratoCchgProductoCpevcProductosInstance() {
        return this.contratoCchgProductoCpevcProductosInstance;
    }
    
    public void setContratoCchgProductoCpevcProductosInstance(Productos contratoCchgProductoCpevcProductos) {
        this.contratoCchgProductoCpevcProductosInstance = contratoCchgProductoCpevcProductos;
        this.contratoCchgProductoCpevcProductos = contratoCchgProductoCpevcProductos != null ? contratoCchgProductoCpevcProductos.getOid() : null;
    }

    private void checkContratoCchgProductoCpevcProductos() throws NotNullArgumentException {
        if(this.getContratoCchgProductoCpevcProductosInstance() == null || this.getContratoCchgProductoCpevcProductosInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_CHGPRODUCTOC, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_CHGPRODUCTOC_CONTRATOCCHGPRODUCTOCPEVCPRODUCTOS, ContratoCConstants.SERV_ALIAS_CHGPRODUCTOC, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_CHGPRODUCTOC_CONTRATOCCHGPRODUCTOCPEVCPRODUCTOS);
        }
    }
}
