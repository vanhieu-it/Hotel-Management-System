package org.example.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.example.entity.ReservationStatus;

import java.util.Date;

@Data
@NoArgsConstructor
public class ReservationDTO {

  private int ID;
  private Date createdDate;
  private Date check_inDate;
  private Date check_outDate;
  private long deposit;
  @NonNull
  private ReservationStatus status;
  private String cmnd;
  private int promotionID;
}
