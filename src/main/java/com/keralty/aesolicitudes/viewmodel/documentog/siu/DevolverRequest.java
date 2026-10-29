package com.keralty.aesolicitudes.viewmodel.documentog.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DocumentoGConstants;
import com.keralty.aesolicitudes.persistence.DocumentoG;
import com.keralty.aesolicitudes.persistence.oid.DocumentoGOid;

public class DevolverRequest {

    @JsonProperty("p_thisdocumentog_oid")
    private DocumentoGOid documentoGdevolverpthisDocumentoG;
    
    @JsonIgnore
    private DocumentoG documentoGdevolverpthisDocumentoGInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkDocumentoGdevolverpthisDocumentoG();
    }

    @JsonIgnore
    public DocumentoGOid getDocumentoGdevolverpthisDocumentoG() {
        return this.documentoGdevolverpthisDocumentoG;
    }
    
    public void setDocumentoGdevolverpthisDocumentoG(DocumentoGOid documentoGdevolverpthisDocumentoG) {
        this.documentoGdevolverpthisDocumentoG = documentoGdevolverpthisDocumentoG;
    }

    @JsonIgnore
    public DocumentoG getDocumentoGdevolverpthisDocumentoGInstance() {
        return this.documentoGdevolverpthisDocumentoGInstance;
    }
    
    public void setDocumentoGdevolverpthisDocumentoGInstance(DocumentoG documentoGdevolverpthisDocumentoG) {
        this.documentoGdevolverpthisDocumentoGInstance = documentoGdevolverpthisDocumentoG;
        this.documentoGdevolverpthisDocumentoG = documentoGdevolverpthisDocumentoG != null ? documentoGdevolverpthisDocumentoG.getOid() : null;
    }

    private void checkDocumentoGdevolverpthisDocumentoG() throws NotNullArgumentException {
        if(this.getDocumentoGdevolverpthisDocumentoGInstance() == null || this.getDocumentoGdevolverpthisDocumentoGInstance().isNull()) {
            throw new NotNullArgumentException(DocumentoGConstants.SERV_ID_DEVOLVER, DocumentoGConstants.CLASS_ID, DocumentoGConstants.ARG_ID_DEVOLVER_DOCUMENTOGDEVOLVERPTHISDOCUMENTOG, DocumentoGConstants.SERV_ALIAS_DEVOLVER, DocumentoGConstants.CLASS_ALIAS, DocumentoGConstants.ARG_ALIAS_DEVOLVER_DOCUMENTOGDEVOLVERPTHISDOCUMENTOG);
        }
    }
}
