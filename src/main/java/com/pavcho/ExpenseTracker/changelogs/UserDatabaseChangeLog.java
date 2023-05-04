package com.pavcho.ExpenseTracker.changelogs;

import com.pavcho.ExpenseTracker.entity.User;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;

@AllArgsConstructor
@ChangeUnit(order = "002", id = "addUserCollection", author = "pavCho")
public class UserDatabaseChangeLog {

  @Execution
  public void addUserCollection(MongoTemplate mongoTemplate) {
    mongoTemplate.createCollection(User.class);
  }

  @RollbackExecution
  public void rollback(MongoTemplate mongoTemplate) {
    mongoTemplate.dropCollection(User.class);
  }
}
