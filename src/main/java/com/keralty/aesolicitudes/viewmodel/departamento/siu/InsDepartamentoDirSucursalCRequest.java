package com.keralty.aesolicitudes.viewmodel.departamento.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DepartamentoConstants;
import com.keralty.aesolicitudes.persistence.Departamento;
import com.keralty.aesolicitudes.persistence.DirSucursalC;
import com.keralty.aesolicitudes.persistence.oid.DepartamentoOid;
import com.keralty.aesolicitudes.persistence.oid.DirSucursalCOid;

public class InsDepartamentoDirSucursalCRequest {

    @JsonProperty("p_thisdepartamento_oid")
    private DepartamentoOid departamentoInsDepartamentoDirSucursalCpthisDepartamento;
    
    @JsonIgnore
    private Departamento departamentoInsDepartamentoDirSucursalCpthisDepartamentoInstance;

    @JsonProperty("p_evcdirsucursalc_oid")
    private DirSucursalCOid departamentoInsDepartamentoDirSucursalCpevcDirSucursalC;
    
    @JsonIgnore
    private DirSucursalC departamentoInsDepartamentoDirSucursalCpevcDirSucursalCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkDepartamentoInsDepartamentoDirSucursalCpthisDepartamento();
        checkDepartamentoInsDepartamentoDirSucursalCpevcDirSucursalC();
    }

    @JsonIgnore
    public DepartamentoOid getDepartamentoInsDepartamentoDirSucursalCpthisDepartamento() {
        return this.departamentoInsDepartamentoDirSucursalCpthisDepartamento;
    }
    
    public void setDepartamentoInsDepartamentoDirSucursalCpthisDepartamento(DepartamentoOid departamentoInsDepartamentoDirSucursalCpthisDepartamento) {
        this.departamentoInsDepartamentoDirSucursalCpthisDepartamento = departamentoInsDepartamentoDirSucursalCpthisDepartamento;
    }

    @JsonIgnore
    public Departamento getDepartamentoInsDepartamentoDirSucursalCpthisDepartamentoInstance() {
        return this.departamentoInsDepartamentoDirSucursalCpthisDepartamentoInstance;
    }
    
    public void setDepartamentoInsDepartamentoDirSucursalCpthisDepartamentoInstance(Departamento departamentoInsDepartamentoDirSucursalCpthisDepartamento) {
        this.departamentoInsDepartamentoDirSucursalCpthisDepartamentoInstance = departamentoInsDepartamentoDirSucursalCpthisDepartamento;
        this.departamentoInsDepartamentoDirSucursalCpthisDepartamento = departamentoInsDepartamentoDirSucursalCpthisDepartamento != null ? departamentoInsDepartamentoDirSucursalCpthisDepartamento.getOid() : null;
    }

    private void checkDepartamentoInsDepartamentoDirSucursalCpthisDepartamento() throws NotNullArgumentException {
        if(this.getDepartamentoInsDepartamentoDirSucursalCpthisDepartamentoInstance() == null || this.getDepartamentoInsDepartamentoDirSucursalCpthisDepartamentoInstance().isNull()) {
            throw new NotNullArgumentException(DepartamentoConstants.SERV_ID_INSDEPARTAMENTODIRSUCURSALC, DepartamentoConstants.CLASS_ID, DepartamentoConstants.ARG_ID_INSDEPARTAMENTODIRSUCURSALC_DEPARTAMENTOINSDEPARTAMENTODIRSUCURSALCPTHISDEPARTAMENTO, DepartamentoConstants.SERV_ALIAS_INSDEPARTAMENTODIRSUCURSALC, DepartamentoConstants.CLASS_ALIAS, DepartamentoConstants.ARG_ALIAS_INSDEPARTAMENTODIRSUCURSALC_DEPARTAMENTOINSDEPARTAMENTODIRSUCURSALCPTHISDEPARTAMENTO);
        }
    }

    @JsonIgnore
    public DirSucursalCOid getDepartamentoInsDepartamentoDirSucursalCpevcDirSucursalC() {
        return this.departamentoInsDepartamentoDirSucursalCpevcDirSucursalC;
    }
    
    public void setDepartamentoInsDepartamentoDirSucursalCpevcDirSucursalC(DirSucursalCOid departamentoInsDepartamentoDirSucursalCpevcDirSucursalC) {
        this.departamentoInsDepartamentoDirSucursalCpevcDirSucursalC = departamentoInsDepartamentoDirSucursalCpevcDirSucursalC;
    }

    @JsonIgnore
    public DirSucursalC getDepartamentoInsDepartamentoDirSucursalCpevcDirSucursalCInstance() {
        return this.departamentoInsDepartamentoDirSucursalCpevcDirSucursalCInstance;
    }
    
    public void setDepartamentoInsDepartamentoDirSucursalCpevcDirSucursalCInstance(DirSucursalC departamentoInsDepartamentoDirSucursalCpevcDirSucursalC) {
        this.departamentoInsDepartamentoDirSucursalCpevcDirSucursalCInstance = departamentoInsDepartamentoDirSucursalCpevcDirSucursalC;
        this.departamentoInsDepartamentoDirSucursalCpevcDirSucursalC = departamentoInsDepartamentoDirSucursalCpevcDirSucursalC != null ? departamentoInsDepartamentoDirSucursalCpevcDirSucursalC.getOid() : null;
    }

    private void checkDepartamentoInsDepartamentoDirSucursalCpevcDirSucursalC() throws NotNullArgumentException {
        if(this.getDepartamentoInsDepartamentoDirSucursalCpevcDirSucursalCInstance() == null || this.getDepartamentoInsDepartamentoDirSucursalCpevcDirSucursalCInstance().isNull()) {
            throw new NotNullArgumentException(DepartamentoConstants.SERV_ID_INSDEPARTAMENTODIRSUCURSALC, DepartamentoConstants.CLASS_ID, DepartamentoConstants.ARG_ID_INSDEPARTAMENTODIRSUCURSALC_DEPARTAMENTOINSDEPARTAMENTODIRSUCURSALCPEVCDIRSUCURSALC, DepartamentoConstants.SERV_ALIAS_INSDEPARTAMENTODIRSUCURSALC, DepartamentoConstants.CLASS_ALIAS, DepartamentoConstants.ARG_ALIAS_INSDEPARTAMENTODIRSUCURSALC_DEPARTAMENTOINSDEPARTAMENTODIRSUCURSALCPEVCDIRSUCURSALC);
        }
    }
}
