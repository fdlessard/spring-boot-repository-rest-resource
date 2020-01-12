package io.fdlessard.codebites.customer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "customer_category")
@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="version", columnDefinition = "int default 0")
    @JsonIgnore
    @Version
    private int version;

    private String category;

}