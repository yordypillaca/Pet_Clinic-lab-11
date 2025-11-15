package com.tecsup.petclinic.exceptions;

/**
 * 
 * @author bryan
 *
 */
public class ClienteNotFoundException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public ClienteNotFoundException(String message) {
        super(message);
    }

}