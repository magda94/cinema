package com.example.cinema.cinema.model.cinemaproperty;

import com.example.cinema.cinema.model.cinemaproperty.Room;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JacksonXmlRootElement(localName = "roomList")
@AllArgsConstructor
public class RoomList {
    @JsonProperty("roomList")
    @JacksonXmlProperty(localName = "room")
    @JacksonXmlElementWrapper(useWrapping = false)
    @Getter @Setter
    private List<Room> rooms;
}
