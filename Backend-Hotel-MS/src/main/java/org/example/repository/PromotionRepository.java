package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.example.entity.Promotion;

import java.util.Date;
import java.util.Optional;

public interface PromotionRepository extends JpaRepository<Promotion, Integer>,
    JpaSpecificationExecutor<Promotion> {

  Boolean existsByPromotionName(String promotionName);

  @Query("select u from Promotion u where u.startAtDate <= :date and u.endAtDate>=:date")
  Optional<Promotion> findByCurrentDate(@Param("date") Date date);

  Optional<Promotion> findById(Integer id);

  @Query(value = "SELECT TOP 1 * FROM KHUYENMAI p ORDER BY p.NGAYKETTHUC DESC ", nativeQuery = true)
  Promotion findLast();

  @Query(value = "SELECT IIF(EXISTS(SELECT ID FROM KHUYENMAI WHERE ID != :id AND NGAYBATDAU <= :date AND NGAYKETTHUC >= :date), CAST(1 AS BIT), CAST(0 AS BIT))", nativeQuery = true)
  boolean betweenOtherPromotion(@Param("date") Date date, @Param("id") Integer id);
}
