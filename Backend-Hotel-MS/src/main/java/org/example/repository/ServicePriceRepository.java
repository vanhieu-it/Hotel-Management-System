package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.example.entity.ServicePrice;
import org.example.entity.key.ServicePriceID;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ServicePriceRepository extends JpaRepository<ServicePrice, ServicePriceID> {

  @Query(value = "SELECT TOP 1 GIA FROM GIADICHVU WHERE ID_DICHVU = :serviceID AND NGAY <= CAST(GETDATE() AS DATE) ORDER BY NGAY DESC", nativeQuery = true)
  Long getLastPrice(int serviceID);

  Optional<ServicePrice> findByServiceIDAndDate(int serviceID, Date date);

  @Query(value = "SELECT * FROM GIADICHVU WHERE ID_DICHVU = :id ORDER BY NGAY DESC", nativeQuery = true)
  List<ServicePrice> findByServiceID(@Param("id") int id);

  @Modifying
  @Query(value = "DELETE GIADICHVU WHERE NGAY = :date AND ID_DICHVU = :serviceId", nativeQuery = true)
  void delete(Date date, Integer serviceId);
}
