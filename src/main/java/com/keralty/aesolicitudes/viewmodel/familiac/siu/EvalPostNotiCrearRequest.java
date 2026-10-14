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

public class EvalPostNotiCrearRequest {

    @JsonProperty("p_thisfamiliac_oid")
    private FamiliaCOid familiaCevalPostNotiCrearpthisFamiliaC;
    
    @JsonIgnore
    private FamiliaC familiaCevalPostNotiCrearpthisFamiliaCInstance;

    @JsonProperty("penumfamilia")
    private String familiaCevalPostNotiCrearpeNumFamilia;

    @JsonProperty("pefechafinvigencia")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date familiaCevalPostNotiCrearpeFechaFinVigencia;

    @JsonProperty("pedircorresp")
    private String familiaCevalPostNotiCrearpeDirCorresp;

    public void checkArguments() throws NotNullArgumentException {
        checkFamiliaCevalPostNotiCrearpthisFamiliaC();
        checkFamiliaCevalPostNotiCrearpeNumFamilia();
    }

    @JsonIgnore
    public FamiliaCOid getFamiliaCevalPostNotiCrearpthisFamiliaC() {
        return this.familiaCevalPostNotiCrearpthisFamiliaC;
    }
    
    public void setFamiliaCevalPostNotiCrearpthisFamiliaC(FamiliaCOid familiaCevalPostNotiCrearpthisFamiliaC) {
        this.familiaCevalPostNotiCrearpthisFamiliaC = familiaCevalPostNotiCrearpthisFamiliaC;
    }

    @JsonIgnore
    public FamiliaC getFamiliaCevalPostNotiCrearpthisFamiliaCInstance() {
        return this.familiaCevalPostNotiCrearpthisFamiliaCInstance;
    }
    
    public void setFamiliaCevalPostNotiCrearpthisFamiliaCInstance(FamiliaC familiaCevalPostNotiCrearpthisFamiliaC) {
        this.familiaCevalPostNotiCrearpthisFamiliaCInstance = familiaCevalPostNotiCrearpthisFamiliaC;
        this.familiaCevalPostNotiCrearpthisFamiliaC = familiaCevalPostNotiCrearpthisFamiliaC != null ? familiaCevalPostNotiCrearpthisFamiliaC.getOid() : null;
    }

    private void checkFamiliaCevalPostNotiCrearpthisFamiliaC() throws NotNullArgumentException {
        if(this.getFamiliaCevalPostNotiCrearpthisFamiliaCInstance() == null || this.getFamiliaCevalPostNotiCrearpthisFamiliaCInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaCConstants.SERV_ID_EVALPOSTNOTICREAR, FamiliaCConstants.CLASS_ID, FamiliaCConstants.ARG_ID_EVALPOSTNOTICREAR_FAMILIACEVALPOSTNOTICREARPTHISFAMILIAC, FamiliaCConstants.SERV_ALIAS_EVALPOSTNOTICREAR, FamiliaCConstants.CLASS_ALIAS, FamiliaCConstants.ARG_ALIAS_EVALPOSTNOTICREAR_FAMILIACEVALPOSTNOTICREARPTHISFAMILIAC);
        }
    }

    @JsonIgnore
    public String getFamiliaCevalPostNotiCrearpeNumFamilia() {
        return this.familiaCevalPostNotiCrearpeNumFamilia;
    }
    
    public void setFamiliaCevalPostNotiCrearpeNumFamilia(String familiaCevalPostNotiCrearpeNumFamilia) {
        this.familiaCevalPostNotiCrearpeNumFamilia = familiaCevalPostNotiCrearpeNumFamilia;
    }

    private void checkFamiliaCevalPostNotiCrearpeNumFamilia() throws NotNullArgumentException {
        if(this.getFamiliaCevalPostNotiCrearpeNumFamilia() == null) {
            throw new NotNullArgumentException(FamiliaCConstants.SERV_ID_EVALPOSTNOTICREAR, FamiliaCConstants.CLASS_ID, FamiliaCConstants.ARG_ID_EVALPOSTNOTICREAR_FAMILIACEVALPOSTNOTICREARPENUMFAMILIA, FamiliaCConstants.SERV_ALIAS_EVALPOSTNOTICREAR, FamiliaCConstants.CLASS_ALIAS, FamiliaCConstants.ARG_ALIAS_EVALPOSTNOTICREAR_FAMILIACEVALPOSTNOTICREARPENUMFAMILIA);
        }
    }

    @JsonIgnore
    public Date getFamiliaCevalPostNotiCrearpeFechaFinVigencia() {
        return this.familiaCevalPostNotiCrearpeFechaFinVigencia;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setFamiliaCevalPostNotiCrearpeFechaFinVigencia(Date familiaCevalPostNotiCrearpeFechaFinVigencia) {
        this.familiaCevalPostNotiCrearpeFechaFinVigencia = familiaCevalPostNotiCrearpeFechaFinVigencia;
    }

    @JsonIgnore
    public String getFamiliaCevalPostNotiCrearpeDirCorresp() {
        return this.familiaCevalPostNotiCrearpeDirCorresp;
    }
    
    public void setFamiliaCevalPostNotiCrearpeDirCorresp(String familiaCevalPostNotiCrearpeDirCorresp) {
        this.familiaCevalPostNotiCrearpeDirCorresp = familiaCevalPostNotiCrearpeDirCorresp;
    }
}
