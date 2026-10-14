package com.keralty.aesolicitudes.viewmodel.estadopersona.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.EstadoPersonaConstants;
import com.keralty.aesolicitudes.persistence.EstadoPersona;
import com.keralty.aesolicitudes.persistence.oid.EstadoPersonaOid;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.PersonaC;

public class DelEstadoPersonaCRequest {

    @JsonProperty("p_thisestadopersona_oid")
    private EstadoPersonaOid estadoPersonaDelEstadoPersonaCpthisEstadoPersona;
    
    @JsonIgnore
    private EstadoPersona estadoPersonaDelEstadoPersonaCpthisEstadoPersonaInstance;

    @JsonProperty("p_evcpersonac_oid")
    private PersonaCOid estadoPersonaDelEstadoPersonaCpevcPersonaC;
    
    @JsonIgnore
    private PersonaC estadoPersonaDelEstadoPersonaCpevcPersonaCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkEstadoPersonaDelEstadoPersonaCpthisEstadoPersona();
        checkEstadoPersonaDelEstadoPersonaCpevcPersonaC();
    }

    @JsonIgnore
    public EstadoPersonaOid getEstadoPersonaDelEstadoPersonaCpthisEstadoPersona() {
        return this.estadoPersonaDelEstadoPersonaCpthisEstadoPersona;
    }
    
    public void setEstadoPersonaDelEstadoPersonaCpthisEstadoPersona(EstadoPersonaOid estadoPersonaDelEstadoPersonaCpthisEstadoPersona) {
        this.estadoPersonaDelEstadoPersonaCpthisEstadoPersona = estadoPersonaDelEstadoPersonaCpthisEstadoPersona;
    }

    @JsonIgnore
    public EstadoPersona getEstadoPersonaDelEstadoPersonaCpthisEstadoPersonaInstance() {
        return this.estadoPersonaDelEstadoPersonaCpthisEstadoPersonaInstance;
    }
    
    public void setEstadoPersonaDelEstadoPersonaCpthisEstadoPersonaInstance(EstadoPersona estadoPersonaDelEstadoPersonaCpthisEstadoPersona) {
        this.estadoPersonaDelEstadoPersonaCpthisEstadoPersonaInstance = estadoPersonaDelEstadoPersonaCpthisEstadoPersona;
        this.estadoPersonaDelEstadoPersonaCpthisEstadoPersona = estadoPersonaDelEstadoPersonaCpthisEstadoPersona != null ? estadoPersonaDelEstadoPersonaCpthisEstadoPersona.getOid() : null;
    }

    private void checkEstadoPersonaDelEstadoPersonaCpthisEstadoPersona() throws NotNullArgumentException {
        if(this.getEstadoPersonaDelEstadoPersonaCpthisEstadoPersonaInstance() == null || this.getEstadoPersonaDelEstadoPersonaCpthisEstadoPersonaInstance().isNull()) {
            throw new NotNullArgumentException(EstadoPersonaConstants.SERV_ID_DELESTADOPERSONAC, EstadoPersonaConstants.CLASS_ID, EstadoPersonaConstants.ARG_ID_DELESTADOPERSONAC_ESTADOPERSONADELESTADOPERSONACPTHISESTADOPERSONA, EstadoPersonaConstants.SERV_ALIAS_DELESTADOPERSONAC, EstadoPersonaConstants.CLASS_ALIAS, EstadoPersonaConstants.ARG_ALIAS_DELESTADOPERSONAC_ESTADOPERSONADELESTADOPERSONACPTHISESTADOPERSONA);
        }
    }

    @JsonIgnore
    public PersonaCOid getEstadoPersonaDelEstadoPersonaCpevcPersonaC() {
        return this.estadoPersonaDelEstadoPersonaCpevcPersonaC;
    }
    
    public void setEstadoPersonaDelEstadoPersonaCpevcPersonaC(PersonaCOid estadoPersonaDelEstadoPersonaCpevcPersonaC) {
        this.estadoPersonaDelEstadoPersonaCpevcPersonaC = estadoPersonaDelEstadoPersonaCpevcPersonaC;
    }

    @JsonIgnore
    public PersonaC getEstadoPersonaDelEstadoPersonaCpevcPersonaCInstance() {
        return this.estadoPersonaDelEstadoPersonaCpevcPersonaCInstance;
    }
    
    public void setEstadoPersonaDelEstadoPersonaCpevcPersonaCInstance(PersonaC estadoPersonaDelEstadoPersonaCpevcPersonaC) {
        this.estadoPersonaDelEstadoPersonaCpevcPersonaCInstance = estadoPersonaDelEstadoPersonaCpevcPersonaC;
        this.estadoPersonaDelEstadoPersonaCpevcPersonaC = estadoPersonaDelEstadoPersonaCpevcPersonaC != null ? estadoPersonaDelEstadoPersonaCpevcPersonaC.getOid() : null;
    }

    private void checkEstadoPersonaDelEstadoPersonaCpevcPersonaC() throws NotNullArgumentException {
        if(this.getEstadoPersonaDelEstadoPersonaCpevcPersonaCInstance() == null || this.getEstadoPersonaDelEstadoPersonaCpevcPersonaCInstance().isNull()) {
            throw new NotNullArgumentException(EstadoPersonaConstants.SERV_ID_DELESTADOPERSONAC, EstadoPersonaConstants.CLASS_ID, EstadoPersonaConstants.ARG_ID_DELESTADOPERSONAC_ESTADOPERSONADELESTADOPERSONACPEVCPERSONAC, EstadoPersonaConstants.SERV_ALIAS_DELESTADOPERSONAC, EstadoPersonaConstants.CLASS_ALIAS, EstadoPersonaConstants.ARG_ALIAS_DELESTADOPERSONAC_ESTADOPERSONADELESTADOPERSONACPEVCPERSONAC);
        }
    }
}
