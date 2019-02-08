package io.fdlessard.codebites.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    @Version
    private int version;

    @NotBlank(message = "lastName name cannot be blank")
    @Size(min = 2, message = "lastName must have more thant 2 characters")
    private String lastName;

    @NotBlank(message = "firstName name cannot be blank")
    @Size(min = 2, message = "firstName must have more thant 2 characters")
    private String firstName;

    private String company;

    @DecimalMin(value = "0.000", message = "Minimum rate value is 0.000")
    @JsonSerialize(using = BigDecimalScale3Serializer.class)
    private BigDecimal rate;
}
