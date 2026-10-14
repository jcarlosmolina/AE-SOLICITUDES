package com.keralty.aesolicitudes.viewmodel.personac.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.PersonaCConstants;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.oid.TipoIdentificacionOid;
import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.TipoIdentificacion;

public class TMODIFICARRequest {

    @JsonProperty("p_thispersonac_oid")
    private PersonaCOid personaCTMODIFICARpthisPersonaC;
    
    @JsonIgnore
    private PersonaC personaCTMODIFICARpthisPersonaCInstance;

    @JsonProperty("pt_penombrecompleto")
    private String personaCTMODIFICARptpeNombreCompleto;

    @JsonProperty("pt_penumident")
    private String personaCTMODIFICARptpeNumIdent;

    @JsonProperty("pt_p_evctipoidentificacion_oid")
    private TipoIdentificacionOid personaCTMODIFICARptpevcTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion personaCTMODIFICARptpevcTipoIdentificacionInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkPersonaCTMODIFICARpthisPersonaC();
        checkPersonaCTMODIFICARptpeNumIdent();
        checkPersonaCTMODIFICARptpevcTipoIdentificacion();
    }

    @JsonIgnore
    public PersonaCOid getPersonaCTMODIFICARpthisPersonaC() {
        return this.personaCTMODIFICARpthisPersonaC;
    }
    
    public void setPersonaCTMODIFICARpthisPersonaC(PersonaCOid personaCTMODIFICARpthisPersonaC) {
        this.personaCTMODIFICARpthisPersonaC = personaCTMODIFICARpthisPersonaC;
    }

    @JsonIgnore
    public PersonaC getPersonaCTMODIFICARpthisPersonaCInstance() {
        return this.personaCTMODIFICARpthisPersonaCInstance;
    }
    
    public void setPersonaCTMODIFICARpthisPersonaCInstance(PersonaC personaCTMODIFICARpthisPersonaC) {
        this.personaCTMODIFICARpthisPersonaCInstance = personaCTMODIFICARpthisPersonaC;
        this.personaCTMODIFICARpthisPersonaC = personaCTMODIFICARpthisPersonaC != null ? personaCTMODIFICARpthisPersonaC.getOid() : null;
    }

    private void checkPersonaCTMODIFICARpthisPersonaC() throws NotNullArgumentException {
        if(this.getPersonaCTMODIFICARpthisPersonaCInstance() == null || this.getPersonaCTMODIFICARpthisPersonaCInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_TMODIFICAR, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_TMODIFICAR_PERSONACTMODIFICARPTHISPERSONAC, PersonaCConstants.SERV_ALIAS_TMODIFICAR, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_TMODIFICAR_PERSONACTMODIFICARPTHISPERSONAC);
        }
    }

    @JsonIgnore
    public String getPersonaCTMODIFICARptpeNombreCompleto() {
        return this.personaCTMODIFICARptpeNombreCompleto;
    }
    
    public void setPersonaCTMODIFICARptpeNombreCompleto(String personaCTMODIFICARptpeNombreCompleto) {
        this.personaCTMODIFICARptpeNombreCompleto = personaCTMODIFICARptpeNombreCompleto;
    }

    @JsonIgnore
    public String getPersonaCTMODIFICARptpeNumIdent() {
        return this.personaCTMODIFICARptpeNumIdent;
    }
    
    public void setPersonaCTMODIFICARptpeNumIdent(String personaCTMODIFICARptpeNumIdent) {
        this.personaCTMODIFICARptpeNumIdent = personaCTMODIFICARptpeNumIdent;
    }

    private void checkPersonaCTMODIFICARptpeNumIdent() throws NotNullArgumentException {
        if(this.getPersonaCTMODIFICARptpeNumIdent() == null) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_TMODIFICAR, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_TMODIFICAR_PERSONACTMODIFICARPTPENUMIDENT, PersonaCConstants.SERV_ALIAS_TMODIFICAR, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_TMODIFICAR_PERSONACTMODIFICARPTPENUMIDENT);
        }
    }

    @JsonIgnore
    public TipoIdentificacionOid getPersonaCTMODIFICARptpevcTipoIdentificacion() {
        return this.personaCTMODIFICARptpevcTipoIdentificacion;
    }
    
    public void setPersonaCTMODIFICARptpevcTipoIdentificacion(TipoIdentificacionOid personaCTMODIFICARptpevcTipoIdentificacion) {
        this.personaCTMODIFICARptpevcTipoIdentificacion = personaCTMODIFICARptpevcTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getPersonaCTMODIFICARptpevcTipoIdentificacionInstance() {
        return this.personaCTMODIFICARptpevcTipoIdentificacionInstance;
    }
    
    public void setPersonaCTMODIFICARptpevcTipoIdentificacionInstance(TipoIdentificacion personaCTMODIFICARptpevcTipoIdentificacion) {
        this.personaCTMODIFICARptpevcTipoIdentificacionInstance = personaCTMODIFICARptpevcTipoIdentificacion;
        this.personaCTMODIFICARptpevcTipoIdentificacion = personaCTMODIFICARptpevcTipoIdentificacion != null ? personaCTMODIFICARptpevcTipoIdentificacion.getOid() : null;
    }

    private void checkPersonaCTMODIFICARptpevcTipoIdentificacion() throws NotNullArgumentException {
        if(this.getPersonaCTMODIFICARptpevcTipoIdentificacionInstance() == null || this.getPersonaCTMODIFICARptpevcTipoIdentificacionInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_TMODIFICAR, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_TMODIFICAR_PERSONACTMODIFICARPTPEVCTIPOIDENTIFICACION, PersonaCConstants.SERV_ALIAS_TMODIFICAR, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_TMODIFICAR_PERSONACTMODIFICARPTPEVCTIPOIDENTIFICACION);
        }
    }
}
