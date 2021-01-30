package com.example.cinema.cinema.model.cinemaproperty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
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

    public Film(long id, String filmName) {
        this.id = id;
        this.filmName = filmName;
    }

    public Film(String filName, Director director) {
        this.filmName = filName;
        this.director = director;
    }
}
