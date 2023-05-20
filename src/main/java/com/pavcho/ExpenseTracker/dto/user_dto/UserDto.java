package com.pavcho.ExpenseTracker.dto.user_dto;

import com.pavcho.ExpenseTracker.enums.Gender;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {

  private String firstName;
  private String lastName;
  private String email;
  private LocalDate dob;
  private Gender gender;
  private String pictureUrl;

}
