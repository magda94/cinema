package com.example.cinema.cinema.services;

import com.example.cinema.cinema.exceptions.handler.FilmExistException;
import com.example.cinema.cinema.exceptions.handler.FilmNotFoundException;
import com.example.cinema.cinema.model.Film;
import com.example.cinema.cinema.repository.DirectorRepository;
import com.example.cinema.cinema.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    @Autowired
    FilmRepository repository;

    @Autowired
    DirectorRepository directorRepository;

    private static List<Film> films;

    public FilmService(){ }


    public FilmService(FilmRepository repository){
        this.repository = repository;
    }

//    public Optional<Film> getFilmByName(final String name) {
//        return repository.getFilmByName(name);
//    }

    public List<Film> getAllFilms(){
        return repository.findAll();
    }

    public Optional<Film> getFilmByName(final String filmName) {
        return repository.getFilmByFilmName(filmName);
    }

    public Optional<Film> getFilmById(final Long id) {
        return repository.getFilmById(id);
    }

    public Film addFilm(Film film) {
        Optional<Film> filmOptional = getFilmByName(film.getFilmName());

        if(filmOptional.isPresent()) {
            throw new FilmExistException("Film exists in database");
        }

        //TODO check if Director exist and if not remove request

//        Director director = film.getDirector();
//
//        Film newFilm = new Film();
//        newFilm.setFilmName(film.getFilmName());
//        newFilm.setDirector(director);

        return repository.save(film);
    }

    public void deleteFilmWithId(Long id) {
        if (getFilmById(id).isEmpty()) {
            throw new FilmNotFoundException("Film with id: " + id + " doesn't exist in database");
        }

        repository.deleteById(id);
    }

    public void updateFilmWithId(Film film, Long id) {
        if (getFilmById(id).isEmpty()) {
            throw new FilmNotFoundException("There is no film with id: " + id);
        }

        film.setId(id);
        repository.save(film);
    }
}
