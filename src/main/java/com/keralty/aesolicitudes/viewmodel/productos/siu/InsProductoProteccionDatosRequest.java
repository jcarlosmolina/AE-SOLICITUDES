package com.keralty.aesolicitudes.viewmodel.productos.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ProductosConstants;
import com.keralty.aesolicitudes.persistence.oid.ProductosOid;
import com.keralty.aesolicitudes.persistence.oid.ProteccionDatosOid;
import com.keralty.aesolicitudes.persistence.Productos;
import com.keralty.aesolicitudes.persistence.ProteccionDatos;

public class InsProductoProteccionDatosRequest {

    @JsonProperty("p_thisproducto_oid")
    private ProductosOid productosInsProductoProteccionDatospthisProducto;
    
    @JsonIgnore
    private Productos productosInsProductoProteccionDatospthisProductoInstance;

    @JsonProperty("p_evcprotecciondatos_oid")
    private ProteccionDatosOid productosInsProductoProteccionDatospevcProteccionDatos;
    
    @JsonIgnore
    private ProteccionDatos productosInsProductoProteccionDatospevcProteccionDatosInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkProductosInsProductoProteccionDatospthisProducto();
        checkProductosInsProductoProteccionDatospevcProteccionDatos();
    }

    @JsonIgnore
    public ProductosOid getProductosInsProductoProteccionDatospthisProducto() {
        return this.productosInsProductoProteccionDatospthisProducto;
    }
    
    public void setProductosInsProductoProteccionDatospthisProducto(ProductosOid productosInsProductoProteccionDatospthisProducto) {
        this.productosInsProductoProteccionDatospthisProducto = productosInsProductoProteccionDatospthisProducto;
    }

    @JsonIgnore
    public Productos getProductosInsProductoProteccionDatospthisProductoInstance() {
        return this.productosInsProductoProteccionDatospthisProductoInstance;
    }
    
    public void setProductosInsProductoProteccionDatospthisProductoInstance(Productos productosInsProductoProteccionDatospthisProducto) {
        this.productosInsProductoProteccionDatospthisProductoInstance = productosInsProductoProteccionDatospthisProducto;
        this.productosInsProductoProteccionDatospthisProducto = productosInsProductoProteccionDatospthisProducto != null ? productosInsProductoProteccionDatospthisProducto.getOid() : null;
    }

    private void checkProductosInsProductoProteccionDatospthisProducto() throws NotNullArgumentException {
        if(this.getProductosInsProductoProteccionDatospthisProductoInstance() == null || this.getProductosInsProductoProteccionDatospthisProductoInstance().isNull()) {
            throw new NotNullArgumentException(ProductosConstants.SERV_ID_INSPRODUCTOPROTECCIONDATOS, ProductosConstants.CLASS_ID, ProductosConstants.ARG_ID_INSPRODUCTOPROTECCIONDATOS_PRODUCTOSINSPRODUCTOPROTECCIONDATOSPTHISPRODUCTO, ProductosConstants.SERV_ALIAS_INSPRODUCTOPROTECCIONDATOS, ProductosConstants.CLASS_ALIAS, ProductosConstants.ARG_ALIAS_INSPRODUCTOPROTECCIONDATOS_PRODUCTOSINSPRODUCTOPROTECCIONDATOSPTHISPRODUCTO);
        }
    }

    @JsonIgnore
    public ProteccionDatosOid getProductosInsProductoProteccionDatospevcProteccionDatos() {
        return this.productosInsProductoProteccionDatospevcProteccionDatos;
    }
    
    public void setProductosInsProductoProteccionDatospevcProteccionDatos(ProteccionDatosOid productosInsProductoProteccionDatospevcProteccionDatos) {
        this.productosInsProductoProteccionDatospevcProteccionDatos = productosInsProductoProteccionDatospevcProteccionDatos;
    }

    @JsonIgnore
    public ProteccionDatos getProductosInsProductoProteccionDatospevcProteccionDatosInstance() {
        return this.productosInsProductoProteccionDatospevcProteccionDatosInstance;
    }
    
    public void setProductosInsProductoProteccionDatospevcProteccionDatosInstance(ProteccionDatos productosInsProductoProteccionDatospevcProteccionDatos) {
        this.productosInsProductoProteccionDatospevcProteccionDatosInstance = productosInsProductoProteccionDatospevcProteccionDatos;
        this.productosInsProductoProteccionDatospevcProteccionDatos = productosInsProductoProteccionDatospevcProteccionDatos != null ? productosInsProductoProteccionDatospevcProteccionDatos.getOid() : null;
    }

    private void checkProductosInsProductoProteccionDatospevcProteccionDatos() throws NotNullArgumentException {
        if(this.getProductosInsProductoProteccionDatospevcProteccionDatosInstance() == null || this.getProductosInsProductoProteccionDatospevcProteccionDatosInstance().isNull()) {
            throw new NotNullArgumentException(ProductosConstants.SERV_ID_INSPRODUCTOPROTECCIONDATOS, ProductosConstants.CLASS_ID, ProductosConstants.ARG_ID_INSPRODUCTOPROTECCIONDATOS_PRODUCTOSINSPRODUCTOPROTECCIONDATOSPEVCPROTECCIONDATOS, ProductosConstants.SERV_ALIAS_INSPRODUCTOPROTECCIONDATOS, ProductosConstants.CLASS_ALIAS, ProductosConstants.ARG_ALIAS_INSPRODUCTOPROTECCIONDATOS_PRODUCTOSINSPRODUCTOPROTECCIONDATOSPEVCPROTECCIONDATOS);
        }
    }
}
