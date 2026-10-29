package com.keralty.aesolicitudes.viewmodel.estadocontrato.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.EstadoContratoConstants;
import com.keralty.aesolicitudes.persistence.Aesolicitudes;
import com.keralty.aesolicitudes.persistence.EstadoContrato;
import com.keralty.aesolicitudes.persistence.oid.AesolicitudesOid;
import com.keralty.aesolicitudes.persistence.oid.EstadoContratoOid;

public class DelESTADOSOLICITUDRequest {

    @JsonProperty("p_thisestadocontrato_oid")
    private EstadoContratoOid estadoContratoDelESTADOSOLICITUDpthisEstadoContrato;
    
    @JsonIgnore
    private EstadoContrato estadoContratoDelESTADOSOLICITUDpthisEstadoContratoInstance;

    @JsonProperty("p_evcae_solicitudes_oid")
    private AesolicitudesOid estadoContratoDelESTADOSOLICITUDpevcAesolicitudes;
    
    @JsonIgnore
    private Aesolicitudes estadoContratoDelESTADOSOLICITUDpevcAesolicitudesInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkEstadoContratoDelESTADOSOLICITUDpthisEstadoContrato();
        checkEstadoContratoDelESTADOSOLICITUDpevcAesolicitudes();
    }

    @JsonIgnore
    public EstadoContratoOid getEstadoContratoDelESTADOSOLICITUDpthisEstadoContrato() {
        return this.estadoContratoDelESTADOSOLICITUDpthisEstadoContrato;
    }
    
    public void setEstadoContratoDelESTADOSOLICITUDpthisEstadoContrato(EstadoContratoOid estadoContratoDelESTADOSOLICITUDpthisEstadoContrato) {
        this.estadoContratoDelESTADOSOLICITUDpthisEstadoContrato = estadoContratoDelESTADOSOLICITUDpthisEstadoContrato;
    }

    @JsonIgnore
    public EstadoContrato getEstadoContratoDelESTADOSOLICITUDpthisEstadoContratoInstance() {
        return this.estadoContratoDelESTADOSOLICITUDpthisEstadoContratoInstance;
    }
    
    public void setEstadoContratoDelESTADOSOLICITUDpthisEstadoContratoInstance(EstadoContrato estadoContratoDelESTADOSOLICITUDpthisEstadoContrato) {
        this.estadoContratoDelESTADOSOLICITUDpthisEstadoContratoInstance = estadoContratoDelESTADOSOLICITUDpthisEstadoContrato;
        this.estadoContratoDelESTADOSOLICITUDpthisEstadoContrato = estadoContratoDelESTADOSOLICITUDpthisEstadoContrato != null ? estadoContratoDelESTADOSOLICITUDpthisEstadoContrato.getOid() : null;
    }

    private void checkEstadoContratoDelESTADOSOLICITUDpthisEstadoContrato() throws NotNullArgumentException {
        if(this.getEstadoContratoDelESTADOSOLICITUDpthisEstadoContratoInstance() == null || this.getEstadoContratoDelESTADOSOLICITUDpthisEstadoContratoInstance().isNull()) {
            throw new NotNullArgumentException(EstadoContratoConstants.SERV_ID_DELESTADOSOLICITUD, EstadoContratoConstants.CLASS_ID, EstadoContratoConstants.ARG_ID_DELESTADOSOLICITUD_ESTADOCONTRATODELESTADOSOLICITUDPTHISESTADOCONTRATO, EstadoContratoConstants.SERV_ALIAS_DELESTADOSOLICITUD, EstadoContratoConstants.CLASS_ALIAS, EstadoContratoConstants.ARG_ALIAS_DELESTADOSOLICITUD_ESTADOCONTRATODELESTADOSOLICITUDPTHISESTADOCONTRATO);
        }
    }

    @JsonIgnore
    public AesolicitudesOid getEstadoContratoDelESTADOSOLICITUDpevcAesolicitudes() {
        return this.estadoContratoDelESTADOSOLICITUDpevcAesolicitudes;
    }
    
    public void setEstadoContratoDelESTADOSOLICITUDpevcAesolicitudes(AesolicitudesOid estadoContratoDelESTADOSOLICITUDpevcAesolicitudes) {
        this.estadoContratoDelESTADOSOLICITUDpevcAesolicitudes = estadoContratoDelESTADOSOLICITUDpevcAesolicitudes;
    }

    @JsonIgnore
    public Aesolicitudes getEstadoContratoDelESTADOSOLICITUDpevcAesolicitudesInstance() {
        return this.estadoContratoDelESTADOSOLICITUDpevcAesolicitudesInstance;
    }
    
    public void setEstadoContratoDelESTADOSOLICITUDpevcAesolicitudesInstance(Aesolicitudes estadoContratoDelESTADOSOLICITUDpevcAesolicitudes) {
        this.estadoContratoDelESTADOSOLICITUDpevcAesolicitudesInstance = estadoContratoDelESTADOSOLICITUDpevcAesolicitudes;
        this.estadoContratoDelESTADOSOLICITUDpevcAesolicitudes = estadoContratoDelESTADOSOLICITUDpevcAesolicitudes != null ? estadoContratoDelESTADOSOLICITUDpevcAesolicitudes.getOid() : null;
    }

    private void checkEstadoContratoDelESTADOSOLICITUDpevcAesolicitudes() throws NotNullArgumentException {
        if(this.getEstadoContratoDelESTADOSOLICITUDpevcAesolicitudesInstance() == null || this.getEstadoContratoDelESTADOSOLICITUDpevcAesolicitudesInstance().isNull()) {
            throw new NotNullArgumentException(EstadoContratoConstants.SERV_ID_DELESTADOSOLICITUD, EstadoContratoConstants.CLASS_ID, EstadoContratoConstants.ARG_ID_DELESTADOSOLICITUD_ESTADOCONTRATODELESTADOSOLICITUDPEVCAESOLICITUDES, EstadoContratoConstants.SERV_ALIAS_DELESTADOSOLICITUD, EstadoContratoConstants.CLASS_ALIAS, EstadoContratoConstants.ARG_ALIAS_DELESTADOSOLICITUD_ESTADOCONTRATODELESTADOSOLICITUDPEVCAESOLICITUDES);
        }
    }
}
