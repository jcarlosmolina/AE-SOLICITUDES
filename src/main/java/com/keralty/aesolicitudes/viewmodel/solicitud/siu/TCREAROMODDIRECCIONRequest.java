package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.Departamento;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.oid.DepartamentoOid;
import com.keralty.aesolicitudes.persistence.oid.MunicipioOid;
import com.keralty.aesolicitudes.persistence.oid.PaisOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.oid.TipoDireccionOid;
import com.keralty.aesolicitudes.persistence.Pais;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.persistence.TipoDireccion;

public class TCREAROMODDIRECCIONRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudTCREAROMODDIRECCIONpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudTCREAROMODDIRECCIONpthisSolicitudInstance;

    @JsonProperty("pt_p_agrtipodireccion_oid")
    private TipoDireccionOid solicitudTCREAROMODDIRECCIONptpagrTipoDireccion;
    
    @JsonIgnore
    private TipoDireccion solicitudTCREAROMODDIRECCIONptpagrTipoDireccionInstance;

    @JsonProperty("pt_p_agrpais_oid")
    private PaisOid solicitudTCREAROMODDIRECCIONptpagrPais;
    
    @JsonIgnore
    private Pais solicitudTCREAROMODDIRECCIONptpagrPaisInstance;

    @JsonProperty("pt_p_agrdepartamento_oid")
    private DepartamentoOid solicitudTCREAROMODDIRECCIONptpagrDepartamento;
    
    @JsonIgnore
    private Departamento solicitudTCREAROMODDIRECCIONptpagrDepartamentoInstance;

    @JsonProperty("pt_p_agrmunicipio_oid")
    private MunicipioOid solicitudTCREAROMODDIRECCIONptpagrMunicipio;
    
    @JsonIgnore
    private Municipio solicitudTCREAROMODDIRECCIONptpagrMunicipioInstance;

    @JsonProperty("pt_p_atrdireccioncompleta")
    private String solicitudTCREAROMODDIRECCIONptpatrDireccionCompleta;

    @JsonProperty("pt_p_atrrural")
    private Boolean solicitudTCREAROMODDIRECCIONptpatrRural;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudTCREAROMODDIRECCIONpthisSolicitud();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudTCREAROMODDIRECCIONpthisSolicitud() {
        return this.solicitudTCREAROMODDIRECCIONpthisSolicitud;
    }
    
    public void setSolicitudTCREAROMODDIRECCIONpthisSolicitud(SolicitudOid solicitudTCREAROMODDIRECCIONpthisSolicitud) {
        this.solicitudTCREAROMODDIRECCIONpthisSolicitud = solicitudTCREAROMODDIRECCIONpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudTCREAROMODDIRECCIONpthisSolicitudInstance() {
        return this.solicitudTCREAROMODDIRECCIONpthisSolicitudInstance;
    }
    
    public void setSolicitudTCREAROMODDIRECCIONpthisSolicitudInstance(Solicitud solicitudTCREAROMODDIRECCIONpthisSolicitud) {
        this.solicitudTCREAROMODDIRECCIONpthisSolicitudInstance = solicitudTCREAROMODDIRECCIONpthisSolicitud;
        this.solicitudTCREAROMODDIRECCIONpthisSolicitud = solicitudTCREAROMODDIRECCIONpthisSolicitud != null ? solicitudTCREAROMODDIRECCIONpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudTCREAROMODDIRECCIONpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudTCREAROMODDIRECCIONpthisSolicitudInstance() == null || this.getSolicitudTCREAROMODDIRECCIONpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TCREAROMODDIRECCION, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TCREAROMODDIRECCION_SOLICITUDTCREAROMODDIRECCIONPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_TCREAROMODDIRECCION, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TCREAROMODDIRECCION_SOLICITUDTCREAROMODDIRECCIONPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public TipoDireccionOid getSolicitudTCREAROMODDIRECCIONptpagrTipoDireccion() {
        return this.solicitudTCREAROMODDIRECCIONptpagrTipoDireccion;
    }
    
    public void setSolicitudTCREAROMODDIRECCIONptpagrTipoDireccion(TipoDireccionOid solicitudTCREAROMODDIRECCIONptpagrTipoDireccion) {
        this.solicitudTCREAROMODDIRECCIONptpagrTipoDireccion = solicitudTCREAROMODDIRECCIONptpagrTipoDireccion;
    }

    @JsonIgnore
    public TipoDireccion getSolicitudTCREAROMODDIRECCIONptpagrTipoDireccionInstance() {
        return this.solicitudTCREAROMODDIRECCIONptpagrTipoDireccionInstance;
    }
    
    public void setSolicitudTCREAROMODDIRECCIONptpagrTipoDireccionInstance(TipoDireccion solicitudTCREAROMODDIRECCIONptpagrTipoDireccion) {
        this.solicitudTCREAROMODDIRECCIONptpagrTipoDireccionInstance = solicitudTCREAROMODDIRECCIONptpagrTipoDireccion;
        this.solicitudTCREAROMODDIRECCIONptpagrTipoDireccion = solicitudTCREAROMODDIRECCIONptpagrTipoDireccion != null ? solicitudTCREAROMODDIRECCIONptpagrTipoDireccion.getOid() : null;
    }

    @JsonIgnore
    public PaisOid getSolicitudTCREAROMODDIRECCIONptpagrPais() {
        return this.solicitudTCREAROMODDIRECCIONptpagrPais;
    }
    
    public void setSolicitudTCREAROMODDIRECCIONptpagrPais(PaisOid solicitudTCREAROMODDIRECCIONptpagrPais) {
        this.solicitudTCREAROMODDIRECCIONptpagrPais = solicitudTCREAROMODDIRECCIONptpagrPais;
    }

    @JsonIgnore
    public Pais getSolicitudTCREAROMODDIRECCIONptpagrPaisInstance() {
        return this.solicitudTCREAROMODDIRECCIONptpagrPaisInstance;
    }
    
    public void setSolicitudTCREAROMODDIRECCIONptpagrPaisInstance(Pais solicitudTCREAROMODDIRECCIONptpagrPais) {
        this.solicitudTCREAROMODDIRECCIONptpagrPaisInstance = solicitudTCREAROMODDIRECCIONptpagrPais;
        this.solicitudTCREAROMODDIRECCIONptpagrPais = solicitudTCREAROMODDIRECCIONptpagrPais != null ? solicitudTCREAROMODDIRECCIONptpagrPais.getOid() : null;
    }

    @JsonIgnore
    public DepartamentoOid getSolicitudTCREAROMODDIRECCIONptpagrDepartamento() {
        return this.solicitudTCREAROMODDIRECCIONptpagrDepartamento;
    }
    
    public void setSolicitudTCREAROMODDIRECCIONptpagrDepartamento(DepartamentoOid solicitudTCREAROMODDIRECCIONptpagrDepartamento) {
        this.solicitudTCREAROMODDIRECCIONptpagrDepartamento = solicitudTCREAROMODDIRECCIONptpagrDepartamento;
    }

    @JsonIgnore
    public Departamento getSolicitudTCREAROMODDIRECCIONptpagrDepartamentoInstance() {
        return this.solicitudTCREAROMODDIRECCIONptpagrDepartamentoInstance;
    }
    
    public void setSolicitudTCREAROMODDIRECCIONptpagrDepartamentoInstance(Departamento solicitudTCREAROMODDIRECCIONptpagrDepartamento) {
        this.solicitudTCREAROMODDIRECCIONptpagrDepartamentoInstance = solicitudTCREAROMODDIRECCIONptpagrDepartamento;
        this.solicitudTCREAROMODDIRECCIONptpagrDepartamento = solicitudTCREAROMODDIRECCIONptpagrDepartamento != null ? solicitudTCREAROMODDIRECCIONptpagrDepartamento.getOid() : null;
    }

    @JsonIgnore
    public MunicipioOid getSolicitudTCREAROMODDIRECCIONptpagrMunicipio() {
        return this.solicitudTCREAROMODDIRECCIONptpagrMunicipio;
    }
    
    public void setSolicitudTCREAROMODDIRECCIONptpagrMunicipio(MunicipioOid solicitudTCREAROMODDIRECCIONptpagrMunicipio) {
        this.solicitudTCREAROMODDIRECCIONptpagrMunicipio = solicitudTCREAROMODDIRECCIONptpagrMunicipio;
    }

    @JsonIgnore
    public Municipio getSolicitudTCREAROMODDIRECCIONptpagrMunicipioInstance() {
        return this.solicitudTCREAROMODDIRECCIONptpagrMunicipioInstance;
    }
    
    public void setSolicitudTCREAROMODDIRECCIONptpagrMunicipioInstance(Municipio solicitudTCREAROMODDIRECCIONptpagrMunicipio) {
        this.solicitudTCREAROMODDIRECCIONptpagrMunicipioInstance = solicitudTCREAROMODDIRECCIONptpagrMunicipio;
        this.solicitudTCREAROMODDIRECCIONptpagrMunicipio = solicitudTCREAROMODDIRECCIONptpagrMunicipio != null ? solicitudTCREAROMODDIRECCIONptpagrMunicipio.getOid() : null;
    }

    @JsonIgnore
    public String getSolicitudTCREAROMODDIRECCIONptpatrDireccionCompleta() {
        return this.solicitudTCREAROMODDIRECCIONptpatrDireccionCompleta;
    }
    
    public void setSolicitudTCREAROMODDIRECCIONptpatrDireccionCompleta(String solicitudTCREAROMODDIRECCIONptpatrDireccionCompleta) {
        this.solicitudTCREAROMODDIRECCIONptpatrDireccionCompleta = solicitudTCREAROMODDIRECCIONptpatrDireccionCompleta;
    }

    @JsonIgnore
    public Boolean getSolicitudTCREAROMODDIRECCIONptpatrRural() {
        return this.solicitudTCREAROMODDIRECCIONptpatrRural;
    }
    
    public void setSolicitudTCREAROMODDIRECCIONptpatrRural(Boolean solicitudTCREAROMODDIRECCIONptpatrRural) {
        this.solicitudTCREAROMODDIRECCIONptpatrRural = solicitudTCREAROMODDIRECCIONptpatrRural;
    }
}
