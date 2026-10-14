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

public class CrearRequest {

    @JsonProperty("p_agrtipodireccionc_oid")
    private TipoDireccionOid direccionCcrearpagrTipoDireccionC;
    
    @JsonIgnore
    private TipoDireccion direccionCcrearpagrTipoDireccionCInstance;

    @JsonProperty("p_agrdepartamentoc_oid")
    private DepartamentoOid direccionCcrearpagrDepartamentoC;
    
    @JsonIgnore
    private Departamento direccionCcrearpagrDepartamentoCInstance;

    @JsonProperty("p_agrmunicipioc_oid")
    private MunicipioOid direccionCcrearpagrMunicipioC;
    
    @JsonIgnore
    private Municipio direccionCcrearpagrMunicipioCInstance;

    @JsonProperty("p_agrpaisc_oid")
    private PaisOid direccionCcrearpagrPaisC;
    
    @JsonIgnore
    private Pais direccionCcrearpagrPaisCInstance;

    @JsonProperty("p_agrcontratoc_oid")
    private ContratoCOid direccionCcrearpagrContratoC;
    
    @JsonIgnore
    private ContratoC direccionCcrearpagrContratoCInstance;

    @JsonProperty("p_agrpersonac_oid")
    private PersonaCOid direccionCcrearpagrPersonaC;
    
    @JsonIgnore
    private PersonaC direccionCcrearpagrPersonaCInstance;

    @JsonProperty("p_atrdireccioncompleta")
    private String direccionCcrearpatrDireccionCompleta;

    @JsonProperty("p_atrlocalidad")
    private String direccionCcrearpatrLocalidad;

    @JsonIgnore
    public TipoDireccionOid getDireccionCcrearpagrTipoDireccionC() {
        return this.direccionCcrearpagrTipoDireccionC;
    }
    
    public void setDireccionCcrearpagrTipoDireccionC(TipoDireccionOid direccionCcrearpagrTipoDireccionC) {
        this.direccionCcrearpagrTipoDireccionC = direccionCcrearpagrTipoDireccionC;
    }

    @JsonIgnore
    public TipoDireccion getDireccionCcrearpagrTipoDireccionCInstance() {
        return this.direccionCcrearpagrTipoDireccionCInstance;
    }
    
    public void setDireccionCcrearpagrTipoDireccionCInstance(TipoDireccion direccionCcrearpagrTipoDireccionC) {
        this.direccionCcrearpagrTipoDireccionCInstance = direccionCcrearpagrTipoDireccionC;
        this.direccionCcrearpagrTipoDireccionC = direccionCcrearpagrTipoDireccionC != null ? direccionCcrearpagrTipoDireccionC.getOid() : null;
    }

    @JsonIgnore
    public DepartamentoOid getDireccionCcrearpagrDepartamentoC() {
        return this.direccionCcrearpagrDepartamentoC;
    }
    
    public void setDireccionCcrearpagrDepartamentoC(DepartamentoOid direccionCcrearpagrDepartamentoC) {
        this.direccionCcrearpagrDepartamentoC = direccionCcrearpagrDepartamentoC;
    }

    @JsonIgnore
    public Departamento getDireccionCcrearpagrDepartamentoCInstance() {
        return this.direccionCcrearpagrDepartamentoCInstance;
    }
    
    public void setDireccionCcrearpagrDepartamentoCInstance(Departamento direccionCcrearpagrDepartamentoC) {
        this.direccionCcrearpagrDepartamentoCInstance = direccionCcrearpagrDepartamentoC;
        this.direccionCcrearpagrDepartamentoC = direccionCcrearpagrDepartamentoC != null ? direccionCcrearpagrDepartamentoC.getOid() : null;
    }

    @JsonIgnore
    public MunicipioOid getDireccionCcrearpagrMunicipioC() {
        return this.direccionCcrearpagrMunicipioC;
    }
    
    public void setDireccionCcrearpagrMunicipioC(MunicipioOid direccionCcrearpagrMunicipioC) {
        this.direccionCcrearpagrMunicipioC = direccionCcrearpagrMunicipioC;
    }

