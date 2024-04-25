package org.example.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.example.entity.ServicePrice;

import javax.validation.constraints.Min;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ServicePriceDTO {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date date;
    private ServiceDTO service;
    @Min(value = 0, message = "price too small")
    private long price;

    public static ServicePriceDTO toDTO(ServicePrice price){
        if (price == null)
            return null;
        ServicePriceDTO dto = new ServicePriceDTO();
        dto.setPrice(price.getPrice());
        dto.setService(ServiceDTO.toDTO(price.getService()));
        dto.setDate(price.getDate());
        return dto;
    }

    public static List<ServicePriceDTO> toDTO(List<ServicePrice> prices){
        if (prices == null)
            return null;
        return prices.stream().map(ServicePriceDTO::toDTO).collect(Collectors.toList());
    }

    public static ServicePrice toEntity(ServicePriceDTO dto){
        if (dto ==null)
            return null;
        ServicePrice price = new ServicePrice();
        price.setServiceID(dto.getService().getID());
        price.setPrice(dto.getPrice());
        price.setDate(dto.getDate());
        return price;
    }
}
