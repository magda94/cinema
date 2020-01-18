package com.example.cinema.cinema.repository;

import com.example.cinema.cinema.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    //Optional<Film> getFilmByName(@Param("filmName") String filmName);
}
