package com.keralty.aesolicitudes.viewmodel.departamento.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DepartamentoConstants;
import com.keralty.aesolicitudes.persistence.Departamento;
import com.keralty.aesolicitudes.persistence.oid.DepartamentoOid;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.PersonaC;

public class DelDepartamentoCNacRequest {

    @JsonProperty("p_thisdepartamento_oid")
    private DepartamentoOid departamentoDelDepartamentoCNacpthisDepartamento;
    
    @JsonIgnore
    private Departamento departamentoDelDepartamentoCNacpthisDepartamentoInstance;

    @JsonProperty("p_evcpersonac_oid")
    private PersonaCOid departamentoDelDepartamentoCNacpevcPersonaC;
    
    @JsonIgnore
    private PersonaC departamentoDelDepartamentoCNacpevcPersonaCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkDepartamentoDelDepartamentoCNacpthisDepartamento();
        checkDepartamentoDelDepartamentoCNacpevcPersonaC();
    }

    @JsonIgnore
    public DepartamentoOid getDepartamentoDelDepartamentoCNacpthisDepartamento() {
        return this.departamentoDelDepartamentoCNacpthisDepartamento;
    }
    
    public void setDepartamentoDelDepartamentoCNacpthisDepartamento(DepartamentoOid departamentoDelDepartamentoCNacpthisDepartamento) {
        this.departamentoDelDepartamentoCNacpthisDepartamento = departamentoDelDepartamentoCNacpthisDepartamento;
    }

    @JsonIgnore
    public Departamento getDepartamentoDelDepartamentoCNacpthisDepartamentoInstance() {
        return this.departamentoDelDepartamentoCNacpthisDepartamentoInstance;
    }
    
    public void setDepartamentoDelDepartamentoCNacpthisDepartamentoInstance(Departamento departamentoDelDepartamentoCNacpthisDepartamento) {
        this.departamentoDelDepartamentoCNacpthisDepartamentoInstance = departamentoDelDepartamentoCNacpthisDepartamento;
        this.departamentoDelDepartamentoCNacpthisDepartamento = departamentoDelDepartamentoCNacpthisDepartamento != null ? departamentoDelDepartamentoCNacpthisDepartamento.getOid() : null;
    }

    private void checkDepartamentoDelDepartamentoCNacpthisDepartamento() throws NotNullArgumentException {
        if(this.getDepartamentoDelDepartamentoCNacpthisDepartamentoInstance() == null || this.getDepartamentoDelDepartamentoCNacpthisDepartamentoInstance().isNull()) {
            throw new NotNullArgumentException(DepartamentoConstants.SERV_ID_DELDEPARTAMENTOCNAC, DepartamentoConstants.CLASS_ID, DepartamentoConstants.ARG_ID_DELDEPARTAMENTOCNAC_DEPARTAMENTODELDEPARTAMENTOCNACPTHISDEPARTAMENTO, DepartamentoConstants.SERV_ALIAS_DELDEPARTAMENTOCNAC, DepartamentoConstants.CLASS_ALIAS, DepartamentoConstants.ARG_ALIAS_DELDEPARTAMENTOCNAC_DEPARTAMENTODELDEPARTAMENTOCNACPTHISDEPARTAMENTO);
        }
    }

    @JsonIgnore
    public PersonaCOid getDepartamentoDelDepartamentoCNacpevcPersonaC() {
        return this.departamentoDelDepartamentoCNacpevcPersonaC;
    }
    
    public void setDepartamentoDelDepartamentoCNacpevcPersonaC(PersonaCOid departamentoDelDepartamentoCNacpevcPersonaC) {
        this.departamentoDelDepartamentoCNacpevcPersonaC = departamentoDelDepartamentoCNacpevcPersonaC;
    }

    @JsonIgnore
    public PersonaC getDepartamentoDelDepartamentoCNacpevcPersonaCInstance() {
        return this.departamentoDelDepartamentoCNacpevcPersonaCInstance;
    }
    
    public void setDepartamentoDelDepartamentoCNacpevcPersonaCInstance(PersonaC departamentoDelDepartamentoCNacpevcPersonaC) {
        this.departamentoDelDepartamentoCNacpevcPersonaCInstance = departamentoDelDepartamentoCNacpevcPersonaC;
        this.departamentoDelDepartamentoCNacpevcPersonaC = departamentoDelDepartamentoCNacpevcPersonaC != null ? departamentoDelDepartamentoCNacpevcPersonaC.getOid() : null;
    }

    private void checkDepartamentoDelDepartamentoCNacpevcPersonaC() throws NotNullArgumentException {
        if(this.getDepartamentoDelDepartamentoCNacpevcPersonaCInstance() == null || this.getDepartamentoDelDepartamentoCNacpevcPersonaCInstance().isNull()) {
            throw new NotNullArgumentException(DepartamentoConstants.SERV_ID_DELDEPARTAMENTOCNAC, DepartamentoConstants.CLASS_ID, DepartamentoConstants.ARG_ID_DELDEPARTAMENTOCNAC_DEPARTAMENTODELDEPARTAMENTOCNACPEVCPERSONAC, DepartamentoConstants.SERV_ALIAS_DELDEPARTAMENTOCNAC, DepartamentoConstants.CLASS_ALIAS, DepartamentoConstants.ARG_ALIAS_DELDEPARTAMENTOCNAC_DEPARTAMENTODELDEPARTAMENTOCNACPEVCPERSONAC);
        }
    }
}
