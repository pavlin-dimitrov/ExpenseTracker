package com.pavcho.ExpenseTracker.entity;

import io.mongock.utils.field.Field;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("users")
public class User {

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

}
