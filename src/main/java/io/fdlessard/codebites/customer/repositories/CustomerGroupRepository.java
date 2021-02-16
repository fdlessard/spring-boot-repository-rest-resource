package io.fdlessard.codebites.customer.repositories;

import io.fdlessard.codebites.customer.model.CustomerGroup;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "customer-groups")
public interface CustomerGroupRepository extends PagingAndSortingRepository<CustomerGroup, Long> {

  //Page<Customer> findByLastName(@Param("lastName") String lastName, Pageable p);

}
