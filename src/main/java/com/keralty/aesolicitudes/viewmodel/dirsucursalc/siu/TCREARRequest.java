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

public class TCREARRequest {

    @JsonProperty("p_agrmunicipioc_oid")
    private MunicipioOid dirSucursalCTCREARpagrMunicipioC;
    
    @JsonIgnore
    private Municipio dirSucursalCTCREARpagrMunicipioCInstance;

    @JsonProperty("p_agrdepartamentoc_oid")
    private DepartamentoOid dirSucursalCTCREARpagrDepartamentoC;
    
    @JsonIgnore
    private Departamento dirSucursalCTCREARpagrDepartamentoCInstance;

    @JsonProperty("p_agrpaisc_oid")
    private PaisOid dirSucursalCTCREARpagrPaisC;
    
    @JsonIgnore
    private Pais dirSucursalCTCREARpagrPaisCInstance;

    @JsonProperty("p_agrpersonac_oid")
    private PersonaCOid dirSucursalCTCREARpagrPersonaC;
    
    @JsonIgnore
    private PersonaC dirSucursalCTCREARpagrPersonaCInstance;

    @JsonProperty("p_agrregionalc_oid")
    private RegionalOid dirSucursalCTCREARpagrRegionalC;
    
    @JsonIgnore
    private Regional dirSucursalCTCREARpagrRegionalCInstance;

    @JsonProperty("p_atrcodlegalsucursal")
    private String dirSucursalCTCREARpatrCodLegalSucursal;

    @JsonProperty("p_atrnombre")
    private String dirSucursalCTCREARpatrNombre;

    @JsonProperty("p_atresprincipal")
    private Boolean dirSucursalCTCREARpatrEsPrincipal;

    @JsonProperty("p_atractiva")
    private Boolean dirSucursalCTCREARpatrActiva;

    @JsonProperty("p_atrdireccion")
    private String dirSucursalCTCREARpatrDireccion;

    @JsonProperty("p_atrmail")
    private String dirSucursalCTCREARpatrMail;

    @JsonProperty("ptelefonofijo")
    private String dirSucursalCTCREARpTelefonoFijo;

    @JsonProperty("ptelefonocelular")
    private String dirSucursalCTCREARpTelefonoCelular;

    public void checkArguments() throws NotNullArgumentException {
        checkDirSucursalCTCREARpagrPersonaC();
        checkDirSucursalCTCREARpatrEsPrincipal();
        checkDirSucursalCTCREARpatrActiva();
        checkDirSucursalCTCREARpatrDireccion();
    }

    @JsonIgnore
    public MunicipioOid getDirSucursalCTCREARpagrMunicipioC() {
        return this.dirSucursalCTCREARpagrMunicipioC;
    }
    
    public void setDirSucursalCTCREARpagrMunicipioC(MunicipioOid dirSucursalCTCREARpagrMunicipioC) {
        this.dirSucursalCTCREARpagrMunicipioC = dirSucursalCTCREARpagrMunicipioC;
    }

    @JsonIgnore
    public Municipio getDirSucursalCTCREARpagrMunicipioCInstance() {
        return this.dirSucursalCTCREARpagrMunicipioCInstance;
    }
    
    public void setDirSucursalCTCREARpagrMunicipioCInstance(Municipio dirSucursalCTCREARpagrMunicipioC) {
        this.dirSucursalCTCREARpagrMunicipioCInstance = dirSucursalCTCREARpagrMunicipioC;
        this.dirSucursalCTCREARpagrMunicipioC = dirSucursalCTCREARpagrMunicipioC != null ? dirSucursalCTCREARpagrMunicipioC.getOid() : null;
    }

    @JsonIgnore
    public DepartamentoOid getDirSucursalCTCREARpagrDepartamentoC() {
        return this.dirSucursalCTCREARpagrDepartamentoC;
    }
    
    public void setDirSucursalCTCREARpagrDepartamentoC(DepartamentoOid dirSucursalCTCREARpagrDepartamentoC) {
        this.dirSucursalCTCREARpagrDepartamentoC = dirSucursalCTCREARpagrDepartamentoC;
    }

    @JsonIgnore
    public Departamento getDirSucursalCTCREARpagrDepartamentoCInstance() {
        return this.dirSucursalCTCREARpagrDepartamentoCInstance;
    }
    
    public void setDirSucursalCTCREARpagrDepartamentoCInstance(Departamento dirSucursalCTCREARpagrDepartamentoC) {
        this.dirSucursalCTCREARpagrDepartamentoCInstance = dirSucursalCTCREARpagrDepartamentoC;
        this.dirSucursalCTCREARpagrDepartamentoC = dirSucursalCTCREARpagrDepartamentoC != null ? dirSucursalCTCREARpagrDepartamentoC.getOid() : null;
    }

