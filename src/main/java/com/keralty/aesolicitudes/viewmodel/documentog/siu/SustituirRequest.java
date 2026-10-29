package com.keralty.aesolicitudes.viewmodel.documentog.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DocumentoGConstants;
import com.keralty.aesolicitudes.persistence.DocumentoG;
import com.keralty.aesolicitudes.persistence.oid.DocumentoGOid;

public class SustituirRequest {

    @JsonProperty("p_thisdocumentog_oid")
    private DocumentoGOid documentoGsustituirpthisDocumentoG;
    
    @JsonIgnore
    private DocumentoG documentoGsustituirpthisDocumentoGInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkDocumentoGsustituirpthisDocumentoG();
    }

    @JsonIgnore
    public DocumentoGOid getDocumentoGsustituirpthisDocumentoG() {
        return this.documentoGsustituirpthisDocumentoG;
    }
    
    public void setDocumentoGsustituirpthisDocumentoG(DocumentoGOid documentoGsustituirpthisDocumentoG) {
        this.documentoGsustituirpthisDocumentoG = documentoGsustituirpthisDocumentoG;
    }

    @JsonIgnore
    public DocumentoG getDocumentoGsustituirpthisDocumentoGInstance() {
        return this.documentoGsustituirpthisDocumentoGInstance;
    }
    
    public void setDocumentoGsustituirpthisDocumentoGInstance(DocumentoG documentoGsustituirpthisDocumentoG) {
        this.documentoGsustituirpthisDocumentoGInstance = documentoGsustituirpthisDocumentoG;
        this.documentoGsustituirpthisDocumentoG = documentoGsustituirpthisDocumentoG != null ? documentoGsustituirpthisDocumentoG.getOid() : null;
    }

    private void checkDocumentoGsustituirpthisDocumentoG() throws NotNullArgumentException {
        if(this.getDocumentoGsustituirpthisDocumentoGInstance() == null || this.getDocumentoGsustituirpthisDocumentoGInstance().isNull()) {
            throw new NotNullArgumentException(DocumentoGConstants.SERV_ID_SUSTITUIR, DocumentoGConstants.CLASS_ID, DocumentoGConstants.ARG_ID_SUSTITUIR_DOCUMENTOGSUSTITUIRPTHISDOCUMENTOG, DocumentoGConstants.SERV_ALIAS_SUSTITUIR, DocumentoGConstants.CLASS_ALIAS, DocumentoGConstants.ARG_ALIAS_SUSTITUIR_DOCUMENTOGSUSTITUIRPTHISDOCUMENTOG);
        }
    }
}
