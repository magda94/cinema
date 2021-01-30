package com.example.cinema.cinema.controller.cinemaproperty;

import com.example.cinema.cinema.exceptions.handler.cinemaproperty.RoomExistException;
import com.example.cinema.cinema.model.cinemaproperty.Room;
import com.example.cinema.cinema.model.cinemaproperty.RoomList;
import com.example.cinema.cinema.services.cinemaproperty.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Room> addRoom(@RequestBody Room room) {
        return new ResponseEntity<>(roomService.addRoom(room), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(@RequestBody Room room, @PathVariable("id") long id) {
        return new ResponseEntity<>(roomService.updateRoomWithId(room, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable("id") long id) {
        roomService.deleteRoomWithId(id);
    }
}
