package org.humanitarian.collector.services;

import org.humanitarian.collector.models.reports.GeneralDemographicData;
import org.humanitarian.collector.models.reports.ReproductiveHealthData;
import org.humanitarian.collector.models.reports.SanitationData;

import java.util.List;

public interface ReportService {
    List<GeneralDemographicData> getGeneralDemographicsData();
    List<ReproductiveHealthData> getReproductiveHealthData();
    List<SanitationData> getSanitationData();
}
