package com.example.relation.exception;

public class BadRequest extends RuntimeException{

    public BadRequest(String message){
        super(message);
    }
}
