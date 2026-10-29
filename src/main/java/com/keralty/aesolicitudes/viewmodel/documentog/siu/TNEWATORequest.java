package com.keralty.aesolicitudes.viewmodel.documentog.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DocumentoGConstants;
import com.keralty.aesolicitudes.persistence.oid.PersonaOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Persona;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class TNEWATORequest {

    @JsonProperty("pt_p_agrpersona_oid")
    private PersonaOid documentoGTNEWATOptpagrPersona;
    
    @JsonIgnore
    private Persona documentoGTNEWATOptpagrPersonaInstance;

    @JsonProperty("pt_p_agrsolicitud_oid")
    private SolicitudOid documentoGTNEWATOptpagrSolicitud;
    
    @JsonIgnore
    private Solicitud documentoGTNEWATOptpagrSolicitudInstance;

    @JsonProperty("pt_p_atrdescripcion")
    private String documentoGTNEWATOptpatrDescripcion;

    @JsonProperty("pt_p_atrtipo")
    private Long documentoGTNEWATOptpatrTipo;

    @JsonProperty("pt_p_atrestado")
    private Long documentoGTNEWATOptpatrEstado;

    @JsonProperty("pt_p_extension")
    private String documentoGTNEWATOptpExtension;

    @JsonProperty("piddocgestor")
    private String documentoGTNEWATOpIdDocGestor;

    @JsonProperty("ptnombre")
    private String documentoGTNEWATOptNombre;

    public void checkArguments() throws NotNullArgumentException {
        checkDocumentoGTNEWATOptpagrPersona();
        checkDocumentoGTNEWATOptpagrSolicitud();
        checkDocumentoGTNEWATOptpatrEstado();
        checkDocumentoGTNEWATOptpExtension();
        checkDocumentoGTNEWATOpIdDocGestor();
        checkDocumentoGTNEWATOptNombre();
    }

    @JsonIgnore
    public PersonaOid getDocumentoGTNEWATOptpagrPersona() {
        return this.documentoGTNEWATOptpagrPersona;
    }
    
    public void setDocumentoGTNEWATOptpagrPersona(PersonaOid documentoGTNEWATOptpagrPersona) {
        this.documentoGTNEWATOptpagrPersona = documentoGTNEWATOptpagrPersona;
    }

    @JsonIgnore
    public Persona getDocumentoGTNEWATOptpagrPersonaInstance() {
        return this.documentoGTNEWATOptpagrPersonaInstance;
    }
    
    public void setDocumentoGTNEWATOptpagrPersonaInstance(Persona documentoGTNEWATOptpagrPersona) {
        this.documentoGTNEWATOptpagrPersonaInstance = documentoGTNEWATOptpagrPersona;
        this.documentoGTNEWATOptpagrPersona = documentoGTNEWATOptpagrPersona != null ? documentoGTNEWATOptpagrPersona.getOid() : null;
    }

    private void checkDocumentoGTNEWATOptpagrPersona() throws NotNullArgumentException {
        if(this.getDocumentoGTNEWATOptpagrPersonaInstance() == null || this.getDocumentoGTNEWATOptpagrPersonaInstance().isNull()) {
            throw new NotNullArgumentException(DocumentoGConstants.SERV_ID_TNEWATO, DocumentoGConstants.CLASS_ID, DocumentoGConstants.ARG_ID_TNEWATO_DOCUMENTOGTNEWATOPTPAGRPERSONA, DocumentoGConstants.SERV_ALIAS_TNEWATO, DocumentoGConstants.CLASS_ALIAS, DocumentoGConstants.ARG_ALIAS_TNEWATO_DOCUMENTOGTNEWATOPTPAGRPERSONA);
        }
    }

    @JsonIgnore
    public SolicitudOid getDocumentoGTNEWATOptpagrSolicitud() {
        return this.documentoGTNEWATOptpagrSolicitud;
    }
    
    public void setDocumentoGTNEWATOptpagrSolicitud(SolicitudOid documentoGTNEWATOptpagrSolicitud) {
        this.documentoGTNEWATOptpagrSolicitud = documentoGTNEWATOptpagrSolicitud;
    }

    @JsonIgnore
    public Solicitud getDocumentoGTNEWATOptpagrSolicitudInstance() {
        return this.documentoGTNEWATOptpagrSolicitudInstance;
    }
    
    public void setDocumentoGTNEWATOptpagrSolicitudInstance(Solicitud documentoGTNEWATOptpagrSolicitud) {
        this.documentoGTNEWATOptpagrSolicitudInstance = documentoGTNEWATOptpagrSolicitud;
        this.documentoGTNEWATOptpagrSolicitud = documentoGTNEWATOptpagrSolicitud != null ? documentoGTNEWATOptpagrSolicitud.getOid() : null;
    }

    private void checkDocumentoGTNEWATOptpagrSolicitud() throws NotNullArgumentException {
        if(this.getDocumentoGTNEWATOptpagrSolicitudInstance() == null || this.getDocumentoGTNEWATOptpagrSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(DocumentoGConstants.SERV_ID_TNEWATO, DocumentoGConstants.CLASS_ID, DocumentoGConstants.ARG_ID_TNEWATO_DOCUMENTOGTNEWATOPTPAGRSOLICITUD, DocumentoGConstants.SERV_ALIAS_TNEWATO, DocumentoGConstants.CLASS_ALIAS, DocumentoGConstants.ARG_ALIAS_TNEWATO_DOCUMENTOGTNEWATOPTPAGRSOLICITUD);
        }
    }

    @JsonIgnore
    public String getDocumentoGTNEWATOptpatrDescripcion() {
        return this.documentoGTNEWATOptpatrDescripcion;
    }
    
    public void setDocumentoGTNEWATOptpatrDescripcion(String documentoGTNEWATOptpatrDescripcion) {
        this.documentoGTNEWATOptpatrDescripcion = documentoGTNEWATOptpatrDescripcion;
    }

    @JsonIgnore
    public Long getDocumentoGTNEWATOptpatrTipo() {
        return this.documentoGTNEWATOptpatrTipo;
    }
    
    public void setDocumentoGTNEWATOptpatrTipo(Long documentoGTNEWATOptpatrTipo) {
        this.documentoGTNEWATOptpatrTipo = documentoGTNEWATOptpatrTipo;
    }

    @JsonIgnore
    public Long getDocumentoGTNEWATOptpatrEstado() {
        return this.documentoGTNEWATOptpatrEstado;
    }
    
    public void setDocumentoGTNEWATOptpatrEstado(Long documentoGTNEWATOptpatrEstado) {
        this.documentoGTNEWATOptpatrEstado = documentoGTNEWATOptpatrEstado;
    }

    private void checkDocumentoGTNEWATOptpatrEstado() throws NotNullArgumentException {
        if(this.getDocumentoGTNEWATOptpatrEstado() == null) {
            throw new NotNullArgumentException(DocumentoGConstants.SERV_ID_TNEWATO, DocumentoGConstants.CLASS_ID, DocumentoGConstants.ARG_ID_TNEWATO_DOCUMENTOGTNEWATOPTPATRESTADO, DocumentoGConstants.SERV_ALIAS_TNEWATO, DocumentoGConstants.CLASS_ALIAS, DocumentoGConstants.ARG_ALIAS_TNEWATO_DOCUMENTOGTNEWATOPTPATRESTADO);
        }
    }

    @JsonIgnore
    public String getDocumentoGTNEWATOptpExtension() {
        return this.documentoGTNEWATOptpExtension;
    }
    
    public void setDocumentoGTNEWATOptpExtension(String documentoGTNEWATOptpExtension) {
        this.documentoGTNEWATOptpExtension = documentoGTNEWATOptpExtension;
    }

    private void checkDocumentoGTNEWATOptpExtension() throws NotNullArgumentException {
        if(this.getDocumentoGTNEWATOptpExtension() == null) {
            throw new NotNullArgumentException(DocumentoGConstants.SERV_ID_TNEWATO, DocumentoGConstants.CLASS_ID, DocumentoGConstants.ARG_ID_TNEWATO_DOCUMENTOGTNEWATOPTPEXTENSION, DocumentoGConstants.SERV_ALIAS_TNEWATO, DocumentoGConstants.CLASS_ALIAS, DocumentoGConstants.ARG_ALIAS_TNEWATO_DOCUMENTOGTNEWATOPTPEXTENSION);
        }
    }

    @JsonIgnore
    public String getDocumentoGTNEWATOpIdDocGestor() {
        return this.documentoGTNEWATOpIdDocGestor;
    }
    
    public void setDocumentoGTNEWATOpIdDocGestor(String documentoGTNEWATOpIdDocGestor) {
        this.documentoGTNEWATOpIdDocGestor = documentoGTNEWATOpIdDocGestor;
    }

    private void checkDocumentoGTNEWATOpIdDocGestor() throws NotNullArgumentException {
        if(this.getDocumentoGTNEWATOpIdDocGestor() == null) {
            throw new NotNullArgumentException(DocumentoGConstants.SERV_ID_TNEWATO, DocumentoGConstants.CLASS_ID, DocumentoGConstants.ARG_ID_TNEWATO_DOCUMENTOGTNEWATOPIDDOCGESTOR, DocumentoGConstants.SERV_ALIAS_TNEWATO, DocumentoGConstants.CLASS_ALIAS, DocumentoGConstants.ARG_ALIAS_TNEWATO_DOCUMENTOGTNEWATOPIDDOCGESTOR);
        }
    }

    @JsonIgnore
    public String getDocumentoGTNEWATOptNombre() {
        return this.documentoGTNEWATOptNombre;
    }
    
    public void setDocumentoGTNEWATOptNombre(String documentoGTNEWATOptNombre) {
        this.documentoGTNEWATOptNombre = documentoGTNEWATOptNombre;
    }

    private void checkDocumentoGTNEWATOptNombre() throws NotNullArgumentException {
        if(this.getDocumentoGTNEWATOptNombre() == null) {
            throw new NotNullArgumentException(DocumentoGConstants.SERV_ID_TNEWATO, DocumentoGConstants.CLASS_ID, DocumentoGConstants.ARG_ID_TNEWATO_DOCUMENTOGTNEWATOPTNOMBRE, DocumentoGConstants.SERV_ALIAS_TNEWATO, DocumentoGConstants.CLASS_ALIAS, DocumentoGConstants.ARG_ALIAS_TNEWATO_DOCUMENTOGTNEWATOPTNOMBRE);
        }
    }
}
