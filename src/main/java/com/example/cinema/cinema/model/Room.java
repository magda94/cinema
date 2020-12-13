package com.example.cinema.cinema.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
@TableGenerator(name = "roomIdGenerator")
@Getter @Setter
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "directorIdGenerator")
    private Long id;

    private int roomNumber;
}
