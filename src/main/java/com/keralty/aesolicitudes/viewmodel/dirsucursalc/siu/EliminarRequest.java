package com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DirSucursalCConstants;
import com.keralty.aesolicitudes.persistence.DirSucursalC;
import com.keralty.aesolicitudes.persistence.oid.DirSucursalCOid;

public class EliminarRequest {

    @JsonProperty("p_thisdirsucursalc_oid")
    private DirSucursalCOid dirSucursalCeliminarpthisDirSucursalC;
    
    @JsonIgnore
    private DirSucursalC dirSucursalCeliminarpthisDirSucursalCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkDirSucursalCeliminarpthisDirSucursalC();
    }

    @JsonIgnore
    public DirSucursalCOid getDirSucursalCeliminarpthisDirSucursalC() {
        return this.dirSucursalCeliminarpthisDirSucursalC;
    }
    
    public void setDirSucursalCeliminarpthisDirSucursalC(DirSucursalCOid dirSucursalCeliminarpthisDirSucursalC) {
        this.dirSucursalCeliminarpthisDirSucursalC = dirSucursalCeliminarpthisDirSucursalC;
    }

    @JsonIgnore
    public DirSucursalC getDirSucursalCeliminarpthisDirSucursalCInstance() {
        return this.dirSucursalCeliminarpthisDirSucursalCInstance;
    }
    
    public void setDirSucursalCeliminarpthisDirSucursalCInstance(DirSucursalC dirSucursalCeliminarpthisDirSucursalC) {
        this.dirSucursalCeliminarpthisDirSucursalCInstance = dirSucursalCeliminarpthisDirSucursalC;
        this.dirSucursalCeliminarpthisDirSucursalC = dirSucursalCeliminarpthisDirSucursalC != null ? dirSucursalCeliminarpthisDirSucursalC.getOid() : null;
    }

    private void checkDirSucursalCeliminarpthisDirSucursalC() throws NotNullArgumentException {
        if(this.getDirSucursalCeliminarpthisDirSucursalCInstance() == null || this.getDirSucursalCeliminarpthisDirSucursalCInstance().isNull()) {
            throw new NotNullArgumentException(DirSucursalCConstants.SERV_ID_ELIMINAR, DirSucursalCConstants.CLASS_ID, DirSucursalCConstants.ARG_ID_ELIMINAR_DIRSUCURSALCELIMINARPTHISDIRSUCURSALC, DirSucursalCConstants.SERV_ALIAS_ELIMINAR, DirSucursalCConstants.CLASS_ALIAS, DirSucursalCConstants.ARG_ALIAS_ELIMINAR_DIRSUCURSALCELIMINARPTHISDIRSUCURSALC);
        }
    }
}
