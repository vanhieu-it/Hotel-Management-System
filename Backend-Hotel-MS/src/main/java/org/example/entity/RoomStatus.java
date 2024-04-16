package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TRANGTHAIPHONG")
public class RoomStatus {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Integer id;

  //  @Enumerated(EnumType.STRING)
//  @NonNull
  @Column(name = "TRANGTHAI")
  private String roomStatusName;

  @OneToMany(mappedBy = "status", cascade = CascadeType.ALL)
  private List<Room> roomList = new ArrayList<>();

}
