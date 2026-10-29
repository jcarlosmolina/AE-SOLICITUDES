package com.keralty.aesolicitudes.viewmodel.logestado.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.LogEstadoConstants;
import com.keralty.aesolicitudes.persistence.LogEstado;
import com.keralty.aesolicitudes.persistence.oid.LogEstadoOid;

public class EliminarRequest {

    @JsonProperty("p_thislogestado_oid")
    private LogEstadoOid logEstadoeliminarpthisLogEstado;
    
    @JsonIgnore
    private LogEstado logEstadoeliminarpthisLogEstadoInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkLogEstadoeliminarpthisLogEstado();
    }

    @JsonIgnore
    public LogEstadoOid getLogEstadoeliminarpthisLogEstado() {
        return this.logEstadoeliminarpthisLogEstado;
    }
    
    public void setLogEstadoeliminarpthisLogEstado(LogEstadoOid logEstadoeliminarpthisLogEstado) {
        this.logEstadoeliminarpthisLogEstado = logEstadoeliminarpthisLogEstado;
    }

    @JsonIgnore
    public LogEstado getLogEstadoeliminarpthisLogEstadoInstance() {
        return this.logEstadoeliminarpthisLogEstadoInstance;
    }
    
    public void setLogEstadoeliminarpthisLogEstadoInstance(LogEstado logEstadoeliminarpthisLogEstado) {
        this.logEstadoeliminarpthisLogEstadoInstance = logEstadoeliminarpthisLogEstado;
        this.logEstadoeliminarpthisLogEstado = logEstadoeliminarpthisLogEstado != null ? logEstadoeliminarpthisLogEstado.getOid() : null;
    }

    private void checkLogEstadoeliminarpthisLogEstado() throws NotNullArgumentException {
        if(this.getLogEstadoeliminarpthisLogEstadoInstance() == null || this.getLogEstadoeliminarpthisLogEstadoInstance().isNull()) {
            throw new NotNullArgumentException(LogEstadoConstants.SERV_ID_ELIMINAR, LogEstadoConstants.CLASS_ID, LogEstadoConstants.ARG_ID_ELIMINAR_LOGESTADOELIMINARPTHISLOGESTADO, LogEstadoConstants.SERV_ALIAS_ELIMINAR, LogEstadoConstants.CLASS_ALIAS, LogEstadoConstants.ARG_ALIAS_ELIMINAR_LOGESTADOELIMINARPTHISLOGESTADO);
        }
    }
}
