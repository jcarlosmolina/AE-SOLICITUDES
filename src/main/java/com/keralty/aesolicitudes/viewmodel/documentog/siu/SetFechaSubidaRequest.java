package com.keralty.aesolicitudes.viewmodel.documentog.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DocumentoGConstants;
import com.keralty.aesolicitudes.persistence.DocumentoG;
import com.keralty.aesolicitudes.persistence.oid.DocumentoGOid;
import java.sql.Timestamp;

public class SetFechaSubidaRequest {

    @JsonProperty("p_thisdocumentog_oid")
    private DocumentoGOid documentoGsetFechaSubidapthisDocumentoG;
    
    @JsonIgnore
    private DocumentoG documentoGsetFechaSubidapthisDocumentoGInstance;

    @JsonProperty("pefechahora")
    private Timestamp documentoGsetFechaSubidapeFechaHora;

    public void checkArguments() throws NotNullArgumentException {
        checkDocumentoGsetFechaSubidapthisDocumentoG();
        checkDocumentoGsetFechaSubidapeFechaHora();
    }

    @JsonIgnore
    public DocumentoGOid getDocumentoGsetFechaSubidapthisDocumentoG() {
        return this.documentoGsetFechaSubidapthisDocumentoG;
    }
    
    public void setDocumentoGsetFechaSubidapthisDocumentoG(DocumentoGOid documentoGsetFechaSubidapthisDocumentoG) {
        this.documentoGsetFechaSubidapthisDocumentoG = documentoGsetFechaSubidapthisDocumentoG;
    }

    @JsonIgnore
    public DocumentoG getDocumentoGsetFechaSubidapthisDocumentoGInstance() {
        return this.documentoGsetFechaSubidapthisDocumentoGInstance;
    }
    
    public void setDocumentoGsetFechaSubidapthisDocumentoGInstance(DocumentoG documentoGsetFechaSubidapthisDocumentoG) {
        this.documentoGsetFechaSubidapthisDocumentoGInstance = documentoGsetFechaSubidapthisDocumentoG;
        this.documentoGsetFechaSubidapthisDocumentoG = documentoGsetFechaSubidapthisDocumentoG != null ? documentoGsetFechaSubidapthisDocumentoG.getOid() : null;
    }

    private void checkDocumentoGsetFechaSubidapthisDocumentoG() throws NotNullArgumentException {
        if(this.getDocumentoGsetFechaSubidapthisDocumentoGInstance() == null || this.getDocumentoGsetFechaSubidapthisDocumentoGInstance().isNull()) {
            throw new NotNullArgumentException(DocumentoGConstants.SERV_ID_SETFECHASUBIDA, DocumentoGConstants.CLASS_ID, DocumentoGConstants.ARG_ID_SETFECHASUBIDA_DOCUMENTOGSETFECHASUBIDAPTHISDOCUMENTOG, DocumentoGConstants.SERV_ALIAS_SETFECHASUBIDA, DocumentoGConstants.CLASS_ALIAS, DocumentoGConstants.ARG_ALIAS_SETFECHASUBIDA_DOCUMENTOGSETFECHASUBIDAPTHISDOCUMENTOG);
        }
    }

    @JsonIgnore
    public Timestamp getDocumentoGsetFechaSubidapeFechaHora() {
        return this.documentoGsetFechaSubidapeFechaHora;
    }
    
    public void setDocumentoGsetFechaSubidapeFechaHora(Timestamp documentoGsetFechaSubidapeFechaHora) {
        this.documentoGsetFechaSubidapeFechaHora = documentoGsetFechaSubidapeFechaHora;
    }

    private void checkDocumentoGsetFechaSubidapeFechaHora() throws NotNullArgumentException {
        if(this.getDocumentoGsetFechaSubidapeFechaHora() == null) {
            throw new NotNullArgumentException(DocumentoGConstants.SERV_ID_SETFECHASUBIDA, DocumentoGConstants.CLASS_ID, DocumentoGConstants.ARG_ID_SETFECHASUBIDA_DOCUMENTOGSETFECHASUBIDAPEFECHAHORA, DocumentoGConstants.SERV_ALIAS_SETFECHASUBIDA, DocumentoGConstants.CLASS_ALIAS, DocumentoGConstants.ARG_ALIAS_SETFECHASUBIDA_DOCUMENTOGSETFECHASUBIDAPEFECHAHORA);
        }
    }
}
