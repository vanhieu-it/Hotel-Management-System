package org.example.response;

import lombok.Data;

import java.util.Date;

@Data
public class GetRefundResponse {

  private Integer refundId;
  private String guestName;
  private Long money;
  private String clientId;
  private Date cancelAtDate;
  private Long deposit;
  private Integer bookingCardId;
  private String employeeName;


}
