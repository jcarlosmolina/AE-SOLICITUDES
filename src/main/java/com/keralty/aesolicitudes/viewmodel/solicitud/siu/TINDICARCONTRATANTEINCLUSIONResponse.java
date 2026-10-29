package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.oid.PersonaOid;
import com.keralty.aesolicitudes.persistence.Persona;
import com.keralty.aesolicitudes.viewmodel.ServiceResponse;
import java.util.HashMap;
import java.util.Map;

public class TINDICARCONTRATANTEINCLUSIONResponse extends ServiceResponse {


    @JsonProperty("pspersona")
    private PersonaOid solicitudTINDICARCONTRATANTEINCLUSIONpsPersona;
    
    @JsonIgnore
    private Persona solicitudTINDICARCONTRATANTEINCLUSIONpsPersonaInstance;

    public TINDICARCONTRATANTEINCLUSIONResponse() {
        super();
    }

    @JsonIgnore
    public PersonaOid getSolicitudTINDICARCONTRATANTEINCLUSIONpsPersona() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONpsPersona;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONpsPersona(PersonaOid solicitudTINDICARCONTRATANTEINCLUSIONpsPersona) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONpsPersona = solicitudTINDICARCONTRATANTEINCLUSIONpsPersona;
    }
    @JsonIgnore
    public Persona getSolicitudTINDICARCONTRATANTEINCLUSIONpsPersonaInstance() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONpsPersonaInstance;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONpsPersonaInstance(Persona solicitudTINDICARCONTRATANTEINCLUSIONpsPersona) {
        if (solicitudTINDICARCONTRATANTEINCLUSIONpsPersona != null && !solicitudTINDICARCONTRATANTEINCLUSIONpsPersona.isNull()) {
            this.solicitudTINDICARCONTRATANTEINCLUSIONpsPersona = solicitudTINDICARCONTRATANTEINCLUSIONpsPersona.getOid();
            this.solicitudTINDICARCONTRATANTEINCLUSIONpsPersonaInstance = solicitudTINDICARCONTRATANTEINCLUSIONpsPersona;
        } else {
            this.solicitudTINDICARCONTRATANTEINCLUSIONpsPersona = null;
            this.solicitudTINDICARCONTRATANTEINCLUSIONpsPersonaInstance = null;
        }
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("solicitudTINDICARCONTRATANTEINCLUSIONpsPersona", solicitudTINDICARCONTRATANTEINCLUSIONpsPersona);
        return outArgs;
    }
}
