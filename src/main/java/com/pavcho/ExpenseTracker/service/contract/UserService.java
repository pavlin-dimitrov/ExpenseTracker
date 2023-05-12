package com.pavcho.ExpenseTracker.service.contract;

import com.pavcho.ExpenseTracker.dto.UserRegisterDto;
import com.pavcho.ExpenseTracker.entity.User;
import java.util.List;

public interface UserService {

  List<User> getAllUsers();

  UserRegisterDto registerNewUser(UserRegisterDto userRegisterDto);

  User findByEmail(String email);

  List<User> deleteByEmail(String email);

  User editUserInfo(User user);

}
