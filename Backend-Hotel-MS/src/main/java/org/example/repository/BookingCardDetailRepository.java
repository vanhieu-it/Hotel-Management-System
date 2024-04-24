
package org.example.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.example.entity.BookingCardDetail;
import org.example.entity.ReservationStatus;
import org.example.entity.key.BookingCardDetailId;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface BookingCardDetailRepository extends
    JpaRepository<BookingCardDetail, BookingCardDetailId> {

  @Query(value = "FROM BookingCardDetail bcd " +
      "WHERE bcd.roomClass.id = :roomClassId " +
      " AND bcd.bookingCard.status = :status " +
      " AND ((bcd.bookingCard.receivingAtDate <= :re AND bcd.bookingCard.backingAtDate > :re) " +
      "       OR (bcd.bookingCard.receivingAtDate < :ba AND bcd.bookingCard.backingAtDate >= :ba) " +
      "       OR (bcd.bookingCard.receivingAtDate >= :re AND bcd.bookingCard.backingAtDate <= :ba))")
  List<BookingCardDetail> findByBookingCard(@Param("roomClassId") int roomClassId
      , @Param("status") ReservationStatus status, @Param("re") Date receivingDate
      , @Param("ba") Date backingDate);

  List<BookingCardDetail> findAllByBookingCardBackingAtDateAfterAndRoomClassIdAndBookingCardStatusIsNotAndBookingCardStatusIsNot(
      Date date,
      Integer roomClassId, ReservationStatus status, ReservationStatus status2);

  List<BookingCardDetail> findAllByBookingCardBackingAtDateAfterAndRoomClassIdAndBookingCardStatus(
      Date date,
      Integer roomClassId, ReservationStatus status);

  Boolean existsByBookingCardId(Integer bookingCardId);

  Optional<BookingCardDetail> findByBookingCardIdAndRoomClassId(Integer bookingCardId,
      Integer roomClassId);

  Page<BookingCardDetail> findAllByBookingCardId(Integer bookingCardId, Pageable pageable );
}