package com.keralty.aesolicitudes.viewmodel.familiac.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.FamiliaCConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.persistence.oid.MunicipioOid;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class CrearRequest {

    @JsonProperty("p_agrpersonactitular_oid")
    private PersonaCOid familiaCcrearpagrPersonaCTitular;
    
    @JsonIgnore
    private PersonaC familiaCcrearpagrPersonaCTitularInstance;

    @JsonProperty("p_agrcontratoc_oid")
    private ContratoCOid familiaCcrearpagrContratoC;
    
    @JsonIgnore
    private ContratoC familiaCcrearpagrContratoCInstance;

    @JsonProperty("p_agrmunicipioc_oid")
    private MunicipioOid familiaCcrearpagrMunicipioC;
    
    @JsonIgnore
    private Municipio familiaCcrearpagrMunicipioCInstance;

    @JsonProperty("p_atrtitularconbeneficios")
    private Boolean familiaCcrearpatrTitularConBeneficios;

    @JsonProperty("p_atrdireccioncorrespondencia")
    private String familiaCcrearpatrdireccionCorrespondencia;

    @JsonProperty("p_atrestadotitularfamilia")
    private String familiaCcrearpatrEstadoTitularFamilia;

    @JsonProperty("p_atrfechafinvigencia")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date familiaCcrearpatrFechaFinVigencia;

    @JsonProperty("p_atrnumfamilia")
    private String familiaCcrearpatrNumFamilia;

    public void checkArguments() throws NotNullArgumentException {
        checkFamiliaCcrearpagrContratoC();
    }

    @JsonIgnore
    public PersonaCOid getFamiliaCcrearpagrPersonaCTitular() {
        return this.familiaCcrearpagrPersonaCTitular;
    }
    
    public void setFamiliaCcrearpagrPersonaCTitular(PersonaCOid familiaCcrearpagrPersonaCTitular) {
        this.familiaCcrearpagrPersonaCTitular = familiaCcrearpagrPersonaCTitular;
    }

    @JsonIgnore
    public PersonaC getFamiliaCcrearpagrPersonaCTitularInstance() {
        return this.familiaCcrearpagrPersonaCTitularInstance;
    }
    
    public void setFamiliaCcrearpagrPersonaCTitularInstance(PersonaC familiaCcrearpagrPersonaCTitular) {
        this.familiaCcrearpagrPersonaCTitularInstance = familiaCcrearpagrPersonaCTitular;
        this.familiaCcrearpagrPersonaCTitular = familiaCcrearpagrPersonaCTitular != null ? familiaCcrearpagrPersonaCTitular.getOid() : null;
    }

    @JsonIgnore
    public ContratoCOid getFamiliaCcrearpagrContratoC() {
        return this.familiaCcrearpagrContratoC;
    }
    
    public void setFamiliaCcrearpagrContratoC(ContratoCOid familiaCcrearpagrContratoC) {
        this.familiaCcrearpagrContratoC = familiaCcrearpagrContratoC;
    }

    @JsonIgnore
    public ContratoC getFamiliaCcrearpagrContratoCInstance() {
        return this.familiaCcrearpagrContratoCInstance;
    }
    
    public void setFamiliaCcrearpagrContratoCInstance(ContratoC familiaCcrearpagrContratoC) {
        this.familiaCcrearpagrContratoCInstance = familiaCcrearpagrContratoC;
        this.familiaCcrearpagrContratoC = familiaCcrearpagrContratoC != null ? familiaCcrearpagrContratoC.getOid() : null;
    }

    private void checkFamiliaCcrearpagrContratoC() throws NotNullArgumentException {
        if(this.getFamiliaCcrearpagrContratoCInstance() == null || this.getFamiliaCcrearpagrContratoCInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaCConstants.SERV_ID_CREAR, FamiliaCConstants.CLASS_ID, FamiliaCConstants.ARG_ID_CREAR_FAMILIACCREARPAGRCONTRATOC, FamiliaCConstants.SERV_ALIAS_CREAR, FamiliaCConstants.CLASS_ALIAS, FamiliaCConstants.ARG_ALIAS_CREAR_FAMILIACCREARPAGRCONTRATOC);
        }
    }

    @JsonIgnore
    public MunicipioOid getFamiliaCcrearpagrMunicipioC() {
        return this.familiaCcrearpagrMunicipioC;
    }
    
    public void setFamiliaCcrearpagrMunicipioC(MunicipioOid familiaCcrearpagrMunicipioC) {
        this.familiaCcrearpagrMunicipioC = familiaCcrearpagrMunicipioC;
    }

    @JsonIgnore
    public Municipio getFamiliaCcrearpagrMunicipioCInstance() {
        return this.familiaCcrearpagrMunicipioCInstance;
    }
    
    public void setFamiliaCcrearpagrMunicipioCInstance(Municipio familiaCcrearpagrMunicipioC) {
        this.familiaCcrearpagrMunicipioCInstance = familiaCcrearpagrMunicipioC;
        this.familiaCcrearpagrMunicipioC = familiaCcrearpagrMunicipioC != null ? familiaCcrearpagrMunicipioC.getOid() : null;
    }

    @JsonIgnore
    public Boolean getFamiliaCcrearpatrTitularConBeneficios() {
        return this.familiaCcrearpatrTitularConBeneficios;
    }
    
    public void setFamiliaCcrearpatrTitularConBeneficios(Boolean familiaCcrearpatrTitularConBeneficios) {
        this.familiaCcrearpatrTitularConBeneficios = familiaCcrearpatrTitularConBeneficios;
    }

    @JsonIgnore
    public String getFamiliaCcrearpatrdireccionCorrespondencia() {
        return this.familiaCcrearpatrdireccionCorrespondencia;
    }
    
    public void setFamiliaCcrearpatrdireccionCorrespondencia(String familiaCcrearpatrdireccionCorrespondencia) {
        this.familiaCcrearpatrdireccionCorrespondencia = familiaCcrearpatrdireccionCorrespondencia;
    }

    @JsonIgnore
    public String getFamiliaCcrearpatrEstadoTitularFamilia() {
        return this.familiaCcrearpatrEstadoTitularFamilia;
    }
    
    public void setFamiliaCcrearpatrEstadoTitularFamilia(String familiaCcrearpatrEstadoTitularFamilia) {
        this.familiaCcrearpatrEstadoTitularFamilia = familiaCcrearpatrEstadoTitularFamilia;
    }

    @JsonIgnore
    public Date getFamiliaCcrearpatrFechaFinVigencia() {
        return this.familiaCcrearpatrFechaFinVigencia;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setFamiliaCcrearpatrFechaFinVigencia(Date familiaCcrearpatrFechaFinVigencia) {
        this.familiaCcrearpatrFechaFinVigencia = familiaCcrearpatrFechaFinVigencia;
    }

    @JsonIgnore
    public String getFamiliaCcrearpatrNumFamilia() {
        return this.familiaCcrearpatrNumFamilia;
    }
    
    public void setFamiliaCcrearpatrNumFamilia(String familiaCcrearpatrNumFamilia) {
        this.familiaCcrearpatrNumFamilia = familiaCcrearpatrNumFamilia;
    }
}
