package com.keralty.aesolicitudes.viewmodel.preguntap.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.PreguntaPConstants;
import com.keralty.aesolicitudes.persistence.oid.PreguntaPOid;
import com.keralty.aesolicitudes.persistence.PreguntaP;

public class TELIMINARRequest {

    @JsonProperty("p_thispreguntap_oid")
    private PreguntaPOid preguntaPTELIMINARpthisPreguntaP;
    
    @JsonIgnore
    private PreguntaP preguntaPTELIMINARpthisPreguntaPInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkPreguntaPTELIMINARpthisPreguntaP();
    }

    @JsonIgnore
    public PreguntaPOid getPreguntaPTELIMINARpthisPreguntaP() {
        return this.preguntaPTELIMINARpthisPreguntaP;
    }
    
    public void setPreguntaPTELIMINARpthisPreguntaP(PreguntaPOid preguntaPTELIMINARpthisPreguntaP) {
        this.preguntaPTELIMINARpthisPreguntaP = preguntaPTELIMINARpthisPreguntaP;
    }

    @JsonIgnore
    public PreguntaP getPreguntaPTELIMINARpthisPreguntaPInstance() {
        return this.preguntaPTELIMINARpthisPreguntaPInstance;
    }
    
    public void setPreguntaPTELIMINARpthisPreguntaPInstance(PreguntaP preguntaPTELIMINARpthisPreguntaP) {
        this.preguntaPTELIMINARpthisPreguntaPInstance = preguntaPTELIMINARpthisPreguntaP;
        this.preguntaPTELIMINARpthisPreguntaP = preguntaPTELIMINARpthisPreguntaP != null ? preguntaPTELIMINARpthisPreguntaP.getOid() : null;
    }

    private void checkPreguntaPTELIMINARpthisPreguntaP() throws NotNullArgumentException {
        if(this.getPreguntaPTELIMINARpthisPreguntaPInstance() == null || this.getPreguntaPTELIMINARpthisPreguntaPInstance().isNull()) {
            throw new NotNullArgumentException(PreguntaPConstants.SERV_ID_TELIMINAR, PreguntaPConstants.CLASS_ID, PreguntaPConstants.ARG_ID_TELIMINAR_PREGUNTAPTELIMINARPTHISPREGUNTAP, PreguntaPConstants.SERV_ALIAS_TELIMINAR, PreguntaPConstants.CLASS_ALIAS, PreguntaPConstants.ARG_ALIAS_TELIMINAR_PREGUNTAPTELIMINARPTHISPREGUNTAP);
        }
    }
}
