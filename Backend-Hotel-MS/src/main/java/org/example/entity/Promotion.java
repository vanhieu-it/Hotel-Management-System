package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "KHUYENMAI")
public class Promotion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Integer id;

  @Column(name = "TEN")
  private String promotionName;

  @Column(name = "NGAYBATDAU")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date startAtDate;

  @Column(name = "NGAYKETTHUC")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date endAtDate;

  @OneToMany(mappedBy = "promotion", cascade = CascadeType.ALL)
  private List<PromotionDetail> promotionDetails = new ArrayList<>();

  public float getPromotionValueByRoomClassId(Integer roomClassId) {

    float value =0 ;
    if (this.promotionDetails.size() != 0) {
      for (PromotionDetail promotionDetail : this.promotionDetails
      ) {
        if (promotionDetail.getRoomClass().getId().equals(roomClassId)) {
          value = promotionDetail.getValue();
        }
      }
    }
    return value;

  }

}
