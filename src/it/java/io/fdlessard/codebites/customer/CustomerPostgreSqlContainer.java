package io.fdlessard.codebites.customer;

import lombok.extern.slf4j.Slf4j;
import org.testcontainers.containers.PostgreSQLContainer;

@Slf4j
public class CustomerPostgreSqlContainer extends PostgreSQLContainer<CustomerPostgreSqlContainer> {

  private static final String IMAGE_VERSION = "postgres:12.5";
  
  private static CustomerPostgreSqlContainer container = new CustomerPostgreSqlContainer()
      .withUsername("postgres")
      .withPassword("secret")
      .withDatabaseName("postgres");

  private CustomerPostgreSqlContainer() {
    super(IMAGE_VERSION);
  }

  public static CustomerPostgreSqlContainer getInstance() {
    return container;
  }

  @Override
  public void start() {
    logger.info("STARTING POSTGRESQL CONTAINER");
    super.start();
    logger.info("DB_URL: {}", container.getJdbcUrl());
    logger.info("DB_USERNAME: {}", container.getUsername());
    logger.info("DB_PASSWORD: {}", container.getJdbcUrl());
    System.setProperty("DB_URL", container.getJdbcUrl());
  }

  @Override
  public void stop() {
    logger.info("STOPPING POSTGRESQL CONTAINER");
  }
}
