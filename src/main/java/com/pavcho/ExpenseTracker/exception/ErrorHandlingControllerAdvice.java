package com.pavcho.ExpenseTracker.exception;

import com.mongodb.lang.NonNull;
import com.pavcho.ExpenseTracker.dto.ErrorResponseDto;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorHandlingControllerAdvice extends ResponseEntityExceptionHandler {

  @ExceptionHandler({UserNotFoundException.class, InvalidZoneIdException.class})
  public ResponseEntity<ErrorResponseDto> handleNotFoundException(RuntimeException ex) {
    return new ResponseEntity<>(
        new ErrorResponseDto(HttpStatus.NOT_FOUND, ex.getMessage(), LocalDateTime.now()),
        HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler({
    EmailIsTakenException.class,
  })
  public ResponseEntity<ErrorResponseDto> handleBadRequestException(RuntimeException ex) {
    return new ResponseEntity<>(
        new ErrorResponseDto(HttpStatus.BAD_REQUEST, ex.getMessage(), LocalDateTime.now()),
        HttpStatus.BAD_REQUEST);
  }

  @Override
  @NonNull
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
      @NonNull MethodArgumentNotValidException ex,
      @NonNull HttpHeaders headers,
      @NonNull HttpStatus status,
      @NonNull WebRequest request) {
    Map<String, String> fieldErrors = new HashMap<>();
    ex.getBindingResult()
        .getFieldErrors()
        .forEach(
            fieldError -> fieldErrors.put(fieldError.getField(), fieldError.getDefaultMessage()));
    ErrorResponseDto errorResponse =
        new ErrorResponseDto(
            HttpStatus.BAD_REQUEST, "Validation Failed", fieldErrors, LocalDateTime.now());
    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
  }
}
