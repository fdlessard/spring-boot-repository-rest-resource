package io.fdlessard.codebites.customer.model;

import java.util.List;
import org.springframework.data.rest.core.config.Projection;

@Projection(
        name = "customerInlineProjection",
        types = {Customer.class}
)
public interface CustomerInlineProjection {

    Long getId();

    String getLastName();

    String getFirstName();

    List<Address> getAddresses();
}
