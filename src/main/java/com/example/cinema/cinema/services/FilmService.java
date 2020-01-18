package com.example.cinema.cinema.services;

import com.example.cinema.cinema.model.Film;
import com.example.cinema.cinema.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    @Autowired
    FilmRepository repository;

    private static List<Film> films;

    public FilmService(){
        if(films == null){
            films = new ArrayList<>();
            films.add(new Film(1L,"Rambo"));
            films.add(new Film(2L,"Titanic"));
            films.add(new Film(3L, "Terminator"));
        }
    }


    public FilmService(FilmRepository repository){
        this.repository = repository;
    }

//    public Optional<Film> getFilmByName(final String name) {
//        return repository.getFilmByName(name);
//    }

    public List<Film> getAllFilms(){
        //return repository.findAll();
          return films;
    }
}
