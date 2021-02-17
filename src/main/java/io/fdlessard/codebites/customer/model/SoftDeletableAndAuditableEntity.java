package io.fdlessard.codebites.customer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
@MappedSuperclass
public abstract class SoftDeletableAndAuditableEntity<T, U, V> extends AuditableEntity<U, V> {

  @JsonIgnore
  @Column(name = "deleted_date")
  protected T deletedDate;

}
