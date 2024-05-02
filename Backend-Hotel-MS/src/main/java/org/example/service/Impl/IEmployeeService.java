package org.example.service.Impl;

import org.example.dto.EmployeeDTO;

import java.util.List;

public interface IEmployeeService extends IGeneralService<EmployeeDTO, String> {

  List<EmployeeDTO> showByDepartment(String departmentID);
}
