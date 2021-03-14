package io.fdlessard.codebites.customer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CustomerIt extends BaseIt {

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac)
//        .addFilter(springSecurityFilterChain)
                .build();
    }

    @Test
    void getCustomerById() throws Exception {

        mockMvc.perform(get("/customers/1"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.id", is(1)));
    }

}
