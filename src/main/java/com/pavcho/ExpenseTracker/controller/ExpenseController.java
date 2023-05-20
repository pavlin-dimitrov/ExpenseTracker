package com.pavcho.ExpenseTracker.controller;

import com.pavcho.ExpenseTracker.entity.Expense;
import com.pavcho.ExpenseTracker.service.contract.ExpenseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expense")
@RequiredArgsConstructor
@Api(tags = "Expense Management")
public class ExpenseController {

  @Autowired private final ExpenseService expenseService;

  @ApiOperation(value = "Create a new Expense")
  @PostMapping
  public ResponseEntity addExpense(
      @RequestBody
      @ApiParam(value = "Expense information for a new expense to be created.")
          Expense expense) {
    expenseService.addExpense(expense);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @ApiOperation(value = "Update an existing Expense")
  @PutMapping
  public ResponseEntity updateExpense(
      @RequestBody
      @ApiParam(value = "Updated expense information to replace the old one.")
          Expense expense) {
    expenseService.updateExpense(expense);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @ApiOperation(value = "View a list of all expenses")
  @GetMapping("/all")
  public ResponseEntity<List<Expense>> getAllExpenses() {
    return ResponseEntity.ok(expenseService.getAllExpenses());
  }

  @ApiOperation(value = "Get an Expense by its name")
  @GetMapping("/{name}")
  public ResponseEntity getExpenseByName(
      @PathVariable
      @ApiParam(value = "Name of the expense to be obtained. Cannot be empty.")
          String name) {
    return ResponseEntity.ok(expenseService.getExpense(name));
  }

  @ApiOperation(value = "Delete an Expense")
  @DeleteMapping("/{id}")
  public ResponseEntity deleteExpense(
      @PathVariable
      @ApiParam(value = "Id of the expense to be deleted. Cannot be empty.")
          String id) {
    expenseService.deleteExpense(id);
    return ResponseEntity.noContent().build();
  }
}
