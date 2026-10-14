package com.keralty.aesolicitudes.viewmodel.persona.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.PersonaConstants;
import com.keralty.aesolicitudes.persistence.Departamento;
import com.keralty.aesolicitudes.persistence.oid.DepartamentoOid;
import com.keralty.aesolicitudes.persistence.oid.PersonaOid;
import com.keralty.aesolicitudes.persistence.Persona;

public class InsDptoNacimientoPersonaRequest {

    @JsonProperty("p_thispersona_oid")
    private PersonaOid personaInsDptoNacimientoPersonapthisPersona;
    
    @JsonIgnore
    private Persona personaInsDptoNacimientoPersonapthisPersonaInstance;

    @JsonProperty("p_evcdepartamento_oid")
    private DepartamentoOid personaInsDptoNacimientoPersonapevcDepartamento;
    
    @JsonIgnore
    private Departamento personaInsDptoNacimientoPersonapevcDepartamentoInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkPersonaInsDptoNacimientoPersonapthisPersona();
        checkPersonaInsDptoNacimientoPersonapevcDepartamento();
    }

    @JsonIgnore
    public PersonaOid getPersonaInsDptoNacimientoPersonapthisPersona() {
        return this.personaInsDptoNacimientoPersonapthisPersona;
    }
    
    public void setPersonaInsDptoNacimientoPersonapthisPersona(PersonaOid personaInsDptoNacimientoPersonapthisPersona) {
        this.personaInsDptoNacimientoPersonapthisPersona = personaInsDptoNacimientoPersonapthisPersona;
    }

    @JsonIgnore
    public Persona getPersonaInsDptoNacimientoPersonapthisPersonaInstance() {
        return this.personaInsDptoNacimientoPersonapthisPersonaInstance;
    }
    
    public void setPersonaInsDptoNacimientoPersonapthisPersonaInstance(Persona personaInsDptoNacimientoPersonapthisPersona) {
        this.personaInsDptoNacimientoPersonapthisPersonaInstance = personaInsDptoNacimientoPersonapthisPersona;
        this.personaInsDptoNacimientoPersonapthisPersona = personaInsDptoNacimientoPersonapthisPersona != null ? personaInsDptoNacimientoPersonapthisPersona.getOid() : null;
    }

    private void checkPersonaInsDptoNacimientoPersonapthisPersona() throws NotNullArgumentException {
        if(this.getPersonaInsDptoNacimientoPersonapthisPersonaInstance() == null || this.getPersonaInsDptoNacimientoPersonapthisPersonaInstance().isNull()) {
            throw new NotNullArgumentException(PersonaConstants.SERV_ID_INSDPTONACIMIENTOPERSONA, PersonaConstants.CLASS_ID, PersonaConstants.ARG_ID_INSDPTONACIMIENTOPERSONA_PERSONAINSDPTONACIMIENTOPERSONAPTHISPERSONA, PersonaConstants.SERV_ALIAS_INSDPTONACIMIENTOPERSONA, PersonaConstants.CLASS_ALIAS, PersonaConstants.ARG_ALIAS_INSDPTONACIMIENTOPERSONA_PERSONAINSDPTONACIMIENTOPERSONAPTHISPERSONA);
        }
    }

    @JsonIgnore
    public DepartamentoOid getPersonaInsDptoNacimientoPersonapevcDepartamento() {
        return this.personaInsDptoNacimientoPersonapevcDepartamento;
    }
    
    public void setPersonaInsDptoNacimientoPersonapevcDepartamento(DepartamentoOid personaInsDptoNacimientoPersonapevcDepartamento) {
        this.personaInsDptoNacimientoPersonapevcDepartamento = personaInsDptoNacimientoPersonapevcDepartamento;
    }

    @JsonIgnore
    public Departamento getPersonaInsDptoNacimientoPersonapevcDepartamentoInstance() {
        return this.personaInsDptoNacimientoPersonapevcDepartamentoInstance;
    }
    
    public void setPersonaInsDptoNacimientoPersonapevcDepartamentoInstance(Departamento personaInsDptoNacimientoPersonapevcDepartamento) {
        this.personaInsDptoNacimientoPersonapevcDepartamentoInstance = personaInsDptoNacimientoPersonapevcDepartamento;
        this.personaInsDptoNacimientoPersonapevcDepartamento = personaInsDptoNacimientoPersonapevcDepartamento != null ? personaInsDptoNacimientoPersonapevcDepartamento.getOid() : null;
    }

    private void checkPersonaInsDptoNacimientoPersonapevcDepartamento() throws NotNullArgumentException {
        if(this.getPersonaInsDptoNacimientoPersonapevcDepartamentoInstance() == null || this.getPersonaInsDptoNacimientoPersonapevcDepartamentoInstance().isNull()) {
            throw new NotNullArgumentException(PersonaConstants.SERV_ID_INSDPTONACIMIENTOPERSONA, PersonaConstants.CLASS_ID, PersonaConstants.ARG_ID_INSDPTONACIMIENTOPERSONA_PERSONAINSDPTONACIMIENTOPERSONAPEVCDEPARTAMENTO, PersonaConstants.SERV_ALIAS_INSDPTONACIMIENTOPERSONA, PersonaConstants.CLASS_ALIAS, PersonaConstants.ARG_ALIAS_INSDPTONACIMIENTOPERSONA_PERSONAINSDPTONACIMIENTOPERSONAPEVCDEPARTAMENTO);
        }
    }
}
