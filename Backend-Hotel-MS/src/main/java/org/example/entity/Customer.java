package org.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "KHACHHANG")
public class Customer {

  @Id
  @GeneratedValue(generator = "generate")
  @Column(name = "MAKH")
  private String customerId;

  @Column(name = "CMND")
  private String cmnd;

  @Column(name = "TENKH")
  private String name;

  @Column(name = "SDT")
  private String phoneNumber;

  @Column(name = "MATAIKHOAN")
  private String clientId;

  @Column(name = "MASOTHUE")
  private String taxCode;

  @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
  private User user;

  @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST,
      CascadeType.REFRESH})
  @JoinTable(name = "CT_KHACHTHUE", joinColumns = {@JoinColumn(name = "MAKH")},
      inverseJoinColumns = {@JoinColumn(name = "ID_CTPT")})
  private Set<RentalDetail> rentalDetails = new HashSet<>();
}

