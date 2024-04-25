package org.example.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.example.entity.Bill;

import java.util.Date;

@Getter
@Setter
public class BillDTO {

  private String ID;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss dd/MM/yyyy")
  private Date date;
  @Length(max = 10, message = "maximum length is 10.")
  private String taxCode;
  @Length(min = 1, max = 50, message = "payer name is empty or too loong(50).")
  private String payerFullName;
  private long paymentAmount;
  private int rentID;
  private PayRentDTO payRentDTO;
  private EmployeeDTO employeeDTO;

  public static Bill toEntity(BillDTO dto) {
    if (dto == null) {
      return null;
    }
    Bill bill = new Bill();
    bill.setDate(new Date());
    bill.setPayerFullName(dto.getPayerFullName());
    bill.setTaxCode(dto.getTaxCode());
    return bill;
  }

  public static BillDTO toDTO(Bill bill) {
    if (bill == null) {
      return null;
    }
    BillDTO dto = new BillDTO();
    dto.setDate(bill.getDate());
    dto.setPayerFullName(bill.getPayerFullName());
    dto.setID(bill.getID());
    dto.setTaxCode(bill.getTaxCode());
    dto.setPaymentAmount(bill.getPaymentAmount());
    dto.setRentID(bill.getRent().getID());
    dto.setEmployeeDTO(EmployeeDTO.toDTO(bill.getEmployee()));
    return dto;
  }
}