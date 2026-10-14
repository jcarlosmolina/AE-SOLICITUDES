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

public class TINDICARTITULAR2Request {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudTINDICARTITULAR2pthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudTINDICARTITULAR2pthisSolicitudInstance;

    @JsonProperty("pt_p_agrtipoidentificacion_json")
    private String solicitudTINDICARTITULAR2ptpagrTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion solicitudTINDICARTITULAR2ptpagrTipoIdentificacionInstance;

    @JsonProperty("pt_p_agrdepartamentonacimiento_json")
    private String solicitudTINDICARTITULAR2ptpagrDepartamentoNacimiento;
    
    @JsonIgnore
    private Departamento solicitudTINDICARTITULAR2ptpagrDepartamentoNacimientoInstance;

    @JsonProperty("pt_p_agrmunicipionacimiento_json")
    private String solicitudTINDICARTITULAR2ptpagrMunicipioNacimiento;
    
    @JsonIgnore
    private Municipio solicitudTINDICARTITULAR2ptpagrMunicipioNacimientoInstance;

    @JsonProperty("pt_p_agrestadocivil_json")
    private String solicitudTINDICARTITULAR2ptpagrEstadoCivil;
    
    @JsonIgnore
    private EstadoCivil solicitudTINDICARTITULAR2ptpagrEstadoCivilInstance;

    @JsonProperty("pt_p_atrnumidentificacion")
    private String solicitudTINDICARTITULAR2ptpatrNumIdentificacion;

    @JsonProperty("pt_p_atrprimernombre")
    private String solicitudTINDICARTITULAR2ptpatrPrimerNombre;

    @JsonProperty("pt_p_atrsegundonombre")
    private String solicitudTINDICARTITULAR2ptpatrSegundoNombre;

    @JsonProperty("pt_p_atrprimerapellido")
    private String solicitudTINDICARTITULAR2ptpatrPrimerApellido;

    @JsonProperty("pt_p_atrsegundoapellido")
    private String solicitudTINDICARTITULAR2ptpatrSegundoApellido;

    @JsonProperty("pt_p_atrfechanacimiento")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date solicitudTINDICARTITULAR2ptpatrFechaNacimiento;

    @JsonProperty("pt_p_atrgenero")
    private String solicitudTINDICARTITULAR2ptpatrGenero;

    @JsonProperty("pt_p_atrindicadorextranjero")
    private Boolean solicitudTINDICARTITULAR2ptpatrIndicadorExtranjero;

    @JsonProperty("pt_p_atrtelefonofijo")
    private String solicitudTINDICARTITULAR2ptpatrTelefonoFijo;

    @JsonProperty("pt_p_atrtelefonocelular")
    private String solicitudTINDICARTITULAR2ptpatrTelefonoCelular;

    @JsonProperty("pt_p_atrcorreoelectronico")
    private String solicitudTINDICARTITULAR2ptpatrCorreoElectronico;

    @JsonProperty("pt_p_agrdepartamento_json")
    private String solicitudTINDICARTITULAR2ptpagrDepartamento;
    
    @JsonIgnore
    private Departamento solicitudTINDICARTITULAR2ptpagrDepartamentoInstance;

    @JsonProperty("pt_p_agrmunicipio_json")
    private String solicitudTINDICARTITULAR2ptpagrMunicipio;
    
    @JsonIgnore
    private Municipio solicitudTINDICARTITULAR2ptpagrMunicipioInstance;

    @JsonProperty("pt_p_atrdireccioncompleta")
    private String solicitudTINDICARTITULAR2ptpatrDireccionCompleta;

    @JsonProperty("pt_p_atrrural")
    private Boolean solicitudTINDICARTITULAR2ptpatrRural;

    @JsonProperty("pt_p_agrpais_oid")
    private PaisOid solicitudTINDICARTITULAR2ptpagrPais;
    
    @JsonIgnore
    private Pais solicitudTINDICARTITULAR2ptpagrPaisInstance;

    @JsonProperty("pt_p_codigo")
    private Long solicitudTINDICARTITULAR2ptpCodigo;

    @JsonProperty("pt_p_tieneepssanitas")
    private Boolean solicitudTINDICARTITULAR2ptpTieneEPSSanitas;

    @JsonProperty("pt_p_rechazadoafiliacion")
    private String solicitudTINDICARTITULAR2ptpRechazadoAfiliacion;

    @JsonProperty("pt_p_titularbeneficios")
    private Boolean solicitudTINDICARTITULAR2ptpTitularBeneficios;

