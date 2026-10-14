package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.oid.PersonaOid;
import com.keralty.aesolicitudes.persistence.Persona;
import com.keralty.aesolicitudes.viewmodel.ServiceResponse;
import java.util.HashMap;
import java.util.Map;

public class TINDICARTITULARINCLUSIONResponse extends ServiceResponse {


    @JsonProperty("pt_pspersona")
    private PersonaOid solicitudTINDICARTITULARINCLUSIONptpsPersona;
    
    @JsonIgnore
    private Persona solicitudTINDICARTITULARINCLUSIONptpsPersonaInstance;

    public TINDICARTITULARINCLUSIONResponse() {
        super();
    }

    @JsonIgnore
    public PersonaOid getSolicitudTINDICARTITULARINCLUSIONptpsPersona() {
        return this.solicitudTINDICARTITULARINCLUSIONptpsPersona;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptpsPersona(PersonaOid solicitudTINDICARTITULARINCLUSIONptpsPersona) {
        this.solicitudTINDICARTITULARINCLUSIONptpsPersona = solicitudTINDICARTITULARINCLUSIONptpsPersona;
    }
    @JsonIgnore
    public Persona getSolicitudTINDICARTITULARINCLUSIONptpsPersonaInstance() {
        return this.solicitudTINDICARTITULARINCLUSIONptpsPersonaInstance;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptpsPersonaInstance(Persona solicitudTINDICARTITULARINCLUSIONptpsPersona) {
        if (solicitudTINDICARTITULARINCLUSIONptpsPersona != null && !solicitudTINDICARTITULARINCLUSIONptpsPersona.isNull()) {
            this.solicitudTINDICARTITULARINCLUSIONptpsPersona = solicitudTINDICARTITULARINCLUSIONptpsPersona.getOid();
            this.solicitudTINDICARTITULARINCLUSIONptpsPersonaInstance = solicitudTINDICARTITULARINCLUSIONptpsPersona;
        } else {
            this.solicitudTINDICARTITULARINCLUSIONptpsPersona = null;
            this.solicitudTINDICARTITULARINCLUSIONptpsPersonaInstance = null;
        }
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("solicitudTINDICARTITULARINCLUSIONptpsPersona", solicitudTINDICARTITULARINCLUSIONptpsPersona);
        return outArgs;
    }
}
