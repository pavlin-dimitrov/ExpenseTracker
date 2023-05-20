package com.pavcho.ExpenseTracker.entity;

import com.pavcho.ExpenseTracker.auditor.AuditableWithoutUser;
import com.pavcho.ExpenseTracker.enums.Gender;
import com.pavcho.ExpenseTracker.enums.Role;
import io.mongock.utils.field.Field;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("users")
public class User extends AuditableWithoutUser<String> implements Serializable {

  @Id
  private String id;
  @Field("first_name")
  private String firstName;
  @Field("last_name")
  private String lastName;
  @Field("email")
  private String email;
  @Field("password")
  private String password;
  @Field("gender")
  private Gender gender;
  @Field("dob")
  private LocalDate dob;
  @Field("pictureUrl")
  private String pictureUrl;
  @Field("role")
  private Role role;
  @Field("zone_id")
  private String zoneId;

}
