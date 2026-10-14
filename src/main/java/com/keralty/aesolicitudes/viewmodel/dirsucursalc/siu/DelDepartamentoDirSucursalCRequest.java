package com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DirSucursalCConstants;
import com.keralty.aesolicitudes.persistence.Departamento;
import com.keralty.aesolicitudes.persistence.DirSucursalC;
import com.keralty.aesolicitudes.persistence.oid.DepartamentoOid;
import com.keralty.aesolicitudes.persistence.oid.DirSucursalCOid;

public class DelDepartamentoDirSucursalCRequest {

    @JsonProperty("p_thisdirsucursalc_oid")
    private DirSucursalCOid dirSucursalCDelDepartamentoDirSucursalCpthisDirSucursalC;
    
    @JsonIgnore
    private DirSucursalC dirSucursalCDelDepartamentoDirSucursalCpthisDirSucursalCInstance;

    @JsonProperty("p_evcdepartamento_oid")
    private DepartamentoOid dirSucursalCDelDepartamentoDirSucursalCpevcDepartamento;
    
    @JsonIgnore
    private Departamento dirSucursalCDelDepartamentoDirSucursalCpevcDepartamentoInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkDirSucursalCDelDepartamentoDirSucursalCpthisDirSucursalC();
        checkDirSucursalCDelDepartamentoDirSucursalCpevcDepartamento();
    }

    @JsonIgnore
    public DirSucursalCOid getDirSucursalCDelDepartamentoDirSucursalCpthisDirSucursalC() {
        return this.dirSucursalCDelDepartamentoDirSucursalCpthisDirSucursalC;
    }
    
    public void setDirSucursalCDelDepartamentoDirSucursalCpthisDirSucursalC(DirSucursalCOid dirSucursalCDelDepartamentoDirSucursalCpthisDirSucursalC) {
        this.dirSucursalCDelDepartamentoDirSucursalCpthisDirSucursalC = dirSucursalCDelDepartamentoDirSucursalCpthisDirSucursalC;
    }

    @JsonIgnore
    public DirSucursalC getDirSucursalCDelDepartamentoDirSucursalCpthisDirSucursalCInstance() {
        return this.dirSucursalCDelDepartamentoDirSucursalCpthisDirSucursalCInstance;
    }
    
    public void setDirSucursalCDelDepartamentoDirSucursalCpthisDirSucursalCInstance(DirSucursalC dirSucursalCDelDepartamentoDirSucursalCpthisDirSucursalC) {
        this.dirSucursalCDelDepartamentoDirSucursalCpthisDirSucursalCInstance = dirSucursalCDelDepartamentoDirSucursalCpthisDirSucursalC;
        this.dirSucursalCDelDepartamentoDirSucursalCpthisDirSucursalC = dirSucursalCDelDepartamentoDirSucursalCpthisDirSucursalC != null ? dirSucursalCDelDepartamentoDirSucursalCpthisDirSucursalC.getOid() : null;
    }

    private void checkDirSucursalCDelDepartamentoDirSucursalCpthisDirSucursalC() throws NotNullArgumentException {
        if(this.getDirSucursalCDelDepartamentoDirSucursalCpthisDirSucursalCInstance() == null || this.getDirSucursalCDelDepartamentoDirSucursalCpthisDirSucursalCInstance().isNull()) {
            throw new NotNullArgumentException(DirSucursalCConstants.SERV_ID_DELDEPARTAMENTODIRSUCURSALC, DirSucursalCConstants.CLASS_ID, DirSucursalCConstants.ARG_ID_DELDEPARTAMENTODIRSUCURSALC_DIRSUCURSALCDELDEPARTAMENTODIRSUCURSALCPTHISDIRSUCURSALC, DirSucursalCConstants.SERV_ALIAS_DELDEPARTAMENTODIRSUCURSALC, DirSucursalCConstants.CLASS_ALIAS, DirSucursalCConstants.ARG_ALIAS_DELDEPARTAMENTODIRSUCURSALC_DIRSUCURSALCDELDEPARTAMENTODIRSUCURSALCPTHISDIRSUCURSALC);
        }
    }

    @JsonIgnore
    public DepartamentoOid getDirSucursalCDelDepartamentoDirSucursalCpevcDepartamento() {
        return this.dirSucursalCDelDepartamentoDirSucursalCpevcDepartamento;
    }
    
    public void setDirSucursalCDelDepartamentoDirSucursalCpevcDepartamento(DepartamentoOid dirSucursalCDelDepartamentoDirSucursalCpevcDepartamento) {
        this.dirSucursalCDelDepartamentoDirSucursalCpevcDepartamento = dirSucursalCDelDepartamentoDirSucursalCpevcDepartamento;
    }

    @JsonIgnore
    public Departamento getDirSucursalCDelDepartamentoDirSucursalCpevcDepartamentoInstance() {
        return this.dirSucursalCDelDepartamentoDirSucursalCpevcDepartamentoInstance;
    }
    
    public void setDirSucursalCDelDepartamentoDirSucursalCpevcDepartamentoInstance(Departamento dirSucursalCDelDepartamentoDirSucursalCpevcDepartamento) {
        this.dirSucursalCDelDepartamentoDirSucursalCpevcDepartamentoInstance = dirSucursalCDelDepartamentoDirSucursalCpevcDepartamento;
        this.dirSucursalCDelDepartamentoDirSucursalCpevcDepartamento = dirSucursalCDelDepartamentoDirSucursalCpevcDepartamento != null ? dirSucursalCDelDepartamentoDirSucursalCpevcDepartamento.getOid() : null;
    }

    private void checkDirSucursalCDelDepartamentoDirSucursalCpevcDepartamento() throws NotNullArgumentException {
        if(this.getDirSucursalCDelDepartamentoDirSucursalCpevcDepartamentoInstance() == null || this.getDirSucursalCDelDepartamentoDirSucursalCpevcDepartamentoInstance().isNull()) {
            throw new NotNullArgumentException(DirSucursalCConstants.SERV_ID_DELDEPARTAMENTODIRSUCURSALC, DirSucursalCConstants.CLASS_ID, DirSucursalCConstants.ARG_ID_DELDEPARTAMENTODIRSUCURSALC_DIRSUCURSALCDELDEPARTAMENTODIRSUCURSALCPEVCDEPARTAMENTO, DirSucursalCConstants.SERV_ALIAS_DELDEPARTAMENTODIRSUCURSALC, DirSucursalCConstants.CLASS_ALIAS, DirSucursalCConstants.ARG_ALIAS_DELDEPARTAMENTODIRSUCURSALC_DIRSUCURSALCDELDEPARTAMENTODIRSUCURSALCPEVCDEPARTAMENTO);
        }
    }
}
