package com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.AesolicitudesConstants;
import com.keralty.aesolicitudes.persistence.oid.ProductosOid;
import com.keralty.aesolicitudes.persistence.Productos;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class TCREARFISICARequest {

    @JsonProperty("pt_p_agrproducto_oid")
    private ProductosOid aesolicitudesTCREARFISICAptpagrProducto;
    
    @JsonIgnore
    private Productos aesolicitudesTCREARFISICAptpagrProductoInstance;

    @JsonProperty("pt_p_atrlogin")
    private String aesolicitudesTCREARFISICAptpatrLOGIN;

    @JsonProperty("pt_p_numero_solicitud")
    private String aesolicitudesTCREARFISICAptpNUMEROSOLICITUD;

    @JsonProperty("pt_p_sw_estado")
    private String aesolicitudesTCREARFISICAptpSWESTADO;

    @JsonProperty("pt_p_fecha_estado")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date aesolicitudesTCREARFISICAptpFECHAESTADO;

    public void checkArguments() throws NotNullArgumentException {
        checkAesolicitudesTCREARFISICAptpagrProducto();
    }

    @JsonIgnore
    public ProductosOid getAesolicitudesTCREARFISICAptpagrProducto() {
        return this.aesolicitudesTCREARFISICAptpagrProducto;
    }
    
    public void setAesolicitudesTCREARFISICAptpagrProducto(ProductosOid aesolicitudesTCREARFISICAptpagrProducto) {
        this.aesolicitudesTCREARFISICAptpagrProducto = aesolicitudesTCREARFISICAptpagrProducto;
    }

    @JsonIgnore
    public Productos getAesolicitudesTCREARFISICAptpagrProductoInstance() {
        return this.aesolicitudesTCREARFISICAptpagrProductoInstance;
    }
    
    public void setAesolicitudesTCREARFISICAptpagrProductoInstance(Productos aesolicitudesTCREARFISICAptpagrProducto) {
        this.aesolicitudesTCREARFISICAptpagrProductoInstance = aesolicitudesTCREARFISICAptpagrProducto;
        this.aesolicitudesTCREARFISICAptpagrProducto = aesolicitudesTCREARFISICAptpagrProducto != null ? aesolicitudesTCREARFISICAptpagrProducto.getOid() : null;
    }

    private void checkAesolicitudesTCREARFISICAptpagrProducto() throws NotNullArgumentException {
        if(this.getAesolicitudesTCREARFISICAptpagrProductoInstance() == null || this.getAesolicitudesTCREARFISICAptpagrProductoInstance().isNull()) {
            throw new NotNullArgumentException(AesolicitudesConstants.SERV_ID_TCREARFISICA, AesolicitudesConstants.CLASS_ID, AesolicitudesConstants.ARG_ID_TCREARFISICA_AESOLICITUDESTCREARFISICAPTPAGRPRODUCTO, AesolicitudesConstants.SERV_ALIAS_TCREARFISICA, AesolicitudesConstants.CLASS_ALIAS, AesolicitudesConstants.ARG_ALIAS_TCREARFISICA_AESOLICITUDESTCREARFISICAPTPAGRPRODUCTO);
        }
    }

    @JsonIgnore
    public String getAesolicitudesTCREARFISICAptpatrLOGIN() {
        return this.aesolicitudesTCREARFISICAptpatrLOGIN;
    }
    
    public void setAesolicitudesTCREARFISICAptpatrLOGIN(String aesolicitudesTCREARFISICAptpatrLOGIN) {
        this.aesolicitudesTCREARFISICAptpatrLOGIN = aesolicitudesTCREARFISICAptpatrLOGIN;
    }

    @JsonIgnore
    public String getAesolicitudesTCREARFISICAptpNUMEROSOLICITUD() {
        return this.aesolicitudesTCREARFISICAptpNUMEROSOLICITUD;
    }
    
    public void setAesolicitudesTCREARFISICAptpNUMEROSOLICITUD(String aesolicitudesTCREARFISICAptpNUMEROSOLICITUD) {
        this.aesolicitudesTCREARFISICAptpNUMEROSOLICITUD = aesolicitudesTCREARFISICAptpNUMEROSOLICITUD;
    }

    @JsonIgnore
    public String getAesolicitudesTCREARFISICAptpSWESTADO() {
        return this.aesolicitudesTCREARFISICAptpSWESTADO;
    }
    
    public void setAesolicitudesTCREARFISICAptpSWESTADO(String aesolicitudesTCREARFISICAptpSWESTADO) {
        this.aesolicitudesTCREARFISICAptpSWESTADO = aesolicitudesTCREARFISICAptpSWESTADO;
    }

    @JsonIgnore
    public Date getAesolicitudesTCREARFISICAptpFECHAESTADO() {
        return this.aesolicitudesTCREARFISICAptpFECHAESTADO;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setAesolicitudesTCREARFISICAptpFECHAESTADO(Date aesolicitudesTCREARFISICAptpFECHAESTADO) {
        this.aesolicitudesTCREARFISICAptpFECHAESTADO = aesolicitudesTCREARFISICAptpFECHAESTADO;
    }
}
