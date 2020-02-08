package com.example.cinema.cinema.exceptions.handler;

public class FilmExistException extends RuntimeException {
    public FilmExistException(String message) {
        super(message);
    }
}
