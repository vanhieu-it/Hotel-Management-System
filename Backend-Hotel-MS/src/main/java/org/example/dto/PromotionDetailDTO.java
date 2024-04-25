package org.example.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.entity.PromotionDetail;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class PromotionDetailDTO {
    private RoomClassDTO roomClass;
    @Min(value = 1)
    @Max(value = 100)
    private float value;

    public static PromotionDetail toEntity(PromotionDetailDTO detailDTO) {
        if (detailDTO == null)
            return null;
        PromotionDetail detail = new PromotionDetail();
        detail.setValue(detailDTO.getValue() / 100);
        return detail;
    }

    public static PromotionDetailDTO toDTO(PromotionDetail detail) {
        if (detail == null)
            return null;
        PromotionDetailDTO dto = new PromotionDetailDTO();
        dto.setValue(detail.getValue());
        dto.setRoomClass(RoomClassDTO.toDTO(detail.getRoomClass()));
        return dto;
    }

    public static List<PromotionDetailDTO> toDTO(List<PromotionDetail> details) {
        if (details == null)
            return null;
        return details.stream().map(PromotionDetailDTO::toDTO).collect(Collectors.toList());
    }
}
