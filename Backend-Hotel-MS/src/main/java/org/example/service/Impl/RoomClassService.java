package org.example.service.Impl;

import org.springframework.data.domain.Page;
import org.example.dto.RoomClassDTO;
import org.example.request.CreateRoomClassRequest;
import org.example.request.UpdateRoomClassRequest;
import org.example.response.GetRoomClassResponse;
import org.example.specification.roomclass.RoomClassCriteria;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

public interface RoomClassService {

  //1
  void createRoomClass(CreateRoomClassRequest createRoomClassRequest);

  //3
  Page<GetRoomClassResponse> getRoomClasses(int pageNum, int pageSize, String sort,
      RoomClassCriteria roomClassCriteria);

  //2
  void updateRoomClass(UpdateRoomClassRequest updateRoomClassRequest, Integer roomClassId);

  List<GetRoomClassResponse> getAllRoomClasses();

  List<GetRoomClassResponse> getAllRoomClassesWithTopPromotion();

  //4
  GetRoomClassResponse getRoomClassById(Integer roomClassId);

  //5
  List<RoomClassDTO> lookup(Date startDate, Date endDate, boolean expired);

  //6
  List<RoomClassDTO> showAll();

  //7
  List<RoomClassDTO> showRoomFree();

  //8
  RoomClassDTO create(@Valid RoomClassDTO dto);

  //9
  RoomClassDTO showOne(Integer id);

  //10
  RoomClassDTO update(RoomClassDTO dto);

  //11
  void delete(Integer roomClassId);
}
