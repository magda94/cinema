package com.example.cinema.cinema.controller;

import com.example.cinema.cinema.model.Director;
import com.example.cinema.cinema.model.DirectorList;
import com.example.cinema.cinema.services.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DirectorController {

    @Autowired
    DirectorService directorService;

    @GetMapping("/directors")
    public DirectorList getAllDirectors() {
        return new DirectorList(directorService.getAllDirectors());
    }

    @GetMapping("/directors/firstName/{firstName}")
    public DirectorList getAllDirectorsWithFirstName(@PathVariable("firstName") String firstName) {
        return directorService.getAllDirectorsWithFirstName(firstName);
    }

    @GetMapping("/directors/lastName/{lastName}")
    public DirectorList getAllDirectorsWithLastName(@PathVariable("lastName") String lastName) {
        return directorService.getAllDirectorWithLastName(lastName);
    }

    @GetMapping("/directors/fullName/{firstName}-{lastName}")
    public Director getDirector(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
        return directorService.getDirector(firstName, lastName);
    }

    @PostMapping("/directors")
    public ResponseEntity addDirector(@RequestBody Director director) {
        return ResponseEntity.status(HttpStatus.CREATED).body(directorService.addDirector(director));
    }


}


