package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.key.PromotionDetailId;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Table(name = "CT_KHUYENMAI")
@Entity
@IdClass(PromotionDetailId.class)
public class PromotionDetail {

  @Id
  @ManyToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "ID_KHUYENMAI", referencedColumnName = "ID")
  private Promotion promotion;

  @Id
  @ManyToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "ID_HANG", referencedColumnName = "ID")
  private RoomClass roomClass;

  @Column(name = "GIATRI")
  private float value;


}
