package com.keralty.aesolicitudes.viewmodel.telefonoc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.TelefonoCConstants;
import com.keralty.aesolicitudes.persistence.DireccionC;
import com.keralty.aesolicitudes.persistence.oid.DireccionCOid;
import com.keralty.aesolicitudes.persistence.oid.TelefonoCOid;
import com.keralty.aesolicitudes.persistence.TelefonoC;

public class TCREARFROMDIRWSRequest {

    @JsonProperty("pdireccionc_oid")
    private DireccionCOid telefonoCTCREARFROMDIRWSpDireccionC;
    
    @JsonIgnore
    private DireccionC telefonoCTCREARFROMDIRWSpDireccionCInstance;

    @JsonProperty("ptelefonoc_oid")
    private TelefonoCOid telefonoCTCREARFROMDIRWSpTelefonoC;
    
    @JsonIgnore
    private TelefonoC telefonoCTCREARFROMDIRWSpTelefonoCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkTelefonoCTCREARFROMDIRWSpDireccionC();
        checkTelefonoCTCREARFROMDIRWSpTelefonoC();
    }

    @JsonIgnore
    public DireccionCOid getTelefonoCTCREARFROMDIRWSpDireccionC() {
        return this.telefonoCTCREARFROMDIRWSpDireccionC;
    }
    
    public void setTelefonoCTCREARFROMDIRWSpDireccionC(DireccionCOid telefonoCTCREARFROMDIRWSpDireccionC) {
        this.telefonoCTCREARFROMDIRWSpDireccionC = telefonoCTCREARFROMDIRWSpDireccionC;
    }

    @JsonIgnore
    public DireccionC getTelefonoCTCREARFROMDIRWSpDireccionCInstance() {
        return this.telefonoCTCREARFROMDIRWSpDireccionCInstance;
    }
    
    public void setTelefonoCTCREARFROMDIRWSpDireccionCInstance(DireccionC telefonoCTCREARFROMDIRWSpDireccionC) {
        this.telefonoCTCREARFROMDIRWSpDireccionCInstance = telefonoCTCREARFROMDIRWSpDireccionC;
        this.telefonoCTCREARFROMDIRWSpDireccionC = telefonoCTCREARFROMDIRWSpDireccionC != null ? telefonoCTCREARFROMDIRWSpDireccionC.getOid() : null;
    }

    private void checkTelefonoCTCREARFROMDIRWSpDireccionC() throws NotNullArgumentException {
        if(this.getTelefonoCTCREARFROMDIRWSpDireccionCInstance() == null || this.getTelefonoCTCREARFROMDIRWSpDireccionCInstance().isNull()) {
            throw new NotNullArgumentException(TelefonoCConstants.SERV_ID_TCREARFROMDIRWS, TelefonoCConstants.CLASS_ID, TelefonoCConstants.ARG_ID_TCREARFROMDIRWS_TELEFONOCTCREARFROMDIRWSPDIRECCIONC, TelefonoCConstants.SERV_ALIAS_TCREARFROMDIRWS, TelefonoCConstants.CLASS_ALIAS, TelefonoCConstants.ARG_ALIAS_TCREARFROMDIRWS_TELEFONOCTCREARFROMDIRWSPDIRECCIONC);
        }
    }

    @JsonIgnore
    public TelefonoCOid getTelefonoCTCREARFROMDIRWSpTelefonoC() {
        return this.telefonoCTCREARFROMDIRWSpTelefonoC;
    }
    
    public void setTelefonoCTCREARFROMDIRWSpTelefonoC(TelefonoCOid telefonoCTCREARFROMDIRWSpTelefonoC) {
        this.telefonoCTCREARFROMDIRWSpTelefonoC = telefonoCTCREARFROMDIRWSpTelefonoC;
    }

    @JsonIgnore
    public TelefonoC getTelefonoCTCREARFROMDIRWSpTelefonoCInstance() {
        return this.telefonoCTCREARFROMDIRWSpTelefonoCInstance;
    }
    
    public void setTelefonoCTCREARFROMDIRWSpTelefonoCInstance(TelefonoC telefonoCTCREARFROMDIRWSpTelefonoC) {
        this.telefonoCTCREARFROMDIRWSpTelefonoCInstance = telefonoCTCREARFROMDIRWSpTelefonoC;
        this.telefonoCTCREARFROMDIRWSpTelefonoC = telefonoCTCREARFROMDIRWSpTelefonoC != null ? telefonoCTCREARFROMDIRWSpTelefonoC.getOid() : null;
    }

    private void checkTelefonoCTCREARFROMDIRWSpTelefonoC() throws NotNullArgumentException {
        if(this.getTelefonoCTCREARFROMDIRWSpTelefonoCInstance() == null || this.getTelefonoCTCREARFROMDIRWSpTelefonoCInstance().isNull()) {
            throw new NotNullArgumentException(TelefonoCConstants.SERV_ID_TCREARFROMDIRWS, TelefonoCConstants.CLASS_ID, TelefonoCConstants.ARG_ID_TCREARFROMDIRWS_TELEFONOCTCREARFROMDIRWSPTELEFONOC, TelefonoCConstants.SERV_ALIAS_TCREARFROMDIRWS, TelefonoCConstants.CLASS_ALIAS, TelefonoCConstants.ARG_ALIAS_TCREARFROMDIRWS_TELEFONOCTCREARFROMDIRWSPTELEFONOC);
        }
    }
}
