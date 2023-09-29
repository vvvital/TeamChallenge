package com.vvvital.teamchallenge.servise;

public class ExceptionUser  extends Throwable{

    private final String exception;
    public ExceptionUser(String exception){
        this.exception=exception;
    }
}
