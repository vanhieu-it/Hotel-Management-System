package org.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "CT_PHIEUTHUE", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"ID_PHIEUTHUE", "ID_PHONG"})})
public class RentalDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private int ID;

  @Column(name = "NGAYNHANPHONG")
  private Date checkinDate = new Date();

  @Column(name = "NGAYTRAPHONG")
  private Date checkoutDate;

  @Column(name = "TRANGTHAITHANHTOAN")
  private boolean status;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ID_PHIEUTHUE", nullable = false)
  private Rent rent;

  @Column(name = "GIA")
  private Long price;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ID_PHONG", nullable = false)
  private Room room;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "SOHOADON", nullable = false)
  private Bill bill;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "rentalDetail")
  private List<Usage> usages = new ArrayList<>();

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "CT_KHACHTHUE", joinColumns = {@JoinColumn(name = "ID_CTPT")},
      inverseJoinColumns = {@JoinColumn(name = "MAKH")})
  private Set<Customer> customers = new HashSet<>();
}