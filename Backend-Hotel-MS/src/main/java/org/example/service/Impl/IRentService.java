package org.example.service.Impl;

import org.example.dto.*;

import java.util.List;

public interface IRentService extends IGeneralService<RentDTO, Integer> {

    RentDTO createRentWithNoReservation(CreateRentDTO dto, String employeeId);

    RentDTO createRentWithReservation(CreateRentDTO dto, String employeeId);

    List<RentDTO> showByEmployee(String employeeID);

    CalculatorDTO calculator(PayRentDTO dto);

    BillDTO pay(BillDTO billDTO, String employeeId);

    List<RentDTO> showByCustomer(String value);
}
