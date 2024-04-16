package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.example.entity.PromotionDetail;
import org.example.entity.key.PromotionDetailId;

import java.util.Date;
import java.util.List;

public interface PromotionDetailRepository extends
    JpaRepository<PromotionDetail, PromotionDetailId> {

  void deleteAllByPromotionId(Integer promotionId);

  @Query(value = "FROM PromotionDetail pd WHERE pd.roomClass.id = :roomClassId" +
      " AND pd.promotion.startAtDate <= :currentDate AND pd.promotion.endAtDate >= :currentDate")
  List<PromotionDetail> findByRoomClass_IdAndStartAtDateAndEndAtDate(
      @Param("roomClassId") Integer id,
      @Param("currentDate") Date currentDate);

  @Query(value = "FROM PromotionDetail pd WHERE pd.roomClass.roomClassName = :name" +
      " AND pd.promotion.startAtDate <= :currentDate AND pd.promotion.endAtDate >= :currentDate")
  List<PromotionDetail> findByRoomClassName(@Param("name") String name,
      @Param("currentDate") Date currentDate);

  List<PromotionDetail> findAllByPromotionIdOrderByValueDesc(Integer promotionId);
}
