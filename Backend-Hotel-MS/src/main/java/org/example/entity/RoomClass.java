package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "HANG")
public class RoomClass {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Integer id;

  @Column(name = "TENHANG")
  private String roomClassName;

  @Column(name = "MOTA")
  private String description;

  @Column(name = "ANH")
  private String image;

  @ManyToOne
  @JoinColumn(name = "ID_LOAIPHONG", referencedColumnName = "MALP")
  private RoomCategory roomCategory;

  @ManyToOne
  @JoinColumn(name = "ID_KIEUPHONG", referencedColumnName = "MAKP")
  private RoomType roomType;

  @OneToMany(mappedBy = "roomClass", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
  private List<RoomClassPrice> prices = new ArrayList<>();

  @OneToMany(mappedBy = "roomClass", cascade = CascadeType.ALL)
  private List<PromotionDetail> promotionDetails = new ArrayList<>();

}
