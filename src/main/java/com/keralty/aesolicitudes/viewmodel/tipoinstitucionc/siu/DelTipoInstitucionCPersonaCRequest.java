package com.keralty.aesolicitudes.viewmodel.tipoinstitucionc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.TipoInstitucionCConstants;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.oid.TipoInstitucionCOid;
import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.TipoInstitucionC;

public class DelTipoInstitucionCPersonaCRequest {

    @JsonProperty("p_thistipoinstitucionc_oid")
    private TipoInstitucionCOid tipoInstitucionCDelTipoInstitucionCPersonaCpthisTipoInstitucionC;
    
    @JsonIgnore
    private TipoInstitucionC tipoInstitucionCDelTipoInstitucionCPersonaCpthisTipoInstitucionCInstance;

    @JsonProperty("p_evcpersonac_oid")
    private PersonaCOid tipoInstitucionCDelTipoInstitucionCPersonaCpevcPersonaC;
    
    @JsonIgnore
    private PersonaC tipoInstitucionCDelTipoInstitucionCPersonaCpevcPersonaCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkTipoInstitucionCDelTipoInstitucionCPersonaCpthisTipoInstitucionC();
        checkTipoInstitucionCDelTipoInstitucionCPersonaCpevcPersonaC();
    }

    @JsonIgnore
    public TipoInstitucionCOid getTipoInstitucionCDelTipoInstitucionCPersonaCpthisTipoInstitucionC() {
        return this.tipoInstitucionCDelTipoInstitucionCPersonaCpthisTipoInstitucionC;
    }
    
    public void setTipoInstitucionCDelTipoInstitucionCPersonaCpthisTipoInstitucionC(TipoInstitucionCOid tipoInstitucionCDelTipoInstitucionCPersonaCpthisTipoInstitucionC) {
        this.tipoInstitucionCDelTipoInstitucionCPersonaCpthisTipoInstitucionC = tipoInstitucionCDelTipoInstitucionCPersonaCpthisTipoInstitucionC;
    }

    @JsonIgnore
    public TipoInstitucionC getTipoInstitucionCDelTipoInstitucionCPersonaCpthisTipoInstitucionCInstance() {
        return this.tipoInstitucionCDelTipoInstitucionCPersonaCpthisTipoInstitucionCInstance;
    }
    
    public void setTipoInstitucionCDelTipoInstitucionCPersonaCpthisTipoInstitucionCInstance(TipoInstitucionC tipoInstitucionCDelTipoInstitucionCPersonaCpthisTipoInstitucionC) {
        this.tipoInstitucionCDelTipoInstitucionCPersonaCpthisTipoInstitucionCInstance = tipoInstitucionCDelTipoInstitucionCPersonaCpthisTipoInstitucionC;
        this.tipoInstitucionCDelTipoInstitucionCPersonaCpthisTipoInstitucionC = tipoInstitucionCDelTipoInstitucionCPersonaCpthisTipoInstitucionC != null ? tipoInstitucionCDelTipoInstitucionCPersonaCpthisTipoInstitucionC.getOid() : null;
    }

    private void checkTipoInstitucionCDelTipoInstitucionCPersonaCpthisTipoInstitucionC() throws NotNullArgumentException {
        if(this.getTipoInstitucionCDelTipoInstitucionCPersonaCpthisTipoInstitucionCInstance() == null || this.getTipoInstitucionCDelTipoInstitucionCPersonaCpthisTipoInstitucionCInstance().isNull()) {
            throw new NotNullArgumentException(TipoInstitucionCConstants.SERV_ID_DELTIPOINSTITUCIONCPERSONAC, TipoInstitucionCConstants.CLASS_ID, TipoInstitucionCConstants.ARG_ID_DELTIPOINSTITUCIONCPERSONAC_TIPOINSTITUCIONCDELTIPOINSTITUCIONCPERSONACPTHISTIPOINSTITUCIONC, TipoInstitucionCConstants.SERV_ALIAS_DELTIPOINSTITUCIONCPERSONAC, TipoInstitucionCConstants.CLASS_ALIAS, TipoInstitucionCConstants.ARG_ALIAS_DELTIPOINSTITUCIONCPERSONAC_TIPOINSTITUCIONCDELTIPOINSTITUCIONCPERSONACPTHISTIPOINSTITUCIONC);
        }
    }

    @JsonIgnore
    public PersonaCOid getTipoInstitucionCDelTipoInstitucionCPersonaCpevcPersonaC() {
        return this.tipoInstitucionCDelTipoInstitucionCPersonaCpevcPersonaC;
    }
    
    public void setTipoInstitucionCDelTipoInstitucionCPersonaCpevcPersonaC(PersonaCOid tipoInstitucionCDelTipoInstitucionCPersonaCpevcPersonaC) {
        this.tipoInstitucionCDelTipoInstitucionCPersonaCpevcPersonaC = tipoInstitucionCDelTipoInstitucionCPersonaCpevcPersonaC;
    }

    @JsonIgnore
    public PersonaC getTipoInstitucionCDelTipoInstitucionCPersonaCpevcPersonaCInstance() {
        return this.tipoInstitucionCDelTipoInstitucionCPersonaCpevcPersonaCInstance;
    }
    
    public void setTipoInstitucionCDelTipoInstitucionCPersonaCpevcPersonaCInstance(PersonaC tipoInstitucionCDelTipoInstitucionCPersonaCpevcPersonaC) {
        this.tipoInstitucionCDelTipoInstitucionCPersonaCpevcPersonaCInstance = tipoInstitucionCDelTipoInstitucionCPersonaCpevcPersonaC;
        this.tipoInstitucionCDelTipoInstitucionCPersonaCpevcPersonaC = tipoInstitucionCDelTipoInstitucionCPersonaCpevcPersonaC != null ? tipoInstitucionCDelTipoInstitucionCPersonaCpevcPersonaC.getOid() : null;
    }

    private void checkTipoInstitucionCDelTipoInstitucionCPersonaCpevcPersonaC() throws NotNullArgumentException {
        if(this.getTipoInstitucionCDelTipoInstitucionCPersonaCpevcPersonaCInstance() == null || this.getTipoInstitucionCDelTipoInstitucionCPersonaCpevcPersonaCInstance().isNull()) {
            throw new NotNullArgumentException(TipoInstitucionCConstants.SERV_ID_DELTIPOINSTITUCIONCPERSONAC, TipoInstitucionCConstants.CLASS_ID, TipoInstitucionCConstants.ARG_ID_DELTIPOINSTITUCIONCPERSONAC_TIPOINSTITUCIONCDELTIPOINSTITUCIONCPERSONACPEVCPERSONAC, TipoInstitucionCConstants.SERV_ALIAS_DELTIPOINSTITUCIONCPERSONAC, TipoInstitucionCConstants.CLASS_ALIAS, TipoInstitucionCConstants.ARG_ALIAS_DELTIPOINSTITUCIONCPERSONAC_TIPOINSTITUCIONCDELTIPOINSTITUCIONCPERSONACPEVCPERSONAC);
        }
    }
}
