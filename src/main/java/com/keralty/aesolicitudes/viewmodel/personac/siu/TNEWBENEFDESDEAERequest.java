package com.keralty.aesolicitudes.viewmodel.personac.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.PersonaCConstants;
import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.oid.BeneficiarioCOid;
import com.keralty.aesolicitudes.persistence.oid.UsuarioOid;
import com.keralty.aesolicitudes.persistence.Usuario;

public class TNEWBENEFDESDEAERequest {

    @JsonProperty("ptbeneficiario_oid")
    private BeneficiarioCOid personaCTNEWBENEFDESDEAEptBeneficiario;
    
    @JsonIgnore
    private BeneficiarioC personaCTNEWBENEFDESDEAEptBeneficiarioInstance;

    @JsonProperty("ptusuario_oid")
    private UsuarioOid personaCTNEWBENEFDESDEAEptUsuario;
    
    @JsonIgnore
    private Usuario personaCTNEWBENEFDESDEAEptUsuarioInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkPersonaCTNEWBENEFDESDEAEptBeneficiario();
        checkPersonaCTNEWBENEFDESDEAEptUsuario();
    }

    @JsonIgnore
    public BeneficiarioCOid getPersonaCTNEWBENEFDESDEAEptBeneficiario() {
        return this.personaCTNEWBENEFDESDEAEptBeneficiario;
    }
    
    public void setPersonaCTNEWBENEFDESDEAEptBeneficiario(BeneficiarioCOid personaCTNEWBENEFDESDEAEptBeneficiario) {
        this.personaCTNEWBENEFDESDEAEptBeneficiario = personaCTNEWBENEFDESDEAEptBeneficiario;
    }

    @JsonIgnore
    public BeneficiarioC getPersonaCTNEWBENEFDESDEAEptBeneficiarioInstance() {
        return this.personaCTNEWBENEFDESDEAEptBeneficiarioInstance;
    }
    
    public void setPersonaCTNEWBENEFDESDEAEptBeneficiarioInstance(BeneficiarioC personaCTNEWBENEFDESDEAEptBeneficiario) {
        this.personaCTNEWBENEFDESDEAEptBeneficiarioInstance = personaCTNEWBENEFDESDEAEptBeneficiario;
        this.personaCTNEWBENEFDESDEAEptBeneficiario = personaCTNEWBENEFDESDEAEptBeneficiario != null ? personaCTNEWBENEFDESDEAEptBeneficiario.getOid() : null;
    }

    private void checkPersonaCTNEWBENEFDESDEAEptBeneficiario() throws NotNullArgumentException {
        if(this.getPersonaCTNEWBENEFDESDEAEptBeneficiarioInstance() == null || this.getPersonaCTNEWBENEFDESDEAEptBeneficiarioInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_TNEWBENEFDESDEAE, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_TNEWBENEFDESDEAE_PERSONACTNEWBENEFDESDEAEPTBENEFICIARIO, PersonaCConstants.SERV_ALIAS_TNEWBENEFDESDEAE, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_TNEWBENEFDESDEAE_PERSONACTNEWBENEFDESDEAEPTBENEFICIARIO);
        }
    }

    @JsonIgnore
    public UsuarioOid getPersonaCTNEWBENEFDESDEAEptUsuario() {
        return this.personaCTNEWBENEFDESDEAEptUsuario;
    }
    
    public void setPersonaCTNEWBENEFDESDEAEptUsuario(UsuarioOid personaCTNEWBENEFDESDEAEptUsuario) {
        this.personaCTNEWBENEFDESDEAEptUsuario = personaCTNEWBENEFDESDEAEptUsuario;
    }

    @JsonIgnore
    public Usuario getPersonaCTNEWBENEFDESDEAEptUsuarioInstance() {
        return this.personaCTNEWBENEFDESDEAEptUsuarioInstance;
    }
    
    public void setPersonaCTNEWBENEFDESDEAEptUsuarioInstance(Usuario personaCTNEWBENEFDESDEAEptUsuario) {
        this.personaCTNEWBENEFDESDEAEptUsuarioInstance = personaCTNEWBENEFDESDEAEptUsuario;
        this.personaCTNEWBENEFDESDEAEptUsuario = personaCTNEWBENEFDESDEAEptUsuario != null ? personaCTNEWBENEFDESDEAEptUsuario.getOid() : null;
    }

    private void checkPersonaCTNEWBENEFDESDEAEptUsuario() throws NotNullArgumentException {
        if(this.getPersonaCTNEWBENEFDESDEAEptUsuarioInstance() == null || this.getPersonaCTNEWBENEFDESDEAEptUsuarioInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_TNEWBENEFDESDEAE, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_TNEWBENEFDESDEAE_PERSONACTNEWBENEFDESDEAEPTUSUARIO, PersonaCConstants.SERV_ALIAS_TNEWBENEFDESDEAE, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_TNEWBENEFDESDEAE_PERSONACTNEWBENEFDESDEAEPTUSUARIO);
        }
    }
}
