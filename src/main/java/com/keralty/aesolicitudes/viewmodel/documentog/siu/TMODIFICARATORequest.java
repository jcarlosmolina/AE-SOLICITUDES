package com.keralty.aesolicitudes.viewmodel.documentog.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DocumentoGConstants;
import com.keralty.aesolicitudes.persistence.DocumentoG;
import com.keralty.aesolicitudes.persistence.oid.DocumentoGOid;
import java.sql.Timestamp;

public class TMODIFICARATORequest {

    @JsonProperty("p_thisdocumentog_oid")
    private DocumentoGOid documentoGTMODIFICARATOpthisDocumentoG;
    
    @JsonIgnore
    private DocumentoG documentoGTMODIFICARATOpthisDocumentoGInstance;

    @JsonProperty("pt_p_descripcion")
    private String documentoGTMODIFICARATOptpDescripcion;

    @JsonProperty("pt_p_tipo")
    private Long documentoGTMODIFICARATOptpTipo;

    @JsonProperty("pt_p_estado")
    private Long documentoGTMODIFICARATOptpEstado;

    @JsonProperty("pt_p_fechasubida")
    private Timestamp documentoGTMODIFICARATOptpFechaSubida;

    @JsonProperty("ptiddocgestor")
    private String documentoGTMODIFICARATOptIdDocGestor;

    @JsonProperty("pt_p_extension")
    private String documentoGTMODIFICARATOptpExtension;

    @JsonProperty("ptnombre")
    private String documentoGTMODIFICARATOptNombre;

    public void checkArguments() throws NotNullArgumentException {
        checkDocumentoGTMODIFICARATOpthisDocumentoG();
        checkDocumentoGTMODIFICARATOptpEstado();
        checkDocumentoGTMODIFICARATOptpFechaSubida();
        checkDocumentoGTMODIFICARATOptIdDocGestor();
        checkDocumentoGTMODIFICARATOptpExtension();
        checkDocumentoGTMODIFICARATOptNombre();
    }

    @JsonIgnore
    public DocumentoGOid getDocumentoGTMODIFICARATOpthisDocumentoG() {
        return this.documentoGTMODIFICARATOpthisDocumentoG;
    }
    
    public void setDocumentoGTMODIFICARATOpthisDocumentoG(DocumentoGOid documentoGTMODIFICARATOpthisDocumentoG) {
        this.documentoGTMODIFICARATOpthisDocumentoG = documentoGTMODIFICARATOpthisDocumentoG;
    }

    @JsonIgnore
    public DocumentoG getDocumentoGTMODIFICARATOpthisDocumentoGInstance() {
        return this.documentoGTMODIFICARATOpthisDocumentoGInstance;
    }
    
    public void setDocumentoGTMODIFICARATOpthisDocumentoGInstance(DocumentoG documentoGTMODIFICARATOpthisDocumentoG) {
        this.documentoGTMODIFICARATOpthisDocumentoGInstance = documentoGTMODIFICARATOpthisDocumentoG;
        this.documentoGTMODIFICARATOpthisDocumentoG = documentoGTMODIFICARATOpthisDocumentoG != null ? documentoGTMODIFICARATOpthisDocumentoG.getOid() : null;
    }

    private void checkDocumentoGTMODIFICARATOpthisDocumentoG() throws NotNullArgumentException {
        if(this.getDocumentoGTMODIFICARATOpthisDocumentoGInstance() == null || this.getDocumentoGTMODIFICARATOpthisDocumentoGInstance().isNull()) {
            throw new NotNullArgumentException(DocumentoGConstants.SERV_ID_TMODIFICARATO, DocumentoGConstants.CLASS_ID, DocumentoGConstants.ARG_ID_TMODIFICARATO_DOCUMENTOGTMODIFICARATOPTHISDOCUMENTOG, DocumentoGConstants.SERV_ALIAS_TMODIFICARATO, DocumentoGConstants.CLASS_ALIAS, DocumentoGConstants.ARG_ALIAS_TMODIFICARATO_DOCUMENTOGTMODIFICARATOPTHISDOCUMENTOG);
        }
    }

    @JsonIgnore
    public String getDocumentoGTMODIFICARATOptpDescripcion() {
        return this.documentoGTMODIFICARATOptpDescripcion;
    }
    
    public void setDocumentoGTMODIFICARATOptpDescripcion(String documentoGTMODIFICARATOptpDescripcion) {
        this.documentoGTMODIFICARATOptpDescripcion = documentoGTMODIFICARATOptpDescripcion;
    }

    @JsonIgnore
    public Long getDocumentoGTMODIFICARATOptpTipo() {
        return this.documentoGTMODIFICARATOptpTipo;
    }
    
    public void setDocumentoGTMODIFICARATOptpTipo(Long documentoGTMODIFICARATOptpTipo) {
        this.documentoGTMODIFICARATOptpTipo = documentoGTMODIFICARATOptpTipo;
    }

    @JsonIgnore
    public Long getDocumentoGTMODIFICARATOptpEstado() {
        return this.documentoGTMODIFICARATOptpEstado;
    }
    
    public void setDocumentoGTMODIFICARATOptpEstado(Long documentoGTMODIFICARATOptpEstado) {
        this.documentoGTMODIFICARATOptpEstado = documentoGTMODIFICARATOptpEstado;
    }

