package com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DirSucursalCConstants;
import com.keralty.aesolicitudes.persistence.Departamento;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.oid.DepartamentoOid;
import com.keralty.aesolicitudes.persistence.oid.MunicipioOid;
import com.keralty.aesolicitudes.persistence.oid.PaisOid;
import com.keralty.aesolicitudes.persistence.oid.PersonaCOid;
import com.keralty.aesolicitudes.persistence.oid.RegionalOid;
import com.keralty.aesolicitudes.persistence.Pais;
import com.keralty.aesolicitudes.persistence.PersonaC;
import com.keralty.aesolicitudes.persistence.Regional;

public class CrearRequest {

    @JsonProperty("p_agrpersonac_oid")
    private PersonaCOid dirSucursalCcrearpagrPersonaC;
    
    @JsonIgnore
    private PersonaC dirSucursalCcrearpagrPersonaCInstance;

    @JsonProperty("p_agrmunicipioc_oid")
    private MunicipioOid dirSucursalCcrearpagrMunicipioC;
    
    @JsonIgnore
    private Municipio dirSucursalCcrearpagrMunicipioCInstance;

    @JsonProperty("p_agrdepartamentoc_oid")
    private DepartamentoOid dirSucursalCcrearpagrDepartamentoC;
    
    @JsonIgnore
    private Departamento dirSucursalCcrearpagrDepartamentoCInstance;

    @JsonProperty("p_agrpaisc_oid")
    private PaisOid dirSucursalCcrearpagrPaisC;
    
    @JsonIgnore
    private Pais dirSucursalCcrearpagrPaisCInstance;

    @JsonProperty("p_agrregionalc_oid")
    private RegionalOid dirSucursalCcrearpagrRegionalC;
    
    @JsonIgnore
    private Regional dirSucursalCcrearpagrRegionalCInstance;

    @JsonProperty("p_atrcodlegalsucursal")
    private String dirSucursalCcrearpatrCodLegalSucursal;

    @JsonProperty("p_atrnombre")
    private String dirSucursalCcrearpatrNombre;

    @JsonProperty("p_atresprincipal")
    private Boolean dirSucursalCcrearpatrEsPrincipal;

    @JsonProperty("p_atractiva")
    private Boolean dirSucursalCcrearpatrActiva;

    @JsonProperty("p_atrdireccion")
    private String dirSucursalCcrearpatrDireccion;

    @JsonProperty("p_atrmail")
    private String dirSucursalCcrearpatrMail;

    public void checkArguments() throws NotNullArgumentException {
        checkDirSucursalCcrearpagrPersonaC();
        checkDirSucursalCcrearpatrEsPrincipal();
        checkDirSucursalCcrearpatrActiva();
        checkDirSucursalCcrearpatrDireccion();
    }

    @JsonIgnore
    public PersonaCOid getDirSucursalCcrearpagrPersonaC() {
        return this.dirSucursalCcrearpagrPersonaC;
    }
    
    public void setDirSucursalCcrearpagrPersonaC(PersonaCOid dirSucursalCcrearpagrPersonaC) {
        this.dirSucursalCcrearpagrPersonaC = dirSucursalCcrearpagrPersonaC;
    }

    @JsonIgnore
    public PersonaC getDirSucursalCcrearpagrPersonaCInstance() {
        return this.dirSucursalCcrearpagrPersonaCInstance;
    }
    
    public void setDirSucursalCcrearpagrPersonaCInstance(PersonaC dirSucursalCcrearpagrPersonaC) {
        this.dirSucursalCcrearpagrPersonaCInstance = dirSucursalCcrearpagrPersonaC;
        this.dirSucursalCcrearpagrPersonaC = dirSucursalCcrearpagrPersonaC != null ? dirSucursalCcrearpagrPersonaC.getOid() : null;
    }

    private void checkDirSucursalCcrearpagrPersonaC() throws NotNullArgumentException {
        if(this.getDirSucursalCcrearpagrPersonaCInstance() == null || this.getDirSucursalCcrearpagrPersonaCInstance().isNull()) {
            throw new NotNullArgumentException(DirSucursalCConstants.SERV_ID_CREAR, DirSucursalCConstants.CLASS_ID, DirSucursalCConstants.ARG_ID_CREAR_DIRSUCURSALCCREARPAGRPERSONAC, DirSucursalCConstants.SERV_ALIAS_CREAR, DirSucursalCConstants.CLASS_ALIAS, DirSucursalCConstants.ARG_ALIAS_CREAR_DIRSUCURSALCCREARPAGRPERSONAC);
        }
    }

