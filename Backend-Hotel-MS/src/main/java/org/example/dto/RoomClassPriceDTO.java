package org.example.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.example.entity.RoomClass;
import org.example.entity.RoomClassPrice;

import javax.validation.constraints.Min;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class RoomClassPriceDTO {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date date;
    private RoomClassDTO roomClass;
    @Min(value = 0, message = "price too small")
    private long price;

    public static RoomClassPriceDTO toDTO(RoomClassPrice price){
        if (price == null)
            return null;
        RoomClassPriceDTO dto = new RoomClassPriceDTO();
        dto.setPrice(price.getPrice());
        dto.setRoomClass(RoomClassDTO.toDTO(price.getRoomClass()));
        dto.setDate(price.getDate());
        return dto;
    }

    public static List<RoomClassPriceDTO> toDTO(List<RoomClassPrice> prices){
        if (prices == null)
            return null;
        return prices.stream().map(RoomClassPriceDTO::toDTO).collect(Collectors.toList());
    }

    public static RoomClassPrice toEntity(RoomClassPriceDTO dto){
        if (dto ==null)
            return null;
        RoomClassPrice price = new RoomClassPrice();
        RoomClass roomClass = new RoomClass();
        roomClass.setId(dto.getRoomClass().getId());
        price.setRoomClass(roomClass);
        price.setPrice(dto.getPrice());
        price.setDate(dto.getDate());
        return price;
    }
}
