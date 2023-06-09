package com.pavcho.ExpenseTracker.service.implementation;

import com.pavcho.ExpenseTracker.entity.Expense;
import com.pavcho.ExpenseTracker.repository.ExpenseRepository;
import com.pavcho.ExpenseTracker.service.contract.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ExpenseServiceImpl implements ExpenseService {

  private final ExpenseRepository expenseRepository;

  @Override
  public void addExpense(Expense expense) {
    expenseRepository.insert(expense);
  }

  @Override
  public void updateExpense(Expense expense) {
    Expense savedExpense =
        expenseRepository
            .findById(expense.getId())
            .orElseThrow(
                () ->
                    new RuntimeException(
                        String.format("Cannot Find Expense by ID %s", expense.getId())));
    savedExpense.setExpenseName(expense.getExpenseName());
    savedExpense.setExpenseCategory(expense.getExpenseCategory());
    savedExpense.setExpenseAmount(expense.getExpenseAmount());

    expenseRepository.save(expense);
  }

  @Override
  public Expense getExpense(String name) {
    return expenseRepository
        .findByName(name)
        .orElseThrow(
            () -> new RuntimeException(String.format("Cannot Find Expense by Name - %s", name)));
  }

  @Override
  public List<Expense> getAllExpenses() {
    return expenseRepository.findAll();
  }

  @Override
  public void deleteExpense(String id) {
    expenseRepository.deleteById(id);
  }
}
