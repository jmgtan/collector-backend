package org.humanitarian.collector.controllers.requests;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BarangayFormDataBatchRow {
    @CsvBindByName(column = "First_Name", required = true)
    private String firstName;

    @CsvBindByName(column = "Middle_Name", required = true)
    private String middleName;

    @CsvBindByName(column = "Last_Name", required = true)
    private String lastName;

    @CsvDate("yyyy-MM-dd")
    @CsvBindByName(column = "DOB", required = true)
    private Date dob;

    @CsvBindByName(column = "Member_of_LGBTQI")
    private String memberOfLGBTQI;

    @CsvBindByName(column = "Breastfeeding")
    private String breastfeeding;

    @CsvBindByName(column = "Pregnant")
    private String pregnant;

    @CsvBindByName(column = "Practicing_Family_Planning")
    private String practicingFamilyPlanning;

    @CsvBindByName(column = "Gender")
    private String gender;

    @CsvBindByName(column = "Relationship")
    private String relationship;

    @CsvBindByName(column = "Civil_Status")
    private String civilStatus;

    @CsvBindByName(column = "Highest_Educational_Attainment")
    private String highestEducationalAttainment;

    @CsvBindByName(column = "Place_of_Birth")
    private String placeOfBirth;

    @CsvBindByName(column = "Blood_Type")
    private String bloodType;

    @CsvBindByName(column = "Occupation")
    private String occupation;

    @CsvBindByName(column = "Government_Programs")
    private String governmentPrograms;

    @CsvBindByName(column = "IP_Affiliations")
    private String ipAffiliations;

    @CsvBindByName(column = "Disabilities")
    private String disabilities;

    @CsvBindByName(column = "Family_Planning_Methods")
    private String familyPlanningMethods;

    @CsvBindByName(column = "Food_Production_Activities")
    private String foodProductionActivities;

    @CsvBindByName(column = "Trees_in_Vicinity")
    private String treesInVicinity;

    @CsvBindByName(column = "Types_of_Toilet")
    private String typesOfToilet;

    @CsvBindByName(column = "Livelihood_Equipments")
    private String livelihoodEquipments;

    @CsvBindByName(column = "Garbage_Disposals")
    private String garbageDisposals;

    @CsvBindByName(column = "Water_Sources")
    private String waterSources;

    @CsvBindByName(column = "Members_Count")
    private int membersCount;

    @CsvBindByName(column = "Tenure")
    private String tenure;

    @CsvBindByName(column = "Consuming_Fortified_Food")
    private String consumingFortifiedFood;

    @CsvBindByName(column = "Residence_Address")
    private String residenceAddress;

    @CsvBindByName(column = "House_Level")
    private String houseLevel;

    @CsvBindByName(column = "Consuming_Iodized_Salt")
    private String consumingIodizedSalt;

    @CsvBindByName(column = "Household_Number")
    private String householdNumber;

    @CsvBindByName(column = "Dwelling")
    private String dwelling;

    public BarangayFormDataRequest toFormDataRequest() {
        List<BarangayPersonRequest> personRequestList = new ArrayList<>();

        BarangayFormDataRequest r = new BarangayFormDataRequest();
        r.setFoodProductionActivity(getFoodProductionActivities());
        r.setTreesInVicinity(getTreesInVicinity());
        r.setTypeOfToilet(getTypesOfToilet());
        r.setLivelihoodEquipment(getLivelihoodEquipments());
        r.setMembers(getMembersCount());

        BarangayPersonRequest personRequest = new BarangayPersonRequest();
        personRequest.setFirstName(getFirstName());
        personRequest.setMiddleName(getMiddleName());
        personRequest.setLastName(getLastName());
        personRequest.setMemberOfLgbtqi(getMemberOfLGBTQI());
        personRequest.setDob(getDob());
        personRequest.setPlaceOfBirth(getPlaceOfBirth());
        personRequest.setReceivedGovernmentPrograms(getGovernmentPrograms());
        personRequest.setFamilyPlanning(getPracticingFamilyPlanning());
        personRequest.setSex(getGender());
        personRequest.setHighestEducationalAttainment(getHighestEducationalAttainment());
        personRequest.setRelationship(getRelationship());
        personRequest.setCivilStatus(getCivilStatus());
        personRequest.setDisability(getDisabilities());
        personRequest.setIpAffiliation(getIpAffiliations());
        personRequest.setOccupation(getOccupation());
        personRequest.setBloodType(getBloodType());
        personRequest.setBreastfeeding(getBreastfeeding());
        personRequest.setPregnant(getPregnant());
        personRequest.setFamilyPlanningMethod(getFamilyPlanningMethods());
        personRequestList.add(personRequest);

        r.setPeople(personRequestList);
        r.setTenure(getTenure());
        r.setFortifiedFood(getConsumingFortifiedFood());
        r.setGarbageDisposal(getGarbageDisposals());
        r.setResidenceAddress(getResidenceAddress());
        r.setSubmissionTime(new Timestamp(System.currentTimeMillis()));
        r.setWaterSource(getWaterSources());
        r.setHouseLevel(getHouseLevel());
        r.setIodizedSalt(getConsumingIodizedSalt());
        r.setHouseholdNumber(getHouseholdNumber());
        r.setDwelling(getDwelling());

        return r;
    }

    public String getResidenceAddress() {
        return residenceAddress;
    }

    public void setResidenceAddress(String residenceAddress) {
        this.residenceAddress = residenceAddress;
    }

    public String getHouseLevel() {
        return houseLevel;
    }

    public void setHouseLevel(String houseLevel) {
        this.houseLevel = houseLevel;
    }

    public String getConsumingIodizedSalt() {
        return consumingIodizedSalt;
    }

    public void setConsumingIodizedSalt(String consumingIodizedSalt) {
        this.consumingIodizedSalt = consumingIodizedSalt;
    }

    public String getHouseholdNumber() {
        return householdNumber;
    }

    public void setHouseholdNumber(String householdNumber) {
        this.householdNumber = householdNumber;
    }

    public String getDwelling() {
        return dwelling;
    }

    public void setDwelling(String dwelling) {
        this.dwelling = dwelling;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getMemberOfLGBTQI() {
        return memberOfLGBTQI;
    }

    public void setMemberOfLGBTQI(String memberOfLGBTQI) {
        this.memberOfLGBTQI = memberOfLGBTQI;
    }

    public String getBreastfeeding() {
        return breastfeeding;
    }

    public void setBreastfeeding(String breastfeeding) {
        this.breastfeeding = breastfeeding;
    }

    public String getPregnant() {
        return pregnant;
    }

    public void setPregnant(String pregnant) {
        this.pregnant = pregnant;
    }

    public String getPracticingFamilyPlanning() {
        return practicingFamilyPlanning;
    }

    public void setPracticingFamilyPlanning(String practicingFamilyPlanning) {
        this.practicingFamilyPlanning = practicingFamilyPlanning;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    public String getHighestEducationalAttainment() {
        return highestEducationalAttainment;
    }

    public void setHighestEducationalAttainment(String highestEducationalAttainment) {
        this.highestEducationalAttainment = highestEducationalAttainment;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getGovernmentPrograms() {
        return governmentPrograms;
    }

    public void setGovernmentPrograms(String governmentPrograms) {
        this.governmentPrograms = governmentPrograms;
    }

    public String getIpAffiliations() {
        return ipAffiliations;
    }

    public void setIpAffiliations(String ipAffiliations) {
        this.ipAffiliations = ipAffiliations;
    }

    public String getDisabilities() {
        return disabilities;
    }

    public void setDisabilities(String disabilities) {
        this.disabilities = disabilities;
    }

    public String getFamilyPlanningMethods() {
        return familyPlanningMethods;
    }

    public void setFamilyPlanningMethods(String familyPlanningMethods) {
        this.familyPlanningMethods = familyPlanningMethods;
    }

    public String getFoodProductionActivities() {
        return foodProductionActivities;
    }

    public void setFoodProductionActivities(String foodProductionActivities) {
        this.foodProductionActivities = foodProductionActivities;
    }

    public String getTreesInVicinity() {
        return treesInVicinity;
    }

    public void setTreesInVicinity(String treesInVicinity) {
        this.treesInVicinity = treesInVicinity;
    }

    public String getTypesOfToilet() {
        return typesOfToilet;
    }

    public void setTypesOfToilet(String typesOfToilet) {
        this.typesOfToilet = typesOfToilet;
    }

    public String getLivelihoodEquipments() {
        return livelihoodEquipments;
    }

    public void setLivelihoodEquipments(String livelihoodEquipments) {
        this.livelihoodEquipments = livelihoodEquipments;
    }

    public String getGarbageDisposals() {
        return garbageDisposals;
    }

    public void setGarbageDisposals(String garbageDisposals) {
        this.garbageDisposals = garbageDisposals;
    }

    public String getWaterSources() {
        return waterSources;
    }

    public void setWaterSources(String waterSources) {
        this.waterSources = waterSources;
    }

    public int getMembersCount() {
        return membersCount;
    }

    public void setMembersCount(int membersCount) {
        this.membersCount = membersCount;
    }

    public String getTenure() {
        return tenure;
    }

    public void setTenure(String tenure) {
        this.tenure = tenure;
    }

    public String getConsumingFortifiedFood() {
        return consumingFortifiedFood;
    }

    public void setConsumingFortifiedFood(String consumingFortifiedFood) {
        this.consumingFortifiedFood = consumingFortifiedFood;
    }
}
