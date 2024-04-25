package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.example.entity.Promotion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PromotionDTO {
    private Integer id;
    @Length(min = 1, max = 50, message = "length 1 to 255.")
    private String promotionName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startAtDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endAtDate;
    private List<PromotionDetailDTO> details = new ArrayList<>();

    public static PromotionDTO toDTO(Promotion promotion){
        if (promotion == null)
            return null;
        PromotionDTO dto = new PromotionDTO();
        dto.setPromotionName(promotion.getPromotionName());
        dto.setId(promotion.getId());
        dto.setEndAtDate(promotion.getEndAtDate());
        dto.setStartAtDate(promotion.getStartAtDate());
        return dto;
    }

    public static List<PromotionDTO> toDTO(List<Promotion> promotions){
        if (promotions == null)
            return null;
        return promotions.stream().map(PromotionDTO::toDTO).collect(Collectors.toList());
    }

    public static Promotion toEntity(PromotionDTO dto) {
        if (dto == null)
        return null;
        Promotion promotion = new Promotion();
        promotion.setPromotionName(dto.getPromotionName());
        promotion.setEndAtDate(dto.getEndAtDate());
        promotion.setStartAtDate(dto.startAtDate);
        return promotion;
    }
}
