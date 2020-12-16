package org.humanitarian.collector.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "people")
public class Person {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "date_of_birth", nullable = false)
    private Date dob;

    @Column(name = "member_of_lgbtqi")
    private boolean memberOfLgbtqi = false;

    private String breastfeeding;

    private boolean pregnant = false;

    @Column(name = "family_planning")
    private boolean familyPlanning = false;

    private String gender;

    private String relationship;

    @Column(name = "civil_status")
    private String civilStatus;

    @Column(name = "highest_educational_attainment")
    private String highestEducationalAttainment;

    @Column(name = "others_educational_attainment")
    private String othersEducationalAttainment;

    @Column(name = "place_of_birth")
    private String placeOfBirth;

    @Column(name = "others_breastfeeding")
    private String othersBreastfeeding;

    @Column(name = "blood_type")
    private String bloodType;

    @Column(name = "occupation")
    private String occupation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Household household;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<GovernmentProgram> governmentPrograms;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<IpAffiliation> ipAffiliations;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Disability> disabilities;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<FamilyPlanningMethod> familyPlanningMethods;

    public void addFamilyPlanningMethods(String t) {
        if (t != null) {
            if (familyPlanningMethods == null) {
                familyPlanningMethods = new ArrayList<>();
            }

            String[] arr = t.split(" ");

            for (String a : arr) {
                familyPlanningMethods.add(new FamilyPlanningMethod(this, a));
            }
        }
    }

    public void addDisabilities(String t) {
        if (t != null) {
            if (disabilities == null) {
                disabilities = new ArrayList<>();
            }

            String[] arr = t.split(" ");

            for (String a : arr) {
                disabilities.add(new Disability(this, a));
            }
        }
    }

    public void addIpAffiliations(String t) {
        if (t != null) {
            if (ipAffiliations == null) {
                ipAffiliations = new ArrayList<>();
            }

            String[] arr = t.split(" ");

            for (String a : arr) {
                ipAffiliations.add(new IpAffiliation(this, a));
            }
        }
    }

    public void addGovernmentPrograms(String t) {
        if (t != null) {
            if (governmentPrograms == null) {
                governmentPrograms = new ArrayList<>();
            }

            String[] arr = t.split(" ");

            for (String a : arr) {
                governmentPrograms.add(new GovernmentProgram(this, a));
            }
        }
    }

    public List<GovernmentProgram> getGovernmentPrograms() {
        return governmentPrograms;
    }

    public void setGovernmentPrograms(List<GovernmentProgram> governmentPrograms) {
        this.governmentPrograms = governmentPrograms;
    }

    public List<IpAffiliation> getIpAffiliations() {
        return ipAffiliations;
    }

    public void setIpAffiliations(List<IpAffiliation> ipAffiliations) {
        this.ipAffiliations = ipAffiliations;
    }

    public List<Disability> getDisabilities() {
        return disabilities;
    }

    public void setDisabilities(List<Disability> disabilities) {
        this.disabilities = disabilities;
    }

    public List<FamilyPlanningMethod> getFamilyPlanningMethods() {
        return familyPlanningMethods;
    }

    public void setFamilyPlanningMethods(List<FamilyPlanningMethod> familyPlanningMethods) {
        this.familyPlanningMethods = familyPlanningMethods;
    }

    public Household getHousehold() {
        return household;
    }

    public void setHousehold(Household household) {
        this.household = household;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public boolean isMemberOfLgbtqi() {
        return memberOfLgbtqi;
    }

    public void setMemberOfLgbtqi(boolean memberOfLgbtqi) {
        this.memberOfLgbtqi = memberOfLgbtqi;
    }

    public String getBreastfeeding() {
        return breastfeeding;
    }

    public void setBreastfeeding(String breastfeeding) {
        this.breastfeeding = breastfeeding;
    }

    public boolean isPregnant() {
        return pregnant;
    }

    public void setPregnant(boolean pregnant) {
        this.pregnant = pregnant;
    }

    public boolean isFamilyPlanning() {
        return familyPlanning;
    }

    public void setFamilyPlanning(boolean familyPlanning) {
        this.familyPlanning = familyPlanning;
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

    public String getOthersEducationalAttainment() {
        return othersEducationalAttainment;
    }

    public void setOthersEducationalAttainment(String othersEducationalAttainment) {
        this.othersEducationalAttainment = othersEducationalAttainment;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getOthersBreastfeeding() {
        return othersBreastfeeding;
    }

    public void setOthersBreastfeeding(String othersBreastfeeding) {
        this.othersBreastfeeding = othersBreastfeeding;
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
}
