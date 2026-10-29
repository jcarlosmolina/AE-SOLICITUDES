package com.keralty.aesolicitudes.viewmodel.departamento.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DepartamentoConstants;
import com.keralty.aesolicitudes.persistence.Departamento;
import com.keralty.aesolicitudes.persistence.oid.DepartamentoOid;
import com.keralty.aesolicitudes.persistence.oid.TitularOid;
import com.keralty.aesolicitudes.persistence.Titular;

public class InsDepartamentoNacTitularRequest {

    @JsonProperty("p_thisdepartamento_oid")
    private DepartamentoOid departamentoInsDepartamentoNacTitularpthisDepartamento;
    
    @JsonIgnore
    private Departamento departamentoInsDepartamentoNacTitularpthisDepartamentoInstance;

    @JsonProperty("p_evctitular_oid")
    private TitularOid departamentoInsDepartamentoNacTitularpevcTitular;
    
    @JsonIgnore
    private Titular departamentoInsDepartamentoNacTitularpevcTitularInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkDepartamentoInsDepartamentoNacTitularpthisDepartamento();
        checkDepartamentoInsDepartamentoNacTitularpevcTitular();
    }

    @JsonIgnore
    public DepartamentoOid getDepartamentoInsDepartamentoNacTitularpthisDepartamento() {
        return this.departamentoInsDepartamentoNacTitularpthisDepartamento;
    }
    
    public void setDepartamentoInsDepartamentoNacTitularpthisDepartamento(DepartamentoOid departamentoInsDepartamentoNacTitularpthisDepartamento) {
        this.departamentoInsDepartamentoNacTitularpthisDepartamento = departamentoInsDepartamentoNacTitularpthisDepartamento;
    }

    @JsonIgnore
    public Departamento getDepartamentoInsDepartamentoNacTitularpthisDepartamentoInstance() {
        return this.departamentoInsDepartamentoNacTitularpthisDepartamentoInstance;
    }
    
    public void setDepartamentoInsDepartamentoNacTitularpthisDepartamentoInstance(Departamento departamentoInsDepartamentoNacTitularpthisDepartamento) {
        this.departamentoInsDepartamentoNacTitularpthisDepartamentoInstance = departamentoInsDepartamentoNacTitularpthisDepartamento;
        this.departamentoInsDepartamentoNacTitularpthisDepartamento = departamentoInsDepartamentoNacTitularpthisDepartamento != null ? departamentoInsDepartamentoNacTitularpthisDepartamento.getOid() : null;
    }

    private void checkDepartamentoInsDepartamentoNacTitularpthisDepartamento() throws NotNullArgumentException {
        if(this.getDepartamentoInsDepartamentoNacTitularpthisDepartamentoInstance() == null || this.getDepartamentoInsDepartamentoNacTitularpthisDepartamentoInstance().isNull()) {
            throw new NotNullArgumentException(DepartamentoConstants.SERV_ID_INSDEPARTAMENTONACTITULAR, DepartamentoConstants.CLASS_ID, DepartamentoConstants.ARG_ID_INSDEPARTAMENTONACTITULAR_DEPARTAMENTOINSDEPARTAMENTONACTITULARPTHISDEPARTAMENTO, DepartamentoConstants.SERV_ALIAS_INSDEPARTAMENTONACTITULAR, DepartamentoConstants.CLASS_ALIAS, DepartamentoConstants.ARG_ALIAS_INSDEPARTAMENTONACTITULAR_DEPARTAMENTOINSDEPARTAMENTONACTITULARPTHISDEPARTAMENTO);
        }
    }

    @JsonIgnore
    public TitularOid getDepartamentoInsDepartamentoNacTitularpevcTitular() {
        return this.departamentoInsDepartamentoNacTitularpevcTitular;
    }
    
    public void setDepartamentoInsDepartamentoNacTitularpevcTitular(TitularOid departamentoInsDepartamentoNacTitularpevcTitular) {
        this.departamentoInsDepartamentoNacTitularpevcTitular = departamentoInsDepartamentoNacTitularpevcTitular;
    }

    @JsonIgnore
    public Titular getDepartamentoInsDepartamentoNacTitularpevcTitularInstance() {
        return this.departamentoInsDepartamentoNacTitularpevcTitularInstance;
    }
    
    public void setDepartamentoInsDepartamentoNacTitularpevcTitularInstance(Titular departamentoInsDepartamentoNacTitularpevcTitular) {
        this.departamentoInsDepartamentoNacTitularpevcTitularInstance = departamentoInsDepartamentoNacTitularpevcTitular;
        this.departamentoInsDepartamentoNacTitularpevcTitular = departamentoInsDepartamentoNacTitularpevcTitular != null ? departamentoInsDepartamentoNacTitularpevcTitular.getOid() : null;
    }

    private void checkDepartamentoInsDepartamentoNacTitularpevcTitular() throws NotNullArgumentException {
        if(this.getDepartamentoInsDepartamentoNacTitularpevcTitularInstance() == null || this.getDepartamentoInsDepartamentoNacTitularpevcTitularInstance().isNull()) {
            throw new NotNullArgumentException(DepartamentoConstants.SERV_ID_INSDEPARTAMENTONACTITULAR, DepartamentoConstants.CLASS_ID, DepartamentoConstants.ARG_ID_INSDEPARTAMENTONACTITULAR_DEPARTAMENTOINSDEPARTAMENTONACTITULARPEVCTITULAR, DepartamentoConstants.SERV_ALIAS_INSDEPARTAMENTONACTITULAR, DepartamentoConstants.CLASS_ALIAS, DepartamentoConstants.ARG_ALIAS_INSDEPARTAMENTONACTITULAR_DEPARTAMENTOINSDEPARTAMENTONACTITULARPEVCTITULAR);
        }
    }
}
