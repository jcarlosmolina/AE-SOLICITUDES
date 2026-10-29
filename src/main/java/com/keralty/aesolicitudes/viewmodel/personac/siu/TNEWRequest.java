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

public class TNEWRequest {

    @JsonProperty("pt_p_agrtipoinstitucionc_oid")
    private TipoInstitucionCOid personaCTNEWptpagrTipoInstitucionC;
    
    @JsonIgnore
    private TipoInstitucionC personaCTNEWptpagrTipoInstitucionCInstance;

    @JsonProperty("pt_p_agrtipoentidadc_oid")
    private TipoEntidadCOid personaCTNEWptpagrTipoEntidadC;
    
    @JsonIgnore
    private TipoEntidadC personaCTNEWptpagrTipoEntidadCInstance;

    @JsonProperty("pt_p_agrestadocivilc_oid")
    private EstadoCivilOid personaCTNEWptpagrEstadoCivilC;
    
    @JsonIgnore
    private EstadoCivil personaCTNEWptpagrEstadoCivilCInstance;

    @JsonProperty("pt_p_agrestadopersonac_oid")
    private EstadoPersonaOid personaCTNEWptpagrEstadoPersonaC;
    
    @JsonIgnore
    private EstadoPersona personaCTNEWptpagrEstadoPersonaCInstance;

    @JsonProperty("pt_p_agrtipoidentificacionc_oid")
    private TipoIdentificacionOid personaCTNEWptpagrTipoIdentificacionC;
    
    @JsonIgnore
    private TipoIdentificacion personaCTNEWptpagrTipoIdentificacionCInstance;

    @JsonProperty("pt_p_agrmunicipiocnac_oid")
    private MunicipioOid personaCTNEWptpagrMunicipioCNac;
    
    @JsonIgnore
    private Municipio personaCTNEWptpagrMunicipioCNacInstance;

    @JsonProperty("pt_p_agrdepartamentocnac_oid")
    private DepartamentoOid personaCTNEWptpagrDepartamentoCNac;
    
    @JsonIgnore
    private Departamento personaCTNEWptpagrDepartamentoCNacInstance;

    @JsonProperty("pt_p_agrcontratosc_oid")
    private ContratoCOid personaCTNEWptpagrContratosC;
    
    @JsonIgnore
    private ContratoC personaCTNEWptpagrContratosCInstance;

    @JsonProperty("pt_p_agrfamiliasc_oid")
    private FamiliaCOid personaCTNEWptpagrFamiliasC;
    
    @JsonIgnore
    private FamiliaC personaCTNEWptpagrFamiliasCInstance;

    @JsonProperty("pt_p_agrbeneficiariosc_oid")
    private BeneficiarioCOid personaCTNEWptpagrBeneficiariosC;
    
    @JsonIgnore
    private BeneficiarioC personaCTNEWptpagrBeneficiariosCInstance;

    @JsonProperty("pt_p_atrnumidentificacion")
    private String personaCTNEWptpatrNumIdentificacion;

    @JsonProperty("pt_p_atrmail")
    private String personaCTNEWptpatrMail;

    @JsonProperty("pt_p_atrprimernombre")
    private String personaCTNEWptpatrPrimerNombre;

    @JsonProperty("pt_p_atrsegundonombre")
    private String personaCTNEWptpatrSegundoNombre;

    @JsonProperty("pt_p_atrprimerapellido")
    private String personaCTNEWptpatrPrimerApellido;

    @JsonProperty("pt_p_atrsegundoapellido")
    private String personaCTNEWptpatrSegundoApellido;

    @JsonProperty("pt_p_atrfechanacimiento")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date personaCTNEWptpatrFechaNacimiento;

    @JsonProperty("pt_p_atrgenero")
    private String personaCTNEWptpatrGenero;

    @JsonProperty("pt_p_atrindicadorextranjero")
    private Boolean personaCTNEWptpatrIndicadorExtranjero;

    @JsonProperty("pt_p_atrrazonsocial")
    private String personaCTNEWptpatrRazonSocial;

    @JsonProperty("pt_p_atrtieneepssanitas")
    private Boolean personaCTNEWptpatrTieneEPSSanitas;

    @JsonProperty("pt_p_atrrechazadoafiliacion")
    private String personaCTNEWptpatrRechazadoAfiliacion;

    @JsonProperty("pt_p_atrnombrecompleto")
    private String personaCTNEWptpatrNombreCompleto;

    @JsonProperty("pt_p_atrcodigo")
    private Long personaCTNEWptpatrCodigo;

