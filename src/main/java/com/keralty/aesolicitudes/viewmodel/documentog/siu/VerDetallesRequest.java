package com.keralty.aesolicitudes.viewmodel.documentog.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DocumentoGConstants;
import com.keralty.aesolicitudes.persistence.DocumentoG;
import com.keralty.aesolicitudes.persistence.oid.DocumentoGOid;

public class VerDetallesRequest {

    @JsonProperty("p_thisdocumentog_oid")
    private DocumentoGOid documentoGverDetallespthisDocumentoG;
    
    @JsonIgnore
    private DocumentoG documentoGverDetallespthisDocumentoGInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkDocumentoGverDetallespthisDocumentoG();
    }

    @JsonIgnore
    public DocumentoGOid getDocumentoGverDetallespthisDocumentoG() {
        return this.documentoGverDetallespthisDocumentoG;
    }
    
    public void setDocumentoGverDetallespthisDocumentoG(DocumentoGOid documentoGverDetallespthisDocumentoG) {
        this.documentoGverDetallespthisDocumentoG = documentoGverDetallespthisDocumentoG;
    }

    @JsonIgnore
    public DocumentoG getDocumentoGverDetallespthisDocumentoGInstance() {
        return this.documentoGverDetallespthisDocumentoGInstance;
    }
    
    public void setDocumentoGverDetallespthisDocumentoGInstance(DocumentoG documentoGverDetallespthisDocumentoG) {
        this.documentoGverDetallespthisDocumentoGInstance = documentoGverDetallespthisDocumentoG;
        this.documentoGverDetallespthisDocumentoG = documentoGverDetallespthisDocumentoG != null ? documentoGverDetallespthisDocumentoG.getOid() : null;
    }

    private void checkDocumentoGverDetallespthisDocumentoG() throws NotNullArgumentException {
        if(this.getDocumentoGverDetallespthisDocumentoGInstance() == null || this.getDocumentoGverDetallespthisDocumentoGInstance().isNull()) {
            throw new NotNullArgumentException(DocumentoGConstants.SERV_ID_VERDETALLES, DocumentoGConstants.CLASS_ID, DocumentoGConstants.ARG_ID_VERDETALLES_DOCUMENTOGVERDETALLESPTHISDOCUMENTOG, DocumentoGConstants.SERV_ALIAS_VERDETALLES, DocumentoGConstants.CLASS_ALIAS, DocumentoGConstants.ARG_ALIAS_VERDETALLES_DOCUMENTOGVERDETALLESPTHISDOCUMENTOG);
        }
    }
}
