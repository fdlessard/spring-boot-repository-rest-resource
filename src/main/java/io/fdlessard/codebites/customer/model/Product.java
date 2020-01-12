package io.fdlessard.codebites.customer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Table(name = "product")
@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="version", columnDefinition = "int default 0")
    @JsonIgnore
    @Version
    private int version;

    private String code;

    private String name;

    private BigDecimal price;
}