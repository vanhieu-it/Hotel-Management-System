package org.example.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.entity.RoomType;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class RoomTypeDTO {
    private String roomTypeCode;
    @NotBlank(message = "can not be empty")
    private String roomTypeName;

    public static RoomTypeDTO toDTO(RoomType roomType){
        if (roomType == null)
            return null;
        RoomTypeDTO dto = new RoomTypeDTO();
        dto.setRoomTypeCode(roomType.getRoomTypeCode());
        dto.setRoomTypeName(roomType.getRoomTypeName());
        return dto;
    }
}
