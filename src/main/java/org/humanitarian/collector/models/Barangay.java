package org.humanitarian.collector.models;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Table(name = "reportdata_barangay")
public class Barangay extends ReportData {

    @Column(name = "food_production_activity")
    private String foodProductionActivity;

    @Column(name = "trees_in_vicinity")
    private String treesInVicinity;

    @Column(name = "type_of_toilet")
    private String typeOfToilet;

    @Column(name = "livelihood_equipment")
    private String livelihoodEquipment;

    private int members;

    private String tenure;

    @Column(name = "fortified_food")
    private boolean fortifiedFood = false;

    @Column(name = "garbage_disposal")
    private String garbageDisposal;

    @Column(name = "residence_address")
    private String residenceAddress;

    @Column(name = "water_source")
    private String waterSource;

    @Column(name = "house_level")
    private String houseLevel;

    @Column(name = "iodized_salt")
    private boolean iodizedSalt = false;

    @Column(name = "household_number")
    private String householdNumber;

    private String dwelling;

    public String getFoodProductionActivity() {
        return foodProductionActivity;
    }

    public void setFoodProductionActivity(String foodProductionActivity) {
        this.foodProductionActivity = foodProductionActivity;
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

    public String getTenure() {
        return tenure;
    }

    public void setTenure(String tenure) {
        this.tenure = tenure;
    }

    public boolean isFortifiedFood() {
        return fortifiedFood;
    }

    public void setFortifiedFood(boolean fortifiedFood) {
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

    public boolean isIodizedSalt() {
        return iodizedSalt;
    }

    public void setIodizedSalt(boolean iodizedSalt) {
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
