package com.example.cinema.cinema.repository.cinemaproperty;

import com.example.cinema.cinema.model.cinemaproperty.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    Optional<Film> getFilmByFilmName(String filmName);
    Optional<Film> getFilmById(Long id);
//    Optional<Film> getFilmByName(@Param("filmName") String filmName);
}
