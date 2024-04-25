package org.example.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Report {
    private int discountPercent;
    private List<InvoiceDTO> invoices;
    private List<InvoiceService> invoiceServices;
}
