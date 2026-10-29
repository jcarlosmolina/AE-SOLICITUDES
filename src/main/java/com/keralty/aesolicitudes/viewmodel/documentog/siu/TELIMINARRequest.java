package com.keralty.aesolicitudes.viewmodel.documentog.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DocumentoGConstants;
import com.keralty.aesolicitudes.persistence.DocumentoG;
import com.keralty.aesolicitudes.persistence.oid.DocumentoGOid;

public class TELIMINARRequest {

    @JsonProperty("p_thisdocumentog_oid")
    private DocumentoGOid documentoGTELIMINARpthisDocumentoG;
    
    @JsonIgnore
    private DocumentoG documentoGTELIMINARpthisDocumentoGInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkDocumentoGTELIMINARpthisDocumentoG();
    }

    @JsonIgnore
    public DocumentoGOid getDocumentoGTELIMINARpthisDocumentoG() {
        return this.documentoGTELIMINARpthisDocumentoG;
    }
    
    public void setDocumentoGTELIMINARpthisDocumentoG(DocumentoGOid documentoGTELIMINARpthisDocumentoG) {
        this.documentoGTELIMINARpthisDocumentoG = documentoGTELIMINARpthisDocumentoG;
    }

    @JsonIgnore
    public DocumentoG getDocumentoGTELIMINARpthisDocumentoGInstance() {
        return this.documentoGTELIMINARpthisDocumentoGInstance;
    }
    
    public void setDocumentoGTELIMINARpthisDocumentoGInstance(DocumentoG documentoGTELIMINARpthisDocumentoG) {
        this.documentoGTELIMINARpthisDocumentoGInstance = documentoGTELIMINARpthisDocumentoG;
        this.documentoGTELIMINARpthisDocumentoG = documentoGTELIMINARpthisDocumentoG != null ? documentoGTELIMINARpthisDocumentoG.getOid() : null;
    }

    private void checkDocumentoGTELIMINARpthisDocumentoG() throws NotNullArgumentException {
        if(this.getDocumentoGTELIMINARpthisDocumentoGInstance() == null || this.getDocumentoGTELIMINARpthisDocumentoGInstance().isNull()) {
            throw new NotNullArgumentException(DocumentoGConstants.SERV_ID_TELIMINAR, DocumentoGConstants.CLASS_ID, DocumentoGConstants.ARG_ID_TELIMINAR_DOCUMENTOGTELIMINARPTHISDOCUMENTOG, DocumentoGConstants.SERV_ALIAS_TELIMINAR, DocumentoGConstants.CLASS_ALIAS, DocumentoGConstants.ARG_ALIAS_TELIMINAR_DOCUMENTOGTELIMINARPTHISDOCUMENTOG);
        }
    }
}
