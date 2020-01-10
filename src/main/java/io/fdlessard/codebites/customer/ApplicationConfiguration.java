package io.fdlessard.codebites.customer;

import io.fdlessard.codebites.customer.model.Address;
import io.fdlessard.codebites.customer.model.Customer;
import io.fdlessard.codebites.customer.model.CustomerCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class ApplicationConfiguration implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Customer.class, CustomerCategory.class, Address.class);
    }
}





