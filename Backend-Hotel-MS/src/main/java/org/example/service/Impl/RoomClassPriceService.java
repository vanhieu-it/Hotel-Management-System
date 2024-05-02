package org.example.service.Impl;

import org.example.dto.RoomClassPriceDTO;

import java.text.ParseException;
import java.util.List;

public interface RoomClassPriceService {
    List<RoomClassPriceDTO> showByRoomClass(Integer id);
    RoomClassPriceDTO create(RoomClassPriceDTO dto);
    void delete(String date, Integer roomClassId) throws ParseException;
}
