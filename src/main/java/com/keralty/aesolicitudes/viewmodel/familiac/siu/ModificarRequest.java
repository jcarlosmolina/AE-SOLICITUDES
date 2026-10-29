package com.keralty.aesolicitudes.viewmodel.familiac.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.FamiliaCConstants;
import com.keralty.aesolicitudes.persistence.FamiliaC;
import com.keralty.aesolicitudes.persistence.oid.FamiliaCOid;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class ModificarRequest {

    @JsonProperty("p_thisfamiliac_oid")
    private FamiliaCOid familiaCmodificarpthisFamiliaC;
    
    @JsonIgnore
    private FamiliaC familiaCmodificarpthisFamiliaCInstance;

    @JsonProperty("p_estadotitularfamilia")
    private String familiaCmodificarpEstadoTitularFamilia;

    @JsonProperty("p_fechafinvigencia")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date familiaCmodificarpFechaFinVigencia;

    @JsonProperty("p_direccioncorrespondencia")
    private String familiaCmodificarpdireccionCorrespondencia;

    @JsonProperty("p_numfamilia")
    private String familiaCmodificarpNumFamilia;

    @JsonProperty("p_titularconbeneficios")
    private Boolean familiaCmodificarpTitularConBeneficios;

    public void checkArguments() throws NotNullArgumentException {
        checkFamiliaCmodificarpthisFamiliaC();
    }

    @JsonIgnore
    public FamiliaCOid getFamiliaCmodificarpthisFamiliaC() {
        return this.familiaCmodificarpthisFamiliaC;
    }
    
    public void setFamiliaCmodificarpthisFamiliaC(FamiliaCOid familiaCmodificarpthisFamiliaC) {
        this.familiaCmodificarpthisFamiliaC = familiaCmodificarpthisFamiliaC;
    }

    @JsonIgnore
    public FamiliaC getFamiliaCmodificarpthisFamiliaCInstance() {
        return this.familiaCmodificarpthisFamiliaCInstance;
    }
    
    public void setFamiliaCmodificarpthisFamiliaCInstance(FamiliaC familiaCmodificarpthisFamiliaC) {
        this.familiaCmodificarpthisFamiliaCInstance = familiaCmodificarpthisFamiliaC;
        this.familiaCmodificarpthisFamiliaC = familiaCmodificarpthisFamiliaC != null ? familiaCmodificarpthisFamiliaC.getOid() : null;
    }

    private void checkFamiliaCmodificarpthisFamiliaC() throws NotNullArgumentException {
        if(this.getFamiliaCmodificarpthisFamiliaCInstance() == null || this.getFamiliaCmodificarpthisFamiliaCInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaCConstants.SERV_ID_MODIFICAR, FamiliaCConstants.CLASS_ID, FamiliaCConstants.ARG_ID_MODIFICAR_FAMILIACMODIFICARPTHISFAMILIAC, FamiliaCConstants.SERV_ALIAS_MODIFICAR, FamiliaCConstants.CLASS_ALIAS, FamiliaCConstants.ARG_ALIAS_MODIFICAR_FAMILIACMODIFICARPTHISFAMILIAC);
        }
    }

    @JsonIgnore
    public String getFamiliaCmodificarpEstadoTitularFamilia() {
        return this.familiaCmodificarpEstadoTitularFamilia;
    }
    
    public void setFamiliaCmodificarpEstadoTitularFamilia(String familiaCmodificarpEstadoTitularFamilia) {
        this.familiaCmodificarpEstadoTitularFamilia = familiaCmodificarpEstadoTitularFamilia;
    }

    @JsonIgnore
    public Date getFamiliaCmodificarpFechaFinVigencia() {
        return this.familiaCmodificarpFechaFinVigencia;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setFamiliaCmodificarpFechaFinVigencia(Date familiaCmodificarpFechaFinVigencia) {
        this.familiaCmodificarpFechaFinVigencia = familiaCmodificarpFechaFinVigencia;
    }

    @JsonIgnore
    public String getFamiliaCmodificarpdireccionCorrespondencia() {
        return this.familiaCmodificarpdireccionCorrespondencia;
    }
    
    public void setFamiliaCmodificarpdireccionCorrespondencia(String familiaCmodificarpdireccionCorrespondencia) {
        this.familiaCmodificarpdireccionCorrespondencia = familiaCmodificarpdireccionCorrespondencia;
    }

    @JsonIgnore
    public String getFamiliaCmodificarpNumFamilia() {
        return this.familiaCmodificarpNumFamilia;
    }
    
    public void setFamiliaCmodificarpNumFamilia(String familiaCmodificarpNumFamilia) {
        this.familiaCmodificarpNumFamilia = familiaCmodificarpNumFamilia;
    }

    @JsonIgnore
    public Boolean getFamiliaCmodificarpTitularConBeneficios() {
        return this.familiaCmodificarpTitularConBeneficios;
    }
    
    public void setFamiliaCmodificarpTitularConBeneficios(Boolean familiaCmodificarpTitularConBeneficios) {
        this.familiaCmodificarpTitularConBeneficios = familiaCmodificarpTitularConBeneficios;
    }
}
