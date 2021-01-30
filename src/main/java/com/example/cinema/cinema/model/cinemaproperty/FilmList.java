package com.example.cinema.cinema.model.cinemaproperty;

import com.example.cinema.cinema.model.cinemaproperty.Film;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName="filmList")
public class FilmList {

    @JsonProperty("filmList")
    @JacksonXmlProperty(localName="film")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Film> films;

    public FilmList() {}

    public FilmList(List<Film> films) {
        this.films = films;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}
