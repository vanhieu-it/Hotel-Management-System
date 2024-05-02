package org.example.service;

import org.example.dto.EmployeeDTO;

import java.util.List;

public interface IEmployeeService extends IGeneralService<EmployeeDTO, String> {

  List<EmployeeDTO> showByDepartment(String departmentID);
}
