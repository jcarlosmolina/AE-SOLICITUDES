package com.keralty.aesolicitudes.viewmodel.globalservices.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.GlobalServiceConstants;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class TGSOLICITUDFISICACARGARRequest {

    @JsonProperty("p_clproducto")
    private String tGSOLICITUDFISICACARGARpCLProducto;

    @JsonProperty("pt_p_atrlogin")
    private String tGSOLICITUDFISICACARGARptpatrLOGIN;

    @JsonProperty("pt_p_numero_solicitud")
    private String tGSOLICITUDFISICACARGARptpNUMEROSOLICITUD;

    @JsonProperty("pt_p_sw_estado")
    private String tGSOLICITUDFISICACARGARptpSWESTADO;

    @JsonProperty("pt_p_fecha_estado")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date tGSOLICITUDFISICACARGARptpFECHAESTADO;

    public void checkArguments() throws NotNullArgumentException {
        checkTGSOLICITUDFISICACARGARpCLProducto();
    }

    @JsonIgnore
    public String getTGSOLICITUDFISICACARGARpCLProducto() {
        return this.tGSOLICITUDFISICACARGARpCLProducto;
    }
    
    public void setTGSOLICITUDFISICACARGARpCLProducto(String tGSOLICITUDFISICACARGARpCLProducto) {
        this.tGSOLICITUDFISICACARGARpCLProducto = tGSOLICITUDFISICACARGARpCLProducto;
    }

    private void checkTGSOLICITUDFISICACARGARpCLProducto() throws NotNullArgumentException {
        if(this.getTGSOLICITUDFISICACARGARpCLProducto() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGSOLICITUDFISICACARGAR, GlobalServiceConstants.GS_ARG_ID_TGSOLICITUDFISICACARGAR_TGSOLICITUDFISICACARGARPCLPRODUCTO, GlobalServiceConstants.G_SERV_ALIAS_TGSOLICITUDFISICACARGAR, GlobalServiceConstants.GS_ARG_ALIAS_TGSOLICITUDFISICACARGAR_TGSOLICITUDFISICACARGARPCLPRODUCTO);
        }
    }

    @JsonIgnore
    public String getTGSOLICITUDFISICACARGARptpatrLOGIN() {
        return this.tGSOLICITUDFISICACARGARptpatrLOGIN;
    }
    
    public void setTGSOLICITUDFISICACARGARptpatrLOGIN(String tGSOLICITUDFISICACARGARptpatrLOGIN) {
        this.tGSOLICITUDFISICACARGARptpatrLOGIN = tGSOLICITUDFISICACARGARptpatrLOGIN;
    }

    @JsonIgnore
    public String getTGSOLICITUDFISICACARGARptpNUMEROSOLICITUD() {
        return this.tGSOLICITUDFISICACARGARptpNUMEROSOLICITUD;
    }
    
    public void setTGSOLICITUDFISICACARGARptpNUMEROSOLICITUD(String tGSOLICITUDFISICACARGARptpNUMEROSOLICITUD) {
        this.tGSOLICITUDFISICACARGARptpNUMEROSOLICITUD = tGSOLICITUDFISICACARGARptpNUMEROSOLICITUD;
    }

    @JsonIgnore
    public String getTGSOLICITUDFISICACARGARptpSWESTADO() {
        return this.tGSOLICITUDFISICACARGARptpSWESTADO;
    }
    
    public void setTGSOLICITUDFISICACARGARptpSWESTADO(String tGSOLICITUDFISICACARGARptpSWESTADO) {
        this.tGSOLICITUDFISICACARGARptpSWESTADO = tGSOLICITUDFISICACARGARptpSWESTADO;
    }

    @JsonIgnore
    public Date getTGSOLICITUDFISICACARGARptpFECHAESTADO() {
        return this.tGSOLICITUDFISICACARGARptpFECHAESTADO;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setTGSOLICITUDFISICACARGARptpFECHAESTADO(Date tGSOLICITUDFISICACARGARptpFECHAESTADO) {
        this.tGSOLICITUDFISICACARGARptpFECHAESTADO = tGSOLICITUDFISICACARGARptpFECHAESTADO;
    }
}
