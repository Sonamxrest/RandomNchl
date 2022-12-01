package com.xrest.nchl.exception;

public class BankException extends BaseException {
    public BankException(ExceptionTypes exceptionTypes) {
        super("Bank " + exceptionTypes.label);
    }
}

