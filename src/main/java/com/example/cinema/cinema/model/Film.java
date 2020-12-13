package com.example.cinema.cinema.model;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import javax.validation.constraints.Size;

@Entity
@TableGenerator(name="filmIdGenerator", initialValue= 0)
public class Film {

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE, generator="filmIdGenerator")
    private Long id;

    @Size(min=1, max=20)
    private String filmName;


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
}
