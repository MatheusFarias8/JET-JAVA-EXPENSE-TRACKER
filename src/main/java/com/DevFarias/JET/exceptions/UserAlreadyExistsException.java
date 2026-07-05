package com.DevFarias.JET.exceptions;

public class UserAlreadyExistsException extends BusinessException {
    public UserAlreadyExistsException() {
        super("A user with the provided email already exists.");
    }
}
