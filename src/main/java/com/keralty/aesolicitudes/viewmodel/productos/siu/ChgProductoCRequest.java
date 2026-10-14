package com.keralty.aesolicitudes.viewmodel.productos.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ProductosConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.ProductosOid;
import com.keralty.aesolicitudes.persistence.Productos;

public class ChgProductoCRequest {

    @JsonProperty("p_thisproductos_oid")
    private ProductosOid productoschgProductoCpthisProductos;
    
    @JsonIgnore
    private Productos productoschgProductoCpthisProductosInstance;

    @JsonProperty("p_evccontratoc_oid")
    private ContratoCOid productoschgProductoCpevcContratoC;
    
    @JsonIgnore
    private ContratoC productoschgProductoCpevcContratoCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkProductoschgProductoCpthisProductos();
        checkProductoschgProductoCpevcContratoC();
    }

    @JsonIgnore
    public ProductosOid getProductoschgProductoCpthisProductos() {
        return this.productoschgProductoCpthisProductos;
    }
    
    public void setProductoschgProductoCpthisProductos(ProductosOid productoschgProductoCpthisProductos) {
        this.productoschgProductoCpthisProductos = productoschgProductoCpthisProductos;
    }

    @JsonIgnore
    public Productos getProductoschgProductoCpthisProductosInstance() {
        return this.productoschgProductoCpthisProductosInstance;
    }
    
    public void setProductoschgProductoCpthisProductosInstance(Productos productoschgProductoCpthisProductos) {
        this.productoschgProductoCpthisProductosInstance = productoschgProductoCpthisProductos;
        this.productoschgProductoCpthisProductos = productoschgProductoCpthisProductos != null ? productoschgProductoCpthisProductos.getOid() : null;
    }

    private void checkProductoschgProductoCpthisProductos() throws NotNullArgumentException {
        if(this.getProductoschgProductoCpthisProductosInstance() == null || this.getProductoschgProductoCpthisProductosInstance().isNull()) {
            throw new NotNullArgumentException(ProductosConstants.SERV_ID_CHGPRODUCTOC, ProductosConstants.CLASS_ID, ProductosConstants.ARG_ID_CHGPRODUCTOC_PRODUCTOSCHGPRODUCTOCPTHISPRODUCTOS, ProductosConstants.SERV_ALIAS_CHGPRODUCTOC, ProductosConstants.CLASS_ALIAS, ProductosConstants.ARG_ALIAS_CHGPRODUCTOC_PRODUCTOSCHGPRODUCTOCPTHISPRODUCTOS);
        }
    }

    @JsonIgnore
    public ContratoCOid getProductoschgProductoCpevcContratoC() {
        return this.productoschgProductoCpevcContratoC;
    }
    
    public void setProductoschgProductoCpevcContratoC(ContratoCOid productoschgProductoCpevcContratoC) {
        this.productoschgProductoCpevcContratoC = productoschgProductoCpevcContratoC;
    }

    @JsonIgnore
    public ContratoC getProductoschgProductoCpevcContratoCInstance() {
        return this.productoschgProductoCpevcContratoCInstance;
    }
    
    public void setProductoschgProductoCpevcContratoCInstance(ContratoC productoschgProductoCpevcContratoC) {
        this.productoschgProductoCpevcContratoCInstance = productoschgProductoCpevcContratoC;
        this.productoschgProductoCpevcContratoC = productoschgProductoCpevcContratoC != null ? productoschgProductoCpevcContratoC.getOid() : null;
    }

    private void checkProductoschgProductoCpevcContratoC() throws NotNullArgumentException {
        if(this.getProductoschgProductoCpevcContratoCInstance() == null || this.getProductoschgProductoCpevcContratoCInstance().isNull()) {
            throw new NotNullArgumentException(ProductosConstants.SERV_ID_CHGPRODUCTOC, ProductosConstants.CLASS_ID, ProductosConstants.ARG_ID_CHGPRODUCTOC_PRODUCTOSCHGPRODUCTOCPEVCCONTRATOC, ProductosConstants.SERV_ALIAS_CHGPRODUCTOC, ProductosConstants.CLASS_ALIAS, ProductosConstants.ARG_ALIAS_CHGPRODUCTOC_PRODUCTOSCHGPRODUCTOCPEVCCONTRATOC);
        }
    }
}
