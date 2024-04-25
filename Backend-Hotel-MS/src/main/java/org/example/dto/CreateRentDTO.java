package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateRentDTO {
    private int bookingCardId;
    private int discountPercent;
    private BookingCardDTO bookingCard;
    private List<RoomClassDTO> roomClassDTOS;
}
