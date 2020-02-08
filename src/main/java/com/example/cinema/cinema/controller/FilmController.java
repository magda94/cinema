package com.example.cinema.cinema.controller;

import com.example.cinema.cinema.exceptions.handler.FilmNotFoundException;
import com.example.cinema.cinema.model.Film;
import com.example.cinema.cinema.model.FilmList;
import com.example.cinema.cinema.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class FilmController {

    @Autowired
    FilmService filmService;

    @GetMapping("/films")
    public FilmList getAllFilms(){
        return new FilmList(filmService.getAllFilms());
    }

    @GetMapping("/film/{filmName}")
    public Film getFilmByFilmName(@PathVariable("filmName") String filmName) {
            Optional<Film> result = filmService.getFilmByName(filmName);
            return result.orElseThrow(() -> new FilmNotFoundException("There is no film with name: " + filmName));
    }

    @PostMapping("/films")
    public ResponseEntity addFilm(@RequestBody Film film) {
        return ResponseEntity.status(HttpStatus.CREATED).body(filmService.addFilm(film));
    }

}
