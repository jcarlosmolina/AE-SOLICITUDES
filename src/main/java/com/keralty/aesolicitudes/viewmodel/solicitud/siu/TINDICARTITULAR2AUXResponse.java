package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.oid.PersonaOid;
import com.keralty.aesolicitudes.persistence.Persona;
import com.keralty.aesolicitudes.viewmodel.ServiceResponse;
import java.util.HashMap;
import java.util.Map;

public class TINDICARTITULAR2AUXResponse extends ServiceResponse {


    @JsonProperty("pt_pspersona")
    private PersonaOid solicitudTINDICARTITULAR2AUXptpsPersona;
    
    @JsonIgnore
    private Persona solicitudTINDICARTITULAR2AUXptpsPersonaInstance;

    public TINDICARTITULAR2AUXResponse() {
        super();
    }

    @JsonIgnore
    public PersonaOid getSolicitudTINDICARTITULAR2AUXptpsPersona() {
        return this.solicitudTINDICARTITULAR2AUXptpsPersona;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptpsPersona(PersonaOid solicitudTINDICARTITULAR2AUXptpsPersona) {
        this.solicitudTINDICARTITULAR2AUXptpsPersona = solicitudTINDICARTITULAR2AUXptpsPersona;
    }
    @JsonIgnore
    public Persona getSolicitudTINDICARTITULAR2AUXptpsPersonaInstance() {
        return this.solicitudTINDICARTITULAR2AUXptpsPersonaInstance;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptpsPersonaInstance(Persona solicitudTINDICARTITULAR2AUXptpsPersona) {
        if (solicitudTINDICARTITULAR2AUXptpsPersona != null && !solicitudTINDICARTITULAR2AUXptpsPersona.isNull()) {
            this.solicitudTINDICARTITULAR2AUXptpsPersona = solicitudTINDICARTITULAR2AUXptpsPersona.getOid();
            this.solicitudTINDICARTITULAR2AUXptpsPersonaInstance = solicitudTINDICARTITULAR2AUXptpsPersona;
        } else {
            this.solicitudTINDICARTITULAR2AUXptpsPersona = null;
            this.solicitudTINDICARTITULAR2AUXptpsPersonaInstance = null;
        }
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("solicitudTINDICARTITULAR2AUXptpsPersona", solicitudTINDICARTITULAR2AUXptpsPersona);
        return outArgs;
    }
}
