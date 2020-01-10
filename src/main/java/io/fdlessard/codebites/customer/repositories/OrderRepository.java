package io.fdlessard.codebites.customer.repositories;

import io.fdlessard.codebites.customer.model.Order;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "order", path = "orders")
public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {

}
