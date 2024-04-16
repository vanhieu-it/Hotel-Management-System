package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "LOAIPHONG")
public class RoomCategory {

  @Id
  @Column(name = "MALP")
  private String roomCategoryCode;

  @Column(name = "TENLOAIPHONG")
  private String roomCategoryName;

}
