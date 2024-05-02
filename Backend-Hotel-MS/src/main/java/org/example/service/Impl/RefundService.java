package org.example.service.Impl;

import org.springframework.data.domain.Page;
import org.example.entity.Employee;
import org.example.response.GetRefundResponse;

import java.util.Date;

public interface RefundService {

  Page<GetRefundResponse> getRefunds(int pageNum, int pageSize,
      String sort, Date date);

  GetRefundResponse getRefundById(Integer id);

  void completeRefund(Integer refundId, Employee employee);

}
