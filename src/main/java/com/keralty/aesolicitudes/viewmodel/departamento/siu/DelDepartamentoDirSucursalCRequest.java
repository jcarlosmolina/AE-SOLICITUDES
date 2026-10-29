package com.keralty.aesolicitudes.viewmodel.departamento.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DepartamentoConstants;
import com.keralty.aesolicitudes.persistence.Departamento;
import com.keralty.aesolicitudes.persistence.DirSucursalC;
import com.keralty.aesolicitudes.persistence.oid.DepartamentoOid;
import com.keralty.aesolicitudes.persistence.oid.DirSucursalCOid;

public class DelDepartamentoDirSucursalCRequest {

    @JsonProperty("p_thisdepartamento_oid")
    private DepartamentoOid departamentoDelDepartamentoDirSucursalCpthisDepartamento;
    
    @JsonIgnore
    private Departamento departamentoDelDepartamentoDirSucursalCpthisDepartamentoInstance;

    @JsonProperty("p_evcdirsucursalc_oid")
    private DirSucursalCOid departamentoDelDepartamentoDirSucursalCpevcDirSucursalC;
    
    @JsonIgnore
    private DirSucursalC departamentoDelDepartamentoDirSucursalCpevcDirSucursalCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkDepartamentoDelDepartamentoDirSucursalCpthisDepartamento();
        checkDepartamentoDelDepartamentoDirSucursalCpevcDirSucursalC();
    }

    @JsonIgnore
    public DepartamentoOid getDepartamentoDelDepartamentoDirSucursalCpthisDepartamento() {
        return this.departamentoDelDepartamentoDirSucursalCpthisDepartamento;
    }
    
    public void setDepartamentoDelDepartamentoDirSucursalCpthisDepartamento(DepartamentoOid departamentoDelDepartamentoDirSucursalCpthisDepartamento) {
        this.departamentoDelDepartamentoDirSucursalCpthisDepartamento = departamentoDelDepartamentoDirSucursalCpthisDepartamento;
    }

    @JsonIgnore
    public Departamento getDepartamentoDelDepartamentoDirSucursalCpthisDepartamentoInstance() {
        return this.departamentoDelDepartamentoDirSucursalCpthisDepartamentoInstance;
    }
    
    public void setDepartamentoDelDepartamentoDirSucursalCpthisDepartamentoInstance(Departamento departamentoDelDepartamentoDirSucursalCpthisDepartamento) {
        this.departamentoDelDepartamentoDirSucursalCpthisDepartamentoInstance = departamentoDelDepartamentoDirSucursalCpthisDepartamento;
        this.departamentoDelDepartamentoDirSucursalCpthisDepartamento = departamentoDelDepartamentoDirSucursalCpthisDepartamento != null ? departamentoDelDepartamentoDirSucursalCpthisDepartamento.getOid() : null;
    }

    private void checkDepartamentoDelDepartamentoDirSucursalCpthisDepartamento() throws NotNullArgumentException {
        if(this.getDepartamentoDelDepartamentoDirSucursalCpthisDepartamentoInstance() == null || this.getDepartamentoDelDepartamentoDirSucursalCpthisDepartamentoInstance().isNull()) {
            throw new NotNullArgumentException(DepartamentoConstants.SERV_ID_DELDEPARTAMENTODIRSUCURSALC, DepartamentoConstants.CLASS_ID, DepartamentoConstants.ARG_ID_DELDEPARTAMENTODIRSUCURSALC_DEPARTAMENTODELDEPARTAMENTODIRSUCURSALCPTHISDEPARTAMENTO, DepartamentoConstants.SERV_ALIAS_DELDEPARTAMENTODIRSUCURSALC, DepartamentoConstants.CLASS_ALIAS, DepartamentoConstants.ARG_ALIAS_DELDEPARTAMENTODIRSUCURSALC_DEPARTAMENTODELDEPARTAMENTODIRSUCURSALCPTHISDEPARTAMENTO);
        }
    }

    @JsonIgnore
    public DirSucursalCOid getDepartamentoDelDepartamentoDirSucursalCpevcDirSucursalC() {
        return this.departamentoDelDepartamentoDirSucursalCpevcDirSucursalC;
    }
    
    public void setDepartamentoDelDepartamentoDirSucursalCpevcDirSucursalC(DirSucursalCOid departamentoDelDepartamentoDirSucursalCpevcDirSucursalC) {
        this.departamentoDelDepartamentoDirSucursalCpevcDirSucursalC = departamentoDelDepartamentoDirSucursalCpevcDirSucursalC;
    }

    @JsonIgnore
    public DirSucursalC getDepartamentoDelDepartamentoDirSucursalCpevcDirSucursalCInstance() {
        return this.departamentoDelDepartamentoDirSucursalCpevcDirSucursalCInstance;
    }
    
    public void setDepartamentoDelDepartamentoDirSucursalCpevcDirSucursalCInstance(DirSucursalC departamentoDelDepartamentoDirSucursalCpevcDirSucursalC) {
        this.departamentoDelDepartamentoDirSucursalCpevcDirSucursalCInstance = departamentoDelDepartamentoDirSucursalCpevcDirSucursalC;
        this.departamentoDelDepartamentoDirSucursalCpevcDirSucursalC = departamentoDelDepartamentoDirSucursalCpevcDirSucursalC != null ? departamentoDelDepartamentoDirSucursalCpevcDirSucursalC.getOid() : null;
    }

    private void checkDepartamentoDelDepartamentoDirSucursalCpevcDirSucursalC() throws NotNullArgumentException {
        if(this.getDepartamentoDelDepartamentoDirSucursalCpevcDirSucursalCInstance() == null || this.getDepartamentoDelDepartamentoDirSucursalCpevcDirSucursalCInstance().isNull()) {
            throw new NotNullArgumentException(DepartamentoConstants.SERV_ID_DELDEPARTAMENTODIRSUCURSALC, DepartamentoConstants.CLASS_ID, DepartamentoConstants.ARG_ID_DELDEPARTAMENTODIRSUCURSALC_DEPARTAMENTODELDEPARTAMENTODIRSUCURSALCPEVCDIRSUCURSALC, DepartamentoConstants.SERV_ALIAS_DELDEPARTAMENTODIRSUCURSALC, DepartamentoConstants.CLASS_ALIAS, DepartamentoConstants.ARG_ALIAS_DELDEPARTAMENTODIRSUCURSALC_DEPARTAMENTODELDEPARTAMENTODIRSUCURSALCPEVCDIRSUCURSALC);
        }
    }
}
