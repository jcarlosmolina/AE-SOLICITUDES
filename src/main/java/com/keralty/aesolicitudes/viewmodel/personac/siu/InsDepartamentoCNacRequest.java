package com.keralty.aesolicitudes.viewmodel.personac.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.PersonaCConstants;
import com.keralty.aesolicitudes.persistence.Departamento;
import com.keralty.aesolicitudes.persistence.oid.DepartamentoOid;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.PersonaC;

public class InsDepartamentoCNacRequest {

    @JsonProperty("p_thispersonac_oid")
    private PersonaCOid personaCInsDepartamentoCNacpthisPersonaC;
    
    @JsonIgnore
    private PersonaC personaCInsDepartamentoCNacpthisPersonaCInstance;

    @JsonProperty("p_evcdepartamento_oid")
    private DepartamentoOid personaCInsDepartamentoCNacpevcDepartamento;
    
    @JsonIgnore
    private Departamento personaCInsDepartamentoCNacpevcDepartamentoInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkPersonaCInsDepartamentoCNacpthisPersonaC();
        checkPersonaCInsDepartamentoCNacpevcDepartamento();
    }

    @JsonIgnore
    public PersonaCOid getPersonaCInsDepartamentoCNacpthisPersonaC() {
        return this.personaCInsDepartamentoCNacpthisPersonaC;
    }
    
    public void setPersonaCInsDepartamentoCNacpthisPersonaC(PersonaCOid personaCInsDepartamentoCNacpthisPersonaC) {
        this.personaCInsDepartamentoCNacpthisPersonaC = personaCInsDepartamentoCNacpthisPersonaC;
    }

    @JsonIgnore
    public PersonaC getPersonaCInsDepartamentoCNacpthisPersonaCInstance() {
        return this.personaCInsDepartamentoCNacpthisPersonaCInstance;
    }
    
    public void setPersonaCInsDepartamentoCNacpthisPersonaCInstance(PersonaC personaCInsDepartamentoCNacpthisPersonaC) {
        this.personaCInsDepartamentoCNacpthisPersonaCInstance = personaCInsDepartamentoCNacpthisPersonaC;
        this.personaCInsDepartamentoCNacpthisPersonaC = personaCInsDepartamentoCNacpthisPersonaC != null ? personaCInsDepartamentoCNacpthisPersonaC.getOid() : null;
    }

    private void checkPersonaCInsDepartamentoCNacpthisPersonaC() throws NotNullArgumentException {
        if(this.getPersonaCInsDepartamentoCNacpthisPersonaCInstance() == null || this.getPersonaCInsDepartamentoCNacpthisPersonaCInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_INSDEPARTAMENTOCNAC, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_INSDEPARTAMENTOCNAC_PERSONACINSDEPARTAMENTOCNACPTHISPERSONAC, PersonaCConstants.SERV_ALIAS_INSDEPARTAMENTOCNAC, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_INSDEPARTAMENTOCNAC_PERSONACINSDEPARTAMENTOCNACPTHISPERSONAC);
        }
    }

    @JsonIgnore
    public DepartamentoOid getPersonaCInsDepartamentoCNacpevcDepartamento() {
        return this.personaCInsDepartamentoCNacpevcDepartamento;
    }
    
    public void setPersonaCInsDepartamentoCNacpevcDepartamento(DepartamentoOid personaCInsDepartamentoCNacpevcDepartamento) {
        this.personaCInsDepartamentoCNacpevcDepartamento = personaCInsDepartamentoCNacpevcDepartamento;
    }

    @JsonIgnore
    public Departamento getPersonaCInsDepartamentoCNacpevcDepartamentoInstance() {
        return this.personaCInsDepartamentoCNacpevcDepartamentoInstance;
    }
    
    public void setPersonaCInsDepartamentoCNacpevcDepartamentoInstance(Departamento personaCInsDepartamentoCNacpevcDepartamento) {
        this.personaCInsDepartamentoCNacpevcDepartamentoInstance = personaCInsDepartamentoCNacpevcDepartamento;
        this.personaCInsDepartamentoCNacpevcDepartamento = personaCInsDepartamentoCNacpevcDepartamento != null ? personaCInsDepartamentoCNacpevcDepartamento.getOid() : null;
    }

    private void checkPersonaCInsDepartamentoCNacpevcDepartamento() throws NotNullArgumentException {
        if(this.getPersonaCInsDepartamentoCNacpevcDepartamentoInstance() == null || this.getPersonaCInsDepartamentoCNacpevcDepartamentoInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_INSDEPARTAMENTOCNAC, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_INSDEPARTAMENTOCNAC_PERSONACINSDEPARTAMENTOCNACPEVCDEPARTAMENTO, PersonaCConstants.SERV_ALIAS_INSDEPARTAMENTOCNAC, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_INSDEPARTAMENTOCNAC_PERSONACINSDEPARTAMENTOCNACPEVCDEPARTAMENTO);
        }
    }
}
