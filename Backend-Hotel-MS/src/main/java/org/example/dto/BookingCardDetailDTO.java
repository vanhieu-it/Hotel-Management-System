package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.entity.BookingCardDetail;

import javax.validation.constraints.Min;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingCardDetailDTO {
    private int roomClassId;
    private int bookingCardId;
    @Min(value = 1, message = "Quantity must be greater than zero.")
    private Integer quantity;
    private String roomClassName;

    public static List<BookingCardDetailDTO> toDTO(List<BookingCardDetail> bookingCardDetails) {
        return bookingCardDetails.stream().map(BookingCardDetailDTO::toDTO).collect(Collectors.toList());
    }

    public static BookingCardDetailDTO toDTO(BookingCardDetail bookingCardDetail){
        if (bookingCardDetail == null)
            return null;
        BookingCardDetailDTO dto = new BookingCardDetailDTO();
        dto.setRoomClassId(bookingCardDetail.getRoomClass().getId());
        dto.setQuantity(bookingCardDetail.getQuantity());
        dto.setRoomClassName(bookingCardDetail.getRoomClass().getRoomClassName());
        SimpleDateFormat ft3 = new SimpleDateFormat("dd-MM-yyyy");
        return dto;
    }
}
