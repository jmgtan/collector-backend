package org.humanitarian.collector.models;

import org.humanitarian.collector.auth.models.User;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "batch_data_files")
public class BatchDataFile {
    public static final String STATUS_PENDING = "PENDING";
    public static final String STATUS_PROCESSING = "PROCESSING";
    public static final String STATUS_PROCESSED = "PROCESSED";
    public static final String STATUS_FAILED = "FAILED";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "uploaded_by")
    private User user;

    private String location;

    @Column(name = "is_processed", nullable = false)
    private boolean processed = false;

    @Column(name = "status", nullable = true)
    private String status = STATUS_PENDING;

    @Column(name = "uploaded_date", nullable = false)
    private Date uploadedDate = new Date(System.currentTimeMillis());

    @Column(name = "processed_date", nullable = true)
    private Date processedDate;

    @Column(name = "handler_type", nullable = false)
    private String handlerType;

    @Column(name = "error_message", nullable = true)
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getHandlerType() {
        return handlerType;
    }

    public void setHandlerType(String handlerType) {
        this.handlerType = handlerType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getUploadedDate() {
        return uploadedDate;
    }

    public void setUploadedDate(Date uploadedDate) {
        this.uploadedDate = uploadedDate;
    }

    public Date getProcessedDate() {
        return processedDate;
    }

    public void setProcessedDate(Date processedDate) {
        this.processedDate = processedDate;
    }
}
