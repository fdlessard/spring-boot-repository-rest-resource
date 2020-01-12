package io.fdlessard.codebites.customer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.io.Serializable;
import java.math.BigDecimal;

@Table(name = "order_item")
@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="version", columnDefinition = "int default 0")
    @JsonIgnore
    @Version
    private int version;

    private int itemId;

    private int productId;

    @DecimalMin(value = "0.000", message = "Minimum quantity value is 0.000")
    @JsonSerialize(using = BigDecimalScale3Serializer.class)
    private BigDecimal quantity;
}