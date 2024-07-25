package com.me.CRUD_TESTUNITARIOS_SPRINGBOOT.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String message) {
        super(message);
    }
}
