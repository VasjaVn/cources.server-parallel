package com.softgroup.common.exceptions;

public class ProtocolVersionException extends SoftgroupException {
    public ProtocolVersionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProtocolVersionException(String message) {
        super(message);
    }
}
