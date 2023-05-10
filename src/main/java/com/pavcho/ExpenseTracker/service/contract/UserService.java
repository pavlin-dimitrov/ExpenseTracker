package com.pavcho.ExpenseTracker.service.contract;

import com.pavcho.ExpenseTracker.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserService {

  List<User> getAllUsers();

  User registerNewUser(User newUser);

  User findByEmail(String email);

}
