package io.fdlessard.codebites.customer.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Table(name = "customer_group",  schema = "public")
@Entity
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE public.customer_group SET deleted_date=now() WHERE id=? AND version = ?")
@Where(clause = "deleted_date IS NULL")
public class CustomerGroup extends SoftDeletableAndAuditableEntity<Instant, String, Instant> {

  @Column(name = "name")
  @Size(min = 2, message = "lastName must have more thant 2 characters")
  private String name;

  @ManyToMany
  @JoinTable(
      schema = "public",
      name = "customer_group_customer",
      joinColumns = @JoinColumn(name = "customer_group_id"),
      inverseJoinColumns = @JoinColumn(name = "customer_id")
  )
  private Set<Customer> customers;
}
