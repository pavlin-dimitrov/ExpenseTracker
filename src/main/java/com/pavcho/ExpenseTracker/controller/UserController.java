package com.pavcho.ExpenseTracker.controller;

import com.pavcho.ExpenseTracker.dto.user_dto.UserCreatedDto;
import com.pavcho.ExpenseTracker.dto.user_dto.UserDto;
import com.pavcho.ExpenseTracker.dto.user_dto.UserRegisterDto;
import com.pavcho.ExpenseTracker.entity.User;
import com.pavcho.ExpenseTracker.service.contract.UserService;
import java.time.ZoneId;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

  @Autowired private final UserService userService;

  @GetMapping("/all")
  public ResponseEntity<List<UserDto>> getAllExpenses() {
    return ResponseEntity.ok(userService.getAllUsers());
  }

  @PostMapping("/register")
  public ResponseEntity<?> registerNewUser(
      @RequestBody @Valid UserRegisterDto userRegisterDto, @RequestParam String zoneId) {
    return new ResponseEntity<>(
        userService.registerNewUser(userRegisterDto, zoneId), HttpStatus.OK);
  }

  @GetMapping("/find-by-email")
  public ResponseEntity<User> findByEmail(@RequestParam String email) {
    return new ResponseEntity<>(userService.findByEmail(email), HttpStatus.OK);
  }

  @DeleteMapping("/delete-user")
  public ResponseEntity<List<User>> deleteUserByEmail(@RequestParam String email) {
    return new ResponseEntity<>(userService.deleteByEmail(email), HttpStatus.OK);
  }

  @PutMapping("/edit-user")
  public ResponseEntity<User> editUserInfo(@RequestBody User user) {
    return new ResponseEntity<>(userService.editUserInfo(user), HttpStatus.OK);
  }
  
}
