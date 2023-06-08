package org.medtech.medmeet.shared.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String resourceName, Integer resourceId) {
        super(String.format("%s with id %d not found.", resourceName, resourceId));
        StackTraceElement[] traceElements = {};
        this.setStackTrace(traceElements);
    }
}
