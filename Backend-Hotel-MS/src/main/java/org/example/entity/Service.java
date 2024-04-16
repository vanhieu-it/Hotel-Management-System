package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "DICHVU")
public class Service {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private int ID;

  @Column(name = "TEN", nullable = false)
  private String name;

  @Column(name = "MOTA")
  private String description;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "service")
  private List<Usage> usages = new ArrayList<>();

}