    @JsonProperty("ptestadopersona_oid")
    private EstadoPersonaOid solicitudTINDICARTITULAR2ptEstadoPersona;
    
    @JsonIgnore
    private EstadoPersona solicitudTINDICARTITULAR2ptEstadoPersonaInstance;

    @JsonProperty("ptdcdepartamento_json")
    private String solicitudTINDICARTITULAR2ptDCDepartamento;
    
    @JsonIgnore
    private Departamento solicitudTINDICARTITULAR2ptDCDepartamentoInstance;

    @JsonProperty("ptdcmunicipio_json")
    private String solicitudTINDICARTITULAR2ptDCMunicipio;
    
    @JsonIgnore
    private Municipio solicitudTINDICARTITULAR2ptDCMunicipioInstance;

    @JsonProperty("ptdcdireccioncompleta")
    private String solicitudTINDICARTITULAR2ptDCDireccionCompleta;

    @JsonProperty("ptdcrural")
    private Boolean solicitudTINDICARTITULAR2ptDCRural;

    @JsonProperty("ptdctelefonofijo")
    private String solicitudTINDICARTITULAR2ptDCTelefonoFijo;

    @JsonProperty("ptdctelefonocelular")
    private String solicitudTINDICARTITULAR2ptDCTelefonoCelular;

    @JsonProperty("ptreplicardir")
    private Boolean solicitudTINDICARTITULAR2ptReplicarDir;

    @JsonProperty("ptrazonsocial")
    private String solicitudTINDICARTITULAR2ptRazonSocial;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudTINDICARTITULAR2pthisSolicitud();
        checkSolicitudTINDICARTITULAR2ptpagrTipoIdentificacion();
        checkSolicitudTINDICARTITULAR2ptpatrNumIdentificacion();
        checkSolicitudTINDICARTITULAR2ptpatrIndicadorExtranjero();
        checkSolicitudTINDICARTITULAR2ptpatrRural();
        checkSolicitudTINDICARTITULAR2ptpTieneEPSSanitas();
        checkSolicitudTINDICARTITULAR2ptpTitularBeneficios();
        checkSolicitudTINDICARTITULAR2ptDCRural();
        checkSolicitudTINDICARTITULAR2ptReplicarDir();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudTINDICARTITULAR2pthisSolicitud() {
        return this.solicitudTINDICARTITULAR2pthisSolicitud;
    }
    
    public void setSolicitudTINDICARTITULAR2pthisSolicitud(SolicitudOid solicitudTINDICARTITULAR2pthisSolicitud) {
        this.solicitudTINDICARTITULAR2pthisSolicitud = solicitudTINDICARTITULAR2pthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudTINDICARTITULAR2pthisSolicitudInstance() {
        return this.solicitudTINDICARTITULAR2pthisSolicitudInstance;
    }
    
    public void setSolicitudTINDICARTITULAR2pthisSolicitudInstance(Solicitud solicitudTINDICARTITULAR2pthisSolicitud) {
        this.solicitudTINDICARTITULAR2pthisSolicitudInstance = solicitudTINDICARTITULAR2pthisSolicitud;
        this.solicitudTINDICARTITULAR2pthisSolicitud = solicitudTINDICARTITULAR2pthisSolicitud != null ? solicitudTINDICARTITULAR2pthisSolicitud.getOid() : null;
    }

    private void checkSolicitudTINDICARTITULAR2pthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARTITULAR2pthisSolicitudInstance() == null || this.getSolicitudTINDICARTITULAR2pthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARTITULAR2, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARTITULAR2_SOLICITUDTINDICARTITULAR2PTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_TINDICARTITULAR2, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARTITULAR2_SOLICITUDTINDICARTITULAR2PTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULAR2ptpagrTipoIdentificacion() {
        return this.solicitudTINDICARTITULAR2ptpagrTipoIdentificacion;
    }
    
    public void setSolicitudTINDICARTITULAR2ptpagrTipoIdentificacion(String solicitudTINDICARTITULAR2ptpagrTipoIdentificacion) {
        this.solicitudTINDICARTITULAR2ptpagrTipoIdentificacion = solicitudTINDICARTITULAR2ptpagrTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getSolicitudTINDICARTITULAR2ptpagrTipoIdentificacionInstance() {
        return this.solicitudTINDICARTITULAR2ptpagrTipoIdentificacionInstance;
    }
    
    public void setSolicitudTINDICARTITULAR2ptpagrTipoIdentificacionInstance(TipoIdentificacion solicitudTINDICARTITULAR2ptpagrTipoIdentificacion) {
        this.solicitudTINDICARTITULAR2ptpagrTipoIdentificacionInstance = solicitudTINDICARTITULAR2ptpagrTipoIdentificacion;
        this.solicitudTINDICARTITULAR2ptpagrTipoIdentificacion = solicitudTINDICARTITULAR2ptpagrTipoIdentificacion != null ? solicitudTINDICARTITULAR2ptpagrTipoIdentificacion.getOid().toJson() : "";
    }

    private void checkSolicitudTINDICARTITULAR2ptpagrTipoIdentificacion() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARTITULAR2ptpagrTipoIdentificacionInstance() == null || this.getSolicitudTINDICARTITULAR2ptpagrTipoIdentificacionInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARTITULAR2, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARTITULAR2_SOLICITUDTINDICARTITULAR2PTPAGRTIPOIDENTIFICACION, SolicitudConstants.SERV_ALIAS_TINDICARTITULAR2, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARTITULAR2_SOLICITUDTINDICARTITULAR2PTPAGRTIPOIDENTIFICACION);
        }
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULAR2ptpagrDepartamentoNacimiento() {
        return this.solicitudTINDICARTITULAR2ptpagrDepartamentoNacimiento;
    }
    
