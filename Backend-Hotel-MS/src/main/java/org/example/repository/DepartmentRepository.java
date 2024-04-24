package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.example.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, String> {
    Boolean existsByName(String name);
    Boolean existsByNameAndIDNot(String name, String id);
    @Modifying
    @Query(value = "UPDATE PHONGBAN SET TENPHONGBAN = :newName, MAPB = :newId WHERE MAPB = :id", nativeQuery = true)
    void update(String id, String newName, String newId);
}
