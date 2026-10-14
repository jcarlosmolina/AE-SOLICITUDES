package com.keralty.aesolicitudes.viewmodel.direccionc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.Departamento;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.DepartamentoOid;
import com.keralty.aesolicitudes.persistence.oid.MunicipioOid;
import com.keralty.aesolicitudes.persistence.oid.PaisOid;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.oid.TipoDireccionOid;
import com.keralty.aesolicitudes.persistence.Pais;
import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.TipoDireccion;

public class TCREARRequest {

    @JsonProperty("p_agrdepartamentoc_oid")
    private DepartamentoOid direccionCTCREARpagrDepartamentoC;
    
    @JsonIgnore
    private Departamento direccionCTCREARpagrDepartamentoCInstance;

    @JsonProperty("p_agrmunicipioc_oid")
    private MunicipioOid direccionCTCREARpagrMunicipioC;
    
    @JsonIgnore
    private Municipio direccionCTCREARpagrMunicipioCInstance;

    @JsonProperty("p_agrtipodireccionc_oid")
    private TipoDireccionOid direccionCTCREARpagrTipoDireccionC;
    
    @JsonIgnore
    private TipoDireccion direccionCTCREARpagrTipoDireccionCInstance;

    @JsonProperty("p_agrpaisc_oid")
    private PaisOid direccionCTCREARpagrPaisC;
    
    @JsonIgnore
    private Pais direccionCTCREARpagrPaisCInstance;

    @JsonProperty("p_agrpersonac_oid")
    private PersonaCOid direccionCTCREARpagrPersonaC;
    
    @JsonIgnore
    private PersonaC direccionCTCREARpagrPersonaCInstance;

    @JsonProperty("p_atrdireccioncompleta")
    private String direccionCTCREARpatrDireccionCompleta;

    @JsonProperty("p_atrlocalidad")
    private String direccionCTCREARpatrLocalidad;

    @JsonProperty("ptelefonofijo")
    private String direccionCTCREARpTelefonoFijo;

    @JsonProperty("ptelefonocelular")
    private String direccionCTCREARpTelefonoCelular;

    @JsonProperty("p_agrcontratoc_oid")
    private ContratoCOid direccionCTCREARpagrContratoC;
    
    @JsonIgnore
    private ContratoC direccionCTCREARpagrContratoCInstance;

    @JsonIgnore
    public DepartamentoOid getDireccionCTCREARpagrDepartamentoC() {
        return this.direccionCTCREARpagrDepartamentoC;
    }
    
    public void setDireccionCTCREARpagrDepartamentoC(DepartamentoOid direccionCTCREARpagrDepartamentoC) {
        this.direccionCTCREARpagrDepartamentoC = direccionCTCREARpagrDepartamentoC;
    }

    @JsonIgnore
    public Departamento getDireccionCTCREARpagrDepartamentoCInstance() {
        return this.direccionCTCREARpagrDepartamentoCInstance;
    }
    
    public void setDireccionCTCREARpagrDepartamentoCInstance(Departamento direccionCTCREARpagrDepartamentoC) {
        this.direccionCTCREARpagrDepartamentoCInstance = direccionCTCREARpagrDepartamentoC;
        this.direccionCTCREARpagrDepartamentoC = direccionCTCREARpagrDepartamentoC != null ? direccionCTCREARpagrDepartamentoC.getOid() : null;
    }

    @JsonIgnore
    public MunicipioOid getDireccionCTCREARpagrMunicipioC() {
        return this.direccionCTCREARpagrMunicipioC;
    }
    
    public void setDireccionCTCREARpagrMunicipioC(MunicipioOid direccionCTCREARpagrMunicipioC) {
        this.direccionCTCREARpagrMunicipioC = direccionCTCREARpagrMunicipioC;
    }

    @JsonIgnore
    public Municipio getDireccionCTCREARpagrMunicipioCInstance() {
        return this.direccionCTCREARpagrMunicipioCInstance;
    }
    
    public void setDireccionCTCREARpagrMunicipioCInstance(Municipio direccionCTCREARpagrMunicipioC) {
        this.direccionCTCREARpagrMunicipioCInstance = direccionCTCREARpagrMunicipioC;
        this.direccionCTCREARpagrMunicipioC = direccionCTCREARpagrMunicipioC != null ? direccionCTCREARpagrMunicipioC.getOid() : null;
    }

    @JsonIgnore
    public TipoDireccionOid getDireccionCTCREARpagrTipoDireccionC() {
        return this.direccionCTCREARpagrTipoDireccionC;
    }
    
    public void setDireccionCTCREARpagrTipoDireccionC(TipoDireccionOid direccionCTCREARpagrTipoDireccionC) {
        this.direccionCTCREARpagrTipoDireccionC = direccionCTCREARpagrTipoDireccionC;
    }

