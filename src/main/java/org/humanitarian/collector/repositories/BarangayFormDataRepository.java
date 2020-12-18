package org.humanitarian.collector.repositories;

import org.humanitarian.collector.models.BarangayFormData;
import org.humanitarian.collector.models.Person;
import org.humanitarian.collector.models.reports.GeneralDemographicData;
import org.humanitarian.collector.models.reports.ReproductiveHealthData;
import org.humanitarian.collector.models.reports.SanitationData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface BarangayFormDataRepository extends PagingAndSortingRepository<BarangayFormData, UUID> {
    BarangayFormData findOneByPerson(Person person);

    @Query("select b.residenceAddress as residenceAddress, count(b.id) as totalPopulation, (select count(b2.id) from BarangayFormData b2 join b2.person p2 where b2.residenceAddress=b.residenceAddress and p2.relationship=?1) as totalHouseholds from BarangayFormData b group by b.residenceAddress order by b.residenceAddress asc")
    List<GeneralDemographicData> getGeneralDemographicsData(String relationshipName);

    @Query("select b.residenceAddress as residenceAddress, (select count(b2.id) from BarangayFormData b2 join b2.person p2 where b2.residenceAddress=b.residenceAddress and p2.gender='female' and p2.pregnant=true) as pregnantWomen, (select count(b3.id) from BarangayFormData b3 join b3.person p3 where b3.residenceAddress=b.residenceAddress and p3.gender='female' and p3.breastfeeding=:exclusiveBF) as motherExclusivelyBF, (select count(b4.id) from BarangayFormData b4 join b4.person p4 where b4.residenceAddress=b.residenceAddress and p4.gender='female' and p4.breastfeeding=:mixedBF) as motherMixedBF, (select count(b5.id) from BarangayFormData b5 join b5.person p5 where b5.residenceAddress=b.residenceAddress and p5.familyPlanning=true) as practicingFamilyPlanning from BarangayFormData b group by b.residenceAddress order by b.residenceAddress asc")
    List<ReproductiveHealthData> getReproductiveHealthData(@Param("exclusiveBF") String exclusiveBF, @Param("mixedBF") String mixedBF);

    @Query("select b.residenceAddress as residenceAddress, (select count(b2.id) from BarangayFormData b2 join b2.typesOfToilet t where b2.residenceAddress=b.residenceAddress and t.type='water_sealed') as waterSealed, (select count(b2.id) from BarangayFormData b2 join b2.typesOfToilet t where b2.residenceAddress=b.residenceAddress and t.type='open_pit') as openPit, (select count(b2.id) from BarangayFormData b2 join b2.typesOfToilet t where b2.residenceAddress=b.residenceAddress and t.type='communal') as communal, (select count(b2.id) from BarangayFormData b2 join b2.typesOfToilet t where b2.residenceAddress=b.residenceAddress and t.type='no_toilet') as noToilet from BarangayFormData b group by b.residenceAddress order by b.residenceAddress asc")
    List<SanitationData> getSanitationData();
}
