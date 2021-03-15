package io.fdlessard.codebites.customer.model;

import static io.fdlessard.codebites.customer.model.AddressTest.buildAddress;
import static io.fdlessard.codebites.customer.model.CustomerGroupTest.buildCustomerGroup;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.testcontainers.shaded.org.apache.commons.lang.RandomStringUtils;

class CustomerTest {

  public static final String TEST_ID_STR = "id";
  public static final String TEST_VERSION_STR = "version";
  public static final String TEST_FIRST_NAME_STR = "firstName";
  public static final String TEST_LAST_NAME_STR = "lastName";
  public static final String TEST_COMPANY_STR = "company";

  private static ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
  private static Validator validator = vf.getValidator();

  @Test
  void customerMarshallingToJson() {
    Customer customer = buildCustomer();
    JsonNode node = TestUtils.getObjectMapper().convertValue(customer, JsonNode.class);
    assertCustomerNode(customer, node);
  }

  @Test
  void customerUnMarshallingFromJson() throws IOException {

    Customer customer = TestUtils
        .readFileIntoPojo("/Customer.json", Customer.class);
    assertCustomer(customer);
  }

  @Test
  void validateLastNameNotBlank() {

    Customer customer = buildCustomer();
    customer.setLastName(null);

    Set<ConstraintViolation<Customer>> violationSet = validator
        .validate(customer, Default.class);

    long violationsCount = TestUtils.getViolationsCount(violationSet,
        "lastName name cannot be blank", TEST_LAST_NAME_STR);
    assertEquals(1, violationsCount);

    customer.setFirstName(RandomStringUtils.random(3, StringUtils.SPACE));

    violationSet = validator.validate(customer, Default.class);
    violationsCount = TestUtils.getViolationsCount(violationSet,
        "lastName name cannot be blank", TEST_LAST_NAME_STR);

    assertEquals(1, violationsCount);
  }

  @Test
  void validateLastNameMinSize() {

    Customer customer = buildCustomer();
    customer.setLastName("a");

    Set<ConstraintViolation<Customer>> violationSet = validator
        .validate(customer, Default.class);

    long violationsCount = TestUtils.getViolationsCount(violationSet,
        "lastName must have more thant 2 characters", TEST_LAST_NAME_STR);
    assertEquals(1, violationsCount);
  }

  @Test
  void validateFirstNameNotBlank() {

    Customer customer = buildCustomer();
    customer.setFirstName(null);

    Set<ConstraintViolation<Customer>> violationSet = validator
        .validate(customer, Default.class);

    long violationsCount = TestUtils.getViolationsCount(violationSet,
        "firstName name cannot be blank", TEST_FIRST_NAME_STR);
    assertEquals(1, violationsCount);

    customer.setFirstName(RandomStringUtils.random(3, StringUtils.SPACE));

    violationSet = validator.validate(customer, Default.class);
    violationsCount = TestUtils.getViolationsCount(violationSet,
        "firstName name cannot be blank", TEST_FIRST_NAME_STR);

    assertEquals(1, violationsCount);
  }

  @Test
  void validateFirstNameMinSize() {

    Customer customer = buildCustomer();
    customer.setFirstName("a");

    Set<ConstraintViolation<Customer>> violationSet = validator
        .validate(customer, Default.class);

    long violationsCount = TestUtils.getViolationsCount(violationSet,
        "firstName must have more thant 2 characters", TEST_FIRST_NAME_STR);
    assertEquals(1, violationsCount);
  }

  @Test
  void validateCompanyNotBlank() {

    Customer customer = buildCustomer();
    customer.setCompany(null);

    Set<ConstraintViolation<Customer>> violationSet = validator
        .validate(customer, Default.class);

    long violationsCount = TestUtils.getViolationsCount(violationSet,
        "company name cannot be blank", TEST_COMPANY_STR);
    assertEquals(1, violationsCount);

    customer.setFirstName(RandomStringUtils.random(3, StringUtils.SPACE));

    violationSet = validator.validate(customer, Default.class);
    violationsCount = TestUtils.getViolationsCount(violationSet,
        "company name cannot be blank", TEST_COMPANY_STR);

    assertEquals(1, violationsCount);
  }

  @Test
  void validateCompanyMinSize() {

    Customer customer = buildCustomer();
    customer.setCompany("a");

    Set<ConstraintViolation<Customer>> violationSet = validator
        .validate(customer, Default.class);

    long violationsCount = TestUtils.getViolationsCount(violationSet,
        "company must have more thant 2 characters", TEST_COMPANY_STR);
    assertEquals(1, violationsCount);
  }

  @Test
  void validateAddressesList() {

    Customer customer = buildCustomer();
    Address address = buildAddress();
    address.setProvince("i");
    List<Address> addresses = new ArrayList<>();
    addresses.add(address);
    customer.setAddresses(addresses);

    Set<ConstraintViolation<Customer>> violationSet = validator
        .validate(customer, Default.class);

    long violationsCount = TestUtils.getViolationsCount(violationSet,
        "province must have more thant 2 characters", "addresses[0].province");
    assertEquals(1, violationsCount);
  }

  @Test
  void equalsContract() {

    Address a = buildAddress();
    a.setId(1l);

    CustomerGroup g = buildCustomerGroup();
    g.setId(1l);

    EqualsVerifier.forClass(Customer.class)
        .withRedefinedSuperclass()
        .withPrefabValues(Address.class, buildAddress(), a)
        .withPrefabValues(CustomerGroup.class, buildCustomerGroup(), g)
        .suppress(Warning.STRICT_INHERITANCE)
        .suppress(Warning.NONFINAL_FIELDS)
        .verify();

    Customer customer1 = buildCustomer();
    Customer customer2 = new Customer();
    customer2.setId(0l);
    customer2.setVersion(0);
    customer2.setFirstName(TEST_FIRST_NAME_STR);
    customer2.setLastName(TEST_LAST_NAME_STR);
    customer2.setCompany(TEST_COMPANY_STR);
    assertEquals(customer1, customer2);
    assertEquals(customer1.toString(), customer2.toString());
  }

  public static void assertCustomerNode(Customer customer, JsonNode node) {
    assertEquals(customer.getId(), node.get(TEST_ID_STR).asInt());
    assertFalse(node.has(TEST_VERSION_STR));
    assertEquals(customer.getLastName(), node.get(TEST_LAST_NAME_STR).asText());
    assertEquals(customer.getFirstName(), node.get(TEST_FIRST_NAME_STR).asText());
    assertEquals(customer.getCompany(), node.get(TEST_COMPANY_STR).asText());
  }

  public static void assertCustomer(Customer customer) {
    //assertEquals(0l, customer.getId());
    assertEquals(0l, customer.getVersion());
    assertEquals(TEST_LAST_NAME_STR, customer.getLastName());
    assertEquals(TEST_FIRST_NAME_STR, customer.getFirstName());
    assertEquals(TEST_COMPANY_STR, customer.getCompany());
  }

  public static Customer buildCustomer() {
    return Customer.builder()
        .id(0l)
        .version(0)
        .firstName(TEST_FIRST_NAME_STR)
        .lastName(TEST_LAST_NAME_STR)
        .company(TEST_COMPANY_STR)
        .build();
  }

  public static List<Customer> buildCustomers() {

    Customer c = buildCustomer();
    c.setId(1l);

    return Arrays.asList( Customer.builder()
        .id(0l)
        .version(0)
        .firstName(TEST_FIRST_NAME_STR)
        .lastName(TEST_LAST_NAME_STR)
        .company(TEST_COMPANY_STR)
        .build(),
        c
    );
  }
}