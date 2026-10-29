package com.keralty.aesolicitudes.viewmodel.protecciondatos.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.oid.ProteccionDatosOid;
import com.keralty.aesolicitudes.persistence.ProteccionDatos;
import com.keralty.aesolicitudes.viewmodel.ServiceResponse;
import java.util.HashMap;
import java.util.Map;

public class TCREARPROTECCIONDATOSINCResponse extends ServiceResponse {


    @JsonProperty("ps_thispd")
    private ProteccionDatosOid proteccionDatosTCREARPROTECCIONDATOSINCpsThisPD;
    
    @JsonIgnore
    private ProteccionDatos proteccionDatosTCREARPROTECCIONDATOSINCpsThisPDInstance;

    public TCREARPROTECCIONDATOSINCResponse() {
        super();
    }

    @JsonIgnore
    public ProteccionDatosOid getProteccionDatosTCREARPROTECCIONDATOSINCpsThisPD() {
        return this.proteccionDatosTCREARPROTECCIONDATOSINCpsThisPD;
    }
    
    public void setProteccionDatosTCREARPROTECCIONDATOSINCpsThisPD(ProteccionDatosOid proteccionDatosTCREARPROTECCIONDATOSINCpsThisPD) {
        this.proteccionDatosTCREARPROTECCIONDATOSINCpsThisPD = proteccionDatosTCREARPROTECCIONDATOSINCpsThisPD;
    }
    @JsonIgnore
    public ProteccionDatos getProteccionDatosTCREARPROTECCIONDATOSINCpsThisPDInstance() {
        return this.proteccionDatosTCREARPROTECCIONDATOSINCpsThisPDInstance;
    }
    
    public void setProteccionDatosTCREARPROTECCIONDATOSINCpsThisPDInstance(ProteccionDatos proteccionDatosTCREARPROTECCIONDATOSINCpsThisPD) {
        if (proteccionDatosTCREARPROTECCIONDATOSINCpsThisPD != null && !proteccionDatosTCREARPROTECCIONDATOSINCpsThisPD.isNull()) {
            this.proteccionDatosTCREARPROTECCIONDATOSINCpsThisPD = proteccionDatosTCREARPROTECCIONDATOSINCpsThisPD.getOid();
            this.proteccionDatosTCREARPROTECCIONDATOSINCpsThisPDInstance = proteccionDatosTCREARPROTECCIONDATOSINCpsThisPD;
        } else {
            this.proteccionDatosTCREARPROTECCIONDATOSINCpsThisPD = null;
            this.proteccionDatosTCREARPROTECCIONDATOSINCpsThisPDInstance = null;
        }
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("proteccionDatosTCREARPROTECCIONDATOSINCpsThisPD", proteccionDatosTCREARPROTECCIONDATOSINCpsThisPD);
        return outArgs;
    }
}
