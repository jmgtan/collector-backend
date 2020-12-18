package org.humanitarian.collector.models.reports;

public interface SanitationData {
    String getResidenceAddress();
    int getWaterSealed();
    int getOpenPit();
    int getCommunal();
    int getNoToilet();
}
