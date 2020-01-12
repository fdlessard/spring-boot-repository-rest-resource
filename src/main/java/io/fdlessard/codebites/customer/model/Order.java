package io.fdlessard.codebites.customer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "`order`")
@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="version", columnDefinition = "int default 0")
    @JsonIgnore
    @Version
    private int version;

    private long customerId;

    @JoinColumn(name = "order_id",  foreignKey = @ForeignKey(name = "fk_order_item"))
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;
}
