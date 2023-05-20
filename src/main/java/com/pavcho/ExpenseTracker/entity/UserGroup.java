package com.pavcho.ExpenseTracker.entity;

import com.pavcho.ExpenseTracker.auditor.AuditableWithoutUser;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("user_group")
public class UserGroup extends AuditableWithoutUser<String> implements Serializable {

  @Id
  private String id;
  @Field("name")
  private String name;
  @Field("created_by")
  private String createdByUserId; // The ID of the user who created the group
  @Field("members")
  private List<String> memberUserIds; // A list of user IDs that belong to this group
  @Field("pending_requests")
  private List<String> pendingRequestUserIds; // A list of user IDs that have requested to join the group
}
