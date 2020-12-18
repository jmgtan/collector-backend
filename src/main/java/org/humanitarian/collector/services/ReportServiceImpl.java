package org.humanitarian.collector.services;

import org.humanitarian.collector.models.Person;
import org.humanitarian.collector.models.reports.GeneralDemographicData;
import org.humanitarian.collector.models.reports.ReproductiveHealthData;
import org.humanitarian.collector.models.reports.SanitationData;
import org.humanitarian.collector.repositories.BarangayFormDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private BarangayFormDataRepository barangayFormDataRepository;

    @Override
    public List<GeneralDemographicData> getGeneralDemographicsData() {
        return barangayFormDataRepository.getGeneralDemographicsData(Person.RELATIONSHIP_HOUSEHOLD_HEAD);
    }

    @Override
    public List<ReproductiveHealthData> getReproductiveHealthData() {
        return barangayFormDataRepository.getReproductiveHealthData(Person.BF_EXCLUSIVE, Person.BF_MIXED_FEEDING);
    }

    @Override
    public List<SanitationData> getSanitationData() {
        return barangayFormDataRepository.getSanitationData();
    }
}
