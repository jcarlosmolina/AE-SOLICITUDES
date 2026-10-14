package com.keralty.aesolicitudes.viewmodel.protecciondatos.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ProteccionDatosConstants;
import com.keralty.aesolicitudes.persistence.oid.ProductosOid;
import com.keralty.aesolicitudes.persistence.oid.ProteccionDatosOid;
import com.keralty.aesolicitudes.persistence.Productos;
import com.keralty.aesolicitudes.persistence.ProteccionDatos;

public class DelProductoProteccionDatosRequest {

    @JsonProperty("p_thisprotecciondatos_oid")
    private ProteccionDatosOid proteccionDatosDelProductoProteccionDatospthisProteccionDatos;
    
    @JsonIgnore
    private ProteccionDatos proteccionDatosDelProductoProteccionDatospthisProteccionDatosInstance;

    @JsonProperty("p_evcproductos_oid")
    private ProductosOid proteccionDatosDelProductoProteccionDatospevcProductos;
    
    @JsonIgnore
    private Productos proteccionDatosDelProductoProteccionDatospevcProductosInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkProteccionDatosDelProductoProteccionDatospthisProteccionDatos();
        checkProteccionDatosDelProductoProteccionDatospevcProductos();
    }

    @JsonIgnore
    public ProteccionDatosOid getProteccionDatosDelProductoProteccionDatospthisProteccionDatos() {
        return this.proteccionDatosDelProductoProteccionDatospthisProteccionDatos;
    }
    
    public void setProteccionDatosDelProductoProteccionDatospthisProteccionDatos(ProteccionDatosOid proteccionDatosDelProductoProteccionDatospthisProteccionDatos) {
        this.proteccionDatosDelProductoProteccionDatospthisProteccionDatos = proteccionDatosDelProductoProteccionDatospthisProteccionDatos;
    }

    @JsonIgnore
    public ProteccionDatos getProteccionDatosDelProductoProteccionDatospthisProteccionDatosInstance() {
        return this.proteccionDatosDelProductoProteccionDatospthisProteccionDatosInstance;
    }
    
    public void setProteccionDatosDelProductoProteccionDatospthisProteccionDatosInstance(ProteccionDatos proteccionDatosDelProductoProteccionDatospthisProteccionDatos) {
        this.proteccionDatosDelProductoProteccionDatospthisProteccionDatosInstance = proteccionDatosDelProductoProteccionDatospthisProteccionDatos;
        this.proteccionDatosDelProductoProteccionDatospthisProteccionDatos = proteccionDatosDelProductoProteccionDatospthisProteccionDatos != null ? proteccionDatosDelProductoProteccionDatospthisProteccionDatos.getOid() : null;
    }

    private void checkProteccionDatosDelProductoProteccionDatospthisProteccionDatos() throws NotNullArgumentException {
        if(this.getProteccionDatosDelProductoProteccionDatospthisProteccionDatosInstance() == null || this.getProteccionDatosDelProductoProteccionDatospthisProteccionDatosInstance().isNull()) {
            throw new NotNullArgumentException(ProteccionDatosConstants.SERV_ID_DELPRODUCTOPROTECCIONDATOS, ProteccionDatosConstants.CLASS_ID, ProteccionDatosConstants.ARG_ID_DELPRODUCTOPROTECCIONDATOS_PROTECCIONDATOSDELPRODUCTOPROTECCIONDATOSPTHISPROTECCIONDATOS, ProteccionDatosConstants.SERV_ALIAS_DELPRODUCTOPROTECCIONDATOS, ProteccionDatosConstants.CLASS_ALIAS, ProteccionDatosConstants.ARG_ALIAS_DELPRODUCTOPROTECCIONDATOS_PROTECCIONDATOSDELPRODUCTOPROTECCIONDATOSPTHISPROTECCIONDATOS);
        }
    }

    @JsonIgnore
    public ProductosOid getProteccionDatosDelProductoProteccionDatospevcProductos() {
        return this.proteccionDatosDelProductoProteccionDatospevcProductos;
    }
    
    public void setProteccionDatosDelProductoProteccionDatospevcProductos(ProductosOid proteccionDatosDelProductoProteccionDatospevcProductos) {
        this.proteccionDatosDelProductoProteccionDatospevcProductos = proteccionDatosDelProductoProteccionDatospevcProductos;
    }

    @JsonIgnore
    public Productos getProteccionDatosDelProductoProteccionDatospevcProductosInstance() {
        return this.proteccionDatosDelProductoProteccionDatospevcProductosInstance;
    }
    
    public void setProteccionDatosDelProductoProteccionDatospevcProductosInstance(Productos proteccionDatosDelProductoProteccionDatospevcProductos) {
        this.proteccionDatosDelProductoProteccionDatospevcProductosInstance = proteccionDatosDelProductoProteccionDatospevcProductos;
        this.proteccionDatosDelProductoProteccionDatospevcProductos = proteccionDatosDelProductoProteccionDatospevcProductos != null ? proteccionDatosDelProductoProteccionDatospevcProductos.getOid() : null;
    }

    private void checkProteccionDatosDelProductoProteccionDatospevcProductos() throws NotNullArgumentException {
        if(this.getProteccionDatosDelProductoProteccionDatospevcProductosInstance() == null || this.getProteccionDatosDelProductoProteccionDatospevcProductosInstance().isNull()) {
            throw new NotNullArgumentException(ProteccionDatosConstants.SERV_ID_DELPRODUCTOPROTECCIONDATOS, ProteccionDatosConstants.CLASS_ID, ProteccionDatosConstants.ARG_ID_DELPRODUCTOPROTECCIONDATOS_PROTECCIONDATOSDELPRODUCTOPROTECCIONDATOSPEVCPRODUCTOS, ProteccionDatosConstants.SERV_ALIAS_DELPRODUCTOPROTECCIONDATOS, ProteccionDatosConstants.CLASS_ALIAS, ProteccionDatosConstants.ARG_ALIAS_DELPRODUCTOPROTECCIONDATOS_PROTECCIONDATOSDELPRODUCTOPROTECCIONDATOSPEVCPRODUCTOS);
        }
    }
}
