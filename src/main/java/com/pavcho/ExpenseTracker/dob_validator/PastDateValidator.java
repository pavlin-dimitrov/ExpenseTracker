package com.pavcho.ExpenseTracker.dob_validator;

import java.time.LocalDate;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PastDateValidator implements ConstraintValidator<PastDate, LocalDate> {

  @Override
  public void initialize(PastDate constraintAnnotation) {
  }

  @Override
  public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
    return localDate != null && (localDate.isBefore(LocalDate.now()));
  }
}
