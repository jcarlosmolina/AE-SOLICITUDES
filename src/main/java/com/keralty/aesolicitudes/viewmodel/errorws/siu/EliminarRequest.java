package com.keralty.aesolicitudes.viewmodel.errorws.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ErrorWSConstants;
import com.keralty.aesolicitudes.persistence.ErrorWS;
import com.keralty.aesolicitudes.persistence.oid.ErrorWSOid;

public class EliminarRequest {

    @JsonProperty("p_thiserrorws_oid")
    private ErrorWSOid errorWSeliminarpthisErrorWS;
    
    @JsonIgnore
    private ErrorWS errorWSeliminarpthisErrorWSInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkErrorWSeliminarpthisErrorWS();
    }

    @JsonIgnore
    public ErrorWSOid getErrorWSeliminarpthisErrorWS() {
        return this.errorWSeliminarpthisErrorWS;
    }
    
    public void setErrorWSeliminarpthisErrorWS(ErrorWSOid errorWSeliminarpthisErrorWS) {
        this.errorWSeliminarpthisErrorWS = errorWSeliminarpthisErrorWS;
    }

    @JsonIgnore
    public ErrorWS getErrorWSeliminarpthisErrorWSInstance() {
        return this.errorWSeliminarpthisErrorWSInstance;
    }
    
    public void setErrorWSeliminarpthisErrorWSInstance(ErrorWS errorWSeliminarpthisErrorWS) {
        this.errorWSeliminarpthisErrorWSInstance = errorWSeliminarpthisErrorWS;
        this.errorWSeliminarpthisErrorWS = errorWSeliminarpthisErrorWS != null ? errorWSeliminarpthisErrorWS.getOid() : null;
    }

    private void checkErrorWSeliminarpthisErrorWS() throws NotNullArgumentException {
        if(this.getErrorWSeliminarpthisErrorWSInstance() == null || this.getErrorWSeliminarpthisErrorWSInstance().isNull()) {
            throw new NotNullArgumentException(ErrorWSConstants.SERV_ID_ELIMINAR, ErrorWSConstants.CLASS_ID, ErrorWSConstants.ARG_ID_ELIMINAR_ERRORWSELIMINARPTHISERRORWS, ErrorWSConstants.SERV_ALIAS_ELIMINAR, ErrorWSConstants.CLASS_ALIAS, ErrorWSConstants.ARG_ALIAS_ELIMINAR_ERRORWSELIMINARPTHISERRORWS);
        }
    }
}
