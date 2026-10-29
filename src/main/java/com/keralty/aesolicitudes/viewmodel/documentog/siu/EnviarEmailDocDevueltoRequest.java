package com.keralty.aesolicitudes.viewmodel.documentog.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DocumentoGConstants;
import com.keralty.aesolicitudes.persistence.DocumentoG;
import com.keralty.aesolicitudes.persistence.oid.DocumentoGOid;
import com.keralty.aesolicitudes.persistence.oid.PlantillaEmailOid;
import com.keralty.aesolicitudes.persistence.PlantillaEmail;

public class EnviarEmailDocDevueltoRequest {

    @JsonProperty("p_thisdocumentog_oid")
    private DocumentoGOid documentoGenviarEmailDocDevueltopthisDocumentoG;
    
    @JsonIgnore
    private DocumentoG documentoGenviarEmailDocDevueltopthisDocumentoGInstance;

    @JsonProperty("pt_p_atrobservacions")
    private String documentoGenviarEmailDocDevueltoptpatrObservacions;

    @JsonProperty("peplantilla_oid")
    private PlantillaEmailOid documentoGenviarEmailDocDevueltopePlantilla;
    
    @JsonIgnore
    private PlantillaEmail documentoGenviarEmailDocDevueltopePlantillaInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkDocumentoGenviarEmailDocDevueltopthisDocumentoG();
    }

    @JsonIgnore
    public DocumentoGOid getDocumentoGenviarEmailDocDevueltopthisDocumentoG() {
        return this.documentoGenviarEmailDocDevueltopthisDocumentoG;
    }
    
    public void setDocumentoGenviarEmailDocDevueltopthisDocumentoG(DocumentoGOid documentoGenviarEmailDocDevueltopthisDocumentoG) {
        this.documentoGenviarEmailDocDevueltopthisDocumentoG = documentoGenviarEmailDocDevueltopthisDocumentoG;
    }

    @JsonIgnore
    public DocumentoG getDocumentoGenviarEmailDocDevueltopthisDocumentoGInstance() {
        return this.documentoGenviarEmailDocDevueltopthisDocumentoGInstance;
    }
    
    public void setDocumentoGenviarEmailDocDevueltopthisDocumentoGInstance(DocumentoG documentoGenviarEmailDocDevueltopthisDocumentoG) {
        this.documentoGenviarEmailDocDevueltopthisDocumentoGInstance = documentoGenviarEmailDocDevueltopthisDocumentoG;
        this.documentoGenviarEmailDocDevueltopthisDocumentoG = documentoGenviarEmailDocDevueltopthisDocumentoG != null ? documentoGenviarEmailDocDevueltopthisDocumentoG.getOid() : null;
    }

    private void checkDocumentoGenviarEmailDocDevueltopthisDocumentoG() throws NotNullArgumentException {
        if(this.getDocumentoGenviarEmailDocDevueltopthisDocumentoGInstance() == null || this.getDocumentoGenviarEmailDocDevueltopthisDocumentoGInstance().isNull()) {
            throw new NotNullArgumentException(DocumentoGConstants.SERV_ID_ENVIAREMAILDOCDEVUELTO, DocumentoGConstants.CLASS_ID, DocumentoGConstants.ARG_ID_ENVIAREMAILDOCDEVUELTO_DOCUMENTOGENVIAREMAILDOCDEVUELTOPTHISDOCUMENTOG, DocumentoGConstants.SERV_ALIAS_ENVIAREMAILDOCDEVUELTO, DocumentoGConstants.CLASS_ALIAS, DocumentoGConstants.ARG_ALIAS_ENVIAREMAILDOCDEVUELTO_DOCUMENTOGENVIAREMAILDOCDEVUELTOPTHISDOCUMENTOG);
        }
    }

    @JsonIgnore
    public String getDocumentoGenviarEmailDocDevueltoptpatrObservacions() {
        return this.documentoGenviarEmailDocDevueltoptpatrObservacions;
    }
    
    public void setDocumentoGenviarEmailDocDevueltoptpatrObservacions(String documentoGenviarEmailDocDevueltoptpatrObservacions) {
        this.documentoGenviarEmailDocDevueltoptpatrObservacions = documentoGenviarEmailDocDevueltoptpatrObservacions;
    }

    @JsonIgnore
    public PlantillaEmailOid getDocumentoGenviarEmailDocDevueltopePlantilla() {
        return this.documentoGenviarEmailDocDevueltopePlantilla;
    }
    
    public void setDocumentoGenviarEmailDocDevueltopePlantilla(PlantillaEmailOid documentoGenviarEmailDocDevueltopePlantilla) {
        this.documentoGenviarEmailDocDevueltopePlantilla = documentoGenviarEmailDocDevueltopePlantilla;
    }

    @JsonIgnore
    public PlantillaEmail getDocumentoGenviarEmailDocDevueltopePlantillaInstance() {
        return this.documentoGenviarEmailDocDevueltopePlantillaInstance;
    }
    
    public void setDocumentoGenviarEmailDocDevueltopePlantillaInstance(PlantillaEmail documentoGenviarEmailDocDevueltopePlantilla) {
        this.documentoGenviarEmailDocDevueltopePlantillaInstance = documentoGenviarEmailDocDevueltopePlantilla;
        this.documentoGenviarEmailDocDevueltopePlantilla = documentoGenviarEmailDocDevueltopePlantilla != null ? documentoGenviarEmailDocDevueltopePlantilla.getOid() : null;
    }
}
