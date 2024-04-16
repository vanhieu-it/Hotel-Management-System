package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.example.entity.Room;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, String>,
    JpaSpecificationExecutor<Room> {

  Boolean existsByRoomCode(String roomCode);

  Optional<Room> findByRoomCode(String roomCode);

  int countByRoomClass_IdAndStatus_RoomStatusNameNot(int roomClassId, String roomStatusName);

  @Query(value = "FROM Room r WHERE r.roomClass.id = :roomClassId AND" +
      " (SELECT rs.roomStatusName FROM RoomStatus rs WHERE r.status.id = rs.id) " +
      "NOT IN :roomStatuses AND" +
      " (SELECT COUNT(1) FROM RentalDetail rd WHERE rd.room.roomCode = r.roomCode AND rd.status = false ) = 0")
  List<Room> findRoomCanRent(@Param("roomClassId") int roomClassId, @Param("roomStatuses") List<String> roomStatusName);

  List<Room> findByRoomClassId(Integer roomClassId);

  boolean existsByRoomClass_Id(Integer id);

  List<Room> findAllByStatusRoomStatusNameAndRoomClassId(String status, Integer roomClassId);
}
