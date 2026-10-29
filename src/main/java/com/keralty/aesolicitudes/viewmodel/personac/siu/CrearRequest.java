package com.keralty.aesolicitudes.viewmodel.personac.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.PersonaCConstants;
import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.Departamento;
import com.keralty.aesolicitudes.persistence.EstadoCivil;
import com.keralty.aesolicitudes.persistence.EstadoPersona;
import com.keralty.aesolicitudes.persistence.FamiliaC;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.oid.BeneficiarioCOid;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.DepartamentoOid;
import com.keralty.aesolicitudes.persistence.oid.EstadoCivilOid;
import com.keralty.aesolicitudes.persistence.oid.EstadoPersonaOid;
import com.keralty.aesolicitudes.persistence.oid.FamiliaCOid;
import com.keralty.aesolicitudes.persistence.oid.MunicipioOid;
import com.keralty.aesolicitudes.persistence.oid.TipoEntidadCOid;
import com.keralty.aesolicitudes.persistence.oid.TipoIdentificacionOid;
import com.keralty.aesolicitudes.persistence.oid.TipoInstitucionCOid;
import com.keralty.aesolicitudes.persistence.TipoEntidadC;
import com.keralty.aesolicitudes.persistence.TipoIdentificacion;
import com.keralty.aesolicitudes.persistence.TipoInstitucionC;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;
import java.sql.Timestamp;

public class CrearRequest {

    @JsonProperty("p_agrtipoinstitucionc_oid")
    private TipoInstitucionCOid personaCcrearpagrTipoInstitucionC;
    
    @JsonIgnore
    private TipoInstitucionC personaCcrearpagrTipoInstitucionCInstance;

    @JsonProperty("p_agrtipoentidadc_oid")
    private TipoEntidadCOid personaCcrearpagrTipoEntidadC;
    
    @JsonIgnore
    private TipoEntidadC personaCcrearpagrTipoEntidadCInstance;

    @JsonProperty("p_agrestadocivilc_oid")
    private EstadoCivilOid personaCcrearpagrEstadoCivilC;
    
    @JsonIgnore
    private EstadoCivil personaCcrearpagrEstadoCivilCInstance;

    @JsonProperty("p_agrestadopersonac_oid")
    private EstadoPersonaOid personaCcrearpagrEstadoPersonaC;
    
    @JsonIgnore
    private EstadoPersona personaCcrearpagrEstadoPersonaCInstance;

    @JsonProperty("p_agrtipoidentificacionc_oid")
    private TipoIdentificacionOid personaCcrearpagrTipoIdentificacionC;
    
    @JsonIgnore
    private TipoIdentificacion personaCcrearpagrTipoIdentificacionCInstance;

    @JsonProperty("p_agrmunicipiocnac_oid")
    private MunicipioOid personaCcrearpagrMunicipioCNac;
    
    @JsonIgnore
    private Municipio personaCcrearpagrMunicipioCNacInstance;

    @JsonProperty("p_agrdepartamentocnac_oid")
    private DepartamentoOid personaCcrearpagrDepartamentoCNac;
    
    @JsonIgnore
    private Departamento personaCcrearpagrDepartamentoCNacInstance;

    @JsonProperty("p_agrcontratosc_oid")
    private ContratoCOid personaCcrearpagrContratosC;
    
    @JsonIgnore
    private ContratoC personaCcrearpagrContratosCInstance;

    @JsonProperty("p_agrfamiliasc_oid")
    private FamiliaCOid personaCcrearpagrFamiliasC;
    
    @JsonIgnore
    private FamiliaC personaCcrearpagrFamiliasCInstance;

    @JsonProperty("p_agrbeneficiariosc_oid")
    private BeneficiarioCOid personaCcrearpagrBeneficiariosC;
    
    @JsonIgnore
    private BeneficiarioC personaCcrearpagrBeneficiariosCInstance;

    @JsonProperty("p_atrnumidentificacion")
    private String personaCcrearpatrNumIdentificacion;

    @JsonProperty("p_atrmail")
    private String personaCcrearpatrMail;

    @JsonProperty("p_atrprimernombre")
    private String personaCcrearpatrPrimerNombre;

    @JsonProperty("p_atrsegundonombre")
    private String personaCcrearpatrSegundoNombre;

    @JsonProperty("p_atrprimerapellido")
    private String personaCcrearpatrPrimerApellido;

    @JsonProperty("p_atrsegundoapellido")
    private String personaCcrearpatrSegundoApellido;

