package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.key.ServicePriceID;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity()
@Table(name = "GIADICHVU")
@IdClass(ServicePriceID.class)
public class  ServicePrice {

  @Id
  @Column(name = "ID_DICHVU", nullable = false)
  private int serviceID;

  @Id
  @Column(name = "NGAY", nullable = false)
  private Date date = new Date();

  @Column(name = "GIA", nullable = false)
  private long price;

  @ManyToOne
  @MapsId("serviceID")
  @JoinColumn(name = "ID_DICHVU")
  private Service service;

}
