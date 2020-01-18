package com.example.cinema.cinema.controller;

import com.example.cinema.cinema.model.FilmList;
import com.example.cinema.cinema.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilmController {

    @Autowired
    FilmService filmService;

    @GetMapping("/films")
    public FilmList getAllUsers(){
        return new FilmList(filmService.getAllFilms());
    }
}
