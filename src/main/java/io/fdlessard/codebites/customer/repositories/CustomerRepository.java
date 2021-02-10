package io.fdlessard.codebites.customer.repositories;

import io.fdlessard.codebites.customer.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "customers")
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

    List<Customer> findByLastName(@Param("lastName") String lastName);
    List<Customer> findByFirstName(@Param("firstName") String firstName);
}
