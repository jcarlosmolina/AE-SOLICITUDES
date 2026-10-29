package com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.AesolicitudesConstants;
import com.keralty.aesolicitudes.persistence.Aesolicitudes;
import com.keralty.aesolicitudes.persistence.EstadoContrato;
import com.keralty.aesolicitudes.persistence.oid.AesolicitudesOid;
import com.keralty.aesolicitudes.persistence.oid.EstadoContratoOid;

public class DelESTADOSOLICITUDRequest {

    @JsonProperty("p_thisae_solicitudes_oid")
    private AesolicitudesOid aesolicitudesDelESTADOSOLICITUDpthisAESOLICITUDES;
    
    @JsonIgnore
    private Aesolicitudes aesolicitudesDelESTADOSOLICITUDpthisAESOLICITUDESInstance;

    @JsonProperty("p_evcestadocontrato_oid")
    private EstadoContratoOid aesolicitudesDelESTADOSOLICITUDpevcEstadoContrato;
    
    @JsonIgnore
    private EstadoContrato aesolicitudesDelESTADOSOLICITUDpevcEstadoContratoInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkAesolicitudesDelESTADOSOLICITUDpthisAESOLICITUDES();
        checkAesolicitudesDelESTADOSOLICITUDpevcEstadoContrato();
    }

    @JsonIgnore
    public AesolicitudesOid getAesolicitudesDelESTADOSOLICITUDpthisAESOLICITUDES() {
        return this.aesolicitudesDelESTADOSOLICITUDpthisAESOLICITUDES;
    }
    
    public void setAesolicitudesDelESTADOSOLICITUDpthisAESOLICITUDES(AesolicitudesOid aesolicitudesDelESTADOSOLICITUDpthisAESOLICITUDES) {
        this.aesolicitudesDelESTADOSOLICITUDpthisAESOLICITUDES = aesolicitudesDelESTADOSOLICITUDpthisAESOLICITUDES;
    }

    @JsonIgnore
    public Aesolicitudes getAesolicitudesDelESTADOSOLICITUDpthisAESOLICITUDESInstance() {
        return this.aesolicitudesDelESTADOSOLICITUDpthisAESOLICITUDESInstance;
    }
    
    public void setAesolicitudesDelESTADOSOLICITUDpthisAESOLICITUDESInstance(Aesolicitudes aesolicitudesDelESTADOSOLICITUDpthisAESOLICITUDES) {
        this.aesolicitudesDelESTADOSOLICITUDpthisAESOLICITUDESInstance = aesolicitudesDelESTADOSOLICITUDpthisAESOLICITUDES;
        this.aesolicitudesDelESTADOSOLICITUDpthisAESOLICITUDES = aesolicitudesDelESTADOSOLICITUDpthisAESOLICITUDES != null ? aesolicitudesDelESTADOSOLICITUDpthisAESOLICITUDES.getOid() : null;
    }

    private void checkAesolicitudesDelESTADOSOLICITUDpthisAESOLICITUDES() throws NotNullArgumentException {
        if(this.getAesolicitudesDelESTADOSOLICITUDpthisAESOLICITUDESInstance() == null || this.getAesolicitudesDelESTADOSOLICITUDpthisAESOLICITUDESInstance().isNull()) {
            throw new NotNullArgumentException(AesolicitudesConstants.SERV_ID_DELESTADOSOLICITUD, AesolicitudesConstants.CLASS_ID, AesolicitudesConstants.ARG_ID_DELESTADOSOLICITUD_AESOLICITUDESDELESTADOSOLICITUDPTHISAESOLICITUDES, AesolicitudesConstants.SERV_ALIAS_DELESTADOSOLICITUD, AesolicitudesConstants.CLASS_ALIAS, AesolicitudesConstants.ARG_ALIAS_DELESTADOSOLICITUD_AESOLICITUDESDELESTADOSOLICITUDPTHISAESOLICITUDES);
        }
    }

    @JsonIgnore
    public EstadoContratoOid getAesolicitudesDelESTADOSOLICITUDpevcEstadoContrato() {
        return this.aesolicitudesDelESTADOSOLICITUDpevcEstadoContrato;
    }
    
    public void setAesolicitudesDelESTADOSOLICITUDpevcEstadoContrato(EstadoContratoOid aesolicitudesDelESTADOSOLICITUDpevcEstadoContrato) {
        this.aesolicitudesDelESTADOSOLICITUDpevcEstadoContrato = aesolicitudesDelESTADOSOLICITUDpevcEstadoContrato;
    }

    @JsonIgnore
    public EstadoContrato getAesolicitudesDelESTADOSOLICITUDpevcEstadoContratoInstance() {
        return this.aesolicitudesDelESTADOSOLICITUDpevcEstadoContratoInstance;
    }
    
    public void setAesolicitudesDelESTADOSOLICITUDpevcEstadoContratoInstance(EstadoContrato aesolicitudesDelESTADOSOLICITUDpevcEstadoContrato) {
        this.aesolicitudesDelESTADOSOLICITUDpevcEstadoContratoInstance = aesolicitudesDelESTADOSOLICITUDpevcEstadoContrato;
        this.aesolicitudesDelESTADOSOLICITUDpevcEstadoContrato = aesolicitudesDelESTADOSOLICITUDpevcEstadoContrato != null ? aesolicitudesDelESTADOSOLICITUDpevcEstadoContrato.getOid() : null;
    }

    private void checkAesolicitudesDelESTADOSOLICITUDpevcEstadoContrato() throws NotNullArgumentException {
        if(this.getAesolicitudesDelESTADOSOLICITUDpevcEstadoContratoInstance() == null || this.getAesolicitudesDelESTADOSOLICITUDpevcEstadoContratoInstance().isNull()) {
            throw new NotNullArgumentException(AesolicitudesConstants.SERV_ID_DELESTADOSOLICITUD, AesolicitudesConstants.CLASS_ID, AesolicitudesConstants.ARG_ID_DELESTADOSOLICITUD_AESOLICITUDESDELESTADOSOLICITUDPEVCESTADOCONTRATO, AesolicitudesConstants.SERV_ALIAS_DELESTADOSOLICITUD, AesolicitudesConstants.CLASS_ALIAS, AesolicitudesConstants.ARG_ALIAS_DELESTADOSOLICITUD_AESOLICITUDESDELESTADOSOLICITUDPEVCESTADOCONTRATO);
        }
    }
}