    @JsonProperty("p_atrfechanacimiento")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date personaCcrearpatrFechaNacimiento;

    @JsonProperty("p_atrgenero")
    private String personaCcrearpatrGenero;

    @JsonProperty("p_atrindicadorextranjero")
    private Boolean personaCcrearpatrIndicadorExtranjero;

    @JsonProperty("p_atrrazonsocial")
    private String personaCcrearpatrRazonSocial;

    @JsonProperty("p_atrtieneepssanitas")
    private Boolean personaCcrearpatrTieneEPSSanitas;

    @JsonProperty("p_atrrechazadoafiliacion")
    private String personaCcrearpatrRechazadoAfiliacion;

    @JsonProperty("p_atrnombrecompleto")
    private String personaCcrearpatrNombreCompleto;

    @JsonProperty("p_atrcodigo")
    private Long personaCcrearpatrCodigo;

    @JsonProperty("p_atrultimaactualizacion")
    private Timestamp personaCcrearpatrUltimaActualizacion;

    public void checkArguments() throws NotNullArgumentException {
        checkPersonaCcrearpagrTipoIdentificacionC();
        checkPersonaCcrearpatrNumIdentificacion();
    }

    @JsonIgnore
    public TipoInstitucionCOid getPersonaCcrearpagrTipoInstitucionC() {
        return this.personaCcrearpagrTipoInstitucionC;
    }
    
    public void setPersonaCcrearpagrTipoInstitucionC(TipoInstitucionCOid personaCcrearpagrTipoInstitucionC) {
        this.personaCcrearpagrTipoInstitucionC = personaCcrearpagrTipoInstitucionC;
    }

    @JsonIgnore
    public TipoInstitucionC getPersonaCcrearpagrTipoInstitucionCInstance() {
        return this.personaCcrearpagrTipoInstitucionCInstance;
    }
    
    public void setPersonaCcrearpagrTipoInstitucionCInstance(TipoInstitucionC personaCcrearpagrTipoInstitucionC) {
        this.personaCcrearpagrTipoInstitucionCInstance = personaCcrearpagrTipoInstitucionC;
        this.personaCcrearpagrTipoInstitucionC = personaCcrearpagrTipoInstitucionC != null ? personaCcrearpagrTipoInstitucionC.getOid() : null;
    }

    @JsonIgnore
    public TipoEntidadCOid getPersonaCcrearpagrTipoEntidadC() {
        return this.personaCcrearpagrTipoEntidadC;
    }
    
    public void setPersonaCcrearpagrTipoEntidadC(TipoEntidadCOid personaCcrearpagrTipoEntidadC) {
        this.personaCcrearpagrTipoEntidadC = personaCcrearpagrTipoEntidadC;
    }

    @JsonIgnore
    public TipoEntidadC getPersonaCcrearpagrTipoEntidadCInstance() {
        return this.personaCcrearpagrTipoEntidadCInstance;
    }
    
    public void setPersonaCcrearpagrTipoEntidadCInstance(TipoEntidadC personaCcrearpagrTipoEntidadC) {
        this.personaCcrearpagrTipoEntidadCInstance = personaCcrearpagrTipoEntidadC;
        this.personaCcrearpagrTipoEntidadC = personaCcrearpagrTipoEntidadC != null ? personaCcrearpagrTipoEntidadC.getOid() : null;
    }

    @JsonIgnore
    public EstadoCivilOid getPersonaCcrearpagrEstadoCivilC() {
        return this.personaCcrearpagrEstadoCivilC;
    }
    
    public void setPersonaCcrearpagrEstadoCivilC(EstadoCivilOid personaCcrearpagrEstadoCivilC) {
        this.personaCcrearpagrEstadoCivilC = personaCcrearpagrEstadoCivilC;
    }

    @JsonIgnore
    public EstadoCivil getPersonaCcrearpagrEstadoCivilCInstance() {
        return this.personaCcrearpagrEstadoCivilCInstance;
    }
    
    public void setPersonaCcrearpagrEstadoCivilCInstance(EstadoCivil personaCcrearpagrEstadoCivilC) {
        this.personaCcrearpagrEstadoCivilCInstance = personaCcrearpagrEstadoCivilC;
        this.personaCcrearpagrEstadoCivilC = personaCcrearpagrEstadoCivilC != null ? personaCcrearpagrEstadoCivilC.getOid() : null;
    }

    @JsonIgnore
    public EstadoPersonaOid getPersonaCcrearpagrEstadoPersonaC() {
        return this.personaCcrearpagrEstadoPersonaC;
    }
    
