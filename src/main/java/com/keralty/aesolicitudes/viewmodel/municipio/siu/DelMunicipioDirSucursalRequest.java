package com.keralty.aesolicitudes.viewmodel.municipio.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.MunicipioConstants;
import com.keralty.aesolicitudes.persistence.DirSucursalC;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.oid.DirSucursalCOid;
import com.keralty.aesolicitudes.persistence.oid.MunicipioOid;

public class DelMunicipioDirSucursalRequest {

    @JsonProperty("p_thismunicipio_oid")
    private MunicipioOid municipioDelMunicipioDirSucursalpthisMunicipio;
    
    @JsonIgnore
    private Municipio municipioDelMunicipioDirSucursalpthisMunicipioInstance;

    @JsonProperty("p_evcdirsucursalc_oid")
    private DirSucursalCOid municipioDelMunicipioDirSucursalpevcDirSucursalC;
    
    @JsonIgnore
    private DirSucursalC municipioDelMunicipioDirSucursalpevcDirSucursalCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkMunicipioDelMunicipioDirSucursalpthisMunicipio();
        checkMunicipioDelMunicipioDirSucursalpevcDirSucursalC();
    }

    @JsonIgnore
    public MunicipioOid getMunicipioDelMunicipioDirSucursalpthisMunicipio() {
        return this.municipioDelMunicipioDirSucursalpthisMunicipio;
    }
    
    public void setMunicipioDelMunicipioDirSucursalpthisMunicipio(MunicipioOid municipioDelMunicipioDirSucursalpthisMunicipio) {
        this.municipioDelMunicipioDirSucursalpthisMunicipio = municipioDelMunicipioDirSucursalpthisMunicipio;
    }

    @JsonIgnore
    public Municipio getMunicipioDelMunicipioDirSucursalpthisMunicipioInstance() {
        return this.municipioDelMunicipioDirSucursalpthisMunicipioInstance;
    }
    
    public void setMunicipioDelMunicipioDirSucursalpthisMunicipioInstance(Municipio municipioDelMunicipioDirSucursalpthisMunicipio) {
        this.municipioDelMunicipioDirSucursalpthisMunicipioInstance = municipioDelMunicipioDirSucursalpthisMunicipio;
        this.municipioDelMunicipioDirSucursalpthisMunicipio = municipioDelMunicipioDirSucursalpthisMunicipio != null ? municipioDelMunicipioDirSucursalpthisMunicipio.getOid() : null;
    }

    private void checkMunicipioDelMunicipioDirSucursalpthisMunicipio() throws NotNullArgumentException {
        if(this.getMunicipioDelMunicipioDirSucursalpthisMunicipioInstance() == null || this.getMunicipioDelMunicipioDirSucursalpthisMunicipioInstance().isNull()) {
            throw new NotNullArgumentException(MunicipioConstants.SERV_ID_DELMUNICIPIODIRSUCURSAL, MunicipioConstants.CLASS_ID, MunicipioConstants.ARG_ID_DELMUNICIPIODIRSUCURSAL_MUNICIPIODELMUNICIPIODIRSUCURSALPTHISMUNICIPIO, MunicipioConstants.SERV_ALIAS_DELMUNICIPIODIRSUCURSAL, MunicipioConstants.CLASS_ALIAS, MunicipioConstants.ARG_ALIAS_DELMUNICIPIODIRSUCURSAL_MUNICIPIODELMUNICIPIODIRSUCURSALPTHISMUNICIPIO);
        }
    }

    @JsonIgnore
    public DirSucursalCOid getMunicipioDelMunicipioDirSucursalpevcDirSucursalC() {
        return this.municipioDelMunicipioDirSucursalpevcDirSucursalC;
    }
    
    public void setMunicipioDelMunicipioDirSucursalpevcDirSucursalC(DirSucursalCOid municipioDelMunicipioDirSucursalpevcDirSucursalC) {
        this.municipioDelMunicipioDirSucursalpevcDirSucursalC = municipioDelMunicipioDirSucursalpevcDirSucursalC;
    }

    @JsonIgnore
    public DirSucursalC getMunicipioDelMunicipioDirSucursalpevcDirSucursalCInstance() {
        return this.municipioDelMunicipioDirSucursalpevcDirSucursalCInstance;
    }
    
    public void setMunicipioDelMunicipioDirSucursalpevcDirSucursalCInstance(DirSucursalC municipioDelMunicipioDirSucursalpevcDirSucursalC) {
        this.municipioDelMunicipioDirSucursalpevcDirSucursalCInstance = municipioDelMunicipioDirSucursalpevcDirSucursalC;
        this.municipioDelMunicipioDirSucursalpevcDirSucursalC = municipioDelMunicipioDirSucursalpevcDirSucursalC != null ? municipioDelMunicipioDirSucursalpevcDirSucursalC.getOid() : null;
    }

    private void checkMunicipioDelMunicipioDirSucursalpevcDirSucursalC() throws NotNullArgumentException {
        if(this.getMunicipioDelMunicipioDirSucursalpevcDirSucursalCInstance() == null || this.getMunicipioDelMunicipioDirSucursalpevcDirSucursalCInstance().isNull()) {
            throw new NotNullArgumentException(MunicipioConstants.SERV_ID_DELMUNICIPIODIRSUCURSAL, MunicipioConstants.CLASS_ID, MunicipioConstants.ARG_ID_DELMUNICIPIODIRSUCURSAL_MUNICIPIODELMUNICIPIODIRSUCURSALPEVCDIRSUCURSALC, MunicipioConstants.SERV_ALIAS_DELMUNICIPIODIRSUCURSAL, MunicipioConstants.CLASS_ALIAS, MunicipioConstants.ARG_ALIAS_DELMUNICIPIODIRSUCURSAL_MUNICIPIODELMUNICIPIODIRSUCURSALPEVCDIRSUCURSALC);
        }
    }
}
