package com.keralty.aesolicitudes.viewmodel.reportesdominio.ds;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.ReportesDominio;
public class DSReportesDominio {

    @JsonProperty("plantillareporte_tipo")
    private Long dSReportesDominioPlantillaReporteDotTipo;

    @JsonProperty("plantillareporte_fechavigencia")
    private Date dSReportesDominioPlantillaReporteDotFechaVigencia;

    @JsonProperty("enviarauto")
    private Boolean dSReportesDominioEnviarAuto;

    @JsonProperty("plantillareporte_titulo")
    private String dSReportesDominioPlantillaReporteDotTitulo;

    public DSReportesDominio() {
    
    }

    public DSReportesDominio(ReportesDominio instance) {
        if (instance != null) {
            try {
                this.dSReportesDominioPlantillaReporteDotTipo = instance.getPlantillaReporte().getPlantillaReporteTipo();
                this.dSReportesDominioPlantillaReporteDotFechaVigencia = instance.getPlantillaReporte().getPlantillaReporteFechaVigencia();
                this.dSReportesDominioEnviarAuto = instance.getReportesDominioEnviarAuto();
                this.dSReportesDominioPlantillaReporteDotTitulo = instance.getPlantillaReporte().getPlantillaReporteTitulo();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public Long getDSReportesDominioPlantillaReporteDotTipo() {
        return this.dSReportesDominioPlantillaReporteDotTipo;
    }
    
    public void setDSReportesDominioPlantillaReporteDotTipo(Long dSReportesDominioPlantillaReporteDotTipo) {
        this.dSReportesDominioPlantillaReporteDotTipo = dSReportesDominioPlantillaReporteDotTipo;
    }

    @JsonIgnore
    public Date getDSReportesDominioPlantillaReporteDotFechaVigencia() {
        return this.dSReportesDominioPlantillaReporteDotFechaVigencia;
    }
    
    public void setDSReportesDominioPlantillaReporteDotFechaVigencia(Date dSReportesDominioPlantillaReporteDotFechaVigencia) {
        this.dSReportesDominioPlantillaReporteDotFechaVigencia = dSReportesDominioPlantillaReporteDotFechaVigencia;
    }

    @JsonIgnore
    public Boolean getDSReportesDominioEnviarAuto() {
        return this.dSReportesDominioEnviarAuto;
    }
    
    public void setDSReportesDominioEnviarAuto(Boolean dSReportesDominioEnviarAuto) {
        this.dSReportesDominioEnviarAuto = dSReportesDominioEnviarAuto;
    }

    @JsonIgnore
    public String getDSReportesDominioPlantillaReporteDotTitulo() {
        return this.dSReportesDominioPlantillaReporteDotTitulo;
    }
    
    public void setDSReportesDominioPlantillaReporteDotTitulo(String dSReportesDominioPlantillaReporteDotTitulo) {
        this.dSReportesDominioPlantillaReporteDotTitulo = dSReportesDominioPlantillaReporteDotTitulo;
    }
}
