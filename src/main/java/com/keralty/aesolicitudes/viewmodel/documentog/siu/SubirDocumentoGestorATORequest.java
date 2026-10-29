package com.keralty.aesolicitudes.viewmodel.documentog.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DocumentoGConstants;
import com.keralty.aesolicitudes.persistence.DocumentoG;
import com.keralty.aesolicitudes.persistence.oid.DocumentoGOid;

public class SubirDocumentoGestorATORequest {

    @JsonProperty("p_thisdocumentog_oid")
    private DocumentoGOid documentoGsubirDocumentoGestorATOpthisDocumentoG;
    
    @JsonIgnore
    private DocumentoG documentoGsubirDocumentoGestorATOpthisDocumentoGInstance;

    @JsonProperty("p_extension")
    private String documentoGsubirDocumentoGestorATOpExtension;

    @JsonProperty("piddocgestor")
    private String documentoGsubirDocumentoGestorATOpIdDocGestor;

    @JsonProperty("pnombre")
    private String documentoGsubirDocumentoGestorATOpNombre;

    public void checkArguments() throws NotNullArgumentException {
        checkDocumentoGsubirDocumentoGestorATOpthisDocumentoG();
        checkDocumentoGsubirDocumentoGestorATOpExtension();
        checkDocumentoGsubirDocumentoGestorATOpIdDocGestor();
        checkDocumentoGsubirDocumentoGestorATOpNombre();
    }

    @JsonIgnore
    public DocumentoGOid getDocumentoGsubirDocumentoGestorATOpthisDocumentoG() {
        return this.documentoGsubirDocumentoGestorATOpthisDocumentoG;
    }
    
    public void setDocumentoGsubirDocumentoGestorATOpthisDocumentoG(DocumentoGOid documentoGsubirDocumentoGestorATOpthisDocumentoG) {
        this.documentoGsubirDocumentoGestorATOpthisDocumentoG = documentoGsubirDocumentoGestorATOpthisDocumentoG;
    }

    @JsonIgnore
    public DocumentoG getDocumentoGsubirDocumentoGestorATOpthisDocumentoGInstance() {
        return this.documentoGsubirDocumentoGestorATOpthisDocumentoGInstance;
    }
    
    public void setDocumentoGsubirDocumentoGestorATOpthisDocumentoGInstance(DocumentoG documentoGsubirDocumentoGestorATOpthisDocumentoG) {
        this.documentoGsubirDocumentoGestorATOpthisDocumentoGInstance = documentoGsubirDocumentoGestorATOpthisDocumentoG;
        this.documentoGsubirDocumentoGestorATOpthisDocumentoG = documentoGsubirDocumentoGestorATOpthisDocumentoG != null ? documentoGsubirDocumentoGestorATOpthisDocumentoG.getOid() : null;
    }

    private void checkDocumentoGsubirDocumentoGestorATOpthisDocumentoG() throws NotNullArgumentException {
        if(this.getDocumentoGsubirDocumentoGestorATOpthisDocumentoGInstance() == null || this.getDocumentoGsubirDocumentoGestorATOpthisDocumentoGInstance().isNull()) {
            throw new NotNullArgumentException(DocumentoGConstants.SERV_ID_SUBIRDOCUMENTOGESTORATO, DocumentoGConstants.CLASS_ID, DocumentoGConstants.ARG_ID_SUBIRDOCUMENTOGESTORATO_DOCUMENTOGSUBIRDOCUMENTOGESTORATOPTHISDOCUMENTOG, DocumentoGConstants.SERV_ALIAS_SUBIRDOCUMENTOGESTORATO, DocumentoGConstants.CLASS_ALIAS, DocumentoGConstants.ARG_ALIAS_SUBIRDOCUMENTOGESTORATO_DOCUMENTOGSUBIRDOCUMENTOGESTORATOPTHISDOCUMENTOG);
        }
    }

    @JsonIgnore
    public String getDocumentoGsubirDocumentoGestorATOpExtension() {
        return this.documentoGsubirDocumentoGestorATOpExtension;
    }
    
