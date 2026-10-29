package com.keralty.aesolicitudes.viewmodel.telefonoc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.TelefonoCConstants;
import com.keralty.aesolicitudes.persistence.DireccionC;
import com.keralty.aesolicitudes.persistence.DirSucursalC;
import com.keralty.aesolicitudes.persistence.oid.DireccionCOid;
import com.keralty.aesolicitudes.persistence.oid.DirSucursalCOid;

public class CrearRequest {

    @JsonProperty("p_agrdirsucursalc_oid")
    private DirSucursalCOid telefonoCcrearpagrDirSucursalC;
    
    @JsonIgnore
    private DirSucursalC telefonoCcrearpagrDirSucursalCInstance;

    @JsonProperty("p_agrdireccionc_oid")
    private DireccionCOid telefonoCcrearpagrDireccionC;
    
    @JsonIgnore
    private DireccionC telefonoCcrearpagrDireccionCInstance;

    @JsonProperty("p_atrtelefono")
    private String telefonoCcrearpatrTelefono;

    @JsonProperty("p_atrindicativopais")
    private String telefonoCcrearpatrIndicativoPais;

    @JsonProperty("p_atrcodigoarea")
    private String telefonoCcrearpatrCodigoArea;

    @JsonProperty("p_atrext")
    private String telefonoCcrearpatrExt;

    @JsonProperty("p_atrcodigo")
    private Long telefonoCcrearpatrCodigo;

    public void checkArguments() throws NotNullArgumentException {
        checkTelefonoCcrearpatrCodigo();
    }

    @JsonIgnore
    public DirSucursalCOid getTelefonoCcrearpagrDirSucursalC() {
        return this.telefonoCcrearpagrDirSucursalC;
    }
    
    public void setTelefonoCcrearpagrDirSucursalC(DirSucursalCOid telefonoCcrearpagrDirSucursalC) {
        this.telefonoCcrearpagrDirSucursalC = telefonoCcrearpagrDirSucursalC;
    }

    @JsonIgnore
    public DirSucursalC getTelefonoCcrearpagrDirSucursalCInstance() {
        return this.telefonoCcrearpagrDirSucursalCInstance;
    }
    
    public void setTelefonoCcrearpagrDirSucursalCInstance(DirSucursalC telefonoCcrearpagrDirSucursalC) {
        this.telefonoCcrearpagrDirSucursalCInstance = telefonoCcrearpagrDirSucursalC;
        this.telefonoCcrearpagrDirSucursalC = telefonoCcrearpagrDirSucursalC != null ? telefonoCcrearpagrDirSucursalC.getOid() : null;
    }

    @JsonIgnore
    public DireccionCOid getTelefonoCcrearpagrDireccionC() {
        return this.telefonoCcrearpagrDireccionC;
    }
    
    public void setTelefonoCcrearpagrDireccionC(DireccionCOid telefonoCcrearpagrDireccionC) {
        this.telefonoCcrearpagrDireccionC = telefonoCcrearpagrDireccionC;
    }

    @JsonIgnore
    public DireccionC getTelefonoCcrearpagrDireccionCInstance() {
        return this.telefonoCcrearpagrDireccionCInstance;
    }
    
    public void setTelefonoCcrearpagrDireccionCInstance(DireccionC telefonoCcrearpagrDireccionC) {
        this.telefonoCcrearpagrDireccionCInstance = telefonoCcrearpagrDireccionC;
        this.telefonoCcrearpagrDireccionC = telefonoCcrearpagrDireccionC != null ? telefonoCcrearpagrDireccionC.getOid() : null;
    }

    @JsonIgnore
    public String getTelefonoCcrearpatrTelefono() {
        return this.telefonoCcrearpatrTelefono;
    }
    
    public void setTelefonoCcrearpatrTelefono(String telefonoCcrearpatrTelefono) {
        this.telefonoCcrearpatrTelefono = telefonoCcrearpatrTelefono;
    }

    @JsonIgnore
    public String getTelefonoCcrearpatrIndicativoPais() {
        return this.telefonoCcrearpatrIndicativoPais;
    }
    
    public void setTelefonoCcrearpatrIndicativoPais(String telefonoCcrearpatrIndicativoPais) {
        this.telefonoCcrearpatrIndicativoPais = telefonoCcrearpatrIndicativoPais;
    }

    @JsonIgnore
    public String getTelefonoCcrearpatrCodigoArea() {
        return this.telefonoCcrearpatrCodigoArea;
    }
    
    public void setTelefonoCcrearpatrCodigoArea(String telefonoCcrearpatrCodigoArea) {
        this.telefonoCcrearpatrCodigoArea = telefonoCcrearpatrCodigoArea;
    }

    @JsonIgnore
    public String getTelefonoCcrearpatrExt() {
        return this.telefonoCcrearpatrExt;
    }
    
    public void setTelefonoCcrearpatrExt(String telefonoCcrearpatrExt) {
        this.telefonoCcrearpatrExt = telefonoCcrearpatrExt;
    }

    @JsonIgnore
    public Long getTelefonoCcrearpatrCodigo() {
        return this.telefonoCcrearpatrCodigo;
    }
    
    public void setTelefonoCcrearpatrCodigo(Long telefonoCcrearpatrCodigo) {
        this.telefonoCcrearpatrCodigo = telefonoCcrearpatrCodigo;
    }

    private void checkTelefonoCcrearpatrCodigo() throws NotNullArgumentException {
        if(this.getTelefonoCcrearpatrCodigo() == null) {
            throw new NotNullArgumentException(TelefonoCConstants.SERV_ID_CREAR, TelefonoCConstants.CLASS_ID, TelefonoCConstants.ARG_ID_CREAR_TELEFONOCCREARPATRCODIGO, TelefonoCConstants.SERV_ALIAS_CREAR, TelefonoCConstants.CLASS_ALIAS, TelefonoCConstants.ARG_ALIAS_CREAR_TELEFONOCCREARPATRCODIGO);
        }
    }
}
