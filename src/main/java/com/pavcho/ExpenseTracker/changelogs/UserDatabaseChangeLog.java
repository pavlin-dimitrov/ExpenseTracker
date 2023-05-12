package com.pavcho.ExpenseTracker.changelogs;

import com.pavcho.ExpenseTracker.entity.User;
import com.pavcho.ExpenseTracker.enums.Gender;
import com.pavcho.ExpenseTracker.enums.Role;
import com.pavcho.ExpenseTracker.repository.UserRepository;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@ChangeUnit(order = "002", id = "addUserCollection", author = "pavCho")
public class UserDatabaseChangeLog {

  @Execution
  public void addUserCollection(UserRepository userRepository) {

    // Add the first user
    User user1 = new User();
    user1.setFirstName("John");
    user1.setLastName("Doe");
    user1.setEmail("john.doe@example.com");
    user1.setPassword("password1");
    user1.setGender(Gender.MALE);
    user1.setDob(LocalDate.of(1990,01,01));
    user1.setRole(Role.USER);

    // Add the second user
    User user2 = new User();
    user2.setFirstName("Jane");
    user2.setLastName("Doe");
    user2.setEmail("jane.doe@example.com");
    user2.setPassword("password2");
    user2.setGender(Gender.FEMALE);
    user2.setDob(LocalDate.of(1992,02,01));
    user2.setRole(Role.USER);

    List<User> users = new ArrayList<>();
    users.add(user1);
    users.add(user2);
    userRepository.insert(users);
  }

  @RollbackExecution
  public void rollback() {
  }
}
