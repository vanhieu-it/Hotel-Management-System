package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "PHIEUDAT")
public class BookingCard {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Integer id;

  @Column(name = "NGAYDAT")
//  @Temporal(TemporalType.DATE)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date bookingAtDate;

  @Column(name = "NGAYNHANPHONG")
//  @Temporal(TemporalType.DATE)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date receivingAtDate;

  @Column(name = "NGAYTRAPHONG")
//  @Temporal(TemporalType.DATE)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date backingAtDate;

  @Column(name = "SOTIENDATCOC")
  private Long deposit;

  @Column(name = "TRANGTHAI")
  private ReservationStatus status;

  @Column(name = "NHANPHONGTRE")
  private boolean lateCheckIn;

  @ManyToOne
  @JoinColumn(name = "MAKH", referencedColumnName = "MAKH")
  private Customer customer;

  @OneToMany(mappedBy = "bookingCard", cascade = CascadeType.ALL)
  private List<BookingCardDetail> bookingCardDetails = new ArrayList<>();

  @OneToMany(mappedBy = "bookingCard", cascade = CascadeType.ALL)
  private List<Refunds> refunds = new ArrayList<>();

}
