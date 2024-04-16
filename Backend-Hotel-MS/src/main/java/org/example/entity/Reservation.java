package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "PHIEUDAT")
public class Reservation {

  @Id
  @Column(name = "ID")
  private int ID;

  @Column(name = "NGAYDAT")
  private Date createdDate = new Date();

  @Column(name = "NGAYNHANPHONG")
  private Date check_inDate;

  @Column(name = "NGAYTRAPHONG")
  private Date check_outDate;

  @Column(name = "SOTIENDATCOC")
  private long deposit;

  @Enumerated(EnumType.STRING)
  @NonNull
  @Column(name = "TRANGTHAI")
  private ReservationStatus status = ReservationStatus.UNCONFIRMED;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CMND", nullable = false)
  private Customer customer;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ID_UUDAI")
  private Promotion promotion;
}
