package com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DirSucursalCConstants;
import com.keralty.aesolicitudes.persistence.Departamento;
import com.keralty.aesolicitudes.persistence.DirSucursalC;
import com.keralty.aesolicitudes.persistence.Municipio;
import com.keralty.aesolicitudes.persistence.oid.DepartamentoOid;
import com.keralty.aesolicitudes.persistence.oid.DirSucursalCOid;
import com.keralty.aesolicitudes.persistence.oid.MunicipioOid;
import com.keralty.aesolicitudes.persistence.oid.PaisOid;
import com.keralty.aesolicitudes.persistence.Pais;

public class TMODIFICARRequest {

    @JsonProperty("p_thisdirsucursalc_oid")
    private DirSucursalCOid dirSucursalCTMODIFICARpthisDirSucursalC;
    
    @JsonIgnore
    private DirSucursalC dirSucursalCTMODIFICARpthisDirSucursalCInstance;

    @JsonProperty("pt_p_codlegalsucursal")
    private String dirSucursalCTMODIFICARptpCodLegalSucursal;

    @JsonProperty("pt_p_nombre")
    private String dirSucursalCTMODIFICARptpNombre;

    @JsonProperty("pt_p_esprincipal")
    private Boolean dirSucursalCTMODIFICARptpEsPrincipal;

    @JsonProperty("pt_p_activa")
    private Boolean dirSucursalCTMODIFICARptpActiva;

    @JsonProperty("pt_p_direccion")
    private String dirSucursalCTMODIFICARptpDireccion;

    @JsonProperty("pt_p_mail")
    private String dirSucursalCTMODIFICARptpMail;

    @JsonProperty("pt_p_evcdepartamentoc_oid")
    private DepartamentoOid dirSucursalCTMODIFICARptpevcDepartamentoC;
    
    @JsonIgnore
    private Departamento dirSucursalCTMODIFICARptpevcDepartamentoCInstance;

    @JsonProperty("pt_p_evcmunicipioc_oid")
    private MunicipioOid dirSucursalCTMODIFICARptpevcMunicipioC;
    
    @JsonIgnore
    private Municipio dirSucursalCTMODIFICARptpevcMunicipioCInstance;

    @JsonProperty("pt_p_evcpaisc_oid")
    private PaisOid dirSucursalCTMODIFICARptpevcPaisC;
    
