package com.ari.pestaltoke.domain.exception;

public class EmailYaRegistradoException extends RuntimeException{
    public EmailYaRegistradoException(String email){
        super("Email registrado: "+ email);
    }
}
