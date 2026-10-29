package com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DirSucursalCConstants;
import com.keralty.aesolicitudes.persistence.DirSucursalC;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.oid.DirSucursalCOid;
import com.keralty.aesolicitudes.persistence.oid.MunicipioOid;

public class InsMunicipioDirSucursalRequest {

    @JsonProperty("p_thisdirsucursalc_oid")
    private DirSucursalCOid dirSucursalCInsMunicipioDirSucursalpthisDirSucursalC;
    
    @JsonIgnore
    private DirSucursalC dirSucursalCInsMunicipioDirSucursalpthisDirSucursalCInstance;

    @JsonProperty("p_evcmunicipio_oid")
    private MunicipioOid dirSucursalCInsMunicipioDirSucursalpevcMunicipio;
    
    @JsonIgnore
    private Municipio dirSucursalCInsMunicipioDirSucursalpevcMunicipioInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkDirSucursalCInsMunicipioDirSucursalpthisDirSucursalC();
        checkDirSucursalCInsMunicipioDirSucursalpevcMunicipio();
    }

    @JsonIgnore
    public DirSucursalCOid getDirSucursalCInsMunicipioDirSucursalpthisDirSucursalC() {
        return this.dirSucursalCInsMunicipioDirSucursalpthisDirSucursalC;
    }
    
    public void setDirSucursalCInsMunicipioDirSucursalpthisDirSucursalC(DirSucursalCOid dirSucursalCInsMunicipioDirSucursalpthisDirSucursalC) {
        this.dirSucursalCInsMunicipioDirSucursalpthisDirSucursalC = dirSucursalCInsMunicipioDirSucursalpthisDirSucursalC;
    }

    @JsonIgnore
    public DirSucursalC getDirSucursalCInsMunicipioDirSucursalpthisDirSucursalCInstance() {
        return this.dirSucursalCInsMunicipioDirSucursalpthisDirSucursalCInstance;
    }
    
    public void setDirSucursalCInsMunicipioDirSucursalpthisDirSucursalCInstance(DirSucursalC dirSucursalCInsMunicipioDirSucursalpthisDirSucursalC) {
        this.dirSucursalCInsMunicipioDirSucursalpthisDirSucursalCInstance = dirSucursalCInsMunicipioDirSucursalpthisDirSucursalC;
        this.dirSucursalCInsMunicipioDirSucursalpthisDirSucursalC = dirSucursalCInsMunicipioDirSucursalpthisDirSucursalC != null ? dirSucursalCInsMunicipioDirSucursalpthisDirSucursalC.getOid() : null;
    }

    private void checkDirSucursalCInsMunicipioDirSucursalpthisDirSucursalC() throws NotNullArgumentException {
        if(this.getDirSucursalCInsMunicipioDirSucursalpthisDirSucursalCInstance() == null || this.getDirSucursalCInsMunicipioDirSucursalpthisDirSucursalCInstance().isNull()) {
            throw new NotNullArgumentException(DirSucursalCConstants.SERV_ID_INSMUNICIPIODIRSUCURSAL, DirSucursalCConstants.CLASS_ID, DirSucursalCConstants.ARG_ID_INSMUNICIPIODIRSUCURSAL_DIRSUCURSALCINSMUNICIPIODIRSUCURSALPTHISDIRSUCURSALC, DirSucursalCConstants.SERV_ALIAS_INSMUNICIPIODIRSUCURSAL, DirSucursalCConstants.CLASS_ALIAS, DirSucursalCConstants.ARG_ALIAS_INSMUNICIPIODIRSUCURSAL_DIRSUCURSALCINSMUNICIPIODIRSUCURSALPTHISDIRSUCURSALC);
        }
    }

    @JsonIgnore
    public MunicipioOid getDirSucursalCInsMunicipioDirSucursalpevcMunicipio() {
        return this.dirSucursalCInsMunicipioDirSucursalpevcMunicipio;
    }
    
    public void setDirSucursalCInsMunicipioDirSucursalpevcMunicipio(MunicipioOid dirSucursalCInsMunicipioDirSucursalpevcMunicipio) {
        this.dirSucursalCInsMunicipioDirSucursalpevcMunicipio = dirSucursalCInsMunicipioDirSucursalpevcMunicipio;
    }

    @JsonIgnore
    public Municipio getDirSucursalCInsMunicipioDirSucursalpevcMunicipioInstance() {
        return this.dirSucursalCInsMunicipioDirSucursalpevcMunicipioInstance;
    }
    
    public void setDirSucursalCInsMunicipioDirSucursalpevcMunicipioInstance(Municipio dirSucursalCInsMunicipioDirSucursalpevcMunicipio) {
        this.dirSucursalCInsMunicipioDirSucursalpevcMunicipioInstance = dirSucursalCInsMunicipioDirSucursalpevcMunicipio;
        this.dirSucursalCInsMunicipioDirSucursalpevcMunicipio = dirSucursalCInsMunicipioDirSucursalpevcMunicipio != null ? dirSucursalCInsMunicipioDirSucursalpevcMunicipio.getOid() : null;
    }

    private void checkDirSucursalCInsMunicipioDirSucursalpevcMunicipio() throws NotNullArgumentException {
        if(this.getDirSucursalCInsMunicipioDirSucursalpevcMunicipioInstance() == null || this.getDirSucursalCInsMunicipioDirSucursalpevcMunicipioInstance().isNull()) {
            throw new NotNullArgumentException(DirSucursalCConstants.SERV_ID_INSMUNICIPIODIRSUCURSAL, DirSucursalCConstants.CLASS_ID, DirSucursalCConstants.ARG_ID_INSMUNICIPIODIRSUCURSAL_DIRSUCURSALCINSMUNICIPIODIRSUCURSALPEVCMUNICIPIO, DirSucursalCConstants.SERV_ALIAS_INSMUNICIPIODIRSUCURSAL, DirSucursalCConstants.CLASS_ALIAS, DirSucursalCConstants.ARG_ALIAS_INSMUNICIPIODIRSUCURSAL_DIRSUCURSALCINSMUNICIPIODIRSUCURSALPEVCMUNICIPIO);
        }
    }
}
