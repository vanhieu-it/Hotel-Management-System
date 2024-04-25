package org.example.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.example.entity.Customer;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class CustomerDTO {

  private String customerId;
  @Length(max = 15, message = "max length 15 characters.")
  private String cmnd = "";
  @Length(min = 1, max = 30, message = "length between 1-30 characters.")
  private String name = "";
  @Length(max = 15, message = "max length 15 characters.")
  private String phoneNumber = "";
  @Length(max = 10, message = "max length 10 characters.")
  private String taxCode = "";
  private String clientId;

  //  private User user;
  public static CustomerDTO toDTO(Customer customer) {
    if (customer == null) {
      return null;
    }
    CustomerDTO dto = new CustomerDTO();
    dto.setCustomerId(customer.getCustomerId());
    dto.setCmnd(customer.getCmnd());
    dto.setName(customer.getName());
    dto.setPhoneNumber(customer.getPhoneNumber());
    dto.setTaxCode(customer.getTaxCode());
    return dto;
  }

  public static Set<CustomerDTO> toDTO(Set<Customer> customers) {
    if (customers == null) {
      return null;
    }
    if (customers.size() == 0) {
      return new HashSet<>();
    }
    return customers.stream().map(CustomerDTO::toDTO).collect(Collectors.toSet());
  }

  public static Customer toEntity(CustomerDTO dto) {
    if (dto == null) {
      return null;
    }
    Customer customer = new Customer();
    customer.setCustomerId(dto.getCustomerId());
    customer.setClientId(dto.clientId);
    customer.setCmnd(dto.getCmnd());
    customer.setName(dto.getName());
    customer.setPhoneNumber(dto.getPhoneNumber());
    customer.setTaxCode(dto.getTaxCode());
    return customer;
  }
}