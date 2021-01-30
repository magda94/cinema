package com.example.cinema.cinema.controller.cinemaproperty;

import com.example.cinema.cinema.exceptions.handler.cinemaproperty.FilmNotFoundException;
import com.example.cinema.cinema.model.cinemaproperty.Film;
import com.example.cinema.cinema.model.cinemaproperty.FilmList;
import com.example.cinema.cinema.services.cinemaproperty.DirectorService;
import com.example.cinema.cinema.services.cinemaproperty.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/films")
public class FilmController {

    @Autowired
    FilmService filmService;

    @Autowired
    DirectorService directorService;

    @GetMapping("/all")
    public FilmList getAllFilms(){
        return new FilmList(filmService.getAllFilms());
    }

    @GetMapping("/{filmName}")
    public Film getFilmByFilmName(@PathVariable("filmName") String filmName) {
            Optional<Film> result = filmService.getFilmByName(filmName);
            return result.orElseThrow(() -> new FilmNotFoundException("There is no film with name: " + filmName));
    }

//    @GetMapping("/films/{id}")
//    public Film getFilmById(@PathVariable("id") Long id) {
//        Optional<Film> result = filmService.getFilmById(id);
//        return result.orElseThrow(() -> new FilmNotFoundException("There is no film wit id: " + id));
//    }

    @PostMapping("")
    public ResponseEntity<Film> addFilm(@RequestBody Film film) {
        return new ResponseEntity<>(filmService.addFilm(film), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteFilm(@PathVariable("id") Long id) {
        filmService.deleteFilmWithId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Film> updateFilm(@RequestBody Film film, @PathVariable("id") Long id) {
        return new ResponseEntity<>(filmService.updateFilmWithId(film, id), HttpStatus.OK);
    }

}
