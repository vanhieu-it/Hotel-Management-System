package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.example.entity.UsageReport;

import java.util.List;

public interface UsageReportRepository extends JpaRepository<UsageReport, Integer> {
    @Query(value = "select * from ( select cast(sd.NGAY as date) date, " +
            "(select pt.ID_PHONG from CT_PHIEUTHUE pt where pt.ID = sd.ID_CTPT) as roomCode, " +
            "(select dv.TEN from DICHVU dv where dv.ID = sd.ID_DICHVU) service, " +
            "sum(sd.SOLUONG) as quantity, sd.DONGIA as price, NEWID() id from SUDUNG sd where sd.SOHOADON = :billId " +
            "group by cast(sd.NGAY as date), sd.ID_CTPT, sd.ID_DICHVU , sd.DONGIA ) r order by r.date, r.roomCode",
            nativeQuery = true)
    List<UsageReport> findByBill(String billId);
}
