package com.example.cinema.cinema.repository.cinemaproperty;


import com.example.cinema.cinema.model.cinemaproperty.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {
    List<Director> findAllByFirstName(@Param("firstName") String firstName);

    List<Director> findAllByLastName(@Param("lastName") String lastName);
}
