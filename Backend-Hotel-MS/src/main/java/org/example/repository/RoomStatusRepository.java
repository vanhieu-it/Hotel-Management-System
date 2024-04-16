package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.entity.RoomStatus;

import java.util.Optional;

public interface RoomStatusRepository extends JpaRepository<RoomStatus, Integer> {

  Optional<RoomStatus> findByRoomStatusName(String roomStatusName);

}
