package com.pavcho.ExpenseTracker.dto.response_dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ErrorResponseDto {
  private final HttpStatus status;
  private final String message;
  private final Map<String, String> fieldErrors;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd' 'HH:mm:ss")
  private final LocalDateTime timestamp;


  public ErrorResponseDto(HttpStatus status, String message, LocalDateTime timestamp) {
    this.status = status;
    this.message = message;
    this.timestamp = LocalDateTime.now();
    this.fieldErrors = new HashMap<>();
  }

  public ErrorResponseDto(HttpStatus status, String message, Map<String, String> fieldErrors, LocalDateTime timestamp) {
    this.status = status;
    this.message = message;
    this.timestamp = LocalDateTime.now();
    this.fieldErrors = fieldErrors;
  }

}