    public void setSolicitudTINDICARTITULAR2ptpagrDepartamentoNacimiento(String solicitudTINDICARTITULAR2ptpagrDepartamentoNacimiento) {
        this.solicitudTINDICARTITULAR2ptpagrDepartamentoNacimiento = solicitudTINDICARTITULAR2ptpagrDepartamentoNacimiento;
    }

    @JsonIgnore
    public Departamento getSolicitudTINDICARTITULAR2ptpagrDepartamentoNacimientoInstance() {
        return this.solicitudTINDICARTITULAR2ptpagrDepartamentoNacimientoInstance;
    }
    
    public void setSolicitudTINDICARTITULAR2ptpagrDepartamentoNacimientoInstance(Departamento solicitudTINDICARTITULAR2ptpagrDepartamentoNacimiento) {
        this.solicitudTINDICARTITULAR2ptpagrDepartamentoNacimientoInstance = solicitudTINDICARTITULAR2ptpagrDepartamentoNacimiento;
        this.solicitudTINDICARTITULAR2ptpagrDepartamentoNacimiento = solicitudTINDICARTITULAR2ptpagrDepartamentoNacimiento != null ? solicitudTINDICARTITULAR2ptpagrDepartamentoNacimiento.getOid().toJson() : "";
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULAR2ptpagrMunicipioNacimiento() {
        return this.solicitudTINDICARTITULAR2ptpagrMunicipioNacimiento;
    }
    
    public void setSolicitudTINDICARTITULAR2ptpagrMunicipioNacimiento(String solicitudTINDICARTITULAR2ptpagrMunicipioNacimiento) {
        this.solicitudTINDICARTITULAR2ptpagrMunicipioNacimiento = solicitudTINDICARTITULAR2ptpagrMunicipioNacimiento;
    }

    @JsonIgnore
    public Municipio getSolicitudTINDICARTITULAR2ptpagrMunicipioNacimientoInstance() {
        return this.solicitudTINDICARTITULAR2ptpagrMunicipioNacimientoInstance;
    }
    
    public void setSolicitudTINDICARTITULAR2ptpagrMunicipioNacimientoInstance(Municipio solicitudTINDICARTITULAR2ptpagrMunicipioNacimiento) {
        this.solicitudTINDICARTITULAR2ptpagrMunicipioNacimientoInstance = solicitudTINDICARTITULAR2ptpagrMunicipioNacimiento;
        this.solicitudTINDICARTITULAR2ptpagrMunicipioNacimiento = solicitudTINDICARTITULAR2ptpagrMunicipioNacimiento != null ? solicitudTINDICARTITULAR2ptpagrMunicipioNacimiento.getOid().toJson() : "";
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULAR2ptpagrEstadoCivil() {
        return this.solicitudTINDICARTITULAR2ptpagrEstadoCivil;
    }
    
    public void setSolicitudTINDICARTITULAR2ptpagrEstadoCivil(String solicitudTINDICARTITULAR2ptpagrEstadoCivil) {
        this.solicitudTINDICARTITULAR2ptpagrEstadoCivil = solicitudTINDICARTITULAR2ptpagrEstadoCivil;
    }

    @JsonIgnore
    public EstadoCivil getSolicitudTINDICARTITULAR2ptpagrEstadoCivilInstance() {
        return this.solicitudTINDICARTITULAR2ptpagrEstadoCivilInstance;
    }
    
    public void setSolicitudTINDICARTITULAR2ptpagrEstadoCivilInstance(EstadoCivil solicitudTINDICARTITULAR2ptpagrEstadoCivil) {
        this.solicitudTINDICARTITULAR2ptpagrEstadoCivilInstance = solicitudTINDICARTITULAR2ptpagrEstadoCivil;
        this.solicitudTINDICARTITULAR2ptpagrEstadoCivil = solicitudTINDICARTITULAR2ptpagrEstadoCivil != null ? solicitudTINDICARTITULAR2ptpagrEstadoCivil.getOid().toJson() : "";
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULAR2ptpatrNumIdentificacion() {
        return this.solicitudTINDICARTITULAR2ptpatrNumIdentificacion;
    }
    
    public void setSolicitudTINDICARTITULAR2ptpatrNumIdentificacion(String solicitudTINDICARTITULAR2ptpatrNumIdentificacion) {
        this.solicitudTINDICARTITULAR2ptpatrNumIdentificacion = solicitudTINDICARTITULAR2ptpatrNumIdentificacion;
    }

    private void checkSolicitudTINDICARTITULAR2ptpatrNumIdentificacion() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARTITULAR2ptpatrNumIdentificacion() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARTITULAR2, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARTITULAR2_SOLICITUDTINDICARTITULAR2PTPATRNUMIDENTIFICACION, SolicitudConstants.SERV_ALIAS_TINDICARTITULAR2, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARTITULAR2_SOLICITUDTINDICARTITULAR2PTPATRNUMIDENTIFICACION);
        }
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULAR2ptpatrPrimerNombre() {
        return this.solicitudTINDICARTITULAR2ptpatrPrimerNombre;
    }
    
    public void setSolicitudTINDICARTITULAR2ptpatrPrimerNombre(String solicitudTINDICARTITULAR2ptpatrPrimerNombre) {
        this.solicitudTINDICARTITULAR2ptpatrPrimerNombre = solicitudTINDICARTITULAR2ptpatrPrimerNombre;
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULAR2ptpatrSegundoNombre() {
        return this.solicitudTINDICARTITULAR2ptpatrSegundoNombre;
    }
    
    public void setSolicitudTINDICARTITULAR2ptpatrSegundoNombre(String solicitudTINDICARTITULAR2ptpatrSegundoNombre) {
        this.solicitudTINDICARTITULAR2ptpatrSegundoNombre = solicitudTINDICARTITULAR2ptpatrSegundoNombre;
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULAR2ptpatrPrimerApellido() {
        return this.solicitudTINDICARTITULAR2ptpatrPrimerApellido;
    }
    
    public void setSolicitudTINDICARTITULAR2ptpatrPrimerApellido(String solicitudTINDICARTITULAR2ptpatrPrimerApellido) {
        this.solicitudTINDICARTITULAR2ptpatrPrimerApellido = solicitudTINDICARTITULAR2ptpatrPrimerApellido;
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULAR2ptpatrSegundoApellido() {
        return this.solicitudTINDICARTITULAR2ptpatrSegundoApellido;
    }
    
    public void setSolicitudTINDICARTITULAR2ptpatrSegundoApellido(String solicitudTINDICARTITULAR2ptpatrSegundoApellido) {
        this.solicitudTINDICARTITULAR2ptpatrSegundoApellido = solicitudTINDICARTITULAR2ptpatrSegundoApellido;
    }

    @JsonIgnore
    public Date getSolicitudTINDICARTITULAR2ptpatrFechaNacimiento() {
        return this.solicitudTINDICARTITULAR2ptpatrFechaNacimiento;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setSolicitudTINDICARTITULAR2ptpatrFechaNacimiento(Date solicitudTINDICARTITULAR2ptpatrFechaNacimiento) {
        this.solicitudTINDICARTITULAR2ptpatrFechaNacimiento = solicitudTINDICARTITULAR2ptpatrFechaNacimiento;
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULAR2ptpatrGenero() {
        return this.solicitudTINDICARTITULAR2ptpatrGenero;
    }
    
    public void setSolicitudTINDICARTITULAR2ptpatrGenero(String solicitudTINDICARTITULAR2ptpatrGenero) {
        this.solicitudTINDICARTITULAR2ptpatrGenero = solicitudTINDICARTITULAR2ptpatrGenero;
    }

    @JsonIgnore
    public Boolean getSolicitudTINDICARTITULAR2ptpatrIndicadorExtranjero() {
        return this.solicitudTINDICARTITULAR2ptpatrIndicadorExtranjero;
    }
    
    public void setSolicitudTINDICARTITULAR2ptpatrIndicadorExtranjero(Boolean solicitudTINDICARTITULAR2ptpatrIndicadorExtranjero) {
        this.solicitudTINDICARTITULAR2ptpatrIndicadorExtranjero = solicitudTINDICARTITULAR2ptpatrIndicadorExtranjero;
    }

    private void checkSolicitudTINDICARTITULAR2ptpatrIndicadorExtranjero() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARTITULAR2ptpatrIndicadorExtranjero() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARTITULAR2, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARTITULAR2_SOLICITUDTINDICARTITULAR2PTPATRINDICADOREXTRANJERO, SolicitudConstants.SERV_ALIAS_TINDICARTITULAR2, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARTITULAR2_SOLICITUDTINDICARTITULAR2PTPATRINDICADOREXTRANJERO);
        }
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULAR2ptpatrTelefonoFijo() {
        return this.solicitudTINDICARTITULAR2ptpatrTelefonoFijo;
    }
    
    public void setSolicitudTINDICARTITULAR2ptpatrTelefonoFijo(String solicitudTINDICARTITULAR2ptpatrTelefonoFijo) {
        this.solicitudTINDICARTITULAR2ptpatrTelefonoFijo = solicitudTINDICARTITULAR2ptpatrTelefonoFijo;
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULAR2ptpatrTelefonoCelular() {
        return this.solicitudTINDICARTITULAR2ptpatrTelefonoCelular;
    }
    
    public void setSolicitudTINDICARTITULAR2ptpatrTelefonoCelular(String solicitudTINDICARTITULAR2ptpatrTelefonoCelular) {
        this.solicitudTINDICARTITULAR2ptpatrTelefonoCelular = solicitudTINDICARTITULAR2ptpatrTelefonoCelular;
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULAR2ptpatrCorreoElectronico() {
        return this.solicitudTINDICARTITULAR2ptpatrCorreoElectronico;
    }
    
    public void setSolicitudTINDICARTITULAR2ptpatrCorreoElectronico(String solicitudTINDICARTITULAR2ptpatrCorreoElectronico) {
        this.solicitudTINDICARTITULAR2ptpatrCorreoElectronico = solicitudTINDICARTITULAR2ptpatrCorreoElectronico;
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULAR2ptpagrDepartamento() {
        return this.solicitudTINDICARTITULAR2ptpagrDepartamento;
    }
    
    public void setSolicitudTINDICARTITULAR2ptpagrDepartamento(String solicitudTINDICARTITULAR2ptpagrDepartamento) {
        this.solicitudTINDICARTITULAR2ptpagrDepartamento = solicitudTINDICARTITULAR2ptpagrDepartamento;
    }

    @JsonIgnore
    public Departamento getSolicitudTINDICARTITULAR2ptpagrDepartamentoInstance() {
        return this.solicitudTINDICARTITULAR2ptpagrDepartamentoInstance;
    }
    
    public void setSolicitudTINDICARTITULAR2ptpagrDepartamentoInstance(Departamento solicitudTINDICARTITULAR2ptpagrDepartamento) {
        this.solicitudTINDICARTITULAR2ptpagrDepartamentoInstance = solicitudTINDICARTITULAR2ptpagrDepartamento;
        this.solicitudTINDICARTITULAR2ptpagrDepartamento = solicitudTINDICARTITULAR2ptpagrDepartamento != null ? solicitudTINDICARTITULAR2ptpagrDepartamento.getOid().toJson() : "";
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULAR2ptpagrMunicipio() {
        return this.solicitudTINDICARTITULAR2ptpagrMunicipio;
    }
    
    public void setSolicitudTINDICARTITULAR2ptpagrMunicipio(String solicitudTINDICARTITULAR2ptpagrMunicipio) {
        this.solicitudTINDICARTITULAR2ptpagrMunicipio = solicitudTINDICARTITULAR2ptpagrMunicipio;
    }

    @JsonIgnore
    public Municipio getSolicitudTINDICARTITULAR2ptpagrMunicipioInstance() {
        return this.solicitudTINDICARTITULAR2ptpagrMunicipioInstance;
    }
    
    public void setSolicitudTINDICARTITULAR2ptpagrMunicipioInstance(Municipio solicitudTINDICARTITULAR2ptpagrMunicipio) {
        this.solicitudTINDICARTITULAR2ptpagrMunicipioInstance = solicitudTINDICARTITULAR2ptpagrMunicipio;
        this.solicitudTINDICARTITULAR2ptpagrMunicipio = solicitudTINDICARTITULAR2ptpagrMunicipio != null ? solicitudTINDICARTITULAR2ptpagrMunicipio.getOid().toJson() : "";
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULAR2ptpatrDireccionCompleta() {
        return this.solicitudTINDICARTITULAR2ptpatrDireccionCompleta;
    }
    
    public void setSolicitudTINDICARTITULAR2ptpatrDireccionCompleta(String solicitudTINDICARTITULAR2ptpatrDireccionCompleta) {
        this.solicitudTINDICARTITULAR2ptpatrDireccionCompleta = solicitudTINDICARTITULAR2ptpatrDireccionCompleta;
    }

    @JsonIgnore
    public Boolean getSolicitudTINDICARTITULAR2ptpatrRural() {
        return this.solicitudTINDICARTITULAR2ptpatrRural;
    }
    
    public void setSolicitudTINDICARTITULAR2ptpatrRural(Boolean solicitudTINDICARTITULAR2ptpatrRural) {
        this.solicitudTINDICARTITULAR2ptpatrRural = solicitudTINDICARTITULAR2ptpatrRural;
    }

    private void checkSolicitudTINDICARTITULAR2ptpatrRural() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARTITULAR2ptpatrRural() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARTITULAR2, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARTITULAR2_SOLICITUDTINDICARTITULAR2PTPATRRURAL, SolicitudConstants.SERV_ALIAS_TINDICARTITULAR2, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARTITULAR2_SOLICITUDTINDICARTITULAR2PTPATRRURAL);
        }
    }

    @JsonIgnore
    public PaisOid getSolicitudTINDICARTITULAR2ptpagrPais() {
        return this.solicitudTINDICARTITULAR2ptpagrPais;
    }
    
    public void setSolicitudTINDICARTITULAR2ptpagrPais(PaisOid solicitudTINDICARTITULAR2ptpagrPais) {
        this.solicitudTINDICARTITULAR2ptpagrPais = solicitudTINDICARTITULAR2ptpagrPais;
    }

    @JsonIgnore
    public Pais getSolicitudTINDICARTITULAR2ptpagrPaisInstance() {
        return this.solicitudTINDICARTITULAR2ptpagrPaisInstance;
    }
    
    public void setSolicitudTINDICARTITULAR2ptpagrPaisInstance(Pais solicitudTINDICARTITULAR2ptpagrPais) {
        this.solicitudTINDICARTITULAR2ptpagrPaisInstance = solicitudTINDICARTITULAR2ptpagrPais;
        this.solicitudTINDICARTITULAR2ptpagrPais = solicitudTINDICARTITULAR2ptpagrPais != null ? solicitudTINDICARTITULAR2ptpagrPais.getOid() : null;
    }

    @JsonIgnore
    public Long getSolicitudTINDICARTITULAR2ptpCodigo() {
        return this.solicitudTINDICARTITULAR2ptpCodigo;
    }
    
    public void setSolicitudTINDICARTITULAR2ptpCodigo(Long solicitudTINDICARTITULAR2ptpCodigo) {
        this.solicitudTINDICARTITULAR2ptpCodigo = solicitudTINDICARTITULAR2ptpCodigo;
    }

    @JsonIgnore
    public Boolean getSolicitudTINDICARTITULAR2ptpTieneEPSSanitas() {
        return this.solicitudTINDICARTITULAR2ptpTieneEPSSanitas;
    }
    
    public void setSolicitudTINDICARTITULAR2ptpTieneEPSSanitas(Boolean solicitudTINDICARTITULAR2ptpTieneEPSSanitas) {
        this.solicitudTINDICARTITULAR2ptpTieneEPSSanitas = solicitudTINDICARTITULAR2ptpTieneEPSSanitas;
    }

    private void checkSolicitudTINDICARTITULAR2ptpTieneEPSSanitas() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARTITULAR2ptpTieneEPSSanitas() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARTITULAR2, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARTITULAR2_SOLICITUDTINDICARTITULAR2PTPTIENEEPSSANITAS, SolicitudConstants.SERV_ALIAS_TINDICARTITULAR2, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARTITULAR2_SOLICITUDTINDICARTITULAR2PTPTIENEEPSSANITAS);
        }
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULAR2ptpRechazadoAfiliacion() {
        return this.solicitudTINDICARTITULAR2ptpRechazadoAfiliacion;
    }
    
    public void setSolicitudTINDICARTITULAR2ptpRechazadoAfiliacion(String solicitudTINDICARTITULAR2ptpRechazadoAfiliacion) {
        this.solicitudTINDICARTITULAR2ptpRechazadoAfiliacion = solicitudTINDICARTITULAR2ptpRechazadoAfiliacion;
    }

    @JsonIgnore
    public Boolean getSolicitudTINDICARTITULAR2ptpTitularBeneficios() {
        return this.solicitudTINDICARTITULAR2ptpTitularBeneficios;
    }
    
    public void setSolicitudTINDICARTITULAR2ptpTitularBeneficios(Boolean solicitudTINDICARTITULAR2ptpTitularBeneficios) {
        this.solicitudTINDICARTITULAR2ptpTitularBeneficios = solicitudTINDICARTITULAR2ptpTitularBeneficios;
    }

    private void checkSolicitudTINDICARTITULAR2ptpTitularBeneficios() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARTITULAR2ptpTitularBeneficios() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARTITULAR2, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARTITULAR2_SOLICITUDTINDICARTITULAR2PTPTITULARBENEFICIOS, SolicitudConstants.SERV_ALIAS_TINDICARTITULAR2, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARTITULAR2_SOLICITUDTINDICARTITULAR2PTPTITULARBENEFICIOS);
        }
    }

    @JsonIgnore
    public EstadoPersonaOid getSolicitudTINDICARTITULAR2ptEstadoPersona() {
        return this.solicitudTINDICARTITULAR2ptEstadoPersona;
    }
    
    public void setSolicitudTINDICARTITULAR2ptEstadoPersona(EstadoPersonaOid solicitudTINDICARTITULAR2ptEstadoPersona) {
        this.solicitudTINDICARTITULAR2ptEstadoPersona = solicitudTINDICARTITULAR2ptEstadoPersona;
    }

    @JsonIgnore
    public EstadoPersona getSolicitudTINDICARTITULAR2ptEstadoPersonaInstance() {
        return this.solicitudTINDICARTITULAR2ptEstadoPersonaInstance;
    }
    
    public void setSolicitudTINDICARTITULAR2ptEstadoPersonaInstance(EstadoPersona solicitudTINDICARTITULAR2ptEstadoPersona) {
        this.solicitudTINDICARTITULAR2ptEstadoPersonaInstance = solicitudTINDICARTITULAR2ptEstadoPersona;
        this.solicitudTINDICARTITULAR2ptEstadoPersona = solicitudTINDICARTITULAR2ptEstadoPersona != null ? solicitudTINDICARTITULAR2ptEstadoPersona.getOid() : null;
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULAR2ptDCDepartamento() {
        return this.solicitudTINDICARTITULAR2ptDCDepartamento;
    }
    
    public void setSolicitudTINDICARTITULAR2ptDCDepartamento(String solicitudTINDICARTITULAR2ptDCDepartamento) {
        this.solicitudTINDICARTITULAR2ptDCDepartamento = solicitudTINDICARTITULAR2ptDCDepartamento;
    }

    @JsonIgnore
    public Departamento getSolicitudTINDICARTITULAR2ptDCDepartamentoInstance() {
        return this.solicitudTINDICARTITULAR2ptDCDepartamentoInstance;
    }
    
    public void setSolicitudTINDICARTITULAR2ptDCDepartamentoInstance(Departamento solicitudTINDICARTITULAR2ptDCDepartamento) {
        this.solicitudTINDICARTITULAR2ptDCDepartamentoInstance = solicitudTINDICARTITULAR2ptDCDepartamento;
        this.solicitudTINDICARTITULAR2ptDCDepartamento = solicitudTINDICARTITULAR2ptDCDepartamento != null ? solicitudTINDICARTITULAR2ptDCDepartamento.getOid().toJson() : "";
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULAR2ptDCMunicipio() {
        return this.solicitudTINDICARTITULAR2ptDCMunicipio;
    }
    
    public void setSolicitudTINDICARTITULAR2ptDCMunicipio(String solicitudTINDICARTITULAR2ptDCMunicipio) {
        this.solicitudTINDICARTITULAR2ptDCMunicipio = solicitudTINDICARTITULAR2ptDCMunicipio;
    }

    @JsonIgnore
    public Municipio getSolicitudTINDICARTITULAR2ptDCMunicipioInstance() {
        return this.solicitudTINDICARTITULAR2ptDCMunicipioInstance;
    }
    
    public void setSolicitudTINDICARTITULAR2ptDCMunicipioInstance(Municipio solicitudTINDICARTITULAR2ptDCMunicipio) {
        this.solicitudTINDICARTITULAR2ptDCMunicipioInstance = solicitudTINDICARTITULAR2ptDCMunicipio;
        this.solicitudTINDICARTITULAR2ptDCMunicipio = solicitudTINDICARTITULAR2ptDCMunicipio != null ? solicitudTINDICARTITULAR2ptDCMunicipio.getOid().toJson() : "";
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULAR2ptDCDireccionCompleta() {
        return this.solicitudTINDICARTITULAR2ptDCDireccionCompleta;
    }
    
    public void setSolicitudTINDICARTITULAR2ptDCDireccionCompleta(String solicitudTINDICARTITULAR2ptDCDireccionCompleta) {
        this.solicitudTINDICARTITULAR2ptDCDireccionCompleta = solicitudTINDICARTITULAR2ptDCDireccionCompleta;
    }

    @JsonIgnore
    public Boolean getSolicitudTINDICARTITULAR2ptDCRural() {
        return this.solicitudTINDICARTITULAR2ptDCRural;
    }
    
    public void setSolicitudTINDICARTITULAR2ptDCRural(Boolean solicitudTINDICARTITULAR2ptDCRural) {
        this.solicitudTINDICARTITULAR2ptDCRural = solicitudTINDICARTITULAR2ptDCRural;
    }

    private void checkSolicitudTINDICARTITULAR2ptDCRural() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARTITULAR2ptDCRural() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARTITULAR2, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARTITULAR2_SOLICITUDTINDICARTITULAR2PTDCRURAL, SolicitudConstants.SERV_ALIAS_TINDICARTITULAR2, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARTITULAR2_SOLICITUDTINDICARTITULAR2PTDCRURAL);
        }
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULAR2ptDCTelefonoFijo() {
        return this.solicitudTINDICARTITULAR2ptDCTelefonoFijo;
    }
    
    public void setSolicitudTINDICARTITULAR2ptDCTelefonoFijo(String solicitudTINDICARTITULAR2ptDCTelefonoFijo) {
        this.solicitudTINDICARTITULAR2ptDCTelefonoFijo = solicitudTINDICARTITULAR2ptDCTelefonoFijo;
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULAR2ptDCTelefonoCelular() {
        return this.solicitudTINDICARTITULAR2ptDCTelefonoCelular;
    }
    
    public void setSolicitudTINDICARTITULAR2ptDCTelefonoCelular(String solicitudTINDICARTITULAR2ptDCTelefonoCelular) {
        this.solicitudTINDICARTITULAR2ptDCTelefonoCelular = solicitudTINDICARTITULAR2ptDCTelefonoCelular;
    }

    @JsonIgnore
    public Boolean getSolicitudTINDICARTITULAR2ptReplicarDir() {
        return this.solicitudTINDICARTITULAR2ptReplicarDir;
    }
    
    public void setSolicitudTINDICARTITULAR2ptReplicarDir(Boolean solicitudTINDICARTITULAR2ptReplicarDir) {
        this.solicitudTINDICARTITULAR2ptReplicarDir = solicitudTINDICARTITULAR2ptReplicarDir;
    }

    private void checkSolicitudTINDICARTITULAR2ptReplicarDir() throws NotNullArgumentException {
        if(this.getSolicitudTINDICARTITULAR2ptReplicarDir() == null) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_TINDICARTITULAR2, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_TINDICARTITULAR2_SOLICITUDTINDICARTITULAR2PTREPLICARDIR, SolicitudConstants.SERV_ALIAS_TINDICARTITULAR2, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_TINDICARTITULAR2_SOLICITUDTINDICARTITULAR2PTREPLICARDIR);
        }
    }

    @JsonIgnore
    public String getSolicitudTINDICARTITULAR2ptRazonSocial() {
        return this.solicitudTINDICARTITULAR2ptRazonSocial;
    }
    
    public void setSolicitudTINDICARTITULAR2ptRazonSocial(String solicitudTINDICARTITULAR2ptRazonSocial) {
        this.solicitudTINDICARTITULAR2ptRazonSocial = solicitudTINDICARTITULAR2ptRazonSocial;
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
