package io.fdlessard.codebites.customer.model;

import static io.fdlessard.codebites.customer.model.CustomerTest.buildCustomer;
import static io.fdlessard.codebites.customer.model.CustomerTest.buildCustomers;
import static org.junit.jupiter.api.Assertions.*;

class CustomerGroupTest {


  public static final String TEST_NAME_STR = "name";

  public static CustomerGroup buildCustomerGroup() {
    return CustomerGroup.builder()
        .id(0l)
        .version(0)
        .name(TEST_NAME_STR)
        .customers(buildCustomers())
        .mainCustomer(buildCustomer())
        .build();
  }
}