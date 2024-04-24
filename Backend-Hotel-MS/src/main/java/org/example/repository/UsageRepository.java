package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.example.entity.Usage;
import org.example.entity.key.UsageID;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UsageRepository extends JpaRepository<Usage, UsageID> {

  Optional<Usage> findByServiceIDAndRentalDetailIDAndDate(int serviceID, int rentalDetailID,
      Date date);

  @Query(value = "select * from sudung sd where sd.id_ctpt = :rentalDetailID and sd.id_dichvu = :serviceID and ngay = :date", nativeQuery = true)
  Optional<Usage> findByServiceIDAndRentalDetailIDAndDate(int serviceID, int rentalDetailID,
      String date);

  @Modifying
  @Query(value = "delete sudung where id_ctpt = :rentalDetailID and id_dichvu = :serviceID and ngay = :date", nativeQuery = true)
  void delete(@Param("serviceID") int serviceID, @Param("rentalDetailID") int rentalDetailID,
      @Param("date") String date);

  List<Usage> findByRentalDetailID(int rentalDetailID);

  List<Usage> findByBill_ID(int billID);

  @Query(value = "select * from SUDUNG sd where sd.SOHOADON = :billId and CAST(sd.NGAY as date) = :date",
      nativeQuery = true)
  List<Usage> findByBillAndDate(@Param("billId") String billId, @Param("date") String date);

  @Modifying(clearAutomatically = true, flushAutomatically = true)
  @Query(value = "UPDATE SUDUNG SET TRANGTHAITHANHTOAN = 1, SOHOADON = :billId " +
      "WHERE NGAY = :date AND ID_DICHVU = :serviceId AND ID_CTPT = :rentalId", nativeQuery = true)
  void pay(@Param("billId") String billId, @Param("date") String date,
      @Param("rentalId") int rentalId,
      @Param("serviceId") int serviceId);

  @Query(value = "Select * from SUDUNG sd where YEAR(sd.NGAY)=:year AND MONTH(sd.NGAY)=:month AND DAY(sd.NGAY)=:day", nativeQuery = true)
  List<Usage> findAllByDate(@Param("year") int year, @Param("month") int month,
      @Param("day") int day);

  @Query(value = "Select * from SUDUNG sd where YEAR(sd.NGAY)=:year", nativeQuery = true)
  List<Usage> findAllByYear(@Param("year") int year);

  boolean existsByServiceID(Integer integer);
}