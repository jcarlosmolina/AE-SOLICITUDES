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
import com.keralty.aesolicitudes.persistence.oid.EstadoPersonaOid;
import com.keralty.aesolicitudes.persistence.oid.PaisOid;
import com.keralty.aesolicitudes.persistence.oid.SolicitudOid;
import com.keralty.aesolicitudes.persistence.Pais;
import com.keralty.aesolicitudes.persistence.Solicitud;
import com.keralty.aesolicitudes.persistence.TipoIdentificacion;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class TINDICARCONTRATANTE2Request {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudTINDICARCONTRATANTE2pthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudTINDICARCONTRATANTE2pthisSolicitudInstance;

    @JsonProperty("pt_p_primernombre")
    private String solicitudTINDICARCONTRATANTE2ptpPrimerNombre;

    @JsonProperty("pt_p_segundonombre")
    private String solicitudTINDICARCONTRATANTE2ptpSegundoNombre;

    @JsonProperty("pt_p_primerapellido")
    private String solicitudTINDICARCONTRATANTE2ptpPrimerApellido;

    @JsonProperty("pt_p_segundoapellido")
    private String solicitudTINDICARCONTRATANTE2ptpSegundoApellido;

    @JsonProperty("pt_p_fechanacimiento")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date solicitudTINDICARCONTRATANTE2ptpFechaNacimiento;

    @JsonProperty("pt_p_genero")
    private String solicitudTINDICARCONTRATANTE2ptpGenero;

    @JsonProperty("pt_p_indicadorextranjero")
    private Boolean solicitudTINDICARCONTRATANTE2ptpIndicadorExtranjero;

    @JsonProperty("pt_p_telefonofijo")
    private String solicitudTINDICARCONTRATANTE2ptpTelefonoFijo;

    @JsonProperty("pt_p_telefonocelular")
    private String solicitudTINDICARCONTRATANTE2ptpTelefonoCelular;

    @JsonProperty("pt_p_correoelectronico")
    private String solicitudTINDICARCONTRATANTE2ptpCorreoElectronico;

    @JsonProperty("pt_p_evcdepartamentonac_json")
    private String solicitudTINDICARCONTRATANTE2ptpevcDepartamentoNac;
    
    @JsonIgnore
    private Departamento solicitudTINDICARCONTRATANTE2ptpevcDepartamentoNacInstance;

    @JsonProperty("pt_p_evcmunicipionac_json")
    private String solicitudTINDICARCONTRATANTE2ptpevcMunicipioNac;
    
    @JsonIgnore
    private Municipio solicitudTINDICARCONTRATANTE2ptpevcMunicipioNacInstance;

    @JsonProperty("pt_p_evcestadocivil_json")
    private String solicitudTINDICARCONTRATANTE2ptpevcEstadoCivil;
    
    @JsonIgnore
    private EstadoCivil solicitudTINDICARCONTRATANTE2ptpevcEstadoCivilInstance;

    @JsonProperty("pt_p_direccioncompleta")
    private String solicitudTINDICARCONTRATANTE2ptpDireccionCompleta;

    @JsonProperty("pt_p_rural")
    private Boolean solicitudTINDICARCONTRATANTE2ptpRural;

    @JsonProperty("pt_p_evcdepartamento_json")
    private String solicitudTINDICARCONTRATANTE2ptpevcDepartamento;
    
    @JsonIgnore
    private Departamento solicitudTINDICARCONTRATANTE2ptpevcDepartamentoInstance;

    @JsonProperty("pt_p_evcmunicipio_json")
    private String solicitudTINDICARCONTRATANTE2ptpevcMunicipio;
    
    @JsonIgnore
    private Municipio solicitudTINDICARCONTRATANTE2ptpevcMunicipioInstance;

    @JsonProperty("pt_p_numidentificacion")
    private String solicitudTINDICARCONTRATANTE2ptpNumIdentificacion;

    @JsonProperty("pt_p_evctipoidentificacion_json")
    private String solicitudTINDICARCONTRATANTE2ptpevcTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion solicitudTINDICARCONTRATANTE2ptpevcTipoIdentificacionInstance;

    @JsonProperty("pt_p_atrrazonsocial")
    private String solicitudTINDICARCONTRATANTE2ptpatrRazonSocial;

    @JsonProperty("pt_pdcdireccioncompleta")
    private String solicitudTINDICARCONTRATANTE2ptpDCDireccionCompleta;

    @JsonProperty("pt_pdcdepartamento_json")
    private String solicitudTINDICARCONTRATANTE2ptpDCDepartamento;
    
    @JsonIgnore
    private Departamento solicitudTINDICARCONTRATANTE2ptpDCDepartamentoInstance;

    @JsonProperty("pt_pdcmunicipio_json")
    private String solicitudTINDICARCONTRATANTE2ptpDCMunicipio;
    
    @JsonIgnore
    private Municipio solicitudTINDICARCONTRATANTE2ptpDCMunicipioInstance;

    @JsonProperty("pt_pdcrural")
    private Boolean solicitudTINDICARCONTRATANTE2ptpDCRural;

    @JsonProperty("pt_pdctelefonofijo")
    private String solicitudTINDICARCONTRATANTE2ptpDCTelefonoFijo;

    @JsonProperty("pt_pdctelefonocelular")
    private String solicitudTINDICARCONTRATANTE2ptpDCTelefonoCelular;

    @JsonProperty("pt_p_pais_oid")
    private PaisOid solicitudTINDICARCONTRATANTE2ptpPais;
    
    @JsonIgnore
    private Pais solicitudTINDICARCONTRATANTE2ptpPaisInstance;

    @JsonProperty("pt_p_codigocore")
    private Long solicitudTINDICARCONTRATANTE2ptpCodigoCORE;

    @JsonProperty("pt_tieneepssanitas")
    private Boolean solicitudTINDICARCONTRATANTE2ptTieneEPSSanitas;

    @JsonProperty("pt_rechazadoafiliacion")
    private String solicitudTINDICARCONTRATANTE2ptRechazadoAfiliacion;

    @JsonProperty("pdcpais_oid")
    private PaisOid solicitudTINDICARCONTRATANTE2pDCPais;
    
    @JsonIgnore
    private Pais solicitudTINDICARCONTRATANTE2pDCPaisInstance;

    @JsonProperty("p_titularbeneficios")
    private Boolean solicitudTINDICARCONTRATANTE2pTitularBeneficios;

    @JsonProperty("pt_diplomatico")
    private Boolean solicitudTINDICARCONTRATANTE2ptDiplomatico;

    @JsonProperty("pt_direccionesxclass")
    private String solicitudTINDICARCONTRATANTE2ptDireccionesXClass;

    @JsonProperty("ptreplicardireccion")
    private Boolean solicitudTINDICARCONTRATANTE2ptReplicarDireccion;

    @JsonProperty("ptestadopersona_oid")
    private EstadoPersonaOid solicitudTINDICARCONTRATANTE2ptEstadoPersona;
    
    @JsonIgnore
    private EstadoPersona solicitudTINDICARCONTRATANTE2ptEstadoPersonaInstance;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudTINDICARCONTRATANTE2pthisSolicitud();
        checkSolicitudTINDICARCONTRATANTE2ptpIndicadorExtranjero();
        checkSolicitudTINDICARCONTRATANTE2ptpRural();
        checkSolicitudTINDICARCONTRATANTE2ptpNumIdentificacion();
        checkSolicitudTINDICARCONTRATANTE2ptpevcTipoIdentificacion();
        checkSolicitudTINDICARCONTRATANTE2ptpDCDireccionCompleta();
        checkSolicitudTINDICARCONTRATANTE2ptpDCDepartamento();
        checkSolicitudTINDICARCONTRATANTE2ptpDCMunicipio();
        checkSolicitudTINDICARCONTRATANTE2ptpDCRural();
        checkSolicitudTINDICARCONTRATANTE2ptTieneEPSSanitas();
        checkSolicitudTINDICARCONTRATANTE2pTitularBeneficios();
        checkSolicitudTINDICARCONTRATANTE2ptDiplomatico();
        checkSolicitudTINDICARCONTRATANTE2ptReplicarDireccion();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudTINDICARCONTRATANTE2pthisSolicitud() {
        return this.solicitudTINDICARCONTRATANTE2pthisSolicitud;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2pthisSolicitud(SolicitudOid solicitudTINDICARCONTRATANTE2pthisSolicitud) {
        this.solicitudTINDICARCONTRATANTE2pthisSolicitud = solicitudTINDICARCONTRATANTE2pthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudTINDICARCONTRATANTE2pthisSolicitudInstance() {
        return this.solicitudTINDICARCONTRATANTE2pthisSolicitudInstance;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2pthisSolicitudInstance(Solicitud solicitudTINDICARCONTRATANTE2pthisSolicitud) {
        this.solicitudTINDICARCONTRATANTE2pthisSolicitudInstance = solicitudTINDICARCONTRATANTE2pthisSolicitud;
        this.solicitudTINDICARCONTRATANTE2pthisSolicitud = solicitudTINDICARCONTRATANTE2pthisSolicitud != null ? solicitudTINDICARCONTRATANTE2pthisSolicitud.getOid() : null;
    }

    private void checkSolicitudTINDICARCONTRATANTE2pthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARCONTRATANTE2pthisSolicitudInstance() == null || this.getSolicitudTINDICARCONTRATANTE2pthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARCONTRATANTE2, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARCONTRATANTE2_SOLICITUDTINDICARCONTRATANTE2PTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_TINDICARCONTRATANTE2, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARCONTRATANTE2_SOLICITUDTINDICARCONTRATANTE2PTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTE2ptpPrimerNombre() {
        return this.solicitudTINDICARCONTRATANTE2ptpPrimerNombre;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2ptpPrimerNombre(String solicitudTINDICARCONTRATANTE2ptpPrimerNombre) {
        this.solicitudTINDICARCONTRATANTE2ptpPrimerNombre = solicitudTINDICARCONTRATANTE2ptpPrimerNombre;
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTE2ptpSegundoNombre() {
        return this.solicitudTINDICARCONTRATANTE2ptpSegundoNombre;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2ptpSegundoNombre(String solicitudTINDICARCONTRATANTE2ptpSegundoNombre) {
        this.solicitudTINDICARCONTRATANTE2ptpSegundoNombre = solicitudTINDICARCONTRATANTE2ptpSegundoNombre;
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTE2ptpPrimerApellido() {
        return this.solicitudTINDICARCONTRATANTE2ptpPrimerApellido;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2ptpPrimerApellido(String solicitudTINDICARCONTRATANTE2ptpPrimerApellido) {
        this.solicitudTINDICARCONTRATANTE2ptpPrimerApellido = solicitudTINDICARCONTRATANTE2ptpPrimerApellido;
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTE2ptpSegundoApellido() {
        return this.solicitudTINDICARCONTRATANTE2ptpSegundoApellido;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2ptpSegundoApellido(String solicitudTINDICARCONTRATANTE2ptpSegundoApellido) {
        this.solicitudTINDICARCONTRATANTE2ptpSegundoApellido = solicitudTINDICARCONTRATANTE2ptpSegundoApellido;
    }

    @JsonIgnore
    public Date getSolicitudTINDICARCONTRATANTE2ptpFechaNacimiento() {
        return this.solicitudTINDICARCONTRATANTE2ptpFechaNacimiento;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setSolicitudTINDICARCONTRATANTE2ptpFechaNacimiento(Date solicitudTINDICARCONTRATANTE2ptpFechaNacimiento) {
        this.solicitudTINDICARCONTRATANTE2ptpFechaNacimiento = solicitudTINDICARCONTRATANTE2ptpFechaNacimiento;
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTE2ptpGenero() {
        return this.solicitudTINDICARCONTRATANTE2ptpGenero;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2ptpGenero(String solicitudTINDICARCONTRATANTE2ptpGenero) {
        this.solicitudTINDICARCONTRATANTE2ptpGenero = solicitudTINDICARCONTRATANTE2ptpGenero;
    }

    @JsonIgnore
    public Boolean getSolicitudTINDICARCONTRATANTE2ptpIndicadorExtranjero() {
        return this.solicitudTINDICARCONTRATANTE2ptpIndicadorExtranjero;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2ptpIndicadorExtranjero(Boolean solicitudTINDICARCONTRATANTE2ptpIndicadorExtranjero) {
        this.solicitudTINDICARCONTRATANTE2ptpIndicadorExtranjero = solicitudTINDICARCONTRATANTE2ptpIndicadorExtranjero;
    }

    private void checkSolicitudTINDICARCONTRATANTE2ptpIndicadorExtranjero() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARCONTRATANTE2ptpIndicadorExtranjero() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARCONTRATANTE2, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARCONTRATANTE2_SOLICITUDTINDICARCONTRATANTE2PTPINDICADOREXTRANJERO, SolicitudConstants.SERV_ALIAS_TINDICARCONTRATANTE2, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARCONTRATANTE2_SOLICITUDTINDICARCONTRATANTE2PTPINDICADOREXTRANJERO);
        }
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTE2ptpTelefonoFijo() {
        return this.solicitudTINDICARCONTRATANTE2ptpTelefonoFijo;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2ptpTelefonoFijo(String solicitudTINDICARCONTRATANTE2ptpTelefonoFijo) {
        this.solicitudTINDICARCONTRATANTE2ptpTelefonoFijo = solicitudTINDICARCONTRATANTE2ptpTelefonoFijo;
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTE2ptpTelefonoCelular() {
        return this.solicitudTINDICARCONTRATANTE2ptpTelefonoCelular;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2ptpTelefonoCelular(String solicitudTINDICARCONTRATANTE2ptpTelefonoCelular) {
        this.solicitudTINDICARCONTRATANTE2ptpTelefonoCelular = solicitudTINDICARCONTRATANTE2ptpTelefonoCelular;
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTE2ptpCorreoElectronico() {
        return this.solicitudTINDICARCONTRATANTE2ptpCorreoElectronico;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2ptpCorreoElectronico(String solicitudTINDICARCONTRATANTE2ptpCorreoElectronico) {
        this.solicitudTINDICARCONTRATANTE2ptpCorreoElectronico = solicitudTINDICARCONTRATANTE2ptpCorreoElectronico;
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTE2ptpevcDepartamentoNac() {
        return this.solicitudTINDICARCONTRATANTE2ptpevcDepartamentoNac;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2ptpevcDepartamentoNac(String solicitudTINDICARCONTRATANTE2ptpevcDepartamentoNac) {
        this.solicitudTINDICARCONTRATANTE2ptpevcDepartamentoNac = solicitudTINDICARCONTRATANTE2ptpevcDepartamentoNac;
    }

    @JsonIgnore
    public Departamento getSolicitudTINDICARCONTRATANTE2ptpevcDepartamentoNacInstance() {
        return this.solicitudTINDICARCONTRATANTE2ptpevcDepartamentoNacInstance;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2ptpevcDepartamentoNacInstance(Departamento solicitudTINDICARCONTRATANTE2ptpevcDepartamentoNac) {
        this.solicitudTINDICARCONTRATANTE2ptpevcDepartamentoNacInstance = solicitudTINDICARCONTRATANTE2ptpevcDepartamentoNac;
        this.solicitudTINDICARCONTRATANTE2ptpevcDepartamentoNac = solicitudTINDICARCONTRATANTE2ptpevcDepartamentoNac != null ? solicitudTINDICARCONTRATANTE2ptpevcDepartamentoNac.getOid().toJson() : "";
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTE2ptpevcMunicipioNac() {
        return this.solicitudTINDICARCONTRATANTE2ptpevcMunicipioNac;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2ptpevcMunicipioNac(String solicitudTINDICARCONTRATANTE2ptpevcMunicipioNac) {
        this.solicitudTINDICARCONTRATANTE2ptpevcMunicipioNac = solicitudTINDICARCONTRATANTE2ptpevcMunicipioNac;
    }

    @JsonIgnore
    public Municipio getSolicitudTINDICARCONTRATANTE2ptpevcMunicipioNacInstance() {
        return this.solicitudTINDICARCONTRATANTE2ptpevcMunicipioNacInstance;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2ptpevcMunicipioNacInstance(Municipio solicitudTINDICARCONTRATANTE2ptpevcMunicipioNac) {
        this.solicitudTINDICARCONTRATANTE2ptpevcMunicipioNacInstance = solicitudTINDICARCONTRATANTE2ptpevcMunicipioNac;
        this.solicitudTINDICARCONTRATANTE2ptpevcMunicipioNac = solicitudTINDICARCONTRATANTE2ptpevcMunicipioNac != null ? solicitudTINDICARCONTRATANTE2ptpevcMunicipioNac.getOid().toJson() : "";
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTE2ptpevcEstadoCivil() {
        return this.solicitudTINDICARCONTRATANTE2ptpevcEstadoCivil;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2ptpevcEstadoCivil(String solicitudTINDICARCONTRATANTE2ptpevcEstadoCivil) {
        this.solicitudTINDICARCONTRATANTE2ptpevcEstadoCivil = solicitudTINDICARCONTRATANTE2ptpevcEstadoCivil;
    }

    @JsonIgnore
    public EstadoCivil getSolicitudTINDICARCONTRATANTE2ptpevcEstadoCivilInstance() {
        return this.solicitudTINDICARCONTRATANTE2ptpevcEstadoCivilInstance;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2ptpevcEstadoCivilInstance(EstadoCivil solicitudTINDICARCONTRATANTE2ptpevcEstadoCivil) {
        this.solicitudTINDICARCONTRATANTE2ptpevcEstadoCivilInstance = solicitudTINDICARCONTRATANTE2ptpevcEstadoCivil;
        this.solicitudTINDICARCONTRATANTE2ptpevcEstadoCivil = solicitudTINDICARCONTRATANTE2ptpevcEstadoCivil != null ? solicitudTINDICARCONTRATANTE2ptpevcEstadoCivil.getOid().toJson() : "";
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTE2ptpDireccionCompleta() {
        return this.solicitudTINDICARCONTRATANTE2ptpDireccionCompleta;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2ptpDireccionCompleta(String solicitudTINDICARCONTRATANTE2ptpDireccionCompleta) {
        this.solicitudTINDICARCONTRATANTE2ptpDireccionCompleta = solicitudTINDICARCONTRATANTE2ptpDireccionCompleta;
    }

    @JsonIgnore
    public Boolean getSolicitudTINDICARCONTRATANTE2ptpRural() {
        return this.solicitudTINDICARCONTRATANTE2ptpRural;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2ptpRural(Boolean solicitudTINDICARCONTRATANTE2ptpRural) {
        this.solicitudTINDICARCONTRATANTE2ptpRural = solicitudTINDICARCONTRATANTE2ptpRural;
    }

    private void checkSolicitudTINDICARCONTRATANTE2ptpRural() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARCONTRATANTE2ptpRural() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARCONTRATANTE2, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARCONTRATANTE2_SOLICITUDTINDICARCONTRATANTE2PTPRURAL, SolicitudConstants.SERV_ALIAS_TINDICARCONTRATANTE2, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARCONTRATANTE2_SOLICITUDTINDICARCONTRATANTE2PTPRURAL);
        }
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTE2ptpevcDepartamento() {
        return this.solicitudTINDICARCONTRATANTE2ptpevcDepartamento;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2ptpevcDepartamento(String solicitudTINDICARCONTRATANTE2ptpevcDepartamento) {
        this.solicitudTINDICARCONTRATANTE2ptpevcDepartamento = solicitudTINDICARCONTRATANTE2ptpevcDepartamento;
    }

    @JsonIgnore
    public Departamento getSolicitudTINDICARCONTRATANTE2ptpevcDepartamentoInstance() {
        return this.solicitudTINDICARCONTRATANTE2ptpevcDepartamentoInstance;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2ptpevcDepartamentoInstance(Departamento solicitudTINDICARCONTRATANTE2ptpevcDepartamento) {
        this.solicitudTINDICARCONTRATANTE2ptpevcDepartamentoInstance = solicitudTINDICARCONTRATANTE2ptpevcDepartamento;
        this.solicitudTINDICARCONTRATANTE2ptpevcDepartamento = solicitudTINDICARCONTRATANTE2ptpevcDepartamento != null ? solicitudTINDICARCONTRATANTE2ptpevcDepartamento.getOid().toJson() : "";
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTE2ptpevcMunicipio() {
        return this.solicitudTINDICARCONTRATANTE2ptpevcMunicipio;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2ptpevcMunicipio(String solicitudTINDICARCONTRATANTE2ptpevcMunicipio) {
        this.solicitudTINDICARCONTRATANTE2ptpevcMunicipio = solicitudTINDICARCONTRATANTE2ptpevcMunicipio;
    }

    @JsonIgnore
    public Municipio getSolicitudTINDICARCONTRATANTE2ptpevcMunicipioInstance() {
        return this.solicitudTINDICARCONTRATANTE2ptpevcMunicipioInstance;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2ptpevcMunicipioInstance(Municipio solicitudTINDICARCONTRATANTE2ptpevcMunicipio) {
        this.solicitudTINDICARCONTRATANTE2ptpevcMunicipioInstance = solicitudTINDICARCONTRATANTE2ptpevcMunicipio;
        this.solicitudTINDICARCONTRATANTE2ptpevcMunicipio = solicitudTINDICARCONTRATANTE2ptpevcMunicipio != null ? solicitudTINDICARCONTRATANTE2ptpevcMunicipio.getOid().toJson() : "";
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTE2ptpNumIdentificacion() {
        return this.solicitudTINDICARCONTRATANTE2ptpNumIdentificacion;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2ptpNumIdentificacion(String solicitudTINDICARCONTRATANTE2ptpNumIdentificacion) {
        this.solicitudTINDICARCONTRATANTE2ptpNumIdentificacion = solicitudTINDICARCONTRATANTE2ptpNumIdentificacion;
    }

    private void checkSolicitudTINDICARCONTRATANTE2ptpNumIdentificacion() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARCONTRATANTE2ptpNumIdentificacion() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARCONTRATANTE2, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARCONTRATANTE2_SOLICITUDTINDICARCONTRATANTE2PTPNUMIDENTIFICACION, SolicitudConstants.SERV_ALIAS_TINDICARCONTRATANTE2, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARCONTRATANTE2_SOLICITUDTINDICARCONTRATANTE2PTPNUMIDENTIFICACION);
        }
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTE2ptpevcTipoIdentificacion() {
        return this.solicitudTINDICARCONTRATANTE2ptpevcTipoIdentificacion;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2ptpevcTipoIdentificacion(String solicitudTINDICARCONTRATANTE2ptpevcTipoIdentificacion) {
        this.solicitudTINDICARCONTRATANTE2ptpevcTipoIdentificacion = solicitudTINDICARCONTRATANTE2ptpevcTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getSolicitudTINDICARCONTRATANTE2ptpevcTipoIdentificacionInstance() {
        return this.solicitudTINDICARCONTRATANTE2ptpevcTipoIdentificacionInstance;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2ptpevcTipoIdentificacionInstance(TipoIdentificacion solicitudTINDICARCONTRATANTE2ptpevcTipoIdentificacion) {
        this.solicitudTINDICARCONTRATANTE2ptpevcTipoIdentificacionInstance = solicitudTINDICARCONTRATANTE2ptpevcTipoIdentificacion;
        this.solicitudTINDICARCONTRATANTE2ptpevcTipoIdentificacion = solicitudTINDICARCONTRATANTE2ptpevcTipoIdentificacion != null ? solicitudTINDICARCONTRATANTE2ptpevcTipoIdentificacion.getOid().toJson() : "";
    }

    private void checkSolicitudTINDICARCONTRATANTE2ptpevcTipoIdentificacion() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARCONTRATANTE2ptpevcTipoIdentificacionInstance() == null || this.getSolicitudTINDICARCONTRATANTE2ptpevcTipoIdentificacionInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARCONTRATANTE2, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARCONTRATANTE2_SOLICITUDTINDICARCONTRATANTE2PTPEVCTIPOIDENTIFICACION, SolicitudConstants.SERV_ALIAS_TINDICARCONTRATANTE2, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARCONTRATANTE2_SOLICITUDTINDICARCONTRATANTE2PTPEVCTIPOIDENTIFICACION);
        }
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTE2ptpatrRazonSocial() {
        return this.solicitudTINDICARCONTRATANTE2ptpatrRazonSocial;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2ptpatrRazonSocial(String solicitudTINDICARCONTRATANTE2ptpatrRazonSocial) {
        this.solicitudTINDICARCONTRATANTE2ptpatrRazonSocial = solicitudTINDICARCONTRATANTE2ptpatrRazonSocial;
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTE2ptpDCDireccionCompleta() {
        return this.solicitudTINDICARCONTRATANTE2ptpDCDireccionCompleta;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2ptpDCDireccionCompleta(String solicitudTINDICARCONTRATANTE2ptpDCDireccionCompleta) {
        this.solicitudTINDICARCONTRATANTE2ptpDCDireccionCompleta = solicitudTINDICARCONTRATANTE2ptpDCDireccionCompleta;
    }

    private void checkSolicitudTINDICARCONTRATANTE2ptpDCDireccionCompleta() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARCONTRATANTE2ptpDCDireccionCompleta() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARCONTRATANTE2, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARCONTRATANTE2_SOLICITUDTINDICARCONTRATANTE2PTPDCDIRECCIONCOMPLETA, SolicitudConstants.SERV_ALIAS_TINDICARCONTRATANTE2, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARCONTRATANTE2_SOLICITUDTINDICARCONTRATANTE2PTPDCDIRECCIONCOMPLETA);
        }
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTE2ptpDCDepartamento() {
        return this.solicitudTINDICARCONTRATANTE2ptpDCDepartamento;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2ptpDCDepartamento(String solicitudTINDICARCONTRATANTE2ptpDCDepartamento) {
        this.solicitudTINDICARCONTRATANTE2ptpDCDepartamento = solicitudTINDICARCONTRATANTE2ptpDCDepartamento;
    }

    @JsonIgnore
    public Departamento getSolicitudTINDICARCONTRATANTE2ptpDCDepartamentoInstance() {
        return this.solicitudTINDICARCONTRATANTE2ptpDCDepartamentoInstance;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2ptpDCDepartamentoInstance(Departamento solicitudTINDICARCONTRATANTE2ptpDCDepartamento) {
        this.solicitudTINDICARCONTRATANTE2ptpDCDepartamentoInstance = solicitudTINDICARCONTRATANTE2ptpDCDepartamento;
        this.solicitudTINDICARCONTRATANTE2ptpDCDepartamento = solicitudTINDICARCONTRATANTE2ptpDCDepartamento != null ? solicitudTINDICARCONTRATANTE2ptpDCDepartamento.getOid().toJson() : "";
    }

    private void checkSolicitudTINDICARCONTRATANTE2ptpDCDepartamento() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARCONTRATANTE2ptpDCDepartamentoInstance() == null || this.getSolicitudTINDICARCONTRATANTE2ptpDCDepartamentoInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARCONTRATANTE2, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARCONTRATANTE2_SOLICITUDTINDICARCONTRATANTE2PTPDCDEPARTAMENTO, SolicitudConstants.SERV_ALIAS_TINDICARCONTRATANTE2, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARCONTRATANTE2_SOLICITUDTINDICARCONTRATANTE2PTPDCDEPARTAMENTO);
        }
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTE2ptpDCMunicipio() {
        return this.solicitudTINDICARCONTRATANTE2ptpDCMunicipio;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2ptpDCMunicipio(String solicitudTINDICARCONTRATANTE2ptpDCMunicipio) {
        this.solicitudTINDICARCONTRATANTE2ptpDCMunicipio = solicitudTINDICARCONTRATANTE2ptpDCMunicipio;
    }

    @JsonIgnore
    public Municipio getSolicitudTINDICARCONTRATANTE2ptpDCMunicipioInstance() {
        return this.solicitudTINDICARCONTRATANTE2ptpDCMunicipioInstance;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2ptpDCMunicipioInstance(Municipio solicitudTINDICARCONTRATANTE2ptpDCMunicipio) {
        this.solicitudTINDICARCONTRATANTE2ptpDCMunicipioInstance = solicitudTINDICARCONTRATANTE2ptpDCMunicipio;
        this.solicitudTINDICARCONTRATANTE2ptpDCMunicipio = solicitudTINDICARCONTRATANTE2ptpDCMunicipio != null ? solicitudTINDICARCONTRATANTE2ptpDCMunicipio.getOid().toJson() : "";
    }

    private void checkSolicitudTINDICARCONTRATANTE2ptpDCMunicipio() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARCONTRATANTE2ptpDCMunicipioInstance() == null || this.getSolicitudTINDICARCONTRATANTE2ptpDCMunicipioInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARCONTRATANTE2, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARCONTRATANTE2_SOLICITUDTINDICARCONTRATANTE2PTPDCMUNICIPIO, SolicitudConstants.SERV_ALIAS_TINDICARCONTRATANTE2, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARCONTRATANTE2_SOLICITUDTINDICARCONTRATANTE2PTPDCMUNICIPIO);
        }
    }

    @JsonIgnore
    public Boolean getSolicitudTINDICARCONTRATANTE2ptpDCRural() {
        return this.solicitudTINDICARCONTRATANTE2ptpDCRural;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2ptpDCRural(Boolean solicitudTINDICARCONTRATANTE2ptpDCRural) {
        this.solicitudTINDICARCONTRATANTE2ptpDCRural = solicitudTINDICARCONTRATANTE2ptpDCRural;
    }

    private void checkSolicitudTINDICARCONTRATANTE2ptpDCRural() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARCONTRATANTE2ptpDCRural() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARCONTRATANTE2, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARCONTRATANTE2_SOLICITUDTINDICARCONTRATANTE2PTPDCRURAL, SolicitudConstants.SERV_ALIAS_TINDICARCONTRATANTE2, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARCONTRATANTE2_SOLICITUDTINDICARCONTRATANTE2PTPDCRURAL);
        }
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTE2ptpDCTelefonoFijo() {
        return this.solicitudTINDICARCONTRATANTE2ptpDCTelefonoFijo;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2ptpDCTelefonoFijo(String solicitudTINDICARCONTRATANTE2ptpDCTelefonoFijo) {
        this.solicitudTINDICARCONTRATANTE2ptpDCTelefonoFijo = solicitudTINDICARCONTRATANTE2ptpDCTelefonoFijo;
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTE2ptpDCTelefonoCelular() {
        return this.solicitudTINDICARCONTRATANTE2ptpDCTelefonoCelular;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2ptpDCTelefonoCelular(String solicitudTINDICARCONTRATANTE2ptpDCTelefonoCelular) {
        this.solicitudTINDICARCONTRATANTE2ptpDCTelefonoCelular = solicitudTINDICARCONTRATANTE2ptpDCTelefonoCelular;
    }

    @JsonIgnore
    public PaisOid getSolicitudTINDICARCONTRATANTE2ptpPais() {
        return this.solicitudTINDICARCONTRATANTE2ptpPais;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2ptpPais(PaisOid solicitudTINDICARCONTRATANTE2ptpPais) {
        this.solicitudTINDICARCONTRATANTE2ptpPais = solicitudTINDICARCONTRATANTE2ptpPais;
    }

    @JsonIgnore
    public Pais getSolicitudTINDICARCONTRATANTE2ptpPaisInstance() {
        return this.solicitudTINDICARCONTRATANTE2ptpPaisInstance;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2ptpPaisInstance(Pais solicitudTINDICARCONTRATANTE2ptpPais) {
        this.solicitudTINDICARCONTRATANTE2ptpPaisInstance = solicitudTINDICARCONTRATANTE2ptpPais;
        this.solicitudTINDICARCONTRATANTE2ptpPais = solicitudTINDICARCONTRATANTE2ptpPais != null ? solicitudTINDICARCONTRATANTE2ptpPais.getOid() : null;
    }

    @JsonIgnore
    public Long getSolicitudTINDICARCONTRATANTE2ptpCodigoCORE() {
        return this.solicitudTINDICARCONTRATANTE2ptpCodigoCORE;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2ptpCodigoCORE(Long solicitudTINDICARCONTRATANTE2ptpCodigoCORE) {
        this.solicitudTINDICARCONTRATANTE2ptpCodigoCORE = solicitudTINDICARCONTRATANTE2ptpCodigoCORE;
    }

    @JsonIgnore
    public Boolean getSolicitudTINDICARCONTRATANTE2ptTieneEPSSanitas() {
        return this.solicitudTINDICARCONTRATANTE2ptTieneEPSSanitas;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2ptTieneEPSSanitas(Boolean solicitudTINDICARCONTRATANTE2ptTieneEPSSanitas) {
        this.solicitudTINDICARCONTRATANTE2ptTieneEPSSanitas = solicitudTINDICARCONTRATANTE2ptTieneEPSSanitas;
    }

    private void checkSolicitudTINDICARCONTRATANTE2ptTieneEPSSanitas() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARCONTRATANTE2ptTieneEPSSanitas() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARCONTRATANTE2, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARCONTRATANTE2_SOLICITUDTINDICARCONTRATANTE2PTTIENEEPSSANITAS, SolicitudConstants.SERV_ALIAS_TINDICARCONTRATANTE2, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARCONTRATANTE2_SOLICITUDTINDICARCONTRATANTE2PTTIENEEPSSANITAS);
        }
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTE2ptRechazadoAfiliacion() {
        return this.solicitudTINDICARCONTRATANTE2ptRechazadoAfiliacion;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2ptRechazadoAfiliacion(String solicitudTINDICARCONTRATANTE2ptRechazadoAfiliacion) {
        this.solicitudTINDICARCONTRATANTE2ptRechazadoAfiliacion = solicitudTINDICARCONTRATANTE2ptRechazadoAfiliacion;
    }

    @JsonIgnore
    public PaisOid getSolicitudTINDICARCONTRATANTE2pDCPais() {
        return this.solicitudTINDICARCONTRATANTE2pDCPais;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2pDCPais(PaisOid solicitudTINDICARCONTRATANTE2pDCPais) {
        this.solicitudTINDICARCONTRATANTE2pDCPais = solicitudTINDICARCONTRATANTE2pDCPais;
    }

    @JsonIgnore
    public Pais getSolicitudTINDICARCONTRATANTE2pDCPaisInstance() {
        return this.solicitudTINDICARCONTRATANTE2pDCPaisInstance;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2pDCPaisInstance(Pais solicitudTINDICARCONTRATANTE2pDCPais) {
        this.solicitudTINDICARCONTRATANTE2pDCPaisInstance = solicitudTINDICARCONTRATANTE2pDCPais;
        this.solicitudTINDICARCONTRATANTE2pDCPais = solicitudTINDICARCONTRATANTE2pDCPais != null ? solicitudTINDICARCONTRATANTE2pDCPais.getOid() : null;
    }

    @JsonIgnore
    public Boolean getSolicitudTINDICARCONTRATANTE2pTitularBeneficios() {
        return this.solicitudTINDICARCONTRATANTE2pTitularBeneficios;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2pTitularBeneficios(Boolean solicitudTINDICARCONTRATANTE2pTitularBeneficios) {
        this.solicitudTINDICARCONTRATANTE2pTitularBeneficios = solicitudTINDICARCONTRATANTE2pTitularBeneficios;
    }

    private void checkSolicitudTINDICARCONTRATANTE2pTitularBeneficios() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARCONTRATANTE2pTitularBeneficios() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARCONTRATANTE2, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARCONTRATANTE2_SOLICITUDTINDICARCONTRATANTE2PTITULARBENEFICIOS, SolicitudConstants.SERV_ALIAS_TINDICARCONTRATANTE2, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARCONTRATANTE2_SOLICITUDTINDICARCONTRATANTE2PTITULARBENEFICIOS);
        }
    }

    @JsonIgnore
    public Boolean getSolicitudTINDICARCONTRATANTE2ptDiplomatico() {
        return this.solicitudTINDICARCONTRATANTE2ptDiplomatico;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2ptDiplomatico(Boolean solicitudTINDICARCONTRATANTE2ptDiplomatico) {
        this.solicitudTINDICARCONTRATANTE2ptDiplomatico = solicitudTINDICARCONTRATANTE2ptDiplomatico;
    }

    private void checkSolicitudTINDICARCONTRATANTE2ptDiplomatico() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARCONTRATANTE2ptDiplomatico() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARCONTRATANTE2, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARCONTRATANTE2_SOLICITUDTINDICARCONTRATANTE2PTDIPLOMATICO, SolicitudConstants.SERV_ALIAS_TINDICARCONTRATANTE2, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARCONTRATANTE2_SOLICITUDTINDICARCONTRATANTE2PTDIPLOMATICO);
        }
    }

    @JsonIgnore
    public String getSolicitudTINDICARCONTRATANTE2ptDireccionesXClass() {
        return this.solicitudTINDICARCONTRATANTE2ptDireccionesXClass;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2ptDireccionesXClass(String solicitudTINDICARCONTRATANTE2ptDireccionesXClass) {
        this.solicitudTINDICARCONTRATANTE2ptDireccionesXClass = solicitudTINDICARCONTRATANTE2ptDireccionesXClass;
    }

    @JsonIgnore
    public Boolean getSolicitudTINDICARCONTRATANTE2ptReplicarDireccion() {
        return this.solicitudTINDICARCONTRATANTE2ptReplicarDireccion;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2ptReplicarDireccion(Boolean solicitudTINDICARCONTRATANTE2ptReplicarDireccion) {
        this.solicitudTINDICARCONTRATANTE2ptReplicarDireccion = solicitudTINDICARCONTRATANTE2ptReplicarDireccion;
    }

    private void checkSolicitudTINDICARCONTRATANTE2ptReplicarDireccion() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARCONTRATANTE2ptReplicarDireccion() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARCONTRATANTE2, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARCONTRATANTE2_SOLICITUDTINDICARCONTRATANTE2PTREPLICARDIRECCION, SolicitudConstants.SERV_ALIAS_TINDICARCONTRATANTE2, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARCONTRATANTE2_SOLICITUDTINDICARCONTRATANTE2PTREPLICARDIRECCION);
        }
    }

    @JsonIgnore
    public EstadoPersonaOid getSolicitudTINDICARCONTRATANTE2ptEstadoPersona() {
        return this.solicitudTINDICARCONTRATANTE2ptEstadoPersona;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2ptEstadoPersona(EstadoPersonaOid solicitudTINDICARCONTRATANTE2ptEstadoPersona) {
        this.solicitudTINDICARCONTRATANTE2ptEstadoPersona = solicitudTINDICARCONTRATANTE2ptEstadoPersona;
    }

    @JsonIgnore
    public EstadoPersona getSolicitudTINDICARCONTRATANTE2ptEstadoPersonaInstance() {
        return this.solicitudTINDICARCONTRATANTE2ptEstadoPersonaInstance;
    }
    
    public void setSolicitudTINDICARCONTRATANTE2ptEstadoPersonaInstance(EstadoPersona solicitudTINDICARCONTRATANTE2ptEstadoPersona) {
        this.solicitudTINDICARCONTRATANTE2ptEstadoPersonaInstance = solicitudTINDICARCONTRATANTE2ptEstadoPersona;
        this.solicitudTINDICARCONTRATANTE2ptEstadoPersona = solicitudTINDICARCONTRATANTE2ptEstadoPersona != null ? solicitudTINDICARCONTRATANTE2ptEstadoPersona.getOid() : null;
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
