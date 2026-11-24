package com.ari.pestaltoke.domain.exception;

public class CredencialesInvalidasException extends RuntimeException{
    public CredencialesInvalidasException(){
        super("Credenciales inválidas");
    }
}
