package org.example.service.Impl;

import org.example.dto.RoomCategoryDTO;
import org.example.request.CreateRoomCategoryRequest;
import org.example.request.UpdateRoomCategoryRequest;

import java.util.List;

public interface RoomCategoryService {

    void createRoomCategory(CreateRoomCategoryRequest createRoomCategoryRequest);

    void updateRoomCategory(UpdateRoomCategoryRequest updateRoomCategoryRequest,
                            String roomCategoryCode);

    List<RoomCategoryDTO> findAll();
}
