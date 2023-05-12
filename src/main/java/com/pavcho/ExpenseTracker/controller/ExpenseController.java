package com.pavcho.ExpenseTracker.controller;

import com.pavcho.ExpenseTracker.entity.Expense;
import com.pavcho.ExpenseTracker.service.contract.ExpenseService;
import com.pavcho.ExpenseTracker.service.implementation.ExpenseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expense")
@RequiredArgsConstructor
public class ExpenseController {

  @Autowired
  private final ExpenseService expenseService;

  @PostMapping
  public ResponseEntity addExpense(@RequestBody Expense expense) {
    expenseService.addExpense(expense);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @PutMapping
  public ResponseEntity updateExpense(@RequestBody Expense expense) {
    expenseService.updateExpense(expense);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @GetMapping("/all")
  public ResponseEntity<List<Expense>> getAllExpenses() {
    return ResponseEntity.ok(expenseService.getAllExpenses());
  }

  @GetMapping("/{name}")
  public ResponseEntity getExpenseByName(@PathVariable String name) {
    return ResponseEntity.ok(expenseService.getExpense(name));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity deleteExpense(@PathVariable String id) {
    expenseService.deleteExpense(id);
    return ResponseEntity.noContent().build();
  }

}
