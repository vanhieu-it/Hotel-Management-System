package org.example.service;

import org.example.dto.RoomTypeDTO;
import org.example.request.CreateRoomTypeRequest;
import org.example.request.UpdateRoomTypeRequest;

import java.util.List;

public interface RoomTypeService {

    void createRoomType(CreateRoomTypeRequest createRoomTypeRequest);

    void updateRoomType(UpdateRoomTypeRequest updateRoomTypeRequest, String roomTypeCode);

    List<RoomTypeDTO> findAll();
}
