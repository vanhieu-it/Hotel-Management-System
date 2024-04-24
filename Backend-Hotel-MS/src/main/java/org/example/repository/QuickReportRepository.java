package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.example.entity.QuickReport;

import java.util.List;

public interface QuickReportRepository extends JpaRepository<QuickReport, String> {
//    @Query(value = "SELECT (SELECT TENHANG FROM HANG WHERE ID = rs.ID_HANG) roomClassName, " +
//            "SUM(rs.SOLUONG) quantity FROM (SELECT * FROM (SELECT ID FROM PHIEUDAT WHERE " +
//            "NGAYNHANPHONG = CAST(GETDATE() AS DATE) AND TRANGTHAI = 0) pd INNER JOIN CT_PHIEUDAT ct " +
//            "ON pd.ID = ct.ID_PHIEUDAT) rs GROUP BY rs.ID_HANG", nativeQuery = true)
    @Query(value = "SELECT (SELECT TENHANG FROM HANG WHERE ID = rs.ID_HANG) roomClassName, SUM(rs.SOLUONG) quantity, (SELECT COUNT(1) totalQuantity FROM PHONG p WHERE p.ID_HANG = rs.ID_HANG AND p.ID_TRANGTHAI != :state GROUP BY p.ID_HANG) - ISNULL((SELECT TOP 1 rows FROM (SELECT SUM(1) OVER (ORDER BY a.maphong DESC) rows FROM (SELECT p.MAPHONG FROM PHONG p WHERE p.ID_HANG = rs.ID_HANG and p.ID_TRANGTHAI != :state) a INNER JOIN (SELECT ctpt.ID_PHONG FROM CT_PHIEUTHUE ctpt WHERE ctpt.TRANGTHAITHANHTOAN = 0) b ON a.MAPHONG = b.ID_PHONG) g ORDER BY g.rows DESC), 0) available FROM (SELECT ct.ID_HANG, ct.SOLUONG FROM (SELECT ID FROM PHIEUDAT WHERE NGAYNHANPHONG = CAST(GETDATE() AS DATE) AND TRANGTHAI = 0) pd INNER JOIN CT_PHIEUDAT ct ON pd.ID = ct.ID_PHIEUDAT) rs GROUP BY rs.ID_HANG", nativeQuery = true)
    List<QuickReport> getQuickReport(int state);
}
