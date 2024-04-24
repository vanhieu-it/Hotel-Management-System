package org.example.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.example.util.LocalDateDeserializer;
import org.example.util.LocalDateSerializer;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class UpdatePromotionRequest {

  @NotBlank(message = "cannot-be-empty")
  private String promotionName;

  @JsonDeserialize(using = LocalDateDeserializer.class)
  @JsonSerialize(using = LocalDateSerializer.class)
  private LocalDate startAtDate;

  @JsonDeserialize(using = LocalDateDeserializer.class)
  @JsonSerialize(using = LocalDateSerializer.class)
  private LocalDate endAtDate;

  @Min(value = 1, message = "must-be-greater-than-0")
  private BigDecimal value;

  @NotNull(message = "cannot-be-null")
  private List<PromotionDetailDto> promotionDetailDtos;

}
