package com.stackroute.designerservice.exception;

public class designprovideralreadyexistsexception extends Throwable{
    public String getMessage(){

        return " DESIGNER EXISTS WITH THIS designerId";

    }
}
