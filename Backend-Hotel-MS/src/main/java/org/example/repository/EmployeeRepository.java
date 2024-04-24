package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    List<Employee> findByDepartmentID(String departmentID);

    boolean existsByDepartment_ID(String id);

    boolean existsByPhoneNumber(String phoneNumber);

    boolean existsByName(String name);

    boolean existsByPhoneNumberAndIDNot(String phoneNumber, String id);

    boolean existsByNameAndIDNot(String name, String id);
}
