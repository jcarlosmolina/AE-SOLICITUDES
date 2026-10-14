package com.keralty.aesolicitudes.viewmodel.protecciondatos.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ProteccionDatosConstants;
import com.keralty.aesolicitudes.persistence.oid.ProductosOid;
import com.keralty.aesolicitudes.persistence.oid.ProteccionDatosOid;
import com.keralty.aesolicitudes.persistence.Productos;
import com.keralty.aesolicitudes.persistence.ProteccionDatos;

public class InsProductoProteccionDatosRequest {

    @JsonProperty("p_thisprotecciondatos_oid")
    private ProteccionDatosOid proteccionDatosInsProductoProteccionDatospthisProteccionDatos;
    
    @JsonIgnore
    private ProteccionDatos proteccionDatosInsProductoProteccionDatospthisProteccionDatosInstance;

    @JsonProperty("p_evcproductos_oid")
    private ProductosOid proteccionDatosInsProductoProteccionDatospevcProductos;
    
    @JsonIgnore
    private Productos proteccionDatosInsProductoProteccionDatospevcProductosInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkProteccionDatosInsProductoProteccionDatospthisProteccionDatos();
        checkProteccionDatosInsProductoProteccionDatospevcProductos();
    }

    @JsonIgnore
    public ProteccionDatosOid getProteccionDatosInsProductoProteccionDatospthisProteccionDatos() {
        return this.proteccionDatosInsProductoProteccionDatospthisProteccionDatos;
    }
    
    public void setProteccionDatosInsProductoProteccionDatospthisProteccionDatos(ProteccionDatosOid proteccionDatosInsProductoProteccionDatospthisProteccionDatos) {
        this.proteccionDatosInsProductoProteccionDatospthisProteccionDatos = proteccionDatosInsProductoProteccionDatospthisProteccionDatos;
    }

    @JsonIgnore
    public ProteccionDatos getProteccionDatosInsProductoProteccionDatospthisProteccionDatosInstance() {
        return this.proteccionDatosInsProductoProteccionDatospthisProteccionDatosInstance;
    }
    
    public void setProteccionDatosInsProductoProteccionDatospthisProteccionDatosInstance(ProteccionDatos proteccionDatosInsProductoProteccionDatospthisProteccionDatos) {
        this.proteccionDatosInsProductoProteccionDatospthisProteccionDatosInstance = proteccionDatosInsProductoProteccionDatospthisProteccionDatos;
        this.proteccionDatosInsProductoProteccionDatospthisProteccionDatos = proteccionDatosInsProductoProteccionDatospthisProteccionDatos != null ? proteccionDatosInsProductoProteccionDatospthisProteccionDatos.getOid() : null;
    }

    private void checkProteccionDatosInsProductoProteccionDatospthisProteccionDatos() throws NotNullArgumentException {
        if(this.getProteccionDatosInsProductoProteccionDatospthisProteccionDatosInstance() == null || this.getProteccionDatosInsProductoProteccionDatospthisProteccionDatosInstance().isNull()) {
            throw new NotNullArgumentException(ProteccionDatosConstants.SERV_ID_INSPRODUCTOPROTECCIONDATOS, ProteccionDatosConstants.CLASS_ID, ProteccionDatosConstants.ARG_ID_INSPRODUCTOPROTECCIONDATOS_PROTECCIONDATOSINSPRODUCTOPROTECCIONDATOSPTHISPROTECCIONDATOS, ProteccionDatosConstants.SERV_ALIAS_INSPRODUCTOPROTECCIONDATOS, ProteccionDatosConstants.CLASS_ALIAS, ProteccionDatosConstants.ARG_ALIAS_INSPRODUCTOPROTECCIONDATOS_PROTECCIONDATOSINSPRODUCTOPROTECCIONDATOSPTHISPROTECCIONDATOS);
        }
    }

    @JsonIgnore
    public ProductosOid getProteccionDatosInsProductoProteccionDatospevcProductos() {
        return this.proteccionDatosInsProductoProteccionDatospevcProductos;
    }
    
    public void setProteccionDatosInsProductoProteccionDatospevcProductos(ProductosOid proteccionDatosInsProductoProteccionDatospevcProductos) {
        this.proteccionDatosInsProductoProteccionDatospevcProductos = proteccionDatosInsProductoProteccionDatospevcProductos;
    }

    @JsonIgnore
    public Productos getProteccionDatosInsProductoProteccionDatospevcProductosInstance() {
        return this.proteccionDatosInsProductoProteccionDatospevcProductosInstance;
    }
    
    public void setProteccionDatosInsProductoProteccionDatospevcProductosInstance(Productos proteccionDatosInsProductoProteccionDatospevcProductos) {
        this.proteccionDatosInsProductoProteccionDatospevcProductosInstance = proteccionDatosInsProductoProteccionDatospevcProductos;
        this.proteccionDatosInsProductoProteccionDatospevcProductos = proteccionDatosInsProductoProteccionDatospevcProductos != null ? proteccionDatosInsProductoProteccionDatospevcProductos.getOid() : null;
    }

    private void checkProteccionDatosInsProductoProteccionDatospevcProductos() throws NotNullArgumentException {
        if(this.getProteccionDatosInsProductoProteccionDatospevcProductosInstance() == null || this.getProteccionDatosInsProductoProteccionDatospevcProductosInstance().isNull()) {
            throw new NotNullArgumentException(ProteccionDatosConstants.SERV_ID_INSPRODUCTOPROTECCIONDATOS, ProteccionDatosConstants.CLASS_ID, ProteccionDatosConstants.ARG_ID_INSPRODUCTOPROTECCIONDATOS_PROTECCIONDATOSINSPRODUCTOPROTECCIONDATOSPEVCPRODUCTOS, ProteccionDatosConstants.SERV_ALIAS_INSPRODUCTOPROTECCIONDATOS, ProteccionDatosConstants.CLASS_ALIAS, ProteccionDatosConstants.ARG_ALIAS_INSPRODUCTOPROTECCIONDATOS_PROTECCIONDATOSINSPRODUCTOPROTECCIONDATOSPEVCPRODUCTOS);
        }
    }
}
