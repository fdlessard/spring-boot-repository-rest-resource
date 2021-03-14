package io.fdlessard.codebites.customer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "address", schema = "public")
@Entity
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address extends BaseEntity implements Serializable {

  @Column(name = "number")
  private String number;
  @Column(name = "street")
  private String street;
  @Column(name = "city")
  private String city;
  @Column(name = "postal_code")
  private String postalCode;
  @Column(name = "province")
  private String province;
  @Column(name = "country")
  private String country;

  @ManyToOne
  @JoinColumn(name="customer_id")
  private Customer customer;
}