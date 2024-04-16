package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "PHONG")
public class Room {

  @Id
  @GeneratedValue(generator = "generate")
  @Column(name = "MAPHONG")
  private String roomCode;

  @Column(name = "MOTA")
  private String description;

  @ManyToOne
  @JoinColumn(name = "ID_TRANGTHAI", referencedColumnName = "ID")
  private RoomStatus status;

  @ManyToOne
  @JoinColumn(name = "ID_HANG", referencedColumnName = "ID")
  private RoomClass roomClass;


  @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST,
      CascadeType.REFRESH},
      mappedBy = "room")
  private List<RentalDetail> rentalDetails = new ArrayList<>();


}
