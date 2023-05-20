package com.pavcho.ExpenseTracker.dto.user_dto;

import com.pavcho.ExpenseTracker.enums.Gender;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@ApiModel(
    value = "Present User model",
    description = "Public Model of user entity for presentation purpose.")
public class UserDto {

  @ApiModelProperty(value = "User's first name", required = true)
  private String firstName;

  @ApiModelProperty(value = "User's last name", required = true)
  private String lastName;

  @ApiModelProperty(value = "User's email", required = true)
  private String email;

  @ApiModelProperty(value = "User's date of birth", required = true)
  private LocalDate dob;

  @ApiModelProperty(value = "User's gender", required = true)
  private Gender gender;

  @ApiModelProperty(value = "User's picture url", required = true)
  private String pictureUrl;

}
