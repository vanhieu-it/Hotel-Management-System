package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.example.entity.*;
import org.example.util.DateUtils;

import java.time.LocalTime;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {
    private String roomCode;
    private String description;
    private RoomStatusDTO status;
    @Length(min = 1, max = 15, message = "Name of room class too long or too short.")
    private String roomClassName;
    private CustomerDTO customer;
    private String subState;
    private RoomClassDTO roomClass;

    public static RoomDTO toDTO(Room room) {
        if (room == null)
            return null;
        RoomDTO dto = new RoomDTO();
        dto.setDescription(room.getDescription());
        dto.setRoomCode(room.getRoomCode());
        dto.setRoomClassName(room.getRoomClass().getRoomClassName());
        dto.setStatus(RoomStatusDTO.toDTO(room.getStatus()));
        dto.setRoomClass(RoomClassDTO.toDTO(room.getRoomClass()));
        List<RentalDetail> details = room.getRentalDetails();
        if (details.size() > 0) {
            details = details.stream().sorted(Comparator.comparing(RentalDetail::getID)).collect(Collectors.toList());
            RentalDetail detail = details.get(details.size() - 1);
            if (!detail.isStatus()) {
                BookingCard bookingCard = detail.getRent().getBookingCard();
                Date backAtDate = bookingCard.getBackingAtDate();
                backAtDate = new Date(backAtDate.getYear(), backAtDate.getMonth(), backAtDate.getDate());
                if (DateUtils.isSameDay(backAtDate, new Date()) && LocalTime.now().getHour() < 11)
                    dto.setSubState(RoomStatusName.PAYMENT_OF_DATE.name());
                else if ((DateUtils.isSameDay(backAtDate, new Date()) && (LocalTime.now().getHour() >= 11))
                        || DateUtils.isBefore(backAtDate, new Date()))// backAtDate.before(new Date()))
                    dto.setSubState(RoomStatusName.EXPIRED.name());
                Customer customer = bookingCard.getCustomer();
                CustomerDTO cus = new CustomerDTO();
                cus.setName(customer.getName());
                cus.setCmnd(customer.getCmnd().isEmpty() ? "N/A" : customer.getCmnd());
                dto.setCustomer(cus);
            }
        }
        return dto;
    }
}