    @JsonIgnore
    public PaisOid getDirSucursalCTCREARpagrPaisC() {
        return this.dirSucursalCTCREARpagrPaisC;
    }
    
    public void setDirSucursalCTCREARpagrPaisC(PaisOid dirSucursalCTCREARpagrPaisC) {
        this.dirSucursalCTCREARpagrPaisC = dirSucursalCTCREARpagrPaisC;
    }

    @JsonIgnore
    public Pais getDirSucursalCTCREARpagrPaisCInstance() {
        return this.dirSucursalCTCREARpagrPaisCInstance;
    }
    
    public void setDirSucursalCTCREARpagrPaisCInstance(Pais dirSucursalCTCREARpagrPaisC) {
        this.dirSucursalCTCREARpagrPaisCInstance = dirSucursalCTCREARpagrPaisC;
        this.dirSucursalCTCREARpagrPaisC = dirSucursalCTCREARpagrPaisC != null ? dirSucursalCTCREARpagrPaisC.getOid() : null;
    }

    @JsonIgnore
    public PersonaCOid getDirSucursalCTCREARpagrPersonaC() {
        return this.dirSucursalCTCREARpagrPersonaC;
    }
    
    public void setDirSucursalCTCREARpagrPersonaC(PersonaCOid dirSucursalCTCREARpagrPersonaC) {
        this.dirSucursalCTCREARpagrPersonaC = dirSucursalCTCREARpagrPersonaC;
    }

    @JsonIgnore
    public PersonaC getDirSucursalCTCREARpagrPersonaCInstance() {
        return this.dirSucursalCTCREARpagrPersonaCInstance;
    }
    
    public void setDirSucursalCTCREARpagrPersonaCInstance(PersonaC dirSucursalCTCREARpagrPersonaC) {
        this.dirSucursalCTCREARpagrPersonaCInstance = dirSucursalCTCREARpagrPersonaC;
        this.dirSucursalCTCREARpagrPersonaC = dirSucursalCTCREARpagrPersonaC != null ? dirSucursalCTCREARpagrPersonaC.getOid() : null;
    }

    private void checkDirSucursalCTCREARpagrPersonaC() throws NotNullArgumentException {
        if(this.getDirSucursalCTCREARpagrPersonaCInstance() == null || this.getDirSucursalCTCREARpagrPersonaCInstance().isNull()) {
            throw new NotNullArgumentException(DirSucursalCConstants.SERV_ID_TCREAR, DirSucursalCConstants.CLASS_ID, DirSucursalCConstants.ARG_ID_TCREAR_DIRSUCURSALCTCREARPAGRPERSONAC, DirSucursalCConstants.SERV_ALIAS_TCREAR, DirSucursalCConstants.CLASS_ALIAS, DirSucursalCConstants.ARG_ALIAS_TCREAR_DIRSUCURSALCTCREARPAGRPERSONAC);
        }
    }

    @JsonIgnore
    public RegionalOid getDirSucursalCTCREARpagrRegionalC() {
        return this.dirSucursalCTCREARpagrRegionalC;
    }
    
    public void setDirSucursalCTCREARpagrRegionalC(RegionalOid dirSucursalCTCREARpagrRegionalC) {
        this.dirSucursalCTCREARpagrRegionalC = dirSucursalCTCREARpagrRegionalC;
    }

    @JsonIgnore
    public Regional getDirSucursalCTCREARpagrRegionalCInstance() {
        return this.dirSucursalCTCREARpagrRegionalCInstance;
    }
    
    public void setDirSucursalCTCREARpagrRegionalCInstance(Regional dirSucursalCTCREARpagrRegionalC) {
        this.dirSucursalCTCREARpagrRegionalCInstance = dirSucursalCTCREARpagrRegionalC;
        this.dirSucursalCTCREARpagrRegionalC = dirSucursalCTCREARpagrRegionalC != null ? dirSucursalCTCREARpagrRegionalC.getOid() : null;
    }

    @JsonIgnore
    public String getDirSucursalCTCREARpatrCodLegalSucursal() {
        return this.dirSucursalCTCREARpatrCodLegalSucursal;
    }
    
    public void setDirSucursalCTCREARpatrCodLegalSucursal(String dirSucursalCTCREARpatrCodLegalSucursal) {
        this.dirSucursalCTCREARpatrCodLegalSucursal = dirSucursalCTCREARpatrCodLegalSucursal;
    }

    @JsonIgnore
    public String getDirSucursalCTCREARpatrNombre() {
        return this.dirSucursalCTCREARpatrNombre;
    }
    
