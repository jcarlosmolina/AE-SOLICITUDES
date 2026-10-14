package com.keralty.aesolicitudes.viewmodel.documentog.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DocumentoGConstants;
import com.keralty.aesolicitudes.persistence.DocumentoG;
import com.keralty.aesolicitudes.persistence.oid.DocumentoGOid;

public class AprobarRequest {

    @JsonProperty("p_thisdocumentog_oid")
    private DocumentoGOid documentoGaprobarpthisDocumentoG;
    
    @JsonIgnore
    private DocumentoG documentoGaprobarpthisDocumentoGInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkDocumentoGaprobarpthisDocumentoG();
    }

    @JsonIgnore
    public DocumentoGOid getDocumentoGaprobarpthisDocumentoG() {
        return this.documentoGaprobarpthisDocumentoG;
    }
    
    public void setDocumentoGaprobarpthisDocumentoG(DocumentoGOid documentoGaprobarpthisDocumentoG) {
        this.documentoGaprobarpthisDocumentoG = documentoGaprobarpthisDocumentoG;
    }

    @JsonIgnore
    public DocumentoG getDocumentoGaprobarpthisDocumentoGInstance() {
        return this.documentoGaprobarpthisDocumentoGInstance;
    }
    
    public void setDocumentoGaprobarpthisDocumentoGInstance(DocumentoG documentoGaprobarpthisDocumentoG) {
        this.documentoGaprobarpthisDocumentoGInstance = documentoGaprobarpthisDocumentoG;
        this.documentoGaprobarpthisDocumentoG = documentoGaprobarpthisDocumentoG != null ? documentoGaprobarpthisDocumentoG.getOid() : null;
    }

    private void checkDocumentoGaprobarpthisDocumentoG() throws NotNullArgumentException {
        if(this.getDocumentoGaprobarpthisDocumentoGInstance() == null || this.getDocumentoGaprobarpthisDocumentoGInstance().isNull()) {
            throw new NotNullArgumentException(DocumentoGConstants.SERV_ID_APROBAR, DocumentoGConstants.CLASS_ID, DocumentoGConstants.ARG_ID_APROBAR_DOCUMENTOGAPROBARPTHISDOCUMENTOG, DocumentoGConstants.SERV_ALIAS_APROBAR, DocumentoGConstants.CLASS_ALIAS, DocumentoGConstants.ARG_ALIAS_APROBAR_DOCUMENTOGAPROBARPTHISDOCUMENTOG);
        }
    }
}
