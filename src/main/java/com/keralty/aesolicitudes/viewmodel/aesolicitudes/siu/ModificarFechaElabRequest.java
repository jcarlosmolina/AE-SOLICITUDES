package com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.AesolicitudesConstants;
import com.keralty.aesolicitudes.persistence.Aesolicitudes;
import com.keralty.aesolicitudes.persistence.oid.AesolicitudesOid;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class ModificarFechaElabRequest {

    @JsonProperty("p_thisae_solicitudes_oid")
    private AesolicitudesOid aesolicitudesmodificarFechaElabpthisAESOLICITUDES;
    
    @JsonIgnore
    private Aesolicitudes aesolicitudesmodificarFechaElabpthisAESOLICITUDESInstance;

    @JsonProperty("pefecha")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date aesolicitudesmodificarFechaElabpeFecha;

    public void checkArguments() throws NotNullArgumentException {
        checkAesolicitudesmodificarFechaElabpthisAESOLICITUDES();
        checkAesolicitudesmodificarFechaElabpeFecha();
    }

    @JsonIgnore
    public AesolicitudesOid getAesolicitudesmodificarFechaElabpthisAESOLICITUDES() {
        return this.aesolicitudesmodificarFechaElabpthisAESOLICITUDES;
    }
    
    public void setAesolicitudesmodificarFechaElabpthisAESOLICITUDES(AesolicitudesOid aesolicitudesmodificarFechaElabpthisAESOLICITUDES) {
        this.aesolicitudesmodificarFechaElabpthisAESOLICITUDES = aesolicitudesmodificarFechaElabpthisAESOLICITUDES;
    }

    @JsonIgnore
    public Aesolicitudes getAesolicitudesmodificarFechaElabpthisAESOLICITUDESInstance() {
        return this.aesolicitudesmodificarFechaElabpthisAESOLICITUDESInstance;
    }
    
    public void setAesolicitudesmodificarFechaElabpthisAESOLICITUDESInstance(Aesolicitudes aesolicitudesmodificarFechaElabpthisAESOLICITUDES) {
        this.aesolicitudesmodificarFechaElabpthisAESOLICITUDESInstance = aesolicitudesmodificarFechaElabpthisAESOLICITUDES;
        this.aesolicitudesmodificarFechaElabpthisAESOLICITUDES = aesolicitudesmodificarFechaElabpthisAESOLICITUDES != null ? aesolicitudesmodificarFechaElabpthisAESOLICITUDES.getOid() : null;
    }

    private void checkAesolicitudesmodificarFechaElabpthisAESOLICITUDES() throws NotNullArgumentException {
        if(this.getAesolicitudesmodificarFechaElabpthisAESOLICITUDESInstance() == null || this.getAesolicitudesmodificarFechaElabpthisAESOLICITUDESInstance().isNull()) {
            throw new NotNullArgumentException(AesolicitudesConstants.SERV_ID_MODIFICARFECHAELAB, AesolicitudesConstants.CLASS_ID, AesolicitudesConstants.ARG_ID_MODIFICARFECHAELAB_AESOLICITUDESMODIFICARFECHAELABPTHISAESOLICITUDES, AesolicitudesConstants.SERV_ALIAS_MODIFICARFECHAELAB, AesolicitudesConstants.CLASS_ALIAS, AesolicitudesConstants.ARG_ALIAS_MODIFICARFECHAELAB_AESOLICITUDESMODIFICARFECHAELABPTHISAESOLICITUDES);
        }
    }

    @JsonIgnore
    public Date getAesolicitudesmodificarFechaElabpeFecha() {
        return this.aesolicitudesmodificarFechaElabpeFecha;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setAesolicitudesmodificarFechaElabpeFecha(Date aesolicitudesmodificarFechaElabpeFecha) {
        this.aesolicitudesmodificarFechaElabpeFecha = aesolicitudesmodificarFechaElabpeFecha;
    }

    private void checkAesolicitudesmodificarFechaElabpeFecha() throws NotNullArgumentException {
        if(this.getAesolicitudesmodificarFechaElabpeFecha() == null) {
            throw new NotNullArgumentException(AesolicitudesConstants.SERV_ID_MODIFICARFECHAELAB, AesolicitudesConstants.CLASS_ID, AesolicitudesConstants.ARG_ID_MODIFICARFECHAELAB_AESOLICITUDESMODIFICARFECHAELABPEFECHA, AesolicitudesConstants.SERV_ALIAS_MODIFICARFECHAELAB, AesolicitudesConstants.CLASS_ALIAS, AesolicitudesConstants.ARG_ALIAS_MODIFICARFECHAELAB_AESOLICITUDESMODIFICARFECHAELABPEFECHA);
        }
    }
}
