package com.pavcho.ExpenseTracker.controller;

import com.pavcho.ExpenseTracker.dto.user_dto.UserDto;
import com.pavcho.ExpenseTracker.dto.user_dto.UserRegisterDto;
import com.pavcho.ExpenseTracker.entity.User;
import com.pavcho.ExpenseTracker.service.contract.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api(value = "User controller")
@RequiredArgsConstructor
public class UserController {

  @Autowired private final UserService userService;

  @ApiOperation(value = "Retrieves a list of all users", response = UserDto.class)
  @ApiResponses(
      value = {
          @ApiResponse(code = 200, message = "Successfully retrieved list of users"),
          @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
          @ApiResponse(
              code = 403,
              message = "Accessing the resource you were trying to reach is forbidden"),
          @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
      })
  @GetMapping("/all")
  public ResponseEntity<List<UserDto>> getAllExpenses() {
    return ResponseEntity.ok(userService.getAllUsers());
  }

  @ApiOperation(value = "Create new User account", response = UserRegisterDto.class)
  @ApiResponses(
      value = {
          @ApiResponse(code = 200, message = "Successfully registered new account"),
          @ApiResponse(code = 401, message = "Not authorized action"),
          @ApiResponse(
              code = 403,
              message = "Accessing the resource you were trying to reach is forbidden"),
          @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
      })
  @PostMapping("/register")
  public ResponseEntity<UserRegisterDto> registerNewUser(
      @RequestBody @Valid UserRegisterDto userRegisterDto, @RequestParam String zoneId) {
    return new ResponseEntity<>(
        userService.registerNewUser(userRegisterDto, zoneId), HttpStatus.OK);
  }

  @GetMapping("/find-by-email")
  public ResponseEntity<User> findByEmail(@RequestParam String email) {
    return new ResponseEntity<>(userService.findByEmail(email), HttpStatus.OK);
  }
  @ApiOperation(value = "Delete user account", response = User.class)
  @ApiResponses(
      value = {
          @ApiResponse(code = 200, message = "Successfully deleted account"),
          @ApiResponse(code = 401, message = "You are not authorized to do this action"),
          @ApiResponse(code = 403, message = "Forbidden resource"),
          @ApiResponse(code = 404, message = "The resource is not found")
      })
  @DeleteMapping("/delete-user")
  public ResponseEntity<List<User>> deleteUserByEmail(@RequestParam String email) {
    return new ResponseEntity<>(userService.deleteByEmail(email), HttpStatus.OK);
  }

  @ApiOperation(value = "Edit user account", response = User.class)
  @ApiResponses(
      value = {
          @ApiResponse(code = 200, message = "Successfully edited account"),
          @ApiResponse(code = 401, message = "Not authorized resource"),
          @ApiResponse(code = 403, message = "Forbidden resource"),
          @ApiResponse(code = 404, message = "The resource is not found")
      })
  @PutMapping("/edit-user")
  public ResponseEntity<User> editUserInfo(@RequestBody User user) {
    return new ResponseEntity<>(userService.editUserInfo(user), HttpStatus.OK);
  }
  
}
