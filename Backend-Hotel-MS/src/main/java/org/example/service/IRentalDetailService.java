package org.example.service;

import org.example.dto.CustomerDTO;
import org.example.dto.RentalDetailDTO;

import java.util.List;

public interface IRentalDetailService extends IGeneralService<RentalDetailDTO, Integer> {

    List<RentalDetailDTO> showByRentID(int rentID);

    List<CustomerDTO> showCustomerByID(int ID);

    RentalDetailDTO showByRoomCode(String roomCode);

    RentalDetailDTO addCustomer(CustomerDTO dto, Integer rentalDetailId);

    RentalDetailDTO removeCustomer(String customerId, Integer rentalDetailId);
}