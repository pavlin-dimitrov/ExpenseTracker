package com.pavcho.ExpenseTracker.entity;

import com.pavcho.ExpenseTracker.auditor.Auditable;
import com.pavcho.ExpenseTracker.enums.ExpenseCategory;
import io.mongock.utils.field.Field;
import java.math.BigDecimal;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("expense")
public class Expense extends Auditable<String> {
  @Id
  private String id;
  @Field("user_id")
  private String userId;
  @Field("name")
  private String expenseName;
  @Field("category")
  private ExpenseCategory expenseCategory;
  @Field("amount")
  private BigDecimal expenseAmount;
}
