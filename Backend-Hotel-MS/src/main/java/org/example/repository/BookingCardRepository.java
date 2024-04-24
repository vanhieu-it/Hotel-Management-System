
package org.example.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.example.entity.BookingCard;
import org.example.entity.ReservationStatus;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface BookingCardRepository extends JpaRepository<BookingCard, Integer>,
    JpaSpecificationExecutor<BookingCard> {

  List<BookingCard> findByReceivingAtDateAndCustomer_NameLikeAndStatus(Date receiveDate
      , String name, ReservationStatus status);

  List<BookingCard> findByReceivingAtDateAndCustomer_NameLike(Date receiveDate
      , String name);

  List<BookingCard> findByReceivingAtDateAndStatus(Date receiveDate, ReservationStatus status);

  List<BookingCard> findByReceivingAtDate(Date receiveDate);

  Optional<BookingCard> findByCustomerCustomerIdAndStatus(String customerId,
      ReservationStatus status);

  List<BookingCard> findAllByBackingAtDateAfter(Date date);

  boolean existsByCustomer_CustomerId(String customerId);

  Page<BookingCard> findAllByCustomerCustomerId(String customerId, Pageable pageable);
}