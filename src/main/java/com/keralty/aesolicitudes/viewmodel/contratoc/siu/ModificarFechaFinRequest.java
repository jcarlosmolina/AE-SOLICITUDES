package com.keralty.aesolicitudes.viewmodel.contratoc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ContratoCConstants;
import com.keralty.aesolicitudes.persistence.ContratoC;
import com.keralty.aesolicitudes.persistence.oid.ContratoCOid;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneDeserializer;
import com.keralty.aesolicitudes.viewmodel.SqlDateWithoutTimezoneSerializer;
import java.sql.Date;

public class ModificarFechaFinRequest {

    @JsonProperty("p_thiscontratoc_oid")
    private ContratoCOid contratoCmodificarFechaFinpthisContratoC;
    
    @JsonIgnore
    private ContratoC contratoCmodificarFechaFinpthisContratoCInstance;

    @JsonProperty("p_fechafin")
    @JsonSerialize(using = SqlDateWithoutTimezoneSerializer.class)
    private Date contratoCmodificarFechaFinpFechaFin;

    public void checkArguments() throws NotNullArgumentException {
        checkContratoCmodificarFechaFinpthisContratoC();
        checkContratoCmodificarFechaFinpFechaFin();
    }

    @JsonIgnore
    public ContratoCOid getContratoCmodificarFechaFinpthisContratoC() {
        return this.contratoCmodificarFechaFinpthisContratoC;
    }
    
    public void setContratoCmodificarFechaFinpthisContratoC(ContratoCOid contratoCmodificarFechaFinpthisContratoC) {
        this.contratoCmodificarFechaFinpthisContratoC = contratoCmodificarFechaFinpthisContratoC;
    }

    @JsonIgnore
    public ContratoC getContratoCmodificarFechaFinpthisContratoCInstance() {
        return this.contratoCmodificarFechaFinpthisContratoCInstance;
    }
    
    public void setContratoCmodificarFechaFinpthisContratoCInstance(ContratoC contratoCmodificarFechaFinpthisContratoC) {
        this.contratoCmodificarFechaFinpthisContratoCInstance = contratoCmodificarFechaFinpthisContratoC;
        this.contratoCmodificarFechaFinpthisContratoC = contratoCmodificarFechaFinpthisContratoC != null ? contratoCmodificarFechaFinpthisContratoC.getOid() : null;
    }

    private void checkContratoCmodificarFechaFinpthisContratoC() throws NotNullArgumentException {
        if(this.getContratoCmodificarFechaFinpthisContratoCInstance() == null || this.getContratoCmodificarFechaFinpthisContratoCInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_MODIFICARFECHAFIN, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_MODIFICARFECHAFIN_CONTRATOCMODIFICARFECHAFINPTHISCONTRATOC, ContratoCConstants.SERV_ALIAS_MODIFICARFECHAFIN, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_MODIFICARFECHAFIN_CONTRATOCMODIFICARFECHAFINPTHISCONTRATOC);
        }
    }

    @JsonIgnore
    public Date getContratoCmodificarFechaFinpFechaFin() {
        return this.contratoCmodificarFechaFinpFechaFin;
    }
    
    @JsonDeserialize(using = SqlDateWithoutTimezoneDeserializer.class)
    public void setContratoCmodificarFechaFinpFechaFin(Date contratoCmodificarFechaFinpFechaFin) {
        this.contratoCmodificarFechaFinpFechaFin = contratoCmodificarFechaFinpFechaFin;
    }

    private void checkContratoCmodificarFechaFinpFechaFin() throws NotNullArgumentException {
        if(this.getContratoCmodificarFechaFinpFechaFin() == null) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_MODIFICARFECHAFIN, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_MODIFICARFECHAFIN_CONTRATOCMODIFICARFECHAFINPFECHAFIN, ContratoCConstants.SERV_ALIAS_MODIFICARFECHAFIN, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_MODIFICARFECHAFIN_CONTRATOCMODIFICARFECHAFINPFECHAFIN);
        }
    }
}
