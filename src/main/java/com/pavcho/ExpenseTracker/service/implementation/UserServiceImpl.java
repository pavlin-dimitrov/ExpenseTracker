package com.pavcho.ExpenseTracker.service.implementation;

import com.pavcho.ExpenseTracker.entity.User;
import com.pavcho.ExpenseTracker.exception.UserNotFoundException;
import com.pavcho.ExpenseTracker.repository.UserRepository;
import com.pavcho.ExpenseTracker.service.contract.UserService;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

  @Autowired
  private final UserRepository userRepository;
  @Autowired
  private MongoTemplate mongoTemplate;


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

  @Override
  public List<User> deleteByEmail(String email) {
    User deleteUser = userRepository.findByEmail(email);
    userRepository.delete(deleteUser);
    return userRepository.findAll();
  }

  @Override
  public User editUserInfo(User user) {
    Optional<User> optionalUser = userRepository.findById(user.getId());
    if (optionalUser.isEmpty()) {
      throw new UserNotFoundException();
    }
    User editUser = optionalUser.get();
    editUser.setFirstName(user.getFirstName());
    editUser.setLastName(user.getLastName());
    editUser.setEmail(user.getEmail());

    Query query = new Query();
    query.addCriteria(Criteria.where("id").is(user.getId()));
    Update update = new Update();
    update.set("firstName", user.getFirstName());
    update.set("lastName", user.getLastName());
    update.set("email", user.getEmail());

    mongoTemplate.updateFirst(query, update, User.class);

    return editUser;
  }


}
