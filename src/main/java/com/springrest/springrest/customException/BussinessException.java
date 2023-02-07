package com.springrest.springrest.customException;

public class BussinessException extends RuntimeException {
    public BussinessException(String InvalidAge) {
        super(InvalidAge);
    }
}
