package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.entity.Service;

public interface ServiceRepository extends JpaRepository<Service, Integer> {

}
