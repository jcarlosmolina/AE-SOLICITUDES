package com.keralty.aesolicitudes.viewmodel.telefonoc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.TelefonoCConstants;
import com.keralty.aesolicitudes.persistence.DirSucursalC;
import com.keralty.aesolicitudes.persistence.oid.DirSucursalCOid;
import com.keralty.aesolicitudes.persistence.oid.TelefonoCOid;
import com.keralty.aesolicitudes.persistence.TelefonoC;

public class TCREARFROMDIRSUCWSRequest {

    @JsonProperty("pdirsucursalc_oid")
    private DirSucursalCOid telefonoCTCREARFROMDIRSUCWSpDirSucursalC;
    
    @JsonIgnore
    private DirSucursalC telefonoCTCREARFROMDIRSUCWSpDirSucursalCInstance;

    @JsonProperty("ptelefonoc_oid")
    private TelefonoCOid telefonoCTCREARFROMDIRSUCWSpTelefonoC;
    
    @JsonIgnore
    private TelefonoC telefonoCTCREARFROMDIRSUCWSpTelefonoCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkTelefonoCTCREARFROMDIRSUCWSpDirSucursalC();
        checkTelefonoCTCREARFROMDIRSUCWSpTelefonoC();
    }

    @JsonIgnore
    public DirSucursalCOid getTelefonoCTCREARFROMDIRSUCWSpDirSucursalC() {
        return this.telefonoCTCREARFROMDIRSUCWSpDirSucursalC;
    }
    
    public void setTelefonoCTCREARFROMDIRSUCWSpDirSucursalC(DirSucursalCOid telefonoCTCREARFROMDIRSUCWSpDirSucursalC) {
        this.telefonoCTCREARFROMDIRSUCWSpDirSucursalC = telefonoCTCREARFROMDIRSUCWSpDirSucursalC;
    }

    @JsonIgnore
    public DirSucursalC getTelefonoCTCREARFROMDIRSUCWSpDirSucursalCInstance() {
        return this.telefonoCTCREARFROMDIRSUCWSpDirSucursalCInstance;
    }
    
    public void setTelefonoCTCREARFROMDIRSUCWSpDirSucursalCInstance(DirSucursalC telefonoCTCREARFROMDIRSUCWSpDirSucursalC) {
        this.telefonoCTCREARFROMDIRSUCWSpDirSucursalCInstance = telefonoCTCREARFROMDIRSUCWSpDirSucursalC;
        this.telefonoCTCREARFROMDIRSUCWSpDirSucursalC = telefonoCTCREARFROMDIRSUCWSpDirSucursalC != null ? telefonoCTCREARFROMDIRSUCWSpDirSucursalC.getOid() : null;
    }

    private void checkTelefonoCTCREARFROMDIRSUCWSpDirSucursalC() throws NotNullArgumentException {
        if(this.getTelefonoCTCREARFROMDIRSUCWSpDirSucursalCInstance() == null || this.getTelefonoCTCREARFROMDIRSUCWSpDirSucursalCInstance().isNull()) {
            throw new NotNullArgumentException(TelefonoCConstants.SERV_ID_TCREARFROMDIRSUCWS, TelefonoCConstants.CLASS_ID, TelefonoCConstants.ARG_ID_TCREARFROMDIRSUCWS_TELEFONOCTCREARFROMDIRSUCWSPDIRSUCURSALC, TelefonoCConstants.SERV_ALIAS_TCREARFROMDIRSUCWS, TelefonoCConstants.CLASS_ALIAS, TelefonoCConstants.ARG_ALIAS_TCREARFROMDIRSUCWS_TELEFONOCTCREARFROMDIRSUCWSPDIRSUCURSALC);
        }
    }

    @JsonIgnore
    public TelefonoCOid getTelefonoCTCREARFROMDIRSUCWSpTelefonoC() {
        return this.telefonoCTCREARFROMDIRSUCWSpTelefonoC;
    }
    
    public void setTelefonoCTCREARFROMDIRSUCWSpTelefonoC(TelefonoCOid telefonoCTCREARFROMDIRSUCWSpTelefonoC) {
        this.telefonoCTCREARFROMDIRSUCWSpTelefonoC = telefonoCTCREARFROMDIRSUCWSpTelefonoC;
    }

    @JsonIgnore
    public TelefonoC getTelefonoCTCREARFROMDIRSUCWSpTelefonoCInstance() {
        return this.telefonoCTCREARFROMDIRSUCWSpTelefonoCInstance;
    }
    
    public void setTelefonoCTCREARFROMDIRSUCWSpTelefonoCInstance(TelefonoC telefonoCTCREARFROMDIRSUCWSpTelefonoC) {
        this.telefonoCTCREARFROMDIRSUCWSpTelefonoCInstance = telefonoCTCREARFROMDIRSUCWSpTelefonoC;
        this.telefonoCTCREARFROMDIRSUCWSpTelefonoC = telefonoCTCREARFROMDIRSUCWSpTelefonoC != null ? telefonoCTCREARFROMDIRSUCWSpTelefonoC.getOid() : null;
    }

    private void checkTelefonoCTCREARFROMDIRSUCWSpTelefonoC() throws NotNullArgumentException {
        if(this.getTelefonoCTCREARFROMDIRSUCWSpTelefonoCInstance() == null || this.getTelefonoCTCREARFROMDIRSUCWSpTelefonoCInstance().isNull()) {
            throw new NotNullArgumentException(TelefonoCConstants.SERV_ID_TCREARFROMDIRSUCWS, TelefonoCConstants.CLASS_ID, TelefonoCConstants.ARG_ID_TCREARFROMDIRSUCWS_TELEFONOCTCREARFROMDIRSUCWSPTELEFONOC, TelefonoCConstants.SERV_ALIAS_TCREARFROMDIRSUCWS, TelefonoCConstants.CLASS_ALIAS, TelefonoCConstants.ARG_ALIAS_TCREARFROMDIRSUCWS_TELEFONOCTCREARFROMDIRSUCWSPTELEFONOC);
        }
    }
}
