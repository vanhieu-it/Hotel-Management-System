package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.example.entity.key.RoomClassPriceId;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity(name = "GIAHANG")
@IdClass(RoomClassPriceId.class)
public class RoomClassPrice {

  @Id
  @ManyToOne
  @JoinColumn(name = "ID_HANG", referencedColumnName = "ID")
  private RoomClass roomClass;

  @Id
  @Column(name = "NGAY")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date date;

  @Column(name = "GIA")
  private Long price;

}
