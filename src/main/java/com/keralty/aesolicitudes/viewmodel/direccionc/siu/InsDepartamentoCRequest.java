package com.keralty.aesolicitudes.viewmodel.direccionc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DireccionCConstants;
import com.keralty.aesolicitudes.persistence.Departamento;
import com.keralty.aesolicitudes.persistence.DireccionC;
import com.keralty.aesolicitudes.persistence.oid.DepartamentoOid;
import com.keralty.aesolicitudes.persistence.oid.DireccionCOid;

public class InsDepartamentoCRequest {

    @JsonProperty("p_thisdireccionc_oid")
    private DireccionCOid direccionCInsDepartamentoCpthisDireccionC;
    
    @JsonIgnore
    private DireccionC direccionCInsDepartamentoCpthisDireccionCInstance;

    @JsonProperty("p_evcdepartamento_oid")
    private DepartamentoOid direccionCInsDepartamentoCpevcDepartamento;
    
    @JsonIgnore
    private Departamento direccionCInsDepartamentoCpevcDepartamentoInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkDireccionCInsDepartamentoCpthisDireccionC();
        checkDireccionCInsDepartamentoCpevcDepartamento();
    }

    @JsonIgnore
    public DireccionCOid getDireccionCInsDepartamentoCpthisDireccionC() {
        return this.direccionCInsDepartamentoCpthisDireccionC;
    }
    
    public void setDireccionCInsDepartamentoCpthisDireccionC(DireccionCOid direccionCInsDepartamentoCpthisDireccionC) {
        this.direccionCInsDepartamentoCpthisDireccionC = direccionCInsDepartamentoCpthisDireccionC;
    }

    @JsonIgnore
    public DireccionC getDireccionCInsDepartamentoCpthisDireccionCInstance() {
        return this.direccionCInsDepartamentoCpthisDireccionCInstance;
    }
    
    public void setDireccionCInsDepartamentoCpthisDireccionCInstance(DireccionC direccionCInsDepartamentoCpthisDireccionC) {
        this.direccionCInsDepartamentoCpthisDireccionCInstance = direccionCInsDepartamentoCpthisDireccionC;
        this.direccionCInsDepartamentoCpthisDireccionC = direccionCInsDepartamentoCpthisDireccionC != null ? direccionCInsDepartamentoCpthisDireccionC.getOid() : null;
    }

    private void checkDireccionCInsDepartamentoCpthisDireccionC() throws NotNullArgumentException {
        if(this.getDireccionCInsDepartamentoCpthisDireccionCInstance() == null || this.getDireccionCInsDepartamentoCpthisDireccionCInstance().isNull()) {
            throw new NotNullArgumentException(DireccionCConstants.SERV_ID_INSDEPARTAMENTOC, DireccionCConstants.CLASS_ID, DireccionCConstants.ARG_ID_INSDEPARTAMENTOC_DIRECCIONCINSDEPARTAMENTOCPTHISDIRECCIONC, DireccionCConstants.SERV_ALIAS_INSDEPARTAMENTOC, DireccionCConstants.CLASS_ALIAS, DireccionCConstants.ARG_ALIAS_INSDEPARTAMENTOC_DIRECCIONCINSDEPARTAMENTOCPTHISDIRECCIONC);
        }
    }

    @JsonIgnore
    public DepartamentoOid getDireccionCInsDepartamentoCpevcDepartamento() {
        return this.direccionCInsDepartamentoCpevcDepartamento;
    }
    
    public void setDireccionCInsDepartamentoCpevcDepartamento(DepartamentoOid direccionCInsDepartamentoCpevcDepartamento) {
        this.direccionCInsDepartamentoCpevcDepartamento = direccionCInsDepartamentoCpevcDepartamento;
    }

    @JsonIgnore
    public Departamento getDireccionCInsDepartamentoCpevcDepartamentoInstance() {
        return this.direccionCInsDepartamentoCpevcDepartamentoInstance;
    }
    
    public void setDireccionCInsDepartamentoCpevcDepartamentoInstance(Departamento direccionCInsDepartamentoCpevcDepartamento) {
        this.direccionCInsDepartamentoCpevcDepartamentoInstance = direccionCInsDepartamentoCpevcDepartamento;
        this.direccionCInsDepartamentoCpevcDepartamento = direccionCInsDepartamentoCpevcDepartamento != null ? direccionCInsDepartamentoCpevcDepartamento.getOid() : null;
    }

    private void checkDireccionCInsDepartamentoCpevcDepartamento() throws NotNullArgumentException {
        if(this.getDireccionCInsDepartamentoCpevcDepartamentoInstance() == null || this.getDireccionCInsDepartamentoCpevcDepartamentoInstance().isNull()) {
            throw new NotNullArgumentException(DireccionCConstants.SERV_ID_INSDEPARTAMENTOC, DireccionCConstants.CLASS_ID, DireccionCConstants.ARG_ID_INSDEPARTAMENTOC_DIRECCIONCINSDEPARTAMENTOCPEVCDEPARTAMENTO, DireccionCConstants.SERV_ALIAS_INSDEPARTAMENTOC, DireccionCConstants.CLASS_ALIAS, DireccionCConstants.ARG_ALIAS_INSDEPARTAMENTOC_DIRECCIONCINSDEPARTAMENTOCPEVCDEPARTAMENTO);
        }
    }
}
