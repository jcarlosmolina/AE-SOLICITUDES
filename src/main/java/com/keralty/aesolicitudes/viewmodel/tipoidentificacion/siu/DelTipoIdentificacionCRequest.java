package com.keralty.aesolicitudes.viewmodel.tipoidentificacion.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.TipoIdentificacionConstants;
import com.keralty.aesolicitudes.persistence.AnexoC;
import com.keralty.aesolicitudes.persistence.oid.AnexoCOid;
import com.keralty.aesolicitudes.persistence.oid.TipoIdentificacionOid;
import com.keralty.aesolicitudes.persistence.TipoIdentificacion;

public class DelTipoIdentificacionCRequest {

    @JsonProperty("p_thistipoidentificacion_oid")
    private TipoIdentificacionOid tipoIdentificacionDelTipoIdentificacionCpthisTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion tipoIdentificacionDelTipoIdentificacionCpthisTipoIdentificacionInstance;

    @JsonProperty("p_evcanexoc_oid")
    private AnexoCOid tipoIdentificacionDelTipoIdentificacionCpevcAnexoC;
    
    @JsonIgnore
    private AnexoC tipoIdentificacionDelTipoIdentificacionCpevcAnexoCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkTipoIdentificacionDelTipoIdentificacionCpthisTipoIdentificacion();
        checkTipoIdentificacionDelTipoIdentificacionCpevcAnexoC();
    }

    @JsonIgnore
    public TipoIdentificacionOid getTipoIdentificacionDelTipoIdentificacionCpthisTipoIdentificacion() {
        return this.tipoIdentificacionDelTipoIdentificacionCpthisTipoIdentificacion;
    }
    
    public void setTipoIdentificacionDelTipoIdentificacionCpthisTipoIdentificacion(TipoIdentificacionOid tipoIdentificacionDelTipoIdentificacionCpthisTipoIdentificacion) {
        this.tipoIdentificacionDelTipoIdentificacionCpthisTipoIdentificacion = tipoIdentificacionDelTipoIdentificacionCpthisTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getTipoIdentificacionDelTipoIdentificacionCpthisTipoIdentificacionInstance() {
        return this.tipoIdentificacionDelTipoIdentificacionCpthisTipoIdentificacionInstance;
    }
    
    public void setTipoIdentificacionDelTipoIdentificacionCpthisTipoIdentificacionInstance(TipoIdentificacion tipoIdentificacionDelTipoIdentificacionCpthisTipoIdentificacion) {
        this.tipoIdentificacionDelTipoIdentificacionCpthisTipoIdentificacionInstance = tipoIdentificacionDelTipoIdentificacionCpthisTipoIdentificacion;
        this.tipoIdentificacionDelTipoIdentificacionCpthisTipoIdentificacion = tipoIdentificacionDelTipoIdentificacionCpthisTipoIdentificacion != null ? tipoIdentificacionDelTipoIdentificacionCpthisTipoIdentificacion.getOid() : null;
    }

    private void checkTipoIdentificacionDelTipoIdentificacionCpthisTipoIdentificacion() throws NotNullArgumentException {
        if(this.getTipoIdentificacionDelTipoIdentificacionCpthisTipoIdentificacionInstance() == null || this.getTipoIdentificacionDelTipoIdentificacionCpthisTipoIdentificacionInstance().isNull()) {
            throw new NotNullArgumentException(TipoIdentificacionConstants.SERV_ID_DELTIPOIDENTIFICACIONC, TipoIdentificacionConstants.CLASS_ID, TipoIdentificacionConstants.ARG_ID_DELTIPOIDENTIFICACIONC_TIPOIDENTIFICACIONDELTIPOIDENTIFICACIONCPTHISTIPOIDENTIFICACION, TipoIdentificacionConstants.SERV_ALIAS_DELTIPOIDENTIFICACIONC, TipoIdentificacionConstants.CLASS_ALIAS, TipoIdentificacionConstants.ARG_ALIAS_DELTIPOIDENTIFICACIONC_TIPOIDENTIFICACIONDELTIPOIDENTIFICACIONCPTHISTIPOIDENTIFICACION);
        }
    }

    @JsonIgnore
    public AnexoCOid getTipoIdentificacionDelTipoIdentificacionCpevcAnexoC() {
        return this.tipoIdentificacionDelTipoIdentificacionCpevcAnexoC;
    }
    
    public void setTipoIdentificacionDelTipoIdentificacionCpevcAnexoC(AnexoCOid tipoIdentificacionDelTipoIdentificacionCpevcAnexoC) {
        this.tipoIdentificacionDelTipoIdentificacionCpevcAnexoC = tipoIdentificacionDelTipoIdentificacionCpevcAnexoC;
    }

    @JsonIgnore
    public AnexoC getTipoIdentificacionDelTipoIdentificacionCpevcAnexoCInstance() {
        return this.tipoIdentificacionDelTipoIdentificacionCpevcAnexoCInstance;
    }
    
    public void setTipoIdentificacionDelTipoIdentificacionCpevcAnexoCInstance(AnexoC tipoIdentificacionDelTipoIdentificacionCpevcAnexoC) {
        this.tipoIdentificacionDelTipoIdentificacionCpevcAnexoCInstance = tipoIdentificacionDelTipoIdentificacionCpevcAnexoC;
        this.tipoIdentificacionDelTipoIdentificacionCpevcAnexoC = tipoIdentificacionDelTipoIdentificacionCpevcAnexoC != null ? tipoIdentificacionDelTipoIdentificacionCpevcAnexoC.getOid() : null;
    }

    private void checkTipoIdentificacionDelTipoIdentificacionCpevcAnexoC() throws NotNullArgumentException {
        if(this.getTipoIdentificacionDelTipoIdentificacionCpevcAnexoCInstance() == null || this.getTipoIdentificacionDelTipoIdentificacionCpevcAnexoCInstance().isNull()) {
            throw new NotNullArgumentException(TipoIdentificacionConstants.SERV_ID_DELTIPOIDENTIFICACIONC, TipoIdentificacionConstants.CLASS_ID, TipoIdentificacionConstants.ARG_ID_DELTIPOIDENTIFICACIONC_TIPOIDENTIFICACIONDELTIPOIDENTIFICACIONCPEVCANEXOC, TipoIdentificacionConstants.SERV_ALIAS_DELTIPOIDENTIFICACIONC, TipoIdentificacionConstants.CLASS_ALIAS, TipoIdentificacionConstants.ARG_ALIAS_DELTIPOIDENTIFICACIONC_TIPOIDENTIFICACIONDELTIPOIDENTIFICACIONCPEVCANEXOC);
        }
    }
}
