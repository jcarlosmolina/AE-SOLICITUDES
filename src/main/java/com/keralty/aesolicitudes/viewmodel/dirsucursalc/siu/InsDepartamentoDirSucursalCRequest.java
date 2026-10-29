package com.keralty.aesolicitudes.viewmodel.dirsucursalc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.DirSucursalCConstants;
import com.keralty.aesolicitudes.persistence.Departamento;
import com.keralty.aesolicitudes.persistence.DirSucursalC;
import com.keralty.aesolicitudes.persistence.oid.DepartamentoOid;
import com.keralty.aesolicitudes.persistence.oid.DirSucursalCOid;

public class InsDepartamentoDirSucursalCRequest {

    @JsonProperty("p_thisdirsucursalc_oid")
    private DirSucursalCOid dirSucursalCInsDepartamentoDirSucursalCpthisDirSucursalC;
    
    @JsonIgnore
    private DirSucursalC dirSucursalCInsDepartamentoDirSucursalCpthisDirSucursalCInstance;

    @JsonProperty("p_evcdepartamento_oid")
    private DepartamentoOid dirSucursalCInsDepartamentoDirSucursalCpevcDepartamento;
    
    @JsonIgnore
    private Departamento dirSucursalCInsDepartamentoDirSucursalCpevcDepartamentoInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkDirSucursalCInsDepartamentoDirSucursalCpthisDirSucursalC();
        checkDirSucursalCInsDepartamentoDirSucursalCpevcDepartamento();
    }

    @JsonIgnore
    public DirSucursalCOid getDirSucursalCInsDepartamentoDirSucursalCpthisDirSucursalC() {
        return this.dirSucursalCInsDepartamentoDirSucursalCpthisDirSucursalC;
    }
    
    public void setDirSucursalCInsDepartamentoDirSucursalCpthisDirSucursalC(DirSucursalCOid dirSucursalCInsDepartamentoDirSucursalCpthisDirSucursalC) {
        this.dirSucursalCInsDepartamentoDirSucursalCpthisDirSucursalC = dirSucursalCInsDepartamentoDirSucursalCpthisDirSucursalC;
    }

    @JsonIgnore
    public DirSucursalC getDirSucursalCInsDepartamentoDirSucursalCpthisDirSucursalCInstance() {
        return this.dirSucursalCInsDepartamentoDirSucursalCpthisDirSucursalCInstance;
    }
    
    public void setDirSucursalCInsDepartamentoDirSucursalCpthisDirSucursalCInstance(DirSucursalC dirSucursalCInsDepartamentoDirSucursalCpthisDirSucursalC) {
        this.dirSucursalCInsDepartamentoDirSucursalCpthisDirSucursalCInstance = dirSucursalCInsDepartamentoDirSucursalCpthisDirSucursalC;
        this.dirSucursalCInsDepartamentoDirSucursalCpthisDirSucursalC = dirSucursalCInsDepartamentoDirSucursalCpthisDirSucursalC != null ? dirSucursalCInsDepartamentoDirSucursalCpthisDirSucursalC.getOid() : null;
    }

    private void checkDirSucursalCInsDepartamentoDirSucursalCpthisDirSucursalC() throws NotNullArgumentException {
        if(this.getDirSucursalCInsDepartamentoDirSucursalCpthisDirSucursalCInstance() == null || this.getDirSucursalCInsDepartamentoDirSucursalCpthisDirSucursalCInstance().isNull()) {
            throw new NotNullArgumentException(DirSucursalCConstants.SERV_ID_INSDEPARTAMENTODIRSUCURSALC, DirSucursalCConstants.CLASS_ID, DirSucursalCConstants.ARG_ID_INSDEPARTAMENTODIRSUCURSALC_DIRSUCURSALCINSDEPARTAMENTODIRSUCURSALCPTHISDIRSUCURSALC, DirSucursalCConstants.SERV_ALIAS_INSDEPARTAMENTODIRSUCURSALC, DirSucursalCConstants.CLASS_ALIAS, DirSucursalCConstants.ARG_ALIAS_INSDEPARTAMENTODIRSUCURSALC_DIRSUCURSALCINSDEPARTAMENTODIRSUCURSALCPTHISDIRSUCURSALC);
        }
    }

    @JsonIgnore
    public DepartamentoOid getDirSucursalCInsDepartamentoDirSucursalCpevcDepartamento() {
        return this.dirSucursalCInsDepartamentoDirSucursalCpevcDepartamento;
    }
    
    public void setDirSucursalCInsDepartamentoDirSucursalCpevcDepartamento(DepartamentoOid dirSucursalCInsDepartamentoDirSucursalCpevcDepartamento) {
        this.dirSucursalCInsDepartamentoDirSucursalCpevcDepartamento = dirSucursalCInsDepartamentoDirSucursalCpevcDepartamento;
    }

    @JsonIgnore
    public Departamento getDirSucursalCInsDepartamentoDirSucursalCpevcDepartamentoInstance() {
        return this.dirSucursalCInsDepartamentoDirSucursalCpevcDepartamentoInstance;
    }
    
    public void setDirSucursalCInsDepartamentoDirSucursalCpevcDepartamentoInstance(Departamento dirSucursalCInsDepartamentoDirSucursalCpevcDepartamento) {
        this.dirSucursalCInsDepartamentoDirSucursalCpevcDepartamentoInstance = dirSucursalCInsDepartamentoDirSucursalCpevcDepartamento;
        this.dirSucursalCInsDepartamentoDirSucursalCpevcDepartamento = dirSucursalCInsDepartamentoDirSucursalCpevcDepartamento != null ? dirSucursalCInsDepartamentoDirSucursalCpevcDepartamento.getOid() : null;
    }

    private void checkDirSucursalCInsDepartamentoDirSucursalCpevcDepartamento() throws NotNullArgumentException {
        if(this.getDirSucursalCInsDepartamentoDirSucursalCpevcDepartamentoInstance() == null || this.getDirSucursalCInsDepartamentoDirSucursalCpevcDepartamentoInstance().isNull()) {
            throw new NotNullArgumentException(DirSucursalCConstants.SERV_ID_INSDEPARTAMENTODIRSUCURSALC, DirSucursalCConstants.CLASS_ID, DirSucursalCConstants.ARG_ID_INSDEPARTAMENTODIRSUCURSALC_DIRSUCURSALCINSDEPARTAMENTODIRSUCURSALCPEVCDEPARTAMENTO, DirSucursalCConstants.SERV_ALIAS_INSDEPARTAMENTODIRSUCURSALC, DirSucursalCConstants.CLASS_ALIAS, DirSucursalCConstants.ARG_ALIAS_INSDEPARTAMENTODIRSUCURSALC_DIRSUCURSALCINSDEPARTAMENTODIRSUCURSALCPEVCDEPARTAMENTO);
        }
    }
}
