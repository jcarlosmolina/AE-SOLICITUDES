package com.keralty.aesolicitudes.viewmodel.familiac.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.FamiliaCConstants;
import com.keralty.aesolicitudes.persistence.FamiliaC;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.oid.FamiliaCOid;
import com.keralty.aesolicitudes.persistence.oid.MunicipioOid;
import com.keralty.aesolicitudes.persistence.oid.TipoIdentificacionOid;
import com.keralty.aesolicitudes.persistence.TipoIdentificacion;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class TPOSTNOTICREARRequest {

    @JsonProperty("p_thisfamiliac_oid")
    private FamiliaCOid familiaCTPOSTNOTICREARpthisFamiliaC;
    
    @JsonIgnore
    private FamiliaC familiaCTPOSTNOTICREARpthisFamiliaCInstance;

    @JsonProperty("pt_penumfamilia")
    private String familiaCTPOSTNOTICREARptpeNumFamilia;

    @JsonProperty("pt_pefechafinvigencia")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date familiaCTPOSTNOTICREARptpeFechaFinVigencia;

    @JsonProperty("pt_pedircorresp")
    private String familiaCTPOSTNOTICREARptpeDirCorresp;

    @JsonProperty("ptmunicipiodireccion_oid")
    private MunicipioOid familiaCTPOSTNOTICREARptMunicipioDireccion;
    
    @JsonIgnore
    private Municipio familiaCTPOSTNOTICREARptMunicipioDireccionInstance;

    @JsonProperty("pttipoidenttitular_oid")
    private TipoIdentificacionOid familiaCTPOSTNOTICREARptTipoIdentTitular;
    
    @JsonIgnore
    private TipoIdentificacion familiaCTPOSTNOTICREARptTipoIdentTitularInstance;

    @JsonProperty("ptnumidenttitular")
    private String familiaCTPOSTNOTICREARptNumIdentTitular;

    @JsonProperty("ptnombrecompletotitular")
    private String familiaCTPOSTNOTICREARptNombreCompletoTitular;

    public void checkArguments() throws NotNullArgumentException {
        checkFamiliaCTPOSTNOTICREARpthisFamiliaC();
        checkFamiliaCTPOSTNOTICREARptpeNumFamilia();
    }

    @JsonIgnore
    public FamiliaCOid getFamiliaCTPOSTNOTICREARpthisFamiliaC() {
        return this.familiaCTPOSTNOTICREARpthisFamiliaC;
    }
    
    public void setFamiliaCTPOSTNOTICREARpthisFamiliaC(FamiliaCOid familiaCTPOSTNOTICREARpthisFamiliaC) {
        this.familiaCTPOSTNOTICREARpthisFamiliaC = familiaCTPOSTNOTICREARpthisFamiliaC;
    }

    @JsonIgnore
    public FamiliaC getFamiliaCTPOSTNOTICREARpthisFamiliaCInstance() {
        return this.familiaCTPOSTNOTICREARpthisFamiliaCInstance;
    }
    
    public void setFamiliaCTPOSTNOTICREARpthisFamiliaCInstance(FamiliaC familiaCTPOSTNOTICREARpthisFamiliaC) {
        this.familiaCTPOSTNOTICREARpthisFamiliaCInstance = familiaCTPOSTNOTICREARpthisFamiliaC;
        this.familiaCTPOSTNOTICREARpthisFamiliaC = familiaCTPOSTNOTICREARpthisFamiliaC != null ? familiaCTPOSTNOTICREARpthisFamiliaC.getOid() : null;
    }

    private void checkFamiliaCTPOSTNOTICREARpthisFamiliaC() throws NotNullArgumentException {
        if(this.getFamiliaCTPOSTNOTICREARpthisFamiliaCInstance() == null || this.getFamiliaCTPOSTNOTICREARpthisFamiliaCInstance().isNull()) {
            throw new NotNullArgumentException(FamiliaCConstants.SERV_ID_TPOSTNOTICREAR, FamiliaCConstants.CLASS_ID, FamiliaCConstants.ARG_ID_TPOSTNOTICREAR_FAMILIACTPOSTNOTICREARPTHISFAMILIAC, FamiliaCConstants.SERV_ALIAS_TPOSTNOTICREAR, FamiliaCConstants.CLASS_ALIAS, FamiliaCConstants.ARG_ALIAS_TPOSTNOTICREAR_FAMILIACTPOSTNOTICREARPTHISFAMILIAC);
        }
    }

    @JsonIgnore
    public String getFamiliaCTPOSTNOTICREARptpeNumFamilia() {
        return this.familiaCTPOSTNOTICREARptpeNumFamilia;
    }
    
    public void setFamiliaCTPOSTNOTICREARptpeNumFamilia(String familiaCTPOSTNOTICREARptpeNumFamilia) {
        this.familiaCTPOSTNOTICREARptpeNumFamilia = familiaCTPOSTNOTICREARptpeNumFamilia;
    }

    private void checkFamiliaCTPOSTNOTICREARptpeNumFamilia() throws NotNullArgumentException {
        if(this.getFamiliaCTPOSTNOTICREARptpeNumFamilia() == null) {
            throw new NotNullArgumentException(FamiliaCConstants.SERV_ID_TPOSTNOTICREAR, FamiliaCConstants.CLASS_ID, FamiliaCConstants.ARG_ID_TPOSTNOTICREAR_FAMILIACTPOSTNOTICREARPTPENUMFAMILIA, FamiliaCConstants.SERV_ALIAS_TPOSTNOTICREAR, FamiliaCConstants.CLASS_ALIAS, FamiliaCConstants.ARG_ALIAS_TPOSTNOTICREAR_FAMILIACTPOSTNOTICREARPTPENUMFAMILIA);
        }
    }

    @JsonIgnore
    public Date getFamiliaCTPOSTNOTICREARptpeFechaFinVigencia() {
        return this.familiaCTPOSTNOTICREARptpeFechaFinVigencia;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setFamiliaCTPOSTNOTICREARptpeFechaFinVigencia(Date familiaCTPOSTNOTICREARptpeFechaFinVigencia) {
        this.familiaCTPOSTNOTICREARptpeFechaFinVigencia = familiaCTPOSTNOTICREARptpeFechaFinVigencia;
    }

    @JsonIgnore
    public String getFamiliaCTPOSTNOTICREARptpeDirCorresp() {
        return this.familiaCTPOSTNOTICREARptpeDirCorresp;
    }
    
    public void setFamiliaCTPOSTNOTICREARptpeDirCorresp(String familiaCTPOSTNOTICREARptpeDirCorresp) {
        this.familiaCTPOSTNOTICREARptpeDirCorresp = familiaCTPOSTNOTICREARptpeDirCorresp;
    }

    @JsonIgnore
    public MunicipioOid getFamiliaCTPOSTNOTICREARptMunicipioDireccion() {
        return this.familiaCTPOSTNOTICREARptMunicipioDireccion;
    }
    
    public void setFamiliaCTPOSTNOTICREARptMunicipioDireccion(MunicipioOid familiaCTPOSTNOTICREARptMunicipioDireccion) {
        this.familiaCTPOSTNOTICREARptMunicipioDireccion = familiaCTPOSTNOTICREARptMunicipioDireccion;
    }

    @JsonIgnore
    public Municipio getFamiliaCTPOSTNOTICREARptMunicipioDireccionInstance() {
        return this.familiaCTPOSTNOTICREARptMunicipioDireccionInstance;
    }
    
    public void setFamiliaCTPOSTNOTICREARptMunicipioDireccionInstance(Municipio familiaCTPOSTNOTICREARptMunicipioDireccion) {
        this.familiaCTPOSTNOTICREARptMunicipioDireccionInstance = familiaCTPOSTNOTICREARptMunicipioDireccion;
        this.familiaCTPOSTNOTICREARptMunicipioDireccion = familiaCTPOSTNOTICREARptMunicipioDireccion != null ? familiaCTPOSTNOTICREARptMunicipioDireccion.getOid() : null;
    }

    @JsonIgnore
    public TipoIdentificacionOid getFamiliaCTPOSTNOTICREARptTipoIdentTitular() {
        return this.familiaCTPOSTNOTICREARptTipoIdentTitular;
    }
    
    public void setFamiliaCTPOSTNOTICREARptTipoIdentTitular(TipoIdentificacionOid familiaCTPOSTNOTICREARptTipoIdentTitular) {
        this.familiaCTPOSTNOTICREARptTipoIdentTitular = familiaCTPOSTNOTICREARptTipoIdentTitular;
    }

    @JsonIgnore
    public TipoIdentificacion getFamiliaCTPOSTNOTICREARptTipoIdentTitularInstance() {
        return this.familiaCTPOSTNOTICREARptTipoIdentTitularInstance;
    }
    
    public void setFamiliaCTPOSTNOTICREARptTipoIdentTitularInstance(TipoIdentificacion familiaCTPOSTNOTICREARptTipoIdentTitular) {
        this.familiaCTPOSTNOTICREARptTipoIdentTitularInstance = familiaCTPOSTNOTICREARptTipoIdentTitular;
        this.familiaCTPOSTNOTICREARptTipoIdentTitular = familiaCTPOSTNOTICREARptTipoIdentTitular != null ? familiaCTPOSTNOTICREARptTipoIdentTitular.getOid() : null;
    }

    @JsonIgnore
    public String getFamiliaCTPOSTNOTICREARptNumIdentTitular() {
        return this.familiaCTPOSTNOTICREARptNumIdentTitular;
    }
    
    public void setFamiliaCTPOSTNOTICREARptNumIdentTitular(String familiaCTPOSTNOTICREARptNumIdentTitular) {
        this.familiaCTPOSTNOTICREARptNumIdentTitular = familiaCTPOSTNOTICREARptNumIdentTitular;
    }

    @JsonIgnore
    public String getFamiliaCTPOSTNOTICREARptNombreCompletoTitular() {
        return this.familiaCTPOSTNOTICREARptNombreCompletoTitular;
    }
    
    public void setFamiliaCTPOSTNOTICREARptNombreCompletoTitular(String familiaCTPOSTNOTICREARptNombreCompletoTitular) {
        this.familiaCTPOSTNOTICREARptNombreCompletoTitular = familiaCTPOSTNOTICREARptNombreCompletoTitular;
    }
}
