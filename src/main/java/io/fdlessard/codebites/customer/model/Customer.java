package io.fdlessard.codebites.customer.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Table(name = "customer", schema = "public")
@Entity
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE public.customer SET deleted_date=now() WHERE id=? AND version = ?")
@Where(clause = "deleted_date IS NULL")
public class Customer extends SoftDeletableAndAuditableEntity<Instant, String, Instant> {

  @NotBlank(message = "lastName name cannot be blank")
  @Size(min = 2, message = "lastName must have more thant 2 characters")
  private String lastName;

  @NotBlank(message = "firstName name cannot be blank")
  @Size(min = 2, message = "firstName must have more thant 2 characters")
  private String firstName;

  @NotBlank(message = "company name cannot be blank")
  @Size(min = 2, message = "company must have more thant 2 characters")
  private String company;

  //@JsonBackReference
  //@OneToMany(cascade = CascadeType.ALL, mappedBy="customer")
  @JoinColumn(name = "customer_id")
  @OneToMany(cascade = CascadeType.ALL)
  private Set<Address> addresses;
}
