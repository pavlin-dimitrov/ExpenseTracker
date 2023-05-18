package com.pavcho.ExpenseTracker.auditor;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@ToString
@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditableWithoutUser<T> {

  @CreatedDate
  protected Long createdAt;

  @LastModifiedDate
  protected Long lastModifiedAt;

  public AuditableWithoutUser(Long createdAt, Long lastModifiedAt) {
    this.createdAt = createdAt;
    this.lastModifiedAt = lastModifiedAt;
  }
}
