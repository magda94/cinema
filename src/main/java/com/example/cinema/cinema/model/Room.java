package com.example.cinema.cinema.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.TableGenerator;
import java.util.HashSet;
import java.util.Set;

@Entity
@TableGenerator(name = "roomIdGenerator")
@Getter @Setter
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "roomIdGenerator")
    private Long id;

    private int roomNumber;

    @ManyToMany
    @JoinTable(name="rooms_films",
    joinColumns = @JoinColumn(name = "room_id"), inverseJoinColumns = @JoinColumn(name = "film_id"))
    Set<Film> filmSet = new HashSet<>();

    public void addFilm(Film film) {
        this.filmSet.add(film);
        film.getRoomSet().add(this);
    }

    public void removeFilm(Film film) {
        this.filmSet.remove(film);
        film.getRoomSet().remove(this);
    }
}
