package com.keralty.aesolicitudes.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SolicitudConstants;
import com.keralty.aesolicitudes.persistence.Departamento;
import com.keralty.aesolicitudes.persistence.EstadoCivil;
import com.keralty.aesolicitudes.persistence.EstadoPersona;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.oid.DepartamentoOid;
import com.keralty.aesolicitudes.persistence.oid.EstadoCivilOid;
import com.keralty.aesolicitudes.persistence.oid.EstadoPersonaOid;
import com.keralty.aesolicitudes.persistence.oid.MunicipioOid;
import com.keralty.aesolicitudes.persistence.oid.PaisOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.oid.TipoIdentificacionOid;
import com.keralty.aesolicitudes.persistence.Pais;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.persistence.TipoIdentificacion;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class TINDICARCONTRATANTEINCLUSIONRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudTINDICARCONTRATANTEINCLUSIONpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudTINDICARCONTRATANTEINCLUSIONpthisSolicitudInstance;

    @JsonProperty("pt_p_primernombre")
    private String solicitudTINDICARCONTRATANTEINCLUSIONptpPrimerNombre;

    @JsonProperty("pt_p_segundonombre")
    private String solicitudTINDICARCONTRATANTEINCLUSIONptpSegundoNombre;

    @JsonProperty("pt_p_primerapellido")
    private String solicitudTINDICARCONTRATANTEINCLUSIONptpPrimerApellido;

    @JsonProperty("pt_p_segundoapellido")
    private String solicitudTINDICARCONTRATANTEINCLUSIONptpSegundoApellido;

    @JsonProperty("pt_p_fechanacimiento")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date solicitudTINDICARCONTRATANTEINCLUSIONptpFechaNacimiento;

    @JsonProperty("pt_p_genero")
    private String solicitudTINDICARCONTRATANTEINCLUSIONptpGenero;

    @JsonProperty("pt_p_indicadorextranjero")
    private Boolean solicitudTINDICARCONTRATANTEINCLUSIONptpIndicadorExtranjero;

    @JsonProperty("pt_p_telefonofijo")
    private String solicitudTINDICARCONTRATANTEINCLUSIONptpTelefonoFijo;

    @JsonProperty("pt_p_telefonocelular")
    private String solicitudTINDICARCONTRATANTEINCLUSIONptpTelefonoCelular;

    @JsonProperty("pt_p_correoelectronico")
    private String solicitudTINDICARCONTRATANTEINCLUSIONptpCorreoElectronico;

    @JsonProperty("pt_p_evcdepartamentonac_oid")
    private DepartamentoOid solicitudTINDICARCONTRATANTEINCLUSIONptpevcDepartamentoNac;
    
    @JsonIgnore
    private Departamento solicitudTINDICARCONTRATANTEINCLUSIONptpevcDepartamentoNacInstance;

    @JsonProperty("pt_p_evcmunicipionac_oid")
    private MunicipioOid solicitudTINDICARCONTRATANTEINCLUSIONptpevcMunicipioNac;
    
    @JsonIgnore
    private Municipio solicitudTINDICARCONTRATANTEINCLUSIONptpevcMunicipioNacInstance;

    @JsonProperty("pt_p_evcestadocivil_oid")
    private EstadoCivilOid solicitudTINDICARCONTRATANTEINCLUSIONptpevcEstadoCivil;
    
    @JsonIgnore
    private EstadoCivil solicitudTINDICARCONTRATANTEINCLUSIONptpevcEstadoCivilInstance;

    @JsonProperty("pt_p_direccioncompleta")
    private String solicitudTINDICARCONTRATANTEINCLUSIONptpDireccionCompleta;

    @JsonProperty("pt_p_rural")
    private Boolean solicitudTINDICARCONTRATANTEINCLUSIONptpRural;

    @JsonProperty("pt_p_evcdepartamento_oid")
    private DepartamentoOid solicitudTINDICARCONTRATANTEINCLUSIONptpevcDepartamento;
    
    @JsonIgnore
    private Departamento solicitudTINDICARCONTRATANTEINCLUSIONptpevcDepartamentoInstance;

    @JsonProperty("pt_p_evcmunicipio_oid")
    private MunicipioOid solicitudTINDICARCONTRATANTEINCLUSIONptpevcMunicipio;
    
    @JsonIgnore
    private Municipio solicitudTINDICARCONTRATANTEINCLUSIONptpevcMunicipioInstance;

    @JsonProperty("pt_p_numidentificacion")
    private String solicitudTINDICARCONTRATANTEINCLUSIONptpNumIdentificacion;

    @JsonProperty("pt_p_evctipoidentificacion_oid")
    private TipoIdentificacionOid solicitudTINDICARCONTRATANTEINCLUSIONptpevcTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion solicitudTINDICARCONTRATANTEINCLUSIONptpevcTipoIdentificacionInstance;

    @JsonProperty("pt_p_atrrazonsocial")
    private String solicitudTINDICARCONTRATANTEINCLUSIONptpatrRazonSocial;

    @JsonProperty("pt_pdcdireccioncompleta")
    private String solicitudTINDICARCONTRATANTEINCLUSIONptpDCDireccionCompleta;

    @JsonProperty("pt_pdcdepartamento_oid")
    private DepartamentoOid solicitudTINDICARCONTRATANTEINCLUSIONptpDCDepartamento;
    
    @JsonIgnore
    private Departamento solicitudTINDICARCONTRATANTEINCLUSIONptpDCDepartamentoInstance;

    @JsonProperty("pt_pdcmunicipio_oid")
    private MunicipioOid solicitudTINDICARCONTRATANTEINCLUSIONptpDCMunicipio;
    
    @JsonIgnore
    private Municipio solicitudTINDICARCONTRATANTEINCLUSIONptpDCMunicipioInstance;

    @JsonProperty("pt_pdcrural")
    private Boolean solicitudTINDICARCONTRATANTEINCLUSIONptpDCRural;

    @JsonProperty("pt_pdctelefonofijo")
    private String solicitudTINDICARCONTRATANTEINCLUSIONptpDCTelefonoFijo;

    @JsonProperty("pt_pdctelefonocelular")
    private String solicitudTINDICARCONTRATANTEINCLUSIONptpDCTelefonoCelular;

    @JsonProperty("pt_p_pais_oid")
    private PaisOid solicitudTINDICARCONTRATANTEINCLUSIONptpPais;
    
    @JsonIgnore
    private Pais solicitudTINDICARCONTRATANTEINCLUSIONptpPaisInstance;

    @JsonProperty("pt_p_codigocore")
    private Long solicitudTINDICARCONTRATANTEINCLUSIONptpCodigoCORE;

    @JsonProperty("pt_tieneepssanitas")
    private Boolean solicitudTINDICARCONTRATANTEINCLUSIONptTieneEPSSanitas;

    @JsonProperty("pt_rechazadoafiliacion")
    private String solicitudTINDICARCONTRATANTEINCLUSIONptRechazadoAfiliacion;

    @JsonProperty("pdcpais_oid")
    private PaisOid solicitudTINDICARCONTRATANTEINCLUSIONpDCPais;
    
    @JsonIgnore
    private Pais solicitudTINDICARCONTRATANTEINCLUSIONpDCPaisInstance;

    @JsonProperty("p_titularbeneficios")
    private Boolean solicitudTINDICARCONTRATANTEINCLUSIONpTitularBeneficios;

    @JsonProperty("pttiporegimen")
    private String solicitudTINDICARCONTRATANTEINCLUSIONptTipoRegimen;

    @JsonProperty("ptestadopersona_oid")
    private EstadoPersonaOid solicitudTINDICARCONTRATANTEINCLUSIONptEstadoPersona;
    
    @JsonIgnore
    private EstadoPersona solicitudTINDICARCONTRATANTEINCLUSIONptEstadoPersonaInstance;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudTINDICARCONTRATANTEINCLUSIONpthisSolicitud();
        checkSolicitudTINDICARCONTRATANTEINCLUSIONptpNumIdentificacion();
        checkSolicitudTINDICARCONTRATANTEINCLUSIONptpevcTipoIdentificacion();
        checkSolicitudTINDICARCONTRATANTEINCLUSIONpTitularBeneficios();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudTINDICARCONTRATANTEINCLUSIONpthisSolicitud() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONpthisSolicitud;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONpthisSolicitud(SolicitudOid solicitudTINDICARCONTRATANTEINCLUSIONpthisSolicitud) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONpthisSolicitud = solicitudTINDICARCONTRATANTEINCLUSIONpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudTINDICARCONTRATANTEINCLUSIONpthisSolicitudInstance() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONpthisSolicitudInstance;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONpthisSolicitudInstance(Solicitud solicitudTINDICARCONTRATANTEINCLUSIONpthisSolicitud) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONpthisSolicitudInstance = solicitudTINDICARCONTRATANTEINCLUSIONpthisSolicitud;
        this.solicitudTINDICARCONTRATANTEINCLUSIONpthisSolicitud = solicitudTINDICARCONTRATANTEINCLUSIONpthisSolicitud != null ? solicitudTINDICARCONTRATANTEINCLUSIONpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudTINDICARCONTRATANTEINCLUSIONpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARCONTRATANTEINCLUSIONpthisSolicitudInstance() == null || this.getSolicitudTINDICARCONTRATANTEINCLUSIONpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARCONTRATANTEINCLUSION, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARCONTRATANTEINCLUSION_SOLICITUDTINDICARCONTRATANTEINCLUSIONPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_TINDICARCONTRATANTEINCLUSION, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARCONTRATANTEINCLUSION_SOLICITUDTINDICARCONTRATANTEINCLUSIONPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTEINCLUSIONptpPrimerNombre() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONptpPrimerNombre;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONptpPrimerNombre(String solicitudTINDICARCONTRATANTEINCLUSIONptpPrimerNombre) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpPrimerNombre = solicitudTINDICARCONTRATANTEINCLUSIONptpPrimerNombre;
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTEINCLUSIONptpSegundoNombre() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONptpSegundoNombre;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONptpSegundoNombre(String solicitudTINDICARCONTRATANTEINCLUSIONptpSegundoNombre) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpSegundoNombre = solicitudTINDICARCONTRATANTEINCLUSIONptpSegundoNombre;
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTEINCLUSIONptpPrimerApellido() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONptpPrimerApellido;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONptpPrimerApellido(String solicitudTINDICARCONTRATANTEINCLUSIONptpPrimerApellido) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpPrimerApellido = solicitudTINDICARCONTRATANTEINCLUSIONptpPrimerApellido;
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTEINCLUSIONptpSegundoApellido() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONptpSegundoApellido;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONptpSegundoApellido(String solicitudTINDICARCONTRATANTEINCLUSIONptpSegundoApellido) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpSegundoApellido = solicitudTINDICARCONTRATANTEINCLUSIONptpSegundoApellido;
    }

    @JsonIgnore
    public Date getSolicitudTINDICARCONTRATANTEINCLUSIONptpFechaNacimiento() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONptpFechaNacimiento;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONptpFechaNacimiento(Date solicitudTINDICARCONTRATANTEINCLUSIONptpFechaNacimiento) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpFechaNacimiento = solicitudTINDICARCONTRATANTEINCLUSIONptpFechaNacimiento;
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTEINCLUSIONptpGenero() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONptpGenero;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONptpGenero(String solicitudTINDICARCONTRATANTEINCLUSIONptpGenero) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpGenero = solicitudTINDICARCONTRATANTEINCLUSIONptpGenero;
    }

    @JsonIgnore
    public Boolean getSolicitudTINDICARCONTRATANTEINCLUSIONptpIndicadorExtranjero() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONptpIndicadorExtranjero;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONptpIndicadorExtranjero(Boolean solicitudTINDICARCONTRATANTEINCLUSIONptpIndicadorExtranjero) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpIndicadorExtranjero = solicitudTINDICARCONTRATANTEINCLUSIONptpIndicadorExtranjero;
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTEINCLUSIONptpTelefonoFijo() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONptpTelefonoFijo;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONptpTelefonoFijo(String solicitudTINDICARCONTRATANTEINCLUSIONptpTelefonoFijo) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpTelefonoFijo = solicitudTINDICARCONTRATANTEINCLUSIONptpTelefonoFijo;
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTEINCLUSIONptpTelefonoCelular() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONptpTelefonoCelular;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONptpTelefonoCelular(String solicitudTINDICARCONTRATANTEINCLUSIONptpTelefonoCelular) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpTelefonoCelular = solicitudTINDICARCONTRATANTEINCLUSIONptpTelefonoCelular;
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTEINCLUSIONptpCorreoElectronico() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONptpCorreoElectronico;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONptpCorreoElectronico(String solicitudTINDICARCONTRATANTEINCLUSIONptpCorreoElectronico) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpCorreoElectronico = solicitudTINDICARCONTRATANTEINCLUSIONptpCorreoElectronico;
    }

    @JsonIgnore
    public DepartamentoOid getSolicitudTINDICARCONTRATANTEINCLUSIONptpevcDepartamentoNac() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONptpevcDepartamentoNac;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONptpevcDepartamentoNac(DepartamentoOid solicitudTINDICARCONTRATANTEINCLUSIONptpevcDepartamentoNac) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpevcDepartamentoNac = solicitudTINDICARCONTRATANTEINCLUSIONptpevcDepartamentoNac;
    }

    @JsonIgnore
    public Departamento getSolicitudTINDICARCONTRATANTEINCLUSIONptpevcDepartamentoNacInstance() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONptpevcDepartamentoNacInstance;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONptpevcDepartamentoNacInstance(Departamento solicitudTINDICARCONTRATANTEINCLUSIONptpevcDepartamentoNac) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpevcDepartamentoNacInstance = solicitudTINDICARCONTRATANTEINCLUSIONptpevcDepartamentoNac;
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpevcDepartamentoNac = solicitudTINDICARCONTRATANTEINCLUSIONptpevcDepartamentoNac != null ? solicitudTINDICARCONTRATANTEINCLUSIONptpevcDepartamentoNac.getOid() : null;
    }

    @JsonIgnore
    public MunicipioOid getSolicitudTINDICARCONTRATANTEINCLUSIONptpevcMunicipioNac() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONptpevcMunicipioNac;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONptpevcMunicipioNac(MunicipioOid solicitudTINDICARCONTRATANTEINCLUSIONptpevcMunicipioNac) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpevcMunicipioNac = solicitudTINDICARCONTRATANTEINCLUSIONptpevcMunicipioNac;
    }

    @JsonIgnore
    public Municipio getSolicitudTINDICARCONTRATANTEINCLUSIONptpevcMunicipioNacInstance() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONptpevcMunicipioNacInstance;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONptpevcMunicipioNacInstance(Municipio solicitudTINDICARCONTRATANTEINCLUSIONptpevcMunicipioNac) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpevcMunicipioNacInstance = solicitudTINDICARCONTRATANTEINCLUSIONptpevcMunicipioNac;
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpevcMunicipioNac = solicitudTINDICARCONTRATANTEINCLUSIONptpevcMunicipioNac != null ? solicitudTINDICARCONTRATANTEINCLUSIONptpevcMunicipioNac.getOid() : null;
    }

    @JsonIgnore
    public EstadoCivilOid getSolicitudTINDICARCONTRATANTEINCLUSIONptpevcEstadoCivil() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONptpevcEstadoCivil;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONptpevcEstadoCivil(EstadoCivilOid solicitudTINDICARCONTRATANTEINCLUSIONptpevcEstadoCivil) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpevcEstadoCivil = solicitudTINDICARCONTRATANTEINCLUSIONptpevcEstadoCivil;
    }

    @JsonIgnore
    public EstadoCivil getSolicitudTINDICARCONTRATANTEINCLUSIONptpevcEstadoCivilInstance() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONptpevcEstadoCivilInstance;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONptpevcEstadoCivilInstance(EstadoCivil solicitudTINDICARCONTRATANTEINCLUSIONptpevcEstadoCivil) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpevcEstadoCivilInstance = solicitudTINDICARCONTRATANTEINCLUSIONptpevcEstadoCivil;
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpevcEstadoCivil = solicitudTINDICARCONTRATANTEINCLUSIONptpevcEstadoCivil != null ? solicitudTINDICARCONTRATANTEINCLUSIONptpevcEstadoCivil.getOid() : null;
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTEINCLUSIONptpDireccionCompleta() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONptpDireccionCompleta;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONptpDireccionCompleta(String solicitudTINDICARCONTRATANTEINCLUSIONptpDireccionCompleta) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpDireccionCompleta = solicitudTINDICARCONTRATANTEINCLUSIONptpDireccionCompleta;
    }

    @JsonIgnore
    public Boolean getSolicitudTINDICARCONTRATANTEINCLUSIONptpRural() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONptpRural;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONptpRural(Boolean solicitudTINDICARCONTRATANTEINCLUSIONptpRural) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpRural = solicitudTINDICARCONTRATANTEINCLUSIONptpRural;
    }

    @JsonIgnore
    public DepartamentoOid getSolicitudTINDICARCONTRATANTEINCLUSIONptpevcDepartamento() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONptpevcDepartamento;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONptpevcDepartamento(DepartamentoOid solicitudTINDICARCONTRATANTEINCLUSIONptpevcDepartamento) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpevcDepartamento = solicitudTINDICARCONTRATANTEINCLUSIONptpevcDepartamento;
    }

    @JsonIgnore
    public Departamento getSolicitudTINDICARCONTRATANTEINCLUSIONptpevcDepartamentoInstance() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONptpevcDepartamentoInstance;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONptpevcDepartamentoInstance(Departamento solicitudTINDICARCONTRATANTEINCLUSIONptpevcDepartamento) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpevcDepartamentoInstance = solicitudTINDICARCONTRATANTEINCLUSIONptpevcDepartamento;
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpevcDepartamento = solicitudTINDICARCONTRATANTEINCLUSIONptpevcDepartamento != null ? solicitudTINDICARCONTRATANTEINCLUSIONptpevcDepartamento.getOid() : null;
    }

    @JsonIgnore
    public MunicipioOid getSolicitudTINDICARCONTRATANTEINCLUSIONptpevcMunicipio() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONptpevcMunicipio;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONptpevcMunicipio(MunicipioOid solicitudTINDICARCONTRATANTEINCLUSIONptpevcMunicipio) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpevcMunicipio = solicitudTINDICARCONTRATANTEINCLUSIONptpevcMunicipio;
    }

    @JsonIgnore
    public Municipio getSolicitudTINDICARCONTRATANTEINCLUSIONptpevcMunicipioInstance() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONptpevcMunicipioInstance;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONptpevcMunicipioInstance(Municipio solicitudTINDICARCONTRATANTEINCLUSIONptpevcMunicipio) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpevcMunicipioInstance = solicitudTINDICARCONTRATANTEINCLUSIONptpevcMunicipio;
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpevcMunicipio = solicitudTINDICARCONTRATANTEINCLUSIONptpevcMunicipio != null ? solicitudTINDICARCONTRATANTEINCLUSIONptpevcMunicipio.getOid() : null;
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTEINCLUSIONptpNumIdentificacion() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONptpNumIdentificacion;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONptpNumIdentificacion(String solicitudTINDICARCONTRATANTEINCLUSIONptpNumIdentificacion) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpNumIdentificacion = solicitudTINDICARCONTRATANTEINCLUSIONptpNumIdentificacion;
    }

    private void checkSolicitudTINDICARCONTRATANTEINCLUSIONptpNumIdentificacion() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARCONTRATANTEINCLUSIONptpNumIdentificacion() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARCONTRATANTEINCLUSION, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARCONTRATANTEINCLUSION_SOLICITUDTINDICARCONTRATANTEINCLUSIONPTPNUMIDENTIFICACION, SolicitudConstants.SERV_ALIAS_TINDICARCONTRATANTEINCLUSION, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARCONTRATANTEINCLUSION_SOLICITUDTINDICARCONTRATANTEINCLUSIONPTPNUMIDENTIFICACION);
        }
    }

    @JsonIgnore
    public TipoIdentificacionOid getSolicitudTINDICARCONTRATANTEINCLUSIONptpevcTipoIdentificacion() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONptpevcTipoIdentificacion;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONptpevcTipoIdentificacion(TipoIdentificacionOid solicitudTINDICARCONTRATANTEINCLUSIONptpevcTipoIdentificacion) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpevcTipoIdentificacion = solicitudTINDICARCONTRATANTEINCLUSIONptpevcTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getSolicitudTINDICARCONTRATANTEINCLUSIONptpevcTipoIdentificacionInstance() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONptpevcTipoIdentificacionInstance;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONptpevcTipoIdentificacionInstance(TipoIdentificacion solicitudTINDICARCONTRATANTEINCLUSIONptpevcTipoIdentificacion) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpevcTipoIdentificacionInstance = solicitudTINDICARCONTRATANTEINCLUSIONptpevcTipoIdentificacion;
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpevcTipoIdentificacion = solicitudTINDICARCONTRATANTEINCLUSIONptpevcTipoIdentificacion != null ? solicitudTINDICARCONTRATANTEINCLUSIONptpevcTipoIdentificacion.getOid() : null;
    }

    private void checkSolicitudTINDICARCONTRATANTEINCLUSIONptpevcTipoIdentificacion() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARCONTRATANTEINCLUSIONptpevcTipoIdentificacionInstance() == null || this.getSolicitudTINDICARCONTRATANTEINCLUSIONptpevcTipoIdentificacionInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARCONTRATANTEINCLUSION, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARCONTRATANTEINCLUSION_SOLICITUDTINDICARCONTRATANTEINCLUSIONPTPEVCTIPOIDENTIFICACION, SolicitudConstants.SERV_ALIAS_TINDICARCONTRATANTEINCLUSION, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARCONTRATANTEINCLUSION_SOLICITUDTINDICARCONTRATANTEINCLUSIONPTPEVCTIPOIDENTIFICACION);
        }
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTEINCLUSIONptpatrRazonSocial() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONptpatrRazonSocial;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONptpatrRazonSocial(String solicitudTINDICARCONTRATANTEINCLUSIONptpatrRazonSocial) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpatrRazonSocial = solicitudTINDICARCONTRATANTEINCLUSIONptpatrRazonSocial;
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTEINCLUSIONptpDCDireccionCompleta() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONptpDCDireccionCompleta;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONptpDCDireccionCompleta(String solicitudTINDICARCONTRATANTEINCLUSIONptpDCDireccionCompleta) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpDCDireccionCompleta = solicitudTINDICARCONTRATANTEINCLUSIONptpDCDireccionCompleta;
    }

    @JsonIgnore
    public DepartamentoOid getSolicitudTINDICARCONTRATANTEINCLUSIONptpDCDepartamento() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONptpDCDepartamento;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONptpDCDepartamento(DepartamentoOid solicitudTINDICARCONTRATANTEINCLUSIONptpDCDepartamento) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpDCDepartamento = solicitudTINDICARCONTRATANTEINCLUSIONptpDCDepartamento;
    }

    @JsonIgnore
    public Departamento getSolicitudTINDICARCONTRATANTEINCLUSIONptpDCDepartamentoInstance() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONptpDCDepartamentoInstance;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONptpDCDepartamentoInstance(Departamento solicitudTINDICARCONTRATANTEINCLUSIONptpDCDepartamento) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpDCDepartamentoInstance = solicitudTINDICARCONTRATANTEINCLUSIONptpDCDepartamento;
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpDCDepartamento = solicitudTINDICARCONTRATANTEINCLUSIONptpDCDepartamento != null ? solicitudTINDICARCONTRATANTEINCLUSIONptpDCDepartamento.getOid() : null;
    }

    @JsonIgnore
    public MunicipioOid getSolicitudTINDICARCONTRATANTEINCLUSIONptpDCMunicipio() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONptpDCMunicipio;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONptpDCMunicipio(MunicipioOid solicitudTINDICARCONTRATANTEINCLUSIONptpDCMunicipio) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpDCMunicipio = solicitudTINDICARCONTRATANTEINCLUSIONptpDCMunicipio;
    }

    @JsonIgnore
    public Municipio getSolicitudTINDICARCONTRATANTEINCLUSIONptpDCMunicipioInstance() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONptpDCMunicipioInstance;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONptpDCMunicipioInstance(Municipio solicitudTINDICARCONTRATANTEINCLUSIONptpDCMunicipio) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpDCMunicipioInstance = solicitudTINDICARCONTRATANTEINCLUSIONptpDCMunicipio;
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpDCMunicipio = solicitudTINDICARCONTRATANTEINCLUSIONptpDCMunicipio != null ? solicitudTINDICARCONTRATANTEINCLUSIONptpDCMunicipio.getOid() : null;
    }

    @JsonIgnore
    public Boolean getSolicitudTINDICARCONTRATANTEINCLUSIONptpDCRural() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONptpDCRural;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONptpDCRural(Boolean solicitudTINDICARCONTRATANTEINCLUSIONptpDCRural) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpDCRural = solicitudTINDICARCONTRATANTEINCLUSIONptpDCRural;
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTEINCLUSIONptpDCTelefonoFijo() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONptpDCTelefonoFijo;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONptpDCTelefonoFijo(String solicitudTINDICARCONTRATANTEINCLUSIONptpDCTelefonoFijo) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpDCTelefonoFijo = solicitudTINDICARCONTRATANTEINCLUSIONptpDCTelefonoFijo;
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTEINCLUSIONptpDCTelefonoCelular() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONptpDCTelefonoCelular;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONptpDCTelefonoCelular(String solicitudTINDICARCONTRATANTEINCLUSIONptpDCTelefonoCelular) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpDCTelefonoCelular = solicitudTINDICARCONTRATANTEINCLUSIONptpDCTelefonoCelular;
    }

    @JsonIgnore
    public PaisOid getSolicitudTINDICARCONTRATANTEINCLUSIONptpPais() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONptpPais;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONptpPais(PaisOid solicitudTINDICARCONTRATANTEINCLUSIONptpPais) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpPais = solicitudTINDICARCONTRATANTEINCLUSIONptpPais;
    }

    @JsonIgnore
    public Pais getSolicitudTINDICARCONTRATANTEINCLUSIONptpPaisInstance() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONptpPaisInstance;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONptpPaisInstance(Pais solicitudTINDICARCONTRATANTEINCLUSIONptpPais) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpPaisInstance = solicitudTINDICARCONTRATANTEINCLUSIONptpPais;
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpPais = solicitudTINDICARCONTRATANTEINCLUSIONptpPais != null ? solicitudTINDICARCONTRATANTEINCLUSIONptpPais.getOid() : null;
    }

    @JsonIgnore
    public Long getSolicitudTINDICARCONTRATANTEINCLUSIONptpCodigoCORE() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONptpCodigoCORE;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONptpCodigoCORE(Long solicitudTINDICARCONTRATANTEINCLUSIONptpCodigoCORE) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONptpCodigoCORE = solicitudTINDICARCONTRATANTEINCLUSIONptpCodigoCORE;
    }

    @JsonIgnore
    public Boolean getSolicitudTINDICARCONTRATANTEINCLUSIONptTieneEPSSanitas() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONptTieneEPSSanitas;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONptTieneEPSSanitas(Boolean solicitudTINDICARCONTRATANTEINCLUSIONptTieneEPSSanitas) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONptTieneEPSSanitas = solicitudTINDICARCONTRATANTEINCLUSIONptTieneEPSSanitas;
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTEINCLUSIONptRechazadoAfiliacion() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONptRechazadoAfiliacion;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONptRechazadoAfiliacion(String solicitudTINDICARCONTRATANTEINCLUSIONptRechazadoAfiliacion) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONptRechazadoAfiliacion = solicitudTINDICARCONTRATANTEINCLUSIONptRechazadoAfiliacion;
    }

    @JsonIgnore
    public PaisOid getSolicitudTINDICARCONTRATANTEINCLUSIONpDCPais() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONpDCPais;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONpDCPais(PaisOid solicitudTINDICARCONTRATANTEINCLUSIONpDCPais) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONpDCPais = solicitudTINDICARCONTRATANTEINCLUSIONpDCPais;
    }

    @JsonIgnore
    public Pais getSolicitudTINDICARCONTRATANTEINCLUSIONpDCPaisInstance() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONpDCPaisInstance;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONpDCPaisInstance(Pais solicitudTINDICARCONTRATANTEINCLUSIONpDCPais) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONpDCPaisInstance = solicitudTINDICARCONTRATANTEINCLUSIONpDCPais;
        this.solicitudTINDICARCONTRATANTEINCLUSIONpDCPais = solicitudTINDICARCONTRATANTEINCLUSIONpDCPais != null ? solicitudTINDICARCONTRATANTEINCLUSIONpDCPais.getOid() : null;
    }

    @JsonIgnore
    public Boolean getSolicitudTINDICARCONTRATANTEINCLUSIONpTitularBeneficios() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONpTitularBeneficios;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONpTitularBeneficios(Boolean solicitudTINDICARCONTRATANTEINCLUSIONpTitularBeneficios) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONpTitularBeneficios = solicitudTINDICARCONTRATANTEINCLUSIONpTitularBeneficios;
    }

    private void checkSolicitudTINDICARCONTRATANTEINCLUSIONpTitularBeneficios() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARCONTRATANTEINCLUSIONpTitularBeneficios() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARCONTRATANTEINCLUSION, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARCONTRATANTEINCLUSION_SOLICITUDTINDICARCONTRATANTEINCLUSIONPTITULARBENEFICIOS, SolicitudConstants.SERV_ALIAS_TINDICARCONTRATANTEINCLUSION, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARCONTRATANTEINCLUSION_SOLICITUDTINDICARCONTRATANTEINCLUSIONPTITULARBENEFICIOS);
        }
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTEINCLUSIONptTipoRegimen() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONptTipoRegimen;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONptTipoRegimen(String solicitudTINDICARCONTRATANTEINCLUSIONptTipoRegimen) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONptTipoRegimen = solicitudTINDICARCONTRATANTEINCLUSIONptTipoRegimen;
    }

    @JsonIgnore
    public EstadoPersonaOid getSolicitudTINDICARCONTRATANTEINCLUSIONptEstadoPersona() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONptEstadoPersona;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONptEstadoPersona(EstadoPersonaOid solicitudTINDICARCONTRATANTEINCLUSIONptEstadoPersona) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONptEstadoPersona = solicitudTINDICARCONTRATANTEINCLUSIONptEstadoPersona;
    }

    @JsonIgnore
    public EstadoPersona getSolicitudTINDICARCONTRATANTEINCLUSIONptEstadoPersonaInstance() {
        return this.solicitudTINDICARCONTRATANTEINCLUSIONptEstadoPersonaInstance;
    }
    
    public void setSolicitudTINDICARCONTRATANTEINCLUSIONptEstadoPersonaInstance(EstadoPersona solicitudTINDICARCONTRATANTEINCLUSIONptEstadoPersona) {
        this.solicitudTINDICARCONTRATANTEINCLUSIONptEstadoPersonaInstance = solicitudTINDICARCONTRATANTEINCLUSIONptEstadoPersona;
        this.solicitudTINDICARCONTRATANTEINCLUSIONptEstadoPersona = solicitudTINDICARCONTRATANTEINCLUSIONptEstadoPersona != null ? solicitudTINDICARCONTRATANTEINCLUSIONptEstadoPersona.getOid() : null;
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
