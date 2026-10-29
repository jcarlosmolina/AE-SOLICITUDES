package com.keralty.aesolicitudes.viewmodel.seccionp.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.exception.NotNullArgumentException;
import com.keralty.aesolicitudes.global.SeccionPConstants;
import com.keralty.aesolicitudes.persistence.CuestionarioP;
import com.keralty.aesolicitudes.persistence.oid.CuestionarioPOid;
import com.keralty.aesolicitudes.persistence.oid.SeccionOid;
import com.keralty.aesolicitudes.persistence.Seccion;

public class TCREARYPREGUNTASRequest {

    @JsonProperty("pt_seccion_oid")
    private SeccionOid seccionPTCREARYPREGUNTASptSeccion;
    
    @JsonIgnore
    private Seccion seccionPTCREARYPREGUNTASptSeccionInstance;

    @JsonProperty("pt_cuestionariop_oid")
    private CuestionarioPOid seccionPTCREARYPREGUNTASptCuestionarioP;
    
    @JsonIgnore
    private CuestionarioP seccionPTCREARYPREGUNTASptCuestionarioPInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSeccionPTCREARYPREGUNTASptSeccion();
        checkSeccionPTCREARYPREGUNTASptCuestionarioP();
    }

    @JsonIgnore
    public SeccionOid getSeccionPTCREARYPREGUNTASptSeccion() {
        return this.seccionPTCREARYPREGUNTASptSeccion;
    }
    
    public void setSeccionPTCREARYPREGUNTASptSeccion(SeccionOid seccionPTCREARYPREGUNTASptSeccion) {
        this.seccionPTCREARYPREGUNTASptSeccion = seccionPTCREARYPREGUNTASptSeccion;
    }

    @JsonIgnore
    public Seccion getSeccionPTCREARYPREGUNTASptSeccionInstance() {
        return this.seccionPTCREARYPREGUNTASptSeccionInstance;
    }
    
    public void setSeccionPTCREARYPREGUNTASptSeccionInstance(Seccion seccionPTCREARYPREGUNTASptSeccion) {
        this.seccionPTCREARYPREGUNTASptSeccionInstance = seccionPTCREARYPREGUNTASptSeccion;
        this.seccionPTCREARYPREGUNTASptSeccion = seccionPTCREARYPREGUNTASptSeccion != null ? seccionPTCREARYPREGUNTASptSeccion.getOid() : null;
    }

    private void checkSeccionPTCREARYPREGUNTASptSeccion() throws NotNullArgumentException {
        if(this.getSeccionPTCREARYPREGUNTASptSeccionInstance() == null || this.getSeccionPTCREARYPREGUNTASptSeccionInstance().isNull()) {
            throw new NotNullArgumentException(SeccionPConstants.SERV_ID_TCREARYPREGUNTAS, SeccionPConstants.CLASS_ID, SeccionPConstants.ARG_ID_TCREARYPREGUNTAS_SECCIONPTCREARYPREGUNTASPTSECCION, SeccionPConstants.SERV_ALIAS_TCREARYPREGUNTAS, SeccionPConstants.CLASS_ALIAS, SeccionPConstants.ARG_ALIAS_TCREARYPREGUNTAS_SECCIONPTCREARYPREGUNTASPTSECCION);
        }
    }

    @JsonIgnore
    public CuestionarioPOid getSeccionPTCREARYPREGUNTASptCuestionarioP() {
        return this.seccionPTCREARYPREGUNTASptCuestionarioP;
    }
    
    public void setSeccionPTCREARYPREGUNTASptCuestionarioP(CuestionarioPOid seccionPTCREARYPREGUNTASptCuestionarioP) {
        this.seccionPTCREARYPREGUNTASptCuestionarioP = seccionPTCREARYPREGUNTASptCuestionarioP;
    }

    @JsonIgnore
    public CuestionarioP getSeccionPTCREARYPREGUNTASptCuestionarioPInstance() {
        return this.seccionPTCREARYPREGUNTASptCuestionarioPInstance;
    }
    
    public void setSeccionPTCREARYPREGUNTASptCuestionarioPInstance(CuestionarioP seccionPTCREARYPREGUNTASptCuestionarioP) {
        this.seccionPTCREARYPREGUNTASptCuestionarioPInstance = seccionPTCREARYPREGUNTASptCuestionarioP;
        this.seccionPTCREARYPREGUNTASptCuestionarioP = seccionPTCREARYPREGUNTASptCuestionarioP != null ? seccionPTCREARYPREGUNTASptCuestionarioP.getOid() : null;
    }

    private void checkSeccionPTCREARYPREGUNTASptCuestionarioP() throws NotNullArgumentException {
        if(this.getSeccionPTCREARYPREGUNTASptCuestionarioPInstance() == null || this.getSeccionPTCREARYPREGUNTASptCuestionarioPInstance().isNull()) {
            throw new NotNullArgumentException(SeccionPConstants.SERV_ID_TCREARYPREGUNTAS, SeccionPConstants.CLASS_ID, SeccionPConstants.ARG_ID_TCREARYPREGUNTAS_SECCIONPTCREARYPREGUNTASPTCUESTIONARIOP, SeccionPConstants.SERV_ALIAS_TCREARYPREGUNTAS, SeccionPConstants.CLASS_ALIAS, SeccionPConstants.ARG_ALIAS_TCREARYPREGUNTAS_SECCIONPTCREARYPREGUNTASPTCUESTIONARIOP);
        }
    }
}
