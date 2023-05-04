package com.pavcho.ExpenseTracker.controller;

import com.pavcho.ExpenseTracker.entity.Expense;
import com.pavcho.ExpenseTracker.service.implementation.ExpenseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expense")
@RequiredArgsConstructor
public class ExpenseController {

  private final ExpenseServiceImpl expenseServiceImpl;

  @PostMapping
  public ResponseEntity addExpense(@RequestBody Expense expense) {
    expenseServiceImpl.addExpense(expense);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @PutMapping
  public ResponseEntity updateExpense(@RequestBody Expense expense) {
    expenseServiceImpl.updateExpense(expense);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @GetMapping("/all")
  public ResponseEntity<List<Expense>> getAllExpenses() {
    return ResponseEntity.ok(expenseServiceImpl.getAllExpenses());
  }

  @GetMapping("/{name}")
  public ResponseEntity getExpenseByName(@PathVariable String name) {
    return ResponseEntity.ok(expenseServiceImpl.getExpense(name));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity deleteExpense(@PathVariable String id) {
    expenseServiceImpl.deleteExpense(id);
    return ResponseEntity.noContent().build();
  }

}
