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

public class TMODDIRSTITULARRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudTMODDIRSTITULARpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudTMODDIRSTITULARpthisSolicitudInstance;

    @JsonProperty("pt_p_atrtelefonofijo")
    private String solicitudTMODDIRSTITULARptpatrTelefonoFijo;

    @JsonProperty("pt_p_atrtelefonocelular")
    private String solicitudTMODDIRSTITULARptpatrTelefonoCelular;

    @JsonProperty("pt_p_agrdepartamento_json")
    private String solicitudTMODDIRSTITULARptpagrDepartamento;
    
    @JsonIgnore
    private Departamento solicitudTMODDIRSTITULARptpagrDepartamentoInstance;

    @JsonProperty("pt_p_agrmunicipio_json")
    private String solicitudTMODDIRSTITULARptpagrMunicipio;
    
    @JsonIgnore
    private Municipio solicitudTMODDIRSTITULARptpagrMunicipioInstance;

    @JsonProperty("pt_p_atrdireccioncompleta")
    private String solicitudTMODDIRSTITULARptpatrDireccionCompleta;

    @JsonProperty("pt_p_atrrural")
    private Boolean solicitudTMODDIRSTITULARptpatrRural;

    @JsonProperty("pt_p_agrpais_oid")
    private PaisOid solicitudTMODDIRSTITULARptpagrPais;
    
    @JsonIgnore
    private Pais solicitudTMODDIRSTITULARptpagrPaisInstance;

    @JsonProperty("ptdcdepartamento_json")
    private String solicitudTMODDIRSTITULARptDCDepartamento;
    
    @JsonIgnore
    private Departamento solicitudTMODDIRSTITULARptDCDepartamentoInstance;

    @JsonProperty("ptdcmunicipio_json")
    private String solicitudTMODDIRSTITULARptDCMunicipio;
    
    @JsonIgnore
    private Municipio solicitudTMODDIRSTITULARptDCMunicipioInstance;

    @JsonProperty("ptdcdireccioncompleta")
    private String solicitudTMODDIRSTITULARptDCDireccionCompleta;

    @JsonProperty("ptdcrural")
    private Boolean solicitudTMODDIRSTITULARptDCRural;

    @JsonProperty("ptdctelefonofijo")
    private String solicitudTMODDIRSTITULARptDCTelefonoFijo;

    @JsonProperty("ptdctelefonocelular")
    private String solicitudTMODDIRSTITULARptDCTelefonoCelular;

    @JsonProperty("ptreplicardir")
    private Boolean solicitudTMODDIRSTITULARptReplicarDir;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudTMODDIRSTITULARpthisSolicitud();
        checkSolicitudTMODDIRSTITULARptpatrRural();
        checkSolicitudTMODDIRSTITULARptDCRural();
        checkSolicitudTMODDIRSTITULARptReplicarDir();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudTMODDIRSTITULARpthisSolicitud() {
        return this.solicitudTMODDIRSTITULARpthisSolicitud;
    }
    
    public void setSolicitudTMODDIRSTITULARpthisSolicitud(SolicitudOid solicitudTMODDIRSTITULARpthisSolicitud) {
        this.solicitudTMODDIRSTITULARpthisSolicitud = solicitudTMODDIRSTITULARpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudTMODDIRSTITULARpthisSolicitudInstance() {
        return this.solicitudTMODDIRSTITULARpthisSolicitudInstance;
    }
    
    public void setSolicitudTMODDIRSTITULARpthisSolicitudInstance(Solicitud solicitudTMODDIRSTITULARpthisSolicitud) {
        this.solicitudTMODDIRSTITULARpthisSolicitudInstance = solicitudTMODDIRSTITULARpthisSolicitud;
        this.solicitudTMODDIRSTITULARpthisSolicitud = solicitudTMODDIRSTITULARpthisSolicitud != null ? solicitudTMODDIRSTITULARpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudTMODDIRSTITULARpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudTMODDIRSTITULARpthisSolicitudInstance() == null || this.getSolicitudTMODDIRSTITULARpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TMODDIRSTITULAR, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TMODDIRSTITULAR_SOLICITUDTMODDIRSTITULARPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_TMODDIRSTITULAR, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TMODDIRSTITULAR_SOLICITUDTMODDIRSTITULARPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public String getSolicitudTMODDIRSTITULARptpatrTelefonoFijo() {
        return this.solicitudTMODDIRSTITULARptpatrTelefonoFijo;
    }
    
    public void setSolicitudTMODDIRSTITULARptpatrTelefonoFijo(String solicitudTMODDIRSTITULARptpatrTelefonoFijo) {
        this.solicitudTMODDIRSTITULARptpatrTelefonoFijo = solicitudTMODDIRSTITULARptpatrTelefonoFijo;
    }

    @JsonIgnore
    public String getSolicitudTMODDIRSTITULARptpatrTelefonoCelular() {
        return this.solicitudTMODDIRSTITULARptpatrTelefonoCelular;
    }
    
    public void setSolicitudTMODDIRSTITULARptpatrTelefonoCelular(String solicitudTMODDIRSTITULARptpatrTelefonoCelular) {
        this.solicitudTMODDIRSTITULARptpatrTelefonoCelular = solicitudTMODDIRSTITULARptpatrTelefonoCelular;
    }

    @JsonIgnore
    public String getSolicitudTMODDIRSTITULARptpagrDepartamento() {
        return this.solicitudTMODDIRSTITULARptpagrDepartamento;
    }
    
    public void setSolicitudTMODDIRSTITULARptpagrDepartamento(String solicitudTMODDIRSTITULARptpagrDepartamento) {
        this.solicitudTMODDIRSTITULARptpagrDepartamento = solicitudTMODDIRSTITULARptpagrDepartamento;
    }

    @JsonIgnore
    public Departamento getSolicitudTMODDIRSTITULARptpagrDepartamentoInstance() {
        return this.solicitudTMODDIRSTITULARptpagrDepartamentoInstance;
    }
    
    public void setSolicitudTMODDIRSTITULARptpagrDepartamentoInstance(Departamento solicitudTMODDIRSTITULARptpagrDepartamento) {
        this.solicitudTMODDIRSTITULARptpagrDepartamentoInstance = solicitudTMODDIRSTITULARptpagrDepartamento;
        this.solicitudTMODDIRSTITULARptpagrDepartamento = solicitudTMODDIRSTITULARptpagrDepartamento != null ? solicitudTMODDIRSTITULARptpagrDepartamento.getOid().toJson() : "";
    }

    @JsonIgnore
    public String getSolicitudTMODDIRSTITULARptpagrMunicipio() {
        return this.solicitudTMODDIRSTITULARptpagrMunicipio;
    }
    
    public void setSolicitudTMODDIRSTITULARptpagrMunicipio(String solicitudTMODDIRSTITULARptpagrMunicipio) {
        this.solicitudTMODDIRSTITULARptpagrMunicipio = solicitudTMODDIRSTITULARptpagrMunicipio;
    }

    @JsonIgnore
    public Municipio getSolicitudTMODDIRSTITULARptpagrMunicipioInstance() {
        return this.solicitudTMODDIRSTITULARptpagrMunicipioInstance;
    }
    
    public void setSolicitudTMODDIRSTITULARptpagrMunicipioInstance(Municipio solicitudTMODDIRSTITULARptpagrMunicipio) {
        this.solicitudTMODDIRSTITULARptpagrMunicipioInstance = solicitudTMODDIRSTITULARptpagrMunicipio;
        this.solicitudTMODDIRSTITULARptpagrMunicipio = solicitudTMODDIRSTITULARptpagrMunicipio != null ? solicitudTMODDIRSTITULARptpagrMunicipio.getOid().toJson() : "";
    }

    @JsonIgnore
    public String getSolicitudTMODDIRSTITULARptpatrDireccionCompleta() {
        return this.solicitudTMODDIRSTITULARptpatrDireccionCompleta;
    }
    
    public void setSolicitudTMODDIRSTITULARptpatrDireccionCompleta(String solicitudTMODDIRSTITULARptpatrDireccionCompleta) {
        this.solicitudTMODDIRSTITULARptpatrDireccionCompleta = solicitudTMODDIRSTITULARptpatrDireccionCompleta;
    }

    @JsonIgnore
    public Boolean getSolicitudTMODDIRSTITULARptpatrRural() {
        return this.solicitudTMODDIRSTITULARptpatrRural;
    }
    
    public void setSolicitudTMODDIRSTITULARptpatrRural(Boolean solicitudTMODDIRSTITULARptpatrRural) {
        this.solicitudTMODDIRSTITULARptpatrRural = solicitudTMODDIRSTITULARptpatrRural;
    }

    private void checkSolicitudTMODDIRSTITULARptpatrRural() throws NotNullArgumentException {
        if(this.getSolicitudTMODDIRSTITULARptpatrRural() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TMODDIRSTITULAR, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TMODDIRSTITULAR_SOLICITUDTMODDIRSTITULARPTPATRRURAL, SolicitudConstants.SERV_ALIAS_TMODDIRSTITULAR, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TMODDIRSTITULAR_SOLICITUDTMODDIRSTITULARPTPATRRURAL);
        }
    }

    @JsonIgnore
    public PaisOid getSolicitudTMODDIRSTITULARptpagrPais() {
        return this.solicitudTMODDIRSTITULARptpagrPais;
    }
    
    public void setSolicitudTMODDIRSTITULARptpagrPais(PaisOid solicitudTMODDIRSTITULARptpagrPais) {
        this.solicitudTMODDIRSTITULARptpagrPais = solicitudTMODDIRSTITULARptpagrPais;
    }

    @JsonIgnore
    public Pais getSolicitudTMODDIRSTITULARptpagrPaisInstance() {
        return this.solicitudTMODDIRSTITULARptpagrPaisInstance;
    }
    
    public void setSolicitudTMODDIRSTITULARptpagrPaisInstance(Pais solicitudTMODDIRSTITULARptpagrPais) {
        this.solicitudTMODDIRSTITULARptpagrPaisInstance = solicitudTMODDIRSTITULARptpagrPais;
        this.solicitudTMODDIRSTITULARptpagrPais = solicitudTMODDIRSTITULARptpagrPais != null ? solicitudTMODDIRSTITULARptpagrPais.getOid() : null;
    }

    @JsonIgnore
    public String getSolicitudTMODDIRSTITULARptDCDepartamento() {
        return this.solicitudTMODDIRSTITULARptDCDepartamento;
    }
    
    public void setSolicitudTMODDIRSTITULARptDCDepartamento(String solicitudTMODDIRSTITULARptDCDepartamento) {
        this.solicitudTMODDIRSTITULARptDCDepartamento = solicitudTMODDIRSTITULARptDCDepartamento;
    }

    @JsonIgnore
    public Departamento getSolicitudTMODDIRSTITULARptDCDepartamentoInstance() {
        return this.solicitudTMODDIRSTITULARptDCDepartamentoInstance;
    }
    
    public void setSolicitudTMODDIRSTITULARptDCDepartamentoInstance(Departamento solicitudTMODDIRSTITULARptDCDepartamento) {
        this.solicitudTMODDIRSTITULARptDCDepartamentoInstance = solicitudTMODDIRSTITULARptDCDepartamento;
        this.solicitudTMODDIRSTITULARptDCDepartamento = solicitudTMODDIRSTITULARptDCDepartamento != null ? solicitudTMODDIRSTITULARptDCDepartamento.getOid().toJson() : "";
    }

    @JsonIgnore
    public String getSolicitudTMODDIRSTITULARptDCMunicipio() {
        return this.solicitudTMODDIRSTITULARptDCMunicipio;
    }
    
    public void setSolicitudTMODDIRSTITULARptDCMunicipio(String solicitudTMODDIRSTITULARptDCMunicipio) {
        this.solicitudTMODDIRSTITULARptDCMunicipio = solicitudTMODDIRSTITULARptDCMunicipio;
    }

    @JsonIgnore
    public Municipio getSolicitudTMODDIRSTITULARptDCMunicipioInstance() {
        return this.solicitudTMODDIRSTITULARptDCMunicipioInstance;
    }
    
    public void setSolicitudTMODDIRSTITULARptDCMunicipioInstance(Municipio solicitudTMODDIRSTITULARptDCMunicipio) {
        this.solicitudTMODDIRSTITULARptDCMunicipioInstance = solicitudTMODDIRSTITULARptDCMunicipio;
        this.solicitudTMODDIRSTITULARptDCMunicipio = solicitudTMODDIRSTITULARptDCMunicipio != null ? solicitudTMODDIRSTITULARptDCMunicipio.getOid().toJson() : "";
    }

    @JsonIgnore
    public String getSolicitudTMODDIRSTITULARptDCDireccionCompleta() {
        return this.solicitudTMODDIRSTITULARptDCDireccionCompleta;
    }
    
    public void setSolicitudTMODDIRSTITULARptDCDireccionCompleta(String solicitudTMODDIRSTITULARptDCDireccionCompleta) {
        this.solicitudTMODDIRSTITULARptDCDireccionCompleta = solicitudTMODDIRSTITULARptDCDireccionCompleta;
    }

    @JsonIgnore
    public Boolean getSolicitudTMODDIRSTITULARptDCRural() {
        return this.solicitudTMODDIRSTITULARptDCRural;
    }
    
    public void setSolicitudTMODDIRSTITULARptDCRural(Boolean solicitudTMODDIRSTITULARptDCRural) {
        this.solicitudTMODDIRSTITULARptDCRural = solicitudTMODDIRSTITULARptDCRural;
    }

    private void checkSolicitudTMODDIRSTITULARptDCRural() throws NotNullArgumentException {
        if(this.getSolicitudTMODDIRSTITULARptDCRural() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TMODDIRSTITULAR, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TMODDIRSTITULAR_SOLICITUDTMODDIRSTITULARPTDCRURAL, SolicitudConstants.SERV_ALIAS_TMODDIRSTITULAR, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TMODDIRSTITULAR_SOLICITUDTMODDIRSTITULARPTDCRURAL);
        }
    }

    @JsonIgnore
    public String getSolicitudTMODDIRSTITULARptDCTelefonoFijo() {
        return this.solicitudTMODDIRSTITULARptDCTelefonoFijo;
    }
    
    public void setSolicitudTMODDIRSTITULARptDCTelefonoFijo(String solicitudTMODDIRSTITULARptDCTelefonoFijo) {
        this.solicitudTMODDIRSTITULARptDCTelefonoFijo = solicitudTMODDIRSTITULARptDCTelefonoFijo;
    }

    @JsonIgnore
    public String getSolicitudTMODDIRSTITULARptDCTelefonoCelular() {
        return this.solicitudTMODDIRSTITULARptDCTelefonoCelular;
    }
    
    public void setSolicitudTMODDIRSTITULARptDCTelefonoCelular(String solicitudTMODDIRSTITULARptDCTelefonoCelular) {
        this.solicitudTMODDIRSTITULARptDCTelefonoCelular = solicitudTMODDIRSTITULARptDCTelefonoCelular;
    }

    @JsonIgnore
    public Boolean getSolicitudTMODDIRSTITULARptReplicarDir() {
        return this.solicitudTMODDIRSTITULARptReplicarDir;
    }
    
    public void setSolicitudTMODDIRSTITULARptReplicarDir(Boolean solicitudTMODDIRSTITULARptReplicarDir) {
        this.solicitudTMODDIRSTITULARptReplicarDir = solicitudTMODDIRSTITULARptReplicarDir;
    }

    private void checkSolicitudTMODDIRSTITULARptReplicarDir() throws NotNullArgumentException {
        if(this.getSolicitudTMODDIRSTITULARptReplicarDir() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TMODDIRSTITULAR, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TMODDIRSTITULAR_SOLICITUDTMODDIRSTITULARPTREPLICARDIR, SolicitudConstants.SERV_ALIAS_TMODDIRSTITULAR, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TMODDIRSTITULAR_SOLICITUDTMODDIRSTITULARPTREPLICARDIR);
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
