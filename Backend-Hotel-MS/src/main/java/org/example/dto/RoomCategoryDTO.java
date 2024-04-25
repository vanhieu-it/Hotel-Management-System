package org.example.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.entity.RoomCategory;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class RoomCategoryDTO {
    private String roomCategoryCode;
    @NotBlank(message = "can not be empty")
    private String roomCategoryName;

    public static RoomCategoryDTO toDTO(RoomCategory roomCategory){
        if (roomCategory == null)
            return null;
        RoomCategoryDTO dto = new RoomCategoryDTO();
        dto.setRoomCategoryCode(roomCategory.getRoomCategoryCode());
        dto.setRoomCategoryName(roomCategory.getRoomCategoryName());
        return dto;
    }
}
