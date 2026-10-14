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

public class TINDICARTITULAR2AUXRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudTINDICARTITULAR2AUXpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudTINDICARTITULAR2AUXpthisSolicitudInstance;

    @JsonProperty("pt_p_agrtipoidentificacion_oid")
    private TipoIdentificacionOid solicitudTINDICARTITULAR2AUXptpagrTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion solicitudTINDICARTITULAR2AUXptpagrTipoIdentificacionInstance;

    @JsonProperty("pt_p_agrdepartamentonacimiento_oid")
    private DepartamentoOid solicitudTINDICARTITULAR2AUXptpagrDepartamentoNacimiento;
    
    @JsonIgnore
    private Departamento solicitudTINDICARTITULAR2AUXptpagrDepartamentoNacimientoInstance;

    @JsonProperty("pt_p_agrmunicipionacimiento_oid")
    private MunicipioOid solicitudTINDICARTITULAR2AUXptpagrMunicipioNacimiento;
    
    @JsonIgnore
    private Municipio solicitudTINDICARTITULAR2AUXptpagrMunicipioNacimientoInstance;

    @JsonProperty("pt_p_agrestadocivil_oid")
    private EstadoCivilOid solicitudTINDICARTITULAR2AUXptpagrEstadoCivil;
    
    @JsonIgnore
    private EstadoCivil solicitudTINDICARTITULAR2AUXptpagrEstadoCivilInstance;

    @JsonProperty("pt_p_atrnumidentificacion")
    private String solicitudTINDICARTITULAR2AUXptpatrNumIdentificacion;

    @JsonProperty("pt_p_atrprimernombre")
    private String solicitudTINDICARTITULAR2AUXptpatrPrimerNombre;

    @JsonProperty("pt_p_atrsegundonombre")
    private String solicitudTINDICARTITULAR2AUXptpatrSegundoNombre;

    @JsonProperty("pt_p_atrprimerapellido")
    private String solicitudTINDICARTITULAR2AUXptpatrPrimerApellido;

    @JsonProperty("pt_p_atrsegundoapellido")
    private String solicitudTINDICARTITULAR2AUXptpatrSegundoApellido;

    @JsonProperty("pt_p_atrfechanacimiento")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date solicitudTINDICARTITULAR2AUXptpatrFechaNacimiento;

    @JsonProperty("pt_p_atrgenero")
    private String solicitudTINDICARTITULAR2AUXptpatrGenero;

    @JsonProperty("pt_p_atrindicadorextranjero")
    private Boolean solicitudTINDICARTITULAR2AUXptpatrIndicadorExtranjero;

    @JsonProperty("pt_p_atrtelefonofijo")
    private String solicitudTINDICARTITULAR2AUXptpatrTelefonoFijo;

    @JsonProperty("pt_p_atrtelefonocelular")
    private String solicitudTINDICARTITULAR2AUXptpatrTelefonoCelular;

    @JsonProperty("pt_p_atrcorreoelectronico")
    private String solicitudTINDICARTITULAR2AUXptpatrCorreoElectronico;

    @JsonProperty("pt_p_agrdepartamento_oid")
    private DepartamentoOid solicitudTINDICARTITULAR2AUXptpagrDepartamento;
    
    @JsonIgnore
    private Departamento solicitudTINDICARTITULAR2AUXptpagrDepartamentoInstance;

    @JsonProperty("pt_p_agrmunicipio_oid")
    private MunicipioOid solicitudTINDICARTITULAR2AUXptpagrMunicipio;
    
    @JsonIgnore
    private Municipio solicitudTINDICARTITULAR2AUXptpagrMunicipioInstance;

    @JsonProperty("pt_p_atrdireccioncompleta")
    private String solicitudTINDICARTITULAR2AUXptpatrDireccionCompleta;

    @JsonProperty("pt_p_atrrural")
    private Boolean solicitudTINDICARTITULAR2AUXptpatrRural;

    @JsonProperty("pt_p_agrpais_oid")
    private PaisOid solicitudTINDICARTITULAR2AUXptpagrPais;
    
    @JsonIgnore
    private Pais solicitudTINDICARTITULAR2AUXptpagrPaisInstance;

    @JsonProperty("pt_p_codigo")
    private Long solicitudTINDICARTITULAR2AUXptpCodigo;

    @JsonProperty("pt_p_tieneepssanitas")
    private Boolean solicitudTINDICARTITULAR2AUXptpTieneEPSSanitas;

    @JsonProperty("pt_p_rechazadoafiliacion")
    private String solicitudTINDICARTITULAR2AUXptpRechazadoAfiliacion;

    @JsonProperty("p_titularbeneficios")
    private Boolean solicitudTINDICARTITULAR2AUXpTitularBeneficios;

    @JsonProperty("pt_p_titularrecuperadoinc")
    private Boolean solicitudTINDICARTITULAR2AUXptpTitularRecuperadoInc;

    @JsonProperty("ptchecktiporegimen")
    private Long solicitudTINDICARTITULAR2AUXptCheckTipoRegimen;

    @JsonProperty("pt_dcdireccioncompleta")
    private String solicitudTINDICARTITULAR2AUXptDCDireccionCompleta;

    @JsonProperty("pt_dcmunicipio_oid")
    private MunicipioOid solicitudTINDICARTITULAR2AUXptDCMunicipio;
    
    @JsonIgnore
    private Municipio solicitudTINDICARTITULAR2AUXptDCMunicipioInstance;

    @JsonProperty("pt_dcdepartamento_oid")
    private DepartamentoOid solicitudTINDICARTITULAR2AUXptDCDepartamento;
    
    @JsonIgnore
    private Departamento solicitudTINDICARTITULAR2AUXptDCDepartamentoInstance;

    @JsonProperty("pt_dcpais_oid")
    private PaisOid solicitudTINDICARTITULAR2AUXptDCPais;
    
    @JsonIgnore
    private Pais solicitudTINDICARTITULAR2AUXptDCPaisInstance;

    @JsonProperty("ptestadopersona_oid")
    private EstadoPersonaOid solicitudTINDICARTITULAR2AUXptEstadoPersona;
    
    @JsonIgnore
    private EstadoPersona solicitudTINDICARTITULAR2AUXptEstadoPersonaInstance;

    @JsonProperty("ptvalidardatos")
    private Boolean solicitudTINDICARTITULAR2AUXptValidarDatos;

    @JsonProperty("pt_pdcrural")
    private Boolean solicitudTINDICARTITULAR2AUXptpDCRural;

    @JsonProperty("ptdctelefonofijo")
    private String solicitudTINDICARTITULAR2AUXptDCTelefonoFijo;

    @JsonProperty("ptdctelefonocelular")
    private String solicitudTINDICARTITULAR2AUXptDCTelefonoCelular;

    @JsonProperty("ptrazonsocial")
    private String solicitudTINDICARTITULAR2AUXptRazonSocial;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudTINDICARTITULAR2AUXpthisSolicitud();
        checkSolicitudTINDICARTITULAR2AUXptpagrTipoIdentificacion();
        checkSolicitudTINDICARTITULAR2AUXptpatrNumIdentificacion();
        checkSolicitudTINDICARTITULAR2AUXpTitularBeneficios();
        checkSolicitudTINDICARTITULAR2AUXptpTitularRecuperadoInc();
        checkSolicitudTINDICARTITULAR2AUXptValidarDatos();
        checkSolicitudTINDICARTITULAR2AUXptpDCRural();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudTINDICARTITULAR2AUXpthisSolicitud() {
        return this.solicitudTINDICARTITULAR2AUXpthisSolicitud;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXpthisSolicitud(SolicitudOid solicitudTINDICARTITULAR2AUXpthisSolicitud) {
        this.solicitudTINDICARTITULAR2AUXpthisSolicitud = solicitudTINDICARTITULAR2AUXpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudTINDICARTITULAR2AUXpthisSolicitudInstance() {
        return this.solicitudTINDICARTITULAR2AUXpthisSolicitudInstance;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXpthisSolicitudInstance(Solicitud solicitudTINDICARTITULAR2AUXpthisSolicitud) {
        this.solicitudTINDICARTITULAR2AUXpthisSolicitudInstance = solicitudTINDICARTITULAR2AUXpthisSolicitud;
        this.solicitudTINDICARTITULAR2AUXpthisSolicitud = solicitudTINDICARTITULAR2AUXpthisSolicitud != null ? solicitudTINDICARTITULAR2AUXpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudTINDICARTITULAR2AUXpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARTITULAR2AUXpthisSolicitudInstance() == null || this.getSolicitudTINDICARTITULAR2AUXpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARTITULAR2AUX, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARTITULAR2AUX_SOLICITUDTINDICARTITULAR2AUXPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_TINDICARTITULAR2AUX, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARTITULAR2AUX_SOLICITUDTINDICARTITULAR2AUXPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public TipoIdentificacionOid getSolicitudTINDICARTITULAR2AUXptpagrTipoIdentificacion() {
        return this.solicitudTINDICARTITULAR2AUXptpagrTipoIdentificacion;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptpagrTipoIdentificacion(TipoIdentificacionOid solicitudTINDICARTITULAR2AUXptpagrTipoIdentificacion) {
        this.solicitudTINDICARTITULAR2AUXptpagrTipoIdentificacion = solicitudTINDICARTITULAR2AUXptpagrTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getSolicitudTINDICARTITULAR2AUXptpagrTipoIdentificacionInstance() {
        return this.solicitudTINDICARTITULAR2AUXptpagrTipoIdentificacionInstance;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptpagrTipoIdentificacionInstance(TipoIdentificacion solicitudTINDICARTITULAR2AUXptpagrTipoIdentificacion) {
        this.solicitudTINDICARTITULAR2AUXptpagrTipoIdentificacionInstance = solicitudTINDICARTITULAR2AUXptpagrTipoIdentificacion;
        this.solicitudTINDICARTITULAR2AUXptpagrTipoIdentificacion = solicitudTINDICARTITULAR2AUXptpagrTipoIdentificacion != null ? solicitudTINDICARTITULAR2AUXptpagrTipoIdentificacion.getOid() : null;
    }

    private void checkSolicitudTINDICARTITULAR2AUXptpagrTipoIdentificacion() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARTITULAR2AUXptpagrTipoIdentificacionInstance() == null || this.getSolicitudTINDICARTITULAR2AUXptpagrTipoIdentificacionInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARTITULAR2AUX, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARTITULAR2AUX_SOLICITUDTINDICARTITULAR2AUXPTPAGRTIPOIDENTIFICACION, SolicitudConstants.SERV_ALIAS_TINDICARTITULAR2AUX, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARTITULAR2AUX_SOLICITUDTINDICARTITULAR2AUXPTPAGRTIPOIDENTIFICACION);
        }
    }

    @JsonIgnore
    public DepartamentoOid getSolicitudTINDICARTITULAR2AUXptpagrDepartamentoNacimiento() {
        return this.solicitudTINDICARTITULAR2AUXptpagrDepartamentoNacimiento;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptpagrDepartamentoNacimiento(DepartamentoOid solicitudTINDICARTITULAR2AUXptpagrDepartamentoNacimiento) {
        this.solicitudTINDICARTITULAR2AUXptpagrDepartamentoNacimiento = solicitudTINDICARTITULAR2AUXptpagrDepartamentoNacimiento;
    }

    @JsonIgnore
    public Departamento getSolicitudTINDICARTITULAR2AUXptpagrDepartamentoNacimientoInstance() {
        return this.solicitudTINDICARTITULAR2AUXptpagrDepartamentoNacimientoInstance;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptpagrDepartamentoNacimientoInstance(Departamento solicitudTINDICARTITULAR2AUXptpagrDepartamentoNacimiento) {
        this.solicitudTINDICARTITULAR2AUXptpagrDepartamentoNacimientoInstance = solicitudTINDICARTITULAR2AUXptpagrDepartamentoNacimiento;
        this.solicitudTINDICARTITULAR2AUXptpagrDepartamentoNacimiento = solicitudTINDICARTITULAR2AUXptpagrDepartamentoNacimiento != null ? solicitudTINDICARTITULAR2AUXptpagrDepartamentoNacimiento.getOid() : null;
    }

    @JsonIgnore
    public MunicipioOid getSolicitudTINDICARTITULAR2AUXptpagrMunicipioNacimiento() {
        return this.solicitudTINDICARTITULAR2AUXptpagrMunicipioNacimiento;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptpagrMunicipioNacimiento(MunicipioOid solicitudTINDICARTITULAR2AUXptpagrMunicipioNacimiento) {
        this.solicitudTINDICARTITULAR2AUXptpagrMunicipioNacimiento = solicitudTINDICARTITULAR2AUXptpagrMunicipioNacimiento;
    }

    @JsonIgnore
    public Municipio getSolicitudTINDICARTITULAR2AUXptpagrMunicipioNacimientoInstance() {
        return this.solicitudTINDICARTITULAR2AUXptpagrMunicipioNacimientoInstance;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptpagrMunicipioNacimientoInstance(Municipio solicitudTINDICARTITULAR2AUXptpagrMunicipioNacimiento) {
        this.solicitudTINDICARTITULAR2AUXptpagrMunicipioNacimientoInstance = solicitudTINDICARTITULAR2AUXptpagrMunicipioNacimiento;
        this.solicitudTINDICARTITULAR2AUXptpagrMunicipioNacimiento = solicitudTINDICARTITULAR2AUXptpagrMunicipioNacimiento != null ? solicitudTINDICARTITULAR2AUXptpagrMunicipioNacimiento.getOid() : null;
    }

    @JsonIgnore
    public EstadoCivilOid getSolicitudTINDICARTITULAR2AUXptpagrEstadoCivil() {
        return this.solicitudTINDICARTITULAR2AUXptpagrEstadoCivil;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptpagrEstadoCivil(EstadoCivilOid solicitudTINDICARTITULAR2AUXptpagrEstadoCivil) {
        this.solicitudTINDICARTITULAR2AUXptpagrEstadoCivil = solicitudTINDICARTITULAR2AUXptpagrEstadoCivil;
    }

    @JsonIgnore
    public EstadoCivil getSolicitudTINDICARTITULAR2AUXptpagrEstadoCivilInstance() {
        return this.solicitudTINDICARTITULAR2AUXptpagrEstadoCivilInstance;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptpagrEstadoCivilInstance(EstadoCivil solicitudTINDICARTITULAR2AUXptpagrEstadoCivil) {
        this.solicitudTINDICARTITULAR2AUXptpagrEstadoCivilInstance = solicitudTINDICARTITULAR2AUXptpagrEstadoCivil;
        this.solicitudTINDICARTITULAR2AUXptpagrEstadoCivil = solicitudTINDICARTITULAR2AUXptpagrEstadoCivil != null ? solicitudTINDICARTITULAR2AUXptpagrEstadoCivil.getOid() : null;
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULAR2AUXptpatrNumIdentificacion() {
        return this.solicitudTINDICARTITULAR2AUXptpatrNumIdentificacion;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptpatrNumIdentificacion(String solicitudTINDICARTITULAR2AUXptpatrNumIdentificacion) {
        this.solicitudTINDICARTITULAR2AUXptpatrNumIdentificacion = solicitudTINDICARTITULAR2AUXptpatrNumIdentificacion;
    }

    private void checkSolicitudTINDICARTITULAR2AUXptpatrNumIdentificacion() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARTITULAR2AUXptpatrNumIdentificacion() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARTITULAR2AUX, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARTITULAR2AUX_SOLICITUDTINDICARTITULAR2AUXPTPATRNUMIDENTIFICACION, SolicitudConstants.SERV_ALIAS_TINDICARTITULAR2AUX, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARTITULAR2AUX_SOLICITUDTINDICARTITULAR2AUXPTPATRNUMIDENTIFICACION);
        }
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULAR2AUXptpatrPrimerNombre() {
        return this.solicitudTINDICARTITULAR2AUXptpatrPrimerNombre;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptpatrPrimerNombre(String solicitudTINDICARTITULAR2AUXptpatrPrimerNombre) {
        this.solicitudTINDICARTITULAR2AUXptpatrPrimerNombre = solicitudTINDICARTITULAR2AUXptpatrPrimerNombre;
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULAR2AUXptpatrSegundoNombre() {
        return this.solicitudTINDICARTITULAR2AUXptpatrSegundoNombre;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptpatrSegundoNombre(String solicitudTINDICARTITULAR2AUXptpatrSegundoNombre) {
        this.solicitudTINDICARTITULAR2AUXptpatrSegundoNombre = solicitudTINDICARTITULAR2AUXptpatrSegundoNombre;
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULAR2AUXptpatrPrimerApellido() {
        return this.solicitudTINDICARTITULAR2AUXptpatrPrimerApellido;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptpatrPrimerApellido(String solicitudTINDICARTITULAR2AUXptpatrPrimerApellido) {
        this.solicitudTINDICARTITULAR2AUXptpatrPrimerApellido = solicitudTINDICARTITULAR2AUXptpatrPrimerApellido;
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULAR2AUXptpatrSegundoApellido() {
        return this.solicitudTINDICARTITULAR2AUXptpatrSegundoApellido;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptpatrSegundoApellido(String solicitudTINDICARTITULAR2AUXptpatrSegundoApellido) {
        this.solicitudTINDICARTITULAR2AUXptpatrSegundoApellido = solicitudTINDICARTITULAR2AUXptpatrSegundoApellido;
    }

    @JsonIgnore
    public Date getSolicitudTINDICARTITULAR2AUXptpatrFechaNacimiento() {
        return this.solicitudTINDICARTITULAR2AUXptpatrFechaNacimiento;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setSolicitudTINDICARTITULAR2AUXptpatrFechaNacimiento(Date solicitudTINDICARTITULAR2AUXptpatrFechaNacimiento) {
        this.solicitudTINDICARTITULAR2AUXptpatrFechaNacimiento = solicitudTINDICARTITULAR2AUXptpatrFechaNacimiento;
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULAR2AUXptpatrGenero() {
        return this.solicitudTINDICARTITULAR2AUXptpatrGenero;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptpatrGenero(String solicitudTINDICARTITULAR2AUXptpatrGenero) {
        this.solicitudTINDICARTITULAR2AUXptpatrGenero = solicitudTINDICARTITULAR2AUXptpatrGenero;
    }

    @JsonIgnore
    public Boolean getSolicitudTINDICARTITULAR2AUXptpatrIndicadorExtranjero() {
        return this.solicitudTINDICARTITULAR2AUXptpatrIndicadorExtranjero;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptpatrIndicadorExtranjero(Boolean solicitudTINDICARTITULAR2AUXptpatrIndicadorExtranjero) {
        this.solicitudTINDICARTITULAR2AUXptpatrIndicadorExtranjero = solicitudTINDICARTITULAR2AUXptpatrIndicadorExtranjero;
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULAR2AUXptpatrTelefonoFijo() {
        return this.solicitudTINDICARTITULAR2AUXptpatrTelefonoFijo;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptpatrTelefonoFijo(String solicitudTINDICARTITULAR2AUXptpatrTelefonoFijo) {
        this.solicitudTINDICARTITULAR2AUXptpatrTelefonoFijo = solicitudTINDICARTITULAR2AUXptpatrTelefonoFijo;
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULAR2AUXptpatrTelefonoCelular() {
        return this.solicitudTINDICARTITULAR2AUXptpatrTelefonoCelular;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptpatrTelefonoCelular(String solicitudTINDICARTITULAR2AUXptpatrTelefonoCelular) {
        this.solicitudTINDICARTITULAR2AUXptpatrTelefonoCelular = solicitudTINDICARTITULAR2AUXptpatrTelefonoCelular;
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULAR2AUXptpatrCorreoElectronico() {
        return this.solicitudTINDICARTITULAR2AUXptpatrCorreoElectronico;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptpatrCorreoElectronico(String solicitudTINDICARTITULAR2AUXptpatrCorreoElectronico) {
        this.solicitudTINDICARTITULAR2AUXptpatrCorreoElectronico = solicitudTINDICARTITULAR2AUXptpatrCorreoElectronico;
    }

    @JsonIgnore
    public DepartamentoOid getSolicitudTINDICARTITULAR2AUXptpagrDepartamento() {
        return this.solicitudTINDICARTITULAR2AUXptpagrDepartamento;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptpagrDepartamento(DepartamentoOid solicitudTINDICARTITULAR2AUXptpagrDepartamento) {
        this.solicitudTINDICARTITULAR2AUXptpagrDepartamento = solicitudTINDICARTITULAR2AUXptpagrDepartamento;
    }

    @JsonIgnore
    public Departamento getSolicitudTINDICARTITULAR2AUXptpagrDepartamentoInstance() {
        return this.solicitudTINDICARTITULAR2AUXptpagrDepartamentoInstance;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptpagrDepartamentoInstance(Departamento solicitudTINDICARTITULAR2AUXptpagrDepartamento) {
        this.solicitudTINDICARTITULAR2AUXptpagrDepartamentoInstance = solicitudTINDICARTITULAR2AUXptpagrDepartamento;
        this.solicitudTINDICARTITULAR2AUXptpagrDepartamento = solicitudTINDICARTITULAR2AUXptpagrDepartamento != null ? solicitudTINDICARTITULAR2AUXptpagrDepartamento.getOid() : null;
    }

    @JsonIgnore
    public MunicipioOid getSolicitudTINDICARTITULAR2AUXptpagrMunicipio() {
        return this.solicitudTINDICARTITULAR2AUXptpagrMunicipio;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptpagrMunicipio(MunicipioOid solicitudTINDICARTITULAR2AUXptpagrMunicipio) {
        this.solicitudTINDICARTITULAR2AUXptpagrMunicipio = solicitudTINDICARTITULAR2AUXptpagrMunicipio;
    }

    @JsonIgnore
    public Municipio getSolicitudTINDICARTITULAR2AUXptpagrMunicipioInstance() {
        return this.solicitudTINDICARTITULAR2AUXptpagrMunicipioInstance;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptpagrMunicipioInstance(Municipio solicitudTINDICARTITULAR2AUXptpagrMunicipio) {
        this.solicitudTINDICARTITULAR2AUXptpagrMunicipioInstance = solicitudTINDICARTITULAR2AUXptpagrMunicipio;
        this.solicitudTINDICARTITULAR2AUXptpagrMunicipio = solicitudTINDICARTITULAR2AUXptpagrMunicipio != null ? solicitudTINDICARTITULAR2AUXptpagrMunicipio.getOid() : null;
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULAR2AUXptpatrDireccionCompleta() {
        return this.solicitudTINDICARTITULAR2AUXptpatrDireccionCompleta;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptpatrDireccionCompleta(String solicitudTINDICARTITULAR2AUXptpatrDireccionCompleta) {
        this.solicitudTINDICARTITULAR2AUXptpatrDireccionCompleta = solicitudTINDICARTITULAR2AUXptpatrDireccionCompleta;
    }

    @JsonIgnore
    public Boolean getSolicitudTINDICARTITULAR2AUXptpatrRural() {
        return this.solicitudTINDICARTITULAR2AUXptpatrRural;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptpatrRural(Boolean solicitudTINDICARTITULAR2AUXptpatrRural) {
        this.solicitudTINDICARTITULAR2AUXptpatrRural = solicitudTINDICARTITULAR2AUXptpatrRural;
    }

    @JsonIgnore
    public PaisOid getSolicitudTINDICARTITULAR2AUXptpagrPais() {
        return this.solicitudTINDICARTITULAR2AUXptpagrPais;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptpagrPais(PaisOid solicitudTINDICARTITULAR2AUXptpagrPais) {
        this.solicitudTINDICARTITULAR2AUXptpagrPais = solicitudTINDICARTITULAR2AUXptpagrPais;
    }

    @JsonIgnore
    public Pais getSolicitudTINDICARTITULAR2AUXptpagrPaisInstance() {
        return this.solicitudTINDICARTITULAR2AUXptpagrPaisInstance;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptpagrPaisInstance(Pais solicitudTINDICARTITULAR2AUXptpagrPais) {
        this.solicitudTINDICARTITULAR2AUXptpagrPaisInstance = solicitudTINDICARTITULAR2AUXptpagrPais;
        this.solicitudTINDICARTITULAR2AUXptpagrPais = solicitudTINDICARTITULAR2AUXptpagrPais != null ? solicitudTINDICARTITULAR2AUXptpagrPais.getOid() : null;
    }

    @JsonIgnore
    public Long getSolicitudTINDICARTITULAR2AUXptpCodigo() {
        return this.solicitudTINDICARTITULAR2AUXptpCodigo;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptpCodigo(Long solicitudTINDICARTITULAR2AUXptpCodigo) {
        this.solicitudTINDICARTITULAR2AUXptpCodigo = solicitudTINDICARTITULAR2AUXptpCodigo;
    }

    @JsonIgnore
    public Boolean getSolicitudTINDICARTITULAR2AUXptpTieneEPSSanitas() {
        return this.solicitudTINDICARTITULAR2AUXptpTieneEPSSanitas;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptpTieneEPSSanitas(Boolean solicitudTINDICARTITULAR2AUXptpTieneEPSSanitas) {
        this.solicitudTINDICARTITULAR2AUXptpTieneEPSSanitas = solicitudTINDICARTITULAR2AUXptpTieneEPSSanitas;
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULAR2AUXptpRechazadoAfiliacion() {
        return this.solicitudTINDICARTITULAR2AUXptpRechazadoAfiliacion;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptpRechazadoAfiliacion(String solicitudTINDICARTITULAR2AUXptpRechazadoAfiliacion) {
        this.solicitudTINDICARTITULAR2AUXptpRechazadoAfiliacion = solicitudTINDICARTITULAR2AUXptpRechazadoAfiliacion;
    }

    @JsonIgnore
    public Boolean getSolicitudTINDICARTITULAR2AUXpTitularBeneficios() {
        return this.solicitudTINDICARTITULAR2AUXpTitularBeneficios;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXpTitularBeneficios(Boolean solicitudTINDICARTITULAR2AUXpTitularBeneficios) {
        this.solicitudTINDICARTITULAR2AUXpTitularBeneficios = solicitudTINDICARTITULAR2AUXpTitularBeneficios;
    }

    private void checkSolicitudTINDICARTITULAR2AUXpTitularBeneficios() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARTITULAR2AUXpTitularBeneficios() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARTITULAR2AUX, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARTITULAR2AUX_SOLICITUDTINDICARTITULAR2AUXPTITULARBENEFICIOS, SolicitudConstants.SERV_ALIAS_TINDICARTITULAR2AUX, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARTITULAR2AUX_SOLICITUDTINDICARTITULAR2AUXPTITULARBENEFICIOS);
        }
    }

    @JsonIgnore
    public Boolean getSolicitudTINDICARTITULAR2AUXptpTitularRecuperadoInc() {
        return this.solicitudTINDICARTITULAR2AUXptpTitularRecuperadoInc;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptpTitularRecuperadoInc(Boolean solicitudTINDICARTITULAR2AUXptpTitularRecuperadoInc) {
        this.solicitudTINDICARTITULAR2AUXptpTitularRecuperadoInc = solicitudTINDICARTITULAR2AUXptpTitularRecuperadoInc;
    }

    private void checkSolicitudTINDICARTITULAR2AUXptpTitularRecuperadoInc() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARTITULAR2AUXptpTitularRecuperadoInc() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARTITULAR2AUX, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARTITULAR2AUX_SOLICITUDTINDICARTITULAR2AUXPTPTITULARRECUPERADOINC, SolicitudConstants.SERV_ALIAS_TINDICARTITULAR2AUX, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARTITULAR2AUX_SOLICITUDTINDICARTITULAR2AUXPTPTITULARRECUPERADOINC);
        }
    }

    @JsonIgnore
    public Long getSolicitudTINDICARTITULAR2AUXptCheckTipoRegimen() {
        return this.solicitudTINDICARTITULAR2AUXptCheckTipoRegimen;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptCheckTipoRegimen(Long solicitudTINDICARTITULAR2AUXptCheckTipoRegimen) {
        this.solicitudTINDICARTITULAR2AUXptCheckTipoRegimen = solicitudTINDICARTITULAR2AUXptCheckTipoRegimen;
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULAR2AUXptDCDireccionCompleta() {
        return this.solicitudTINDICARTITULAR2AUXptDCDireccionCompleta;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptDCDireccionCompleta(String solicitudTINDICARTITULAR2AUXptDCDireccionCompleta) {
        this.solicitudTINDICARTITULAR2AUXptDCDireccionCompleta = solicitudTINDICARTITULAR2AUXptDCDireccionCompleta;
    }

    @JsonIgnore
    public MunicipioOid getSolicitudTINDICARTITULAR2AUXptDCMunicipio() {
        return this.solicitudTINDICARTITULAR2AUXptDCMunicipio;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptDCMunicipio(MunicipioOid solicitudTINDICARTITULAR2AUXptDCMunicipio) {
        this.solicitudTINDICARTITULAR2AUXptDCMunicipio = solicitudTINDICARTITULAR2AUXptDCMunicipio;
    }

    @JsonIgnore
    public Municipio getSolicitudTINDICARTITULAR2AUXptDCMunicipioInstance() {
        return this.solicitudTINDICARTITULAR2AUXptDCMunicipioInstance;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptDCMunicipioInstance(Municipio solicitudTINDICARTITULAR2AUXptDCMunicipio) {
        this.solicitudTINDICARTITULAR2AUXptDCMunicipioInstance = solicitudTINDICARTITULAR2AUXptDCMunicipio;
        this.solicitudTINDICARTITULAR2AUXptDCMunicipio = solicitudTINDICARTITULAR2AUXptDCMunicipio != null ? solicitudTINDICARTITULAR2AUXptDCMunicipio.getOid() : null;
    }

    @JsonIgnore
    public DepartamentoOid getSolicitudTINDICARTITULAR2AUXptDCDepartamento() {
        return this.solicitudTINDICARTITULAR2AUXptDCDepartamento;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptDCDepartamento(DepartamentoOid solicitudTINDICARTITULAR2AUXptDCDepartamento) {
        this.solicitudTINDICARTITULAR2AUXptDCDepartamento = solicitudTINDICARTITULAR2AUXptDCDepartamento;
    }

    @JsonIgnore
    public Departamento getSolicitudTINDICARTITULAR2AUXptDCDepartamentoInstance() {
        return this.solicitudTINDICARTITULAR2AUXptDCDepartamentoInstance;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptDCDepartamentoInstance(Departamento solicitudTINDICARTITULAR2AUXptDCDepartamento) {
        this.solicitudTINDICARTITULAR2AUXptDCDepartamentoInstance = solicitudTINDICARTITULAR2AUXptDCDepartamento;
        this.solicitudTINDICARTITULAR2AUXptDCDepartamento = solicitudTINDICARTITULAR2AUXptDCDepartamento != null ? solicitudTINDICARTITULAR2AUXptDCDepartamento.getOid() : null;
    }

    @JsonIgnore
    public PaisOid getSolicitudTINDICARTITULAR2AUXptDCPais() {
        return this.solicitudTINDICARTITULAR2AUXptDCPais;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptDCPais(PaisOid solicitudTINDICARTITULAR2AUXptDCPais) {
        this.solicitudTINDICARTITULAR2AUXptDCPais = solicitudTINDICARTITULAR2AUXptDCPais;
    }

    @JsonIgnore
    public Pais getSolicitudTINDICARTITULAR2AUXptDCPaisInstance() {
        return this.solicitudTINDICARTITULAR2AUXptDCPaisInstance;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptDCPaisInstance(Pais solicitudTINDICARTITULAR2AUXptDCPais) {
        this.solicitudTINDICARTITULAR2AUXptDCPaisInstance = solicitudTINDICARTITULAR2AUXptDCPais;
        this.solicitudTINDICARTITULAR2AUXptDCPais = solicitudTINDICARTITULAR2AUXptDCPais != null ? solicitudTINDICARTITULAR2AUXptDCPais.getOid() : null;
    }

    @JsonIgnore
    public EstadoPersonaOid getSolicitudTINDICARTITULAR2AUXptEstadoPersona() {
        return this.solicitudTINDICARTITULAR2AUXptEstadoPersona;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptEstadoPersona(EstadoPersonaOid solicitudTINDICARTITULAR2AUXptEstadoPersona) {
        this.solicitudTINDICARTITULAR2AUXptEstadoPersona = solicitudTINDICARTITULAR2AUXptEstadoPersona;
    }

    @JsonIgnore
    public EstadoPersona getSolicitudTINDICARTITULAR2AUXptEstadoPersonaInstance() {
        return this.solicitudTINDICARTITULAR2AUXptEstadoPersonaInstance;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptEstadoPersonaInstance(EstadoPersona solicitudTINDICARTITULAR2AUXptEstadoPersona) {
        this.solicitudTINDICARTITULAR2AUXptEstadoPersonaInstance = solicitudTINDICARTITULAR2AUXptEstadoPersona;
        this.solicitudTINDICARTITULAR2AUXptEstadoPersona = solicitudTINDICARTITULAR2AUXptEstadoPersona != null ? solicitudTINDICARTITULAR2AUXptEstadoPersona.getOid() : null;
    }

    @JsonIgnore
    public Boolean getSolicitudTINDICARTITULAR2AUXptValidarDatos() {
        return this.solicitudTINDICARTITULAR2AUXptValidarDatos;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptValidarDatos(Boolean solicitudTINDICARTITULAR2AUXptValidarDatos) {
        this.solicitudTINDICARTITULAR2AUXptValidarDatos = solicitudTINDICARTITULAR2AUXptValidarDatos;
    }

    private void checkSolicitudTINDICARTITULAR2AUXptValidarDatos() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARTITULAR2AUXptValidarDatos() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARTITULAR2AUX, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARTITULAR2AUX_SOLICITUDTINDICARTITULAR2AUXPTVALIDARDATOS, SolicitudConstants.SERV_ALIAS_TINDICARTITULAR2AUX, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARTITULAR2AUX_SOLICITUDTINDICARTITULAR2AUXPTVALIDARDATOS);
        }
    }

    @JsonIgnore
    public Boolean getSolicitudTINDICARTITULAR2AUXptpDCRural() {
        return this.solicitudTINDICARTITULAR2AUXptpDCRural;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptpDCRural(Boolean solicitudTINDICARTITULAR2AUXptpDCRural) {
        this.solicitudTINDICARTITULAR2AUXptpDCRural = solicitudTINDICARTITULAR2AUXptpDCRural;
    }

    private void checkSolicitudTINDICARTITULAR2AUXptpDCRural() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARTITULAR2AUXptpDCRural() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARTITULAR2AUX, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARTITULAR2AUX_SOLICITUDTINDICARTITULAR2AUXPTPDCRURAL, SolicitudConstants.SERV_ALIAS_TINDICARTITULAR2AUX, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARTITULAR2AUX_SOLICITUDTINDICARTITULAR2AUXPTPDCRURAL);
        }
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULAR2AUXptDCTelefonoFijo() {
        return this.solicitudTINDICARTITULAR2AUXptDCTelefonoFijo;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptDCTelefonoFijo(String solicitudTINDICARTITULAR2AUXptDCTelefonoFijo) {
        this.solicitudTINDICARTITULAR2AUXptDCTelefonoFijo = solicitudTINDICARTITULAR2AUXptDCTelefonoFijo;
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULAR2AUXptDCTelefonoCelular() {
        return this.solicitudTINDICARTITULAR2AUXptDCTelefonoCelular;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptDCTelefonoCelular(String solicitudTINDICARTITULAR2AUXptDCTelefonoCelular) {
        this.solicitudTINDICARTITULAR2AUXptDCTelefonoCelular = solicitudTINDICARTITULAR2AUXptDCTelefonoCelular;
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULAR2AUXptRazonSocial() {
        return this.solicitudTINDICARTITULAR2AUXptRazonSocial;
    }
    
    public void setSolicitudTINDICARTITULAR2AUXptRazonSocial(String solicitudTINDICARTITULAR2AUXptRazonSocial) {
        this.solicitudTINDICARTITULAR2AUXptRazonSocial = solicitudTINDICARTITULAR2AUXptRazonSocial;
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
