package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.key.UsageID;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "SUDUNG")
@IdClass(UsageID.class)
public class Usage {

  @Id
  @Column(name = "ID_CTPT", nullable = false)
  private int rentalDetailID;

  @Id
  @Column(name = "ID_DICHVU", nullable = false)
  private int serviceID;

  @Id
  @Column(name = "NGAY", nullable = false)
  private Date date = new Date();

  @Column(name = "SOLUONG", nullable = false)
  private int quantity;

  @Column(name = "DONGIA", nullable = false)
  private long price;

  @Column(name = "TRANGTHAITHANHTOAN")
  private boolean status;

  @ManyToOne
  @MapsId("serviceID")
  @JoinColumn(name = "ID_DICHVU")
  private Service service;

  @ManyToOne
  @MapsId("rentalDetailID")
  @JoinColumn(name = "ID_CTPT")
  private RentalDetail rentalDetail;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "SOHOADON", nullable = false)
  private Bill bill;
}