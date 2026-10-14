package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.Departamento;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.oid.PaisOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Pais;
import com.keralty.aesolicitudes.persistence.Solicitud;

public class TMODDIRSCONTRATANTERequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudTMODDIRSCONTRATANTEpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudTMODDIRSCONTRATANTEpthisSolicitudInstance;

    @JsonProperty("pt_p_telefonofijo")
    private String solicitudTMODDIRSCONTRATANTEptpTelefonoFijo;

    @JsonProperty("pt_p_telefonocelular")
    private String solicitudTMODDIRSCONTRATANTEptpTelefonoCelular;

    @JsonProperty("pt_p_direccioncompleta")
    private String solicitudTMODDIRSCONTRATANTEptpDireccionCompleta;

    @JsonProperty("pt_p_rural")
    private Boolean solicitudTMODDIRSCONTRATANTEptpRural;

    @JsonProperty("pt_p_evcdepartamento_json")
    private String solicitudTMODDIRSCONTRATANTEptpevcDepartamento;
    
    @JsonIgnore
    private Departamento solicitudTMODDIRSCONTRATANTEptpevcDepartamentoInstance;

    @JsonProperty("pt_p_evcmunicipio_json")
    private String solicitudTMODDIRSCONTRATANTEptpevcMunicipio;
    
    @JsonIgnore
    private Municipio solicitudTMODDIRSCONTRATANTEptpevcMunicipioInstance;

    @JsonProperty("pt_pdcdireccioncompleta")
    private String solicitudTMODDIRSCONTRATANTEptpDCDireccionCompleta;

    @JsonProperty("pt_pdcdepartamento_json")
    private String solicitudTMODDIRSCONTRATANTEptpDCDepartamento;
    
    @JsonIgnore
    private Departamento solicitudTMODDIRSCONTRATANTEptpDCDepartamentoInstance;

    @JsonProperty("pt_pdcmunicipio_json")
    private String solicitudTMODDIRSCONTRATANTEptpDCMunicipio;
    
    @JsonIgnore
    private Municipio solicitudTMODDIRSCONTRATANTEptpDCMunicipioInstance;

    @JsonProperty("pt_pdcrural")
    private Boolean solicitudTMODDIRSCONTRATANTEptpDCRural;

    @JsonProperty("pt_pdctelefonofijo")
    private String solicitudTMODDIRSCONTRATANTEptpDCTelefonoFijo;

    @JsonProperty("pt_pdctelefonocelular")
    private String solicitudTMODDIRSCONTRATANTEptpDCTelefonoCelular;

    @JsonProperty("pt_p_pais_oid")
    private PaisOid solicitudTMODDIRSCONTRATANTEptpPais;
    
    @JsonIgnore
    private Pais solicitudTMODDIRSCONTRATANTEptpPaisInstance;

    @JsonProperty("pdcpais_oid")
    private PaisOid solicitudTMODDIRSCONTRATANTEpDCPais;
    
    @JsonIgnore
    private Pais solicitudTMODDIRSCONTRATANTEpDCPaisInstance;

    @JsonProperty("ptreplicardireccion")
    private Boolean solicitudTMODDIRSCONTRATANTEptReplicarDireccion;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudTMODDIRSCONTRATANTEpthisSolicitud();
        checkSolicitudTMODDIRSCONTRATANTEptpRural();
        checkSolicitudTMODDIRSCONTRATANTEptpDCRural();
        checkSolicitudTMODDIRSCONTRATANTEptReplicarDireccion();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudTMODDIRSCONTRATANTEpthisSolicitud() {
        return this.solicitudTMODDIRSCONTRATANTEpthisSolicitud;
    }
    
    public void setSolicitudTMODDIRSCONTRATANTEpthisSolicitud(SolicitudOid solicitudTMODDIRSCONTRATANTEpthisSolicitud) {
        this.solicitudTMODDIRSCONTRATANTEpthisSolicitud = solicitudTMODDIRSCONTRATANTEpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudTMODDIRSCONTRATANTEpthisSolicitudInstance() {
        return this.solicitudTMODDIRSCONTRATANTEpthisSolicitudInstance;
    }
    
    public void setSolicitudTMODDIRSCONTRATANTEpthisSolicitudInstance(Solicitud solicitudTMODDIRSCONTRATANTEpthisSolicitud) {
        this.solicitudTMODDIRSCONTRATANTEpthisSolicitudInstance = solicitudTMODDIRSCONTRATANTEpthisSolicitud;
        this.solicitudTMODDIRSCONTRATANTEpthisSolicitud = solicitudTMODDIRSCONTRATANTEpthisSolicitud != null ? solicitudTMODDIRSCONTRATANTEpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudTMODDIRSCONTRATANTEpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudTMODDIRSCONTRATANTEpthisSolicitudInstance() == null || this.getSolicitudTMODDIRSCONTRATANTEpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TMODDIRSCONTRATANTE, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TMODDIRSCONTRATANTE_SOLICITUDTMODDIRSCONTRATANTEPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_TMODDIRSCONTRATANTE, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TMODDIRSCONTRATANTE_SOLICITUDTMODDIRSCONTRATANTEPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public String getSolicitudTMODDIRSCONTRATANTEptpTelefonoFijo() {
        return this.solicitudTMODDIRSCONTRATANTEptpTelefonoFijo;
    }
    
    public void setSolicitudTMODDIRSCONTRATANTEptpTelefonoFijo(String solicitudTMODDIRSCONTRATANTEptpTelefonoFijo) {
        this.solicitudTMODDIRSCONTRATANTEptpTelefonoFijo = solicitudTMODDIRSCONTRATANTEptpTelefonoFijo;
    }

    @JsonIgnore
    public String getSolicitudTMODDIRSCONTRATANTEptpTelefonoCelular() {
        return this.solicitudTMODDIRSCONTRATANTEptpTelefonoCelular;
    }
    
    public void setSolicitudTMODDIRSCONTRATANTEptpTelefonoCelular(String solicitudTMODDIRSCONTRATANTEptpTelefonoCelular) {
        this.solicitudTMODDIRSCONTRATANTEptpTelefonoCelular = solicitudTMODDIRSCONTRATANTEptpTelefonoCelular;
    }

    @JsonIgnore
    public String getSolicitudTMODDIRSCONTRATANTEptpDireccionCompleta() {
        return this.solicitudTMODDIRSCONTRATANTEptpDireccionCompleta;
    }
    
    public void setSolicitudTMODDIRSCONTRATANTEptpDireccionCompleta(String solicitudTMODDIRSCONTRATANTEptpDireccionCompleta) {
        this.solicitudTMODDIRSCONTRATANTEptpDireccionCompleta = solicitudTMODDIRSCONTRATANTEptpDireccionCompleta;
    }

    @JsonIgnore
    public Boolean getSolicitudTMODDIRSCONTRATANTEptpRural() {
        return this.solicitudTMODDIRSCONTRATANTEptpRural;
    }
    
    public void setSolicitudTMODDIRSCONTRATANTEptpRural(Boolean solicitudTMODDIRSCONTRATANTEptpRural) {
        this.solicitudTMODDIRSCONTRATANTEptpRural = solicitudTMODDIRSCONTRATANTEptpRural;
    }

    private void checkSolicitudTMODDIRSCONTRATANTEptpRural() throws NotNullArgumentException {
        if(this.getSolicitudTMODDIRSCONTRATANTEptpRural() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TMODDIRSCONTRATANTE, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TMODDIRSCONTRATANTE_SOLICITUDTMODDIRSCONTRATANTEPTPRURAL, SolicitudConstants.SERV_ALIAS_TMODDIRSCONTRATANTE, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TMODDIRSCONTRATANTE_SOLICITUDTMODDIRSCONTRATANTEPTPRURAL);
        }
    }

    @JsonIgnore
    public String getSolicitudTMODDIRSCONTRATANTEptpevcDepartamento() {
        return this.solicitudTMODDIRSCONTRATANTEptpevcDepartamento;
    }
    
    public void setSolicitudTMODDIRSCONTRATANTEptpevcDepartamento(String solicitudTMODDIRSCONTRATANTEptpevcDepartamento) {
        this.solicitudTMODDIRSCONTRATANTEptpevcDepartamento = solicitudTMODDIRSCONTRATANTEptpevcDepartamento;
    }

    @JsonIgnore
    public Departamento getSolicitudTMODDIRSCONTRATANTEptpevcDepartamentoInstance() {
        return this.solicitudTMODDIRSCONTRATANTEptpevcDepartamentoInstance;
    }
    
    public void setSolicitudTMODDIRSCONTRATANTEptpevcDepartamentoInstance(Departamento solicitudTMODDIRSCONTRATANTEptpevcDepartamento) {
        this.solicitudTMODDIRSCONTRATANTEptpevcDepartamentoInstance = solicitudTMODDIRSCONTRATANTEptpevcDepartamento;
        this.solicitudTMODDIRSCONTRATANTEptpevcDepartamento = solicitudTMODDIRSCONTRATANTEptpevcDepartamento != null ? solicitudTMODDIRSCONTRATANTEptpevcDepartamento.getOid().toJson() : "";
    }

    @JsonIgnore
    public String getSolicitudTMODDIRSCONTRATANTEptpevcMunicipio() {
        return this.solicitudTMODDIRSCONTRATANTEptpevcMunicipio;
    }
    
    public void setSolicitudTMODDIRSCONTRATANTEptpevcMunicipio(String solicitudTMODDIRSCONTRATANTEptpevcMunicipio) {
        this.solicitudTMODDIRSCONTRATANTEptpevcMunicipio = solicitudTMODDIRSCONTRATANTEptpevcMunicipio;
    }

    @JsonIgnore
    public Municipio getSolicitudTMODDIRSCONTRATANTEptpevcMunicipioInstance() {
        return this.solicitudTMODDIRSCONTRATANTEptpevcMunicipioInstance;
    }
    
    public void setSolicitudTMODDIRSCONTRATANTEptpevcMunicipioInstance(Municipio solicitudTMODDIRSCONTRATANTEptpevcMunicipio) {
        this.solicitudTMODDIRSCONTRATANTEptpevcMunicipioInstance = solicitudTMODDIRSCONTRATANTEptpevcMunicipio;
        this.solicitudTMODDIRSCONTRATANTEptpevcMunicipio = solicitudTMODDIRSCONTRATANTEptpevcMunicipio != null ? solicitudTMODDIRSCONTRATANTEptpevcMunicipio.getOid().toJson() : "";
    }

    @JsonIgnore
    public String getSolicitudTMODDIRSCONTRATANTEptpDCDireccionCompleta() {
        return this.solicitudTMODDIRSCONTRATANTEptpDCDireccionCompleta;
    }
    
    public void setSolicitudTMODDIRSCONTRATANTEptpDCDireccionCompleta(String solicitudTMODDIRSCONTRATANTEptpDCDireccionCompleta) {
        this.solicitudTMODDIRSCONTRATANTEptpDCDireccionCompleta = solicitudTMODDIRSCONTRATANTEptpDCDireccionCompleta;
    }

    @JsonIgnore
    public String getSolicitudTMODDIRSCONTRATANTEptpDCDepartamento() {
        return this.solicitudTMODDIRSCONTRATANTEptpDCDepartamento;
    }
    
    public void setSolicitudTMODDIRSCONTRATANTEptpDCDepartamento(String solicitudTMODDIRSCONTRATANTEptpDCDepartamento) {
        this.solicitudTMODDIRSCONTRATANTEptpDCDepartamento = solicitudTMODDIRSCONTRATANTEptpDCDepartamento;
    }

    @JsonIgnore
    public Departamento getSolicitudTMODDIRSCONTRATANTEptpDCDepartamentoInstance() {
        return this.solicitudTMODDIRSCONTRATANTEptpDCDepartamentoInstance;
    }
    
    public void setSolicitudTMODDIRSCONTRATANTEptpDCDepartamentoInstance(Departamento solicitudTMODDIRSCONTRATANTEptpDCDepartamento) {
        this.solicitudTMODDIRSCONTRATANTEptpDCDepartamentoInstance = solicitudTMODDIRSCONTRATANTEptpDCDepartamento;
        this.solicitudTMODDIRSCONTRATANTEptpDCDepartamento = solicitudTMODDIRSCONTRATANTEptpDCDepartamento != null ? solicitudTMODDIRSCONTRATANTEptpDCDepartamento.getOid().toJson() : "";
    }

    @JsonIgnore
    public String getSolicitudTMODDIRSCONTRATANTEptpDCMunicipio() {
        return this.solicitudTMODDIRSCONTRATANTEptpDCMunicipio;
    }
    
    public void setSolicitudTMODDIRSCONTRATANTEptpDCMunicipio(String solicitudTMODDIRSCONTRATANTEptpDCMunicipio) {
        this.solicitudTMODDIRSCONTRATANTEptpDCMunicipio = solicitudTMODDIRSCONTRATANTEptpDCMunicipio;
    }

    @JsonIgnore
    public Municipio getSolicitudTMODDIRSCONTRATANTEptpDCMunicipioInstance() {
        return this.solicitudTMODDIRSCONTRATANTEptpDCMunicipioInstance;
    }
    
    public void setSolicitudTMODDIRSCONTRATANTEptpDCMunicipioInstance(Municipio solicitudTMODDIRSCONTRATANTEptpDCMunicipio) {
        this.solicitudTMODDIRSCONTRATANTEptpDCMunicipioInstance = solicitudTMODDIRSCONTRATANTEptpDCMunicipio;
        this.solicitudTMODDIRSCONTRATANTEptpDCMunicipio = solicitudTMODDIRSCONTRATANTEptpDCMunicipio != null ? solicitudTMODDIRSCONTRATANTEptpDCMunicipio.getOid().toJson() : "";
    }

    @JsonIgnore
    public Boolean getSolicitudTMODDIRSCONTRATANTEptpDCRural() {
        return this.solicitudTMODDIRSCONTRATANTEptpDCRural;
    }
    
    public void setSolicitudTMODDIRSCONTRATANTEptpDCRural(Boolean solicitudTMODDIRSCONTRATANTEptpDCRural) {
        this.solicitudTMODDIRSCONTRATANTEptpDCRural = solicitudTMODDIRSCONTRATANTEptpDCRural;
    }

    private void checkSolicitudTMODDIRSCONTRATANTEptpDCRural() throws NotNullArgumentException {
        if(this.getSolicitudTMODDIRSCONTRATANTEptpDCRural() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TMODDIRSCONTRATANTE, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TMODDIRSCONTRATANTE_SOLICITUDTMODDIRSCONTRATANTEPTPDCRURAL, SolicitudConstants.SERV_ALIAS_TMODDIRSCONTRATANTE, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TMODDIRSCONTRATANTE_SOLICITUDTMODDIRSCONTRATANTEPTPDCRURAL);
        }
    }

    @JsonIgnore
    public String getSolicitudTMODDIRSCONTRATANTEptpDCTelefonoFijo() {
        return this.solicitudTMODDIRSCONTRATANTEptpDCTelefonoFijo;
    }
    
    public void setSolicitudTMODDIRSCONTRATANTEptpDCTelefonoFijo(String solicitudTMODDIRSCONTRATANTEptpDCTelefonoFijo) {
        this.solicitudTMODDIRSCONTRATANTEptpDCTelefonoFijo = solicitudTMODDIRSCONTRATANTEptpDCTelefonoFijo;
    }

    @JsonIgnore
    public String getSolicitudTMODDIRSCONTRATANTEptpDCTelefonoCelular() {
        return this.solicitudTMODDIRSCONTRATANTEptpDCTelefonoCelular;
    }
    
    public void setSolicitudTMODDIRSCONTRATANTEptpDCTelefonoCelular(String solicitudTMODDIRSCONTRATANTEptpDCTelefonoCelular) {
        this.solicitudTMODDIRSCONTRATANTEptpDCTelefonoCelular = solicitudTMODDIRSCONTRATANTEptpDCTelefonoCelular;
    }

    @JsonIgnore
    public PaisOid getSolicitudTMODDIRSCONTRATANTEptpPais() {
        return this.solicitudTMODDIRSCONTRATANTEptpPais;
    }
    
    public void setSolicitudTMODDIRSCONTRATANTEptpPais(PaisOid solicitudTMODDIRSCONTRATANTEptpPais) {
        this.solicitudTMODDIRSCONTRATANTEptpPais = solicitudTMODDIRSCONTRATANTEptpPais;
    }

    @JsonIgnore
    public Pais getSolicitudTMODDIRSCONTRATANTEptpPaisInstance() {
        return this.solicitudTMODDIRSCONTRATANTEptpPaisInstance;
    }
    
    public void setSolicitudTMODDIRSCONTRATANTEptpPaisInstance(Pais solicitudTMODDIRSCONTRATANTEptpPais) {
        this.solicitudTMODDIRSCONTRATANTEptpPaisInstance = solicitudTMODDIRSCONTRATANTEptpPais;
        this.solicitudTMODDIRSCONTRATANTEptpPais = solicitudTMODDIRSCONTRATANTEptpPais != null ? solicitudTMODDIRSCONTRATANTEptpPais.getOid() : null;
    }

    @JsonIgnore
    public PaisOid getSolicitudTMODDIRSCONTRATANTEpDCPais() {
        return this.solicitudTMODDIRSCONTRATANTEpDCPais;
    }
    
    public void setSolicitudTMODDIRSCONTRATANTEpDCPais(PaisOid solicitudTMODDIRSCONTRATANTEpDCPais) {
        this.solicitudTMODDIRSCONTRATANTEpDCPais = solicitudTMODDIRSCONTRATANTEpDCPais;
    }

    @JsonIgnore
    public Pais getSolicitudTMODDIRSCONTRATANTEpDCPaisInstance() {
        return this.solicitudTMODDIRSCONTRATANTEpDCPaisInstance;
    }
    
    public void setSolicitudTMODDIRSCONTRATANTEpDCPaisInstance(Pais solicitudTMODDIRSCONTRATANTEpDCPais) {
        this.solicitudTMODDIRSCONTRATANTEpDCPaisInstance = solicitudTMODDIRSCONTRATANTEpDCPais;
        this.solicitudTMODDIRSCONTRATANTEpDCPais = solicitudTMODDIRSCONTRATANTEpDCPais != null ? solicitudTMODDIRSCONTRATANTEpDCPais.getOid() : null;
    }

    @JsonIgnore
    public Boolean getSolicitudTMODDIRSCONTRATANTEptReplicarDireccion() {
        return this.solicitudTMODDIRSCONTRATANTEptReplicarDireccion;
    }
    
    public void setSolicitudTMODDIRSCONTRATANTEptReplicarDireccion(Boolean solicitudTMODDIRSCONTRATANTEptReplicarDireccion) {
        this.solicitudTMODDIRSCONTRATANTEptReplicarDireccion = solicitudTMODDIRSCONTRATANTEptReplicarDireccion;
    }

    private void checkSolicitudTMODDIRSCONTRATANTEptReplicarDireccion() throws NotNullArgumentException {
        if(this.getSolicitudTMODDIRSCONTRATANTEptReplicarDireccion() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TMODDIRSCONTRATANTE, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TMODDIRSCONTRATANTE_SOLICITUDTMODDIRSCONTRATANTEPTREPLICARDIRECCION, SolicitudConstants.SERV_ALIAS_TMODDIRSCONTRATANTE, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TMODDIRSCONTRATANTE_SOLICITUDTMODDIRSCONTRATANTEPTREPLICARDIRECCION);
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
