package com.example.cinema.cinema.services;

import com.example.cinema.cinema.exceptions.handler.DirectorExistException;
import com.example.cinema.cinema.exceptions.handler.DirectorNotFoundException;
import com.example.cinema.cinema.model.Director;
import com.example.cinema.cinema.model.DirectorList;
import com.example.cinema.cinema.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        //return directors;
        return repository.findAll();
    }

    public Long addDirector(Director director) {
        List<Director> directorsList = getAllDirectors();

        Optional<Director> seachedDirector = directorsList.stream()
                .filter(v -> v.getFirstName().equals(director.getFirstName()))
                .filter(v -> v.getLastName().equals(director.getLastName()))
                .findFirst();

        if (seachedDirector.isPresent())
            throw new DirectorExistException("Director exists in database");

        return repository.save(director).getId();
    }

    public DirectorList getAllDirectorsWithFirstName(String firstName) {
       return new DirectorList(repository.findAllByFirstName(firstName));
    }

    public DirectorList getAllDirectorWithLastName(String lastName) {
        return new DirectorList(repository.findAllByLastName(lastName));
    }

    public Director getDirector(String firstName, String lastName) {
        List<Director> directorsWithFirstName = repository.findAllByFirstName(firstName);
        List<Director> directorsWithLastName = repository.findAllByLastName(lastName);

        directorsWithFirstName.retainAll(directorsWithLastName);

        if (directorsWithFirstName.isEmpty())
            throw new DirectorNotFoundException("There is no director with: " + firstName + " " + lastName);

        return directorsWithFirstName.get(0);
    }
}
