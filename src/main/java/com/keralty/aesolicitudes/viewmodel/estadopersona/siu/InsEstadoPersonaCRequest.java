package com.keralty.aesolicitudes.viewmodel.estadopersona.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.EstadoPersonaConstants;
import com.keralty.aesolicitudes.persistence.EstadoPersona;
import com.keralty.aesolicitudes.persistence.oid.EstadoPersonaOid;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.PersonaC;

public class InsEstadoPersonaCRequest {

    @JsonProperty("p_thisestadopersona_oid")
    private EstadoPersonaOid estadoPersonaInsEstadoPersonaCpthisEstadoPersona;
    
    @JsonIgnore
    private EstadoPersona estadoPersonaInsEstadoPersonaCpthisEstadoPersonaInstance;

    @JsonProperty("p_evcpersonac_oid")
    private PersonaCOid estadoPersonaInsEstadoPersonaCpevcPersonaC;
    
    @JsonIgnore
    private PersonaC estadoPersonaInsEstadoPersonaCpevcPersonaCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkEstadoPersonaInsEstadoPersonaCpthisEstadoPersona();
        checkEstadoPersonaInsEstadoPersonaCpevcPersonaC();
    }

    @JsonIgnore
    public EstadoPersonaOid getEstadoPersonaInsEstadoPersonaCpthisEstadoPersona() {
        return this.estadoPersonaInsEstadoPersonaCpthisEstadoPersona;
    }
    
    public void setEstadoPersonaInsEstadoPersonaCpthisEstadoPersona(EstadoPersonaOid estadoPersonaInsEstadoPersonaCpthisEstadoPersona) {
        this.estadoPersonaInsEstadoPersonaCpthisEstadoPersona = estadoPersonaInsEstadoPersonaCpthisEstadoPersona;
    }

    @JsonIgnore
    public EstadoPersona getEstadoPersonaInsEstadoPersonaCpthisEstadoPersonaInstance() {
        return this.estadoPersonaInsEstadoPersonaCpthisEstadoPersonaInstance;
    }
    
    public void setEstadoPersonaInsEstadoPersonaCpthisEstadoPersonaInstance(EstadoPersona estadoPersonaInsEstadoPersonaCpthisEstadoPersona) {
        this.estadoPersonaInsEstadoPersonaCpthisEstadoPersonaInstance = estadoPersonaInsEstadoPersonaCpthisEstadoPersona;
        this.estadoPersonaInsEstadoPersonaCpthisEstadoPersona = estadoPersonaInsEstadoPersonaCpthisEstadoPersona != null ? estadoPersonaInsEstadoPersonaCpthisEstadoPersona.getOid() : null;
    }

    private void checkEstadoPersonaInsEstadoPersonaCpthisEstadoPersona() throws NotNullArgumentException {
        if(this.getEstadoPersonaInsEstadoPersonaCpthisEstadoPersonaInstance() == null || this.getEstadoPersonaInsEstadoPersonaCpthisEstadoPersonaInstance().isNull()) {
            throw new NotNullArgumentException(EstadoPersonaConstants.SERV_ID_INSESTADOPERSONAC, EstadoPersonaConstants.CLASS_ID, EstadoPersonaConstants.ARG_ID_INSESTADOPERSONAC_ESTADOPERSONAINSESTADOPERSONACPTHISESTADOPERSONA, EstadoPersonaConstants.SERV_ALIAS_INSESTADOPERSONAC, EstadoPersonaConstants.CLASS_ALIAS, EstadoPersonaConstants.ARG_ALIAS_INSESTADOPERSONAC_ESTADOPERSONAINSESTADOPERSONACPTHISESTADOPERSONA);
        }
    }

    @JsonIgnore
    public PersonaCOid getEstadoPersonaInsEstadoPersonaCpevcPersonaC() {
        return this.estadoPersonaInsEstadoPersonaCpevcPersonaC;
    }
    
    public void setEstadoPersonaInsEstadoPersonaCpevcPersonaC(PersonaCOid estadoPersonaInsEstadoPersonaCpevcPersonaC) {
        this.estadoPersonaInsEstadoPersonaCpevcPersonaC = estadoPersonaInsEstadoPersonaCpevcPersonaC;
    }

    @JsonIgnore
    public PersonaC getEstadoPersonaInsEstadoPersonaCpevcPersonaCInstance() {
        return this.estadoPersonaInsEstadoPersonaCpevcPersonaCInstance;
    }
    
    public void setEstadoPersonaInsEstadoPersonaCpevcPersonaCInstance(PersonaC estadoPersonaInsEstadoPersonaCpevcPersonaC) {
        this.estadoPersonaInsEstadoPersonaCpevcPersonaCInstance = estadoPersonaInsEstadoPersonaCpevcPersonaC;
        this.estadoPersonaInsEstadoPersonaCpevcPersonaC = estadoPersonaInsEstadoPersonaCpevcPersonaC != null ? estadoPersonaInsEstadoPersonaCpevcPersonaC.getOid() : null;
    }

    private void checkEstadoPersonaInsEstadoPersonaCpevcPersonaC() throws NotNullArgumentException {
        if(this.getEstadoPersonaInsEstadoPersonaCpevcPersonaCInstance() == null || this.getEstadoPersonaInsEstadoPersonaCpevcPersonaCInstance().isNull()) {
            throw new NotNullArgumentException(EstadoPersonaConstants.SERV_ID_INSESTADOPERSONAC, EstadoPersonaConstants.CLASS_ID, EstadoPersonaConstants.ARG_ID_INSESTADOPERSONAC_ESTADOPERSONAINSESTADOPERSONACPEVCPERSONAC, EstadoPersonaConstants.SERV_ALIAS_INSESTADOPERSONAC, EstadoPersonaConstants.CLASS_ALIAS, EstadoPersonaConstants.ARG_ALIAS_INSESTADOPERSONAC_ESTADOPERSONAINSESTADOPERSONACPEVCPERSONAC);
        }
    }
}
