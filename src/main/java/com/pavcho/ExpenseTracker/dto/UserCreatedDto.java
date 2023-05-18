package com.pavcho.ExpenseTracker.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserCreatedDto {

  private String email;
  private LocalDateTime createdAt;

}
