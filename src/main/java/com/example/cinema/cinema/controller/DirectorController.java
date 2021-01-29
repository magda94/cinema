package com.example.cinema.cinema.controller;

import com.example.cinema.cinema.model.Director;
import com.example.cinema.cinema.model.DirectorList;
import com.example.cinema.cinema.services.DirectorService;
import com.example.cinema.cinema.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/directors")
public class DirectorController {

    @Autowired
    DirectorService directorService;

    @Autowired
    FilmService filmService;

    @GetMapping("/all")
    public DirectorList getAllDirectors() {
        return new DirectorList(directorService.getAllDirectors());
    }

    @GetMapping("/firstName/{firstName}")
    public DirectorList getAllDirectorsWithFirstName(@PathVariable("firstName") String firstName) {
        return directorService.getAllDirectorsWithFirstName(firstName);
    }

    @GetMapping("/lastName/{lastName}")
    public DirectorList getAllDirectorsWithLastName(@PathVariable("lastName") String lastName) {
        return directorService.getAllDirectorWithLastName(lastName);
    }

    @GetMapping("/fullName/{firstName}-{lastName}")
    public Director getDirector(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
        return directorService.getDirector(firstName, lastName);
    }

    @PostMapping("")
    public ResponseEntity<Director> addDirector(@RequestBody Director director) {
        return new ResponseEntity<Director>(directorService.addDirector(director), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Director> updateDirector(@RequestBody Director director, @PathVariable("id") Long id) {
        return new ResponseEntity<>(directorService.updateDirector(director, id), HttpStatus.OK);
    }


}


