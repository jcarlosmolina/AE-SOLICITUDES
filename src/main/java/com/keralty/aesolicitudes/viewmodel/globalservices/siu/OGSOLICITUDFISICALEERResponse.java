package com.keralty.aesolicitudes.viewmodel.globalservices.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.viewmodel.ServiceResponse;
import java.util.HashMap;
import java.util.Map;

public class OGSOLICITUDFISICALEERResponse extends ServiceResponse {

    @JsonProperty("ps_archivoresultado")
    private byte[] oGSOLICITUDFISICALEERpsArchivoResultado;

    @JsonProperty("ps_nombrearchivoresultado")
    private String oGSOLICITUDFISICALEERpsNombreArchivoResultado;

    @JsonProperty("ps_resultado")
    private String oGSOLICITUDFISICALEERpsResultado;

    public OGSOLICITUDFISICALEERResponse() {
        super();
    }

    @JsonIgnore
    public byte[] getOGSOLICITUDFISICALEERpsArchivoResultado() {
        return this.oGSOLICITUDFISICALEERpsArchivoResultado;
    }

    public void setOGSOLICITUDFISICALEERpsArchivoResultado(byte[] oGSOLICITUDFISICALEERpsArchivoResultado) {
        this.oGSOLICITUDFISICALEERpsArchivoResultado = oGSOLICITUDFISICALEERpsArchivoResultado;
    }

    @JsonIgnore
    public String getOGSOLICITUDFISICALEERpsNombreArchivoResultado() {
        return this.oGSOLICITUDFISICALEERpsNombreArchivoResultado;
    }

    public void setOGSOLICITUDFISICALEERpsNombreArchivoResultado(String oGSOLICITUDFISICALEERpsNombreArchivoResultado) {
        this.oGSOLICITUDFISICALEERpsNombreArchivoResultado = oGSOLICITUDFISICALEERpsNombreArchivoResultado;
    }

    @JsonIgnore
    public String getOGSOLICITUDFISICALEERpsResultado() {
        return this.oGSOLICITUDFISICALEERpsResultado;
    }

    public void setOGSOLICITUDFISICALEERpsResultado(String oGSOLICITUDFISICALEERpsResultado) {
        this.oGSOLICITUDFISICALEERpsResultado = oGSOLICITUDFISICALEERpsResultado;
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("oGSOLICITUDFISICALEERpsArchivoResultado", oGSOLICITUDFISICALEERpsArchivoResultado);
        outArgs.put("oGSOLICITUDFISICALEERpsNombreArchivoResultado", oGSOLICITUDFISICALEERpsNombreArchivoResultado);
        outArgs.put("oGSOLICITUDFISICALEERpsResultado", oGSOLICITUDFISICALEERpsResultado);
        return outArgs;
    }
}
