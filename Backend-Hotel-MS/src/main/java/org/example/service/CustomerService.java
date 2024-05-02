package org.example.service;

import org.springframework.data.domain.Page;
import org.example.dto.CustomerDTO;
import org.example.request.CreateCustomerRequest;
import org.example.request.UpdateCustomerRequest;
import org.example.response.GetCustomerResponse;
import org.example.specification.customer.CustomerCriteria;

import java.util.List;

public interface CustomerService {

    void createCustomer(CreateCustomerRequest createCustomerRequest);

    void updateCustomer(UpdateCustomerRequest updateCustomerRequest, String customerId);

    GetCustomerResponse getCustomerById(String customerId);

    Page<GetCustomerResponse> getCustomers(int pageNum, int pageSize, String sort,
                                           CustomerCriteria customerCriteria);

    List<GetCustomerResponse> showByCmndOrFullName(String keySearch);

    CustomerDTO create(CustomerDTO dto);

    void delete(String customerId);

    CustomerDTO update(CustomerDTO dto);
}