    public void checkArguments() throws NotNullArgumentException {
        checkPersonaCTNEWptpagrTipoIdentificacionC();
        checkPersonaCTNEWptpatrNumIdentificacion();
    }

    @JsonIgnore
    public TipoInstitucionCOid getPersonaCTNEWptpagrTipoInstitucionC() {
        return this.personaCTNEWptpagrTipoInstitucionC;
    }
    
    public void setPersonaCTNEWptpagrTipoInstitucionC(TipoInstitucionCOid personaCTNEWptpagrTipoInstitucionC) {
        this.personaCTNEWptpagrTipoInstitucionC = personaCTNEWptpagrTipoInstitucionC;
    }

    @JsonIgnore
    public TipoInstitucionC getPersonaCTNEWptpagrTipoInstitucionCInstance() {
        return this.personaCTNEWptpagrTipoInstitucionCInstance;
    }
    
    public void setPersonaCTNEWptpagrTipoInstitucionCInstance(TipoInstitucionC personaCTNEWptpagrTipoInstitucionC) {
        this.personaCTNEWptpagrTipoInstitucionCInstance = personaCTNEWptpagrTipoInstitucionC;
        this.personaCTNEWptpagrTipoInstitucionC = personaCTNEWptpagrTipoInstitucionC != null ? personaCTNEWptpagrTipoInstitucionC.getOid() : null;
    }

    @JsonIgnore
    public TipoEntidadCOid getPersonaCTNEWptpagrTipoEntidadC() {
        return this.personaCTNEWptpagrTipoEntidadC;
    }
    
    public void setPersonaCTNEWptpagrTipoEntidadC(TipoEntidadCOid personaCTNEWptpagrTipoEntidadC) {
        this.personaCTNEWptpagrTipoEntidadC = personaCTNEWptpagrTipoEntidadC;
    }

    @JsonIgnore
    public TipoEntidadC getPersonaCTNEWptpagrTipoEntidadCInstance() {
        return this.personaCTNEWptpagrTipoEntidadCInstance;
    }
    
    public void setPersonaCTNEWptpagrTipoEntidadCInstance(TipoEntidadC personaCTNEWptpagrTipoEntidadC) {
        this.personaCTNEWptpagrTipoEntidadCInstance = personaCTNEWptpagrTipoEntidadC;
        this.personaCTNEWptpagrTipoEntidadC = personaCTNEWptpagrTipoEntidadC != null ? personaCTNEWptpagrTipoEntidadC.getOid() : null;
    }

    @JsonIgnore
    public EstadoCivilOid getPersonaCTNEWptpagrEstadoCivilC() {
        return this.personaCTNEWptpagrEstadoCivilC;
    }
    
    public void setPersonaCTNEWptpagrEstadoCivilC(EstadoCivilOid personaCTNEWptpagrEstadoCivilC) {
        this.personaCTNEWptpagrEstadoCivilC = personaCTNEWptpagrEstadoCivilC;
    }

    @JsonIgnore
    public EstadoCivil getPersonaCTNEWptpagrEstadoCivilCInstance() {
        return this.personaCTNEWptpagrEstadoCivilCInstance;
    }
    
    public void setPersonaCTNEWptpagrEstadoCivilCInstance(EstadoCivil personaCTNEWptpagrEstadoCivilC) {
        this.personaCTNEWptpagrEstadoCivilCInstance = personaCTNEWptpagrEstadoCivilC;
        this.personaCTNEWptpagrEstadoCivilC = personaCTNEWptpagrEstadoCivilC != null ? personaCTNEWptpagrEstadoCivilC.getOid() : null;
    }

    @JsonIgnore
    public EstadoPersonaOid getPersonaCTNEWptpagrEstadoPersonaC() {
        return this.personaCTNEWptpagrEstadoPersonaC;
    }
    
    public void setPersonaCTNEWptpagrEstadoPersonaC(EstadoPersonaOid personaCTNEWptpagrEstadoPersonaC) {
        this.personaCTNEWptpagrEstadoPersonaC = personaCTNEWptpagrEstadoPersonaC;
    }

    @JsonIgnore
    public EstadoPersona getPersonaCTNEWptpagrEstadoPersonaCInstance() {
        return this.personaCTNEWptpagrEstadoPersonaCInstance;
    }
    
    public void setPersonaCTNEWptpagrEstadoPersonaCInstance(EstadoPersona personaCTNEWptpagrEstadoPersonaC) {
        this.personaCTNEWptpagrEstadoPersonaCInstance = personaCTNEWptpagrEstadoPersonaC;
        this.personaCTNEWptpagrEstadoPersonaC = personaCTNEWptpagrEstadoPersonaC != null ? personaCTNEWptpagrEstadoPersonaC.getOid() : null;
    }

