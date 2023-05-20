package com.pavcho.ExpenseTracker.dto.user_dto;

import com.pavcho.ExpenseTracker.dob_validator.PastDate;
import com.pavcho.ExpenseTracker.enums.Gender;
import java.time.LocalDate;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class UserRegisterDto {

  @Size(min = 2, max = 50)
  @Pattern(regexp = "^[A-Za-z-]*$")
  @NotBlank
  private String firstName;

  @Size(min = 2, max = 50)
  @Pattern(regexp = "^[A-Za-z-]*$")
  @NotBlank
  private String lastName;

  @NotBlank @Email private String email;

  @Pattern(
      regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
      message =
          "Password must be at least 8 characters long, contain at least one digit, "
              + "one uppercase letter, one lowercase letter and one special character.")
  private String password;

  @Enumerated(EnumType.STRING)
  @NotNull
  private Gender gender;

  @PastDate
  private LocalDate dob;
}
