package com.keralty.aesolicitudes.viewmodel.parentesco.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.ParentescoConstants;
import com.keralty.aesolicitudes.persistence.BeneficiarioC;
import com.keralty.aesolicitudes.persistence.oid.BeneficiarioCOid;
import com.keralty.aesolicitudes.persistence.oid.ParentescoOid;
import com.keralty.aesolicitudes.persistence.Parentesco;

public class ChgParentescoCRequest {

    @JsonProperty("p_thisparentesco_oid")
    private ParentescoOid parentescochgParentescoCpthisParentesco;
    
    @JsonIgnore
    private Parentesco parentescochgParentescoCpthisParentescoInstance;

    @JsonProperty("p_evcbeneficiarioc_oid")
    private BeneficiarioCOid parentescochgParentescoCpevcBeneficiarioC;
    
    @JsonIgnore
    private BeneficiarioC parentescochgParentescoCpevcBeneficiarioCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkParentescochgParentescoCpthisParentesco();
        checkParentescochgParentescoCpevcBeneficiarioC();
    }

    @JsonIgnore
    public ParentescoOid getParentescochgParentescoCpthisParentesco() {
        return this.parentescochgParentescoCpthisParentesco;
    }
    
    public void setParentescochgParentescoCpthisParentesco(ParentescoOid parentescochgParentescoCpthisParentesco) {
        this.parentescochgParentescoCpthisParentesco = parentescochgParentescoCpthisParentesco;
    }

    @JsonIgnore
    public Parentesco getParentescochgParentescoCpthisParentescoInstance() {
        return this.parentescochgParentescoCpthisParentescoInstance;
    }
    
    public void setParentescochgParentescoCpthisParentescoInstance(Parentesco parentescochgParentescoCpthisParentesco) {
        this.parentescochgParentescoCpthisParentescoInstance = parentescochgParentescoCpthisParentesco;
        this.parentescochgParentescoCpthisParentesco = parentescochgParentescoCpthisParentesco != null ? parentescochgParentescoCpthisParentesco.getOid() : null;
    }

    private void checkParentescochgParentescoCpthisParentesco() throws NotNullArgumentException {
        if(this.getParentescochgParentescoCpthisParentescoInstance() == null || this.getParentescochgParentescoCpthisParentescoInstance().isNull()) {
            throw new NotNullArgumentException(ParentescoConstants.SERV_ID_CHGPARENTESCOC, ParentescoConstants.CLASS_ID, ParentescoConstants.ARG_ID_CHGPARENTESCOC_PARENTESCOCHGPARENTESCOCPTHISPARENTESCO, ParentescoConstants.SERV_ALIAS_CHGPARENTESCOC, ParentescoConstants.CLASS_ALIAS, ParentescoConstants.ARG_ALIAS_CHGPARENTESCOC_PARENTESCOCHGPARENTESCOCPTHISPARENTESCO);
        }
    }

    @JsonIgnore
    public BeneficiarioCOid getParentescochgParentescoCpevcBeneficiarioC() {
        return this.parentescochgParentescoCpevcBeneficiarioC;
    }
    
    public void setParentescochgParentescoCpevcBeneficiarioC(BeneficiarioCOid parentescochgParentescoCpevcBeneficiarioC) {
        this.parentescochgParentescoCpevcBeneficiarioC = parentescochgParentescoCpevcBeneficiarioC;
    }

    @JsonIgnore
    public BeneficiarioC getParentescochgParentescoCpevcBeneficiarioCInstance() {
        return this.parentescochgParentescoCpevcBeneficiarioCInstance;
    }
    
    public void setParentescochgParentescoCpevcBeneficiarioCInstance(BeneficiarioC parentescochgParentescoCpevcBeneficiarioC) {
        this.parentescochgParentescoCpevcBeneficiarioCInstance = parentescochgParentescoCpevcBeneficiarioC;
        this.parentescochgParentescoCpevcBeneficiarioC = parentescochgParentescoCpevcBeneficiarioC != null ? parentescochgParentescoCpevcBeneficiarioC.getOid() : null;
    }

    private void checkParentescochgParentescoCpevcBeneficiarioC() throws NotNullArgumentException {
        if(this.getParentescochgParentescoCpevcBeneficiarioCInstance() == null || this.getParentescochgParentescoCpevcBeneficiarioCInstance().isNull()) {
            throw new NotNullArgumentException(ParentescoConstants.SERV_ID_CHGPARENTESCOC, ParentescoConstants.CLASS_ID, ParentescoConstants.ARG_ID_CHGPARENTESCOC_PARENTESCOCHGPARENTESCOCPEVCBENEFICIARIOC, ParentescoConstants.SERV_ALIAS_CHGPARENTESCOC, ParentescoConstants.CLASS_ALIAS, ParentescoConstants.ARG_ALIAS_CHGPARENTESCOC_PARENTESCOCHGPARENTESCOCPEVCBENEFICIARIOC);
        }
    }
}
