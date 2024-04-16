package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "HOADON")
public class Bill {

  @Id
  @GeneratedValue(generator = "generate")
  @Column(name = "SOHOADON")
  private String ID;

  @Column(name = "NGAY", nullable = false)
  private Date date = new Date();

  @Column(name = "MASOTHUE")
  private String taxCode;

  @Column(name = "HOTENNGUOITHANHTOAN", nullable = false)
  private String payerFullName;

  @Column(name = "SOTIEN", nullable = false)
  private long paymentAmount;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ID_PHIEUTHUE", nullable = false)
  private Rent rent;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ID_NHANVIEN", nullable = false)
  private Employee employee;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "bill")
  private List<RentalDetail> rentalDetails = new ArrayList<>();

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "bill")
  private List<Usage> uses = new ArrayList<>();
}