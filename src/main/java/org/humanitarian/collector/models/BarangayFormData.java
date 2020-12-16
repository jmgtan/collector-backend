package org.humanitarian.collector.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "form_data_barangay")
public class BarangayFormData extends FormData {

    @OneToMany(mappedBy = "formData", cascade = CascadeType.ALL)
    private List<FoodProductionActivity> foodProductionActivities;

    @OneToMany(mappedBy = "formData", cascade = CascadeType.ALL)
    private List<TreeInVicinity> treesInVicinity;

    @OneToMany(mappedBy = "formData", cascade = CascadeType.ALL)
    private List<TypeOfToilet> typesOfToilet;

    @OneToMany(mappedBy = "formData", cascade = CascadeType.ALL)
    private List<LivelihoodEquipment> livelihoodEquipments;

    @OneToMany(mappedBy = "formData", cascade = CascadeType.ALL)
    private List<GarbageDisposal> garbageDisposals;

    @OneToMany(mappedBy = "formData", cascade = CascadeType.ALL)
    private List<WaterSource> waterSources;

    private int members;

    private String tenure;

    @Column(name = "fortified_food")
    private boolean fortifiedFood = false;

    @Column(name = "residence_address")
    private String residenceAddress;

    @Column(name = "house_level")
    private String houseLevel;

    @Column(name = "iodized_salt")
    private boolean iodizedSalt = false;

    @Column(name = "household_number")
    private String householdNumber;

    private String dwelling;

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

    public void addWaterSources(String t) {
        if (t != null) {
            if (waterSources == null) {
                waterSources = new ArrayList<>();
            }

            String[] ts = t.split(" ");

            for (String arr : ts) {
                waterSources.add(new WaterSource(this, arr));
            }
        }
    }

    public void addGarbageDisposals(String t) {
        if (t != null) {
            if (garbageDisposals == null) {
                garbageDisposals = new ArrayList<>();
            }

            String[] ts = t.split(" ");

            for (String arr : ts) {
                garbageDisposals.add(new GarbageDisposal(this, arr));
            }
        }
    }

    public void addLivelihoodEquipments(String equipments) {
        if (equipments != null) {
            if (livelihoodEquipments == null) {
                livelihoodEquipments = new ArrayList<>();
            }

            String[] arrEquipments = equipments.split(" ");

            for (String arrEquipment : arrEquipments) {
                livelihoodEquipments.add(new LivelihoodEquipment(this, arrEquipment));
            }
        }
    }

    public void addTypesOfToilet(String types) {
        if (types != null) {
            if (typesOfToilet == null) {
                typesOfToilet = new ArrayList<>();
            }

            String[] arrTypes = types.split(" ");

            for (String arrType : arrTypes) {
                typesOfToilet.add(new TypeOfToilet(this, arrType));
            }
        }
    }

    public void addFoodProductionActivities(String activities) {
        if (activities != null) {
            if (foodProductionActivities == null) {
                foodProductionActivities = new ArrayList<>();
            }

            String[] arrActivities = activities.split(" ");

            for (String arrActivity : arrActivities) {
                foodProductionActivities.add(new FoodProductionActivity(this, arrActivity));
            }
        }
    }

    public void addTreeInVicinity(String trees) {
        if (trees != null) {
            if (treesInVicinity == null) {
                treesInVicinity = new ArrayList<>();
            }

            String[] arrTrees = trees.split(" ");

            for (String arrTree : arrTrees) {
                treesInVicinity.add(new TreeInVicinity(this, arrTree));
            }
        }
    }

    public List<FoodProductionActivity> getFoodProductionActivities() {
        return foodProductionActivities;
    }

    public void setFoodProductionActivities(List<FoodProductionActivity> foodProductionActivities) {
        this.foodProductionActivities = foodProductionActivities;
    }

    public List<TreeInVicinity> getTreesInVicinity() {
        return treesInVicinity;
    }

    public void setTreesInVicinity(List<TreeInVicinity> treesInVicinity) {
        this.treesInVicinity = treesInVicinity;
    }

    public List<TypeOfToilet> getTypesOfToilet() {
        return typesOfToilet;
    }

    public void setTypesOfToilet(List<TypeOfToilet> typesOfToilet) {
        this.typesOfToilet = typesOfToilet;
    }

    public List<LivelihoodEquipment> getLivelihoodEquipments() {
        return livelihoodEquipments;
    }

    public void setLivelihoodEquipments(List<LivelihoodEquipment> livelihoodEquipments) {
        this.livelihoodEquipments = livelihoodEquipments;
    }

    public List<GarbageDisposal> getGarbageDisposals() {
        return garbageDisposals;
    }

    public void setGarbageDisposals(List<GarbageDisposal> garbageDisposals) {
        this.garbageDisposals = garbageDisposals;
    }

    public List<WaterSource> getWaterSources() {
        return waterSources;
    }

    public void setWaterSources(List<WaterSource> waterSources) {
        this.waterSources = waterSources;
    }
}