    @JsonIgnore
    public Municipio getDireccionCcrearpagrMunicipioCInstance() {
        return this.direccionCcrearpagrMunicipioCInstance;
    }
    
    public void setDireccionCcrearpagrMunicipioCInstance(Municipio direccionCcrearpagrMunicipioC) {
        this.direccionCcrearpagrMunicipioCInstance = direccionCcrearpagrMunicipioC;
        this.direccionCcrearpagrMunicipioC = direccionCcrearpagrMunicipioC != null ? direccionCcrearpagrMunicipioC.getOid() : null;
    }

    @JsonIgnore
    public PaisOid getDireccionCcrearpagrPaisC() {
        return this.direccionCcrearpagrPaisC;
    }
    
    public void setDireccionCcrearpagrPaisC(PaisOid direccionCcrearpagrPaisC) {
        this.direccionCcrearpagrPaisC = direccionCcrearpagrPaisC;
    }

    @JsonIgnore
    public Pais getDireccionCcrearpagrPaisCInstance() {
        return this.direccionCcrearpagrPaisCInstance;
    }
    
    public void setDireccionCcrearpagrPaisCInstance(Pais direccionCcrearpagrPaisC) {
        this.direccionCcrearpagrPaisCInstance = direccionCcrearpagrPaisC;
        this.direccionCcrearpagrPaisC = direccionCcrearpagrPaisC != null ? direccionCcrearpagrPaisC.getOid() : null;
    }

    @JsonIgnore
    public ContratoCOid getDireccionCcrearpagrContratoC() {
        return this.direccionCcrearpagrContratoC;
    }
    
    public void setDireccionCcrearpagrContratoC(ContratoCOid direccionCcrearpagrContratoC) {
        this.direccionCcrearpagrContratoC = direccionCcrearpagrContratoC;
    }

    @JsonIgnore
    public ContratoC getDireccionCcrearpagrContratoCInstance() {
        return this.direccionCcrearpagrContratoCInstance;
    }
    
    public void setDireccionCcrearpagrContratoCInstance(ContratoC direccionCcrearpagrContratoC) {
        this.direccionCcrearpagrContratoCInstance = direccionCcrearpagrContratoC;
        this.direccionCcrearpagrContratoC = direccionCcrearpagrContratoC != null ? direccionCcrearpagrContratoC.getOid() : null;
    }

    @JsonIgnore
    public PersonaCOid getDireccionCcrearpagrPersonaC() {
        return this.direccionCcrearpagrPersonaC;
    }
    
    public void setDireccionCcrearpagrPersonaC(PersonaCOid direccionCcrearpagrPersonaC) {
        this.direccionCcrearpagrPersonaC = direccionCcrearpagrPersonaC;
    }

    @JsonIgnore
    public PersonaC getDireccionCcrearpagrPersonaCInstance() {
        return this.direccionCcrearpagrPersonaCInstance;
    }
    
    public void setDireccionCcrearpagrPersonaCInstance(PersonaC direccionCcrearpagrPersonaC) {
        this.direccionCcrearpagrPersonaCInstance = direccionCcrearpagrPersonaC;
        this.direccionCcrearpagrPersonaC = direccionCcrearpagrPersonaC != null ? direccionCcrearpagrPersonaC.getOid() : null;
    }

    @JsonIgnore
    public String getDireccionCcrearpatrDireccionCompleta() {
        return this.direccionCcrearpatrDireccionCompleta;
    }
    
    public void setDireccionCcrearpatrDireccionCompleta(String direccionCcrearpatrDireccionCompleta) {
        this.direccionCcrearpatrDireccionCompleta = direccionCcrearpatrDireccionCompleta;
    }

    @JsonIgnore
    public String getDireccionCcrearpatrLocalidad() {
        return this.direccionCcrearpatrLocalidad;
    }
    
    public void setDireccionCcrearpatrLocalidad(String direccionCcrearpatrLocalidad) {
        this.direccionCcrearpatrLocalidad = direccionCcrearpatrLocalidad;
    }
}
