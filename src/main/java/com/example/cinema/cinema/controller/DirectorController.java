package com.example.cinema.cinema.controller;

import com.example.cinema.cinema.model.DirectorList;
import com.example.cinema.cinema.services.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DirectorController {

    @Autowired
    DirectorService directorService;

    @GetMapping("/directors")
    public DirectorList getAllDirectors() {
        return new DirectorList(directorService.getAllDirectors());
    }
}


