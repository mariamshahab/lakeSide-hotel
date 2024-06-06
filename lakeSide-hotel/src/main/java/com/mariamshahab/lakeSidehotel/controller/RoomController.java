package com.mariamshahab.lakeSidehotel.controller;

import com.mariamshahab.lakeSidehotel.model.Room;
import com.mariamshahab.lakeSidehotel.response.RoomResponse;
import com.mariamshahab.lakeSidehotel.service.IRoomService;
import lombok.RequiredArgsConstructor;
import org.hibernate.Remove;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

@RestController

@RequiredArgsConstructor
@RequestMapping("/rooms")
public class RoomController {
    private final IRoomService roomService;

    @PostMapping("/add/new-room")
    public ResponseEntity<RoomResponse> addNewRoom(
            @RequestParam("photo") MultipartFile photo,
            @RequestParam("roomType") String roomType,
            @RequestParam("roomPrice") BigDecimal roomPrice) throws SQLException, IOException {
        Room savedRoom = roomService.addNewRoom(photo, roomType, roomPrice);
        RoomResponse response = new RoomResponse(savedRoom.getRoomPrice(), savedRoom.getRoomType(), savedRoom.getId());
        return ResponseEntity.ok(response);
    }

}
