package org.example.service;

import org.example.dto.ServiceDTO;

public interface IServiceService extends IGeneralService<ServiceDTO, Integer> {

  void updatePrice(long price, int serviceID);
}
