package org.humanitarian.collector.repositories;

import org.humanitarian.collector.models.ReportDownload;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface ReportDownloadRepository extends PagingAndSortingRepository<ReportDownload, UUID> {
}
