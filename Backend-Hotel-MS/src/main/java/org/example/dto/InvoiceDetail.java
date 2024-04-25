package org.example.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvoiceDetail {
    private String roomClassName;
    private long price;
    private int quantity;
    private float discountPercent;
}