    @JsonIgnore
    public TipoIdentificacionOid getPersonaCTNEWptpagrTipoIdentificacionC() {
        return this.personaCTNEWptpagrTipoIdentificacionC;
    }
    
    public void setPersonaCTNEWptpagrTipoIdentificacionC(TipoIdentificacionOid personaCTNEWptpagrTipoIdentificacionC) {
        this.personaCTNEWptpagrTipoIdentificacionC = personaCTNEWptpagrTipoIdentificacionC;
    }

    @JsonIgnore
    public TipoIdentificacion getPersonaCTNEWptpagrTipoIdentificacionCInstance() {
        return this.personaCTNEWptpagrTipoIdentificacionCInstance;
    }
    
    public void setPersonaCTNEWptpagrTipoIdentificacionCInstance(TipoIdentificacion personaCTNEWptpagrTipoIdentificacionC) {
        this.personaCTNEWptpagrTipoIdentificacionCInstance = personaCTNEWptpagrTipoIdentificacionC;
        this.personaCTNEWptpagrTipoIdentificacionC = personaCTNEWptpagrTipoIdentificacionC != null ? personaCTNEWptpagrTipoIdentificacionC.getOid() : null;
    }

    private void checkPersonaCTNEWptpagrTipoIdentificacionC() throws NotNullArgumentException {
        if(this.getPersonaCTNEWptpagrTipoIdentificacionCInstance() == null || this.getPersonaCTNEWptpagrTipoIdentificacionCInstance().isNull()) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_TNEW, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_TNEW_PERSONACTNEWPTPAGRTIPOIDENTIFICACIONC, PersonaCConstants.SERV_ALIAS_TNEW, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_TNEW_PERSONACTNEWPTPAGRTIPOIDENTIFICACIONC);
        }
    }

    @JsonIgnore
    public MunicipioOid getPersonaCTNEWptpagrMunicipioCNac() {
        return this.personaCTNEWptpagrMunicipioCNac;
    }
    
    public void setPersonaCTNEWptpagrMunicipioCNac(MunicipioOid personaCTNEWptpagrMunicipioCNac) {
        this.personaCTNEWptpagrMunicipioCNac = personaCTNEWptpagrMunicipioCNac;
    }

    @JsonIgnore
    public Municipio getPersonaCTNEWptpagrMunicipioCNacInstance() {
        return this.personaCTNEWptpagrMunicipioCNacInstance;
    }
    
    public void setPersonaCTNEWptpagrMunicipioCNacInstance(Municipio personaCTNEWptpagrMunicipioCNac) {
        this.personaCTNEWptpagrMunicipioCNacInstance = personaCTNEWptpagrMunicipioCNac;
        this.personaCTNEWptpagrMunicipioCNac = personaCTNEWptpagrMunicipioCNac != null ? personaCTNEWptpagrMunicipioCNac.getOid() : null;
    }

    @JsonIgnore
    public DepartamentoOid getPersonaCTNEWptpagrDepartamentoCNac() {
        return this.personaCTNEWptpagrDepartamentoCNac;
    }
    
    public void setPersonaCTNEWptpagrDepartamentoCNac(DepartamentoOid personaCTNEWptpagrDepartamentoCNac) {
        this.personaCTNEWptpagrDepartamentoCNac = personaCTNEWptpagrDepartamentoCNac;
    }

    @JsonIgnore
    public Departamento getPersonaCTNEWptpagrDepartamentoCNacInstance() {
        return this.personaCTNEWptpagrDepartamentoCNacInstance;
    }
    
    public void setPersonaCTNEWptpagrDepartamentoCNacInstance(Departamento personaCTNEWptpagrDepartamentoCNac) {
        this.personaCTNEWptpagrDepartamentoCNacInstance = personaCTNEWptpagrDepartamentoCNac;
        this.personaCTNEWptpagrDepartamentoCNac = personaCTNEWptpagrDepartamentoCNac != null ? personaCTNEWptpagrDepartamentoCNac.getOid() : null;
    }

    @JsonIgnore
    public ContratoCOid getPersonaCTNEWptpagrContratosC() {
        return this.personaCTNEWptpagrContratosC;
    }
    
    public void setPersonaCTNEWptpagrContratosC(ContratoCOid personaCTNEWptpagrContratosC) {
        this.personaCTNEWptpagrContratosC = personaCTNEWptpagrContratosC;
    }

    @JsonIgnore
    public ContratoC getPersonaCTNEWptpagrContratosCInstance() {
        return this.personaCTNEWptpagrContratosCInstance;
    }
    
    public void setPersonaCTNEWptpagrContratosCInstance(ContratoC personaCTNEWptpagrContratosC) {
        this.personaCTNEWptpagrContratosCInstance = personaCTNEWptpagrContratosC;
        this.personaCTNEWptpagrContratosC = personaCTNEWptpagrContratosC != null ? personaCTNEWptpagrContratosC.getOid() : null;
    }

    @JsonIgnore
    public FamiliaCOid getPersonaCTNEWptpagrFamiliasC() {
        return this.personaCTNEWptpagrFamiliasC;
    }
    
    public void setPersonaCTNEWptpagrFamiliasC(FamiliaCOid personaCTNEWptpagrFamiliasC) {
        this.personaCTNEWptpagrFamiliasC = personaCTNEWptpagrFamiliasC;
    }

    @JsonIgnore
    public FamiliaC getPersonaCTNEWptpagrFamiliasCInstance() {
        return this.personaCTNEWptpagrFamiliasCInstance;
    }
    
    public void setPersonaCTNEWptpagrFamiliasCInstance(FamiliaC personaCTNEWptpagrFamiliasC) {
        this.personaCTNEWptpagrFamiliasCInstance = personaCTNEWptpagrFamiliasC;
        this.personaCTNEWptpagrFamiliasC = personaCTNEWptpagrFamiliasC != null ? personaCTNEWptpagrFamiliasC.getOid() : null;
    }

    @JsonIgnore
    public BeneficiarioCOid getPersonaCTNEWptpagrBeneficiariosC() {
        return this.personaCTNEWptpagrBeneficiariosC;
    }
    
    public void setPersonaCTNEWptpagrBeneficiariosC(BeneficiarioCOid personaCTNEWptpagrBeneficiariosC) {
        this.personaCTNEWptpagrBeneficiariosC = personaCTNEWptpagrBeneficiariosC;
    }

    @JsonIgnore
    public BeneficiarioC getPersonaCTNEWptpagrBeneficiariosCInstance() {
        return this.personaCTNEWptpagrBeneficiariosCInstance;
    }
    
    public void setPersonaCTNEWptpagrBeneficiariosCInstance(BeneficiarioC personaCTNEWptpagrBeneficiariosC) {
        this.personaCTNEWptpagrBeneficiariosCInstance = personaCTNEWptpagrBeneficiariosC;
        this.personaCTNEWptpagrBeneficiariosC = personaCTNEWptpagrBeneficiariosC != null ? personaCTNEWptpagrBeneficiariosC.getOid() : null;
    }

    @JsonIgnore
    public String getPersonaCTNEWptpatrNumIdentificacion() {
        return this.personaCTNEWptpatrNumIdentificacion;
    }
    
    public void setPersonaCTNEWptpatrNumIdentificacion(String personaCTNEWptpatrNumIdentificacion) {
        this.personaCTNEWptpatrNumIdentificacion = personaCTNEWptpatrNumIdentificacion;
    }

    private void checkPersonaCTNEWptpatrNumIdentificacion() throws NotNullArgumentException {
        if(this.getPersonaCTNEWptpatrNumIdentificacion() == null) {
            throw new NotNullArgumentException(PersonaCConstants.SERV_ID_TNEW, PersonaCConstants.CLASS_ID, PersonaCConstants.ARG_ID_TNEW_PERSONACTNEWPTPATRNUMIDENTIFICACION, PersonaCConstants.SERV_ALIAS_TNEW, PersonaCConstants.CLASS_ALIAS, PersonaCConstants.ARG_ALIAS_TNEW_PERSONACTNEWPTPATRNUMIDENTIFICACION);
        }
    }

    @JsonIgnore
    public String getPersonaCTNEWptpatrMail() {
        return this.personaCTNEWptpatrMail;
    }
    
    public void setPersonaCTNEWptpatrMail(String personaCTNEWptpatrMail) {
        this.personaCTNEWptpatrMail = personaCTNEWptpatrMail;
    }

    @JsonIgnore
    public String getPersonaCTNEWptpatrPrimerNombre() {
        return this.personaCTNEWptpatrPrimerNombre;
    }
    
    public void setPersonaCTNEWptpatrPrimerNombre(String personaCTNEWptpatrPrimerNombre) {
        this.personaCTNEWptpatrPrimerNombre = personaCTNEWptpatrPrimerNombre;
    }

    @JsonIgnore
    public String getPersonaCTNEWptpatrSegundoNombre() {
        return this.personaCTNEWptpatrSegundoNombre;
    }
    
    public void setPersonaCTNEWptpatrSegundoNombre(String personaCTNEWptpatrSegundoNombre) {
        this.personaCTNEWptpatrSegundoNombre = personaCTNEWptpatrSegundoNombre;
    }

    @JsonIgnore
    public String getPersonaCTNEWptpatrPrimerApellido() {
        return this.personaCTNEWptpatrPrimerApellido;
    }
    
    public void setPersonaCTNEWptpatrPrimerApellido(String personaCTNEWptpatrPrimerApellido) {
        this.personaCTNEWptpatrPrimerApellido = personaCTNEWptpatrPrimerApellido;
    }

    @JsonIgnore
    public String getPersonaCTNEWptpatrSegundoApellido() {
        return this.personaCTNEWptpatrSegundoApellido;
    }
    
    public void setPersonaCTNEWptpatrSegundoApellido(String personaCTNEWptpatrSegundoApellido) {
        this.personaCTNEWptpatrSegundoApellido = personaCTNEWptpatrSegundoApellido;
    }

    @JsonIgnore
    public Date getPersonaCTNEWptpatrFechaNacimiento() {
        return this.personaCTNEWptpatrFechaNacimiento;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setPersonaCTNEWptpatrFechaNacimiento(Date personaCTNEWptpatrFechaNacimiento) {
        this.personaCTNEWptpatrFechaNacimiento = personaCTNEWptpatrFechaNacimiento;
    }

    @JsonIgnore
    public String getPersonaCTNEWptpatrGenero() {
        return this.personaCTNEWptpatrGenero;
    }
    
    public void setPersonaCTNEWptpatrGenero(String personaCTNEWptpatrGenero) {
        this.personaCTNEWptpatrGenero = personaCTNEWptpatrGenero;
    }

    @JsonIgnore
    public Boolean getPersonaCTNEWptpatrIndicadorExtranjero() {
        return this.personaCTNEWptpatrIndicadorExtranjero;
    }
    
    public void setPersonaCTNEWptpatrIndicadorExtranjero(Boolean personaCTNEWptpatrIndicadorExtranjero) {
        this.personaCTNEWptpatrIndicadorExtranjero = personaCTNEWptpatrIndicadorExtranjero;
    }

    @JsonIgnore
    public String getPersonaCTNEWptpatrRazonSocial() {
        return this.personaCTNEWptpatrRazonSocial;
    }
    
    public void setPersonaCTNEWptpatrRazonSocial(String personaCTNEWptpatrRazonSocial) {
        this.personaCTNEWptpatrRazonSocial = personaCTNEWptpatrRazonSocial;
    }

    @JsonIgnore
    public Boolean getPersonaCTNEWptpatrTieneEPSSanitas() {
        return this.personaCTNEWptpatrTieneEPSSanitas;
    }
    
    public void setPersonaCTNEWptpatrTieneEPSSanitas(Boolean personaCTNEWptpatrTieneEPSSanitas) {
        this.personaCTNEWptpatrTieneEPSSanitas = personaCTNEWptpatrTieneEPSSanitas;
    }

    @JsonIgnore
    public String getPersonaCTNEWptpatrRechazadoAfiliacion() {
        return this.personaCTNEWptpatrRechazadoAfiliacion;
    }
    
    public void setPersonaCTNEWptpatrRechazadoAfiliacion(String personaCTNEWptpatrRechazadoAfiliacion) {
        this.personaCTNEWptpatrRechazadoAfiliacion = personaCTNEWptpatrRechazadoAfiliacion;
    }

    @JsonIgnore
    public String getPersonaCTNEWptpatrNombreCompleto() {
        return this.personaCTNEWptpatrNombreCompleto;
    }
    
    public void setPersonaCTNEWptpatrNombreCompleto(String personaCTNEWptpatrNombreCompleto) {
        this.personaCTNEWptpatrNombreCompleto = personaCTNEWptpatrNombreCompleto;
    }

    @JsonIgnore
    public Long getPersonaCTNEWptpatrCodigo() {
        return this.personaCTNEWptpatrCodigo;
    }
    
    public void setPersonaCTNEWptpatrCodigo(Long personaCTNEWptpatrCodigo) {
        this.personaCTNEWptpatrCodigo = personaCTNEWptpatrCodigo;
    }
}
