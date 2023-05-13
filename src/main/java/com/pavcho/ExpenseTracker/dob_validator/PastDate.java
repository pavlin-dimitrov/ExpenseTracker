package com.pavcho.ExpenseTracker.dob_validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PastDateValidator.class)
public @interface PastDate {
  String message() default "The date of birth must be in the past";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};

}
