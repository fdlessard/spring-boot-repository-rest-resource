package io.fdlessard.codebites.customer.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Table(name = "address")
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

}