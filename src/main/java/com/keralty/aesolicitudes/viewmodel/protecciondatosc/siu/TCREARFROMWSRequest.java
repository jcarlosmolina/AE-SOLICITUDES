package com.keralty.aesolicitudes.viewmodel.protecciondatosc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ProteccionDatosCConstants;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.oid.ProteccionDatosCOid;
import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.ProteccionDatosC;

public class TCREARFROMWSRequest {

    @JsonProperty("ppersonac_oid")
    private PersonaCOid proteccionDatosCTCREARFROMWSpPersonaC;
    
    @JsonIgnore
    private PersonaC proteccionDatosCTCREARFROMWSpPersonaCInstance;

    @JsonProperty("pprotecciondatosc_oid")
    private ProteccionDatosCOid proteccionDatosCTCREARFROMWSpProteccionDatosC;
    
    @JsonIgnore
    private ProteccionDatosC proteccionDatosCTCREARFROMWSpProteccionDatosCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkProteccionDatosCTCREARFROMWSpPersonaC();
        checkProteccionDatosCTCREARFROMWSpProteccionDatosC();
    }

    @JsonIgnore
    public PersonaCOid getProteccionDatosCTCREARFROMWSpPersonaC() {
        return this.proteccionDatosCTCREARFROMWSpPersonaC;
    }
    
    public void setProteccionDatosCTCREARFROMWSpPersonaC(PersonaCOid proteccionDatosCTCREARFROMWSpPersonaC) {
        this.proteccionDatosCTCREARFROMWSpPersonaC = proteccionDatosCTCREARFROMWSpPersonaC;
    }

    @JsonIgnore
    public PersonaC getProteccionDatosCTCREARFROMWSpPersonaCInstance() {
        return this.proteccionDatosCTCREARFROMWSpPersonaCInstance;
    }
    
    public void setProteccionDatosCTCREARFROMWSpPersonaCInstance(PersonaC proteccionDatosCTCREARFROMWSpPersonaC) {
        this.proteccionDatosCTCREARFROMWSpPersonaCInstance = proteccionDatosCTCREARFROMWSpPersonaC;
        this.proteccionDatosCTCREARFROMWSpPersonaC = proteccionDatosCTCREARFROMWSpPersonaC != null ? proteccionDatosCTCREARFROMWSpPersonaC.getOid() : null;
    }

    private void checkProteccionDatosCTCREARFROMWSpPersonaC() throws NotNullArgumentException {
        if(this.getProteccionDatosCTCREARFROMWSpPersonaCInstance() == null || this.getProteccionDatosCTCREARFROMWSpPersonaCInstance().isNull()) {
            throw new NotNullArgumentException(ProteccionDatosCConstants.SERV_ID_TCREARFROMWS, ProteccionDatosCConstants.CLASS_ID, ProteccionDatosCConstants.ARG_ID_TCREARFROMWS_PROTECCIONDATOSCTCREARFROMWSPPERSONAC, ProteccionDatosCConstants.SERV_ALIAS_TCREARFROMWS, ProteccionDatosCConstants.CLASS_ALIAS, ProteccionDatosCConstants.ARG_ALIAS_TCREARFROMWS_PROTECCIONDATOSCTCREARFROMWSPPERSONAC);
        }
    }

    @JsonIgnore
    public ProteccionDatosCOid getProteccionDatosCTCREARFROMWSpProteccionDatosC() {
        return this.proteccionDatosCTCREARFROMWSpProteccionDatosC;
    }
    
    public void setProteccionDatosCTCREARFROMWSpProteccionDatosC(ProteccionDatosCOid proteccionDatosCTCREARFROMWSpProteccionDatosC) {
        this.proteccionDatosCTCREARFROMWSpProteccionDatosC = proteccionDatosCTCREARFROMWSpProteccionDatosC;
    }

    @JsonIgnore
    public ProteccionDatosC getProteccionDatosCTCREARFROMWSpProteccionDatosCInstance() {
        return this.proteccionDatosCTCREARFROMWSpProteccionDatosCInstance;
    }
    
    public void setProteccionDatosCTCREARFROMWSpProteccionDatosCInstance(ProteccionDatosC proteccionDatosCTCREARFROMWSpProteccionDatosC) {
        this.proteccionDatosCTCREARFROMWSpProteccionDatosCInstance = proteccionDatosCTCREARFROMWSpProteccionDatosC;
        this.proteccionDatosCTCREARFROMWSpProteccionDatosC = proteccionDatosCTCREARFROMWSpProteccionDatosC != null ? proteccionDatosCTCREARFROMWSpProteccionDatosC.getOid() : null;
    }

    private void checkProteccionDatosCTCREARFROMWSpProteccionDatosC() throws NotNullArgumentException {
        if(this.getProteccionDatosCTCREARFROMWSpProteccionDatosCInstance() == null || this.getProteccionDatosCTCREARFROMWSpProteccionDatosCInstance().isNull()) {
            throw new NotNullArgumentException(ProteccionDatosCConstants.SERV_ID_TCREARFROMWS, ProteccionDatosCConstants.CLASS_ID, ProteccionDatosCConstants.ARG_ID_TCREARFROMWS_PROTECCIONDATOSCTCREARFROMWSPPROTECCIONDATOSC, ProteccionDatosCConstants.SERV_ALIAS_TCREARFROMWS, ProteccionDatosCConstants.CLASS_ALIAS, ProteccionDatosCConstants.ARG_ALIAS_TCREARFROMWS_PROTECCIONDATOSCTCREARFROMWSPPROTECCIONDATOSC);
        }
    }
}
