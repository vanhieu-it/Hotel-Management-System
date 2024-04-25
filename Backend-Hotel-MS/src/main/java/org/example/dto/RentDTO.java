package org.example.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.Rent;

import java.util.List;

@Data
@NoArgsConstructor
public class RentDTO {

  private int ID;
  private long totalRent;
  private long discount;
  private long totalBill;
  private int bookingCardId;
  private BookingCardDTO bookingCardDTO;
  private List<RentalDetailDTO> rentalDetailDTOS;
  private List<UsageDTO> usageDTOS;
  private String employeeID;
  private boolean stillOpen;

  public static RentDTO toDTO(Rent rent) {
      if (rent == null) {
          return null;
      }
    RentDTO dto = new RentDTO();
    dto.setDiscount(rent.getDiscount());
    dto.setBookingCardId(rent.getBookingCard().getId());
    dto.setID(rent.getID());
    dto.setEmployeeID(rent.getEmployee().getID());
    dto.setDiscount(rent.getDiscount());
    dto.setTotalRent(rent.getTotalRent());
    return dto;
  }
}
