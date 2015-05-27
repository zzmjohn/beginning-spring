package com.wiley.beginningspring.ch4;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * User: mertcaliskan
 * Date: 19/06/14
 */
public class UserControllerTests extends BaseControllerTests {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void formSubmittedSuccessfully() throws Exception {
        this.mockMvc.perform(
                post("/result")
                        .param("username", "johndoe")
                        .param("email", "john@doe.com")
                        .param("ccNumber", "5245771326014172")
                        .param("password", "TestR0ck"))
                .andExpect(status().isOk())
                .andExpect(view().name("userResult"))
                .andExpect(model().hasNoErrors())
                .andExpect(model().attribute("u", hasProperty("username", is("johndoe"))))
                .andExpect(model().attribute("u", hasProperty("email", is("john@doe.com"))))
                .andExpect(model().attribute("u", hasProperty("ccNumber", is("5245771326014172"))))
                .andExpect(model().attribute("u", hasProperty("password", is("TestR0ck"))));
    }

    @Test
    public void formSubmittedSuccessfullyButContainsValidationErrors() throws Exception {
        this.mockMvc.perform(
                post("/result")
                        .param("username", "ok"))
                .andExpect(status().isOk())
                .andExpect(view().name("userForm"))
                .andExpect(model().hasErrors());
    }
}

