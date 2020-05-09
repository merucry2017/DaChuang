package com.library.smart_library.service.ex;

public class BookNotFoundException extends ServiceException {
    public BookNotFoundException(String message) {
        super(message);
    }
}
