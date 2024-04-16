
package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.example.entity.Rent;

import java.util.List;

public interface RentRepository extends JpaRepository<Rent, Integer> {

    List<Rent> findByEmployeeID(String employeeID);

    @Query(value = "FROM Rent r WHERE r.bookingCard.customer.customerId = :customerId ORDER BY r.ID DESC")
    List<Rent> findByCustomer(@Param("customerId") String value);

    boolean existsByEmployee_ID(String employeeID);
}
