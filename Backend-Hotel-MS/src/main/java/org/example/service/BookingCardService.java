package org.example.service;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;
import org.example.dto.BookingCardDTO;
import org.example.entity.Employee;
import org.example.entity.ReservationStatus;
import org.example.request.BookingCardDetailDto;
import org.example.request.CreateBookingCardRequest;
import org.example.request.UpdateBookingCardRequest;
import org.example.request.UpdateDepositRequest;
import org.example.response.GetBookingCardDetailsResponse;
import org.example.response.GetBookingCardResponse;

import java.util.Date;
import java.util.List;

public interface BookingCardService {

  List<BookingCardDTO> showByCustomerNameAndReceiveDate(String name, Date receiveDate);

  List<BookingCardDTO> showByCustomerNameAndReceiveDateWithFilter(String name, Date receiveDate, ReservationStatus status);

  BookingCardDTO showById(int id);

  void updateBookingCard(String customerId, UpdateBookingCardRequest updateBookingCardRequest);

  List<BookingCardDTO> showByBookingDate(Date bookingDate);

  List<BookingCardDTO> showByReceiveDate(Date startDate, Date endDate);

  void createBookingCard(CreateBookingCardRequest createBookingCardRequest,
      String customerId);

  void updateDeposit(String customerId, UpdateDepositRequest updateDepositRequest);

  void createBookingDetail(BookingCardDetailDto bookingCardDetailDto, String customerId);

  void confirmBookingCard(String customerId);

  void cancelBookingCard(Employee employee,Integer bookingId, Long money);

  void deleteBookingCard(Integer roomClassId,
      String customerId);

  GetBookingCardResponse getTheLastBookingCardByCustomerId(String customerId);

  BookingCardDTO createBookingCard(BookingCardDTO bookingCardDTO);

  BookingCardDTO showByRoom(String roomCode);

  BookingCardDTO update(BookingCardDTO dto);

  BookingCardDTO markLateCheckIn(Integer id);

  void bookingByImportingExcel(MultipartFile file);

  Page<GetBookingCardResponse> getBookingCardByCustomer(int pageNum, int pageSize, String sort,
      String customerId);

  Page<GetBookingCardDetailsResponse> getBookingCardDetailByBookingCardId(int pageNum, int pageSize,
      String sort,
      Integer bookingCardId);


}