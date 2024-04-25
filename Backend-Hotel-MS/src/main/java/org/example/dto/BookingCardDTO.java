package org.example.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.entity.BookingCard;
import org.example.entity.ReservationStatus;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingCardDTO {

  private Integer id;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
  private Date bookingDate;
  @Temporal(TemporalType.DATE)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
  private Date receivingDate;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
  private Date backingDate;
  @Min(value = 0, message = "Deposit should not be less than 0")
  private Long deposit;
  private ReservationStatus status;
  private String customerName;
  private String clientId;
  private Integer quantityOfBookedDays;
  private String customerId;
  private boolean lateCheckIn;
  private List<BookingCardDetailDTO> bookingCardDetailDTOS = new ArrayList<>();

  public static BookingCardDTO toDTO(BookingCard bc) {
    if (bc == null) {
      return null;
    }
    BookingCardDTO dto = new BookingCardDTO();
    dto.setBookingDate(bc.getBookingAtDate());
    dto.setStatus(bc.getStatus());
    dto.setBackingDate(bc.getBackingAtDate());
    dto.setDeposit(bc.getDeposit());
    dto.setId(bc.getId());
    dto.setClientId(bc.getCustomer().getClientId());
    dto.setReceivingDate(bc.getReceivingAtDate());
    dto.setLateCheckIn(bc.isLateCheckIn());
//        dto.setBookingCardDetailDTOS(BookingCardDetailDTO.toDTO(bc.getBookingCardDetails()));
    dto.setCustomerName(bc.getCustomer().getName() + " - " + bc.getCustomer().getCmnd());
    return dto;
  }

  public static BookingCard toEntity(BookingCardDTO dto) {
    if (dto == null) {
      return null;
    }
    BookingCard bookingCard = new BookingCard();
    bookingCard.setBookingAtDate(new Date());
    bookingCard.setStatus(ReservationStatus.CONFIRMED);
    bookingCard.setReceivingAtDate(dto.getReceivingDate());
    bookingCard.setBackingAtDate(dto.getBackingDate());
    bookingCard.setDeposit(dto.getDeposit());
    return bookingCard;
  }
}
