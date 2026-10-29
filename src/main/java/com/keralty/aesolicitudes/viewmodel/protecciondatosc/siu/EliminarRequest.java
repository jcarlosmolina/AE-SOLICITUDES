package com.keralty.aesolicitudes.viewmodel.protecciondatosc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ProteccionDatosCConstants;
import com.keralty.aesolicitudes.persistence.oid.ProteccionDatosCOid;
import com.keralty.aesolicitudes.persistence.ProteccionDatosC;

public class EliminarRequest {

    @JsonProperty("p_thisprotecciondatosc_oid")
    private ProteccionDatosCOid proteccionDatosCeliminarpthisProteccionDatosC;
    
    @JsonIgnore
    private ProteccionDatosC proteccionDatosCeliminarpthisProteccionDatosCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkProteccionDatosCeliminarpthisProteccionDatosC();
    }

    @JsonIgnore
    public ProteccionDatosCOid getProteccionDatosCeliminarpthisProteccionDatosC() {
        return this.proteccionDatosCeliminarpthisProteccionDatosC;
    }
    
    public void setProteccionDatosCeliminarpthisProteccionDatosC(ProteccionDatosCOid proteccionDatosCeliminarpthisProteccionDatosC) {
        this.proteccionDatosCeliminarpthisProteccionDatosC = proteccionDatosCeliminarpthisProteccionDatosC;
    }

    @JsonIgnore
    public ProteccionDatosC getProteccionDatosCeliminarpthisProteccionDatosCInstance() {
        return this.proteccionDatosCeliminarpthisProteccionDatosCInstance;
    }
    
    public void setProteccionDatosCeliminarpthisProteccionDatosCInstance(ProteccionDatosC proteccionDatosCeliminarpthisProteccionDatosC) {
        this.proteccionDatosCeliminarpthisProteccionDatosCInstance = proteccionDatosCeliminarpthisProteccionDatosC;
        this.proteccionDatosCeliminarpthisProteccionDatosC = proteccionDatosCeliminarpthisProteccionDatosC != null ? proteccionDatosCeliminarpthisProteccionDatosC.getOid() : null;
    }

    private void checkProteccionDatosCeliminarpthisProteccionDatosC() throws NotNullArgumentException {
        if(this.getProteccionDatosCeliminarpthisProteccionDatosCInstance() == null || this.getProteccionDatosCeliminarpthisProteccionDatosCInstance().isNull()) {
            throw new NotNullArgumentException(ProteccionDatosCConstants.SERV_ID_ELIMINAR, ProteccionDatosCConstants.CLASS_ID, ProteccionDatosCConstants.ARG_ID_ELIMINAR_PROTECCIONDATOSCELIMINARPTHISPROTECCIONDATOSC, ProteccionDatosCConstants.SERV_ALIAS_ELIMINAR, ProteccionDatosCConstants.CLASS_ALIAS, ProteccionDatosCConstants.ARG_ALIAS_ELIMINAR_PROTECCIONDATOSCELIMINARPTHISPROTECCIONDATOSC);
        }
    }
}
