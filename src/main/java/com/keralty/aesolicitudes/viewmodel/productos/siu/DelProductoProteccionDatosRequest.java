package com.keralty.aesolicitudes.viewmodel.productos.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ProductosConstants;
import com.keralty.aesolicitudes.persistence.oid.ProductosOid;
import com.keralty.aesolicitudes.persistence.oid.ProteccionDatosOid;
import com.keralty.aesolicitudes.persistence.Productos;
import com.keralty.aesolicitudes.persistence.ProteccionDatos;

public class DelProductoProteccionDatosRequest {

    @JsonProperty("p_thisproducto_oid")
    private ProductosOid productosDelProductoProteccionDatospthisProducto;
    
    @JsonIgnore
    private Productos productosDelProductoProteccionDatospthisProductoInstance;

    @JsonProperty("p_evcprotecciondatos_oid")
    private ProteccionDatosOid productosDelProductoProteccionDatospevcProteccionDatos;
    
    @JsonIgnore
    private ProteccionDatos productosDelProductoProteccionDatospevcProteccionDatosInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkProductosDelProductoProteccionDatospthisProducto();
        checkProductosDelProductoProteccionDatospevcProteccionDatos();
    }

    @JsonIgnore
    public ProductosOid getProductosDelProductoProteccionDatospthisProducto() {
        return this.productosDelProductoProteccionDatospthisProducto;
    }
    
    public void setProductosDelProductoProteccionDatospthisProducto(ProductosOid productosDelProductoProteccionDatospthisProducto) {
        this.productosDelProductoProteccionDatospthisProducto = productosDelProductoProteccionDatospthisProducto;
    }

    @JsonIgnore
    public Productos getProductosDelProductoProteccionDatospthisProductoInstance() {
        return this.productosDelProductoProteccionDatospthisProductoInstance;
    }
    
    public void setProductosDelProductoProteccionDatospthisProductoInstance(Productos productosDelProductoProteccionDatospthisProducto) {
        this.productosDelProductoProteccionDatospthisProductoInstance = productosDelProductoProteccionDatospthisProducto;
        this.productosDelProductoProteccionDatospthisProducto = productosDelProductoProteccionDatospthisProducto != null ? productosDelProductoProteccionDatospthisProducto.getOid() : null;
    }

    private void checkProductosDelProductoProteccionDatospthisProducto() throws NotNullArgumentException {
        if(this.getProductosDelProductoProteccionDatospthisProductoInstance() == null || this.getProductosDelProductoProteccionDatospthisProductoInstance().isNull()) {
            throw new NotNullArgumentException(ProductosConstants.SERV_ID_DELPRODUCTOPROTECCIONDATOS, ProductosConstants.CLASS_ID, ProductosConstants.ARG_ID_DELPRODUCTOPROTECCIONDATOS_PRODUCTOSDELPRODUCTOPROTECCIONDATOSPTHISPRODUCTO, ProductosConstants.SERV_ALIAS_DELPRODUCTOPROTECCIONDATOS, ProductosConstants.CLASS_ALIAS, ProductosConstants.ARG_ALIAS_DELPRODUCTOPROTECCIONDATOS_PRODUCTOSDELPRODUCTOPROTECCIONDATOSPTHISPRODUCTO);
        }
    }

    @JsonIgnore
    public ProteccionDatosOid getProductosDelProductoProteccionDatospevcProteccionDatos() {
        return this.productosDelProductoProteccionDatospevcProteccionDatos;
    }
    
    public void setProductosDelProductoProteccionDatospevcProteccionDatos(ProteccionDatosOid productosDelProductoProteccionDatospevcProteccionDatos) {
        this.productosDelProductoProteccionDatospevcProteccionDatos = productosDelProductoProteccionDatospevcProteccionDatos;
    }

    @JsonIgnore
    public ProteccionDatos getProductosDelProductoProteccionDatospevcProteccionDatosInstance() {
        return this.productosDelProductoProteccionDatospevcProteccionDatosInstance;
    }
    
    public void setProductosDelProductoProteccionDatospevcProteccionDatosInstance(ProteccionDatos productosDelProductoProteccionDatospevcProteccionDatos) {
        this.productosDelProductoProteccionDatospevcProteccionDatosInstance = productosDelProductoProteccionDatospevcProteccionDatos;
        this.productosDelProductoProteccionDatospevcProteccionDatos = productosDelProductoProteccionDatospevcProteccionDatos != null ? productosDelProductoProteccionDatospevcProteccionDatos.getOid() : null;
    }

    private void checkProductosDelProductoProteccionDatospevcProteccionDatos() throws NotNullArgumentException {
        if(this.getProductosDelProductoProteccionDatospevcProteccionDatosInstance() == null || this.getProductosDelProductoProteccionDatospevcProteccionDatosInstance().isNull()) {
            throw new NotNullArgumentException(ProductosConstants.SERV_ID_DELPRODUCTOPROTECCIONDATOS, ProductosConstants.CLASS_ID, ProductosConstants.ARG_ID_DELPRODUCTOPROTECCIONDATOS_PRODUCTOSDELPRODUCTOPROTECCIONDATOSPEVCPROTECCIONDATOS, ProductosConstants.SERV_ALIAS_DELPRODUCTOPROTECCIONDATOS, ProductosConstants.CLASS_ALIAS, ProductosConstants.ARG_ALIAS_DELPRODUCTOPROTECCIONDATOS_PRODUCTOSDELPRODUCTOPROTECCIONDATOSPEVCPROTECCIONDATOS);
        }
    }
}
