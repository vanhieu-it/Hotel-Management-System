package org.example.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.example.entity.Employee;

@Data
@NoArgsConstructor
public class EmployeeDTO {
    private String ID;
    @Length(min = 1, max = 50)
    private String name;
    @Length(min = 10, max = 15)
    private String phoneNumber;
    @Length(min = 1, max = 50)
    private String address;
    private String departmentID;
    private DepartmentDTO department;

    public static EmployeeDTO toDTO(Employee employee) {
        if (employee == null)
            return null;
        EmployeeDTO dto = new EmployeeDTO();
        dto.setAddress(employee.getAddress());
        dto.setID(employee.getID());
        dto.setName(employee.getName());
        dto.setPhoneNumber(employee.getPhoneNumber());
        dto.setDepartment(DepartmentDTO.toDTO(employee.getDepartment()));
        return dto;
    }
}
