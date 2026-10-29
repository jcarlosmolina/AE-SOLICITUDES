package com.keralty.aesolicitudes.viewmodel.reportesdominio.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.ReportesDominio;
public class ICReportesDominio {

    @JsonProperty("plantillareporte_titulo")
    private String iCReportesDominioPlantillaReporteDotTitulo;

    public ICReportesDominio() {
    
    }

    public ICReportesDominio(ReportesDominio instance) {
        if (instance != null) {
            try {
                this.iCReportesDominioPlantillaReporteDotTitulo = instance.getPlantillaReporte().getPlantillaReporteTitulo();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public String getICReportesDominioPlantillaReporteDotTitulo() {
        return this.iCReportesDominioPlantillaReporteDotTitulo;
    }
    
    public void setICReportesDominioPlantillaReporteDotTitulo(String iCReportesDominioPlantillaReporteDotTitulo) {
        this.iCReportesDominioPlantillaReporteDotTitulo = iCReportesDominioPlantillaReporteDotTitulo;
    }
}
