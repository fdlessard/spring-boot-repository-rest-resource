package io.fdlessard.codebites.customer.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Table(name = "customer_group")
@Entity
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerGroup extends BaseEntity implements Serializable {

  @Column(name = "name")
  @Size(min = 2, message = "lastName must have more thant 2 characters")
  private String name;

  @ManyToMany
  @JoinTable(
      name = "customer_group_customer",
      joinColumns = @JoinColumn(name = "customer_group_id"),
      inverseJoinColumns = @JoinColumn(name = "customer_id")
  )
  private Set<Customer> customers;
}
