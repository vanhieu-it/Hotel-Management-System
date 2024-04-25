package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.entity.RoomClass;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomClassDTO {

  private Integer id;
  private String roomClassName;
  @NotBlank(message = "can not be empty")
  private String description;
  @NotBlank(message = "can not be empty")
  private String image;
  private RoomCategoryDTO roomCategory;
  private RoomTypeDTO roomType;
  private long price;
  private int availableQuantity;
  private int quantity;
  private List<RoomDTO> roomDTOS;

  public static RoomClassDTO toDTO(RoomClass roomClass) {
    if (roomClass == null) {
      return null;
    }
    RoomClassDTO dto = new RoomClassDTO();
    dto.setId(roomClass.getId());
    dto.setRoomClassName(roomClass.getRoomClassName());
    dto.setDescription(roomClass.getDescription());
    dto.setRoomCategory(RoomCategoryDTO.toDTO(roomClass.getRoomCategory()));
    dto.setRoomType(RoomTypeDTO.toDTO(roomClass.getRoomType()));
    dto.setImage(roomClass.getImage());
    return dto;
  }

  public static RoomClass toEntity(RoomClassDTO dto) {
    if (dto == null) {
      return null;
    }
    RoomClass roomClass = new RoomClass();
    roomClass.setRoomClassName(dto.getRoomClassName());
    roomClass.setDescription(dto.getDescription());
    return roomClass;
  }
}
