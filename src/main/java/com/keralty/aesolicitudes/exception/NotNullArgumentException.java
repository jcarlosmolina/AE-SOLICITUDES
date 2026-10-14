package com.keralty.aesolicitudes.exception;

public class NotNullArgumentException extends ModelException {

    private static final long serialVersionUID = 1L;

    public NotNullArgumentException(String serviceId, String classId, String argumentId, String serviceAlias,
            String classAlias, String argumentAlias) {
        super(ErrorInfo.NULL_ARGUMENT, "Argument '" + argumentAlias + "' of service '" + serviceAlias + "' in class '"
                + classAlias + "' cannot be null");
        getExceptionMessageParts().add(serviceId);
        getExceptionMessageParts().add(classId);
        getExceptionMessageParts().add(argumentId);
    }

    public NotNullArgumentException(String serviceId, String argumentId, String serviceAlias, String argumentAlias) {
        super(ErrorInfo.NULL_ARGUMENT,
                "Argument '" + argumentAlias + "' of service '" + serviceAlias + "' cannot be null");
        getExceptionMessageParts().add(serviceId);
        getExceptionMessageParts().add(argumentId);
    }
}
