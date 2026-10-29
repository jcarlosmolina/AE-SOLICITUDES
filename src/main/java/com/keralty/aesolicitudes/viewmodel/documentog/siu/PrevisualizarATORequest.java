package com.keralty.aesolicitudes.viewmodel.documentog.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DocumentoGConstants;
import com.keralty.aesolicitudes.persistence.DocumentoG;
import com.keralty.aesolicitudes.persistence.oid.DocumentoGOid;

public class PrevisualizarATORequest {

    @JsonProperty("p_thisdocumentog_oid")
    private DocumentoGOid documentoGprevisualizarATOpthisDocumentoG;
    
    @JsonIgnore
    private DocumentoG documentoGprevisualizarATOpthisDocumentoGInstance;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkDocumentoGprevisualizarATOpthisDocumentoG();
    }

    @JsonIgnore
    public DocumentoGOid getDocumentoGprevisualizarATOpthisDocumentoG() {
        return this.documentoGprevisualizarATOpthisDocumentoG;
    }
    
    public void setDocumentoGprevisualizarATOpthisDocumentoG(DocumentoGOid documentoGprevisualizarATOpthisDocumentoG) {
        this.documentoGprevisualizarATOpthisDocumentoG = documentoGprevisualizarATOpthisDocumentoG;
    }

    @JsonIgnore
    public DocumentoG getDocumentoGprevisualizarATOpthisDocumentoGInstance() {
        return this.documentoGprevisualizarATOpthisDocumentoGInstance;
    }
    
    public void setDocumentoGprevisualizarATOpthisDocumentoGInstance(DocumentoG documentoGprevisualizarATOpthisDocumentoG) {
        this.documentoGprevisualizarATOpthisDocumentoGInstance = documentoGprevisualizarATOpthisDocumentoG;
        this.documentoGprevisualizarATOpthisDocumentoG = documentoGprevisualizarATOpthisDocumentoG != null ? documentoGprevisualizarATOpthisDocumentoG.getOid() : null;
    }

    private void checkDocumentoGprevisualizarATOpthisDocumentoG() throws NotNullArgumentException {
        if(this.getDocumentoGprevisualizarATOpthisDocumentoGInstance() == null || this.getDocumentoGprevisualizarATOpthisDocumentoGInstance().isNull()) {
            throw new NotNullArgumentException(DocumentoGConstants.SERV_ID_PREVISUALIZARATO, DocumentoGConstants.CLASS_ID, DocumentoGConstants.ARG_ID_PREVISUALIZARATO_DOCUMENTOGPREVISUALIZARATOPTHISDOCUMENTOG, DocumentoGConstants.SERV_ALIAS_PREVISUALIZARATO, DocumentoGConstants.CLASS_ALIAS, DocumentoGConstants.ARG_ALIAS_PREVISUALIZARATO_DOCUMENTOGPREVISUALIZARATOPTHISDOCUMENTOG);
        }
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
