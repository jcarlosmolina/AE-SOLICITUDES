package com.keralty.aesolicitudes.viewmodel.observacionesc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ObservacionesCConstants;
import com.keralty.aesolicitudes.persistence.ObservacionesC;
import com.keralty.aesolicitudes.persistence.oid.ObservacionesCOid;

public class EliminarRequest {

    @JsonProperty("p_thisobservacionesc_oid")
    private ObservacionesCOid observacionesCeliminarpthisObservacionesC;
    
    @JsonIgnore
    private ObservacionesC observacionesCeliminarpthisObservacionesCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkObservacionesCeliminarpthisObservacionesC();
    }

    @JsonIgnore
    public ObservacionesCOid getObservacionesCeliminarpthisObservacionesC() {
        return this.observacionesCeliminarpthisObservacionesC;
    }
    
    public void setObservacionesCeliminarpthisObservacionesC(ObservacionesCOid observacionesCeliminarpthisObservacionesC) {
        this.observacionesCeliminarpthisObservacionesC = observacionesCeliminarpthisObservacionesC;
    }

    @JsonIgnore
    public ObservacionesC getObservacionesCeliminarpthisObservacionesCInstance() {
        return this.observacionesCeliminarpthisObservacionesCInstance;
    }
    
    public void setObservacionesCeliminarpthisObservacionesCInstance(ObservacionesC observacionesCeliminarpthisObservacionesC) {
        this.observacionesCeliminarpthisObservacionesCInstance = observacionesCeliminarpthisObservacionesC;
        this.observacionesCeliminarpthisObservacionesC = observacionesCeliminarpthisObservacionesC != null ? observacionesCeliminarpthisObservacionesC.getOid() : null;
    }

    private void checkObservacionesCeliminarpthisObservacionesC() throws NotNullArgumentException {
        if(this.getObservacionesCeliminarpthisObservacionesCInstance() == null || this.getObservacionesCeliminarpthisObservacionesCInstance().isNull()) {
            throw new NotNullArgumentException(ObservacionesCConstants.SERV_ID_ELIMINAR, ObservacionesCConstants.CLASS_ID, ObservacionesCConstants.ARG_ID_ELIMINAR_OBSERVACIONESCELIMINARPTHISOBSERVACIONESC, ObservacionesCConstants.SERV_ALIAS_ELIMINAR, ObservacionesCConstants.CLASS_ALIAS, ObservacionesCConstants.ARG_ALIAS_ELIMINAR_OBSERVACIONESCELIMINARPTHISOBSERVACIONESC);
        }
    }
}
