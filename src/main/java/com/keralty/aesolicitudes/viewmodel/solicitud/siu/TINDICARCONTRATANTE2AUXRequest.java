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

public class TINDICARCONTRATANTE2AUXRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudTINDICARCONTRATANTE2AUXpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudTINDICARCONTRATANTE2AUXpthisSolicitudInstance;

    @JsonProperty("pt_p_primernombre")
    private String solicitudTINDICARCONTRATANTE2AUXptpPrimerNombre;

    @JsonProperty("pt_p_segundonombre")
    private String solicitudTINDICARCONTRATANTE2AUXptpSegundoNombre;

    @JsonProperty("pt_p_primerapellido")
    private String solicitudTINDICARCONTRATANTE2AUXptpPrimerApellido;

    @JsonProperty("pt_p_segundoapellido")
    private String solicitudTINDICARCONTRATANTE2AUXptpSegundoApellido;

    @JsonProperty("pt_p_fechanacimiento")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date solicitudTINDICARCONTRATANTE2AUXptpFechaNacimiento;

    @JsonProperty("pt_p_genero")
    private String solicitudTINDICARCONTRATANTE2AUXptpGenero;

    @JsonProperty("pt_p_indicadorextranjero")
    private Boolean solicitudTINDICARCONTRATANTE2AUXptpIndicadorExtranjero;

    @JsonProperty("pt_p_telefonofijo")
    private String solicitudTINDICARCONTRATANTE2AUXptpTelefonoFijo;

    @JsonProperty("pt_p_telefonocelular")
    private String solicitudTINDICARCONTRATANTE2AUXptpTelefonoCelular;

    @JsonProperty("pt_p_correoelectronico")
    private String solicitudTINDICARCONTRATANTE2AUXptpCorreoElectronico;

    @JsonProperty("pt_p_evcdepartamentonac_oid")
    private DepartamentoOid solicitudTINDICARCONTRATANTE2AUXptpevcDepartamentoNac;
    
    @JsonIgnore
    private Departamento solicitudTINDICARCONTRATANTE2AUXptpevcDepartamentoNacInstance;

    @JsonProperty("pt_p_evcmunicipionac_oid")
    private MunicipioOid solicitudTINDICARCONTRATANTE2AUXptpevcMunicipioNac;
    
    @JsonIgnore
    private Municipio solicitudTINDICARCONTRATANTE2AUXptpevcMunicipioNacInstance;

    @JsonProperty("pt_p_evcestadocivil_oid")
    private EstadoCivilOid solicitudTINDICARCONTRATANTE2AUXptpevcEstadoCivil;
    
    @JsonIgnore
    private EstadoCivil solicitudTINDICARCONTRATANTE2AUXptpevcEstadoCivilInstance;

    @JsonProperty("pt_p_direccioncompleta")
    private String solicitudTINDICARCONTRATANTE2AUXptpDireccionCompleta;

    @JsonProperty("pt_p_rural")
    private Boolean solicitudTINDICARCONTRATANTE2AUXptpRural;

    @JsonProperty("pt_p_evcdepartamento_oid")
    private DepartamentoOid solicitudTINDICARCONTRATANTE2AUXptpevcDepartamento;
    
    @JsonIgnore
    private Departamento solicitudTINDICARCONTRATANTE2AUXptpevcDepartamentoInstance;

    @JsonProperty("pt_p_evcmunicipio_oid")
    private MunicipioOid solicitudTINDICARCONTRATANTE2AUXptpevcMunicipio;
    
    @JsonIgnore
    private Municipio solicitudTINDICARCONTRATANTE2AUXptpevcMunicipioInstance;

    @JsonProperty("pt_p_numidentificacion")
    private String solicitudTINDICARCONTRATANTE2AUXptpNumIdentificacion;

    @JsonProperty("pt_p_evctipoidentificacion_oid")
    private TipoIdentificacionOid solicitudTINDICARCONTRATANTE2AUXptpevcTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion solicitudTINDICARCONTRATANTE2AUXptpevcTipoIdentificacionInstance;

    @JsonProperty("pt_p_atrrazonsocial")
    private String solicitudTINDICARCONTRATANTE2AUXptpatrRazonSocial;

    @JsonProperty("pt_pdcdireccioncompleta")
    private String solicitudTINDICARCONTRATANTE2AUXptpDCDireccionCompleta;

    @JsonProperty("pt_pdcdepartamento_oid")
    private DepartamentoOid solicitudTINDICARCONTRATANTE2AUXptpDCDepartamento;
    
    @JsonIgnore
    private Departamento solicitudTINDICARCONTRATANTE2AUXptpDCDepartamentoInstance;

    @JsonProperty("pt_pdcmunicipio_oid")
    private MunicipioOid solicitudTINDICARCONTRATANTE2AUXptpDCMunicipio;
    
    @JsonIgnore
    private Municipio solicitudTINDICARCONTRATANTE2AUXptpDCMunicipioInstance;

    @JsonProperty("pt_pdcrural")
    private Boolean solicitudTINDICARCONTRATANTE2AUXptpDCRural;

    @JsonProperty("pt_pdctelefonofijo")
    private String solicitudTINDICARCONTRATANTE2AUXptpDCTelefonoFijo;

    @JsonProperty("pt_pdctelefonocelular")
    private String solicitudTINDICARCONTRATANTE2AUXptpDCTelefonoCelular;

    @JsonProperty("pt_p_pais_oid")
    private PaisOid solicitudTINDICARCONTRATANTE2AUXptpPais;
    
    @JsonIgnore
    private Pais solicitudTINDICARCONTRATANTE2AUXptpPaisInstance;

    @JsonProperty("pt_p_codigocore")
    private Long solicitudTINDICARCONTRATANTE2AUXptpCodigoCORE;

    @JsonProperty("pt_tieneepssanitas")
    private Boolean solicitudTINDICARCONTRATANTE2AUXptTieneEPSSanitas;

    @JsonProperty("pt_rechazadoafiliacion")
    private String solicitudTINDICARCONTRATANTE2AUXptRechazadoAfiliacion;

    @JsonProperty("pdcpais_oid")
    private PaisOid solicitudTINDICARCONTRATANTE2AUXpDCPais;
    
    @JsonIgnore
    private Pais solicitudTINDICARCONTRATANTE2AUXpDCPaisInstance;

    @JsonProperty("p_titularbeneficios")
    private Boolean solicitudTINDICARCONTRATANTE2AUXpTitularBeneficios;

    @JsonProperty("pt_diplomatico")
    private Boolean solicitudTINDICARCONTRATANTE2AUXptDiplomatico;

    @JsonProperty("pt_direccionesxclass")
    private String solicitudTINDICARCONTRATANTE2AUXptDireccionesXClass;

    @JsonProperty("ptreplicardireccion")
    private Boolean solicitudTINDICARCONTRATANTE2AUXptReplicarDireccion;

    @JsonProperty("ptchecktiporegimen")
    private Long solicitudTINDICARCONTRATANTE2AUXptCheckTipoRegimen;

    @JsonProperty("ptestadopersona_oid")
    private EstadoPersonaOid solicitudTINDICARCONTRATANTE2AUXptEstadoPersona;
    
    @JsonIgnore
    private EstadoPersona solicitudTINDICARCONTRATANTE2AUXptEstadoPersonaInstance;

    @JsonProperty("ptvalidardatos")
    private Boolean solicitudTINDICARCONTRATANTE2AUXptValidarDatos;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudTINDICARCONTRATANTE2AUXpthisSolicitud();
        checkSolicitudTINDICARCONTRATANTE2AUXptpNumIdentificacion();
        checkSolicitudTINDICARCONTRATANTE2AUXptpevcTipoIdentificacion();
        checkSolicitudTINDICARCONTRATANTE2AUXpTitularBeneficios();
        checkSolicitudTINDICARCONTRATANTE2AUXptDiplomatico();
        checkSolicitudTINDICARCONTRATANTE2AUXptReplicarDireccion();
        checkSolicitudTINDICARCONTRATANTE2AUXptValidarDatos();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudTINDICARCONTRATANTE2AUXpthisSolicitud() {
        return this.solicitudTINDICARCONTRATANTE2AUXpthisSolicitud;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXpthisSolicitud(SolicitudOid solicitudTINDICARCONTRATANTE2AUXpthisSolicitud) {
        this.solicitudTINDICARCONTRATANTE2AUXpthisSolicitud = solicitudTINDICARCONTRATANTE2AUXpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudTINDICARCONTRATANTE2AUXpthisSolicitudInstance() {
        return this.solicitudTINDICARCONTRATANTE2AUXpthisSolicitudInstance;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXpthisSolicitudInstance(Solicitud solicitudTINDICARCONTRATANTE2AUXpthisSolicitud) {
        this.solicitudTINDICARCONTRATANTE2AUXpthisSolicitudInstance = solicitudTINDICARCONTRATANTE2AUXpthisSolicitud;
        this.solicitudTINDICARCONTRATANTE2AUXpthisSolicitud = solicitudTINDICARCONTRATANTE2AUXpthisSolicitud != null ? solicitudTINDICARCONTRATANTE2AUXpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudTINDICARCONTRATANTE2AUXpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARCONTRATANTE2AUXpthisSolicitudInstance() == null || this.getSolicitudTINDICARCONTRATANTE2AUXpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARCONTRATANTE2AUX, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARCONTRATANTE2AUX_SOLICITUDTINDICARCONTRATANTE2AUXPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_TINDICARCONTRATANTE2AUX, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARCONTRATANTE2AUX_SOLICITUDTINDICARCONTRATANTE2AUXPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTE2AUXptpPrimerNombre() {
        return this.solicitudTINDICARCONTRATANTE2AUXptpPrimerNombre;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptpPrimerNombre(String solicitudTINDICARCONTRATANTE2AUXptpPrimerNombre) {
        this.solicitudTINDICARCONTRATANTE2AUXptpPrimerNombre = solicitudTINDICARCONTRATANTE2AUXptpPrimerNombre;
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTE2AUXptpSegundoNombre() {
        return this.solicitudTINDICARCONTRATANTE2AUXptpSegundoNombre;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptpSegundoNombre(String solicitudTINDICARCONTRATANTE2AUXptpSegundoNombre) {
        this.solicitudTINDICARCONTRATANTE2AUXptpSegundoNombre = solicitudTINDICARCONTRATANTE2AUXptpSegundoNombre;
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTE2AUXptpPrimerApellido() {
        return this.solicitudTINDICARCONTRATANTE2AUXptpPrimerApellido;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptpPrimerApellido(String solicitudTINDICARCONTRATANTE2AUXptpPrimerApellido) {
        this.solicitudTINDICARCONTRATANTE2AUXptpPrimerApellido = solicitudTINDICARCONTRATANTE2AUXptpPrimerApellido;
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTE2AUXptpSegundoApellido() {
        return this.solicitudTINDICARCONTRATANTE2AUXptpSegundoApellido;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptpSegundoApellido(String solicitudTINDICARCONTRATANTE2AUXptpSegundoApellido) {
        this.solicitudTINDICARCONTRATANTE2AUXptpSegundoApellido = solicitudTINDICARCONTRATANTE2AUXptpSegundoApellido;
    }

    @JsonIgnore
    public Date getSolicitudTINDICARCONTRATANTE2AUXptpFechaNacimiento() {
        return this.solicitudTINDICARCONTRATANTE2AUXptpFechaNacimiento;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setSolicitudTINDICARCONTRATANTE2AUXptpFechaNacimiento(Date solicitudTINDICARCONTRATANTE2AUXptpFechaNacimiento) {
        this.solicitudTINDICARCONTRATANTE2AUXptpFechaNacimiento = solicitudTINDICARCONTRATANTE2AUXptpFechaNacimiento;
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTE2AUXptpGenero() {
        return this.solicitudTINDICARCONTRATANTE2AUXptpGenero;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptpGenero(String solicitudTINDICARCONTRATANTE2AUXptpGenero) {
        this.solicitudTINDICARCONTRATANTE2AUXptpGenero = solicitudTINDICARCONTRATANTE2AUXptpGenero;
    }

    @JsonIgnore
    public Boolean getSolicitudTINDICARCONTRATANTE2AUXptpIndicadorExtranjero() {
        return this.solicitudTINDICARCONTRATANTE2AUXptpIndicadorExtranjero;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptpIndicadorExtranjero(Boolean solicitudTINDICARCONTRATANTE2AUXptpIndicadorExtranjero) {
        this.solicitudTINDICARCONTRATANTE2AUXptpIndicadorExtranjero = solicitudTINDICARCONTRATANTE2AUXptpIndicadorExtranjero;
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTE2AUXptpTelefonoFijo() {
        return this.solicitudTINDICARCONTRATANTE2AUXptpTelefonoFijo;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptpTelefonoFijo(String solicitudTINDICARCONTRATANTE2AUXptpTelefonoFijo) {
        this.solicitudTINDICARCONTRATANTE2AUXptpTelefonoFijo = solicitudTINDICARCONTRATANTE2AUXptpTelefonoFijo;
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTE2AUXptpTelefonoCelular() {
        return this.solicitudTINDICARCONTRATANTE2AUXptpTelefonoCelular;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptpTelefonoCelular(String solicitudTINDICARCONTRATANTE2AUXptpTelefonoCelular) {
        this.solicitudTINDICARCONTRATANTE2AUXptpTelefonoCelular = solicitudTINDICARCONTRATANTE2AUXptpTelefonoCelular;
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTE2AUXptpCorreoElectronico() {
        return this.solicitudTINDICARCONTRATANTE2AUXptpCorreoElectronico;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptpCorreoElectronico(String solicitudTINDICARCONTRATANTE2AUXptpCorreoElectronico) {
        this.solicitudTINDICARCONTRATANTE2AUXptpCorreoElectronico = solicitudTINDICARCONTRATANTE2AUXptpCorreoElectronico;
    }

    @JsonIgnore
    public DepartamentoOid getSolicitudTINDICARCONTRATANTE2AUXptpevcDepartamentoNac() {
        return this.solicitudTINDICARCONTRATANTE2AUXptpevcDepartamentoNac;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptpevcDepartamentoNac(DepartamentoOid solicitudTINDICARCONTRATANTE2AUXptpevcDepartamentoNac) {
        this.solicitudTINDICARCONTRATANTE2AUXptpevcDepartamentoNac = solicitudTINDICARCONTRATANTE2AUXptpevcDepartamentoNac;
    }

    @JsonIgnore
    public Departamento getSolicitudTINDICARCONTRATANTE2AUXptpevcDepartamentoNacInstance() {
        return this.solicitudTINDICARCONTRATANTE2AUXptpevcDepartamentoNacInstance;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptpevcDepartamentoNacInstance(Departamento solicitudTINDICARCONTRATANTE2AUXptpevcDepartamentoNac) {
        this.solicitudTINDICARCONTRATANTE2AUXptpevcDepartamentoNacInstance = solicitudTINDICARCONTRATANTE2AUXptpevcDepartamentoNac;
        this.solicitudTINDICARCONTRATANTE2AUXptpevcDepartamentoNac = solicitudTINDICARCONTRATANTE2AUXptpevcDepartamentoNac != null ? solicitudTINDICARCONTRATANTE2AUXptpevcDepartamentoNac.getOid() : null;
    }

    @JsonIgnore
    public MunicipioOid getSolicitudTINDICARCONTRATANTE2AUXptpevcMunicipioNac() {
        return this.solicitudTINDICARCONTRATANTE2AUXptpevcMunicipioNac;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptpevcMunicipioNac(MunicipioOid solicitudTINDICARCONTRATANTE2AUXptpevcMunicipioNac) {
        this.solicitudTINDICARCONTRATANTE2AUXptpevcMunicipioNac = solicitudTINDICARCONTRATANTE2AUXptpevcMunicipioNac;
    }

    @JsonIgnore
    public Municipio getSolicitudTINDICARCONTRATANTE2AUXptpevcMunicipioNacInstance() {
        return this.solicitudTINDICARCONTRATANTE2AUXptpevcMunicipioNacInstance;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptpevcMunicipioNacInstance(Municipio solicitudTINDICARCONTRATANTE2AUXptpevcMunicipioNac) {
        this.solicitudTINDICARCONTRATANTE2AUXptpevcMunicipioNacInstance = solicitudTINDICARCONTRATANTE2AUXptpevcMunicipioNac;
        this.solicitudTINDICARCONTRATANTE2AUXptpevcMunicipioNac = solicitudTINDICARCONTRATANTE2AUXptpevcMunicipioNac != null ? solicitudTINDICARCONTRATANTE2AUXptpevcMunicipioNac.getOid() : null;
    }

    @JsonIgnore
    public EstadoCivilOid getSolicitudTINDICARCONTRATANTE2AUXptpevcEstadoCivil() {
        return this.solicitudTINDICARCONTRATANTE2AUXptpevcEstadoCivil;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptpevcEstadoCivil(EstadoCivilOid solicitudTINDICARCONTRATANTE2AUXptpevcEstadoCivil) {
        this.solicitudTINDICARCONTRATANTE2AUXptpevcEstadoCivil = solicitudTINDICARCONTRATANTE2AUXptpevcEstadoCivil;
    }

    @JsonIgnore
    public EstadoCivil getSolicitudTINDICARCONTRATANTE2AUXptpevcEstadoCivilInstance() {
        return this.solicitudTINDICARCONTRATANTE2AUXptpevcEstadoCivilInstance;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptpevcEstadoCivilInstance(EstadoCivil solicitudTINDICARCONTRATANTE2AUXptpevcEstadoCivil) {
        this.solicitudTINDICARCONTRATANTE2AUXptpevcEstadoCivilInstance = solicitudTINDICARCONTRATANTE2AUXptpevcEstadoCivil;
        this.solicitudTINDICARCONTRATANTE2AUXptpevcEstadoCivil = solicitudTINDICARCONTRATANTE2AUXptpevcEstadoCivil != null ? solicitudTINDICARCONTRATANTE2AUXptpevcEstadoCivil.getOid() : null;
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTE2AUXptpDireccionCompleta() {
        return this.solicitudTINDICARCONTRATANTE2AUXptpDireccionCompleta;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptpDireccionCompleta(String solicitudTINDICARCONTRATANTE2AUXptpDireccionCompleta) {
        this.solicitudTINDICARCONTRATANTE2AUXptpDireccionCompleta = solicitudTINDICARCONTRATANTE2AUXptpDireccionCompleta;
    }

    @JsonIgnore
    public Boolean getSolicitudTINDICARCONTRATANTE2AUXptpRural() {
        return this.solicitudTINDICARCONTRATANTE2AUXptpRural;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptpRural(Boolean solicitudTINDICARCONTRATANTE2AUXptpRural) {
        this.solicitudTINDICARCONTRATANTE2AUXptpRural = solicitudTINDICARCONTRATANTE2AUXptpRural;
    }

    @JsonIgnore
    public DepartamentoOid getSolicitudTINDICARCONTRATANTE2AUXptpevcDepartamento() {
        return this.solicitudTINDICARCONTRATANTE2AUXptpevcDepartamento;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptpevcDepartamento(DepartamentoOid solicitudTINDICARCONTRATANTE2AUXptpevcDepartamento) {
        this.solicitudTINDICARCONTRATANTE2AUXptpevcDepartamento = solicitudTINDICARCONTRATANTE2AUXptpevcDepartamento;
    }

    @JsonIgnore
    public Departamento getSolicitudTINDICARCONTRATANTE2AUXptpevcDepartamentoInstance() {
        return this.solicitudTINDICARCONTRATANTE2AUXptpevcDepartamentoInstance;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptpevcDepartamentoInstance(Departamento solicitudTINDICARCONTRATANTE2AUXptpevcDepartamento) {
        this.solicitudTINDICARCONTRATANTE2AUXptpevcDepartamentoInstance = solicitudTINDICARCONTRATANTE2AUXptpevcDepartamento;
        this.solicitudTINDICARCONTRATANTE2AUXptpevcDepartamento = solicitudTINDICARCONTRATANTE2AUXptpevcDepartamento != null ? solicitudTINDICARCONTRATANTE2AUXptpevcDepartamento.getOid() : null;
    }

    @JsonIgnore
    public MunicipioOid getSolicitudTINDICARCONTRATANTE2AUXptpevcMunicipio() {
        return this.solicitudTINDICARCONTRATANTE2AUXptpevcMunicipio;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptpevcMunicipio(MunicipioOid solicitudTINDICARCONTRATANTE2AUXptpevcMunicipio) {
        this.solicitudTINDICARCONTRATANTE2AUXptpevcMunicipio = solicitudTINDICARCONTRATANTE2AUXptpevcMunicipio;
    }

    @JsonIgnore
    public Municipio getSolicitudTINDICARCONTRATANTE2AUXptpevcMunicipioInstance() {
        return this.solicitudTINDICARCONTRATANTE2AUXptpevcMunicipioInstance;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptpevcMunicipioInstance(Municipio solicitudTINDICARCONTRATANTE2AUXptpevcMunicipio) {
        this.solicitudTINDICARCONTRATANTE2AUXptpevcMunicipioInstance = solicitudTINDICARCONTRATANTE2AUXptpevcMunicipio;
        this.solicitudTINDICARCONTRATANTE2AUXptpevcMunicipio = solicitudTINDICARCONTRATANTE2AUXptpevcMunicipio != null ? solicitudTINDICARCONTRATANTE2AUXptpevcMunicipio.getOid() : null;
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTE2AUXptpNumIdentificacion() {
        return this.solicitudTINDICARCONTRATANTE2AUXptpNumIdentificacion;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptpNumIdentificacion(String solicitudTINDICARCONTRATANTE2AUXptpNumIdentificacion) {
        this.solicitudTINDICARCONTRATANTE2AUXptpNumIdentificacion = solicitudTINDICARCONTRATANTE2AUXptpNumIdentificacion;
    }

    private void checkSolicitudTINDICARCONTRATANTE2AUXptpNumIdentificacion() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARCONTRATANTE2AUXptpNumIdentificacion() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARCONTRATANTE2AUX, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARCONTRATANTE2AUX_SOLICITUDTINDICARCONTRATANTE2AUXPTPNUMIDENTIFICACION, SolicitudConstants.SERV_ALIAS_TINDICARCONTRATANTE2AUX, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARCONTRATANTE2AUX_SOLICITUDTINDICARCONTRATANTE2AUXPTPNUMIDENTIFICACION);
        }
    }

    @JsonIgnore
    public TipoIdentificacionOid getSolicitudTINDICARCONTRATANTE2AUXptpevcTipoIdentificacion() {
        return this.solicitudTINDICARCONTRATANTE2AUXptpevcTipoIdentificacion;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptpevcTipoIdentificacion(TipoIdentificacionOid solicitudTINDICARCONTRATANTE2AUXptpevcTipoIdentificacion) {
        this.solicitudTINDICARCONTRATANTE2AUXptpevcTipoIdentificacion = solicitudTINDICARCONTRATANTE2AUXptpevcTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getSolicitudTINDICARCONTRATANTE2AUXptpevcTipoIdentificacionInstance() {
        return this.solicitudTINDICARCONTRATANTE2AUXptpevcTipoIdentificacionInstance;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptpevcTipoIdentificacionInstance(TipoIdentificacion solicitudTINDICARCONTRATANTE2AUXptpevcTipoIdentificacion) {
        this.solicitudTINDICARCONTRATANTE2AUXptpevcTipoIdentificacionInstance = solicitudTINDICARCONTRATANTE2AUXptpevcTipoIdentificacion;
        this.solicitudTINDICARCONTRATANTE2AUXptpevcTipoIdentificacion = solicitudTINDICARCONTRATANTE2AUXptpevcTipoIdentificacion != null ? solicitudTINDICARCONTRATANTE2AUXptpevcTipoIdentificacion.getOid() : null;
    }

    private void checkSolicitudTINDICARCONTRATANTE2AUXptpevcTipoIdentificacion() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARCONTRATANTE2AUXptpevcTipoIdentificacionInstance() == null || this.getSolicitudTINDICARCONTRATANTE2AUXptpevcTipoIdentificacionInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARCONTRATANTE2AUX, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARCONTRATANTE2AUX_SOLICITUDTINDICARCONTRATANTE2AUXPTPEVCTIPOIDENTIFICACION, SolicitudConstants.SERV_ALIAS_TINDICARCONTRATANTE2AUX, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARCONTRATANTE2AUX_SOLICITUDTINDICARCONTRATANTE2AUXPTPEVCTIPOIDENTIFICACION);
        }
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTE2AUXptpatrRazonSocial() {
        return this.solicitudTINDICARCONTRATANTE2AUXptpatrRazonSocial;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptpatrRazonSocial(String solicitudTINDICARCONTRATANTE2AUXptpatrRazonSocial) {
        this.solicitudTINDICARCONTRATANTE2AUXptpatrRazonSocial = solicitudTINDICARCONTRATANTE2AUXptpatrRazonSocial;
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTE2AUXptpDCDireccionCompleta() {
        return this.solicitudTINDICARCONTRATANTE2AUXptpDCDireccionCompleta;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptpDCDireccionCompleta(String solicitudTINDICARCONTRATANTE2AUXptpDCDireccionCompleta) {
        this.solicitudTINDICARCONTRATANTE2AUXptpDCDireccionCompleta = solicitudTINDICARCONTRATANTE2AUXptpDCDireccionCompleta;
    }

    @JsonIgnore
    public DepartamentoOid getSolicitudTINDICARCONTRATANTE2AUXptpDCDepartamento() {
        return this.solicitudTINDICARCONTRATANTE2AUXptpDCDepartamento;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptpDCDepartamento(DepartamentoOid solicitudTINDICARCONTRATANTE2AUXptpDCDepartamento) {
        this.solicitudTINDICARCONTRATANTE2AUXptpDCDepartamento = solicitudTINDICARCONTRATANTE2AUXptpDCDepartamento;
    }

    @JsonIgnore
    public Departamento getSolicitudTINDICARCONTRATANTE2AUXptpDCDepartamentoInstance() {
        return this.solicitudTINDICARCONTRATANTE2AUXptpDCDepartamentoInstance;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptpDCDepartamentoInstance(Departamento solicitudTINDICARCONTRATANTE2AUXptpDCDepartamento) {
        this.solicitudTINDICARCONTRATANTE2AUXptpDCDepartamentoInstance = solicitudTINDICARCONTRATANTE2AUXptpDCDepartamento;
        this.solicitudTINDICARCONTRATANTE2AUXptpDCDepartamento = solicitudTINDICARCONTRATANTE2AUXptpDCDepartamento != null ? solicitudTINDICARCONTRATANTE2AUXptpDCDepartamento.getOid() : null;
    }

    @JsonIgnore
    public MunicipioOid getSolicitudTINDICARCONTRATANTE2AUXptpDCMunicipio() {
        return this.solicitudTINDICARCONTRATANTE2AUXptpDCMunicipio;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptpDCMunicipio(MunicipioOid solicitudTINDICARCONTRATANTE2AUXptpDCMunicipio) {
        this.solicitudTINDICARCONTRATANTE2AUXptpDCMunicipio = solicitudTINDICARCONTRATANTE2AUXptpDCMunicipio;
    }

    @JsonIgnore
    public Municipio getSolicitudTINDICARCONTRATANTE2AUXptpDCMunicipioInstance() {
        return this.solicitudTINDICARCONTRATANTE2AUXptpDCMunicipioInstance;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptpDCMunicipioInstance(Municipio solicitudTINDICARCONTRATANTE2AUXptpDCMunicipio) {
        this.solicitudTINDICARCONTRATANTE2AUXptpDCMunicipioInstance = solicitudTINDICARCONTRATANTE2AUXptpDCMunicipio;
        this.solicitudTINDICARCONTRATANTE2AUXptpDCMunicipio = solicitudTINDICARCONTRATANTE2AUXptpDCMunicipio != null ? solicitudTINDICARCONTRATANTE2AUXptpDCMunicipio.getOid() : null;
    }

    @JsonIgnore
    public Boolean getSolicitudTINDICARCONTRATANTE2AUXptpDCRural() {
        return this.solicitudTINDICARCONTRATANTE2AUXptpDCRural;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptpDCRural(Boolean solicitudTINDICARCONTRATANTE2AUXptpDCRural) {
        this.solicitudTINDICARCONTRATANTE2AUXptpDCRural = solicitudTINDICARCONTRATANTE2AUXptpDCRural;
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTE2AUXptpDCTelefonoFijo() {
        return this.solicitudTINDICARCONTRATANTE2AUXptpDCTelefonoFijo;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptpDCTelefonoFijo(String solicitudTINDICARCONTRATANTE2AUXptpDCTelefonoFijo) {
        this.solicitudTINDICARCONTRATANTE2AUXptpDCTelefonoFijo = solicitudTINDICARCONTRATANTE2AUXptpDCTelefonoFijo;
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTE2AUXptpDCTelefonoCelular() {
        return this.solicitudTINDICARCONTRATANTE2AUXptpDCTelefonoCelular;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptpDCTelefonoCelular(String solicitudTINDICARCONTRATANTE2AUXptpDCTelefonoCelular) {
        this.solicitudTINDICARCONTRATANTE2AUXptpDCTelefonoCelular = solicitudTINDICARCONTRATANTE2AUXptpDCTelefonoCelular;
    }

    @JsonIgnore
    public PaisOid getSolicitudTINDICARCONTRATANTE2AUXptpPais() {
        return this.solicitudTINDICARCONTRATANTE2AUXptpPais;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptpPais(PaisOid solicitudTINDICARCONTRATANTE2AUXptpPais) {
        this.solicitudTINDICARCONTRATANTE2AUXptpPais = solicitudTINDICARCONTRATANTE2AUXptpPais;
    }

    @JsonIgnore
    public Pais getSolicitudTINDICARCONTRATANTE2AUXptpPaisInstance() {
        return this.solicitudTINDICARCONTRATANTE2AUXptpPaisInstance;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptpPaisInstance(Pais solicitudTINDICARCONTRATANTE2AUXptpPais) {
        this.solicitudTINDICARCONTRATANTE2AUXptpPaisInstance = solicitudTINDICARCONTRATANTE2AUXptpPais;
        this.solicitudTINDICARCONTRATANTE2AUXptpPais = solicitudTINDICARCONTRATANTE2AUXptpPais != null ? solicitudTINDICARCONTRATANTE2AUXptpPais.getOid() : null;
    }

    @JsonIgnore
    public Long getSolicitudTINDICARCONTRATANTE2AUXptpCodigoCORE() {
        return this.solicitudTINDICARCONTRATANTE2AUXptpCodigoCORE;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptpCodigoCORE(Long solicitudTINDICARCONTRATANTE2AUXptpCodigoCORE) {
        this.solicitudTINDICARCONTRATANTE2AUXptpCodigoCORE = solicitudTINDICARCONTRATANTE2AUXptpCodigoCORE;
    }

    @JsonIgnore
    public Boolean getSolicitudTINDICARCONTRATANTE2AUXptTieneEPSSanitas() {
        return this.solicitudTINDICARCONTRATANTE2AUXptTieneEPSSanitas;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptTieneEPSSanitas(Boolean solicitudTINDICARCONTRATANTE2AUXptTieneEPSSanitas) {
        this.solicitudTINDICARCONTRATANTE2AUXptTieneEPSSanitas = solicitudTINDICARCONTRATANTE2AUXptTieneEPSSanitas;
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTE2AUXptRechazadoAfiliacion() {
        return this.solicitudTINDICARCONTRATANTE2AUXptRechazadoAfiliacion;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptRechazadoAfiliacion(String solicitudTINDICARCONTRATANTE2AUXptRechazadoAfiliacion) {
        this.solicitudTINDICARCONTRATANTE2AUXptRechazadoAfiliacion = solicitudTINDICARCONTRATANTE2AUXptRechazadoAfiliacion;
    }

    @JsonIgnore
    public PaisOid getSolicitudTINDICARCONTRATANTE2AUXpDCPais() {
        return this.solicitudTINDICARCONTRATANTE2AUXpDCPais;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXpDCPais(PaisOid solicitudTINDICARCONTRATANTE2AUXpDCPais) {
        this.solicitudTINDICARCONTRATANTE2AUXpDCPais = solicitudTINDICARCONTRATANTE2AUXpDCPais;
    }

    @JsonIgnore
    public Pais getSolicitudTINDICARCONTRATANTE2AUXpDCPaisInstance() {
        return this.solicitudTINDICARCONTRATANTE2AUXpDCPaisInstance;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXpDCPaisInstance(Pais solicitudTINDICARCONTRATANTE2AUXpDCPais) {
        this.solicitudTINDICARCONTRATANTE2AUXpDCPaisInstance = solicitudTINDICARCONTRATANTE2AUXpDCPais;
        this.solicitudTINDICARCONTRATANTE2AUXpDCPais = solicitudTINDICARCONTRATANTE2AUXpDCPais != null ? solicitudTINDICARCONTRATANTE2AUXpDCPais.getOid() : null;
    }

    @JsonIgnore
    public Boolean getSolicitudTINDICARCONTRATANTE2AUXpTitularBeneficios() {
        return this.solicitudTINDICARCONTRATANTE2AUXpTitularBeneficios;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXpTitularBeneficios(Boolean solicitudTINDICARCONTRATANTE2AUXpTitularBeneficios) {
        this.solicitudTINDICARCONTRATANTE2AUXpTitularBeneficios = solicitudTINDICARCONTRATANTE2AUXpTitularBeneficios;
    }

    private void checkSolicitudTINDICARCONTRATANTE2AUXpTitularBeneficios() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARCONTRATANTE2AUXpTitularBeneficios() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARCONTRATANTE2AUX, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARCONTRATANTE2AUX_SOLICITUDTINDICARCONTRATANTE2AUXPTITULARBENEFICIOS, SolicitudConstants.SERV_ALIAS_TINDICARCONTRATANTE2AUX, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARCONTRATANTE2AUX_SOLICITUDTINDICARCONTRATANTE2AUXPTITULARBENEFICIOS);
        }
    }

    @JsonIgnore
    public Boolean getSolicitudTINDICARCONTRATANTE2AUXptDiplomatico() {
        return this.solicitudTINDICARCONTRATANTE2AUXptDiplomatico;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptDiplomatico(Boolean solicitudTINDICARCONTRATANTE2AUXptDiplomatico) {
        this.solicitudTINDICARCONTRATANTE2AUXptDiplomatico = solicitudTINDICARCONTRATANTE2AUXptDiplomatico;
    }

    private void checkSolicitudTINDICARCONTRATANTE2AUXptDiplomatico() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARCONTRATANTE2AUXptDiplomatico() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARCONTRATANTE2AUX, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARCONTRATANTE2AUX_SOLICITUDTINDICARCONTRATANTE2AUXPTDIPLOMATICO, SolicitudConstants.SERV_ALIAS_TINDICARCONTRATANTE2AUX, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARCONTRATANTE2AUX_SOLICITUDTINDICARCONTRATANTE2AUXPTDIPLOMATICO);
        }
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTE2AUXptDireccionesXClass() {
        return this.solicitudTINDICARCONTRATANTE2AUXptDireccionesXClass;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptDireccionesXClass(String solicitudTINDICARCONTRATANTE2AUXptDireccionesXClass) {
        this.solicitudTINDICARCONTRATANTE2AUXptDireccionesXClass = solicitudTINDICARCONTRATANTE2AUXptDireccionesXClass;
    }

    @JsonIgnore
    public Boolean getSolicitudTINDICARCONTRATANTE2AUXptReplicarDireccion() {
        return this.solicitudTINDICARCONTRATANTE2AUXptReplicarDireccion;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptReplicarDireccion(Boolean solicitudTINDICARCONTRATANTE2AUXptReplicarDireccion) {
        this.solicitudTINDICARCONTRATANTE2AUXptReplicarDireccion = solicitudTINDICARCONTRATANTE2AUXptReplicarDireccion;
    }

    private void checkSolicitudTINDICARCONTRATANTE2AUXptReplicarDireccion() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARCONTRATANTE2AUXptReplicarDireccion() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARCONTRATANTE2AUX, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARCONTRATANTE2AUX_SOLICITUDTINDICARCONTRATANTE2AUXPTREPLICARDIRECCION, SolicitudConstants.SERV_ALIAS_TINDICARCONTRATANTE2AUX, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARCONTRATANTE2AUX_SOLICITUDTINDICARCONTRATANTE2AUXPTREPLICARDIRECCION);
        }
    }

    @JsonIgnore
    public Long getSolicitudTINDICARCONTRATANTE2AUXptCheckTipoRegimen() {
        return this.solicitudTINDICARCONTRATANTE2AUXptCheckTipoRegimen;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptCheckTipoRegimen(Long solicitudTINDICARCONTRATANTE2AUXptCheckTipoRegimen) {
        this.solicitudTINDICARCONTRATANTE2AUXptCheckTipoRegimen = solicitudTINDICARCONTRATANTE2AUXptCheckTipoRegimen;
    }

    @JsonIgnore
    public EstadoPersonaOid getSolicitudTINDICARCONTRATANTE2AUXptEstadoPersona() {
        return this.solicitudTINDICARCONTRATANTE2AUXptEstadoPersona;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptEstadoPersona(EstadoPersonaOid solicitudTINDICARCONTRATANTE2AUXptEstadoPersona) {
        this.solicitudTINDICARCONTRATANTE2AUXptEstadoPersona = solicitudTINDICARCONTRATANTE2AUXptEstadoPersona;
    }

    @JsonIgnore
    public EstadoPersona getSolicitudTINDICARCONTRATANTE2AUXptEstadoPersonaInstance() {
        return this.solicitudTINDICARCONTRATANTE2AUXptEstadoPersonaInstance;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptEstadoPersonaInstance(EstadoPersona solicitudTINDICARCONTRATANTE2AUXptEstadoPersona) {
        this.solicitudTINDICARCONTRATANTE2AUXptEstadoPersonaInstance = solicitudTINDICARCONTRATANTE2AUXptEstadoPersona;
        this.solicitudTINDICARCONTRATANTE2AUXptEstadoPersona = solicitudTINDICARCONTRATANTE2AUXptEstadoPersona != null ? solicitudTINDICARCONTRATANTE2AUXptEstadoPersona.getOid() : null;
    }

    @JsonIgnore
    public Boolean getSolicitudTINDICARCONTRATANTE2AUXptValidarDatos() {
        return this.solicitudTINDICARCONTRATANTE2AUXptValidarDatos;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2AUXptValidarDatos(Boolean solicitudTINDICARCONTRATANTE2AUXptValidarDatos) {
        this.solicitudTINDICARCONTRATANTE2AUXptValidarDatos = solicitudTINDICARCONTRATANTE2AUXptValidarDatos;
    }

    private void checkSolicitudTINDICARCONTRATANTE2AUXptValidarDatos() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARCONTRATANTE2AUXptValidarDatos() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARCONTRATANTE2AUX, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARCONTRATANTE2AUX_SOLICITUDTINDICARCONTRATANTE2AUXPTVALIDARDATOS, SolicitudConstants.SERV_ALIAS_TINDICARCONTRATANTE2AUX, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARCONTRATANTE2AUX_SOLICITUDTINDICARCONTRATANTE2AUXPTVALIDARDATOS);
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
