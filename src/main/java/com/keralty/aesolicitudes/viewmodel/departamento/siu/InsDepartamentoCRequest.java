package com.keralty.aesolicitudes.viewmodel.departamento.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DepartamentoConstants;
import com.keralty.aesolicitudes.persistence.Departamento;
import com.keralty.aesolicitudes.persistence.DireccionC;
import com.keralty.aesolicitudes.persistence.oid.DepartamentoOid;
import com.keralty.aesolicitudes.persistence.oid.DireccionCOid;

public class InsDepartamentoCRequest {

    @JsonProperty("p_thisdepartamento_oid")
    private DepartamentoOid departamentoInsDepartamentoCpthisDepartamento;
    
    @JsonIgnore
    private Departamento departamentoInsDepartamentoCpthisDepartamentoInstance;

    @JsonProperty("p_evcdireccionc_oid")
    private DireccionCOid departamentoInsDepartamentoCpevcDireccionC;
    
    @JsonIgnore
    private DireccionC departamentoInsDepartamentoCpevcDireccionCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkDepartamentoInsDepartamentoCpthisDepartamento();
        checkDepartamentoInsDepartamentoCpevcDireccionC();
    }

    @JsonIgnore
    public DepartamentoOid getDepartamentoInsDepartamentoCpthisDepartamento() {
        return this.departamentoInsDepartamentoCpthisDepartamento;
    }
    
    public void setDepartamentoInsDepartamentoCpthisDepartamento(DepartamentoOid departamentoInsDepartamentoCpthisDepartamento) {
        this.departamentoInsDepartamentoCpthisDepartamento = departamentoInsDepartamentoCpthisDepartamento;
    }

    @JsonIgnore
    public Departamento getDepartamentoInsDepartamentoCpthisDepartamentoInstance() {
        return this.departamentoInsDepartamentoCpthisDepartamentoInstance;
    }
    
    public void setDepartamentoInsDepartamentoCpthisDepartamentoInstance(Departamento departamentoInsDepartamentoCpthisDepartamento) {
        this.departamentoInsDepartamentoCpthisDepartamentoInstance = departamentoInsDepartamentoCpthisDepartamento;
        this.departamentoInsDepartamentoCpthisDepartamento = departamentoInsDepartamentoCpthisDepartamento != null ? departamentoInsDepartamentoCpthisDepartamento.getOid() : null;
    }

    private void checkDepartamentoInsDepartamentoCpthisDepartamento() throws NotNullArgumentException {
        if(this.getDepartamentoInsDepartamentoCpthisDepartamentoInstance() == null || this.getDepartamentoInsDepartamentoCpthisDepartamentoInstance().isNull()) {
            throw new NotNullArgumentException(DepartamentoConstants.SERV_ID_INSDEPARTAMENTOC, DepartamentoConstants.CLASS_ID, DepartamentoConstants.ARG_ID_INSDEPARTAMENTOC_DEPARTAMENTOINSDEPARTAMENTOCPTHISDEPARTAMENTO, DepartamentoConstants.SERV_ALIAS_INSDEPARTAMENTOC, DepartamentoConstants.CLASS_ALIAS, DepartamentoConstants.ARG_ALIAS_INSDEPARTAMENTOC_DEPARTAMENTOINSDEPARTAMENTOCPTHISDEPARTAMENTO);
        }
    }

    @JsonIgnore
    public DireccionCOid getDepartamentoInsDepartamentoCpevcDireccionC() {
        return this.departamentoInsDepartamentoCpevcDireccionC;
    }
    
    public void setDepartamentoInsDepartamentoCpevcDireccionC(DireccionCOid departamentoInsDepartamentoCpevcDireccionC) {
        this.departamentoInsDepartamentoCpevcDireccionC = departamentoInsDepartamentoCpevcDireccionC;
    }

    @JsonIgnore
    public DireccionC getDepartamentoInsDepartamentoCpevcDireccionCInstance() {
        return this.departamentoInsDepartamentoCpevcDireccionCInstance;
    }
    
    public void setDepartamentoInsDepartamentoCpevcDireccionCInstance(DireccionC departamentoInsDepartamentoCpevcDireccionC) {
        this.departamentoInsDepartamentoCpevcDireccionCInstance = departamentoInsDepartamentoCpevcDireccionC;
        this.departamentoInsDepartamentoCpevcDireccionC = departamentoInsDepartamentoCpevcDireccionC != null ? departamentoInsDepartamentoCpevcDireccionC.getOid() : null;
    }

    private void checkDepartamentoInsDepartamentoCpevcDireccionC() throws NotNullArgumentException {
        if(this.getDepartamentoInsDepartamentoCpevcDireccionCInstance() == null || this.getDepartamentoInsDepartamentoCpevcDireccionCInstance().isNull()) {
            throw new NotNullArgumentException(DepartamentoConstants.SERV_ID_INSDEPARTAMENTOC, DepartamentoConstants.CLASS_ID, DepartamentoConstants.ARG_ID_INSDEPARTAMENTOC_DEPARTAMENTOINSDEPARTAMENTOCPEVCDIRECCIONC, DepartamentoConstants.SERV_ALIAS_INSDEPARTAMENTOC, DepartamentoConstants.CLASS_ALIAS, DepartamentoConstants.ARG_ALIAS_INSDEPARTAMENTOC_DEPARTAMENTOINSDEPARTAMENTOCPEVCDIRECCIONC);
        }
    }
}
