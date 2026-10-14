package com.keralty.aesolicitudes.viewmodel.protecciondatos.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ProteccionDatosConstants;
import com.keralty.aesolicitudes.persistence.oid.ProteccionDatosOid;
import com.keralty.aesolicitudes.persistence.ProteccionDatos;

public class EliminarRequest {

    @JsonProperty("p_thisprotecciondatos_oid")
    private ProteccionDatosOid proteccionDatoseliminarpthisProteccionDatos;
    
    @JsonIgnore
    private ProteccionDatos proteccionDatoseliminarpthisProteccionDatosInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkProteccionDatoseliminarpthisProteccionDatos();
    }

    @JsonIgnore
    public ProteccionDatosOid getProteccionDatoseliminarpthisProteccionDatos() {
        return this.proteccionDatoseliminarpthisProteccionDatos;
    }
    
    public void setProteccionDatoseliminarpthisProteccionDatos(ProteccionDatosOid proteccionDatoseliminarpthisProteccionDatos) {
        this.proteccionDatoseliminarpthisProteccionDatos = proteccionDatoseliminarpthisProteccionDatos;
    }

    @JsonIgnore
    public ProteccionDatos getProteccionDatoseliminarpthisProteccionDatosInstance() {
        return this.proteccionDatoseliminarpthisProteccionDatosInstance;
    }
    
    public void setProteccionDatoseliminarpthisProteccionDatosInstance(ProteccionDatos proteccionDatoseliminarpthisProteccionDatos) {
        this.proteccionDatoseliminarpthisProteccionDatosInstance = proteccionDatoseliminarpthisProteccionDatos;
        this.proteccionDatoseliminarpthisProteccionDatos = proteccionDatoseliminarpthisProteccionDatos != null ? proteccionDatoseliminarpthisProteccionDatos.getOid() : null;
    }

    private void checkProteccionDatoseliminarpthisProteccionDatos() throws NotNullArgumentException {
        if(this.getProteccionDatoseliminarpthisProteccionDatosInstance() == null || this.getProteccionDatoseliminarpthisProteccionDatosInstance().isNull()) {
            throw new NotNullArgumentException(ProteccionDatosConstants.SERV_ID_ELIMINAR, ProteccionDatosConstants.CLASS_ID, ProteccionDatosConstants.ARG_ID_ELIMINAR_PROTECCIONDATOSELIMINARPTHISPROTECCIONDATOS, ProteccionDatosConstants.SERV_ALIAS_ELIMINAR, ProteccionDatosConstants.CLASS_ALIAS, ProteccionDatosConstants.ARG_ALIAS_ELIMINAR_PROTECCIONDATOSELIMINARPTHISPROTECCIONDATOS);
        }
    }
}
