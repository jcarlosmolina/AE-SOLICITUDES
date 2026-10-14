package com.keralty.aesolicitudes.viewmodel.tipoinstitucionc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.TipoInstitucionCConstants;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.oid.TipoInstitucionCOid;
import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.TipoInstitucionC;

public class InsTipoInstitucionCPersonaCRequest {

    @JsonProperty("p_thistipoinstitucionc_oid")
    private TipoInstitucionCOid tipoInstitucionCInsTipoInstitucionCPersonaCpthisTipoInstitucionC;
    
    @JsonIgnore
    private TipoInstitucionC tipoInstitucionCInsTipoInstitucionCPersonaCpthisTipoInstitucionCInstance;

    @JsonProperty("p_evcpersonac_oid")
    private PersonaCOid tipoInstitucionCInsTipoInstitucionCPersonaCpevcPersonaC;
    
    @JsonIgnore
    private PersonaC tipoInstitucionCInsTipoInstitucionCPersonaCpevcPersonaCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkTipoInstitucionCInsTipoInstitucionCPersonaCpthisTipoInstitucionC();
        checkTipoInstitucionCInsTipoInstitucionCPersonaCpevcPersonaC();
    }

    @JsonIgnore
    public TipoInstitucionCOid getTipoInstitucionCInsTipoInstitucionCPersonaCpthisTipoInstitucionC() {
        return this.tipoInstitucionCInsTipoInstitucionCPersonaCpthisTipoInstitucionC;
    }
    
    public void setTipoInstitucionCInsTipoInstitucionCPersonaCpthisTipoInstitucionC(TipoInstitucionCOid tipoInstitucionCInsTipoInstitucionCPersonaCpthisTipoInstitucionC) {
        this.tipoInstitucionCInsTipoInstitucionCPersonaCpthisTipoInstitucionC = tipoInstitucionCInsTipoInstitucionCPersonaCpthisTipoInstitucionC;
    }

    @JsonIgnore
    public TipoInstitucionC getTipoInstitucionCInsTipoInstitucionCPersonaCpthisTipoInstitucionCInstance() {
        return this.tipoInstitucionCInsTipoInstitucionCPersonaCpthisTipoInstitucionCInstance;
    }
    
    public void setTipoInstitucionCInsTipoInstitucionCPersonaCpthisTipoInstitucionCInstance(TipoInstitucionC tipoInstitucionCInsTipoInstitucionCPersonaCpthisTipoInstitucionC) {
        this.tipoInstitucionCInsTipoInstitucionCPersonaCpthisTipoInstitucionCInstance = tipoInstitucionCInsTipoInstitucionCPersonaCpthisTipoInstitucionC;
        this.tipoInstitucionCInsTipoInstitucionCPersonaCpthisTipoInstitucionC = tipoInstitucionCInsTipoInstitucionCPersonaCpthisTipoInstitucionC != null ? tipoInstitucionCInsTipoInstitucionCPersonaCpthisTipoInstitucionC.getOid() : null;
    }

    private void checkTipoInstitucionCInsTipoInstitucionCPersonaCpthisTipoInstitucionC() throws NotNullArgumentException {
        if(this.getTipoInstitucionCInsTipoInstitucionCPersonaCpthisTipoInstitucionCInstance() == null || this.getTipoInstitucionCInsTipoInstitucionCPersonaCpthisTipoInstitucionCInstance().isNull()) {
            throw new NotNullArgumentException(TipoInstitucionCConstants.SERV_ID_INSTIPOINSTITUCIONCPERSONAC, TipoInstitucionCConstants.CLASS_ID, TipoInstitucionCConstants.ARG_ID_INSTIPOINSTITUCIONCPERSONAC_TIPOINSTITUCIONCINSTIPOINSTITUCIONCPERSONACPTHISTIPOINSTITUCIONC, TipoInstitucionCConstants.SERV_ALIAS_INSTIPOINSTITUCIONCPERSONAC, TipoInstitucionCConstants.CLASS_ALIAS, TipoInstitucionCConstants.ARG_ALIAS_INSTIPOINSTITUCIONCPERSONAC_TIPOINSTITUCIONCINSTIPOINSTITUCIONCPERSONACPTHISTIPOINSTITUCIONC);
        }
    }

    @JsonIgnore
    public PersonaCOid getTipoInstitucionCInsTipoInstitucionCPersonaCpevcPersonaC() {
        return this.tipoInstitucionCInsTipoInstitucionCPersonaCpevcPersonaC;
    }
    
    public void setTipoInstitucionCInsTipoInstitucionCPersonaCpevcPersonaC(PersonaCOid tipoInstitucionCInsTipoInstitucionCPersonaCpevcPersonaC) {
        this.tipoInstitucionCInsTipoInstitucionCPersonaCpevcPersonaC = tipoInstitucionCInsTipoInstitucionCPersonaCpevcPersonaC;
    }

    @JsonIgnore
    public PersonaC getTipoInstitucionCInsTipoInstitucionCPersonaCpevcPersonaCInstance() {
        return this.tipoInstitucionCInsTipoInstitucionCPersonaCpevcPersonaCInstance;
    }
    
    public void setTipoInstitucionCInsTipoInstitucionCPersonaCpevcPersonaCInstance(PersonaC tipoInstitucionCInsTipoInstitucionCPersonaCpevcPersonaC) {
        this.tipoInstitucionCInsTipoInstitucionCPersonaCpevcPersonaCInstance = tipoInstitucionCInsTipoInstitucionCPersonaCpevcPersonaC;
        this.tipoInstitucionCInsTipoInstitucionCPersonaCpevcPersonaC = tipoInstitucionCInsTipoInstitucionCPersonaCpevcPersonaC != null ? tipoInstitucionCInsTipoInstitucionCPersonaCpevcPersonaC.getOid() : null;
    }

    private void checkTipoInstitucionCInsTipoInstitucionCPersonaCpevcPersonaC() throws NotNullArgumentException {
        if(this.getTipoInstitucionCInsTipoInstitucionCPersonaCpevcPersonaCInstance() == null || this.getTipoInstitucionCInsTipoInstitucionCPersonaCpevcPersonaCInstance().isNull()) {
            throw new NotNullArgumentException(TipoInstitucionCConstants.SERV_ID_INSTIPOINSTITUCIONCPERSONAC, TipoInstitucionCConstants.CLASS_ID, TipoInstitucionCConstants.ARG_ID_INSTIPOINSTITUCIONCPERSONAC_TIPOINSTITUCIONCINSTIPOINSTITUCIONCPERSONACPEVCPERSONAC, TipoInstitucionCConstants.SERV_ALIAS_INSTIPOINSTITUCIONCPERSONAC, TipoInstitucionCConstants.CLASS_ALIAS, TipoInstitucionCConstants.ARG_ALIAS_INSTIPOINSTITUCIONCPERSONAC_TIPOINSTITUCIONCINSTIPOINSTITUCIONCPERSONACPEVCPERSONAC);
        }
    }
}
