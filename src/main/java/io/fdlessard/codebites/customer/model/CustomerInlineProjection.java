package io.fdlessard.codebites.customer.model;
import org.springframework.data.rest.core.config.Projection;

import java.util.Set;

@Projection(
        name = "customerInlineProjection",
        types = {Customer.class}
)
public interface CustomerInlineProjection {

    Long getId();

    String getLastName();

    String getFirstName();

    Set<Address> getAddresses();
}
