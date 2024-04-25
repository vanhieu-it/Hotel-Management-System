package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.entity.RoomStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomStatusDTO {
    private Integer id;
    private String roomStatusName;

    public static RoomStatusDTO toDTO(RoomStatus roomStatus){
        if (roomStatus == null)
            return null;
        RoomStatusDTO dto = new RoomStatusDTO();
        dto.setId(roomStatus.getId());
        dto.setRoomStatusName(roomStatus.getRoomStatusName());
        return dto;
    }
}
