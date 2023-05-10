package com.pavcho.ExpenseTracker.service.implementation;

import com.pavcho.ExpenseTracker.entity.User;
import com.pavcho.ExpenseTracker.repository.UserRepository;
import com.pavcho.ExpenseTracker.service.contract.UserService;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

  @Autowired
  private final UserRepository userRepository;


  @Override
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @Override
  public User registerNewUser(User newUser) {
    userRepository.insert(newUser);
    return userRepository.findByEmail(newUser.getEmail());
  }

  @Override
  public User findByEmail(String email) {
    return userRepository.findByEmail(email);
  }
}
