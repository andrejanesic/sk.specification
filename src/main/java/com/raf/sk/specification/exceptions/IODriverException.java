package com.raf.sk.specification.exceptions;

/**
 * Za greške prilikom izvršavanja IODriver operacija.
 */
public class IODriverException extends RuntimeException {

    public IODriverException(String s) {
        super(s);
    }
}
