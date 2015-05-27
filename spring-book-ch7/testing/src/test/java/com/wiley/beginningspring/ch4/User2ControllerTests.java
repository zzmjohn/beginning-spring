package com.wiley.beginningspring.ch4;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * User: mertcaliskan
 * Date: 19/06/14
 */
public class User2ControllerTests extends BaseControllerTests {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void userNotFoundExceptionHandledSuccessfully() throws Exception {
        this.mockMvc.perform(get("/findUser").param("name", "johndoe"))
                .andExpect(status().isOk())
                .andExpect(view().name("errorUser"))
                .andExpect(model().attribute("errorMessage", "User not found with name: johndoe"));
    }
}
