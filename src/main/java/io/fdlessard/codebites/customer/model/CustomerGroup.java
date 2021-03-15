package io.fdlessard.codebites.customer.model;

import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Table(name = "customer_group", schema = "public")
@Entity
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerGroup extends BaseEntity {

  @Column(name = "name")
  @Size(min = 2, message = "lastName must have more thant 2 characters")
  private String name;

  @Valid
  @ManyToMany(mappedBy = "customerGroups")
  private List<Customer> customers;

  @Valid
  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "main_customer_id", columnDefinition="bigint")
  private Customer mainCustomer;
}
