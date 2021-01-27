package com.example.cinema.cinema.controller;

import com.example.cinema.cinema.exceptions.handler.FilmNotFoundException;
import com.example.cinema.cinema.exceptions.handler.RoomExistException;
import com.example.cinema.cinema.model.Room;
import com.example.cinema.cinema.model.RoomList;
import com.example.cinema.cinema.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    RoomService roomService;

    @GetMapping("/all")
    public RoomList getRooms() {
        return new RoomList(roomService.getAllRooms());
    }

    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable("id") long id) {
        return roomService.getRoomById(id)
                .orElseThrow(() -> new RoomExistException("There is no room with id: " + id));
    }

    @GetMapping("/roomNumber/{roomNumber}")
    public Room getRoomByRoomNumber(@PathVariable("roomNumber") int roomNumber) {
        return roomService.getRoomByRoomNumber(roomNumber)
                .orElseThrow(() -> new RoomExistException("There is no room with number: " + roomNumber));
    }

    @PostMapping("")
    public ResponseEntity addRoom(@RequestBody Room room) {
        return ResponseEntity.status(HttpStatus.CREATED).body(roomService.addRoom(room));
    }

    @PutMapping("/{id}")
    public void updateRoom(@RequestBody Room room, @PathVariable("id") long id) {
        roomService.updateRoomWithId(room, id);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable("id") long id) {
        roomService.deleteRoomWithId(id);
    }
}
