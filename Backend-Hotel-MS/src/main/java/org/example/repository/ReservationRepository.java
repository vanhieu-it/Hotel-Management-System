package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
