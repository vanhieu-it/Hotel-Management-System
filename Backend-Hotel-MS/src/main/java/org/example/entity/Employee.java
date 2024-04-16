package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "NHANVIEN")
public class Employee {

  @Id
  @GeneratedValue(generator = "generate")
  @Column(name = "ID")
  private String ID;

  @Column(name = "TEN")
  private String name;

  @Column(name = "SDT")
  private String phoneNumber;

  @Column(name = "DIACHI")
  private String address;

  @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST,
      CascadeType.REFRESH},
      mappedBy = "employee")
  private List<Rent> rents = new ArrayList<>();

  @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST,
      CascadeType.REFRESH},
      mappedBy = "employee")
  private List<Bill> bills = new ArrayList<>();

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ID_PHONG_BAN", nullable = false)
  private Department department;

  @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
  private List<Refunds> refunds = new ArrayList<>();

}
