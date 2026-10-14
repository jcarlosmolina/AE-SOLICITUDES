package com.keralty.aesolicitudes.viewmodel.documentog.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DocumentoGConstants;
import com.keralty.aesolicitudes.persistence.DocumentoG;
import com.keralty.aesolicitudes.persistence.oid.DocumentoGOid;

public class TDEVOLVERRequest {

    @JsonProperty("p_thisdocumentog_oid")
    private DocumentoGOid documentoGTDEVOLVERpthisDocumentoG;
    
    @JsonIgnore
    private DocumentoG documentoGTDEVOLVERpthisDocumentoGInstance;

    @JsonProperty("pt_p_atrobservacions")
    private String documentoGTDEVOLVERptpatrObservacions;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkDocumentoGTDEVOLVERpthisDocumentoG();
    }

    @JsonIgnore
    public DocumentoGOid getDocumentoGTDEVOLVERpthisDocumentoG() {
        return this.documentoGTDEVOLVERpthisDocumentoG;
    }
    
    public void setDocumentoGTDEVOLVERpthisDocumentoG(DocumentoGOid documentoGTDEVOLVERpthisDocumentoG) {
        this.documentoGTDEVOLVERpthisDocumentoG = documentoGTDEVOLVERpthisDocumentoG;
    }

    @JsonIgnore
    public DocumentoG getDocumentoGTDEVOLVERpthisDocumentoGInstance() {
        return this.documentoGTDEVOLVERpthisDocumentoGInstance;
    }
    
    public void setDocumentoGTDEVOLVERpthisDocumentoGInstance(DocumentoG documentoGTDEVOLVERpthisDocumentoG) {
        this.documentoGTDEVOLVERpthisDocumentoGInstance = documentoGTDEVOLVERpthisDocumentoG;
        this.documentoGTDEVOLVERpthisDocumentoG = documentoGTDEVOLVERpthisDocumentoG != null ? documentoGTDEVOLVERpthisDocumentoG.getOid() : null;
    }

    private void checkDocumentoGTDEVOLVERpthisDocumentoG() throws NotNullArgumentException {
        if(this.getDocumentoGTDEVOLVERpthisDocumentoGInstance() == null || this.getDocumentoGTDEVOLVERpthisDocumentoGInstance().isNull()) {
            throw new NotNullArgumentException(DocumentoGConstants.SERV_ID_TDEVOLVER, DocumentoGConstants.CLASS_ID, DocumentoGConstants.ARG_ID_TDEVOLVER_DOCUMENTOGTDEVOLVERPTHISDOCUMENTOG, DocumentoGConstants.SERV_ALIAS_TDEVOLVER, DocumentoGConstants.CLASS_ALIAS, DocumentoGConstants.ARG_ALIAS_TDEVOLVER_DOCUMENTOGTDEVOLVERPTHISDOCUMENTOG);
        }
    }

    @JsonIgnore
    public String getDocumentoGTDEVOLVERptpatrObservacions() {
        return this.documentoGTDEVOLVERptpatrObservacions;
    }
    
    public void setDocumentoGTDEVOLVERptpatrObservacions(String documentoGTDEVOLVERptpatrObservacions) {
        this.documentoGTDEVOLVERptpatrObservacions = documentoGTDEVOLVERptpatrObservacions;
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
