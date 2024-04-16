package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "PHONGBAN")
public class Department {

  @Id
  @GeneratedValue(generator = "generate")
  @Column(name = "MAPB")
  private String ID;

  @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST,
      CascadeType.REFRESH},
      mappedBy = "department")
  private List<Employee> employees = new ArrayList<>();

  @Column(name = "TENPHONGBAN")
  private String name;

}
