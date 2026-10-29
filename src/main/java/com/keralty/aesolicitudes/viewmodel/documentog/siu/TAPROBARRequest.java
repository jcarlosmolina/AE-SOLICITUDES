package com.keralty.aesolicitudes.viewmodel.documentog.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DocumentoGConstants;
import com.keralty.aesolicitudes.persistence.DocumentoG;
import com.keralty.aesolicitudes.persistence.oid.DocumentoGOid;

public class TAPROBARRequest {

    @JsonProperty("p_thisdocumentog_oid")
    private DocumentoGOid documentoGTAPROBARpthisDocumentoG;
    
    @JsonIgnore
    private DocumentoG documentoGTAPROBARpthisDocumentoGInstance;

    @JsonProperty("pt_p_atrobservacions")
    private String documentoGTAPROBARptpatrObservacions;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkDocumentoGTAPROBARpthisDocumentoG();
    }

    @JsonIgnore
    public DocumentoGOid getDocumentoGTAPROBARpthisDocumentoG() {
        return this.documentoGTAPROBARpthisDocumentoG;
    }
    
    public void setDocumentoGTAPROBARpthisDocumentoG(DocumentoGOid documentoGTAPROBARpthisDocumentoG) {
        this.documentoGTAPROBARpthisDocumentoG = documentoGTAPROBARpthisDocumentoG;
    }

    @JsonIgnore
    public DocumentoG getDocumentoGTAPROBARpthisDocumentoGInstance() {
        return this.documentoGTAPROBARpthisDocumentoGInstance;
    }
    
    public void setDocumentoGTAPROBARpthisDocumentoGInstance(DocumentoG documentoGTAPROBARpthisDocumentoG) {
        this.documentoGTAPROBARpthisDocumentoGInstance = documentoGTAPROBARpthisDocumentoG;
        this.documentoGTAPROBARpthisDocumentoG = documentoGTAPROBARpthisDocumentoG != null ? documentoGTAPROBARpthisDocumentoG.getOid() : null;
    }

    private void checkDocumentoGTAPROBARpthisDocumentoG() throws NotNullArgumentException {
        if(this.getDocumentoGTAPROBARpthisDocumentoGInstance() == null || this.getDocumentoGTAPROBARpthisDocumentoGInstance().isNull()) {
            throw new NotNullArgumentException(DocumentoGConstants.SERV_ID_TAPROBAR, DocumentoGConstants.CLASS_ID, DocumentoGConstants.ARG_ID_TAPROBAR_DOCUMENTOGTAPROBARPTHISDOCUMENTOG, DocumentoGConstants.SERV_ALIAS_TAPROBAR, DocumentoGConstants.CLASS_ALIAS, DocumentoGConstants.ARG_ALIAS_TAPROBAR_DOCUMENTOGTAPROBARPTHISDOCUMENTOG);
        }
    }

    @JsonIgnore
    public String getDocumentoGTAPROBARptpatrObservacions() {
        return this.documentoGTAPROBARptpatrObservacions;
    }
    
    public void setDocumentoGTAPROBARptpatrObservacions(String documentoGTAPROBARptpatrObservacions) {
        this.documentoGTAPROBARptpatrObservacions = documentoGTAPROBARptpatrObservacions;
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
