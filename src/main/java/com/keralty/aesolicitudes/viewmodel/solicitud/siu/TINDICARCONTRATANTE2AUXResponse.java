package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.oid.PersonaOid;
import com.keralty.aesolicitudes.persistence.Persona;
import com.keralty.aesolicitudes.viewmodel.ServiceResponse;
import java.util.HashMap;
import java.util.Map;

public class TINDICARCONTRATANTE2AUXResponse extends ServiceResponse {


    @JsonProperty("pspersona")
    private PersonaOid solicitudTINDICARCONTRATANTE2AUXpsPersona;
    
    @JsonIgnore
    private Persona solicitudTINDICARCONTRATANTE2AUXpsPersonaInstance;

    public TINDICARCONTRATANTE2AUXResponse() {
        super();
    }

    @JsonIgnore
    public PersonaOid getSolicitudTINDICARCONTRATANTE2AUXpsPersona() {
        return this.solicitudTINDICARCONTRATANTE2AUXpsPersona;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXpsPersona(PersonaOid solicitudTINDICARCONTRATANTE2AUXpsPersona) {
        this.solicitudTINDICARCONTRATANTE2AUXpsPersona = solicitudTINDICARCONTRATANTE2AUXpsPersona;
    }
    @JsonIgnore
    public Persona getSolicitudTINDICARCONTRATANTE2AUXpsPersonaInstance() {
        return this.solicitudTINDICARCONTRATANTE2AUXpsPersonaInstance;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXpsPersonaInstance(Persona solicitudTINDICARCONTRATANTE2AUXpsPersona) {
        if (solicitudTINDICARCONTRATANTE2AUXpsPersona != null && !solicitudTINDICARCONTRATANTE2AUXpsPersona.isNull()) {
            this.solicitudTINDICARCONTRATANTE2AUXpsPersona = solicitudTINDICARCONTRATANTE2AUXpsPersona.getOid();
            this.solicitudTINDICARCONTRATANTE2AUXpsPersonaInstance = solicitudTINDICARCONTRATANTE2AUXpsPersona;
        } else {
            this.solicitudTINDICARCONTRATANTE2AUXpsPersona = null;
            this.solicitudTINDICARCONTRATANTE2AUXpsPersonaInstance = null;
        }
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("solicitudTINDICARCONTRATANTE2AUXpsPersona", solicitudTINDICARCONTRATANTE2AUXpsPersona);
        return outArgs;
    }
}
