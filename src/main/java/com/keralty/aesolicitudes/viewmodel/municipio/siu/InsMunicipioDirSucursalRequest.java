package com.keralty.aesolicitudes.viewmodel.municipio.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.MunicipioConstants;
import com.keralty.aesolicitudes.persistence.DirSucursalC;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.oid.DirSucursalCOid;
import com.keralty.aesolicitudes.persistence.oid.MunicipioOid;

public class InsMunicipioDirSucursalRequest {

    @JsonProperty("p_thismunicipio_oid")
    private MunicipioOid municipioInsMunicipioDirSucursalpthisMunicipio;
    
    @JsonIgnore
    private Municipio municipioInsMunicipioDirSucursalpthisMunicipioInstance;

    @JsonProperty("p_evcdirsucursalc_oid")
    private DirSucursalCOid municipioInsMunicipioDirSucursalpevcDirSucursalC;
    
    @JsonIgnore
    private DirSucursalC municipioInsMunicipioDirSucursalpevcDirSucursalCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkMunicipioInsMunicipioDirSucursalpthisMunicipio();
        checkMunicipioInsMunicipioDirSucursalpevcDirSucursalC();
    }

    @JsonIgnore
    public MunicipioOid getMunicipioInsMunicipioDirSucursalpthisMunicipio() {
        return this.municipioInsMunicipioDirSucursalpthisMunicipio;
    }
    
    public void setMunicipioInsMunicipioDirSucursalpthisMunicipio(MunicipioOid municipioInsMunicipioDirSucursalpthisMunicipio) {
        this.municipioInsMunicipioDirSucursalpthisMunicipio = municipioInsMunicipioDirSucursalpthisMunicipio;
    }

    @JsonIgnore
    public Municipio getMunicipioInsMunicipioDirSucursalpthisMunicipioInstance() {
        return this.municipioInsMunicipioDirSucursalpthisMunicipioInstance;
    }
    
    public void setMunicipioInsMunicipioDirSucursalpthisMunicipioInstance(Municipio municipioInsMunicipioDirSucursalpthisMunicipio) {
        this.municipioInsMunicipioDirSucursalpthisMunicipioInstance = municipioInsMunicipioDirSucursalpthisMunicipio;
        this.municipioInsMunicipioDirSucursalpthisMunicipio = municipioInsMunicipioDirSucursalpthisMunicipio != null ? municipioInsMunicipioDirSucursalpthisMunicipio.getOid() : null;
    }

    private void checkMunicipioInsMunicipioDirSucursalpthisMunicipio() throws NotNullArgumentException {
        if(this.getMunicipioInsMunicipioDirSucursalpthisMunicipioInstance() == null || this.getMunicipioInsMunicipioDirSucursalpthisMunicipioInstance().isNull()) {
            throw new NotNullArgumentException(MunicipioConstants.SERV_ID_INSMUNICIPIODIRSUCURSAL, MunicipioConstants.CLASS_ID, MunicipioConstants.ARG_ID_INSMUNICIPIODIRSUCURSAL_MUNICIPIOINSMUNICIPIODIRSUCURSALPTHISMUNICIPIO, MunicipioConstants.SERV_ALIAS_INSMUNICIPIODIRSUCURSAL, MunicipioConstants.CLASS_ALIAS, MunicipioConstants.ARG_ALIAS_INSMUNICIPIODIRSUCURSAL_MUNICIPIOINSMUNICIPIODIRSUCURSALPTHISMUNICIPIO);
        }
    }

    @JsonIgnore
    public DirSucursalCOid getMunicipioInsMunicipioDirSucursalpevcDirSucursalC() {
        return this.municipioInsMunicipioDirSucursalpevcDirSucursalC;
    }
    
    public void setMunicipioInsMunicipioDirSucursalpevcDirSucursalC(DirSucursalCOid municipioInsMunicipioDirSucursalpevcDirSucursalC) {
        this.municipioInsMunicipioDirSucursalpevcDirSucursalC = municipioInsMunicipioDirSucursalpevcDirSucursalC;
    }

    @JsonIgnore
    public DirSucursalC getMunicipioInsMunicipioDirSucursalpevcDirSucursalCInstance() {
        return this.municipioInsMunicipioDirSucursalpevcDirSucursalCInstance;
    }
    
    public void setMunicipioInsMunicipioDirSucursalpevcDirSucursalCInstance(DirSucursalC municipioInsMunicipioDirSucursalpevcDirSucursalC) {
        this.municipioInsMunicipioDirSucursalpevcDirSucursalCInstance = municipioInsMunicipioDirSucursalpevcDirSucursalC;
        this.municipioInsMunicipioDirSucursalpevcDirSucursalC = municipioInsMunicipioDirSucursalpevcDirSucursalC != null ? municipioInsMunicipioDirSucursalpevcDirSucursalC.getOid() : null;
    }

    private void checkMunicipioInsMunicipioDirSucursalpevcDirSucursalC() throws NotNullArgumentException {
        if(this.getMunicipioInsMunicipioDirSucursalpevcDirSucursalCInstance() == null || this.getMunicipioInsMunicipioDirSucursalpevcDirSucursalCInstance().isNull()) {
            throw new NotNullArgumentException(MunicipioConstants.SERV_ID_INSMUNICIPIODIRSUCURSAL, MunicipioConstants.CLASS_ID, MunicipioConstants.ARG_ID_INSMUNICIPIODIRSUCURSAL_MUNICIPIOINSMUNICIPIODIRSUCURSALPEVCDIRSUCURSALC, MunicipioConstants.SERV_ALIAS_INSMUNICIPIODIRSUCURSAL, MunicipioConstants.CLASS_ALIAS, MunicipioConstants.ARG_ALIAS_INSMUNICIPIODIRSUCURSAL_MUNICIPIOINSMUNICIPIODIRSUCURSALPEVCDIRSUCURSALC);
        }
    }
}
