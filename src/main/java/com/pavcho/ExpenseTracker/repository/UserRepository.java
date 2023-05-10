package com.pavcho.ExpenseTracker.repository;

import com.pavcho.ExpenseTracker.entity.User;
import java.util.List;
import java.util.Optional;
import javax.validation.constraints.NotNull;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

  User findByEmail(String email);

  @Override
  void delete(@NotNull User user);
}
