package org.example.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculatorDTO {
    private long totalRent;
    private long totalDiscount;
    private long totalOtherDiscount;
    private long totalService;
}
