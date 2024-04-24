package org.example.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.example.util.LocalDateDeserializer;
import org.example.util.LocalDateSerializer;

import javax.validation.constraints.Min;
import java.time.LocalDate;

@Data
public class UpdateBookingCardRequest {

  @JsonDeserialize(using = LocalDateDeserializer.class)
  @JsonSerialize(using = LocalDateSerializer.class)
  private LocalDate receivingAtDate;

  @JsonDeserialize(using = LocalDateDeserializer.class)
  @JsonSerialize(using = LocalDateSerializer.class)
  private LocalDate backingAtDate;


  @Min(value = 0, message = "must-be-greater-than-or-same-as-0")
  private Long deposit;

}
