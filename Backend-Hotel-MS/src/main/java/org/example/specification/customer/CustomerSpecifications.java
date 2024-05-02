package org.example.specification.customer;

import org.springframework.data.jpa.domain.Specification;
import org.example.entity.Customer;

public final class CustomerSpecifications {

  public static Specification<Customer> getFilter(
      CustomerCriteria customerCriteria) {
    Specification<Customer> specification =
        Specification.where(null);
    if (customerCriteria.getLastName() != null) {
      specification = specification
          .and(lastNameContains(customerCriteria.getLastName()));
    }
    if (customerCriteria.getCmnd() != null) {
      specification = specification
          .and(belongToCMND(customerCriteria.getCmnd()));
    }
    if (customerCriteria.getPhoneNumber() != null) {
      specification = specification
          .and(belongToPhoneNumber(customerCriteria.getPhoneNumber()));
    }

    return specification;
  }


  static Specification<Customer> lastNameContains(String lastName) {
    return (customer, cq, cb) -> cb.like(customer.get("name"), lastName);
//    return (customer, cq, cb) -> cb.like(customer.get("lastName"), lastName);
  }

  static Specification<Customer> belongToPhoneNumber(String phoneNumber) {
    return (customer, cq, cb) -> cb.equal(customer.get("phoneNumber"), phoneNumber);
  }

  static Specification<Customer> belongToCMND(String cmnd) {
    return (customer, cq, cb) -> cb.equal(customer.get("cmnd"), cmnd);
  }

}

