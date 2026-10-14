package com.keralty.aesolicitudes.viewmodel.protecciondatos.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.oid.ProteccionDatosOid;
import com.keralty.aesolicitudes.persistence.ProteccionDatos;
import com.keralty.aesolicitudes.viewmodel.ServiceResponse;
import java.util.HashMap;
import java.util.Map;

public class TCREARSOLNOVEDADEXCEPCIONResponse extends ServiceResponse {


    @JsonProperty("ps_thispd")
    private ProteccionDatosOid proteccionDatosTCREARSOLNOVEDADEXCEPCIONpsThisPD;
    
    @JsonIgnore
    private ProteccionDatos proteccionDatosTCREARSOLNOVEDADEXCEPCIONpsThisPDInstance;

    public TCREARSOLNOVEDADEXCEPCIONResponse() {
        super();
    }

    @JsonIgnore
    public ProteccionDatosOid getProteccionDatosTCREARSOLNOVEDADEXCEPCIONpsThisPD() {
        return this.proteccionDatosTCREARSOLNOVEDADEXCEPCIONpsThisPD;
    }
    
    public void setProteccionDatosTCREARSOLNOVEDADEXCEPCIONpsThisPD(ProteccionDatosOid proteccionDatosTCREARSOLNOVEDADEXCEPCIONpsThisPD) {
        this.proteccionDatosTCREARSOLNOVEDADEXCEPCIONpsThisPD = proteccionDatosTCREARSOLNOVEDADEXCEPCIONpsThisPD;
    }
    @JsonIgnore
    public ProteccionDatos getProteccionDatosTCREARSOLNOVEDADEXCEPCIONpsThisPDInstance() {
        return this.proteccionDatosTCREARSOLNOVEDADEXCEPCIONpsThisPDInstance;
    }
    
    public void setProteccionDatosTCREARSOLNOVEDADEXCEPCIONpsThisPDInstance(ProteccionDatos proteccionDatosTCREARSOLNOVEDADEXCEPCIONpsThisPD) {
        if (proteccionDatosTCREARSOLNOVEDADEXCEPCIONpsThisPD != null && !proteccionDatosTCREARSOLNOVEDADEXCEPCIONpsThisPD.isNull()) {
            this.proteccionDatosTCREARSOLNOVEDADEXCEPCIONpsThisPD = proteccionDatosTCREARSOLNOVEDADEXCEPCIONpsThisPD.getOid();
            this.proteccionDatosTCREARSOLNOVEDADEXCEPCIONpsThisPDInstance = proteccionDatosTCREARSOLNOVEDADEXCEPCIONpsThisPD;
        } else {
            this.proteccionDatosTCREARSOLNOVEDADEXCEPCIONpsThisPD = null;
            this.proteccionDatosTCREARSOLNOVEDADEXCEPCIONpsThisPDInstance = null;
        }
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("proteccionDatosTCREARSOLNOVEDADEXCEPCIONpsThisPD", proteccionDatosTCREARSOLNOVEDADEXCEPCIONpsThisPD);
        return outArgs;
    }
}
