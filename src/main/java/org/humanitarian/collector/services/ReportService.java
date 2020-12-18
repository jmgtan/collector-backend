package org.humanitarian.collector.services;

import org.humanitarian.collector.auth.models.User;
import org.humanitarian.collector.models.ReportDownload;
import org.humanitarian.collector.models.reports.GeneralDemographicData;
import org.humanitarian.collector.models.reports.ReproductiveHealthData;
import org.humanitarian.collector.models.reports.SanitationData;

import java.io.IOException;
import java.util.List;

public interface ReportService {
    String REPORT_PATH_PREFIX = "/reports";
    List<GeneralDemographicData> getGeneralDemographicsData();
    List<ReproductiveHealthData> getReproductiveHealthData();
    List<SanitationData> getSanitationData();
    ReportDownload generateReport(User principal) throws IOException;
}
