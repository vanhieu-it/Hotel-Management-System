package org.example.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorResponse {

  private Long timestamp;
  private int status;
  private String errorCode;

}
