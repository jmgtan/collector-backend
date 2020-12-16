package org.humanitarian.collector.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "parent_form_data")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class FormData {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "date_created", nullable = false)
    private Timestamp dateCreated = new Timestamp(System.currentTimeMillis());

    @Column(name = "submission_time", nullable = false)
    private Timestamp submissionTime = new Timestamp(System.currentTimeMillis());

    @Column(name = "source_system")
    private String sourceSystem;

    @Column(name = "source_system_identifier")
    private String sourceSystemIdentifier;

    @OneToMany(mappedBy = "formData")
    private List<DataAttachment> dataAttachments;

    @OneToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "batch_data_file_id")
    private BatchDataFile batchDataFile;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public BatchDataFile getBatchDataFile() {
        return batchDataFile;
    }

    public void setBatchDataFile(BatchDataFile batchDataFile) {
        this.batchDataFile = batchDataFile;
    }

    public List<DataAttachment> getDataAttachments() {
        return dataAttachments;
    }

    public void setDataAttachments(List<DataAttachment> dataAttachments) {
        this.dataAttachments = dataAttachments;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Timestamp getSubmissionTime() {
        return submissionTime;
    }

    public void setSubmissionTime(Timestamp submissionTime) {
        this.submissionTime = submissionTime;
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

    public void addDataAttachment(DataAttachment d) {
        if (dataAttachments == null) {
            dataAttachments = new ArrayList<>();
        }

        dataAttachments.add(d);
    }
}