    private void checkDocumentoGTMODIFICARATOptpEstado() throws NotNullArgumentException {
        if(this.getDocumentoGTMODIFICARATOptpEstado() == null) {
            throw new NotNullArgumentException(DocumentoGConstants.SERV_ID_TMODIFICARATO, DocumentoGConstants.CLASS_ID, DocumentoGConstants.ARG_ID_TMODIFICARATO_DOCUMENTOGTMODIFICARATOPTPESTADO, DocumentoGConstants.SERV_ALIAS_TMODIFICARATO, DocumentoGConstants.CLASS_ALIAS, DocumentoGConstants.ARG_ALIAS_TMODIFICARATO_DOCUMENTOGTMODIFICARATOPTPESTADO);
        }
    }

    @JsonIgnore
    public Timestamp getDocumentoGTMODIFICARATOptpFechaSubida() {
        return this.documentoGTMODIFICARATOptpFechaSubida;
    }
    
    public void setDocumentoGTMODIFICARATOptpFechaSubida(Timestamp documentoGTMODIFICARATOptpFechaSubida) {
        this.documentoGTMODIFICARATOptpFechaSubida = documentoGTMODIFICARATOptpFechaSubida;
    }

    private void checkDocumentoGTMODIFICARATOptpFechaSubida() throws NotNullArgumentException {
        if(this.getDocumentoGTMODIFICARATOptpFechaSubida() == null) {
            throw new NotNullArgumentException(DocumentoGConstants.SERV_ID_TMODIFICARATO, DocumentoGConstants.CLASS_ID, DocumentoGConstants.ARG_ID_TMODIFICARATO_DOCUMENTOGTMODIFICARATOPTPFECHASUBIDA, DocumentoGConstants.SERV_ALIAS_TMODIFICARATO, DocumentoGConstants.CLASS_ALIAS, DocumentoGConstants.ARG_ALIAS_TMODIFICARATO_DOCUMENTOGTMODIFICARATOPTPFECHASUBIDA);
        }
    }

    @JsonIgnore
    public String getDocumentoGTMODIFICARATOptIdDocGestor() {
        return this.documentoGTMODIFICARATOptIdDocGestor;
    }
    
    public void setDocumentoGTMODIFICARATOptIdDocGestor(String documentoGTMODIFICARATOptIdDocGestor) {
        this.documentoGTMODIFICARATOptIdDocGestor = documentoGTMODIFICARATOptIdDocGestor;
    }

    private void checkDocumentoGTMODIFICARATOptIdDocGestor() throws NotNullArgumentException {
        if(this.getDocumentoGTMODIFICARATOptIdDocGestor() == null) {
            throw new NotNullArgumentException(DocumentoGConstants.SERV_ID_TMODIFICARATO, DocumentoGConstants.CLASS_ID, DocumentoGConstants.ARG_ID_TMODIFICARATO_DOCUMENTOGTMODIFICARATOPTIDDOCGESTOR, DocumentoGConstants.SERV_ALIAS_TMODIFICARATO, DocumentoGConstants.CLASS_ALIAS, DocumentoGConstants.ARG_ALIAS_TMODIFICARATO_DOCUMENTOGTMODIFICARATOPTIDDOCGESTOR);
        }
    }

    @JsonIgnore
    public String getDocumentoGTMODIFICARATOptpExtension() {
        return this.documentoGTMODIFICARATOptpExtension;
    }
    
    public void setDocumentoGTMODIFICARATOptpExtension(String documentoGTMODIFICARATOptpExtension) {
        this.documentoGTMODIFICARATOptpExtension = documentoGTMODIFICARATOptpExtension;
    }

    private void checkDocumentoGTMODIFICARATOptpExtension() throws NotNullArgumentException {
        if(this.getDocumentoGTMODIFICARATOptpExtension() == null) {
            throw new NotNullArgumentException(DocumentoGConstants.SERV_ID_TMODIFICARATO, DocumentoGConstants.CLASS_ID, DocumentoGConstants.ARG_ID_TMODIFICARATO_DOCUMENTOGTMODIFICARATOPTPEXTENSION, DocumentoGConstants.SERV_ALIAS_TMODIFICARATO, DocumentoGConstants.CLASS_ALIAS, DocumentoGConstants.ARG_ALIAS_TMODIFICARATO_DOCUMENTOGTMODIFICARATOPTPEXTENSION);
        }
    }

    @JsonIgnore
    public String getDocumentoGTMODIFICARATOptNombre() {
        return this.documentoGTMODIFICARATOptNombre;
    }
    
    public void setDocumentoGTMODIFICARATOptNombre(String documentoGTMODIFICARATOptNombre) {
        this.documentoGTMODIFICARATOptNombre = documentoGTMODIFICARATOptNombre;
    }

    private void checkDocumentoGTMODIFICARATOptNombre() throws NotNullArgumentException {
        if(this.getDocumentoGTMODIFICARATOptNombre() == null) {
            throw new NotNullArgumentException(DocumentoGConstants.SERV_ID_TMODIFICARATO, DocumentoGConstants.CLASS_ID, DocumentoGConstants.ARG_ID_TMODIFICARATO_DOCUMENTOGTMODIFICARATOPTNOMBRE, DocumentoGConstants.SERV_ALIAS_TMODIFICARATO, DocumentoGConstants.CLASS_ALIAS, DocumentoGConstants.ARG_ALIAS_TMODIFICARATO_DOCUMENTOGTMODIFICARATOPTNOMBRE);
        }
    }
}
