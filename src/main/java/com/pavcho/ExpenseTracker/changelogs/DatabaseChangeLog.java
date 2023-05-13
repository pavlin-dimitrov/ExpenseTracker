package com.pavcho.ExpenseTracker.changelogs;

import static com.pavcho.ExpenseTracker.enums.ExpenseCategory.ENTERTAINMENT;
import static com.pavcho.ExpenseTracker.enums.ExpenseCategory.MISC;
import static com.pavcho.ExpenseTracker.enums.ExpenseCategory.RESTAURANT;
import static com.pavcho.ExpenseTracker.enums.ExpenseCategory.UTILITIES;

import com.pavcho.ExpenseTracker.entity.Expense;
import com.pavcho.ExpenseTracker.entity.User;
import com.pavcho.ExpenseTracker.enums.ExpenseCategory;
import com.pavcho.ExpenseTracker.enums.Gender;
import com.pavcho.ExpenseTracker.enums.Role;
import com.pavcho.ExpenseTracker.repository.ExpenseRepository;
import com.pavcho.ExpenseTracker.repository.UserRepository;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@ChangeUnit(order = "005", id = "test1", author = "pavCho")
public class DatabaseChangeLog {

  @Execution
  public void seedDatabase(ExpenseRepository expenseRepository, UserRepository userRepository) {
    User user;
    if(userRepository.count() == 0) {
      user = new User();
      user.setFirstName("John");
      user.setLastName("Doe");
      user.setEmail("john.doe@example.com");
      user.setPassword("password1");
      user.setGender(Gender.MALE);
      user.setDob(LocalDate.of(1990, 01, 01));
      user.setRole(Role.USER);
      userRepository.save(user);
    } else {
      user = userRepository.findAll().get(0);
    }

    System.out.println("User ID: " + user.getId());

    if (expenseRepository.count() == 0) {
      List<Expense> expenseList = new ArrayList<>();
      expenseList.add(createNewExpense("Movie Tickets", ENTERTAINMENT, BigDecimal.valueOf(40), user.getId()));
      expenseList.add(createNewExpense("Dinner", RESTAURANT, BigDecimal.valueOf(60), user.getId()));
      expenseList.add(createNewExpense("Netflix", ENTERTAINMENT, BigDecimal.valueOf(10), user.getId()));
      expenseList.add(createNewExpense("Gym", MISC, BigDecimal.valueOf(20), user.getId()));
      expenseList.add(createNewExpense("Internet", UTILITIES, BigDecimal.valueOf(30), user.getId()));
      expenseRepository.insert(expenseList);
    }
  }

  @RollbackExecution
  public void rollback() {}

  private Expense createNewExpense(String expenseName, ExpenseCategory expenseCategory, BigDecimal amount, String userId) {
    Expense expense = new Expense();
    expense.setExpenseName(expenseName);
    expense.setExpenseAmount(amount);
    expense.setExpenseCategory(expenseCategory);
    expense.setUserId(userId);  // set the user id
    return expense;
  }
}

