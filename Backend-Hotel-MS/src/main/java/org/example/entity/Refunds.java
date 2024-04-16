package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "HOANTIEN")
public class Refunds {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Integer refundId;

  @Column(name = "TIENHOAN")
  private Long money;

  @Column(name = "NGAYHUY")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date cancelAtDate;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "MANHANVIEN", nullable = false)
  private Employee employee;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "MAPHIEUDAT", nullable = false)
  private BookingCard bookingCard;


}
