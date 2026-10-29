package com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DirSucursalCConstants;
import com.keralty.aesolicitudes.persistence.DirSucursalC;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.oid.DirSucursalCOid;
import com.keralty.aesolicitudes.persistence.oid.MunicipioOid;

public class DelMunicipioDirSucursalRequest {

    @JsonProperty("p_thisdirsucursalc_oid")
    private DirSucursalCOid dirSucursalCDelMunicipioDirSucursalpthisDirSucursalC;
    
    @JsonIgnore
    private DirSucursalC dirSucursalCDelMunicipioDirSucursalpthisDirSucursalCInstance;

    @JsonProperty("p_evcmunicipio_oid")
    private MunicipioOid dirSucursalCDelMunicipioDirSucursalpevcMunicipio;
    
    @JsonIgnore
    private Municipio dirSucursalCDelMunicipioDirSucursalpevcMunicipioInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkDirSucursalCDelMunicipioDirSucursalpthisDirSucursalC();
        checkDirSucursalCDelMunicipioDirSucursalpevcMunicipio();
    }

    @JsonIgnore
    public DirSucursalCOid getDirSucursalCDelMunicipioDirSucursalpthisDirSucursalC() {
        return this.dirSucursalCDelMunicipioDirSucursalpthisDirSucursalC;
    }
    
    public void setDirSucursalCDelMunicipioDirSucursalpthisDirSucursalC(DirSucursalCOid dirSucursalCDelMunicipioDirSucursalpthisDirSucursalC) {
        this.dirSucursalCDelMunicipioDirSucursalpthisDirSucursalC = dirSucursalCDelMunicipioDirSucursalpthisDirSucursalC;
    }

    @JsonIgnore
    public DirSucursalC getDirSucursalCDelMunicipioDirSucursalpthisDirSucursalCInstance() {
        return this.dirSucursalCDelMunicipioDirSucursalpthisDirSucursalCInstance;
    }
    
    public void setDirSucursalCDelMunicipioDirSucursalpthisDirSucursalCInstance(DirSucursalC dirSucursalCDelMunicipioDirSucursalpthisDirSucursalC) {
        this.dirSucursalCDelMunicipioDirSucursalpthisDirSucursalCInstance = dirSucursalCDelMunicipioDirSucursalpthisDirSucursalC;
        this.dirSucursalCDelMunicipioDirSucursalpthisDirSucursalC = dirSucursalCDelMunicipioDirSucursalpthisDirSucursalC != null ? dirSucursalCDelMunicipioDirSucursalpthisDirSucursalC.getOid() : null;
    }

    private void checkDirSucursalCDelMunicipioDirSucursalpthisDirSucursalC() throws NotNullArgumentException {
        if(this.getDirSucursalCDelMunicipioDirSucursalpthisDirSucursalCInstance() == null || this.getDirSucursalCDelMunicipioDirSucursalpthisDirSucursalCInstance().isNull()) {
            throw new NotNullArgumentException(DirSucursalCConstants.SERV_ID_DELMUNICIPIODIRSUCURSAL, DirSucursalCConstants.CLASS_ID, DirSucursalCConstants.ARG_ID_DELMUNICIPIODIRSUCURSAL_DIRSUCURSALCDELMUNICIPIODIRSUCURSALPTHISDIRSUCURSALC, DirSucursalCConstants.SERV_ALIAS_DELMUNICIPIODIRSUCURSAL, DirSucursalCConstants.CLASS_ALIAS, DirSucursalCConstants.ARG_ALIAS_DELMUNICIPIODIRSUCURSAL_DIRSUCURSALCDELMUNICIPIODIRSUCURSALPTHISDIRSUCURSALC);
        }
    }

    @JsonIgnore
    public MunicipioOid getDirSucursalCDelMunicipioDirSucursalpevcMunicipio() {
        return this.dirSucursalCDelMunicipioDirSucursalpevcMunicipio;
    }
    
    public void setDirSucursalCDelMunicipioDirSucursalpevcMunicipio(MunicipioOid dirSucursalCDelMunicipioDirSucursalpevcMunicipio) {
        this.dirSucursalCDelMunicipioDirSucursalpevcMunicipio = dirSucursalCDelMunicipioDirSucursalpevcMunicipio;
    }

    @JsonIgnore
    public Municipio getDirSucursalCDelMunicipioDirSucursalpevcMunicipioInstance() {
        return this.dirSucursalCDelMunicipioDirSucursalpevcMunicipioInstance;
    }
    
    public void setDirSucursalCDelMunicipioDirSucursalpevcMunicipioInstance(Municipio dirSucursalCDelMunicipioDirSucursalpevcMunicipio) {
        this.dirSucursalCDelMunicipioDirSucursalpevcMunicipioInstance = dirSucursalCDelMunicipioDirSucursalpevcMunicipio;
        this.dirSucursalCDelMunicipioDirSucursalpevcMunicipio = dirSucursalCDelMunicipioDirSucursalpevcMunicipio != null ? dirSucursalCDelMunicipioDirSucursalpevcMunicipio.getOid() : null;
    }

    private void checkDirSucursalCDelMunicipioDirSucursalpevcMunicipio() throws NotNullArgumentException {
        if(this.getDirSucursalCDelMunicipioDirSucursalpevcMunicipioInstance() == null || this.getDirSucursalCDelMunicipioDirSucursalpevcMunicipioInstance().isNull()) {
            throw new NotNullArgumentException(DirSucursalCConstants.SERV_ID_DELMUNICIPIODIRSUCURSAL, DirSucursalCConstants.CLASS_ID, DirSucursalCConstants.ARG_ID_DELMUNICIPIODIRSUCURSAL_DIRSUCURSALCDELMUNICIPIODIRSUCURSALPEVCMUNICIPIO, DirSucursalCConstants.SERV_ALIAS_DELMUNICIPIODIRSUCURSAL, DirSucursalCConstants.CLASS_ALIAS, DirSucursalCConstants.ARG_ALIAS_DELMUNICIPIODIRSUCURSAL_DIRSUCURSALCDELMUNICIPIODIRSUCURSALPEVCMUNICIPIO);
        }
    }
}
