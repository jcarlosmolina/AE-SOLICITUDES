package com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.AesolicitudesConstants;
import com.keralty.aesolicitudes.persistence.Aesolicitudes;
import com.keralty.aesolicitudes.persistence.oid.AesolicitudesOid;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class ModificarRequest {

    @JsonProperty("p_thisae_solicitudes_oid")
    private AesolicitudesOid aesolicitudesmodificarpthisAESOLICITUDES;
    
    @JsonIgnore
    private Aesolicitudes aesolicitudesmodificarpthisAESOLICITUDESInstance;

    @JsonProperty("p_numero_solicitud")
    private String aesolicitudesmodificarpNUMEROSOLICITUD;

    @JsonProperty("p_sw_estado")
    private String aesolicitudesmodificarpSWESTADO;

    @JsonProperty("p_fecha_estado")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date aesolicitudesmodificarpFECHAESTADO;

    @JsonProperty("p_cdmotanu")
    private String aesolicitudesmodificarpCDMOTANU;

    @JsonProperty("p_cdmotdev")
    private String aesolicitudesmodificarpCDMOTDEV;

    @JsonProperty("p_fesolici")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date aesolicitudesmodificarpFESOLICI;

    @JsonProperty("p_login")
    private String aesolicitudesmodificarpLOGIN;

    @JsonProperty("p_observacion")
    private String aesolicitudesmodificarpOBSERVACION;

    @JsonProperty("p_tipo_solicitud")
    private String aesolicitudesmodificarpTIPOSOLICITUD;

    public void checkArguments() throws NotNullArgumentException {
        checkAesolicitudesmodificarpthisAESOLICITUDES();
    }

    @JsonIgnore
    public AesolicitudesOid getAesolicitudesmodificarpthisAESOLICITUDES() {
        return this.aesolicitudesmodificarpthisAESOLICITUDES;
    }
    
    public void setAesolicitudesmodificarpthisAESOLICITUDES(AesolicitudesOid aesolicitudesmodificarpthisAESOLICITUDES) {
        this.aesolicitudesmodificarpthisAESOLICITUDES = aesolicitudesmodificarpthisAESOLICITUDES;
    }

    @JsonIgnore
    public Aesolicitudes getAesolicitudesmodificarpthisAESOLICITUDESInstance() {
        return this.aesolicitudesmodificarpthisAESOLICITUDESInstance;
    }
    
    public void setAesolicitudesmodificarpthisAESOLICITUDESInstance(Aesolicitudes aesolicitudesmodificarpthisAESOLICITUDES) {
        this.aesolicitudesmodificarpthisAESOLICITUDESInstance = aesolicitudesmodificarpthisAESOLICITUDES;
        this.aesolicitudesmodificarpthisAESOLICITUDES = aesolicitudesmodificarpthisAESOLICITUDES != null ? aesolicitudesmodificarpthisAESOLICITUDES.getOid() : null;
    }

    private void checkAesolicitudesmodificarpthisAESOLICITUDES() throws NotNullArgumentException {
        if(this.getAesolicitudesmodificarpthisAESOLICITUDESInstance() == null || this.getAesolicitudesmodificarpthisAESOLICITUDESInstance().isNull()) {
            throw new NotNullArgumentException(AesolicitudesConstants.SERV_ID_MODIFICAR, AesolicitudesConstants.CLASS_ID, AesolicitudesConstants.ARG_ID_MODIFICAR_AESOLICITUDESMODIFICARPTHISAESOLICITUDES, AesolicitudesConstants.SERV_ALIAS_MODIFICAR, AesolicitudesConstants.CLASS_ALIAS, AesolicitudesConstants.ARG_ALIAS_MODIFICAR_AESOLICITUDESMODIFICARPTHISAESOLICITUDES);
        }
    }

    @JsonIgnore
    public String getAesolicitudesmodificarpNUMEROSOLICITUD() {
        return this.aesolicitudesmodificarpNUMEROSOLICITUD;
    }
    
    public void setAesolicitudesmodificarpNUMEROSOLICITUD(String aesolicitudesmodificarpNUMEROSOLICITUD) {
        this.aesolicitudesmodificarpNUMEROSOLICITUD = aesolicitudesmodificarpNUMEROSOLICITUD;
    }

    @JsonIgnore
    public String getAesolicitudesmodificarpSWESTADO() {
        return this.aesolicitudesmodificarpSWESTADO;
    }
    
    public void setAesolicitudesmodificarpSWESTADO(String aesolicitudesmodificarpSWESTADO) {
        this.aesolicitudesmodificarpSWESTADO = aesolicitudesmodificarpSWESTADO;
    }

    @JsonIgnore
    public Date getAesolicitudesmodificarpFECHAESTADO() {
        return this.aesolicitudesmodificarpFECHAESTADO;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setAesolicitudesmodificarpFECHAESTADO(Date aesolicitudesmodificarpFECHAESTADO) {
        this.aesolicitudesmodificarpFECHAESTADO = aesolicitudesmodificarpFECHAESTADO;
    }

    @JsonIgnore
    public String getAesolicitudesmodificarpCDMOTANU() {
        return this.aesolicitudesmodificarpCDMOTANU;
    }
    
    public void setAesolicitudesmodificarpCDMOTANU(String aesolicitudesmodificarpCDMOTANU) {
        this.aesolicitudesmodificarpCDMOTANU = aesolicitudesmodificarpCDMOTANU;
    }

    @JsonIgnore
    public String getAesolicitudesmodificarpCDMOTDEV() {
        return this.aesolicitudesmodificarpCDMOTDEV;
    }
    
    public void setAesolicitudesmodificarpCDMOTDEV(String aesolicitudesmodificarpCDMOTDEV) {
        this.aesolicitudesmodificarpCDMOTDEV = aesolicitudesmodificarpCDMOTDEV;
    }

    @JsonIgnore
    public Date getAesolicitudesmodificarpFESOLICI() {
        return this.aesolicitudesmodificarpFESOLICI;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setAesolicitudesmodificarpFESOLICI(Date aesolicitudesmodificarpFESOLICI) {
        this.aesolicitudesmodificarpFESOLICI = aesolicitudesmodificarpFESOLICI;
    }

    @JsonIgnore
    public String getAesolicitudesmodificarpLOGIN() {
        return this.aesolicitudesmodificarpLOGIN;
    }
    
    public void setAesolicitudesmodificarpLOGIN(String aesolicitudesmodificarpLOGIN) {
        this.aesolicitudesmodificarpLOGIN = aesolicitudesmodificarpLOGIN;
    }

    @JsonIgnore
    public String getAesolicitudesmodificarpOBSERVACION() {
        return this.aesolicitudesmodificarpOBSERVACION;
    }
    
    public void setAesolicitudesmodificarpOBSERVACION(String aesolicitudesmodificarpOBSERVACION) {
        this.aesolicitudesmodificarpOBSERVACION = aesolicitudesmodificarpOBSERVACION;
    }

    @JsonIgnore
    public String getAesolicitudesmodificarpTIPOSOLICITUD() {
        return this.aesolicitudesmodificarpTIPOSOLICITUD;
    }
    
    public void setAesolicitudesmodificarpTIPOSOLICITUD(String aesolicitudesmodificarpTIPOSOLICITUD) {
        this.aesolicitudesmodificarpTIPOSOLICITUD = aesolicitudesmodificarpTIPOSOLICITUD;
    }
}
