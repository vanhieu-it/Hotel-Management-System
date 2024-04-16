package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.key.BookingCardDetailId;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@IdClass(BookingCardDetailId.class)
@Table(name = "CT_PHIEUDAT")
public class BookingCardDetail {

  @Id
  @ManyToOne
  @JoinColumn(name = "ID_HANG", referencedColumnName = "ID")
  private RoomClass roomClass;

  @Id
  @ManyToOne
  @JoinColumn(name = "ID_PHIEUDAT", referencedColumnName = "ID")
  private BookingCard bookingCard;

  @Column(name = "SOLUONG")
  private Integer quantity;

  @Column(name = "GIA")
  private Long price;


}
