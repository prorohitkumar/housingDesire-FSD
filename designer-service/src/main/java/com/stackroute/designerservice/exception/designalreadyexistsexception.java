package com.stackroute.designerservice.exception;

public class designalreadyexistsexception extends Throwable{
    public String getMessage(){

        return " DESIGN EXISTS WITH THIS designId";

    }
}
