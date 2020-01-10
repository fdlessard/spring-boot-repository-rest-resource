package io.fdlessard.codebites.customer.repositories;

import io.fdlessard.codebites.customer.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "product", path = "products")
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

}


