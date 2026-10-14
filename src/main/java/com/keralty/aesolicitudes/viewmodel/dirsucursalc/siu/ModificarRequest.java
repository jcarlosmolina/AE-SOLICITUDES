package com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DirSucursalCConstants;
import com.keralty.aesolicitudes.persistence.DirSucursalC;
import com.keralty.aesolicitudes.persistence.oid.DirSucursalCOid;

public class ModificarRequest {

    @JsonProperty("p_thisdirsucursalc_oid")
    private DirSucursalCOid dirSucursalCmodificarpthisDirSucursalC;
    
    @JsonIgnore
    private DirSucursalC dirSucursalCmodificarpthisDirSucursalCInstance;

    @JsonProperty("p_codlegalsucursal")
    private String dirSucursalCmodificarpCodLegalSucursal;

    @JsonProperty("p_nombre")
    private String dirSucursalCmodificarpNombre;

    @JsonProperty("p_esprincipal")
    private Boolean dirSucursalCmodificarpEsPrincipal;

    @JsonProperty("p_activa")
    private Boolean dirSucursalCmodificarpActiva;

    @JsonProperty("p_direccion")
    private String dirSucursalCmodificarpDireccion;

    @JsonProperty("p_mail")
    private String dirSucursalCmodificarpMail;

    public void checkArguments() throws NotNullArgumentException {
        checkDirSucursalCmodificarpthisDirSucursalC();
        checkDirSucursalCmodificarpEsPrincipal();
        checkDirSucursalCmodificarpActiva();
        checkDirSucursalCmodificarpDireccion();
    }

    @JsonIgnore
    public DirSucursalCOid getDirSucursalCmodificarpthisDirSucursalC() {
        return this.dirSucursalCmodificarpthisDirSucursalC;
    }
    
    public void setDirSucursalCmodificarpthisDirSucursalC(DirSucursalCOid dirSucursalCmodificarpthisDirSucursalC) {
        this.dirSucursalCmodificarpthisDirSucursalC = dirSucursalCmodificarpthisDirSucursalC;
    }

    @JsonIgnore
    public DirSucursalC getDirSucursalCmodificarpthisDirSucursalCInstance() {
        return this.dirSucursalCmodificarpthisDirSucursalCInstance;
    }
    
    public void setDirSucursalCmodificarpthisDirSucursalCInstance(DirSucursalC dirSucursalCmodificarpthisDirSucursalC) {
        this.dirSucursalCmodificarpthisDirSucursalCInstance = dirSucursalCmodificarpthisDirSucursalC;
        this.dirSucursalCmodificarpthisDirSucursalC = dirSucursalCmodificarpthisDirSucursalC != null ? dirSucursalCmodificarpthisDirSucursalC.getOid() : null;
    }

    private void checkDirSucursalCmodificarpthisDirSucursalC() throws NotNullArgumentException {
        if(this.getDirSucursalCmodificarpthisDirSucursalCInstance() == null || this.getDirSucursalCmodificarpthisDirSucursalCInstance().isNull()) {
            throw new NotNullArgumentException(DirSucursalCConstants.SERV_ID_MODIFICAR, DirSucursalCConstants.CLASS_ID, DirSucursalCConstants.ARG_ID_MODIFICAR_DIRSUCURSALCMODIFICARPTHISDIRSUCURSALC, DirSucursalCConstants.SERV_ALIAS_MODIFICAR, DirSucursalCConstants.CLASS_ALIAS, DirSucursalCConstants.ARG_ALIAS_MODIFICAR_DIRSUCURSALCMODIFICARPTHISDIRSUCURSALC);
        }
    }

    @JsonIgnore
    public String getDirSucursalCmodificarpCodLegalSucursal() {
        return this.dirSucursalCmodificarpCodLegalSucursal;
    }
    
    public void setDirSucursalCmodificarpCodLegalSucursal(String dirSucursalCmodificarpCodLegalSucursal) {
        this.dirSucursalCmodificarpCodLegalSucursal = dirSucursalCmodificarpCodLegalSucursal;
    }

