package io.fdlessard.codebites.customer.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "customerProjection", types = {Customer.class})
public interface CustomerProjection {

    String getFirstName();

    String getLastName();
}


