package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.example.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, String>,
    JpaSpecificationExecutor<Customer> {

  Boolean existsByCmnd(String cmnd);

  Boolean existsByPhoneNumber(String phoneNumber);

  Boolean existsByCustomerId(String customerId);

  Optional<Customer> findByCmnd(String cmmnd);

  List<Customer> findByCmndOrNameLike(String cmnd, String name);
}
