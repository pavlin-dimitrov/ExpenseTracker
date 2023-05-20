package com.pavcho.ExpenseTracker.entity;

import com.pavcho.ExpenseTracker.auditor.Auditable;
import io.mongock.utils.field.Field;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("shopping_list")
public class ShoppingList extends Auditable<String> implements Serializable {

  @Id
  private String id;

  @Field("user_id")
  private String userId;

  @Field("group_id")
  private String groupId;

  @Field("expenses")
  private List<Expense> expenses;
}
