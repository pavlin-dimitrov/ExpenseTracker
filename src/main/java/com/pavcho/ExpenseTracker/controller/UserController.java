package com.pavcho.ExpenseTracker.controller;

import com.pavcho.ExpenseTracker.entity.User;
import com.pavcho.ExpenseTracker.service.contract.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

  @Autowired private final UserService userService;

  @GetMapping("/all")
  public ResponseEntity<List<User>> getAllExpenses() {
    return ResponseEntity.ok(userService.getAllUsers());
  }

  @PostMapping("/register")
  public ResponseEntity<?> registerNewUser(@RequestBody User newUser) {
    return new ResponseEntity<>(userService.registerNewUser(newUser), HttpStatus.OK);
  }

  @GetMapping("/find-by-email")
  public ResponseEntity<User> findByEmail(@RequestParam String email) {
    return new ResponseEntity<>(userService.findByEmail(email), HttpStatus.OK);
  }
}