    public void setDirSucursalCTCREARpatrNombre(String dirSucursalCTCREARpatrNombre) {
        this.dirSucursalCTCREARpatrNombre = dirSucursalCTCREARpatrNombre;
    }

    @JsonIgnore
    public Boolean getDirSucursalCTCREARpatrEsPrincipal() {
        return this.dirSucursalCTCREARpatrEsPrincipal;
    }
    
    public void setDirSucursalCTCREARpatrEsPrincipal(Boolean dirSucursalCTCREARpatrEsPrincipal) {
        this.dirSucursalCTCREARpatrEsPrincipal = dirSucursalCTCREARpatrEsPrincipal;
    }

    private void checkDirSucursalCTCREARpatrEsPrincipal() throws NotNullArgumentException {
        if(this.getDirSucursalCTCREARpatrEsPrincipal() == null) {
            throw new NotNullArgumentException(DirSucursalCConstants.SERV_ID_TCREAR, DirSucursalCConstants.CLASS_ID, DirSucursalCConstants.ARG_ID_TCREAR_DIRSUCURSALCTCREARPATRESPRINCIPAL, DirSucursalCConstants.SERV_ALIAS_TCREAR, DirSucursalCConstants.CLASS_ALIAS, DirSucursalCConstants.ARG_ALIAS_TCREAR_DIRSUCURSALCTCREARPATRESPRINCIPAL);
        }
    }

    @JsonIgnore
    public Boolean getDirSucursalCTCREARpatrActiva() {
        return this.dirSucursalCTCREARpatrActiva;
    }
    
    public void setDirSucursalCTCREARpatrActiva(Boolean dirSucursalCTCREARpatrActiva) {
        this.dirSucursalCTCREARpatrActiva = dirSucursalCTCREARpatrActiva;
    }

    private void checkDirSucursalCTCREARpatrActiva() throws NotNullArgumentException {
        if(this.getDirSucursalCTCREARpatrActiva() == null) {
            throw new NotNullArgumentException(DirSucursalCConstants.SERV_ID_TCREAR, DirSucursalCConstants.CLASS_ID, DirSucursalCConstants.ARG_ID_TCREAR_DIRSUCURSALCTCREARPATRACTIVA, DirSucursalCConstants.SERV_ALIAS_TCREAR, DirSucursalCConstants.CLASS_ALIAS, DirSucursalCConstants.ARG_ALIAS_TCREAR_DIRSUCURSALCTCREARPATRACTIVA);
        }
    }

    @JsonIgnore
    public String getDirSucursalCTCREARpatrDireccion() {
        return this.dirSucursalCTCREARpatrDireccion;
    }
    
    public void setDirSucursalCTCREARpatrDireccion(String dirSucursalCTCREARpatrDireccion) {
        this.dirSucursalCTCREARpatrDireccion = dirSucursalCTCREARpatrDireccion;
    }

    private void checkDirSucursalCTCREARpatrDireccion() throws NotNullArgumentException {
        if(this.getDirSucursalCTCREARpatrDireccion() == null) {
            throw new NotNullArgumentException(DirSucursalCConstants.SERV_ID_TCREAR, DirSucursalCConstants.CLASS_ID, DirSucursalCConstants.ARG_ID_TCREAR_DIRSUCURSALCTCREARPATRDIRECCION, DirSucursalCConstants.SERV_ALIAS_TCREAR, DirSucursalCConstants.CLASS_ALIAS, DirSucursalCConstants.ARG_ALIAS_TCREAR_DIRSUCURSALCTCREARPATRDIRECCION);
        }
    }

    @JsonIgnore
    public String getDirSucursalCTCREARpatrMail() {
        return this.dirSucursalCTCREARpatrMail;
    }
    
    public void setDirSucursalCTCREARpatrMail(String dirSucursalCTCREARpatrMail) {
        this.dirSucursalCTCREARpatrMail = dirSucursalCTCREARpatrMail;
    }

    @JsonIgnore
    public String getDirSucursalCTCREARpTelefonoFijo() {
        return this.dirSucursalCTCREARpTelefonoFijo;
    }
    
    public void setDirSucursalCTCREARpTelefonoFijo(String dirSucursalCTCREARpTelefonoFijo) {
        this.dirSucursalCTCREARpTelefonoFijo = dirSucursalCTCREARpTelefonoFijo;
    }

    @JsonIgnore
    public String getDirSucursalCTCREARpTelefonoCelular() {
        return this.dirSucursalCTCREARpTelefonoCelular;
    }
    
    public void setDirSucursalCTCREARpTelefonoCelular(String dirSucursalCTCREARpTelefonoCelular) {
        this.dirSucursalCTCREARpTelefonoCelular = dirSucursalCTCREARpTelefonoCelular;
    }
}
