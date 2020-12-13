package com.example.cinema.cinema.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import javax.validation.constraints.Size;

@Entity
@TableGenerator(name = "directorIdGenerator", initialValue=0)
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "directorIdGenerator")
    private Long id;

    @Size(min=1, max=15)
    private String firstName;

    @Size(min=1, max=20)
    private String lastName;

    public Director() {}

    public Director(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
