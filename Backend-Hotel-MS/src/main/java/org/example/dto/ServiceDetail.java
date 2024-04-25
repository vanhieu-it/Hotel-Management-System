package org.example.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ServiceDetail {
    private String service;
    private int quantity;
    private long price;
}
