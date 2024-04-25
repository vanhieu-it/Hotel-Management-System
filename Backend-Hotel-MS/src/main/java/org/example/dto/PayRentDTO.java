package org.example.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PayRentDTO {
    private Integer rentId;
    private List<PayRentalDetailDTO> detailDTOS;
}
