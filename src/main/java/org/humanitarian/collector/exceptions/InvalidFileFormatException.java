package org.humanitarian.collector.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidFileFormatException extends BaseRestException{
    public InvalidFileFormatException() {
        super(HttpStatus.BAD_REQUEST.value(), "Invalid File Format.");
    }
}
