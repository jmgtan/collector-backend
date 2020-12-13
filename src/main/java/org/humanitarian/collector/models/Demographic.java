package org.humanitarian.collector.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "data_demographics")
public class Demographic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Column(name = "submission_time")
    private Timestamp submissionTime;

    private String address;

    @Column(name = "telephone_number")
    private String telephoneNumber;

    @Column(name = "source_form_id")
    private String sourceFormId;

    @ManyToOne
    @JoinColumn(name = "from_batch_id", nullable = true)
    private BatchDataFile batch;

    public BatchDataFile getBatch() {
        return batch;
    }

    public void setBatch(BatchDataFile batch) {
        this.batch = batch;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Timestamp getSubmissionTime() {
        return submissionTime;
    }

    public void setSubmissionTime(Timestamp submissionTime) {
        this.submissionTime = submissionTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getSourceFormId() {
        return sourceFormId;
    }

    public void setSourceFormId(String sourceFormId) {
        this.sourceFormId = sourceFormId;
    }
}
