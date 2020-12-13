package org.humanitarian.collector.services;

import org.humanitarian.collector.auth.models.User;
import org.humanitarian.collector.exceptions.HandlerNotFoundException;
import org.humanitarian.collector.models.BatchDataFile;

import java.io.InputStream;

public interface BatchDataFileService {
    BatchDataFile process(User user, InputStream inputStream, String type) throws HandlerNotFoundException;
}
