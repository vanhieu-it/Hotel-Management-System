

package org.example.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.entity.Usage;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class UsageDTO {

  private int rentalDetailID;
  private ServiceDTO service;
  //    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm dd/MM/yyyy")
  private Date date;
  private int quantity;
  private long price;
  private boolean status;
  private String billID;

  public static List<UsageDTO> toDTO(List<Usage> usages) {
    return usages.stream().map(UsageDTO::toDTO).collect(Collectors.toList());
  }

  public static UsageDTO toDTO(Usage usage) {
    if (usage == null) {
      return null;
    }
    UsageDTO dto = new UsageDTO();
    dto.setRentalDetailID(usage.getRentalDetailID());
    dto.setStatus(usage.isStatus());
    dto.setDate(usage.getDate());
    dto.setPrice(usage.getPrice());
    dto.setQuantity(usage.getQuantity());
    dto.setService(ServiceDTO.toDTO(usage.getService()));
    if (usage.getBill() != null) {
      dto.setBillID(usage.getBill().getID());
    }
    return dto;
  }

  public static Usage toEntity(UsageDTO dto) {
    if (dto == null) {
      return null;
    }
    Usage usage = new Usage();
    usage.setQuantity(dto.getQuantity());
    usage.setStatus(dto.isStatus());
    usage.setDate(new Date());
    usage.setRentalDetailID(dto.getRentalDetailID());
    usage.setServiceID(dto.getService().getID());
//        RentalDetail rentalDetail = new RentalDetail();
//        rentalDetail.setID(dto.getRentalDetailID());
//        usage.setRentalDetail(rentalDetail);
//        Service service = new Service();
//        service.setID(dto.getService().getID());
//        usage.setService(service);
    return usage;
  }
}