    public void setDocumentoGsubirDocumentoGestorATOpExtension(String documentoGsubirDocumentoGestorATOpExtension) {
        this.documentoGsubirDocumentoGestorATOpExtension = documentoGsubirDocumentoGestorATOpExtension;
    }

    private void checkDocumentoGsubirDocumentoGestorATOpExtension() throws NotNullArgumentException {
        if(this.getDocumentoGsubirDocumentoGestorATOpExtension() == null) {
            throw new NotNullArgumentException(DocumentoGConstants.SERV_ID_SUBIRDOCUMENTOGESTORATO, DocumentoGConstants.CLASS_ID, DocumentoGConstants.ARG_ID_SUBIRDOCUMENTOGESTORATO_DOCUMENTOGSUBIRDOCUMENTOGESTORATOPEXTENSION, DocumentoGConstants.SERV_ALIAS_SUBIRDOCUMENTOGESTORATO, DocumentoGConstants.CLASS_ALIAS, DocumentoGConstants.ARG_ALIAS_SUBIRDOCUMENTOGESTORATO_DOCUMENTOGSUBIRDOCUMENTOGESTORATOPEXTENSION);
        }
    }

    @JsonIgnore
    public String getDocumentoGsubirDocumentoGestorATOpIdDocGestor() {
        return this.documentoGsubirDocumentoGestorATOpIdDocGestor;
    }
    
    public void setDocumentoGsubirDocumentoGestorATOpIdDocGestor(String documentoGsubirDocumentoGestorATOpIdDocGestor) {
        this.documentoGsubirDocumentoGestorATOpIdDocGestor = documentoGsubirDocumentoGestorATOpIdDocGestor;
    }

    private void checkDocumentoGsubirDocumentoGestorATOpIdDocGestor() throws NotNullArgumentException {
        if(this.getDocumentoGsubirDocumentoGestorATOpIdDocGestor() == null) {
            throw new NotNullArgumentException(DocumentoGConstants.SERV_ID_SUBIRDOCUMENTOGESTORATO, DocumentoGConstants.CLASS_ID, DocumentoGConstants.ARG_ID_SUBIRDOCUMENTOGESTORATO_DOCUMENTOGSUBIRDOCUMENTOGESTORATOPIDDOCGESTOR, DocumentoGConstants.SERV_ALIAS_SUBIRDOCUMENTOGESTORATO, DocumentoGConstants.CLASS_ALIAS, DocumentoGConstants.ARG_ALIAS_SUBIRDOCUMENTOGESTORATO_DOCUMENTOGSUBIRDOCUMENTOGESTORATOPIDDOCGESTOR);
        }
    }

    @JsonIgnore
    public String getDocumentoGsubirDocumentoGestorATOpNombre() {
        return this.documentoGsubirDocumentoGestorATOpNombre;
    }
    
    public void setDocumentoGsubirDocumentoGestorATOpNombre(String documentoGsubirDocumentoGestorATOpNombre) {
        this.documentoGsubirDocumentoGestorATOpNombre = documentoGsubirDocumentoGestorATOpNombre;
    }

    private void checkDocumentoGsubirDocumentoGestorATOpNombre() throws NotNullArgumentException {
        if(this.getDocumentoGsubirDocumentoGestorATOpNombre() == null) {
            throw new NotNullArgumentException(DocumentoGConstants.SERV_ID_SUBIRDOCUMENTOGESTORATO, DocumentoGConstants.CLASS_ID, DocumentoGConstants.ARG_ID_SUBIRDOCUMENTOGESTORATO_DOCUMENTOGSUBIRDOCUMENTOGESTORATOPNOMBRE, DocumentoGConstants.SERV_ALIAS_SUBIRDOCUMENTOGESTORATO, DocumentoGConstants.CLASS_ALIAS, DocumentoGConstants.ARG_ALIAS_SUBIRDOCUMENTOGESTORATO_DOCUMENTOGSUBIRDOCUMENTOGESTORATOPNOMBRE);
        }
    }
}
