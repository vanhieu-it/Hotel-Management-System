

package org.example.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.entity.Service;

@Getter
@Setter
public class ServiceDTO {

  private int ID;
  private String name;
  private String description;
  private Long price;

  public static ServiceDTO toDTO(Service service) {
      if (service == null) {
          return null;
      }
    ServiceDTO dto = new ServiceDTO();
    dto.setDescription(service.getDescription());
    dto.setID(service.getID());
    dto.setName(service.getName());
    return dto;
  }

  public static Service toEntity(ServiceDTO dto) {
      if (dto == null) {
          return null;
      }
    Service service = new Service();
    service.setDescription(dto.description);
    service.setID(dto.getID());
    service.setName(dto.getName());
    return service;
  }
}