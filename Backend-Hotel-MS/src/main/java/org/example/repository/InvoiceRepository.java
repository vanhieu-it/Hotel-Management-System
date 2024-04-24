package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.example.entity.Invoice;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, String> {
    @Query(value = "select h.TENHANG roomClassName, count(TENHANG) quantity from (select (select p.ID_HANG from PHONG p where p.MAPHONG = ct.ID_PHONG) as id_hang from CT_PHIEUTHUE ct where ct.SOHOADON = :billNumber) as ct inner join (select h1.ID, h1.TENHANG from HANG h1) h on ct.id_hang = h.ID group by h.TENHANG", nativeQuery = true)
    List<Invoice> findByBill(@Param("billNumber") String billNumber);
}
