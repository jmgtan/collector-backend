package org.humanitarian.collector.controllers.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BarangayAttachmentRequest {

    @JsonProperty("mimetype")
    private String mimeType;

    @JsonProperty("download_small_url")
    private String downloadSmallUrl;

    @JsonProperty("download_large_url")
    private String downloadLargeUrl;

    @JsonProperty("download_url")
    private String downloadUrl;

    @JsonProperty("filename")
    private String filename;

    @JsonProperty("download_medium_url")
    private String downloadMediumUrl;

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
