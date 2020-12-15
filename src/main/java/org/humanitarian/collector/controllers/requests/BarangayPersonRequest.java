package org.humanitarian.collector.controllers.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

public class BarangayPersonRequest {
    @JsonProperty("group_lu2kq66/FIRST_NAME")
    private String firstName;

    @JsonProperty("group_lu2kq66/MIDDLE_NAME")
    private String middleName;

    @JsonProperty("group_lu2kq66/LAST_NAME")
    private String lastName;

    @JsonProperty("group_lu2kq66/Is_A1_a_member_of_LGBTQI_community")
    private String memberOfLgbtqi;

    @JsonProperty("group_lu2kq66/Where_was_A1_born")
    private String placeOfBirth;

    @JsonProperty("group_lu2kq66/Does_A1_received_government_programs")
    private String receivedGovernmentPrograms;

    @JsonProperty("group_lu2kq66/DOB")
    private Date dob;

    @JsonProperty("group_lu2kq66/Couples_practicing_family_plan")
    private String familyPlanning;

    @JsonProperty("group_lu2kq66/Sex")
    private String sex;

    @JsonProperty("group_lu2kq66/What_was_A1_highes_ucational_attainment")
    private String highestEducationalAttainment;

    @JsonProperty("group_lu2kq66/What_is_the_relationship_of_A")
    private String relationship;

    @JsonProperty("group_lu2kq66/Civil_Status")
    private String civilStatus;

    @JsonProperty("group_lu2kq66/Disability")
    private String disability;

    @JsonProperty("group_lu2kq66/IP_affiliation")
    private String ipAffiliation;

    @JsonProperty("group_lu2kq66/Age_Years_old")
    private int age;

    @JsonProperty("group_lu2kq66/Occupation")
    private String occupation;

    @JsonProperty("group_lu2kq66/Blood_type")
    private String bloodType;

    @JsonProperty("group_lu2kq66/_Specify_others_Hig_ucational_attainment")
    private String otherHighestEducationalAttainment;

    @JsonProperty("group_lu2kq66/Breastfeeding")
    private String breastfeeding;

    @JsonProperty("group_lu2kq66/_Specify_others_Breastfeeding")
    private String othersBreastfeeding;

    @JsonProperty("group_lu2kq66/Pregnant")
    private String pregnant;

    public boolean isPregnant() {
        return pregnant != null && pregnant.equalsIgnoreCase("yes");
    }

    public boolean isPracticingFamilyPlanning() {
        return familyPlanning != null && familyPlanning.equalsIgnoreCase("yes");
    }

    public boolean isMemberOfLgbtqiCommunity() {
        return memberOfLgbtqi != null && memberOfLgbtqi.equalsIgnoreCase("yes");
    }

    public String getPregnant() {
        return pregnant;
    }

    public void setPregnant(String pregnant) {
        this.pregnant = pregnant;
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

    public String getMemberOfLgbtqi() {
        return memberOfLgbtqi;
    }

    public void setMemberOfLgbtqi(String memberOfLgbtqi) {
        this.memberOfLgbtqi = memberOfLgbtqi;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getReceivedGovernmentPrograms() {
        return receivedGovernmentPrograms;
    }

    public void setReceivedGovernmentPrograms(String receivedGovernmentPrograms) {
        this.receivedGovernmentPrograms = receivedGovernmentPrograms;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getFamilyPlanning() {
        return familyPlanning;
    }

    public void setFamilyPlanning(String familyPlanning) {
        this.familyPlanning = familyPlanning;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHighestEducationalAttainment() {
        return highestEducationalAttainment;
    }

    public void setHighestEducationalAttainment(String highestEducationalAttainment) {
        this.highestEducationalAttainment = highestEducationalAttainment;
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

    public String getDisability() {
        return disability;
    }

    public void setDisability(String disability) {
        this.disability = disability;
    }

    public String getIpAffiliation() {
        return ipAffiliation;
    }

    public void setIpAffiliation(String ipAffiliation) {
        this.ipAffiliation = ipAffiliation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getOtherHighestEducationalAttainment() {
        return otherHighestEducationalAttainment;
    }

    public void setOtherHighestEducationalAttainment(String otherHighestEducationalAttainment) {
        this.otherHighestEducationalAttainment = otherHighestEducationalAttainment;
    }

    public String getBreastfeeding() {
        return breastfeeding;
    }

    public void setBreastfeeding(String breastfeeding) {
        this.breastfeeding = breastfeeding;
    }

    public String getOthersBreastfeeding() {
        return othersBreastfeeding;
    }

    public void setOthersBreastfeeding(String othersBreastfeeding) {
        this.othersBreastfeeding = othersBreastfeeding;
    }
}
