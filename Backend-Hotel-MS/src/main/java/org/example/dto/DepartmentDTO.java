package org.example.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.example.entity.Department;

@Data
@NoArgsConstructor
public class DepartmentDTO {
    private String ID;
    @Length(max = 50, min = 4, message = "length-name-in-range-4-50")
    private String name;

    public static DepartmentDTO toDTO(Department department) {
        if (department == null)
            return null;
        DepartmentDTO dto = new DepartmentDTO();
        dto.setID(department.getID());
        dto.setName(department.getName());
        return dto;
    }
}