    @JsonIgnore
    public MunicipioOid getDirSucursalCcrearpagrMunicipioC() {
        return this.dirSucursalCcrearpagrMunicipioC;
    }
    
    public void setDirSucursalCcrearpagrMunicipioC(MunicipioOid dirSucursalCcrearpagrMunicipioC) {
        this.dirSucursalCcrearpagrMunicipioC = dirSucursalCcrearpagrMunicipioC;
    }

    @JsonIgnore
    public Municipio getDirSucursalCcrearpagrMunicipioCInstance() {
        return this.dirSucursalCcrearpagrMunicipioCInstance;
    }
    
    public void setDirSucursalCcrearpagrMunicipioCInstance(Municipio dirSucursalCcrearpagrMunicipioC) {
        this.dirSucursalCcrearpagrMunicipioCInstance = dirSucursalCcrearpagrMunicipioC;
        this.dirSucursalCcrearpagrMunicipioC = dirSucursalCcrearpagrMunicipioC != null ? dirSucursalCcrearpagrMunicipioC.getOid() : null;
    }

    @JsonIgnore
    public DepartamentoOid getDirSucursalCcrearpagrDepartamentoC() {
        return this.dirSucursalCcrearpagrDepartamentoC;
    }
    
    public void setDirSucursalCcrearpagrDepartamentoC(DepartamentoOid dirSucursalCcrearpagrDepartamentoC) {
        this.dirSucursalCcrearpagrDepartamentoC = dirSucursalCcrearpagrDepartamentoC;
    }

    @JsonIgnore
    public Departamento getDirSucursalCcrearpagrDepartamentoCInstance() {
        return this.dirSucursalCcrearpagrDepartamentoCInstance;
    }
    
    public void setDirSucursalCcrearpagrDepartamentoCInstance(Departamento dirSucursalCcrearpagrDepartamentoC) {
        this.dirSucursalCcrearpagrDepartamentoCInstance = dirSucursalCcrearpagrDepartamentoC;
        this.dirSucursalCcrearpagrDepartamentoC = dirSucursalCcrearpagrDepartamentoC != null ? dirSucursalCcrearpagrDepartamentoC.getOid() : null;
    }

    @JsonIgnore
    public PaisOid getDirSucursalCcrearpagrPaisC() {
        return this.dirSucursalCcrearpagrPaisC;
    }
    
    public void setDirSucursalCcrearpagrPaisC(PaisOid dirSucursalCcrearpagrPaisC) {
        this.dirSucursalCcrearpagrPaisC = dirSucursalCcrearpagrPaisC;
    }

    @JsonIgnore
    public Pais getDirSucursalCcrearpagrPaisCInstance() {
        return this.dirSucursalCcrearpagrPaisCInstance;
    }
    
    public void setDirSucursalCcrearpagrPaisCInstance(Pais dirSucursalCcrearpagrPaisC) {
        this.dirSucursalCcrearpagrPaisCInstance = dirSucursalCcrearpagrPaisC;
        this.dirSucursalCcrearpagrPaisC = dirSucursalCcrearpagrPaisC != null ? dirSucursalCcrearpagrPaisC.getOid() : null;
    }

    @JsonIgnore
    public RegionalOid getDirSucursalCcrearpagrRegionalC() {
        return this.dirSucursalCcrearpagrRegionalC;
    }
    
    public void setDirSucursalCcrearpagrRegionalC(RegionalOid dirSucursalCcrearpagrRegionalC) {
        this.dirSucursalCcrearpagrRegionalC = dirSucursalCcrearpagrRegionalC;
    }

    @JsonIgnore
    public Regional getDirSucursalCcrearpagrRegionalCInstance() {
        return this.dirSucursalCcrearpagrRegionalCInstance;
    }
    
    public void setDirSucursalCcrearpagrRegionalCInstance(Regional dirSucursalCcrearpagrRegionalC) {
        this.dirSucursalCcrearpagrRegionalCInstance = dirSucursalCcrearpagrRegionalC;
        this.dirSucursalCcrearpagrRegionalC = dirSucursalCcrearpagrRegionalC != null ? dirSucursalCcrearpagrRegionalC.getOid() : null;
    }

