package com.example.cinema.cinema.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
public class Film {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Size(min=1, max=20)
    private String filmName;

    @ManyToMany (mappedBy = "filmSet")
    Set<Room> roomSet = new HashSet<>();

    @ManyToOne
//    @JsonIgnore
    @JoinColumn(name="director_id")
    @JsonBackReference
    public Director director;


    public Film() {}

    public Film(long id, String filmName) {
        this.id = id;
        this.filmName = filmName;
    }

    public Film(String filName, Director director) {
        this.filmName = filName;
        this.director = director;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public void addRoom(Room room) {
        this.roomSet.add(room);
        room.getFilmSet().add(this);
    }

    public void removeRoom(Room room) {
        this.roomSet.remove(room);
        room.getFilmSet().remove(this);
    }

    public void addDirector(Director direct) {
        this.director = direct;
//        direct.getFilms().add(this);
    }
}
