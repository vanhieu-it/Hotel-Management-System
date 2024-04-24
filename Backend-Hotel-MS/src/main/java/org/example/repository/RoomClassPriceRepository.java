package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.example.entity.RoomClassPrice;
import org.example.entity.key.RoomClassPriceId;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface RoomClassPriceRepository extends JpaRepository<RoomClassPrice, RoomClassPriceId> {

  Boolean existsByRoomClassRoomClassName(String roomClassName);

  @Query(value = "SELECT TOP 1 * FROM GIAHANG gd WHERE gd.ID_HANG = :id AND gd.NGAY <= CAST(GETDATE() AS DATE) ORDER BY gd.NGAY DESC", nativeQuery = true)
  Optional<RoomClassPrice> findByRoomClass_Id(@Param("id") Integer roomClassId);

  @Query(value = "SELECT TOP 1 * FROM GIAHANG gd WHERE gd.ID_HANG = :id AND gd.NGAY <= :date ORDER BY gd.NGAY DESC", nativeQuery = true)
  Optional<RoomClassPrice> findByRoomClassIdAndDate(@Param("id") Integer roomClassId,
      @Param("date") String date);

  @Query(value = "SELECT TOP 1 g.GIA, g.ID_HANG, g.NGAY FROM (SELECT * FROM GIAHANG gd WHERE gd.NGAY <= CAST(GETDATE() AS DATE)) g INNER JOIN (SELECT h1.ID FROM HANG h1 WHERE h1.TENHANG = :name) h1 ON g.ID_HANG = h1.ID ORDER BY g.NGAY DESC", nativeQuery = true)
  RoomClassPrice findByRoomClassName(@Param("name") String roomClassName);

  List<RoomClassPrice> findRoomClassPriceByRoomClass_IdOrderByDateDesc(Integer id);

  @Modifying
  @Query(value = "DELETE GIAHANG WHERE NGAY = :date AND ID_HANG = :id", nativeQuery = true)
  void delete(Date date, Integer id);
}