    @JsonIgnore
    public String getDirSucursalCcrearpatrCodLegalSucursal() {
        return this.dirSucursalCcrearpatrCodLegalSucursal;
    }
    
    public void setDirSucursalCcrearpatrCodLegalSucursal(String dirSucursalCcrearpatrCodLegalSucursal) {
        this.dirSucursalCcrearpatrCodLegalSucursal = dirSucursalCcrearpatrCodLegalSucursal;
    }

    @JsonIgnore
    public String getDirSucursalCcrearpatrNombre() {
        return this.dirSucursalCcrearpatrNombre;
    }
    
    public void setDirSucursalCcrearpatrNombre(String dirSucursalCcrearpatrNombre) {
        this.dirSucursalCcrearpatrNombre = dirSucursalCcrearpatrNombre;
    }

    @JsonIgnore
    public Boolean getDirSucursalCcrearpatrEsPrincipal() {
        return this.dirSucursalCcrearpatrEsPrincipal;
    }
    
    public void setDirSucursalCcrearpatrEsPrincipal(Boolean dirSucursalCcrearpatrEsPrincipal) {
        this.dirSucursalCcrearpatrEsPrincipal = dirSucursalCcrearpatrEsPrincipal;
    }

    private void checkDirSucursalCcrearpatrEsPrincipal() throws NotNullArgumentException {
        if(this.getDirSucursalCcrearpatrEsPrincipal() == null) {
            throw new NotNullArgumentException(DirSucursalCConstants.SERV_ID_CREAR, DirSucursalCConstants.CLASS_ID, DirSucursalCConstants.ARG_ID_CREAR_DIRSUCURSALCCREARPATRESPRINCIPAL, DirSucursalCConstants.SERV_ALIAS_CREAR, DirSucursalCConstants.CLASS_ALIAS, DirSucursalCConstants.ARG_ALIAS_CREAR_DIRSUCURSALCCREARPATRESPRINCIPAL);
        }
    }

    @JsonIgnore
    public Boolean getDirSucursalCcrearpatrActiva() {
        return this.dirSucursalCcrearpatrActiva;
    }
    
    public void setDirSucursalCcrearpatrActiva(Boolean dirSucursalCcrearpatrActiva) {
        this.dirSucursalCcrearpatrActiva = dirSucursalCcrearpatrActiva;
    }

    private void checkDirSucursalCcrearpatrActiva() throws NotNullArgumentException {
        if(this.getDirSucursalCcrearpatrActiva() == null) {
            throw new NotNullArgumentException(DirSucursalCConstants.SERV_ID_CREAR, DirSucursalCConstants.CLASS_ID, DirSucursalCConstants.ARG_ID_CREAR_DIRSUCURSALCCREARPATRACTIVA, DirSucursalCConstants.SERV_ALIAS_CREAR, DirSucursalCConstants.CLASS_ALIAS, DirSucursalCConstants.ARG_ALIAS_CREAR_DIRSUCURSALCCREARPATRACTIVA);
        }
    }

    @JsonIgnore
    public String getDirSucursalCcrearpatrDireccion() {
        return this.dirSucursalCcrearpatrDireccion;
    }
    
    public void setDirSucursalCcrearpatrDireccion(String dirSucursalCcrearpatrDireccion) {
        this.dirSucursalCcrearpatrDireccion = dirSucursalCcrearpatrDireccion;
    }

    private void checkDirSucursalCcrearpatrDireccion() throws NotNullArgumentException {
        if(this.getDirSucursalCcrearpatrDireccion() == null) {
            throw new NotNullArgumentException(DirSucursalCConstants.SERV_ID_CREAR, DirSucursalCConstants.CLASS_ID, DirSucursalCConstants.ARG_ID_CREAR_DIRSUCURSALCCREARPATRDIRECCION, DirSucursalCConstants.SERV_ALIAS_CREAR, DirSucursalCConstants.CLASS_ALIAS, DirSucursalCConstants.ARG_ALIAS_CREAR_DIRSUCURSALCCREARPATRDIRECCION);
        }
    }

    @JsonIgnore
    public String getDirSucursalCcrearpatrMail() {
        return this.dirSucursalCcrearpatrMail;
    }
    
    public void setDirSucursalCcrearpatrMail(String dirSucursalCcrearpatrMail) {
        this.dirSucursalCcrearpatrMail = dirSucursalCcrearpatrMail;
    }
}
