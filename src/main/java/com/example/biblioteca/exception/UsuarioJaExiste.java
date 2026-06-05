package com.example.biblioteca.exception;

public class UsuarioJaExiste extends RuntimeException {
    public UsuarioJaExiste(String message) {
        super(message);
    }
}
