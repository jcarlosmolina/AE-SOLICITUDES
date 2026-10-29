package com.keralty.aesolicitudes.viewmodel.departamento.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DepartamentoConstants;
import com.keralty.aesolicitudes.persistence.Departamento;
import com.keralty.aesolicitudes.persistence.DireccionC;
import com.keralty.aesolicitudes.persistence.oid.DepartamentoOid;
import com.keralty.aesolicitudes.persistence.oid.DireccionCOid;

public class DelDepartamentoCRequest {

    @JsonProperty("p_thisdepartamento_oid")
    private DepartamentoOid departamentoDelDepartamentoCpthisDepartamento;
    
    @JsonIgnore
    private Departamento departamentoDelDepartamentoCpthisDepartamentoInstance;

    @JsonProperty("p_evcdireccionc_oid")
    private DireccionCOid departamentoDelDepartamentoCpevcDireccionC;
    
    @JsonIgnore
    private DireccionC departamentoDelDepartamentoCpevcDireccionCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkDepartamentoDelDepartamentoCpthisDepartamento();
        checkDepartamentoDelDepartamentoCpevcDireccionC();
    }

    @JsonIgnore
    public DepartamentoOid getDepartamentoDelDepartamentoCpthisDepartamento() {
        return this.departamentoDelDepartamentoCpthisDepartamento;
    }
    
    public void setDepartamentoDelDepartamentoCpthisDepartamento(DepartamentoOid departamentoDelDepartamentoCpthisDepartamento) {
        this.departamentoDelDepartamentoCpthisDepartamento = departamentoDelDepartamentoCpthisDepartamento;
    }

    @JsonIgnore
    public Departamento getDepartamentoDelDepartamentoCpthisDepartamentoInstance() {
        return this.departamentoDelDepartamentoCpthisDepartamentoInstance;
    }
    
    public void setDepartamentoDelDepartamentoCpthisDepartamentoInstance(Departamento departamentoDelDepartamentoCpthisDepartamento) {
        this.departamentoDelDepartamentoCpthisDepartamentoInstance = departamentoDelDepartamentoCpthisDepartamento;
        this.departamentoDelDepartamentoCpthisDepartamento = departamentoDelDepartamentoCpthisDepartamento != null ? departamentoDelDepartamentoCpthisDepartamento.getOid() : null;
    }

    private void checkDepartamentoDelDepartamentoCpthisDepartamento() throws NotNullArgumentException {
        if(this.getDepartamentoDelDepartamentoCpthisDepartamentoInstance() == null || this.getDepartamentoDelDepartamentoCpthisDepartamentoInstance().isNull()) {
            throw new NotNullArgumentException(DepartamentoConstants.SERV_ID_DELDEPARTAMENTOC, DepartamentoConstants.CLASS_ID, DepartamentoConstants.ARG_ID_DELDEPARTAMENTOC_DEPARTAMENTODELDEPARTAMENTOCPTHISDEPARTAMENTO, DepartamentoConstants.SERV_ALIAS_DELDEPARTAMENTOC, DepartamentoConstants.CLASS_ALIAS, DepartamentoConstants.ARG_ALIAS_DELDEPARTAMENTOC_DEPARTAMENTODELDEPARTAMENTOCPTHISDEPARTAMENTO);
        }
    }

    @JsonIgnore
    public DireccionCOid getDepartamentoDelDepartamentoCpevcDireccionC() {
        return this.departamentoDelDepartamentoCpevcDireccionC;
    }
    
    public void setDepartamentoDelDepartamentoCpevcDireccionC(DireccionCOid departamentoDelDepartamentoCpevcDireccionC) {
        this.departamentoDelDepartamentoCpevcDireccionC = departamentoDelDepartamentoCpevcDireccionC;
    }

    @JsonIgnore
    public DireccionC getDepartamentoDelDepartamentoCpevcDireccionCInstance() {
        return this.departamentoDelDepartamentoCpevcDireccionCInstance;
    }
    
    public void setDepartamentoDelDepartamentoCpevcDireccionCInstance(DireccionC departamentoDelDepartamentoCpevcDireccionC) {
        this.departamentoDelDepartamentoCpevcDireccionCInstance = departamentoDelDepartamentoCpevcDireccionC;
        this.departamentoDelDepartamentoCpevcDireccionC = departamentoDelDepartamentoCpevcDireccionC != null ? departamentoDelDepartamentoCpevcDireccionC.getOid() : null;
    }

    private void checkDepartamentoDelDepartamentoCpevcDireccionC() throws NotNullArgumentException {
        if(this.getDepartamentoDelDepartamentoCpevcDireccionCInstance() == null || this.getDepartamentoDelDepartamentoCpevcDireccionCInstance().isNull()) {
            throw new NotNullArgumentException(DepartamentoConstants.SERV_ID_DELDEPARTAMENTOC, DepartamentoConstants.CLASS_ID, DepartamentoConstants.ARG_ID_DELDEPARTAMENTOC_DEPARTAMENTODELDEPARTAMENTOCPEVCDIRECCIONC, DepartamentoConstants.SERV_ALIAS_DELDEPARTAMENTOC, DepartamentoConstants.CLASS_ALIAS, DepartamentoConstants.ARG_ALIAS_DELDEPARTAMENTOC_DEPARTAMENTODELDEPARTAMENTOCPEVCDIRECCIONC);
        }
    }
}