    public void setPersonaCcrearpagrEstadoPersonaC(EstadoPersonaOid personaCcrearpagrEstadoPersonaC) {
        this.personaCcrearpagrEstadoPersonaC = personaCcrearpagrEstadoPersonaC;
    }

    @JsonIgnore
    public EstadoPersona getPersonaCcrearpagrEstadoPersonaCInstance() {
        return this.personaCcrearpagrEstadoPersonaCInstance;
    }
    
    public void setPersonaCcrearpagrEstadoPersonaCInstance(EstadoPersona personaCcrearpagrEstadoPersonaC) {
        this.personaCcrearpagrEstadoPersonaCInstance = personaCcrearpagrEstadoPersonaC;
        this.personaCcrearpagrEstadoPersonaC = personaCcrearpagrEstadoPersonaC != null ? personaCcrearpagrEstadoPersonaC.getOid() : null;
    }

    @JsonIgnore
    public TipoIdentificacionOid getPersonaCcrearpagrTipoIdentificacionC() {
        return this.personaCcrearpagrTipoIdentificacionC;
    }
    
    public void setPersonaCcrearpagrTipoIdentificacionC(TipoIdentificacionOid personaCcrearpagrTipoIdentificacionC) {
        this.personaCcrearpagrTipoIdentificacionC = personaCcrearpagrTipoIdentificacionC;
    }

    @JsonIgnore
    public TipoIdentificacion getPersonaCcrearpagrTipoIdentificacionCInstance() {
        return this.personaCcrearpagrTipoIdentificacionCInstance;
    }
    
    public void setPersonaCcrearpagrTipoIdentificacionCInstance(TipoIdentificacion personaCcrearpagrTipoIdentificacionC) {
        this.personaCcrearpagrTipoIdentificacionCInstance = personaCcrearpagrTipoIdentificacionC;
        this.personaCcrearpagrTipoIdentificacionC = personaCcrearpagrTipoIdentificacionC != null ? personaCcrearpagrTipoIdentificacionC.getOid() : null;
    }

