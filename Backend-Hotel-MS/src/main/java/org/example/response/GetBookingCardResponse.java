package org.example.response;

import lombok.Data;
import org.example.entity.ReservationStatus;

import java.util.Date;
import java.util.List;

@Data
public class GetBookingCardResponse {

  private Integer bookingCardId;
  private String email;
  private String name;
  private String phoneNumber;
  private Date bookingAtDate;
  private Date backingAtDate;
  private Date receivingAtDate;
  private Integer quantityOfDates;
  private Long deposit;
  private ReservationStatus status;
  private List<GetBookingCardDetailsResponse> bookingDetails;
  private Long total;


}
