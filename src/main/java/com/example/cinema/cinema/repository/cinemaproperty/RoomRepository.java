package com.example.cinema.cinema.repository.cinemaproperty;

import com.example.cinema.cinema.model.cinemaproperty.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    Optional<Room> getRoomById(Long id);
    Optional<Room> getRoomByRoomNumber(int roomNumber);
}
