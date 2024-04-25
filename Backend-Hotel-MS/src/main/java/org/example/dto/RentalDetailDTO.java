package org.example.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.RentalDetail;

import javax.validation.constraints.NotBlank;
import java.util.*;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class RentalDetailDTO {

  private int ID;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm dd/MM/yyyy")
  private Date checkinDate;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm dd/MM/yyyy")
  private Date checkoutDate;
  private boolean status;
  private int rentID;
  private int billID;
  @NotBlank(message = "cannot-be-empty")
  private String roomCode;
  private Set<CustomerDTO> customerDTOS = new HashSet<>();
  private List<UsageDTO> usageDTOS = new ArrayList<>();

  public static RentalDetailDTO toDTO(RentalDetail detail) {
    if (detail == null) {
      return null;
    }
    RentalDetailDTO dto = new RentalDetailDTO();
    dto.setCheckinDate(detail.getCheckinDate());
    dto.setCheckoutDate(detail.getCheckoutDate());
    dto.setStatus(detail.isStatus());
    dto.setID(detail.getID());
    dto.setRoomCode(detail.getRoom().getRoomCode());
    dto.setRentID(detail.getRent().getID());
    if (detail.getBill() != null) {
      dto.setBillID(dto.getBillID());
    }
    return dto;
  }

  public static List<RentalDetailDTO> toDTO(List<RentalDetail> details) {
    if (details == null) {
      return null;
    }
    return details.stream().map(RentalDetailDTO::toDTO).collect(Collectors.toList());
  }
}