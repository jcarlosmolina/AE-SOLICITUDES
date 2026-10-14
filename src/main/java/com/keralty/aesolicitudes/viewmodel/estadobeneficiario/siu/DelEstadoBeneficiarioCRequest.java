package com.keralty.aesolicitudes.viewmodel.estadobeneficiario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.EstadoBeneficiarioConstants;
import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.EstadoBeneficiario;
import com.keralty.aesolicitudes.persistence.oid.BeneficiarioCOid;
import com.keralty.aesolicitudes.persistence.oid.EstadoBeneficiarioOid;

public class DelEstadoBeneficiarioCRequest {

    @JsonProperty("p_thisestadobeneficiario_oid")
    private EstadoBeneficiarioOid estadoBeneficiarioDelEstadoBeneficiarioCpthisEstadoBeneficiario;
    
    @JsonIgnore
    private EstadoBeneficiario estadoBeneficiarioDelEstadoBeneficiarioCpthisEstadoBeneficiarioInstance;

    @JsonProperty("p_evcbeneficiarioc_oid")
    private BeneficiarioCOid estadoBeneficiarioDelEstadoBeneficiarioCpevcBeneficiarioC;
    
    @JsonIgnore
    private BeneficiarioC estadoBeneficiarioDelEstadoBeneficiarioCpevcBeneficiarioCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkEstadoBeneficiarioDelEstadoBeneficiarioCpthisEstadoBeneficiario();
        checkEstadoBeneficiarioDelEstadoBeneficiarioCpevcBeneficiarioC();
    }

    @JsonIgnore
    public EstadoBeneficiarioOid getEstadoBeneficiarioDelEstadoBeneficiarioCpthisEstadoBeneficiario() {
        return this.estadoBeneficiarioDelEstadoBeneficiarioCpthisEstadoBeneficiario;
    }
    
    public void setEstadoBeneficiarioDelEstadoBeneficiarioCpthisEstadoBeneficiario(EstadoBeneficiarioOid estadoBeneficiarioDelEstadoBeneficiarioCpthisEstadoBeneficiario) {
        this.estadoBeneficiarioDelEstadoBeneficiarioCpthisEstadoBeneficiario = estadoBeneficiarioDelEstadoBeneficiarioCpthisEstadoBeneficiario;
    }

    @JsonIgnore
    public EstadoBeneficiario getEstadoBeneficiarioDelEstadoBeneficiarioCpthisEstadoBeneficiarioInstance() {
        return this.estadoBeneficiarioDelEstadoBeneficiarioCpthisEstadoBeneficiarioInstance;
    }
    
    public void setEstadoBeneficiarioDelEstadoBeneficiarioCpthisEstadoBeneficiarioInstance(EstadoBeneficiario estadoBeneficiarioDelEstadoBeneficiarioCpthisEstadoBeneficiario) {
        this.estadoBeneficiarioDelEstadoBeneficiarioCpthisEstadoBeneficiarioInstance = estadoBeneficiarioDelEstadoBeneficiarioCpthisEstadoBeneficiario;
        this.estadoBeneficiarioDelEstadoBeneficiarioCpthisEstadoBeneficiario = estadoBeneficiarioDelEstadoBeneficiarioCpthisEstadoBeneficiario != null ? estadoBeneficiarioDelEstadoBeneficiarioCpthisEstadoBeneficiario.getOid() : null;
    }

    private void checkEstadoBeneficiarioDelEstadoBeneficiarioCpthisEstadoBeneficiario() throws NotNullArgumentException {
        if(this.getEstadoBeneficiarioDelEstadoBeneficiarioCpthisEstadoBeneficiarioInstance() == null || this.getEstadoBeneficiarioDelEstadoBeneficiarioCpthisEstadoBeneficiarioInstance().isNull()) {
            throw new NotNullArgumentException(EstadoBeneficiarioConstants.SERV_ID_DELESTADOBENEFICIARIOC, EstadoBeneficiarioConstants.CLASS_ID, EstadoBeneficiarioConstants.ARG_ID_DELESTADOBENEFICIARIOC_ESTADOBENEFICIARIODELESTADOBENEFICIARIOCPTHISESTADOBENEFICIARIO, EstadoBeneficiarioConstants.SERV_ALIAS_DELESTADOBENEFICIARIOC, EstadoBeneficiarioConstants.CLASS_ALIAS, EstadoBeneficiarioConstants.ARG_ALIAS_DELESTADOBENEFICIARIOC_ESTADOBENEFICIARIODELESTADOBENEFICIARIOCPTHISESTADOBENEFICIARIO);
        }
    }

    @JsonIgnore
    public BeneficiarioCOid getEstadoBeneficiarioDelEstadoBeneficiarioCpevcBeneficiarioC() {
        return this.estadoBeneficiarioDelEstadoBeneficiarioCpevcBeneficiarioC;
    }
    
    public void setEstadoBeneficiarioDelEstadoBeneficiarioCpevcBeneficiarioC(BeneficiarioCOid estadoBeneficiarioDelEstadoBeneficiarioCpevcBeneficiarioC) {
        this.estadoBeneficiarioDelEstadoBeneficiarioCpevcBeneficiarioC = estadoBeneficiarioDelEstadoBeneficiarioCpevcBeneficiarioC;
    }

    @JsonIgnore
    public BeneficiarioC getEstadoBeneficiarioDelEstadoBeneficiarioCpevcBeneficiarioCInstance() {
        return this.estadoBeneficiarioDelEstadoBeneficiarioCpevcBeneficiarioCInstance;
    }
    
    public void setEstadoBeneficiarioDelEstadoBeneficiarioCpevcBeneficiarioCInstance(BeneficiarioC estadoBeneficiarioDelEstadoBeneficiarioCpevcBeneficiarioC) {
        this.estadoBeneficiarioDelEstadoBeneficiarioCpevcBeneficiarioCInstance = estadoBeneficiarioDelEstadoBeneficiarioCpevcBeneficiarioC;
        this.estadoBeneficiarioDelEstadoBeneficiarioCpevcBeneficiarioC = estadoBeneficiarioDelEstadoBeneficiarioCpevcBeneficiarioC != null ? estadoBeneficiarioDelEstadoBeneficiarioCpevcBeneficiarioC.getOid() : null;
    }

    private void checkEstadoBeneficiarioDelEstadoBeneficiarioCpevcBeneficiarioC() throws NotNullArgumentException {
        if(this.getEstadoBeneficiarioDelEstadoBeneficiarioCpevcBeneficiarioCInstance() == null || this.getEstadoBeneficiarioDelEstadoBeneficiarioCpevcBeneficiarioCInstance().isNull()) {
            throw new NotNullArgumentException(EstadoBeneficiarioConstants.SERV_ID_DELESTADOBENEFICIARIOC, EstadoBeneficiarioConstants.CLASS_ID, EstadoBeneficiarioConstants.ARG_ID_DELESTADOBENEFICIARIOC_ESTADOBENEFICIARIODELESTADOBENEFICIARIOCPEVCBENEFICIARIOC, EstadoBeneficiarioConstants.SERV_ALIAS_DELESTADOBENEFICIARIOC, EstadoBeneficiarioConstants.CLASS_ALIAS, EstadoBeneficiarioConstants.ARG_ALIAS_DELESTADOBENEFICIARIOC_ESTADOBENEFICIARIODELESTADOBENEFICIARIOCPEVCBENEFICIARIOC);
        }
    }
}
