package org.example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@Entity(name = "UsageReport")
public class UsageReport {
    @Id
    private String id;
    private Date date;
    private String roomCode;
    private String service;
    private int quantity;
    private long price;
}
