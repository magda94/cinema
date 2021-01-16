package com.example.cinema.cinema.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@TableGenerator(name="filmIdGenerator", initialValue= 0)
@Getter @Setter
public class Film {

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE, generator="filmIdGenerator")
    private Long id;

    @Size(min=1, max=20)
    private String filmName;

    @ManyToMany (mappedBy = "filmSet")
    Set<Room> roomSet = new HashSet<>();

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="director_id")
    public Director director;


    public Film() {}

    public Film(long id, String filmName) {
        this.id = id;
        this.filmName = filmName;
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
