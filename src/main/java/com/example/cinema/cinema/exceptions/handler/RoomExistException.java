package com.example.cinema.cinema.exceptions.handler;

public class RoomExistException extends RuntimeException {
    public RoomExistException(String message) {
        super(message);
    }
}
