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

public class TINDICARTITULARINCLUSIONRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudTINDICARTITULARINCLUSIONpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudTINDICARTITULARINCLUSIONpthisSolicitudInstance;

    @JsonProperty("pt_p_agrtipoidentificacion_oid")
    private TipoIdentificacionOid solicitudTINDICARTITULARINCLUSIONptpagrTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion solicitudTINDICARTITULARINCLUSIONptpagrTipoIdentificacionInstance;

    @JsonProperty("pt_p_agrdepartamentonacimiento_oid")
    private DepartamentoOid solicitudTINDICARTITULARINCLUSIONptpagrDepartamentoNacimiento;
    
    @JsonIgnore
    private Departamento solicitudTINDICARTITULARINCLUSIONptpagrDepartamentoNacimientoInstance;

    @JsonProperty("pt_p_agrmunicipionacimiento_oid")
    private MunicipioOid solicitudTINDICARTITULARINCLUSIONptpagrMunicipioNacimiento;
    
    @JsonIgnore
    private Municipio solicitudTINDICARTITULARINCLUSIONptpagrMunicipioNacimientoInstance;

    @JsonProperty("pt_p_agrestadocivil_oid")
    private EstadoCivilOid solicitudTINDICARTITULARINCLUSIONptpagrEstadoCivil;
    
    @JsonIgnore
    private EstadoCivil solicitudTINDICARTITULARINCLUSIONptpagrEstadoCivilInstance;

    @JsonProperty("pt_p_atrnumidentificacion")
    private String solicitudTINDICARTITULARINCLUSIONptpatrNumIdentificacion;

    @JsonProperty("pt_p_atrprimernombre")
    private String solicitudTINDICARTITULARINCLUSIONptpatrPrimerNombre;

    @JsonProperty("pt_p_atrsegundonombre")
    private String solicitudTINDICARTITULARINCLUSIONptpatrSegundoNombre;

    @JsonProperty("pt_p_atrprimerapellido")
    private String solicitudTINDICARTITULARINCLUSIONptpatrPrimerApellido;

    @JsonProperty("pt_p_atrsegundoapellido")
    private String solicitudTINDICARTITULARINCLUSIONptpatrSegundoApellido;

    @JsonProperty("pt_p_atrfechanacimiento")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date solicitudTINDICARTITULARINCLUSIONptpatrFechaNacimiento;

    @JsonProperty("pt_p_atrgenero")
    private String solicitudTINDICARTITULARINCLUSIONptpatrGenero;

    @JsonProperty("pt_p_atrindicadorextranjero")
    private Boolean solicitudTINDICARTITULARINCLUSIONptpatrIndicadorExtranjero;

    @JsonProperty("pt_p_atrtelefonofijo")
    private String solicitudTINDICARTITULARINCLUSIONptpatrTelefonoFijo;

    @JsonProperty("pt_p_atrtelefonocelular")
    private String solicitudTINDICARTITULARINCLUSIONptpatrTelefonoCelular;

    @JsonProperty("pt_p_atrcorreoelectronico")
    private String solicitudTINDICARTITULARINCLUSIONptpatrCorreoElectronico;

    @JsonProperty("pt_p_agrdepartamento_oid")
    private DepartamentoOid solicitudTINDICARTITULARINCLUSIONptpagrDepartamento;
    
    @JsonIgnore
    private Departamento solicitudTINDICARTITULARINCLUSIONptpagrDepartamentoInstance;

    @JsonProperty("pt_p_agrmunicipio_oid")
    private MunicipioOid solicitudTINDICARTITULARINCLUSIONptpagrMunicipio;
    
    @JsonIgnore
    private Municipio solicitudTINDICARTITULARINCLUSIONptpagrMunicipioInstance;

    @JsonProperty("pt_p_atrdireccioncompleta")
    private String solicitudTINDICARTITULARINCLUSIONptpatrDireccionCompleta;

    @JsonProperty("pt_p_atrrural")
    private Boolean solicitudTINDICARTITULARINCLUSIONptpatrRural;

    @JsonProperty("pt_p_agrpais_oid")
    private PaisOid solicitudTINDICARTITULARINCLUSIONptpagrPais;
    
    @JsonIgnore
    private Pais solicitudTINDICARTITULARINCLUSIONptpagrPaisInstance;

    @JsonProperty("pt_p_codigo")
    private Long solicitudTINDICARTITULARINCLUSIONptpCodigo;

    @JsonProperty("pt_p_tieneepssanitas")
    private Boolean solicitudTINDICARTITULARINCLUSIONptpTieneEPSSanitas;

    @JsonProperty("pt_p_rechazadoafiliacion")
    private String solicitudTINDICARTITULARINCLUSIONptpRechazadoAfiliacion;

    @JsonProperty("p_titularbeneficios")
    private Boolean solicitudTINDICARTITULARINCLUSIONpTitularBeneficios;

    @JsonProperty("pttiporegimen")
    private String solicitudTINDICARTITULARINCLUSIONptTipoRegimen;

    @JsonProperty("pt_dcdireccioncompleta")
    private String solicitudTINDICARTITULARINCLUSIONptDCDireccionCompleta;

    @JsonProperty("pt_dcmunicipio_oid")
    private MunicipioOid solicitudTINDICARTITULARINCLUSIONptDCMunicipio;
    
    @JsonIgnore
    private Municipio solicitudTINDICARTITULARINCLUSIONptDCMunicipioInstance;

    @JsonProperty("pt_dcdepartamento_oid")
    private DepartamentoOid solicitudTINDICARTITULARINCLUSIONptDCDepartamento;
    
    @JsonIgnore
    private Departamento solicitudTINDICARTITULARINCLUSIONptDCDepartamentoInstance;

    @JsonProperty("pt_dcpais_oid")
    private PaisOid solicitudTINDICARTITULARINCLUSIONptDCPais;
    
    @JsonIgnore
    private Pais solicitudTINDICARTITULARINCLUSIONptDCPaisInstance;

    @JsonProperty("ptestadopersona_oid")
    private EstadoPersonaOid solicitudTINDICARTITULARINCLUSIONptEstadoPersona;
    
    @JsonIgnore
    private EstadoPersona solicitudTINDICARTITULARINCLUSIONptEstadoPersonaInstance;

    @JsonProperty("pt_pdcrural")
    private Boolean solicitudTINDICARTITULARINCLUSIONptpDCRural;

    @JsonProperty("ptdctelefonofijo")
    private String solicitudTINDICARTITULARINCLUSIONptDCTelefonoFijo;

    @JsonProperty("ptdctelefonocelular")
    private String solicitudTINDICARTITULARINCLUSIONptDCTelefonoCelular;

    @JsonProperty("ptrazonsocial")
    private String solicitudTINDICARTITULARINCLUSIONptRazonSocial;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudTINDICARTITULARINCLUSIONpthisSolicitud();
        checkSolicitudTINDICARTITULARINCLUSIONptpagrTipoIdentificacion();
        checkSolicitudTINDICARTITULARINCLUSIONptpatrNumIdentificacion();
        checkSolicitudTINDICARTITULARINCLUSIONpTitularBeneficios();
        checkSolicitudTINDICARTITULARINCLUSIONptpDCRural();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudTINDICARTITULARINCLUSIONpthisSolicitud() {
        return this.solicitudTINDICARTITULARINCLUSIONpthisSolicitud;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONpthisSolicitud(SolicitudOid solicitudTINDICARTITULARINCLUSIONpthisSolicitud) {
        this.solicitudTINDICARTITULARINCLUSIONpthisSolicitud = solicitudTINDICARTITULARINCLUSIONpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudTINDICARTITULARINCLUSIONpthisSolicitudInstance() {
        return this.solicitudTINDICARTITULARINCLUSIONpthisSolicitudInstance;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONpthisSolicitudInstance(Solicitud solicitudTINDICARTITULARINCLUSIONpthisSolicitud) {
        this.solicitudTINDICARTITULARINCLUSIONpthisSolicitudInstance = solicitudTINDICARTITULARINCLUSIONpthisSolicitud;
        this.solicitudTINDICARTITULARINCLUSIONpthisSolicitud = solicitudTINDICARTITULARINCLUSIONpthisSolicitud != null ? solicitudTINDICARTITULARINCLUSIONpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudTINDICARTITULARINCLUSIONpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARTITULARINCLUSIONpthisSolicitudInstance() == null || this.getSolicitudTINDICARTITULARINCLUSIONpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARTITULARINCLUSION, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARTITULARINCLUSION_SOLICITUDTINDICARTITULARINCLUSIONPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_TINDICARTITULARINCLUSION, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARTITULARINCLUSION_SOLICITUDTINDICARTITULARINCLUSIONPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public TipoIdentificacionOid getSolicitudTINDICARTITULARINCLUSIONptpagrTipoIdentificacion() {
        return this.solicitudTINDICARTITULARINCLUSIONptpagrTipoIdentificacion;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptpagrTipoIdentificacion(TipoIdentificacionOid solicitudTINDICARTITULARINCLUSIONptpagrTipoIdentificacion) {
        this.solicitudTINDICARTITULARINCLUSIONptpagrTipoIdentificacion = solicitudTINDICARTITULARINCLUSIONptpagrTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getSolicitudTINDICARTITULARINCLUSIONptpagrTipoIdentificacionInstance() {
        return this.solicitudTINDICARTITULARINCLUSIONptpagrTipoIdentificacionInstance;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptpagrTipoIdentificacionInstance(TipoIdentificacion solicitudTINDICARTITULARINCLUSIONptpagrTipoIdentificacion) {
        this.solicitudTINDICARTITULARINCLUSIONptpagrTipoIdentificacionInstance = solicitudTINDICARTITULARINCLUSIONptpagrTipoIdentificacion;
        this.solicitudTINDICARTITULARINCLUSIONptpagrTipoIdentificacion = solicitudTINDICARTITULARINCLUSIONptpagrTipoIdentificacion != null ? solicitudTINDICARTITULARINCLUSIONptpagrTipoIdentificacion.getOid() : null;
    }

    private void checkSolicitudTINDICARTITULARINCLUSIONptpagrTipoIdentificacion() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARTITULARINCLUSIONptpagrTipoIdentificacionInstance() == null || this.getSolicitudTINDICARTITULARINCLUSIONptpagrTipoIdentificacionInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARTITULARINCLUSION, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARTITULARINCLUSION_SOLICITUDTINDICARTITULARINCLUSIONPTPAGRTIPOIDENTIFICACION, SolicitudConstants.SERV_ALIAS_TINDICARTITULARINCLUSION, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARTITULARINCLUSION_SOLICITUDTINDICARTITULARINCLUSIONPTPAGRTIPOIDENTIFICACION);
        }
    }

    @JsonIgnore
    public DepartamentoOid getSolicitudTINDICARTITULARINCLUSIONptpagrDepartamentoNacimiento() {
        return this.solicitudTINDICARTITULARINCLUSIONptpagrDepartamentoNacimiento;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptpagrDepartamentoNacimiento(DepartamentoOid solicitudTINDICARTITULARINCLUSIONptpagrDepartamentoNacimiento) {
        this.solicitudTINDICARTITULARINCLUSIONptpagrDepartamentoNacimiento = solicitudTINDICARTITULARINCLUSIONptpagrDepartamentoNacimiento;
    }

    @JsonIgnore
    public Departamento getSolicitudTINDICARTITULARINCLUSIONptpagrDepartamentoNacimientoInstance() {
        return this.solicitudTINDICARTITULARINCLUSIONptpagrDepartamentoNacimientoInstance;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptpagrDepartamentoNacimientoInstance(Departamento solicitudTINDICARTITULARINCLUSIONptpagrDepartamentoNacimiento) {
        this.solicitudTINDICARTITULARINCLUSIONptpagrDepartamentoNacimientoInstance = solicitudTINDICARTITULARINCLUSIONptpagrDepartamentoNacimiento;
        this.solicitudTINDICARTITULARINCLUSIONptpagrDepartamentoNacimiento = solicitudTINDICARTITULARINCLUSIONptpagrDepartamentoNacimiento != null ? solicitudTINDICARTITULARINCLUSIONptpagrDepartamentoNacimiento.getOid() : null;
    }

    @JsonIgnore
    public MunicipioOid getSolicitudTINDICARTITULARINCLUSIONptpagrMunicipioNacimiento() {
        return this.solicitudTINDICARTITULARINCLUSIONptpagrMunicipioNacimiento;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptpagrMunicipioNacimiento(MunicipioOid solicitudTINDICARTITULARINCLUSIONptpagrMunicipioNacimiento) {
        this.solicitudTINDICARTITULARINCLUSIONptpagrMunicipioNacimiento = solicitudTINDICARTITULARINCLUSIONptpagrMunicipioNacimiento;
    }

    @JsonIgnore
    public Municipio getSolicitudTINDICARTITULARINCLUSIONptpagrMunicipioNacimientoInstance() {
        return this.solicitudTINDICARTITULARINCLUSIONptpagrMunicipioNacimientoInstance;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptpagrMunicipioNacimientoInstance(Municipio solicitudTINDICARTITULARINCLUSIONptpagrMunicipioNacimiento) {
        this.solicitudTINDICARTITULARINCLUSIONptpagrMunicipioNacimientoInstance = solicitudTINDICARTITULARINCLUSIONptpagrMunicipioNacimiento;
        this.solicitudTINDICARTITULARINCLUSIONptpagrMunicipioNacimiento = solicitudTINDICARTITULARINCLUSIONptpagrMunicipioNacimiento != null ? solicitudTINDICARTITULARINCLUSIONptpagrMunicipioNacimiento.getOid() : null;
    }

    @JsonIgnore
    public EstadoCivilOid getSolicitudTINDICARTITULARINCLUSIONptpagrEstadoCivil() {
        return this.solicitudTINDICARTITULARINCLUSIONptpagrEstadoCivil;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptpagrEstadoCivil(EstadoCivilOid solicitudTINDICARTITULARINCLUSIONptpagrEstadoCivil) {
        this.solicitudTINDICARTITULARINCLUSIONptpagrEstadoCivil = solicitudTINDICARTITULARINCLUSIONptpagrEstadoCivil;
    }

    @JsonIgnore
    public EstadoCivil getSolicitudTINDICARTITULARINCLUSIONptpagrEstadoCivilInstance() {
        return this.solicitudTINDICARTITULARINCLUSIONptpagrEstadoCivilInstance;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptpagrEstadoCivilInstance(EstadoCivil solicitudTINDICARTITULARINCLUSIONptpagrEstadoCivil) {
        this.solicitudTINDICARTITULARINCLUSIONptpagrEstadoCivilInstance = solicitudTINDICARTITULARINCLUSIONptpagrEstadoCivil;
        this.solicitudTINDICARTITULARINCLUSIONptpagrEstadoCivil = solicitudTINDICARTITULARINCLUSIONptpagrEstadoCivil != null ? solicitudTINDICARTITULARINCLUSIONptpagrEstadoCivil.getOid() : null;
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULARINCLUSIONptpatrNumIdentificacion() {
        return this.solicitudTINDICARTITULARINCLUSIONptpatrNumIdentificacion;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptpatrNumIdentificacion(String solicitudTINDICARTITULARINCLUSIONptpatrNumIdentificacion) {
        this.solicitudTINDICARTITULARINCLUSIONptpatrNumIdentificacion = solicitudTINDICARTITULARINCLUSIONptpatrNumIdentificacion;
    }

    private void checkSolicitudTINDICARTITULARINCLUSIONptpatrNumIdentificacion() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARTITULARINCLUSIONptpatrNumIdentificacion() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARTITULARINCLUSION, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARTITULARINCLUSION_SOLICITUDTINDICARTITULARINCLUSIONPTPATRNUMIDENTIFICACION, SolicitudConstants.SERV_ALIAS_TINDICARTITULARINCLUSION, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARTITULARINCLUSION_SOLICITUDTINDICARTITULARINCLUSIONPTPATRNUMIDENTIFICACION);
        }
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULARINCLUSIONptpatrPrimerNombre() {
        return this.solicitudTINDICARTITULARINCLUSIONptpatrPrimerNombre;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptpatrPrimerNombre(String solicitudTINDICARTITULARINCLUSIONptpatrPrimerNombre) {
        this.solicitudTINDICARTITULARINCLUSIONptpatrPrimerNombre = solicitudTINDICARTITULARINCLUSIONptpatrPrimerNombre;
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULARINCLUSIONptpatrSegundoNombre() {
        return this.solicitudTINDICARTITULARINCLUSIONptpatrSegundoNombre;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptpatrSegundoNombre(String solicitudTINDICARTITULARINCLUSIONptpatrSegundoNombre) {
        this.solicitudTINDICARTITULARINCLUSIONptpatrSegundoNombre = solicitudTINDICARTITULARINCLUSIONptpatrSegundoNombre;
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULARINCLUSIONptpatrPrimerApellido() {
        return this.solicitudTINDICARTITULARINCLUSIONptpatrPrimerApellido;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptpatrPrimerApellido(String solicitudTINDICARTITULARINCLUSIONptpatrPrimerApellido) {
        this.solicitudTINDICARTITULARINCLUSIONptpatrPrimerApellido = solicitudTINDICARTITULARINCLUSIONptpatrPrimerApellido;
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULARINCLUSIONptpatrSegundoApellido() {
        return this.solicitudTINDICARTITULARINCLUSIONptpatrSegundoApellido;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptpatrSegundoApellido(String solicitudTINDICARTITULARINCLUSIONptpatrSegundoApellido) {
        this.solicitudTINDICARTITULARINCLUSIONptpatrSegundoApellido = solicitudTINDICARTITULARINCLUSIONptpatrSegundoApellido;
    }

    @JsonIgnore
    public Date getSolicitudTINDICARTITULARINCLUSIONptpatrFechaNacimiento() {
        return this.solicitudTINDICARTITULARINCLUSIONptpatrFechaNacimiento;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setSolicitudTINDICARTITULARINCLUSIONptpatrFechaNacimiento(Date solicitudTINDICARTITULARINCLUSIONptpatrFechaNacimiento) {
        this.solicitudTINDICARTITULARINCLUSIONptpatrFechaNacimiento = solicitudTINDICARTITULARINCLUSIONptpatrFechaNacimiento;
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULARINCLUSIONptpatrGenero() {
        return this.solicitudTINDICARTITULARINCLUSIONptpatrGenero;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptpatrGenero(String solicitudTINDICARTITULARINCLUSIONptpatrGenero) {
        this.solicitudTINDICARTITULARINCLUSIONptpatrGenero = solicitudTINDICARTITULARINCLUSIONptpatrGenero;
    }

    @JsonIgnore
    public Boolean getSolicitudTINDICARTITULARINCLUSIONptpatrIndicadorExtranjero() {
        return this.solicitudTINDICARTITULARINCLUSIONptpatrIndicadorExtranjero;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptpatrIndicadorExtranjero(Boolean solicitudTINDICARTITULARINCLUSIONptpatrIndicadorExtranjero) {
        this.solicitudTINDICARTITULARINCLUSIONptpatrIndicadorExtranjero = solicitudTINDICARTITULARINCLUSIONptpatrIndicadorExtranjero;
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULARINCLUSIONptpatrTelefonoFijo() {
        return this.solicitudTINDICARTITULARINCLUSIONptpatrTelefonoFijo;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptpatrTelefonoFijo(String solicitudTINDICARTITULARINCLUSIONptpatrTelefonoFijo) {
        this.solicitudTINDICARTITULARINCLUSIONptpatrTelefonoFijo = solicitudTINDICARTITULARINCLUSIONptpatrTelefonoFijo;
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULARINCLUSIONptpatrTelefonoCelular() {
        return this.solicitudTINDICARTITULARINCLUSIONptpatrTelefonoCelular;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptpatrTelefonoCelular(String solicitudTINDICARTITULARINCLUSIONptpatrTelefonoCelular) {
        this.solicitudTINDICARTITULARINCLUSIONptpatrTelefonoCelular = solicitudTINDICARTITULARINCLUSIONptpatrTelefonoCelular;
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULARINCLUSIONptpatrCorreoElectronico() {
        return this.solicitudTINDICARTITULARINCLUSIONptpatrCorreoElectronico;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptpatrCorreoElectronico(String solicitudTINDICARTITULARINCLUSIONptpatrCorreoElectronico) {
        this.solicitudTINDICARTITULARINCLUSIONptpatrCorreoElectronico = solicitudTINDICARTITULARINCLUSIONptpatrCorreoElectronico;
    }

    @JsonIgnore
    public DepartamentoOid getSolicitudTINDICARTITULARINCLUSIONptpagrDepartamento() {
        return this.solicitudTINDICARTITULARINCLUSIONptpagrDepartamento;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptpagrDepartamento(DepartamentoOid solicitudTINDICARTITULARINCLUSIONptpagrDepartamento) {
        this.solicitudTINDICARTITULARINCLUSIONptpagrDepartamento = solicitudTINDICARTITULARINCLUSIONptpagrDepartamento;
    }

    @JsonIgnore
    public Departamento getSolicitudTINDICARTITULARINCLUSIONptpagrDepartamentoInstance() {
        return this.solicitudTINDICARTITULARINCLUSIONptpagrDepartamentoInstance;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptpagrDepartamentoInstance(Departamento solicitudTINDICARTITULARINCLUSIONptpagrDepartamento) {
        this.solicitudTINDICARTITULARINCLUSIONptpagrDepartamentoInstance = solicitudTINDICARTITULARINCLUSIONptpagrDepartamento;
        this.solicitudTINDICARTITULARINCLUSIONptpagrDepartamento = solicitudTINDICARTITULARINCLUSIONptpagrDepartamento != null ? solicitudTINDICARTITULARINCLUSIONptpagrDepartamento.getOid() : null;
    }

    @JsonIgnore
    public MunicipioOid getSolicitudTINDICARTITULARINCLUSIONptpagrMunicipio() {
        return this.solicitudTINDICARTITULARINCLUSIONptpagrMunicipio;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptpagrMunicipio(MunicipioOid solicitudTINDICARTITULARINCLUSIONptpagrMunicipio) {
        this.solicitudTINDICARTITULARINCLUSIONptpagrMunicipio = solicitudTINDICARTITULARINCLUSIONptpagrMunicipio;
    }

    @JsonIgnore
    public Municipio getSolicitudTINDICARTITULARINCLUSIONptpagrMunicipioInstance() {
        return this.solicitudTINDICARTITULARINCLUSIONptpagrMunicipioInstance;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptpagrMunicipioInstance(Municipio solicitudTINDICARTITULARINCLUSIONptpagrMunicipio) {
        this.solicitudTINDICARTITULARINCLUSIONptpagrMunicipioInstance = solicitudTINDICARTITULARINCLUSIONptpagrMunicipio;
        this.solicitudTINDICARTITULARINCLUSIONptpagrMunicipio = solicitudTINDICARTITULARINCLUSIONptpagrMunicipio != null ? solicitudTINDICARTITULARINCLUSIONptpagrMunicipio.getOid() : null;
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULARINCLUSIONptpatrDireccionCompleta() {
        return this.solicitudTINDICARTITULARINCLUSIONptpatrDireccionCompleta;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptpatrDireccionCompleta(String solicitudTINDICARTITULARINCLUSIONptpatrDireccionCompleta) {
        this.solicitudTINDICARTITULARINCLUSIONptpatrDireccionCompleta = solicitudTINDICARTITULARINCLUSIONptpatrDireccionCompleta;
    }

    @JsonIgnore
    public Boolean getSolicitudTINDICARTITULARINCLUSIONptpatrRural() {
        return this.solicitudTINDICARTITULARINCLUSIONptpatrRural;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptpatrRural(Boolean solicitudTINDICARTITULARINCLUSIONptpatrRural) {
        this.solicitudTINDICARTITULARINCLUSIONptpatrRural = solicitudTINDICARTITULARINCLUSIONptpatrRural;
    }

    @JsonIgnore
    public PaisOid getSolicitudTINDICARTITULARINCLUSIONptpagrPais() {
        return this.solicitudTINDICARTITULARINCLUSIONptpagrPais;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptpagrPais(PaisOid solicitudTINDICARTITULARINCLUSIONptpagrPais) {
        this.solicitudTINDICARTITULARINCLUSIONptpagrPais = solicitudTINDICARTITULARINCLUSIONptpagrPais;
    }

    @JsonIgnore
    public Pais getSolicitudTINDICARTITULARINCLUSIONptpagrPaisInstance() {
        return this.solicitudTINDICARTITULARINCLUSIONptpagrPaisInstance;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptpagrPaisInstance(Pais solicitudTINDICARTITULARINCLUSIONptpagrPais) {
        this.solicitudTINDICARTITULARINCLUSIONptpagrPaisInstance = solicitudTINDICARTITULARINCLUSIONptpagrPais;
        this.solicitudTINDICARTITULARINCLUSIONptpagrPais = solicitudTINDICARTITULARINCLUSIONptpagrPais != null ? solicitudTINDICARTITULARINCLUSIONptpagrPais.getOid() : null;
    }

    @JsonIgnore
    public Long getSolicitudTINDICARTITULARINCLUSIONptpCodigo() {
        return this.solicitudTINDICARTITULARINCLUSIONptpCodigo;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptpCodigo(Long solicitudTINDICARTITULARINCLUSIONptpCodigo) {
        this.solicitudTINDICARTITULARINCLUSIONptpCodigo = solicitudTINDICARTITULARINCLUSIONptpCodigo;
    }

    @JsonIgnore
    public Boolean getSolicitudTINDICARTITULARINCLUSIONptpTieneEPSSanitas() {
        return this.solicitudTINDICARTITULARINCLUSIONptpTieneEPSSanitas;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptpTieneEPSSanitas(Boolean solicitudTINDICARTITULARINCLUSIONptpTieneEPSSanitas) {
        this.solicitudTINDICARTITULARINCLUSIONptpTieneEPSSanitas = solicitudTINDICARTITULARINCLUSIONptpTieneEPSSanitas;
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULARINCLUSIONptpRechazadoAfiliacion() {
        return this.solicitudTINDICARTITULARINCLUSIONptpRechazadoAfiliacion;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptpRechazadoAfiliacion(String solicitudTINDICARTITULARINCLUSIONptpRechazadoAfiliacion) {
        this.solicitudTINDICARTITULARINCLUSIONptpRechazadoAfiliacion = solicitudTINDICARTITULARINCLUSIONptpRechazadoAfiliacion;
    }

    @JsonIgnore
    public Boolean getSolicitudTINDICARTITULARINCLUSIONpTitularBeneficios() {
        return this.solicitudTINDICARTITULARINCLUSIONpTitularBeneficios;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONpTitularBeneficios(Boolean solicitudTINDICARTITULARINCLUSIONpTitularBeneficios) {
        this.solicitudTINDICARTITULARINCLUSIONpTitularBeneficios = solicitudTINDICARTITULARINCLUSIONpTitularBeneficios;
    }

    private void checkSolicitudTINDICARTITULARINCLUSIONpTitularBeneficios() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARTITULARINCLUSIONpTitularBeneficios() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARTITULARINCLUSION, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARTITULARINCLUSION_SOLICITUDTINDICARTITULARINCLUSIONPTITULARBENEFICIOS, SolicitudConstants.SERV_ALIAS_TINDICARTITULARINCLUSION, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARTITULARINCLUSION_SOLICITUDTINDICARTITULARINCLUSIONPTITULARBENEFICIOS);
        }
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULARINCLUSIONptTipoRegimen() {
        return this.solicitudTINDICARTITULARINCLUSIONptTipoRegimen;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptTipoRegimen(String solicitudTINDICARTITULARINCLUSIONptTipoRegimen) {
        this.solicitudTINDICARTITULARINCLUSIONptTipoRegimen = solicitudTINDICARTITULARINCLUSIONptTipoRegimen;
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULARINCLUSIONptDCDireccionCompleta() {
        return this.solicitudTINDICARTITULARINCLUSIONptDCDireccionCompleta;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptDCDireccionCompleta(String solicitudTINDICARTITULARINCLUSIONptDCDireccionCompleta) {
        this.solicitudTINDICARTITULARINCLUSIONptDCDireccionCompleta = solicitudTINDICARTITULARINCLUSIONptDCDireccionCompleta;
    }

    @JsonIgnore
    public MunicipioOid getSolicitudTINDICARTITULARINCLUSIONptDCMunicipio() {
        return this.solicitudTINDICARTITULARINCLUSIONptDCMunicipio;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptDCMunicipio(MunicipioOid solicitudTINDICARTITULARINCLUSIONptDCMunicipio) {
        this.solicitudTINDICARTITULARINCLUSIONptDCMunicipio = solicitudTINDICARTITULARINCLUSIONptDCMunicipio;
    }

    @JsonIgnore
    public Municipio getSolicitudTINDICARTITULARINCLUSIONptDCMunicipioInstance() {
        return this.solicitudTINDICARTITULARINCLUSIONptDCMunicipioInstance;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptDCMunicipioInstance(Municipio solicitudTINDICARTITULARINCLUSIONptDCMunicipio) {
        this.solicitudTINDICARTITULARINCLUSIONptDCMunicipioInstance = solicitudTINDICARTITULARINCLUSIONptDCMunicipio;
        this.solicitudTINDICARTITULARINCLUSIONptDCMunicipio = solicitudTINDICARTITULARINCLUSIONptDCMunicipio != null ? solicitudTINDICARTITULARINCLUSIONptDCMunicipio.getOid() : null;
    }

    @JsonIgnore
    public DepartamentoOid getSolicitudTINDICARTITULARINCLUSIONptDCDepartamento() {
        return this.solicitudTINDICARTITULARINCLUSIONptDCDepartamento;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptDCDepartamento(DepartamentoOid solicitudTINDICARTITULARINCLUSIONptDCDepartamento) {
        this.solicitudTINDICARTITULARINCLUSIONptDCDepartamento = solicitudTINDICARTITULARINCLUSIONptDCDepartamento;
    }

    @JsonIgnore
    public Departamento getSolicitudTINDICARTITULARINCLUSIONptDCDepartamentoInstance() {
        return this.solicitudTINDICARTITULARINCLUSIONptDCDepartamentoInstance;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptDCDepartamentoInstance(Departamento solicitudTINDICARTITULARINCLUSIONptDCDepartamento) {
        this.solicitudTINDICARTITULARINCLUSIONptDCDepartamentoInstance = solicitudTINDICARTITULARINCLUSIONptDCDepartamento;
        this.solicitudTINDICARTITULARINCLUSIONptDCDepartamento = solicitudTINDICARTITULARINCLUSIONptDCDepartamento != null ? solicitudTINDICARTITULARINCLUSIONptDCDepartamento.getOid() : null;
    }

    @JsonIgnore
    public PaisOid getSolicitudTINDICARTITULARINCLUSIONptDCPais() {
        return this.solicitudTINDICARTITULARINCLUSIONptDCPais;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptDCPais(PaisOid solicitudTINDICARTITULARINCLUSIONptDCPais) {
        this.solicitudTINDICARTITULARINCLUSIONptDCPais = solicitudTINDICARTITULARINCLUSIONptDCPais;
    }

    @JsonIgnore
    public Pais getSolicitudTINDICARTITULARINCLUSIONptDCPaisInstance() {
        return this.solicitudTINDICARTITULARINCLUSIONptDCPaisInstance;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptDCPaisInstance(Pais solicitudTINDICARTITULARINCLUSIONptDCPais) {
        this.solicitudTINDICARTITULARINCLUSIONptDCPaisInstance = solicitudTINDICARTITULARINCLUSIONptDCPais;
        this.solicitudTINDICARTITULARINCLUSIONptDCPais = solicitudTINDICARTITULARINCLUSIONptDCPais != null ? solicitudTINDICARTITULARINCLUSIONptDCPais.getOid() : null;
    }

    @JsonIgnore
    public EstadoPersonaOid getSolicitudTINDICARTITULARINCLUSIONptEstadoPersona() {
        return this.solicitudTINDICARTITULARINCLUSIONptEstadoPersona;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptEstadoPersona(EstadoPersonaOid solicitudTINDICARTITULARINCLUSIONptEstadoPersona) {
        this.solicitudTINDICARTITULARINCLUSIONptEstadoPersona = solicitudTINDICARTITULARINCLUSIONptEstadoPersona;
    }

    @JsonIgnore
    public EstadoPersona getSolicitudTINDICARTITULARINCLUSIONptEstadoPersonaInstance() {
        return this.solicitudTINDICARTITULARINCLUSIONptEstadoPersonaInstance;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptEstadoPersonaInstance(EstadoPersona solicitudTINDICARTITULARINCLUSIONptEstadoPersona) {
        this.solicitudTINDICARTITULARINCLUSIONptEstadoPersonaInstance = solicitudTINDICARTITULARINCLUSIONptEstadoPersona;
        this.solicitudTINDICARTITULARINCLUSIONptEstadoPersona = solicitudTINDICARTITULARINCLUSIONptEstadoPersona != null ? solicitudTINDICARTITULARINCLUSIONptEstadoPersona.getOid() : null;
    }

    @JsonIgnore
    public Boolean getSolicitudTINDICARTITULARINCLUSIONptpDCRural() {
        return this.solicitudTINDICARTITULARINCLUSIONptpDCRural;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptpDCRural(Boolean solicitudTINDICARTITULARINCLUSIONptpDCRural) {
        this.solicitudTINDICARTITULARINCLUSIONptpDCRural = solicitudTINDICARTITULARINCLUSIONptpDCRural;
    }

    private void checkSolicitudTINDICARTITULARINCLUSIONptpDCRural() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARTITULARINCLUSIONptpDCRural() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARTITULARINCLUSION, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARTITULARINCLUSION_SOLICITUDTINDICARTITULARINCLUSIONPTPDCRURAL, SolicitudConstants.SERV_ALIAS_TINDICARTITULARINCLUSION, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARTITULARINCLUSION_SOLICITUDTINDICARTITULARINCLUSIONPTPDCRURAL);
        }
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULARINCLUSIONptDCTelefonoFijo() {
        return this.solicitudTINDICARTITULARINCLUSIONptDCTelefonoFijo;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptDCTelefonoFijo(String solicitudTINDICARTITULARINCLUSIONptDCTelefonoFijo) {
        this.solicitudTINDICARTITULARINCLUSIONptDCTelefonoFijo = solicitudTINDICARTITULARINCLUSIONptDCTelefonoFijo;
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULARINCLUSIONptDCTelefonoCelular() {
        return this.solicitudTINDICARTITULARINCLUSIONptDCTelefonoCelular;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptDCTelefonoCelular(String solicitudTINDICARTITULARINCLUSIONptDCTelefonoCelular) {
        this.solicitudTINDICARTITULARINCLUSIONptDCTelefonoCelular = solicitudTINDICARTITULARINCLUSIONptDCTelefonoCelular;
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULARINCLUSIONptRazonSocial() {
        return this.solicitudTINDICARTITULARINCLUSIONptRazonSocial;
    }
    
    public void setSolicitudTINDICARTITULARINCLUSIONptRazonSocial(String solicitudTINDICARTITULARINCLUSIONptRazonSocial) {
        this.solicitudTINDICARTITULARINCLUSIONptRazonSocial = solicitudTINDICARTITULARINCLUSIONptRazonSocial;
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