    @JsonIgnore
    public TipoDireccion getDireccionCTCREARpagrTipoDireccionCInstance() {
        return this.direccionCTCREARpagrTipoDireccionCInstance;
    }
    
    public void setDireccionCTCREARpagrTipoDireccionCInstance(TipoDireccion direccionCTCREARpagrTipoDireccionC) {
        this.direccionCTCREARpagrTipoDireccionCInstance = direccionCTCREARpagrTipoDireccionC;
        this.direccionCTCREARpagrTipoDireccionC = direccionCTCREARpagrTipoDireccionC != null ? direccionCTCREARpagrTipoDireccionC.getOid() : null;
    }

    @JsonIgnore
    public PaisOid getDireccionCTCREARpagrPaisC() {
        return this.direccionCTCREARpagrPaisC;
    }
    
    public void setDireccionCTCREARpagrPaisC(PaisOid direccionCTCREARpagrPaisC) {
        this.direccionCTCREARpagrPaisC = direccionCTCREARpagrPaisC;
    }

    @JsonIgnore
    public Pais getDireccionCTCREARpagrPaisCInstance() {
        return this.direccionCTCREARpagrPaisCInstance;
    }
    
    public void setDireccionCTCREARpagrPaisCInstance(Pais direccionCTCREARpagrPaisC) {
        this.direccionCTCREARpagrPaisCInstance = direccionCTCREARpagrPaisC;
        this.direccionCTCREARpagrPaisC = direccionCTCREARpagrPaisC != null ? direccionCTCREARpagrPaisC.getOid() : null;
    }

    @JsonIgnore
    public PersonaCOid getDireccionCTCREARpagrPersonaC() {
        return this.direccionCTCREARpagrPersonaC;
    }
    
    public void setDireccionCTCREARpagrPersonaC(PersonaCOid direccionCTCREARpagrPersonaC) {
        this.direccionCTCREARpagrPersonaC = direccionCTCREARpagrPersonaC;
    }

    @JsonIgnore
    public PersonaC getDireccionCTCREARpagrPersonaCInstance() {
        return this.direccionCTCREARpagrPersonaCInstance;
    }
    
    public void setDireccionCTCREARpagrPersonaCInstance(PersonaC direccionCTCREARpagrPersonaC) {
        this.direccionCTCREARpagrPersonaCInstance = direccionCTCREARpagrPersonaC;
        this.direccionCTCREARpagrPersonaC = direccionCTCREARpagrPersonaC != null ? direccionCTCREARpagrPersonaC.getOid() : null;
    }

    @JsonIgnore
    public String getDireccionCTCREARpatrDireccionCompleta() {
        return this.direccionCTCREARpatrDireccionCompleta;
    }
    
    public void setDireccionCTCREARpatrDireccionCompleta(String direccionCTCREARpatrDireccionCompleta) {
        this.direccionCTCREARpatrDireccionCompleta = direccionCTCREARpatrDireccionCompleta;
    }

    @JsonIgnore
    public String getDireccionCTCREARpatrLocalidad() {
        return this.direccionCTCREARpatrLocalidad;
    }
    
    public void setDireccionCTCREARpatrLocalidad(String direccionCTCREARpatrLocalidad) {
        this.direccionCTCREARpatrLocalidad = direccionCTCREARpatrLocalidad;
    }

    @JsonIgnore
    public String getDireccionCTCREARpTelefonoFijo() {
        return this.direccionCTCREARpTelefonoFijo;
    }
    
    public void setDireccionCTCREARpTelefonoFijo(String direccionCTCREARpTelefonoFijo) {
        this.direccionCTCREARpTelefonoFijo = direccionCTCREARpTelefonoFijo;
    }

    @JsonIgnore
    public String getDireccionCTCREARpTelefonoCelular() {
        return this.direccionCTCREARpTelefonoCelular;
    }
    
    public void setDireccionCTCREARpTelefonoCelular(String direccionCTCREARpTelefonoCelular) {
        this.direccionCTCREARpTelefonoCelular = direccionCTCREARpTelefonoCelular;
    }

    @JsonIgnore
    public ContratoCOid getDireccionCTCREARpagrContratoC() {
        return this.direccionCTCREARpagrContratoC;
    }
    
    public void setDireccionCTCREARpagrContratoC(ContratoCOid direccionCTCREARpagrContratoC) {
        this.direccionCTCREARpagrContratoC = direccionCTCREARpagrContratoC;
    }

    @JsonIgnore
    public ContratoC getDireccionCTCREARpagrContratoCInstance() {
        return this.direccionCTCREARpagrContratoCInstance;
    }
    
    public void setDireccionCTCREARpagrContratoCInstance(ContratoC direccionCTCREARpagrContratoC) {
        this.direccionCTCREARpagrContratoCInstance = direccionCTCREARpagrContratoC;
        this.direccionCTCREARpagrContratoC = direccionCTCREARpagrContratoC != null ? direccionCTCREARpagrContratoC.getOid() : null;
    }
}
