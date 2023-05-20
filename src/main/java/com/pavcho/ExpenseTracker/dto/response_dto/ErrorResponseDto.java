package com.pavcho.ExpenseTracker.dto.response_dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@ApiModel(description = "Detailed information about the error response returned by the API")
public class ErrorResponseDto {

  @ApiModelProperty(value = "The HTTP status of the error", required = true)
  private final HttpStatus status;

  @ApiModelProperty(value = "A descriptive error message", required = true)
  private final String message;

  @ApiModelProperty(value = "Any field-specific error messages")
  private final Map<String, String> fieldErrors;

  @ApiModelProperty(value = "The time at which the error occurred", required = true)
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
