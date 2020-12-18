package org.humanitarian.collector.services;

import com.opencsv.CSVWriter;
import org.apache.commons.text.WordUtils;
import org.humanitarian.collector.auth.models.User;
import org.humanitarian.collector.models.Person;
import org.humanitarian.collector.models.ReportDownload;
import org.humanitarian.collector.models.reports.GeneralDemographicData;
import org.humanitarian.collector.models.reports.ReproductiveHealthData;
import org.humanitarian.collector.models.reports.SanitationData;
import org.humanitarian.collector.repositories.BarangayFormDataRepository;
import org.humanitarian.collector.repositories.ReportDownloadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private BarangayFormDataRepository barangayFormDataRepository;

    @Autowired
    private ReportDownloadRepository reportDownloadRepository;

    @Value("${reports.generated_path}")
    private String reportsGeneratedPath;

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

    @Override
    @Transactional
    public ReportDownload generateReport(User principal) throws IOException {
        File f = new File(reportsGeneratedPath+REPORT_PATH_PREFIX);
        if (!f.exists()) {
            f.mkdirs();
        }

        UUID filenamePrefix = UUID.randomUUID();

        List<GeneralDemographicData> generalDemographicDataList = getGeneralDemographicsData();
        List<ReproductiveHealthData> reproductiveHealthDataList = getReproductiveHealthData();
        List<SanitationData> sanitationDataList = getSanitationData();

        CSVWriter writer = new CSVWriter(new FileWriter(reportsGeneratedPath+REPORT_PATH_PREFIX+"/"+filenamePrefix+".csv"));
        List<String> csvHeaders = new ArrayList<>();
        List<String> totalHouseholds = new ArrayList<>();
        List<String> totalPopulation = new ArrayList<>();

        csvHeaders.add("Data Points");
        totalHouseholds.add("Total Households");
        totalPopulation.add("Total Population");

        for (GeneralDemographicData g : generalDemographicDataList) {
            if (g.getResidenceAddress() != null) {
                if (g.getResidenceAddress().isEmpty()) {
                    csvHeaders.add("n/a");
                } else {
                    String residenceAddress = g.getResidenceAddress().replaceAll("_", " ");
                    csvHeaders.add(WordUtils.capitalizeFully(residenceAddress));
                }
            } else {
                csvHeaders.add("n/a");
            }

            totalHouseholds.add(String.valueOf(g.getTotalHouseholds()));
            totalPopulation.add(String.valueOf(g.getTotalPopulation()));
        }

        writer.writeNext(csvHeaders.toArray(new String[0]));

        writer.writeNext(new String[] {"General Demographics"});
        writer.writeNext(totalHouseholds.toArray(new String[0]));
        writer.writeNext(totalPopulation.toArray(new String[0]));
        writer.writeNext(new String[] {"Reproductive Health Data"});

        List<String> pregnantWomen = new ArrayList<>();
        List<String> exclusiveBf = new ArrayList<>();
        List<String> mixedBf = new ArrayList<>();
        List<String> familyPlanning = new ArrayList<>();

        pregnantWomen.add("Pregnant Women");
        exclusiveBf.add("Mother Exclusively BF");
        mixedBf.add("Mother Mixed BF");
        familyPlanning.add("Couples practicing family planning");

        for (ReproductiveHealthData r : reproductiveHealthDataList) {
            pregnantWomen.add(String.valueOf(r.getPregnantWomen()));
            exclusiveBf.add(String.valueOf(r.getMotherExclusivelyBF()));
            mixedBf.add(String.valueOf(r.getMotherMixedBF()));
            familyPlanning.add(String.valueOf(r.getPracticingFamilyPlanning()));
        }

        writer.writeNext(pregnantWomen.toArray(new String[0]));
        writer.writeNext(exclusiveBf.toArray(new String[0]));
        writer.writeNext(mixedBf.toArray(new String[0]));
        writer.writeNext(familyPlanning.toArray(new String[0]));

        writer.writeNext(new String[] {"Type of Toilet"});

        List<String> waterSealed = new ArrayList<>();
        List<String> openPit = new ArrayList<>();
        List<String> communal = new ArrayList<>();
        List<String> noToilet = new ArrayList<>();

        waterSealed.add("Water Sealed");
        openPit.add("Open Pit");
        communal.add("Communal");
        noToilet.add("No Toilet");

        for (SanitationData s : sanitationDataList) {
            waterSealed.add(String.valueOf(s.getWaterSealed()));
            openPit.add(String.valueOf(s.getOpenPit()));
            communal.add(String.valueOf(s.getCommunal()));
            noToilet.add(String.valueOf(s.getNoToilet()));
        }

        writer.writeNext(waterSealed.toArray(new String[0]));
        writer.writeNext(openPit.toArray(new String[0]));
        writer.writeNext(communal.toArray(new String[0]));
        writer.writeNext(noToilet.toArray(new String[0]));

        writer.close();


        ReportDownload reportDownload = new ReportDownload();

        reportDownload.setUser(principal);
        reportDownload.setId(filenamePrefix);
        reportDownload.setFilename(REPORT_PATH_PREFIX+"/"+filenamePrefix+".csv");

        reportDownloadRepository.save(reportDownload);

        return reportDownload;
    }
}
