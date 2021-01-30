package com.example.cinema.cinema.model.cinemaproperty;


import com.example.cinema.cinema.model.cinemaproperty.Director;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "directorList")
public class DirectorList {

    @JsonProperty("directorList")
    @JacksonXmlProperty(localName = "director")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Director> directors;

    public DirectorList() {}

    public DirectorList(List<Director> directorList) {
        this.directors = directorList;
    }

    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }
}
