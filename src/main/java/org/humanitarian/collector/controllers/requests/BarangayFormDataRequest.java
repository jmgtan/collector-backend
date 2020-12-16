package org.humanitarian.collector.controllers.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;
import java.util.List;

public class BarangayFormDataRequest {

    @JsonProperty("group_pp0oh97/Food_Production_Activity")
    private String foodProductionActivity;

    @JsonProperty("group_pp0oh97/Trees_in_vicinity")
    private String treesInVicinity;

    @JsonProperty("group_pp0oh97/Type_of_toilet")
    private String typeOfToilet;

    @JsonProperty("group_pp0oh97/Livelihood_Equipment")
    private String livelihoodEquipment;

    @JsonProperty("group_vl5um06/members")
    private int members;

    @JsonProperty("group_lu2kq66")
    private List<BarangayPersonRequest> people;

    @JsonProperty("group_pp0oh97/Tenure")
    private String tenure;

    @JsonProperty("group_pp0oh97/Do_the_household_con_lling_fortified_food")
    private String fortifiedFood;

    @JsonProperty("group_pp0oh97/Garbage_Disposal")
    private String garbageDisposal;

    @JsonProperty("group_pp0oh97/Residence_Address")
    private String residenceAddress;

    @JsonProperty("_submission_time")
    private Timestamp submissionTime;

    @JsonProperty("group_pp0oh97/Water_Source")
    private String waterSource;

    @JsonProperty("group_pp0oh97/House_Level")
    private String houseLevel;

    @JsonProperty("_attachments")
    private List<AttachmentRequest> attachments;

    @JsonProperty("group_pp0oh97/Do_the_household_consume_iodized_salt")
    private String iodizedSalt;

    @JsonProperty("group_vl5um06/Household_number")
    private String householdNumber;

    @JsonProperty("group_pp0oh97/Dwelling")
    private String dwelling;

    private String sourceSystem;

    @JsonProperty("_xform_id_string")
    private String sourceSystemIdentifier;

    public boolean isConsumedIodizedSalt() {
        return iodizedSalt != null && iodizedSalt.equalsIgnoreCase("yes");
    }

    public boolean isConsumingFortifiedFood() {
        return fortifiedFood != null && fortifiedFood.equalsIgnoreCase("yes");
    }

    public String getFoodProductionActivity() {
        return foodProductionActivity;
    }

    public void setFoodProductionActivity(String foodProductionActivity) {
        this.foodProductionActivity = foodProductionActivity;
    }

    public String getSourceSystem() {
        return sourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    public String getSourceSystemIdentifier() {
        return sourceSystemIdentifier;
    }

    public void setSourceSystemIdentifier(String sourceSystemIdentifier) {
        this.sourceSystemIdentifier = sourceSystemIdentifier;
    }

    public String getTreesInVicinity() {
        return treesInVicinity;
    }

    public void setTreesInVicinity(String treesInVicinity) {
        this.treesInVicinity = treesInVicinity;
    }

    public String getTypeOfToilet() {
        return typeOfToilet;
    }

    public void setTypeOfToilet(String typeOfToilet) {
        this.typeOfToilet = typeOfToilet;
    }

    public String getLivelihoodEquipment() {
        return livelihoodEquipment;
    }

    public void setLivelihoodEquipment(String livelihoodEquipment) {
        this.livelihoodEquipment = livelihoodEquipment;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }

    public List<BarangayPersonRequest> getPeople() {
        return people;
    }

    public void setPeople(List<BarangayPersonRequest> people) {
        this.people = people;
    }

    public String getTenure() {
        return tenure;
    }

    public void setTenure(String tenure) {
        this.tenure = tenure;
    }

    public String getFortifiedFood() {
        return fortifiedFood;
    }

    public void setFortifiedFood(String fortifiedFood) {
        this.fortifiedFood = fortifiedFood;
    }

    public String getGarbageDisposal() {
        return garbageDisposal;
    }

    public void setGarbageDisposal(String garbageDisposal) {
        this.garbageDisposal = garbageDisposal;
    }

    public String getResidenceAddress() {
        return residenceAddress;
    }

    public void setResidenceAddress(String residenceAddress) {
        this.residenceAddress = residenceAddress;
    }

    public Timestamp getSubmissionTime() {
        return submissionTime;
    }

    public void setSubmissionTime(Timestamp submissionTime) {
        this.submissionTime = submissionTime;
    }

    public String getWaterSource() {
        return waterSource;
    }

    public void setWaterSource(String waterSource) {
        this.waterSource = waterSource;
    }

    public String getHouseLevel() {
        return houseLevel;
    }

    public void setHouseLevel(String houseLevel) {
        this.houseLevel = houseLevel;
    }

    public List<AttachmentRequest> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<AttachmentRequest> attachments) {
        this.attachments = attachments;
    }

    public String getIodizedSalt() {
        return iodizedSalt;
    }

    public void setIodizedSalt(String iodizedSalt) {
        this.iodizedSalt = iodizedSalt;
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
}
