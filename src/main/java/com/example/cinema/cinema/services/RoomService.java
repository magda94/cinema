package com.example.cinema.cinema.services;

import com.example.cinema.cinema.exceptions.handler.RoomExistException;
import com.example.cinema.cinema.model.Room;
import com.example.cinema.cinema.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    RoomRepository repository;

    public RoomService() {}

    public RoomService(RoomRepository repository) {
        this.repository = repository;
    }

    public List<Room> getAllRooms() {
        return repository.findAll();
    }

    public Optional<Room> getRoomById(final long id) {
        return repository.getRoomById(id);
    }

    public Optional<Room> getRoomByRoomNumber(final int roomNumber) {
        return repository.getRoomByRoomNumber(roomNumber);
    }

    public Room addRoom(Room room) {
        Optional<Room> result = repository.getRoomByRoomNumber(room.getRoomNumber());

        if (result.isPresent()) {
            throw new RoomExistException("Room exists in database");
        }

        return repository.save(room);
    }

    public Room updateRoomWithId(Room room, long id) {
        if (getRoomById(id).isEmpty()) {
            throw new RoomExistException("There is no room with id: " + id);
        }
        room.setId(id);
        return repository.save(room);
    }

    public void deleteRoomWithId(long id) {
        if (getRoomById(id).isEmpty()) {
            throw new RoomExistException("There is no room with id: " + id);
        }

        repository.deleteById(id);
    }

}
