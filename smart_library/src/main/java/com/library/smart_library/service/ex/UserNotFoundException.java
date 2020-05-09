package com.library.smart_library.service.ex;

public class UserNotFoundException extends ServiceException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
