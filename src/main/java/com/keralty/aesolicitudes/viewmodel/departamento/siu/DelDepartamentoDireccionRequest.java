package com.keralty.aesolicitudes.viewmodel.departamento.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DepartamentoConstants;
import com.keralty.aesolicitudes.persistence.Departamento;
import com.keralty.aesolicitudes.persistence.Direccion;
import com.keralty.aesolicitudes.persistence.oid.DepartamentoOid;
import com.keralty.aesolicitudes.persistence.oid.DireccionOid;

public class DelDepartamentoDireccionRequest {

    @JsonProperty("p_thisdepartamento_oid")
    private DepartamentoOid departamentoDelDepartamentoDireccionpthisDepartamento;
    
    @JsonIgnore
    private Departamento departamentoDelDepartamentoDireccionpthisDepartamentoInstance;

    @JsonProperty("p_evcdireccion_oid")
    private DireccionOid departamentoDelDepartamentoDireccionpevcDireccion;
    
    @JsonIgnore
    private Direccion departamentoDelDepartamentoDireccionpevcDireccionInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkDepartamentoDelDepartamentoDireccionpthisDepartamento();
        checkDepartamentoDelDepartamentoDireccionpevcDireccion();
    }

    @JsonIgnore
    public DepartamentoOid getDepartamentoDelDepartamentoDireccionpthisDepartamento() {
        return this.departamentoDelDepartamentoDireccionpthisDepartamento;
    }
    
    public void setDepartamentoDelDepartamentoDireccionpthisDepartamento(DepartamentoOid departamentoDelDepartamentoDireccionpthisDepartamento) {
        this.departamentoDelDepartamentoDireccionpthisDepartamento = departamentoDelDepartamentoDireccionpthisDepartamento;
    }

    @JsonIgnore
    public Departamento getDepartamentoDelDepartamentoDireccionpthisDepartamentoInstance() {
        return this.departamentoDelDepartamentoDireccionpthisDepartamentoInstance;
    }
    
    public void setDepartamentoDelDepartamentoDireccionpthisDepartamentoInstance(Departamento departamentoDelDepartamentoDireccionpthisDepartamento) {
        this.departamentoDelDepartamentoDireccionpthisDepartamentoInstance = departamentoDelDepartamentoDireccionpthisDepartamento;
        this.departamentoDelDepartamentoDireccionpthisDepartamento = departamentoDelDepartamentoDireccionpthisDepartamento != null ? departamentoDelDepartamentoDireccionpthisDepartamento.getOid() : null;
    }

    private void checkDepartamentoDelDepartamentoDireccionpthisDepartamento() throws NotNullArgumentException {
        if(this.getDepartamentoDelDepartamentoDireccionpthisDepartamentoInstance() == null || this.getDepartamentoDelDepartamentoDireccionpthisDepartamentoInstance().isNull()) {
            throw new NotNullArgumentException(DepartamentoConstants.SERV_ID_DELDEPARTAMENTODIRECCION, DepartamentoConstants.CLASS_ID, DepartamentoConstants.ARG_ID_DELDEPARTAMENTODIRECCION_DEPARTAMENTODELDEPARTAMENTODIRECCIONPTHISDEPARTAMENTO, DepartamentoConstants.SERV_ALIAS_DELDEPARTAMENTODIRECCION, DepartamentoConstants.CLASS_ALIAS, DepartamentoConstants.ARG_ALIAS_DELDEPARTAMENTODIRECCION_DEPARTAMENTODELDEPARTAMENTODIRECCIONPTHISDEPARTAMENTO);
        }
    }

    @JsonIgnore
    public DireccionOid getDepartamentoDelDepartamentoDireccionpevcDireccion() {
        return this.departamentoDelDepartamentoDireccionpevcDireccion;
    }
    
    public void setDepartamentoDelDepartamentoDireccionpevcDireccion(DireccionOid departamentoDelDepartamentoDireccionpevcDireccion) {
        this.departamentoDelDepartamentoDireccionpevcDireccion = departamentoDelDepartamentoDireccionpevcDireccion;
    }

    @JsonIgnore
    public Direccion getDepartamentoDelDepartamentoDireccionpevcDireccionInstance() {
        return this.departamentoDelDepartamentoDireccionpevcDireccionInstance;
    }
    
    public void setDepartamentoDelDepartamentoDireccionpevcDireccionInstance(Direccion departamentoDelDepartamentoDireccionpevcDireccion) {
        this.departamentoDelDepartamentoDireccionpevcDireccionInstance = departamentoDelDepartamentoDireccionpevcDireccion;
        this.departamentoDelDepartamentoDireccionpevcDireccion = departamentoDelDepartamentoDireccionpevcDireccion != null ? departamentoDelDepartamentoDireccionpevcDireccion.getOid() : null;
    }

    private void checkDepartamentoDelDepartamentoDireccionpevcDireccion() throws NotNullArgumentException {
        if(this.getDepartamentoDelDepartamentoDireccionpevcDireccionInstance() == null || this.getDepartamentoDelDepartamentoDireccionpevcDireccionInstance().isNull()) {
            throw new NotNullArgumentException(DepartamentoConstants.SERV_ID_DELDEPARTAMENTODIRECCION, DepartamentoConstants.CLASS_ID, DepartamentoConstants.ARG_ID_DELDEPARTAMENTODIRECCION_DEPARTAMENTODELDEPARTAMENTODIRECCIONPEVCDIRECCION, DepartamentoConstants.SERV_ALIAS_DELDEPARTAMENTODIRECCION, DepartamentoConstants.CLASS_ALIAS, DepartamentoConstants.ARG_ALIAS_DELDEPARTAMENTODIRECCION_DEPARTAMENTODELDEPARTAMENTODIRECCIONPEVCDIRECCION);
        }
    }
}
