package com.library.smart_library.service.ex;

public class PasswordNotMatchException extends ServiceException {
    public PasswordNotMatchException(String message) {
        super(message);
    }
}
