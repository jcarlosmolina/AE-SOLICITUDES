package com.keralty.aesolicitudes.viewmodel.personac.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.PersonaCConstants;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.oid.UsuarioOid;
import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.Usuario;

public class TCOPIARPREEXDEUSURequest {

    @JsonProperty("p_thispersonac_oid")
    private PersonaCOid personaCTCOPIARPREEXDEUSUpthisPersonaC;
    
    @JsonIgnore
    private PersonaC personaCTCOPIARPREEXDEUSUpthisPersonaCInstance;

    @JsonProperty("p_usuario_oid")
    private UsuarioOid personaCTCOPIARPREEXDEUSUpUsuario;
    
    @JsonIgnore
    private Usuario personaCTCOPIARPREEXDEUSUpUsuarioInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkPersonaCTCOPIARPREEXDEUSUpthisPersonaC();
        checkPersonaCTCOPIARPREEXDEUSUpUsuario();
    }

    @JsonIgnore
    public PersonaCOid getPersonaCTCOPIARPREEXDEUSUpthisPersonaC() {
        return this.personaCTCOPIARPREEXDEUSUpthisPersonaC;
    }
    
    public void setPersonaCTCOPIARPREEXDEUSUpthisPersonaC(PersonaCOid personaCTCOPIARPREEXDEUSUpthisPersonaC) {
        this.personaCTCOPIARPREEXDEUSUpthisPersonaC = personaCTCOPIARPREEXDEUSUpthisPersonaC;
    }

    @JsonIgnore
    public PersonaC getPersonaCTCOPIARPREEXDEUSUpthisPersonaCInstance() {
        return this.personaCTCOPIARPREEXDEUSUpthisPersonaCInstance;
    }
    
    public void setPersonaCTCOPIARPREEXDEUSUpthisPersonaCInstance(PersonaC personaCTCOPIARPREEXDEUSUpthisPersonaC) {
        this.personaCTCOPIARPREEXDEUSUpthisPersonaCInstance = personaCTCOPIARPREEXDEUSUpthisPersonaC;
        this.personaCTCOPIARPREEXDEUSUpthisPersonaC = personaCTCOPIARPREEXDEUSUpthisPersonaC != null ? personaCTCOPIARPREEXDEUSUpthisPersonaC.getOid() : null;
    }

    private void checkPersonaCTCOPIARPREEXDEUSUpthisPersonaC() throws NotNullArgumentException {
        if(this.getPersonaCTCOPIARPREEXDEUSUpthisPersonaCInstance() == null || this.getPersonaCTCOPIARPREEXDEUSUpthisPersonaCInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_TCOPIARPREEXDEUSU, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_TCOPIARPREEXDEUSU_PERSONACTCOPIARPREEXDEUSUPTHISPERSONAC, PersonaCConstants.SERV_ALIAS_TCOPIARPREEXDEUSU, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_TCOPIARPREEXDEUSU_PERSONACTCOPIARPREEXDEUSUPTHISPERSONAC);
        }
    }

    @JsonIgnore
    public UsuarioOid getPersonaCTCOPIARPREEXDEUSUpUsuario() {
        return this.personaCTCOPIARPREEXDEUSUpUsuario;
    }
    
    public void setPersonaCTCOPIARPREEXDEUSUpUsuario(UsuarioOid personaCTCOPIARPREEXDEUSUpUsuario) {
        this.personaCTCOPIARPREEXDEUSUpUsuario = personaCTCOPIARPREEXDEUSUpUsuario;
    }

    @JsonIgnore
    public Usuario getPersonaCTCOPIARPREEXDEUSUpUsuarioInstance() {
        return this.personaCTCOPIARPREEXDEUSUpUsuarioInstance;
    }
    
    public void setPersonaCTCOPIARPREEXDEUSUpUsuarioInstance(Usuario personaCTCOPIARPREEXDEUSUpUsuario) {
        this.personaCTCOPIARPREEXDEUSUpUsuarioInstance = personaCTCOPIARPREEXDEUSUpUsuario;
        this.personaCTCOPIARPREEXDEUSUpUsuario = personaCTCOPIARPREEXDEUSUpUsuario != null ? personaCTCOPIARPREEXDEUSUpUsuario.getOid() : null;
    }

    private void checkPersonaCTCOPIARPREEXDEUSUpUsuario() throws NotNullArgumentException {
        if(this.getPersonaCTCOPIARPREEXDEUSUpUsuarioInstance() == null || this.getPersonaCTCOPIARPREEXDEUSUpUsuarioInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_TCOPIARPREEXDEUSU, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_TCOPIARPREEXDEUSU_PERSONACTCOPIARPREEXDEUSUPUSUARIO, PersonaCConstants.SERV_ALIAS_TCOPIARPREEXDEUSU, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_TCOPIARPREEXDEUSU_PERSONACTCOPIARPREEXDEUSUPUSUARIO);
        }
    }
}
