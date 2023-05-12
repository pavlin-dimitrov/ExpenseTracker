package com.pavcho.ExpenseTracker.entity;

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
@Document("picture")
public class Picture {

  @Id
  private Long id;

  private String pictureUrl;

}
