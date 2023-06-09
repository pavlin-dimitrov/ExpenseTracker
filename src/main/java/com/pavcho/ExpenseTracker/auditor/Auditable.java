package com.pavcho.ExpenseTracker.auditor;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@ToString
@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<T> {

  @CreatedBy
  protected T createdBy;

  @CreatedDate
  protected Long createdAt;

  @LastModifiedBy
  protected T lastModifiedBy;

  @LastModifiedDate
  protected Long lastModifiedAt;

  public Auditable(Long createdAt, T createdBy, T lastModifiedBy, Long lastModifiedAt) {
    this.createdAt = createdAt;
    this.createdBy = createdBy;
    this.lastModifiedBy = lastModifiedBy;
    this.lastModifiedAt = lastModifiedAt;
  }
}
