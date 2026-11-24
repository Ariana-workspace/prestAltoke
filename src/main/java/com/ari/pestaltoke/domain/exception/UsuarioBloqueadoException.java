package com.ari.pestaltoke.domain.exception;

public class UsuarioBloqueadoException extends RuntimeException{
    public UsuarioBloqueadoException(){
        super("Usuario Bloqueado");
    }
}
