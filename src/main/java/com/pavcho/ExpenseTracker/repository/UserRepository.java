package com.pavcho.ExpenseTracker.repository;

import com.pavcho.ExpenseTracker.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository  extends MongoRepository<User, String> {

}
