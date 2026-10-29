package com.keralty.aesolicitudes.viewmodel.documentog.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DocumentoGConstants;
import com.keralty.aesolicitudes.persistence.DocumentoG;
import com.keralty.aesolicitudes.persistence.oid.DocumentoGOid;
import java.sql.Timestamp;

public class ModificarRequest {

    @JsonProperty("p_thisdocumentog_oid")
    private DocumentoGOid documentoGmodificarpthisDocumentoG;
    
    @JsonIgnore
    private DocumentoG documentoGmodificarpthisDocumentoGInstance;

    @JsonProperty("p_descripcion")
    private String documentoGmodificarpDescripcion;

    @JsonProperty("p_tipo")
    private Long documentoGmodificarpTipo;

    @JsonProperty("p_estado")
    private Long documentoGmodificarpEstado;

    @JsonProperty("p_fechasubida")
    private Timestamp documentoGmodificarpFechaSubida;

    public void checkArguments() throws NotNullArgumentException {
        checkDocumentoGmodificarpthisDocumentoG();
        checkDocumentoGmodificarpEstado();
        checkDocumentoGmodificarpFechaSubida();
    }

    @JsonIgnore
    public DocumentoGOid getDocumentoGmodificarpthisDocumentoG() {
        return this.documentoGmodificarpthisDocumentoG;
    }
    
    public void setDocumentoGmodificarpthisDocumentoG(DocumentoGOid documentoGmodificarpthisDocumentoG) {
        this.documentoGmodificarpthisDocumentoG = documentoGmodificarpthisDocumentoG;
    }

    @JsonIgnore
    public DocumentoG getDocumentoGmodificarpthisDocumentoGInstance() {
        return this.documentoGmodificarpthisDocumentoGInstance;
    }
    
    public void setDocumentoGmodificarpthisDocumentoGInstance(DocumentoG documentoGmodificarpthisDocumentoG) {
        this.documentoGmodificarpthisDocumentoGInstance = documentoGmodificarpthisDocumentoG;
        this.documentoGmodificarpthisDocumentoG = documentoGmodificarpthisDocumentoG != null ? documentoGmodificarpthisDocumentoG.getOid() : null;
    }

    private void checkDocumentoGmodificarpthisDocumentoG() throws NotNullArgumentException {
        if(this.getDocumentoGmodificarpthisDocumentoGInstance() == null || this.getDocumentoGmodificarpthisDocumentoGInstance().isNull()) {
            throw new NotNullArgumentException(DocumentoGConstants.SERV_ID_MODIFICAR, DocumentoGConstants.CLASS_ID, DocumentoGConstants.ARG_ID_MODIFICAR_DOCUMENTOGMODIFICARPTHISDOCUMENTOG, DocumentoGConstants.SERV_ALIAS_MODIFICAR, DocumentoGConstants.CLASS_ALIAS, DocumentoGConstants.ARG_ALIAS_MODIFICAR_DOCUMENTOGMODIFICARPTHISDOCUMENTOG);
        }
    }

    @JsonIgnore
    public String getDocumentoGmodificarpDescripcion() {
        return this.documentoGmodificarpDescripcion;
    }
    
    public void setDocumentoGmodificarpDescripcion(String documentoGmodificarpDescripcion) {
        this.documentoGmodificarpDescripcion = documentoGmodificarpDescripcion;
    }

    @JsonIgnore
    public Long getDocumentoGmodificarpTipo() {
        return this.documentoGmodificarpTipo;
    }
    
    public void setDocumentoGmodificarpTipo(Long documentoGmodificarpTipo) {
        this.documentoGmodificarpTipo = documentoGmodificarpTipo;
    }

    @JsonIgnore
    public Long getDocumentoGmodificarpEstado() {
        return this.documentoGmodificarpEstado;
    }
    
    public void setDocumentoGmodificarpEstado(Long documentoGmodificarpEstado) {
        this.documentoGmodificarpEstado = documentoGmodificarpEstado;
    }

    private void checkDocumentoGmodificarpEstado() throws NotNullArgumentException {
        if(this.getDocumentoGmodificarpEstado() == null) {
            throw new NotNullArgumentException(DocumentoGConstants.SERV_ID_MODIFICAR, DocumentoGConstants.CLASS_ID, DocumentoGConstants.ARG_ID_MODIFICAR_DOCUMENTOGMODIFICARPESTADO, DocumentoGConstants.SERV_ALIAS_MODIFICAR, DocumentoGConstants.CLASS_ALIAS, DocumentoGConstants.ARG_ALIAS_MODIFICAR_DOCUMENTOGMODIFICARPESTADO);
        }
    }

    @JsonIgnore
    public Timestamp getDocumentoGmodificarpFechaSubida() {
        return this.documentoGmodificarpFechaSubida;
    }
    
    public void setDocumentoGmodificarpFechaSubida(Timestamp documentoGmodificarpFechaSubida) {
        this.documentoGmodificarpFechaSubida = documentoGmodificarpFechaSubida;
    }

    private void checkDocumentoGmodificarpFechaSubida() throws NotNullArgumentException {
        if(this.getDocumentoGmodificarpFechaSubida() == null) {
            throw new NotNullArgumentException(DocumentoGConstants.SERV_ID_MODIFICAR, DocumentoGConstants.CLASS_ID, DocumentoGConstants.ARG_ID_MODIFICAR_DOCUMENTOGMODIFICARPFECHASUBIDA, DocumentoGConstants.SERV_ALIAS_MODIFICAR, DocumentoGConstants.CLASS_ALIAS, DocumentoGConstants.ARG_ALIAS_MODIFICAR_DOCUMENTOGMODIFICARPFECHASUBIDA);
        }
    }
}
