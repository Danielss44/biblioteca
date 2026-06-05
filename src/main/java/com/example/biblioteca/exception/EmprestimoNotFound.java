package com.example.biblioteca.exception;

public class EmprestimoNotFound extends RuntimeException {
    public EmprestimoNotFound(String message) {
        super(message);
    }
}
