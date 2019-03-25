package com.tomtre.shoppinglist.web.exception;

public class UserAlreadyExistsException extends BaseDataException {
    public UserAlreadyExistsException(String data) {
        super(data);
    }

    public UserAlreadyExistsException(String message, String data) {
        super(message, data);
    }

    public UserAlreadyExistsException(String message, Throwable cause, String data) {
        super(message, cause, data);
    }

    public UserAlreadyExistsException(Throwable cause, String data) {
        super(cause, data);
    }
}