    @JsonIgnore
    private Pais dirSucursalCTMODIFICARptpevcPaisCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkDirSucursalCTMODIFICARpthisDirSucursalC();
        checkDirSucursalCTMODIFICARptpEsPrincipal();
        checkDirSucursalCTMODIFICARptpActiva();
        checkDirSucursalCTMODIFICARptpDireccion();
    }

    @JsonIgnore
    public DirSucursalCOid getDirSucursalCTMODIFICARpthisDirSucursalC() {
        return this.dirSucursalCTMODIFICARpthisDirSucursalC;
    }
    
    public void setDirSucursalCTMODIFICARpthisDirSucursalC(DirSucursalCOid dirSucursalCTMODIFICARpthisDirSucursalC) {
        this.dirSucursalCTMODIFICARpthisDirSucursalC = dirSucursalCTMODIFICARpthisDirSucursalC;
    }

    @JsonIgnore
    public DirSucursalC getDirSucursalCTMODIFICARpthisDirSucursalCInstance() {
        return this.dirSucursalCTMODIFICARpthisDirSucursalCInstance;
    }
    
    public void setDirSucursalCTMODIFICARpthisDirSucursalCInstance(DirSucursalC dirSucursalCTMODIFICARpthisDirSucursalC) {
        this.dirSucursalCTMODIFICARpthisDirSucursalCInstance = dirSucursalCTMODIFICARpthisDirSucursalC;
        this.dirSucursalCTMODIFICARpthisDirSucursalC = dirSucursalCTMODIFICARpthisDirSucursalC != null ? dirSucursalCTMODIFICARpthisDirSucursalC.getOid() : null;
    }

    private void checkDirSucursalCTMODIFICARpthisDirSucursalC() throws NotNullArgumentException {
        if(this.getDirSucursalCTMODIFICARpthisDirSucursalCInstance() == null || this.getDirSucursalCTMODIFICARpthisDirSucursalCInstance().isNull()) {
            throw new NotNullArgumentException(DirSucursalCConstants.SERV_ID_TMODIFICAR, DirSucursalCConstants.CLASS_ID, DirSucursalCConstants.ARG_ID_TMODIFICAR_DIRSUCURSALCTMODIFICARPTHISDIRSUCURSALC, DirSucursalCConstants.SERV_ALIAS_TMODIFICAR, DirSucursalCConstants.CLASS_ALIAS, DirSucursalCConstants.ARG_ALIAS_TMODIFICAR_DIRSUCURSALCTMODIFICARPTHISDIRSUCURSALC);
        }
    }

    @JsonIgnore
    public String getDirSucursalCTMODIFICARptpCodLegalSucursal() {
        return this.dirSucursalCTMODIFICARptpCodLegalSucursal;
    }
    
    public void setDirSucursalCTMODIFICARptpCodLegalSucursal(String dirSucursalCTMODIFICARptpCodLegalSucursal) {
        this.dirSucursalCTMODIFICARptpCodLegalSucursal = dirSucursalCTMODIFICARptpCodLegalSucursal;
    }

    @JsonIgnore
    public String getDirSucursalCTMODIFICARptpNombre() {
        return this.dirSucursalCTMODIFICARptpNombre;
    }
    
    public void setDirSucursalCTMODIFICARptpNombre(String dirSucursalCTMODIFICARptpNombre) {
        this.dirSucursalCTMODIFICARptpNombre = dirSucursalCTMODIFICARptpNombre;
    }

    @JsonIgnore
    public Boolean getDirSucursalCTMODIFICARptpEsPrincipal() {
        return this.dirSucursalCTMODIFICARptpEsPrincipal;
    }
    
    public void setDirSucursalCTMODIFICARptpEsPrincipal(Boolean dirSucursalCTMODIFICARptpEsPrincipal) {
        this.dirSucursalCTMODIFICARptpEsPrincipal = dirSucursalCTMODIFICARptpEsPrincipal;
    }

    private void checkDirSucursalCTMODIFICARptpEsPrincipal() throws NotNullArgumentException {
        if(this.getDirSucursalCTMODIFICARptpEsPrincipal() == null) {
            throw new NotNullArgumentException(DirSucursalCConstants.SERV_ID_TMODIFICAR, DirSucursalCConstants.CLASS_ID, DirSucursalCConstants.ARG_ID_TMODIFICAR_DIRSUCURSALCTMODIFICARPTPESPRINCIPAL, DirSucursalCConstants.SERV_ALIAS_TMODIFICAR, DirSucursalCConstants.CLASS_ALIAS, DirSucursalCConstants.ARG_ALIAS_TMODIFICAR_DIRSUCURSALCTMODIFICARPTPESPRINCIPAL);
        }
    }

    @JsonIgnore
    public Boolean getDirSucursalCTMODIFICARptpActiva() {
        return this.dirSucursalCTMODIFICARptpActiva;
    }
    
    public void setDirSucursalCTMODIFICARptpActiva(Boolean dirSucursalCTMODIFICARptpActiva) {
        this.dirSucursalCTMODIFICARptpActiva = dirSucursalCTMODIFICARptpActiva;
    }

    private void checkDirSucursalCTMODIFICARptpActiva() throws NotNullArgumentException {
        if(this.getDirSucursalCTMODIFICARptpActiva() == null) {
            throw new NotNullArgumentException(DirSucursalCConstants.SERV_ID_TMODIFICAR, DirSucursalCConstants.CLASS_ID, DirSucursalCConstants.ARG_ID_TMODIFICAR_DIRSUCURSALCTMODIFICARPTPACTIVA, DirSucursalCConstants.SERV_ALIAS_TMODIFICAR, DirSucursalCConstants.CLASS_ALIAS, DirSucursalCConstants.ARG_ALIAS_TMODIFICAR_DIRSUCURSALCTMODIFICARPTPACTIVA);
        }
    }

    @JsonIgnore
    public String getDirSucursalCTMODIFICARptpDireccion() {
        return this.dirSucursalCTMODIFICARptpDireccion;
    }
    
    public void setDirSucursalCTMODIFICARptpDireccion(String dirSucursalCTMODIFICARptpDireccion) {
        this.dirSucursalCTMODIFICARptpDireccion = dirSucursalCTMODIFICARptpDireccion;
    }

    private void checkDirSucursalCTMODIFICARptpDireccion() throws NotNullArgumentException {
        if(this.getDirSucursalCTMODIFICARptpDireccion() == null) {
            throw new NotNullArgumentException(DirSucursalCConstants.SERV_ID_TMODIFICAR, DirSucursalCConstants.CLASS_ID, DirSucursalCConstants.ARG_ID_TMODIFICAR_DIRSUCURSALCTMODIFICARPTPDIRECCION, DirSucursalCConstants.SERV_ALIAS_TMODIFICAR, DirSucursalCConstants.CLASS_ALIAS, DirSucursalCConstants.ARG_ALIAS_TMODIFICAR_DIRSUCURSALCTMODIFICARPTPDIRECCION);
        }
    }

    @JsonIgnore
    public String getDirSucursalCTMODIFICARptpMail() {
        return this.dirSucursalCTMODIFICARptpMail;
    }
    
    public void setDirSucursalCTMODIFICARptpMail(String dirSucursalCTMODIFICARptpMail) {
        this.dirSucursalCTMODIFICARptpMail = dirSucursalCTMODIFICARptpMail;
    }

    @JsonIgnore
    public DepartamentoOid getDirSucursalCTMODIFICARptpevcDepartamentoC() {
        return this.dirSucursalCTMODIFICARptpevcDepartamentoC;
    }
    
    public void setDirSucursalCTMODIFICARptpevcDepartamentoC(DepartamentoOid dirSucursalCTMODIFICARptpevcDepartamentoC) {
        this.dirSucursalCTMODIFICARptpevcDepartamentoC = dirSucursalCTMODIFICARptpevcDepartamentoC;
    }

    @JsonIgnore
    public Departamento getDirSucursalCTMODIFICARptpevcDepartamentoCInstance() {
        return this.dirSucursalCTMODIFICARptpevcDepartamentoCInstance;
    }
    
    public void setDirSucursalCTMODIFICARptpevcDepartamentoCInstance(Departamento dirSucursalCTMODIFICARptpevcDepartamentoC) {
        this.dirSucursalCTMODIFICARptpevcDepartamentoCInstance = dirSucursalCTMODIFICARptpevcDepartamentoC;
        this.dirSucursalCTMODIFICARptpevcDepartamentoC = dirSucursalCTMODIFICARptpevcDepartamentoC != null ? dirSucursalCTMODIFICARptpevcDepartamentoC.getOid() : null;
    }

    @JsonIgnore
    public MunicipioOid getDirSucursalCTMODIFICARptpevcMunicipioC() {
        return this.dirSucursalCTMODIFICARptpevcMunicipioC;
    }
    
    public void setDirSucursalCTMODIFICARptpevcMunicipioC(MunicipioOid dirSucursalCTMODIFICARptpevcMunicipioC) {
        this.dirSucursalCTMODIFICARptpevcMunicipioC = dirSucursalCTMODIFICARptpevcMunicipioC;
    }

    @JsonIgnore
    public Municipio getDirSucursalCTMODIFICARptpevcMunicipioCInstance() {
        return this.dirSucursalCTMODIFICARptpevcMunicipioCInstance;
    }
    
    public void setDirSucursalCTMODIFICARptpevcMunicipioCInstance(Municipio dirSucursalCTMODIFICARptpevcMunicipioC) {
        this.dirSucursalCTMODIFICARptpevcMunicipioCInstance = dirSucursalCTMODIFICARptpevcMunicipioC;
        this.dirSucursalCTMODIFICARptpevcMunicipioC = dirSucursalCTMODIFICARptpevcMunicipioC != null ? dirSucursalCTMODIFICARptpevcMunicipioC.getOid() : null;
    }

    @JsonIgnore
    public PaisOid getDirSucursalCTMODIFICARptpevcPaisC() {
        return this.dirSucursalCTMODIFICARptpevcPaisC;
    }
    
    public void setDirSucursalCTMODIFICARptpevcPaisC(PaisOid dirSucursalCTMODIFICARptpevcPaisC) {
        this.dirSucursalCTMODIFICARptpevcPaisC = dirSucursalCTMODIFICARptpevcPaisC;
    }

    @JsonIgnore
    public Pais getDirSucursalCTMODIFICARptpevcPaisCInstance() {
        return this.dirSucursalCTMODIFICARptpevcPaisCInstance;
    }
    
    public void setDirSucursalCTMODIFICARptpevcPaisCInstance(Pais dirSucursalCTMODIFICARptpevcPaisC) {
        this.dirSucursalCTMODIFICARptpevcPaisCInstance = dirSucursalCTMODIFICARptpevcPaisC;
        this.dirSucursalCTMODIFICARptpevcPaisC = dirSucursalCTMODIFICARptpevcPaisC != null ? dirSucursalCTMODIFICARptpevcPaisC.getOid() : null;
    }
}
