package org.humanitarian.collector.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "data_attachments")
public class DataAttachment {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "mime_type")
    private String mimeType;

    @Column(name = "download_small_url")
    private String downloadSmallUrl;

    @Column(name = "download_large_url")
    private String downloadLargeUrl;

    @Column(name = "download_url")
    private String downloadUrl;

    private String filename;

    @Column(name = "download_medium_url")
    private String downloadMediumUrl;

    @ManyToOne
    @JoinColumn(name = "form_data_id", nullable = false)
    @JsonIgnore
    private FormData formData;

    public FormData getFormData() {
        return formData;
    }

    public void setFormData(FormData formData) {
        this.formData = formData;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getDownloadSmallUrl() {
        return downloadSmallUrl;
    }

    public void setDownloadSmallUrl(String downloadSmallUrl) {
        this.downloadSmallUrl = downloadSmallUrl;
    }

    public String getDownloadLargeUrl() {
        return downloadLargeUrl;
    }

    public void setDownloadLargeUrl(String downloadLargeUrl) {
        this.downloadLargeUrl = downloadLargeUrl;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDownloadMediumUrl() {
        return downloadMediumUrl;
    }

    public void setDownloadMediumUrl(String downloadMediumUrl) {
        this.downloadMediumUrl = downloadMediumUrl;
    }
}
