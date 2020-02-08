package com.example.cinema.cinema.services;

import com.example.cinema.cinema.model.Director;
import com.example.cinema.cinema.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DirectorService {

    @Autowired
    DirectorRepository repository;

    private static List<Director> directors;

    public DirectorService() {
        if (directors == null) {
            directors = new ArrayList<>();
            directors.add(new Director(1L, "Steven", "Spielberg"));
            directors.add(new Director(2L, "Andrzej", "Wajda"));
        }
    }

    public DirectorService(DirectorRepository repository) {
        this.repository = repository;
    }

    public List<Director> getAllDirectors() {
        return directors;
    }
}
