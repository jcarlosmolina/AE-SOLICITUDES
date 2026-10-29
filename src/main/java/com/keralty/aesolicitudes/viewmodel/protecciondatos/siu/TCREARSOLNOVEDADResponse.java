package com.keralty.aesolicitudes.viewmodel.protecciondatos.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.oid.ProteccionDatosOid;
import com.keralty.aesolicitudes.persistence.ProteccionDatos;
import com.keralty.aesolicitudes.viewmodel.ServiceResponse;
import java.util.HashMap;
import java.util.Map;

public class TCREARSOLNOVEDADResponse extends ServiceResponse {


    @JsonProperty("ps_thispd")
    private ProteccionDatosOid proteccionDatosTCREARSOLNOVEDADpsThisPD;
    
    @JsonIgnore
    private ProteccionDatos proteccionDatosTCREARSOLNOVEDADpsThisPDInstance;

    public TCREARSOLNOVEDADResponse() {
        super();
    }

    @JsonIgnore
    public ProteccionDatosOid getProteccionDatosTCREARSOLNOVEDADpsThisPD() {
        return this.proteccionDatosTCREARSOLNOVEDADpsThisPD;
    }
    
    public void setProteccionDatosTCREARSOLNOVEDADpsThisPD(ProteccionDatosOid proteccionDatosTCREARSOLNOVEDADpsThisPD) {
        this.proteccionDatosTCREARSOLNOVEDADpsThisPD = proteccionDatosTCREARSOLNOVEDADpsThisPD;
    }
    @JsonIgnore
    public ProteccionDatos getProteccionDatosTCREARSOLNOVEDADpsThisPDInstance() {
        return this.proteccionDatosTCREARSOLNOVEDADpsThisPDInstance;
    }
    
    public void setProteccionDatosTCREARSOLNOVEDADpsThisPDInstance(ProteccionDatos proteccionDatosTCREARSOLNOVEDADpsThisPD) {
        if (proteccionDatosTCREARSOLNOVEDADpsThisPD != null && !proteccionDatosTCREARSOLNOVEDADpsThisPD.isNull()) {
            this.proteccionDatosTCREARSOLNOVEDADpsThisPD = proteccionDatosTCREARSOLNOVEDADpsThisPD.getOid();
            this.proteccionDatosTCREARSOLNOVEDADpsThisPDInstance = proteccionDatosTCREARSOLNOVEDADpsThisPD;
        } else {
            this.proteccionDatosTCREARSOLNOVEDADpsThisPD = null;
            this.proteccionDatosTCREARSOLNOVEDADpsThisPDInstance = null;
        }
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("proteccionDatosTCREARSOLNOVEDADpsThisPD", proteccionDatosTCREARSOLNOVEDADpsThisPD);
        return outArgs;
    }
}
