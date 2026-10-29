package com.keralty.aesolicitudes.viewmodel.estadocivil.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.EstadoCivilConstants;
import com.keralty.aesolicitudes.persistence.EstadoCivil;
import com.keralty.aesolicitudes.persistence.oid.EstadoCivilOid;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.PersonaC;

public class InsEstadoCivilCRequest {

    @JsonProperty("p_thisestadocivil_oid")
    private EstadoCivilOid estadoCivilInsEstadoCivilCpthisEstadoCivil;
    
    @JsonIgnore
    private EstadoCivil estadoCivilInsEstadoCivilCpthisEstadoCivilInstance;

    @JsonProperty("p_evcpersonac_oid")
    private PersonaCOid estadoCivilInsEstadoCivilCpevcPersonaC;
    
    @JsonIgnore
    private PersonaC estadoCivilInsEstadoCivilCpevcPersonaCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkEstadoCivilInsEstadoCivilCpthisEstadoCivil();
        checkEstadoCivilInsEstadoCivilCpevcPersonaC();
    }

    @JsonIgnore
    public EstadoCivilOid getEstadoCivilInsEstadoCivilCpthisEstadoCivil() {
        return this.estadoCivilInsEstadoCivilCpthisEstadoCivil;
    }
    
    public void setEstadoCivilInsEstadoCivilCpthisEstadoCivil(EstadoCivilOid estadoCivilInsEstadoCivilCpthisEstadoCivil) {
        this.estadoCivilInsEstadoCivilCpthisEstadoCivil = estadoCivilInsEstadoCivilCpthisEstadoCivil;
    }

    @JsonIgnore
    public EstadoCivil getEstadoCivilInsEstadoCivilCpthisEstadoCivilInstance() {
        return this.estadoCivilInsEstadoCivilCpthisEstadoCivilInstance;
    }
    
    public void setEstadoCivilInsEstadoCivilCpthisEstadoCivilInstance(EstadoCivil estadoCivilInsEstadoCivilCpthisEstadoCivil) {
        this.estadoCivilInsEstadoCivilCpthisEstadoCivilInstance = estadoCivilInsEstadoCivilCpthisEstadoCivil;
        this.estadoCivilInsEstadoCivilCpthisEstadoCivil = estadoCivilInsEstadoCivilCpthisEstadoCivil != null ? estadoCivilInsEstadoCivilCpthisEstadoCivil.getOid() : null;
    }

    private void checkEstadoCivilInsEstadoCivilCpthisEstadoCivil() throws NotNullArgumentException {
        if(this.getEstadoCivilInsEstadoCivilCpthisEstadoCivilInstance() == null || this.getEstadoCivilInsEstadoCivilCpthisEstadoCivilInstance().isNull()) {
            throw new NotNullArgumentException(EstadoCivilConstants.SERV_ID_INSESTADOCIVILC, EstadoCivilConstants.CLASS_ID, EstadoCivilConstants.ARG_ID_INSESTADOCIVILC_ESTADOCIVILINSESTADOCIVILCPTHISESTADOCIVIL, EstadoCivilConstants.SERV_ALIAS_INSESTADOCIVILC, EstadoCivilConstants.CLASS_ALIAS, EstadoCivilConstants.ARG_ALIAS_INSESTADOCIVILC_ESTADOCIVILINSESTADOCIVILCPTHISESTADOCIVIL);
        }
    }

    @JsonIgnore
    public PersonaCOid getEstadoCivilInsEstadoCivilCpevcPersonaC() {
        return this.estadoCivilInsEstadoCivilCpevcPersonaC;
    }
    
    public void setEstadoCivilInsEstadoCivilCpevcPersonaC(PersonaCOid estadoCivilInsEstadoCivilCpevcPersonaC) {
        this.estadoCivilInsEstadoCivilCpevcPersonaC = estadoCivilInsEstadoCivilCpevcPersonaC;
    }

    @JsonIgnore
    public PersonaC getEstadoCivilInsEstadoCivilCpevcPersonaCInstance() {
        return this.estadoCivilInsEstadoCivilCpevcPersonaCInstance;
    }
    
    public void setEstadoCivilInsEstadoCivilCpevcPersonaCInstance(PersonaC estadoCivilInsEstadoCivilCpevcPersonaC) {
        this.estadoCivilInsEstadoCivilCpevcPersonaCInstance = estadoCivilInsEstadoCivilCpevcPersonaC;
        this.estadoCivilInsEstadoCivilCpevcPersonaC = estadoCivilInsEstadoCivilCpevcPersonaC != null ? estadoCivilInsEstadoCivilCpevcPersonaC.getOid() : null;
    }

    private void checkEstadoCivilInsEstadoCivilCpevcPersonaC() throws NotNullArgumentException {
        if(this.getEstadoCivilInsEstadoCivilCpevcPersonaCInstance() == null || this.getEstadoCivilInsEstadoCivilCpevcPersonaCInstance().isNull()) {
            throw new NotNullArgumentException(EstadoCivilConstants.SERV_ID_INSESTADOCIVILC, EstadoCivilConstants.CLASS_ID, EstadoCivilConstants.ARG_ID_INSESTADOCIVILC_ESTADOCIVILINSESTADOCIVILCPEVCPERSONAC, EstadoCivilConstants.SERV_ALIAS_INSESTADOCIVILC, EstadoCivilConstants.CLASS_ALIAS, EstadoCivilConstants.ARG_ALIAS_INSESTADOCIVILC_ESTADOCIVILINSESTADOCIVILCPEVCPERSONAC);
        }
    }
}
