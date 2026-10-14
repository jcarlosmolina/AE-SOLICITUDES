package com.keralty.aesolicitudes.viewmodel.estadobeneficiario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.EstadoBeneficiarioConstants;
import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.EstadoBeneficiario;
import com.keralty.aesolicitudes.persistence.oid.BeneficiarioCOid;
import com.keralty.aesolicitudes.persistence.oid.EstadoBeneficiarioOid;

public class InsEstadoBeneficiarioCRequest {

    @JsonProperty("p_thisestadobeneficiario_oid")
    private EstadoBeneficiarioOid estadoBeneficiarioInsEstadoBeneficiarioCpthisEstadoBeneficiario;
    
    @JsonIgnore
    private EstadoBeneficiario estadoBeneficiarioInsEstadoBeneficiarioCpthisEstadoBeneficiarioInstance;

    @JsonProperty("p_evcbeneficiarioc_oid")
    private BeneficiarioCOid estadoBeneficiarioInsEstadoBeneficiarioCpevcBeneficiarioC;
    
    @JsonIgnore
    private BeneficiarioC estadoBeneficiarioInsEstadoBeneficiarioCpevcBeneficiarioCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkEstadoBeneficiarioInsEstadoBeneficiarioCpthisEstadoBeneficiario();
        checkEstadoBeneficiarioInsEstadoBeneficiarioCpevcBeneficiarioC();
    }

    @JsonIgnore
    public EstadoBeneficiarioOid getEstadoBeneficiarioInsEstadoBeneficiarioCpthisEstadoBeneficiario() {
        return this.estadoBeneficiarioInsEstadoBeneficiarioCpthisEstadoBeneficiario;
    }
    
    public void setEstadoBeneficiarioInsEstadoBeneficiarioCpthisEstadoBeneficiario(EstadoBeneficiarioOid estadoBeneficiarioInsEstadoBeneficiarioCpthisEstadoBeneficiario) {
        this.estadoBeneficiarioInsEstadoBeneficiarioCpthisEstadoBeneficiario = estadoBeneficiarioInsEstadoBeneficiarioCpthisEstadoBeneficiario;
    }

    @JsonIgnore
    public EstadoBeneficiario getEstadoBeneficiarioInsEstadoBeneficiarioCpthisEstadoBeneficiarioInstance() {
        return this.estadoBeneficiarioInsEstadoBeneficiarioCpthisEstadoBeneficiarioInstance;
    }
    
    public void setEstadoBeneficiarioInsEstadoBeneficiarioCpthisEstadoBeneficiarioInstance(EstadoBeneficiario estadoBeneficiarioInsEstadoBeneficiarioCpthisEstadoBeneficiario) {
        this.estadoBeneficiarioInsEstadoBeneficiarioCpthisEstadoBeneficiarioInstance = estadoBeneficiarioInsEstadoBeneficiarioCpthisEstadoBeneficiario;
        this.estadoBeneficiarioInsEstadoBeneficiarioCpthisEstadoBeneficiario = estadoBeneficiarioInsEstadoBeneficiarioCpthisEstadoBeneficiario != null ? estadoBeneficiarioInsEstadoBeneficiarioCpthisEstadoBeneficiario.getOid() : null;
    }

    private void checkEstadoBeneficiarioInsEstadoBeneficiarioCpthisEstadoBeneficiario() throws NotNullArgumentException {
        if(this.getEstadoBeneficiarioInsEstadoBeneficiarioCpthisEstadoBeneficiarioInstance() == null || this.getEstadoBeneficiarioInsEstadoBeneficiarioCpthisEstadoBeneficiarioInstance().isNull()) {
            throw new NotNullArgumentException(EstadoBeneficiarioConstants.SERV_ID_INSESTADOBENEFICIARIOC, EstadoBeneficiarioConstants.CLASS_ID, EstadoBeneficiarioConstants.ARG_ID_INSESTADOBENEFICIARIOC_ESTADOBENEFICIARIOINSESTADOBENEFICIARIOCPTHISESTADOBENEFICIARIO, EstadoBeneficiarioConstants.SERV_ALIAS_INSESTADOBENEFICIARIOC, EstadoBeneficiarioConstants.CLASS_ALIAS, EstadoBeneficiarioConstants.ARG_ALIAS_INSESTADOBENEFICIARIOC_ESTADOBENEFICIARIOINSESTADOBENEFICIARIOCPTHISESTADOBENEFICIARIO);
        }
    }

    @JsonIgnore
    public BeneficiarioCOid getEstadoBeneficiarioInsEstadoBeneficiarioCpevcBeneficiarioC() {
        return this.estadoBeneficiarioInsEstadoBeneficiarioCpevcBeneficiarioC;
    }
    
    public void setEstadoBeneficiarioInsEstadoBeneficiarioCpevcBeneficiarioC(BeneficiarioCOid estadoBeneficiarioInsEstadoBeneficiarioCpevcBeneficiarioC) {
        this.estadoBeneficiarioInsEstadoBeneficiarioCpevcBeneficiarioC = estadoBeneficiarioInsEstadoBeneficiarioCpevcBeneficiarioC;
    }

    @JsonIgnore
    public BeneficiarioC getEstadoBeneficiarioInsEstadoBeneficiarioCpevcBeneficiarioCInstance() {
        return this.estadoBeneficiarioInsEstadoBeneficiarioCpevcBeneficiarioCInstance;
    }
    
    public void setEstadoBeneficiarioInsEstadoBeneficiarioCpevcBeneficiarioCInstance(BeneficiarioC estadoBeneficiarioInsEstadoBeneficiarioCpevcBeneficiarioC) {
        this.estadoBeneficiarioInsEstadoBeneficiarioCpevcBeneficiarioCInstance = estadoBeneficiarioInsEstadoBeneficiarioCpevcBeneficiarioC;
        this.estadoBeneficiarioInsEstadoBeneficiarioCpevcBeneficiarioC = estadoBeneficiarioInsEstadoBeneficiarioCpevcBeneficiarioC != null ? estadoBeneficiarioInsEstadoBeneficiarioCpevcBeneficiarioC.getOid() : null;
    }

    private void checkEstadoBeneficiarioInsEstadoBeneficiarioCpevcBeneficiarioC() throws NotNullArgumentException {
        if(this.getEstadoBeneficiarioInsEstadoBeneficiarioCpevcBeneficiarioCInstance() == null || this.getEstadoBeneficiarioInsEstadoBeneficiarioCpevcBeneficiarioCInstance().isNull()) {
            throw new NotNullArgumentException(EstadoBeneficiarioConstants.SERV_ID_INSESTADOBENEFICIARIOC, EstadoBeneficiarioConstants.CLASS_ID, EstadoBeneficiarioConstants.ARG_ID_INSESTADOBENEFICIARIOC_ESTADOBENEFICIARIOINSESTADOBENEFICIARIOCPEVCBENEFICIARIOC, EstadoBeneficiarioConstants.SERV_ALIAS_INSESTADOBENEFICIARIOC, EstadoBeneficiarioConstants.CLASS_ALIAS, EstadoBeneficiarioConstants.ARG_ALIAS_INSESTADOBENEFICIARIOC_ESTADOBENEFICIARIOINSESTADOBENEFICIARIOCPEVCBENEFICIARIOC);
        }
    }
}
