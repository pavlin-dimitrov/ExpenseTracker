package com.pavcho.ExpenseTracker.changelogs;

import static com.pavcho.ExpenseTracker.enums.ExpenseCategory.ENTERTAINMENT;
import static com.pavcho.ExpenseTracker.enums.ExpenseCategory.MISC;
import static com.pavcho.ExpenseTracker.enums.ExpenseCategory.RESTAURANT;
import static com.pavcho.ExpenseTracker.enums.ExpenseCategory.UTILITIES;

import com.pavcho.ExpenseTracker.entity.Expense;
import com.pavcho.ExpenseTracker.enums.ExpenseCategory;
import com.pavcho.ExpenseTracker.repository.ExpenseRepository;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@ChangeUnit(order = "001", id = "seedDatabase", author = "pavCho")
public class DatabaseChangeLog {

  @Execution
  public void seedDatabase(ExpenseRepository expenseRepository) {
    List<Expense> expenseList = new ArrayList<>();
    expenseList.add(createNewExpense("Movie Tickets", ENTERTAINMENT, BigDecimal.valueOf(40)));
    expenseList.add(createNewExpense("Dinner", RESTAURANT, BigDecimal.valueOf(60)));
    expenseList.add(createNewExpense("Netflix", ENTERTAINMENT, BigDecimal.valueOf(10)));
    expenseList.add(createNewExpense("Gym", MISC, BigDecimal.valueOf(20)));
    expenseList.add(createNewExpense("Internet", UTILITIES, BigDecimal.valueOf(30)));
    expenseRepository.insert(expenseList);
  }

  @RollbackExecution
  public void rollback() {
  }

  private Expense createNewExpense(String expenseName, ExpenseCategory expenseCategory, BigDecimal amount) {
    Expense expense = new Expense();
    expense.setExpenseName(expenseName);
    expense.setExpenseAmount(amount);
    expense.setExpenseCategory(expenseCategory);
    return expense;
  }
}
