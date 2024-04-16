package org.example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "QuickReport")
@Getter
@Setter
public class QuickReport {
    @Id
    private String roomClassName;
    private int quantity;
    private int available;
}
