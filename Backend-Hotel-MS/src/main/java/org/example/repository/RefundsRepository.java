package org.example.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.example.entity.Refunds;

import java.util.Date;
import java.util.Optional;

public interface RefundsRepository extends JpaRepository<Refunds, Integer>,
    JpaSpecificationExecutor<Refunds> {

  @Query(value = "Select * from HOANTIEN ht where ht.ID=:id", nativeQuery = true)
  Optional<Refunds> findByRefundId(@Param("id") Integer id);

  Page<Refunds> findAllByCancelAtDate(Date date, Pageable pageable);
}
