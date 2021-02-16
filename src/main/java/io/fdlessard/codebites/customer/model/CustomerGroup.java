package io.fdlessard.codebites.customer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "customer_group")
@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerGroup implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "version", columnDefinition = "int default 0")
  @JsonIgnore
  @Version
  private int version;

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
