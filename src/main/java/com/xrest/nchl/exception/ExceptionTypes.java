package com.xrest.nchl.exception;

public enum ExceptionTypes {
    NOT_FOUND("NOT FOUND"),
    INVALID("INVALID FORMAT"),
    DELETE("COULD NOT DELETED");
    public final String label;

    ExceptionTypes(String label) {
        this.label = label;
    }
}
