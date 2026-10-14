package com.keralty.aesolicitudes.viewmodel.protecciondatos.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.oid.ProteccionDatosOid;
import com.keralty.aesolicitudes.persistence.ProteccionDatos;
import com.keralty.aesolicitudes.viewmodel.ServiceResponse;
import java.util.HashMap;
import java.util.Map;

public class TCREARPROTECCIONDATOSNAResponse extends ServiceResponse {


    @JsonProperty("ps_thispd")
    private ProteccionDatosOid proteccionDatosTCREARPROTECCIONDATOSNApsThisPD;
    
    @JsonIgnore
    private ProteccionDatos proteccionDatosTCREARPROTECCIONDATOSNApsThisPDInstance;

    public TCREARPROTECCIONDATOSNAResponse() {
        super();
    }

    @JsonIgnore
    public ProteccionDatosOid getProteccionDatosTCREARPROTECCIONDATOSNApsThisPD() {
        return this.proteccionDatosTCREARPROTECCIONDATOSNApsThisPD;
    }
    
    public void setProteccionDatosTCREARPROTECCIONDATOSNApsThisPD(ProteccionDatosOid proteccionDatosTCREARPROTECCIONDATOSNApsThisPD) {
        this.proteccionDatosTCREARPROTECCIONDATOSNApsThisPD = proteccionDatosTCREARPROTECCIONDATOSNApsThisPD;
    }
    @JsonIgnore
    public ProteccionDatos getProteccionDatosTCREARPROTECCIONDATOSNApsThisPDInstance() {
        return this.proteccionDatosTCREARPROTECCIONDATOSNApsThisPDInstance;
    }
    
    public void setProteccionDatosTCREARPROTECCIONDATOSNApsThisPDInstance(ProteccionDatos proteccionDatosTCREARPROTECCIONDATOSNApsThisPD) {
        if (proteccionDatosTCREARPROTECCIONDATOSNApsThisPD != null && !proteccionDatosTCREARPROTECCIONDATOSNApsThisPD.isNull()) {
            this.proteccionDatosTCREARPROTECCIONDATOSNApsThisPD = proteccionDatosTCREARPROTECCIONDATOSNApsThisPD.getOid();
            this.proteccionDatosTCREARPROTECCIONDATOSNApsThisPDInstance = proteccionDatosTCREARPROTECCIONDATOSNApsThisPD;
        } else {
            this.proteccionDatosTCREARPROTECCIONDATOSNApsThisPD = null;
            this.proteccionDatosTCREARPROTECCIONDATOSNApsThisPDInstance = null;
        }
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("proteccionDatosTCREARPROTECCIONDATOSNApsThisPD", proteccionDatosTCREARPROTECCIONDATOSNApsThisPD);
        return outArgs;
    }
}
