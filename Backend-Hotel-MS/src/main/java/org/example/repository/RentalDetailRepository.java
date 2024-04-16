package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.example.entity.RentalDetail;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface RentalDetailRepository extends JpaRepository<RentalDetail, Integer> {

  List<RentalDetail> findByRent_ID(int rentID);

  int countByRoom_RoomClass_IdAndStatus(int roomClassId, boolean status);

  @Query(value = countByRoomBelongAvailableRent, nativeQuery = true)
  int countByRoomBelongAvailableRent(@Param("roomClassId") int roomClassId);


  @Query(value =
      "FROM RentalDetail rd WHERE rd.status = :status AND rd.room.roomCode = :roomCode AND " +
          "rd.room.status.roomStatusName NOT LIKE :roomState")
  List<RentalDetail> findByStatusAndRoomCodeAndRoomState(@Param("status") boolean status,
      @Param("roomCode") String roomCode,
      @Param("roomState") String roomState);

  Optional<RentalDetail> findByStatusAndRoom_RoomCode(boolean status, String roomCode);

  boolean existsByStatusAndRoom_RoomCode(boolean status, String roomCode);

  Optional<RentalDetail> findByIDAndRent_ID(Integer rentlDetailId, Integer rentId);

  @Query(value = "select iif(exists(select kt.ID_CTPT from (select kt1.ID_CTPT from CT_KHACHTHUE kt1 where kt1.makh = :maKH) kt inner join (select pt1.ID from CT_PHIEUTHUE pt1 where pt1.TRANGTHAITHANHTOAN = 0) pt on kt.ID_CTPT = pt.id), cast(1 as bit), cast(0 as bit)) as s", nativeQuery = true)
  boolean existsCustomerInAnotherRoom(@Param("maKH") String maKH);

  List<RentalDetail> findAllByRentBookingCardId(Integer bookingCardId);

  String countByRoomBelongAvailableRent = "select 0 + COUNT(1)\n" +
      "from (select cpt.ID_PHIEUTHUE\n" +
      "\t  from (select cpt1.ID_PHONG, cpt1.ID_PHIEUTHUE from CT_PHIEUTHUE cpt1 where cpt1.TRANGTHAITHANHTOAN = 0) cpt\n"
      +
      "\t  inner join (select p1.MAPHONG from PHONG p1 where p1.ID_HANG = :roomClassId) p\n" +
      "\t  on p.MAPHONG = cpt.ID_PHONG) a\n" +
      "inner join (select pt.ID\n" +
      "\t\t\tfrom (select pd1.ID from PHIEUDAT pd1 where pd1.NGAYTRAPHONG > cast(getdate() as date)) pd\n"
      +
      "\t\t\tinner join PHIEUTHUE pt\n" +
      "\t\t\ton pt.ID_PHIEUDAT = pd.ID) b\n" +
      "on a.ID_PHIEUTHUE = b.ID";

  boolean existsByRoom_RoomCode(String roomCode);


  List<RentalDetail> findAllByCheckoutDateAfterOrCheckoutDate(Date from,
      Date checkout);
}
