package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Persona;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class TSUBIRDOCUMENTOATORequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudTSUBIRDOCUMENTOATOpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudTSUBIRDOCUMENTOATOpthisSolicitudInstance;

    @JsonProperty("pt_p_atrdescripcion")
    private String solicitudTSUBIRDOCUMENTOATOptpatrDescripcion;

    @JsonProperty("pt_p_atrtipo")
    private Long solicitudTSUBIRDOCUMENTOATOptpatrTipo;

    @JsonProperty("pt_p_extension")
    private String solicitudTSUBIRDOCUMENTOATOptpExtension;

    @JsonProperty("ptpersona_json")
    private String solicitudTSUBIRDOCUMENTOATOptPersona;
    
    @JsonIgnore
    private Persona solicitudTSUBIRDOCUMENTOATOptPersonaInstance;

    @JsonProperty("ptiddocgestor")
    private String solicitudTSUBIRDOCUMENTOATOptIdDocGestor;

    @JsonProperty("ptnombre")
    private String solicitudTSUBIRDOCUMENTOATOptNombre;

    @JsonProperty("pffichero")
    private byte[] solicitudTSUBIRDOCUMENTOATOpfFichero;

    @JsonProperty("ptnumsolicitud")
    private Long solicitudTSUBIRDOCUMENTOATOptNumSolicitud;

    @JsonProperty("ptnumidentusuario")
    private String solicitudTSUBIRDOCUMENTOATOptNumIdentUsuario;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudTSUBIRDOCUMENTOATOpthisSolicitud();
        checkSolicitudTSUBIRDOCUMENTOATOptPersona();
        checkSolicitudTSUBIRDOCUMENTOATOptIdDocGestor();
        checkSolicitudTSUBIRDOCUMENTOATOptNombre();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudTSUBIRDOCUMENTOATOpthisSolicitud() {
        return this.solicitudTSUBIRDOCUMENTOATOpthisSolicitud;
    }
    
    public void setSolicitudTSUBIRDOCUMENTOATOpthisSolicitud(SolicitudOid solicitudTSUBIRDOCUMENTOATOpthisSolicitud) {
        this.solicitudTSUBIRDOCUMENTOATOpthisSolicitud = solicitudTSUBIRDOCUMENTOATOpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudTSUBIRDOCUMENTOATOpthisSolicitudInstance() {
        return this.solicitudTSUBIRDOCUMENTOATOpthisSolicitudInstance;
    }
    
    public void setSolicitudTSUBIRDOCUMENTOATOpthisSolicitudInstance(Solicitud solicitudTSUBIRDOCUMENTOATOpthisSolicitud) {
        this.solicitudTSUBIRDOCUMENTOATOpthisSolicitudInstance = solicitudTSUBIRDOCUMENTOATOpthisSolicitud;
        this.solicitudTSUBIRDOCUMENTOATOpthisSolicitud = solicitudTSUBIRDOCUMENTOATOpthisSolicitud != null ? solicitudTSUBIRDOCUMENTOATOpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudTSUBIRDOCUMENTOATOpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudTSUBIRDOCUMENTOATOpthisSolicitudInstance() == null || this.getSolicitudTSUBIRDOCUMENTOATOpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TSUBIRDOCUMENTOATO, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TSUBIRDOCUMENTOATO_SOLICITUDTSUBIRDOCUMENTOATOPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_TSUBIRDOCUMENTOATO, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TSUBIRDOCUMENTOATO_SOLICITUDTSUBIRDOCUMENTOATOPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public String getSolicitudTSUBIRDOCUMENTOATOptpatrDescripcion() {
        return this.solicitudTSUBIRDOCUMENTOATOptpatrDescripcion;
    }
    
    public void setSolicitudTSUBIRDOCUMENTOATOptpatrDescripcion(String solicitudTSUBIRDOCUMENTOATOptpatrDescripcion) {
        this.solicitudTSUBIRDOCUMENTOATOptpatrDescripcion = solicitudTSUBIRDOCUMENTOATOptpatrDescripcion;
    }

    @JsonIgnore
    public Long getSolicitudTSUBIRDOCUMENTOATOptpatrTipo() {
        return this.solicitudTSUBIRDOCUMENTOATOptpatrTipo;
    }
    
    public void setSolicitudTSUBIRDOCUMENTOATOptpatrTipo(Long solicitudTSUBIRDOCUMENTOATOptpatrTipo) {
        this.solicitudTSUBIRDOCUMENTOATOptpatrTipo = solicitudTSUBIRDOCUMENTOATOptpatrTipo;
    }

    @JsonIgnore
    public String getSolicitudTSUBIRDOCUMENTOATOptpExtension() {
        return this.solicitudTSUBIRDOCUMENTOATOptpExtension;
    }
    
    public void setSolicitudTSUBIRDOCUMENTOATOptpExtension(String solicitudTSUBIRDOCUMENTOATOptpExtension) {
        this.solicitudTSUBIRDOCUMENTOATOptpExtension = solicitudTSUBIRDOCUMENTOATOptpExtension;
    }

    @JsonIgnore
    public String getSolicitudTSUBIRDOCUMENTOATOptPersona() {
        return this.solicitudTSUBIRDOCUMENTOATOptPersona;
    }
    
    public void setSolicitudTSUBIRDOCUMENTOATOptPersona(String solicitudTSUBIRDOCUMENTOATOptPersona) {
        this.solicitudTSUBIRDOCUMENTOATOptPersona = solicitudTSUBIRDOCUMENTOATOptPersona;
    }

    @JsonIgnore
    public Persona getSolicitudTSUBIRDOCUMENTOATOptPersonaInstance() {
        return this.solicitudTSUBIRDOCUMENTOATOptPersonaInstance;
    }
    
    public void setSolicitudTSUBIRDOCUMENTOATOptPersonaInstance(Persona solicitudTSUBIRDOCUMENTOATOptPersona) {
        this.solicitudTSUBIRDOCUMENTOATOptPersonaInstance = solicitudTSUBIRDOCUMENTOATOptPersona;
        this.solicitudTSUBIRDOCUMENTOATOptPersona = solicitudTSUBIRDOCUMENTOATOptPersona != null ? solicitudTSUBIRDOCUMENTOATOptPersona.getOid().toJson() : "";
    }

    private void checkSolicitudTSUBIRDOCUMENTOATOptPersona() throws NotNullArgumentException {
        if(this.getSolicitudTSUBIRDOCUMENTOATOptPersonaInstance() == null || this.getSolicitudTSUBIRDOCUMENTOATOptPersonaInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TSUBIRDOCUMENTOATO, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TSUBIRDOCUMENTOATO_SOLICITUDTSUBIRDOCUMENTOATOPTPERSONA, SolicitudConstants.SERV_ALIAS_TSUBIRDOCUMENTOATO, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TSUBIRDOCUMENTOATO_SOLICITUDTSUBIRDOCUMENTOATOPTPERSONA);
        }
    }

    @JsonIgnore
    public String getSolicitudTSUBIRDOCUMENTOATOptIdDocGestor() {
        return this.solicitudTSUBIRDOCUMENTOATOptIdDocGestor;
    }
    
    public void setSolicitudTSUBIRDOCUMENTOATOptIdDocGestor(String solicitudTSUBIRDOCUMENTOATOptIdDocGestor) {
        this.solicitudTSUBIRDOCUMENTOATOptIdDocGestor = solicitudTSUBIRDOCUMENTOATOptIdDocGestor;
    }

    private void checkSolicitudTSUBIRDOCUMENTOATOptIdDocGestor() throws NotNullArgumentException {
        if(this.getSolicitudTSUBIRDOCUMENTOATOptIdDocGestor() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TSUBIRDOCUMENTOATO, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TSUBIRDOCUMENTOATO_SOLICITUDTSUBIRDOCUMENTOATOPTIDDOCGESTOR, SolicitudConstants.SERV_ALIAS_TSUBIRDOCUMENTOATO, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TSUBIRDOCUMENTOATO_SOLICITUDTSUBIRDOCUMENTOATOPTIDDOCGESTOR);
        }
    }

    @JsonIgnore
    public String getSolicitudTSUBIRDOCUMENTOATOptNombre() {
        return this.solicitudTSUBIRDOCUMENTOATOptNombre;
    }
    
    public void setSolicitudTSUBIRDOCUMENTOATOptNombre(String solicitudTSUBIRDOCUMENTOATOptNombre) {
        this.solicitudTSUBIRDOCUMENTOATOptNombre = solicitudTSUBIRDOCUMENTOATOptNombre;
    }

    private void checkSolicitudTSUBIRDOCUMENTOATOptNombre() throws NotNullArgumentException {
        if(this.getSolicitudTSUBIRDOCUMENTOATOptNombre() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TSUBIRDOCUMENTOATO, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TSUBIRDOCUMENTOATO_SOLICITUDTSUBIRDOCUMENTOATOPTNOMBRE, SolicitudConstants.SERV_ALIAS_TSUBIRDOCUMENTOATO, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TSUBIRDOCUMENTOATO_SOLICITUDTSUBIRDOCUMENTOATOPTNOMBRE);
        }
    }

    @JsonIgnore
    public byte[] getSolicitudTSUBIRDOCUMENTOATOpfFichero() {
        return this.solicitudTSUBIRDOCUMENTOATOpfFichero;
    }
    
    public void setSolicitudTSUBIRDOCUMENTOATOpfFichero(byte[] solicitudTSUBIRDOCUMENTOATOpfFichero) {
        this.solicitudTSUBIRDOCUMENTOATOpfFichero = solicitudTSUBIRDOCUMENTOATOpfFichero;
    }

    @JsonIgnore
    public Long getSolicitudTSUBIRDOCUMENTOATOptNumSolicitud() {
        return this.solicitudTSUBIRDOCUMENTOATOptNumSolicitud;
    }
    
    public void setSolicitudTSUBIRDOCUMENTOATOptNumSolicitud(Long solicitudTSUBIRDOCUMENTOATOptNumSolicitud) {
        this.solicitudTSUBIRDOCUMENTOATOptNumSolicitud = solicitudTSUBIRDOCUMENTOATOptNumSolicitud;
    }

    @JsonIgnore
    public String getSolicitudTSUBIRDOCUMENTOATOptNumIdentUsuario() {
        return this.solicitudTSUBIRDOCUMENTOATOptNumIdentUsuario;
    }
    
    public void setSolicitudTSUBIRDOCUMENTOATOptNumIdentUsuario(String solicitudTSUBIRDOCUMENTOATOptNumIdentUsuario) {
        this.solicitudTSUBIRDOCUMENTOATOptNumIdentUsuario = solicitudTSUBIRDOCUMENTOATOptNumIdentUsuario;
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
