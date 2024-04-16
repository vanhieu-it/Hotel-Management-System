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
@Table(name = "KIEUPHONG")
public class RoomType {

  @Id
  @Column(name = "MAKP")
  private String roomTypeCode;

  @Column(name = "TENKIEUPHONG")
  private String roomTypeName;

}
