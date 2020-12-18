package org.humanitarian.collector.controllers.responses;

import org.humanitarian.collector.models.reports.GeneralDemographicData;
import org.humanitarian.collector.models.reports.ReproductiveHealthData;
import org.humanitarian.collector.models.reports.SanitationData;

import java.util.List;

public class RootsOfHealthResponse {
    private List<GeneralDemographicData> generalDemographicData;
    private List<ReproductiveHealthData> reproductiveHealthData;
    private List<SanitationData> sanitationData;

    public RootsOfHealthResponse() {
    }

    public RootsOfHealthResponse(List<GeneralDemographicData> generalDemographicData, List<ReproductiveHealthData> reproductiveHealthData, List<SanitationData> sanitationData) {
        this.generalDemographicData = generalDemographicData;
        this.reproductiveHealthData = reproductiveHealthData;
        this.sanitationData = sanitationData;
    }

    public List<GeneralDemographicData> getGeneralDemographicData() {
        return generalDemographicData;
    }

    public void setGeneralDemographicData(List<GeneralDemographicData> generalDemographicData) {
        this.generalDemographicData = generalDemographicData;
    }

    public List<ReproductiveHealthData> getReproductiveHealthData() {
        return reproductiveHealthData;
    }

    public void setReproductiveHealthData(List<ReproductiveHealthData> reproductiveHealthData) {
        this.reproductiveHealthData = reproductiveHealthData;
    }

    public List<SanitationData> getSanitationData() {
        return sanitationData;
    }

    public void setSanitationData(List<SanitationData> sanitationData) {
        this.sanitationData = sanitationData;
    }
}
