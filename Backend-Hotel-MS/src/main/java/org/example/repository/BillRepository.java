package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.entity.Bill;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill, String> {
    List<Bill> findByRent_IDOrderByDateDesc(Integer value);

    boolean existsByEmployee_ID(String employee_ID);
}
