package com.keralty.aesolicitudes.viewmodel.tipoentidadc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.TipoEntidadCConstants;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.oid.TipoEntidadCOid;
import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.TipoEntidadC;

public class InsTipoEntidadCPersonaCRequest {

    @JsonProperty("p_thistipoentidadc_oid")
    private TipoEntidadCOid tipoEntidadCInsTipoEntidadCPersonaCpthisTipoEntidadC;
    
    @JsonIgnore
    private TipoEntidadC tipoEntidadCInsTipoEntidadCPersonaCpthisTipoEntidadCInstance;

    @JsonProperty("p_evcpersonac_oid")
    private PersonaCOid tipoEntidadCInsTipoEntidadCPersonaCpevcPersonaC;
    
    @JsonIgnore
    private PersonaC tipoEntidadCInsTipoEntidadCPersonaCpevcPersonaCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkTipoEntidadCInsTipoEntidadCPersonaCpthisTipoEntidadC();
        checkTipoEntidadCInsTipoEntidadCPersonaCpevcPersonaC();
    }

    @JsonIgnore
    public TipoEntidadCOid getTipoEntidadCInsTipoEntidadCPersonaCpthisTipoEntidadC() {
        return this.tipoEntidadCInsTipoEntidadCPersonaCpthisTipoEntidadC;
    }
    
    public void setTipoEntidadCInsTipoEntidadCPersonaCpthisTipoEntidadC(TipoEntidadCOid tipoEntidadCInsTipoEntidadCPersonaCpthisTipoEntidadC) {
        this.tipoEntidadCInsTipoEntidadCPersonaCpthisTipoEntidadC = tipoEntidadCInsTipoEntidadCPersonaCpthisTipoEntidadC;
    }

    @JsonIgnore
    public TipoEntidadC getTipoEntidadCInsTipoEntidadCPersonaCpthisTipoEntidadCInstance() {
        return this.tipoEntidadCInsTipoEntidadCPersonaCpthisTipoEntidadCInstance;
    }
    
    public void setTipoEntidadCInsTipoEntidadCPersonaCpthisTipoEntidadCInstance(TipoEntidadC tipoEntidadCInsTipoEntidadCPersonaCpthisTipoEntidadC) {
        this.tipoEntidadCInsTipoEntidadCPersonaCpthisTipoEntidadCInstance = tipoEntidadCInsTipoEntidadCPersonaCpthisTipoEntidadC;
        this.tipoEntidadCInsTipoEntidadCPersonaCpthisTipoEntidadC = tipoEntidadCInsTipoEntidadCPersonaCpthisTipoEntidadC != null ? tipoEntidadCInsTipoEntidadCPersonaCpthisTipoEntidadC.getOid() : null;
    }

    private void checkTipoEntidadCInsTipoEntidadCPersonaCpthisTipoEntidadC() throws NotNullArgumentException {
        if(this.getTipoEntidadCInsTipoEntidadCPersonaCpthisTipoEntidadCInstance() == null || this.getTipoEntidadCInsTipoEntidadCPersonaCpthisTipoEntidadCInstance().isNull()) {
            throw new NotNullArgumentException(TipoEntidadCConstants.SERV_ID_INSTIPOENTIDADCPERSONAC, TipoEntidadCConstants.CLASS_ID, TipoEntidadCConstants.ARG_ID_INSTIPOENTIDADCPERSONAC_TIPOENTIDADCINSTIPOENTIDADCPERSONACPTHISTIPOENTIDADC, TipoEntidadCConstants.SERV_ALIAS_INSTIPOENTIDADCPERSONAC, TipoEntidadCConstants.CLASS_ALIAS, TipoEntidadCConstants.ARG_ALIAS_INSTIPOENTIDADCPERSONAC_TIPOENTIDADCINSTIPOENTIDADCPERSONACPTHISTIPOENTIDADC);
        }
    }

    @JsonIgnore
    public PersonaCOid getTipoEntidadCInsTipoEntidadCPersonaCpevcPersonaC() {
        return this.tipoEntidadCInsTipoEntidadCPersonaCpevcPersonaC;
    }
    
    public void setTipoEntidadCInsTipoEntidadCPersonaCpevcPersonaC(PersonaCOid tipoEntidadCInsTipoEntidadCPersonaCpevcPersonaC) {
        this.tipoEntidadCInsTipoEntidadCPersonaCpevcPersonaC = tipoEntidadCInsTipoEntidadCPersonaCpevcPersonaC;
    }

    @JsonIgnore
    public PersonaC getTipoEntidadCInsTipoEntidadCPersonaCpevcPersonaCInstance() {
        return this.tipoEntidadCInsTipoEntidadCPersonaCpevcPersonaCInstance;
    }
    
    public void setTipoEntidadCInsTipoEntidadCPersonaCpevcPersonaCInstance(PersonaC tipoEntidadCInsTipoEntidadCPersonaCpevcPersonaC) {
        this.tipoEntidadCInsTipoEntidadCPersonaCpevcPersonaCInstance = tipoEntidadCInsTipoEntidadCPersonaCpevcPersonaC;
        this.tipoEntidadCInsTipoEntidadCPersonaCpevcPersonaC = tipoEntidadCInsTipoEntidadCPersonaCpevcPersonaC != null ? tipoEntidadCInsTipoEntidadCPersonaCpevcPersonaC.getOid() : null;
    }

    private void checkTipoEntidadCInsTipoEntidadCPersonaCpevcPersonaC() throws NotNullArgumentException {
        if(this.getTipoEntidadCInsTipoEntidadCPersonaCpevcPersonaCInstance() == null || this.getTipoEntidadCInsTipoEntidadCPersonaCpevcPersonaCInstance().isNull()) {
            throw new NotNullArgumentException(TipoEntidadCConstants.SERV_ID_INSTIPOENTIDADCPERSONAC, TipoEntidadCConstants.CLASS_ID, TipoEntidadCConstants.ARG_ID_INSTIPOENTIDADCPERSONAC_TIPOENTIDADCINSTIPOENTIDADCPERSONACPEVCPERSONAC, TipoEntidadCConstants.SERV_ALIAS_INSTIPOENTIDADCPERSONAC, TipoEntidadCConstants.CLASS_ALIAS, TipoEntidadCConstants.ARG_ALIAS_INSTIPOENTIDADCPERSONAC_TIPOENTIDADCINSTIPOENTIDADCPERSONACPEVCPERSONAC);
        }
    }
}
