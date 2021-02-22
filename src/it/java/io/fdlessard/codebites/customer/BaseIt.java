package io.fdlessard.codebites.customer;



//import ca.bnc.fm.crm.tests.FmCrmLocalStackContainer;
//import ca.bnc.fm.crm.tests.FmCrmPostgreSqlContainer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.localstack.LocalStackContainer;

//@Testcontainers
@Slf4j
@ExtendWith( {SpringExtension.class})
public abstract class BaseIt {

  @Autowired
  protected WebApplicationContext wac;

/*  @Autowired
  protected FilterChainProxy springSecurityFilterChain;*/

  protected MockMvc mockMvc;


 //@Container
  private static PostgreSQLContainer postgreSQLContainer = CustomerPostgreSqlContainer.getInstance();

  //@Container
  //public static LocalStackContainer localStackContainer = FmCrmLocalStackContainer.getInstance();

  static {
    postgreSQLContainer.start();
    //localStackContainer.start();

/*    try {
      localStackContainer.execInContainer("awslocal", "s3", "mb", "s3://1385-npr-com-appstatic");
    } catch (Exception exception) {
    }*/
  }



}
