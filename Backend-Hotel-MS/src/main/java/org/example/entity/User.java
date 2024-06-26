package org.example.entity;

import lombok.Data;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "OTP")
    private String OTP;

    @Column(name = "HIEULUC")
    private String expiredTime;

    @ManyToOne
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MAKH", referencedColumnName = "MAKH")
    private Customer customer;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_NHANVIEN")
    private Employee employee;
}