package io.fdlessard.codebites.customer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@SuperBuilder
@Data
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditableEntity<U, V> extends BaseEntity {

  @JsonIgnore
  @CreatedBy
  @Column(name = "created_by")
  protected U createdBy;

  @JsonIgnore
  @Basic
  @CreatedDate
  @Column(name = "created_date")
  protected V createdDate;

  @JsonIgnore
  @LastModifiedBy
  @Column(name = "last_modified_by")
  protected U lastModifiedBy;

  @JsonIgnore
  @Basic
  @LastModifiedDate
  @Column(name = "last_modified_date")
  protected V lastModifiedDate;

}