    @JsonIgnore
    public String getDirSucursalCmodificarpNombre() {
        return this.dirSucursalCmodificarpNombre;
    }
    
    public void setDirSucursalCmodificarpNombre(String dirSucursalCmodificarpNombre) {
        this.dirSucursalCmodificarpNombre = dirSucursalCmodificarpNombre;
    }

    @JsonIgnore
    public Boolean getDirSucursalCmodificarpEsPrincipal() {
        return this.dirSucursalCmodificarpEsPrincipal;
    }
    
    public void setDirSucursalCmodificarpEsPrincipal(Boolean dirSucursalCmodificarpEsPrincipal) {
        this.dirSucursalCmodificarpEsPrincipal = dirSucursalCmodificarpEsPrincipal;
    }

    private void checkDirSucursalCmodificarpEsPrincipal() throws NotNullArgumentException {
        if(this.getDirSucursalCmodificarpEsPrincipal() == null) {
            throw new NotNullArgumentException(DirSucursalCConstants.SERV_ID_MODIFICAR, DirSucursalCConstants.CLASS_ID, DirSucursalCConstants.ARG_ID_MODIFICAR_DIRSUCURSALCMODIFICARPESPRINCIPAL, DirSucursalCConstants.SERV_ALIAS_MODIFICAR, DirSucursalCConstants.CLASS_ALIAS, DirSucursalCConstants.ARG_ALIAS_MODIFICAR_DIRSUCURSALCMODIFICARPESPRINCIPAL);
        }
    }

    @JsonIgnore
    public Boolean getDirSucursalCmodificarpActiva() {
        return this.dirSucursalCmodificarpActiva;
    }
    
    public void setDirSucursalCmodificarpActiva(Boolean dirSucursalCmodificarpActiva) {
        this.dirSucursalCmodificarpActiva = dirSucursalCmodificarpActiva;
    }

    private void checkDirSucursalCmodificarpActiva() throws NotNullArgumentException {
        if(this.getDirSucursalCmodificarpActiva() == null) {
            throw new NotNullArgumentException(DirSucursalCConstants.SERV_ID_MODIFICAR, DirSucursalCConstants.CLASS_ID, DirSucursalCConstants.ARG_ID_MODIFICAR_DIRSUCURSALCMODIFICARPACTIVA, DirSucursalCConstants.SERV_ALIAS_MODIFICAR, DirSucursalCConstants.CLASS_ALIAS, DirSucursalCConstants.ARG_ALIAS_MODIFICAR_DIRSUCURSALCMODIFICARPACTIVA);
        }
    }

    @JsonIgnore
    public String getDirSucursalCmodificarpDireccion() {
        return this.dirSucursalCmodificarpDireccion;
    }
    
    public void setDirSucursalCmodificarpDireccion(String dirSucursalCmodificarpDireccion) {
        this.dirSucursalCmodificarpDireccion = dirSucursalCmodificarpDireccion;
    }

    private void checkDirSucursalCmodificarpDireccion() throws NotNullArgumentException {
        if(this.getDirSucursalCmodificarpDireccion() == null) {
            throw new NotNullArgumentException(DirSucursalCConstants.SERV_ID_MODIFICAR, DirSucursalCConstants.CLASS_ID, DirSucursalCConstants.ARG_ID_MODIFICAR_DIRSUCURSALCMODIFICARPDIRECCION, DirSucursalCConstants.SERV_ALIAS_MODIFICAR, DirSucursalCConstants.CLASS_ALIAS, DirSucursalCConstants.ARG_ALIAS_MODIFICAR_DIRSUCURSALCMODIFICARPDIRECCION);
        }
    }

    @JsonIgnore
    public String getDirSucursalCmodificarpMail() {
        return this.dirSucursalCmodificarpMail;
    }
    
    public void setDirSucursalCmodificarpMail(String dirSucursalCmodificarpMail) {
        this.dirSucursalCmodificarpMail = dirSucursalCmodificarpMail;
    }
}
