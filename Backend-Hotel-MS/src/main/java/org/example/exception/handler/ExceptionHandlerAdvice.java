package org.example.exception.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.example.exception.BadRequestException;
import org.example.exception.ConflictException;
import org.example.exception.NotFoundException;
import org.example.response.ErrorResponse;
import org.example.util.DateUtils;

import java.util.Objects;

@Slf4j
@ControllerAdvice
@RestController
@RequiredArgsConstructor
public class ExceptionHandlerAdvice {

  @ExceptionHandler(ConflictException.class)
  public ResponseEntity<ErrorResponse> handleUsernameAlreadyExistsException(
      ConflictException ex) {
    ErrorResponse errorResponse = ErrorResponse.builder()
        .timestamp(DateUtils.now())
        .status(HttpStatus.CONFLICT.value())
        .errorCode(ex.getMessage())
        .build();
    return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
  }

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<ErrorResponse> handleRoleNotFoundException(
      NotFoundException ex) {
    ErrorResponse errorResponse = ErrorResponse.builder()
        .timestamp(DateUtils.now())
        .status(HttpStatus.NOT_FOUND.value())
        .errorCode(ex.getMessage())
        .build();
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  protected ResponseEntity<Object> handle(MethodArgumentNotValidException ex) {
    FieldError error = ex.getBindingResult().getFieldErrors().stream().findFirst().orElse(null);

    if (error == null) {
      ErrorResponse errorResponse = ErrorResponse.builder()
          .timestamp(DateUtils.now())
          .status(HttpStatus.BAD_REQUEST.value())
          .errorCode("unknown-error")
          .build();
      return ResponseEntity.badRequest().body(errorResponse);
    }

    ErrorResponse errorResponse = ErrorResponse.builder()
        .timestamp(DateUtils.now())
        .status(HttpStatus.BAD_REQUEST.value())
        .errorCode(error.getField() + "-"
            + Objects.requireNonNull(error.getDefaultMessage()).replaceAll("\\s", "-"))
        .build();
    return ResponseEntity.badRequest().body(errorResponse);
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(
      HttpMessageNotReadableException ex) {
    ErrorResponse errorResponse = ErrorResponse.builder()
        .timestamp(DateUtils.now())
        .status(HttpStatus.BAD_REQUEST.value())
        .errorCode(ex.getMessage())
        .build();
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
  }

  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<ErrorResponse> handleBadRequestException(
      BadRequestException ex) {
    ErrorResponse errorResponse = ErrorResponse.builder()
        .timestamp(DateUtils.now())
        .status(HttpStatus.BAD_REQUEST.value())
        .errorCode(ex.getMessage())
        .build();
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
  }


}
