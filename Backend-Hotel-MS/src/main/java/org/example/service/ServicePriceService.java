package org.example.service;

import org.example.dto.ServicePriceDTO;

import java.text.ParseException;
import java.util.List;

public interface ServicePriceService {
    List<ServicePriceDTO> showByService(Integer id);
    ServicePriceDTO create(ServicePriceDTO dto);
    void delete(String date, Integer serviceId) throws ParseException;
}
