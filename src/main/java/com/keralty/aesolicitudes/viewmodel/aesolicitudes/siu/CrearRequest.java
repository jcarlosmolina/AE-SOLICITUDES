package com.keralty.aesolicitudes.viewmodel.aesolicitudes.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.AesolicitudesConstants;
import com.keralty.aesolicitudes.persistence.EstadoContrato;
import com.keralty.aesolicitudes.persistence.oid.EstadoContratoOid;
import com.keralty.aesolicitudes.persistence.oid.PlanesOid;
import com.keralty.aesolicitudes.persistence.oid.ProductosOid;
import com.keralty.aesolicitudes.persistence.Planes;
import com.keralty.aesolicitudes.persistence.Productos;

public class CrearRequest {

    @JsonProperty("p_agrestado_solicitud_oid")
    private EstadoContratoOid aesolicitudescrearpagrESTADOSOLICITUD;
    
    @JsonIgnore
    private EstadoContrato aesolicitudescrearpagrESTADOSOLICITUDInstance;

    @JsonProperty("p_agrproductot_oid")
    private ProductosOid aesolicitudescrearpagrProductoT;
    
    @JsonIgnore
    private Productos aesolicitudescrearpagrProductoTInstance;

    @JsonProperty("p_agrplant_oid")
    private PlanesOid aesolicitudescrearpagrPlanT;
    
    @JsonIgnore
    private Planes aesolicitudescrearpagrPlanTInstance;

    @JsonProperty("p_atrlogin")
    private String aesolicitudescrearpatrLogin;

    @JsonProperty("p_atrtipo_solicitud")
    private String aesolicitudescrearpatrTiposolicitud;

    @JsonProperty("p_atrnumero_solicitud")
    private String aesolicitudescrearpatrNumerosolicitud;

    public void checkArguments() throws NotNullArgumentException {
        checkAesolicitudescrearpagrProductoT();
    }

    @JsonIgnore
    public EstadoContratoOid getAesolicitudescrearpagrESTADOSOLICITUD() {
        return this.aesolicitudescrearpagrESTADOSOLICITUD;
    }
    
    public void setAesolicitudescrearpagrESTADOSOLICITUD(EstadoContratoOid aesolicitudescrearpagrESTADOSOLICITUD) {
        this.aesolicitudescrearpagrESTADOSOLICITUD = aesolicitudescrearpagrESTADOSOLICITUD;
    }

    @JsonIgnore
    public EstadoContrato getAesolicitudescrearpagrESTADOSOLICITUDInstance() {
        return this.aesolicitudescrearpagrESTADOSOLICITUDInstance;
    }
    
    public void setAesolicitudescrearpagrESTADOSOLICITUDInstance(EstadoContrato aesolicitudescrearpagrESTADOSOLICITUD) {
        this.aesolicitudescrearpagrESTADOSOLICITUDInstance = aesolicitudescrearpagrESTADOSOLICITUD;
        this.aesolicitudescrearpagrESTADOSOLICITUD = aesolicitudescrearpagrESTADOSOLICITUD != null ? aesolicitudescrearpagrESTADOSOLICITUD.getOid() : null;
    }

    @JsonIgnore
    public ProductosOid getAesolicitudescrearpagrProductoT() {
        return this.aesolicitudescrearpagrProductoT;
    }
    
    public void setAesolicitudescrearpagrProductoT(ProductosOid aesolicitudescrearpagrProductoT) {
        this.aesolicitudescrearpagrProductoT = aesolicitudescrearpagrProductoT;
    }

    @JsonIgnore
    public Productos getAesolicitudescrearpagrProductoTInstance() {
        return this.aesolicitudescrearpagrProductoTInstance;
    }
    
    public void setAesolicitudescrearpagrProductoTInstance(Productos aesolicitudescrearpagrProductoT) {
        this.aesolicitudescrearpagrProductoTInstance = aesolicitudescrearpagrProductoT;
        this.aesolicitudescrearpagrProductoT = aesolicitudescrearpagrProductoT != null ? aesolicitudescrearpagrProductoT.getOid() : null;
    }

    private void checkAesolicitudescrearpagrProductoT() throws NotNullArgumentException {
        if(this.getAesolicitudescrearpagrProductoTInstance() == null || this.getAesolicitudescrearpagrProductoTInstance().isNull()) {
            throw new NotNullArgumentException(AesolicitudesConstants.SERV_ID_CREAR, AesolicitudesConstants.CLASS_ID, AesolicitudesConstants.ARG_ID_CREAR_AESOLICITUDESCREARPAGRPRODUCTOT, AesolicitudesConstants.SERV_ALIAS_CREAR, AesolicitudesConstants.CLASS_ALIAS, AesolicitudesConstants.ARG_ALIAS_CREAR_AESOLICITUDESCREARPAGRPRODUCTOT);
        }
    }

    @JsonIgnore
    public PlanesOid getAesolicitudescrearpagrPlanT() {
        return this.aesolicitudescrearpagrPlanT;
    }
    
    public void setAesolicitudescrearpagrPlanT(PlanesOid aesolicitudescrearpagrPlanT) {
        this.aesolicitudescrearpagrPlanT = aesolicitudescrearpagrPlanT;
    }

    @JsonIgnore
    public Planes getAesolicitudescrearpagrPlanTInstance() {
        return this.aesolicitudescrearpagrPlanTInstance;
    }
    
    public void setAesolicitudescrearpagrPlanTInstance(Planes aesolicitudescrearpagrPlanT) {
        this.aesolicitudescrearpagrPlanTInstance = aesolicitudescrearpagrPlanT;
        this.aesolicitudescrearpagrPlanT = aesolicitudescrearpagrPlanT != null ? aesolicitudescrearpagrPlanT.getOid() : null;
    }

    @JsonIgnore
    public String getAesolicitudescrearpatrLogin() {
        return this.aesolicitudescrearpatrLogin;
    }
    
    public void setAesolicitudescrearpatrLogin(String aesolicitudescrearpatrLogin) {
        this.aesolicitudescrearpatrLogin = aesolicitudescrearpatrLogin;
    }

    @JsonIgnore
    public String getAesolicitudescrearpatrTiposolicitud() {
        return this.aesolicitudescrearpatrTiposolicitud;
    }
    
    public void setAesolicitudescrearpatrTiposolicitud(String aesolicitudescrearpatrTiposolicitud) {
        this.aesolicitudescrearpatrTiposolicitud = aesolicitudescrearpatrTiposolicitud;
    }

    @JsonIgnore
    public String getAesolicitudescrearpatrNumerosolicitud() {
        return this.aesolicitudescrearpatrNumerosolicitud;
    }
    
    public void setAesolicitudescrearpatrNumerosolicitud(String aesolicitudescrearpatrNumerosolicitud) {
        this.aesolicitudescrearpatrNumerosolicitud = aesolicitudescrearpatrNumerosolicitud;
    }
}
