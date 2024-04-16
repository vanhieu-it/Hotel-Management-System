package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "PHIEUTHUE")
public class Rent {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private int ID;

  @Column(name = "TONGTIEN")
  private long totalRent;

  @Column(name = "TONGGIAM")
  private long discount;

  @Column(name = "TRIGIAGIAM")
  private int discountPercent;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ID_PHIEUDAT", unique = true)
  private BookingCard bookingCard;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ID_NHANVIEN", nullable = false)
  private Employee employee;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "rent")
  private List<Bill> bills = new ArrayList<>();

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "rent")
  private List<RentalDetail> rentalDetails = new ArrayList<>();
}