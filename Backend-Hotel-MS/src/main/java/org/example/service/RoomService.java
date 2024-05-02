package org.example.service;

import org.springframework.data.domain.Page;
import org.example.dto.RoomDTO;
import org.example.request.CreateRoomRequest;
import org.example.request.UpdateRoomRequest;
import org.example.response.GetRoomResponse;
import org.example.specification.room.RoomCriteria;

import java.util.List;

public interface RoomService {

    void createRoom(CreateRoomRequest createRoomRequest);

    Page<GetRoomResponse> getRooms(int pageNum, int pageSize, String sort,
                                   RoomCriteria roomCriteria);

    void updateRoom(UpdateRoomRequest updateRoomRequest, String roomCode);

    GetRoomResponse getRoomByRoomCode(String roomCode);

    List<RoomDTO> showAll();

    List<RoomDTO> showFreeByRoomClass(Integer id);

    RoomDTO showOne(String roomCode);

    RoomDTO changeState(String roomCode, Integer stateName);

    void delete(String roomCode);
}
