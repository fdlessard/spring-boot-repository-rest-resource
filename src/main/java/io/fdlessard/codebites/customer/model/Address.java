package io.fdlessard.codebites.customer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "address")
@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "version", columnDefinition = "int default 0")
    @JsonIgnore
    @Version
    private int version;

    @ManyToOne
    private Customer customer;

    private String number;
    private String street;
    private String city;
    private String postalCode;
    private String province;
    private String country;

}