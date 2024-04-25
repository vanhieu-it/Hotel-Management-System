package org.example.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class HotelDTO {

  private String ID;

  @NotBlank(message = "cannot-be-empty")
  @Length(min = 3, message = "length-size-name-must-be-greater-3")
  private String name;

  @NotBlank(message = "cannot-be-empty")
  private String address;

  @NotBlank(message = "cannot-be-empty")
  private String phoneNumber;

  @NotBlank(message = "cannot-be-empty")
  private String description;
}
