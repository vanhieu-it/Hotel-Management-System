package org.example.service.Impl;

import org.example.dto.UsageDTO;
import org.example.entity.key.UsageID;

import java.util.List;

public interface IUsageService extends IGeneralService<UsageDTO, UsageID> {

  List<UsageDTO> findByRentalDetailID(int rentalDetailID);

  List<UsageDTO> findByBillID(int billID);

  void delete(Integer rentalDetailID, Integer serviceID, String date);
}