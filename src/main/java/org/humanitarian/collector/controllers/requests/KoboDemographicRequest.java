package org.humanitarian.collector.controllers.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import com.opencsv.bean.CsvIgnore;

import java.sql.Date;
import java.sql.Timestamp;

public class KoboDemographicRequest {
    @JsonProperty("First_Name")
    @CsvBindByName(column = "First_Name", required = true)
    private String firstName;

    @JsonProperty("Last_Name")
    @CsvBindByName(column = "Last_Name", required = true)
    private String lastName;

    @JsonProperty("Date_of_Birth")
    @CsvDate("yyyy-MM-dd")
    @CsvBindByName(column = "Date_of_Birth", required = true)
    private Date dateOfBirth;

    @JsonProperty("Address")
    @CsvBindByName(column = "Address", required = true)
    private String address;

    @JsonProperty("Telephone_Number")
    @CsvBindByName(column = "Telephone_Number", required = true)
    private String telephoneNumber;

    @JsonProperty("_submission_time")
    @CsvDate("yyyy-MM-dd hh:mm:ss a")
    @CsvBindByName(column = "Submission_Time", required = true)
    private Timestamp submissionTime;

    @JsonProperty("_xform_id_string")
    private String sourceFormId;

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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public Timestamp getSubmissionTime() {
        return submissionTime;
    }

    public void setSubmissionTime(Timestamp submissionTime) {
        this.submissionTime = submissionTime;
    }

    public String getSourceFormId() {
        return sourceFormId;
    }

    public void setSourceFormId(String sourceFormId) {
        this.sourceFormId = sourceFormId;
    }
}