    private void checkPersonaCcrearpagrTipoIdentificacionC() throws NotNullArgumentException {
        if(this.getPersonaCcrearpagrTipoIdentificacionCInstance() == null || this.getPersonaCcrearpagrTipoIdentificacionCInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_CREAR, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_CREAR_PERSONACCREARPAGRTIPOIDENTIFICACIONC, PersonaCConstants.SERV_ALIAS_CREAR, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_CREAR_PERSONACCREARPAGRTIPOIDENTIFICACIONC);
        }
    }

    @JsonIgnore
    public MunicipioOid getPersonaCcrearpagrMunicipioCNac() {
        return this.personaCcrearpagrMunicipioCNac;
    }
    
    public void setPersonaCcrearpagrMunicipioCNac(MunicipioOid personaCcrearpagrMunicipioCNac) {
        this.personaCcrearpagrMunicipioCNac = personaCcrearpagrMunicipioCNac;
    }

    @JsonIgnore
    public Municipio getPersonaCcrearpagrMunicipioCNacInstance() {
        return this.personaCcrearpagrMunicipioCNacInstance;
    }
    
    public void setPersonaCcrearpagrMunicipioCNacInstance(Municipio personaCcrearpagrMunicipioCNac) {
        this.personaCcrearpagrMunicipioCNacInstance = personaCcrearpagrMunicipioCNac;
        this.personaCcrearpagrMunicipioCNac = personaCcrearpagrMunicipioCNac != null ? personaCcrearpagrMunicipioCNac.getOid() : null;
    }

    @JsonIgnore
    public DepartamentoOid getPersonaCcrearpagrDepartamentoCNac() {
        return this.personaCcrearpagrDepartamentoCNac;
    }
    
    public void setPersonaCcrearpagrDepartamentoCNac(DepartamentoOid personaCcrearpagrDepartamentoCNac) {
        this.personaCcrearpagrDepartamentoCNac = personaCcrearpagrDepartamentoCNac;
    }

    @JsonIgnore
    public Departamento getPersonaCcrearpagrDepartamentoCNacInstance() {
        return this.personaCcrearpagrDepartamentoCNacInstance;
    }
    
    public void setPersonaCcrearpagrDepartamentoCNacInstance(Departamento personaCcrearpagrDepartamentoCNac) {
        this.personaCcrearpagrDepartamentoCNacInstance = personaCcrearpagrDepartamentoCNac;
        this.personaCcrearpagrDepartamentoCNac = personaCcrearpagrDepartamentoCNac != null ? personaCcrearpagrDepartamentoCNac.getOid() : null;
    }

    @JsonIgnore
    public ContratoCOid getPersonaCcrearpagrContratosC() {
        return this.personaCcrearpagrContratosC;
    }
    
    public void setPersonaCcrearpagrContratosC(ContratoCOid personaCcrearpagrContratosC) {
        this.personaCcrearpagrContratosC = personaCcrearpagrContratosC;
    }

    @JsonIgnore
    public ContratoC getPersonaCcrearpagrContratosCInstance() {
        return this.personaCcrearpagrContratosCInstance;
    }
    
    public void setPersonaCcrearpagrContratosCInstance(ContratoC personaCcrearpagrContratosC) {
        this.personaCcrearpagrContratosCInstance = personaCcrearpagrContratosC;
        this.personaCcrearpagrContratosC = personaCcrearpagrContratosC != null ? personaCcrearpagrContratosC.getOid() : null;
    }

    @JsonIgnore
    public FamiliaCOid getPersonaCcrearpagrFamiliasC() {
        return this.personaCcrearpagrFamiliasC;
    }
    
    public void setPersonaCcrearpagrFamiliasC(FamiliaCOid personaCcrearpagrFamiliasC) {
        this.personaCcrearpagrFamiliasC = personaCcrearpagrFamiliasC;
    }

    @JsonIgnore
    public FamiliaC getPersonaCcrearpagrFamiliasCInstance() {
        return this.personaCcrearpagrFamiliasCInstance;
    }
    
    public void setPersonaCcrearpagrFamiliasCInstance(FamiliaC personaCcrearpagrFamiliasC) {
        this.personaCcrearpagrFamiliasCInstance = personaCcrearpagrFamiliasC;
        this.personaCcrearpagrFamiliasC = personaCcrearpagrFamiliasC != null ? personaCcrearpagrFamiliasC.getOid() : null;
    }

    @JsonIgnore
    public BeneficiarioCOid getPersonaCcrearpagrBeneficiariosC() {
        return this.personaCcrearpagrBeneficiariosC;
    }
    
    public void setPersonaCcrearpagrBeneficiariosC(BeneficiarioCOid personaCcrearpagrBeneficiariosC) {
        this.personaCcrearpagrBeneficiariosC = personaCcrearpagrBeneficiariosC;
    }

    @JsonIgnore
    public BeneficiarioC getPersonaCcrearpagrBeneficiariosCInstance() {
        return this.personaCcrearpagrBeneficiariosCInstance;
    }
    
    public void setPersonaCcrearpagrBeneficiariosCInstance(BeneficiarioC personaCcrearpagrBeneficiariosC) {
        this.personaCcrearpagrBeneficiariosCInstance = personaCcrearpagrBeneficiariosC;
        this.personaCcrearpagrBeneficiariosC = personaCcrearpagrBeneficiariosC != null ? personaCcrearpagrBeneficiariosC.getOid() : null;
    }

    @JsonIgnore
    public String getPersonaCcrearpatrNumIdentificacion() {
        return this.personaCcrearpatrNumIdentificacion;
    }
    
    public void setPersonaCcrearpatrNumIdentificacion(String personaCcrearpatrNumIdentificacion) {
        this.personaCcrearpatrNumIdentificacion = personaCcrearpatrNumIdentificacion;
    }

    private void checkPersonaCcrearpatrNumIdentificacion() throws NotNullArgumentException {
        if(this.getPersonaCcrearpatrNumIdentificacion() == null) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_CREAR, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_CREAR_PERSONACCREARPATRNUMIDENTIFICACION, PersonaCConstants.SERV_ALIAS_CREAR, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_CREAR_PERSONACCREARPATRNUMIDENTIFICACION);
        }
    }

    @JsonIgnore
    public String getPersonaCcrearpatrMail() {
        return this.personaCcrearpatrMail;
    }
    
    public void setPersonaCcrearpatrMail(String personaCcrearpatrMail) {
        this.personaCcrearpatrMail = personaCcrearpatrMail;
    }

    @JsonIgnore
    public String getPersonaCcrearpatrPrimerNombre() {
        return this.personaCcrearpatrPrimerNombre;
    }
    
    public void setPersonaCcrearpatrPrimerNombre(String personaCcrearpatrPrimerNombre) {
        this.personaCcrearpatrPrimerNombre = personaCcrearpatrPrimerNombre;
    }

    @JsonIgnore
    public String getPersonaCcrearpatrSegundoNombre() {
        return this.personaCcrearpatrSegundoNombre;
    }
    
    public void setPersonaCcrearpatrSegundoNombre(String personaCcrearpatrSegundoNombre) {
        this.personaCcrearpatrSegundoNombre = personaCcrearpatrSegundoNombre;
    }

    @JsonIgnore
    public String getPersonaCcrearpatrPrimerApellido() {
        return this.personaCcrearpatrPrimerApellido;
    }
    
    public void setPersonaCcrearpatrPrimerApellido(String personaCcrearpatrPrimerApellido) {
        this.personaCcrearpatrPrimerApellido = personaCcrearpatrPrimerApellido;
    }

    @JsonIgnore
    public String getPersonaCcrearpatrSegundoApellido() {
        return this.personaCcrearpatrSegundoApellido;
    }
    
    public void setPersonaCcrearpatrSegundoApellido(String personaCcrearpatrSegundoApellido) {
        this.personaCcrearpatrSegundoApellido = personaCcrearpatrSegundoApellido;
    }

    @JsonIgnore
    public Date getPersonaCcrearpatrFechaNacimiento() {
        return this.personaCcrearpatrFechaNacimiento;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setPersonaCcrearpatrFechaNacimiento(Date personaCcrearpatrFechaNacimiento) {
        this.personaCcrearpatrFechaNacimiento = personaCcrearpatrFechaNacimiento;
    }

    @JsonIgnore
    public String getPersonaCcrearpatrGenero() {
        return this.personaCcrearpatrGenero;
    }
    
    public void setPersonaCcrearpatrGenero(String personaCcrearpatrGenero) {
        this.personaCcrearpatrGenero = personaCcrearpatrGenero;
    }

    @JsonIgnore
    public Boolean getPersonaCcrearpatrIndicadorExtranjero() {
        return this.personaCcrearpatrIndicadorExtranjero;
    }
    
    public void setPersonaCcrearpatrIndicadorExtranjero(Boolean personaCcrearpatrIndicadorExtranjero) {
        this.personaCcrearpatrIndicadorExtranjero = personaCcrearpatrIndicadorExtranjero;
    }

    @JsonIgnore
    public String getPersonaCcrearpatrRazonSocial() {
        return this.personaCcrearpatrRazonSocial;
    }
    
    public void setPersonaCcrearpatrRazonSocial(String personaCcrearpatrRazonSocial) {
        this.personaCcrearpatrRazonSocial = personaCcrearpatrRazonSocial;
    }

    @JsonIgnore
    public Boolean getPersonaCcrearpatrTieneEPSSanitas() {
        return this.personaCcrearpatrTieneEPSSanitas;
    }
    
    public void setPersonaCcrearpatrTieneEPSSanitas(Boolean personaCcrearpatrTieneEPSSanitas) {
        this.personaCcrearpatrTieneEPSSanitas = personaCcrearpatrTieneEPSSanitas;
    }

    @JsonIgnore
    public String getPersonaCcrearpatrRechazadoAfiliacion() {
        return this.personaCcrearpatrRechazadoAfiliacion;
    }
    
    public void setPersonaCcrearpatrRechazadoAfiliacion(String personaCcrearpatrRechazadoAfiliacion) {
        this.personaCcrearpatrRechazadoAfiliacion = personaCcrearpatrRechazadoAfiliacion;
    }

    @JsonIgnore
    public String getPersonaCcrearpatrNombreCompleto() {
        return this.personaCcrearpatrNombreCompleto;
    }
    
    public void setPersonaCcrearpatrNombreCompleto(String personaCcrearpatrNombreCompleto) {
        this.personaCcrearpatrNombreCompleto = personaCcrearpatrNombreCompleto;
    }

    @JsonIgnore
    public Long getPersonaCcrearpatrCodigo() {
        return this.personaCcrearpatrCodigo;
    }
    
    public void setPersonaCcrearpatrCodigo(Long personaCcrearpatrCodigo) {
        this.personaCcrearpatrCodigo = personaCcrearpatrCodigo;
    }

    @JsonIgnore
    public Timestamp getPersonaCcrearpatrUltimaActualizacion() {
        return this.personaCcrearpatrUltimaActualizacion;
    }
    
    public void setPersonaCcrearpatrUltimaActualizacion(Timestamp personaCcrearpatrUltimaActualizacion) {
        this.personaCcrearpatrUltimaActualizacion = personaCcrearpatrUltimaActualizacion;
    }
}
