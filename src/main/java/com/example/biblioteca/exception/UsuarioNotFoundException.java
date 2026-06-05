package com.example.biblioteca.exception;

public class UsuarioNotFoundException extends RuntimeException{
    public UsuarioNotFoundException(String mensagem){
        super(mensagem);
    }
}
