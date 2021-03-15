package io.fdlessard.codebites.customer.controlers;

import io.fdlessard.codebites.customer.model.Customer;
import io.fdlessard.codebites.customer.repositories.CustomerRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RepositoryRestController()
@AllArgsConstructor
public class CustomerController {

  private CustomerRepository customerRepository;

  @ResponseBody
  @PostMapping(value = "/customers/batch")
  public Iterable<Customer> post(@RequestBody List<Customer> customers) {
    return customerRepository.saveAll(customers);
  }

}
