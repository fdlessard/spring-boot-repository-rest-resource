package io.fdlessard.codebites.customer.model;

import java.io.Serializable;
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

//    @ManyToOne
//    private Customer customer;

  private String number;
  private String street;
  private String city;
  private String postalCode;
  private String province;
  private String country;

}