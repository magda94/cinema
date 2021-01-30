package com.example.cinema.cinema.exceptions.handler.cinemaproperty;

import java.util.function.Supplier;

public class FilmNotFoundException extends RuntimeException {
    public FilmNotFoundException(String message) {
        super(message);
    }

}
