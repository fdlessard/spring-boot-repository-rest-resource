package io.fdlessard.codebites.customer.model;

import java.util.Set;
import org.springframework.data.rest.core.config.Projection;

@Projection(
    name = "customerGroupInlineProjection",
    types = {CustomerGroup.class}
)
public interface CustomerGroupInlineProjection {

  Long getId();

  String getName();

  Set<Customer> getCustomers();

  Customer getMainCustomer();
}
