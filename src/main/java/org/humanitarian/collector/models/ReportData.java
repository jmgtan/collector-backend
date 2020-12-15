package org.humanitarian.collector.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "report_data")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ReportData {
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

    @ManyToMany
    @JoinTable(
            name = "report_data_persons",
            joinColumns = @JoinColumn(name = "report_data_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private List<Person> associatedPersons;

    @OneToMany(mappedBy = "reportData")
    private List<DataAttachment> dataAttachments;

    @ManyToOne
    @JoinColumn(name = "batch_data_file_id")
    private BatchDataFile batchDataFile;

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

    public List<Person> getAssociatedPersons() {
        return associatedPersons;
    }

    public void setAssociatedPersons(List<Person> associatedPersons) {
        this.associatedPersons = associatedPersons;
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

    public void addPerson(Person p) {
        if (associatedPersons == null) {
            associatedPersons = new ArrayList<>();
        }

        associatedPersons.add(p);
    }

    public void addDataAttachment(DataAttachment d) {
        if (dataAttachments == null) {
            dataAttachments = new ArrayList<>();
        }

        dataAttachments.add(d);
    }
}
