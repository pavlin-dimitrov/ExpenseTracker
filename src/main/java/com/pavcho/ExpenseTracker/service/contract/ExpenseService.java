package com.pavcho.ExpenseTracker.service.contract;

import com.pavcho.ExpenseTracker.entity.Expense;
import java.util.List;

public interface ExpenseService {

  void addExpense(Expense expense);

  void updateExpense(Expense expense);

  Expense getExpense(String name);

  List<Expense> getAllExpenses();

  void deleteExpense(String id);

}
