
package org.example.service.Impl;

import org.example.dto.BillDTO;

import java.util.List;

public interface IBillService extends IGeneralService<BillDTO, String> {

  List<BillDTO> showByRent(Integer value);
}